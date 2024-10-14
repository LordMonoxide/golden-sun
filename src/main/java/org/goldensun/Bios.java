package org.goldensun;

import org.goldensun.cpu.InstructionSet;
import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class Bios {
  private Bios() { }

  @Method(0x0000000)
  public static int SoftReset() {
    return SoftResetImpl();
  }

  @Method(0x0000008)
  public static void SupervisorCall() {
    throw new RuntimeException("Run supervisor calls directly");
  }

  @Method(0x0000018)
  public static void IRQ() {
    IrqImpl();
  }

  @Method(0x000001c)
  public static int FIQ() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0000068)
  public static int SoftResetImpl() {
    int r0;
    final int r1;
    int r2;
    final int r3;
    int r4;
    final int r5;
    final int r6;
    final int r7;
    CPU.cmpA(CPU.lr().value, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      CPU.lr().value = 0x4;
    }
    CPU.r12().value = 0x4000000;
    final int address74 = CPU.r12().value + 0x300;
    CPU.r12().value = MEMORY.ref(1, address74).getUnsigned();
    CPU.teqA(CPU.r12().value, 0x1);
    if(CPU.cpsr().getZero()) { // ==
      CPU.r12().value = CPU.cpsr().get();
    }
    if(CPU.cpsr().getZero()) { // ==
      CPU.r12().value = CPU.r12().value | 0xc0;
    }
    if(CPU.cpsr().getZero()) { // ==
      CPU.cpsr().msr(CPU.r12().value, true, false, false, true);
    }
    if(CPU.cpsr().getZero()) { // ==
      r0 = FIQ();
    }
    r0 = 0xdf;
    CPU.cpsr().msr(r0, true, false, false, true);
    r4 = 0x4000000;
    final int address98 = r4 + 0x208;
    MEMORY.ref(1, address98).setu(r4);
    initCpuModes(r4);
    r0 = 0xa8 + 0x258;
    final int addressa4 = CPU.sp().value + 0xfc;
    MEMORY.ref(4, addressa4).setu(r0);
    final int addressa8 = 0xb0 + 0x1cc;
    r0 = MEMORY.ref(4, addressa8).getUnsigned();
    CPU.lr().value = 0xb4;
    MEMORY.call(r0);
    r4 = 0x4000000;
    final int addressb8 = r4 - 0x6;
    r2 = MEMORY.ref(1, addressb8).getUnsigned();
    initCpuModes(r4);
    CPU.cmpA(r2, 0x0);
    int addressc4 = r4 - 0x34;
    r0 = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    r1 = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    r2 = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    r3 = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    r4 = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    r5 = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    r6 = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    r7 = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    CPU.r8().value = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    CPU.r9().value = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    CPU.r10().value = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    CPU.r11().value = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    CPU.r12().value = MEMORY.ref(4, addressc4).getUnsigned();
    addressc4 += 0x4;
    if(!CPU.cpsr().getZero()) { // !=
      CPU.lr().value = 0x2000000;
    }
    if(CPU.cpsr().getZero()) { // ==
      CPU.lr().value = 0x8000000;
    }
    r0 = 0x1f;
    CPU.cpsr().msr(r0, true, false, false, true);
    r0 = 0x0;
    return r0;
  }

  @Method(0x00000e0)
  public static void initCpuModes(final int r4) {
    int r0;

    r0 = 0xd3;
    CPU.cpsr().msr(r0, true, false, false, true);
    final int addresse8 = 0xf0 + 0xd0;
    CPU.sp().value = MEMORY.ref(4, addresse8).getUnsigned();
    CPU.lr().value = 0x0;
    CPU.spsr().msr(CPU.lr().value, true, false, false, true);
    r0 = 0xd2;
    CPU.cpsr().msr(r0, true, false, false, true);
    final int addressfc = 0x104 + 0xb8;
    CPU.sp().value = MEMORY.ref(4, addressfc).getUnsigned();
    CPU.lr().value = 0x0;
    CPU.spsr().msr(CPU.lr().value, true, false, false, true);
    r0 = 0x5f;
    CPU.cpsr().msr(r0, true, false, false, true);
    final int address110 = 0x118 + 0xa0;
    CPU.sp().value = MEMORY.ref(4, address110).getUnsigned();
    r0 = 0x11c + 0x1;
    MEMORY.call(InstructionSet.THUMB, r0, r4);
  }

  @Method(0x000011c)
  public static void FUN_000011c(final int r4) {
    final int r0;
    int r1;

    r0 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(4, 0x0000280).get();

    //LAB_0000120
    do {
      MEMORY.ref(4, r4 + r1).setu(r0);
      r1 = CPU.addT(r1, 0x4);
    } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
  }

  @Method(0x0000128)
  public static void IrqImpl() {
    int address128 = CPU.sp().value - 0x18;
    CPU.sp().value = address128;
    address128 += 0x4;
    address128 += 0x4;
    address128 += 0x4;
    address128 += 0x4;
    MEMORY.ref(4, address128).setu(CPU.r12().value);
    address128 += 0x4;
    MEMORY.ref(4, address128).setu(CPU.lr().value);
    CPU.lr().value = 0x138;
    final int address134 = 0x3fffffc;
    MEMORY.ref(4, address134).deref(4).call();
    int address138 = CPU.sp().value;
    address138 += 0x4;
    address138 += 0x4;
    address138 += 0x4;
    address138 += 0x4;
    CPU.r12().value = MEMORY.ref(4, address138).getUnsigned();
    address138 += 0x4;
    CPU.lr().value = MEMORY.ref(4, address138).getUnsigned();
    address138 += 0x4;
    CPU.sp().value = address138;
  }

  @Method(0x0000284)
  public static void FUN_0000284() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x000039c)
  public static int FUN_000039c(int r0) {
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r0 = CPU.negT(r0, r0);
    }

    //LAB_00003a2
    return r0;
  }

  @Method(0x00005a4)
  public static void FUN_00005a4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    r6 = CPU.movT(0, 0x8);
    r6 = CPU.lslT(r6, 24);
    r5 = CPU.movT(0, 0x9e);
    r5 = CPU.addT(r5, r6);
    r0 = CPU.subT(r5, 0x1);
    r1 = CPU.movT(0, 0x1b);
    r0 = FUN_00006ac(r0, r1);
    r4 = CPU.movT(0, 0xc);
    r4 = CPU.mulT(r4, r0);
    r3 = MEMORY.ref(1, r5).getUnsigned();
    r3 = CPU.lslT(r3, 30);
    r3 = CPU.lsrT(r3, 30);
    r2 = CPU.movT(0, 0x30);
    r2 = CPU.mulT(r2, r3);
    r4 = CPU.addT(r4, r2);
    r5 = 0x00005ec;
    r5 = CPU.addT(r5, r4);
    r4 = CPU.movT(0, 0x0);

    //LAB_00005cc
    do {
      r0 = CPU.addT(r4, 0x0);
      FUN_00006ce(r0);
      CPU.cmpT(r4, 0x3);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        CPU.cmpT(r4, 0x9);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r1 = MEMORY.ref(2, r5).getUnsigned();
          r1 = CPU.lslT(r1, 1);
          r1 = CPU.orrT(r1, r6);
          r0 = MEMORY.ref(2, r1).getUnsigned();
          r5 = CPU.addT(r5, 0x2);
        }
      }

      //LAB_00005e4
      r4 = CPU.addT(r4, 0x1);
      CPU.cmpT(r4, 0xb);
    } while(!CPU.cpsr().getZero()); // !=
  }

  @Method(0x00006ac)
  public static int FUN_00006ac(int r0, int r1) {
    int r2;
    int r3;
    final int r4;
    int r5;

    r4 = CPU.movT(0, 0x3);
    r3 = CPU.movT(0, 0x0);

    //LAB_00006b2
    do {
      r2 = MEMORY.ref(1, r0).getUnsigned();
      r3 = CPU.rorT(r3, r4);
      r5 = CPU.movT(0, 0x4);

      //LAB_00006b8
      do {
        r3 = CPU.eorT(r3, r2);
        r2 = CPU.lslT(r2, 8);
        r5 = CPU.subT(r5, 0x1);
      } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >

      r0 = CPU.addT(r0, 0x1);
      r1 = CPU.subT(r1, 0x1);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >

    r0 = CPU.addT(r3, 0x0);
    r0 = CPU.lslT(r0, 27);
    r0 = CPU.lsrT(r0, 30);
    return r0;
  }

  @Method(0x00006ce)
  public static void FUN_00006ce(int r0) {
    int r1;
    final int r2;
    int r3;
    int r4;

    r4 = CPU.movT(0, 0x14);
    r4 = CPU.mulT(r4, r0);
    r3 = CPU.movT(0, 0x8);
    r3 = CPU.lslT(r3, 24);
    r0 = CPU.addT(r3, 0x4);
    r0 = CPU.addT(r0, r4);
    r1 = MEMORY.ref(4, 0x0000ac0).get();
    r1 = CPU.addT(r1, r4);
    r2 = CPU.movT(0, 0xa);
    CpuSet(r0, r1, r2);
  }

  @Method(0x00006e8)
  public static int FUN_00006e8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0000726)
  public static void FUN_0000726() {
    int r0;
    int r2;
    final int r3;
    r3 = MEMORY.ref(4, 0x0000ac8).get();
    r2 = CPU.movT(0, 0x8);
    r0 = CPU.movT(0, 0x7e);
    r0 = CPU.negT(r0, r0);

    //LAB_000072e
    do {
      MEMORY.ref(4, r3 + r2).setu(r0);
      r2 = CPU.addT(r2, 0x10);
      CPU.cmpT(r2, 0x78);
    } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
  }

  @Method(0x0000738)
  public static void FUN_0000738(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0000768)
  public static void FUN_0000768(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x000079e)
  public static void FUN_000079e(int r0, final int r1, final int r2, final int r3) {
    int r4;
    final int r5;
    int r6;
    int r7;

    r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r5 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r7 = CPU.movT(0, 0x0);

    //LAB_00007a6
    do {
      r6 = CPU.movT(0, 0x0);

      //LAB_00007a8
      do {
        MEMORY.ref(2, r4 + r6).setu(r0);
        r0 = CPU.addT(r0, r1);
        r6 = CPU.addT(r6, 0x2);
        r6 = CPU.cmpT(r6, r2);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <

      r4 = CPU.addT(r4, r5);
      r7 = CPU.addT(r7, 0x1);
      r7 = CPU.cmpT(r7, r3);
    } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
  }

  @Method(0x00007bc)
  public static void FUN_00007bc(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0000800)
  public static void FUN_0000800(final int r0) {
    int r1;
    int r2;
    int r3;

    //LAB_0000800
    do {
      r1 = CPU.movT(0, 0x2);
      r1 = CPU.lslT(r1, 8);
      CPU.r12().value = r1;
      r3 = MEMORY.ref(4, 0x0000ad4).get();
      r2 = MEMORY.ref(2, r3).getUnsigned();
      r3 = MEMORY.ref(4, 0x0000ad4).get();
      r1 = CPU.lslT(r2, 22);
      r1 = CPU.lsrT(r1, 22);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r1, CPU.r12().value);
        if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
          break;
        }
        r2 = CPU.addT(r2, 0x2);
      } else {
        //LAB_000081c
        CPU.cmpT(r1, 0x0);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          break;
        }
        r2 = CPU.subT(r2, 0x2);
      }

      //LAB_0000822
      MEMORY.ref(2, r3).setu(r2);
      r2 = CPU.movT(0, 0x8);

      //LAB_0000826
      do {
        r2 = CPU.subT(r2, 0x1);
      } while(!CPU.cpsr().getNegative()); // positive or 0
    } while(true);

    //LAB_000082c
  }

  @Method(0x000082e)
  public static void FUN_000082e() {
    final int r0;
    final int r1;
    int r2;
    r1 = MEMORY.ref(4, 0x0000ad8).get();
    r2 = CPU.movT(0, 0x37);
    r2 = CPU.lslT(r2, 4);
    r0 = MEMORY.ref(4, 0x0000adc).get();
    FUN_0000858(r0, r1, r2);
  }

  @Method(0x0000838)
  public static void FUN_0000838() {
    final int r1 = MEMORY.ref(4, 0x0000ad8).get();
    final int r2 = CPU.movT(0, 0x24);
    final int r0 = MEMORY.ref(4, 0x0000ae0).get();
    FUN_0000858(r0, r1, r2);
  }

  @Method(0x0000840)
  public static void FUN_0000840() {
    final int r0;
    int r1;
    final int r2;
    r1 = CPU.movT(0, 0x7);
    r1 = CPU.lslT(r1, 24);
    r2 = CPU.movT(0, 0x50);
    r0 = MEMORY.ref(4, 0x0000ae4).get();
    FUN_0000858(r0, r1, r2);
  }

  @Method(0x000084a)
  public static void FUN_000084a(int r0) {
    int r1;
    final int r2;

    r1 = MEMORY.ref(4, 0x0000ae8).get();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.lslT(r0, 9);
      r1 = CPU.addT(r1, r0);
    }

    //LAB_0000854
    r2 = CPU.movT(0, 0x8);
    r0 = MEMORY.ref(4, 0x0000aec).get();
    FUN_0000858(r0, r1, r2);
  }

  @Method(0x0000858)
  public static void FUN_0000858(int r0, int r1, int r2) {
    int r3;

    r2 = CPU.addT(r2, r1);

    //LAB_000085c
    do {
      r3 = MEMORY.ref(4, 0x0000acc).get();
      r0 = CPU.cmpT(r0, r3);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        break;
      }
      r3 = CPU.movT(0, 0x4);
      r3 = CPU.lslT(r3, 12);
      r0 = CPU.cmpT(r0, r3);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        break;
      }
      r3 = MEMORY.ref(4, r0).get();
      r0 += 0x4;
      MEMORY.ref(4, r1).setu(r3);
      r1 += 0x4;
      r1 = CPU.cmpT(r1, r2);
    } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <

    //LAB_0000872
  }

  @Method(0x0000874)
  public static void FUN_0000874() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;
    int r7;

    CPU.sp().value -= 0x14;
    r1 = MEMORY.ref(4, 0x0000af0).get();
    r5 = MEMORY.ref(4, r1).get();
    r1 += 0x4;
    r7 = MEMORY.ref(4, r1).get();
    r1 += 0x4;
    r0 = CPU.sp().value + 0x8;
    MEMORY.ref(4, r0).setu(r5);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r7);
    r0 += 0x4;

    r0 = MEMORY.ref(4, 0x0000af4).get();
    r3 = MEMORY.ref(4, 0x0000af8).get();
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lsrT(r3, 7);
    if(CPU.cpsr().getZero()) { // ==
      r0 = MEMORY.ref(4, 0x0000afc).get();
    }

    //LAB_000088c
    r1 = MEMORY.ref(4, 0x0000ad8).get();
    r2 = CPU.movT(0, 0xa);
    CpuSet(r0, r1, r2);
    FUN_00005a4();
    r1 = MEMORY.ref(4, 0x0000ac0).get();
    r3 = CPU.addT(r1, 0x0);
    r3 = CPU.addT(r3, 0xae);
    r0 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r0, 0x96);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = MEMORY.ref(4, 0x0000b00).get();
      r3 = CPU.asrT(r2, 31);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
      r0 = CPU.sp().value + 0x10;
      CpuSet(r0, r1, r2);
    }

    //LAB_00008b0
    FUN_000082e();
    r0 = MEMORY.ref(4, 0x0000ad8).get();
    r1 = MEMORY.ref(4, 0x0000b04).get();
    FUN_0001010(r0, r1);
    r0 = MEMORY.ref(4, 0x0000b04).get();
    r1 = MEMORY.ref(4, 0x0000ad8).get();
    FUN_00010f8(r0, r1);
    r7 = CPU.movT(0, 0x0);

    //LAB_00008c6
    do {
      r0 = CPU.lslT(r7, 2);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
      r2 = MEMORY.ref(4, 0x0000ad8).get();
      r0 = CPU.lslT(r7, 8);
      r0 = CPU.addT(r0, r2);
      r3 = MEMORY.ref(4, 0x0000b08).get();
      r1 = CPU.lslT(r7, 10);
      r1 = CPU.addT(r1, r3);
      r2 = CPU.sp().value + 0x8;
      FUN_0000f5c(r0, r1, r2);
      r7 = CPU.addT(r7, 0x1);
      CPU.cmpT(r7, 0x8);
    } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <

    r7 = CPU.movT(0, 0xe);

    //LAB_00008e4
    do {
      r4 = CPU.movT(0, 0x3);

      //LAB_00008e6
      do {
        r3 = MEMORY.ref(4, 0x0000b08).get();
        r0 = CPU.lslT(r7, 1);
        r0 = CPU.addT(r0, r4);
        r0 = CPU.lslT(r0, 8);
        r0 = CPU.addT(r0, r3);
        r3 = MEMORY.ref(4, 0x0000b0c).get();
        r2 = MEMORY.ref(2, r3 + r7).getUnsigned();
        r3 = MEMORY.ref(4, 0x0000b10).get();
        r1 = CPU.lslT(r4, 4);
        r1 = CPU.addT(r1, r2);
        r1 = CPU.lslT(r1, 6);
        r1 = CPU.addT(r1, r3);
        r2 = CPU.movT(0, 0x80);
        CpuSet(r0, r1, r2);
        r4 = CPU.subT(r4, 0x1);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      r7 = CPU.subT(r7, 0x2);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r0 = MEMORY.ref(4, 0x0000ac0).get();
    FUN_000094a(r0);
    FUN_0000974();
    FUN_0000982();
    r2 = CPU.movT(0, 0x20);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r1 = MEMORY.ref(4, 0x0000b14).get();
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    r3 = CPU.movT(0, 0x4);
    r2 = CPU.movT(0, 0x4);
    r1 = MEMORY.ref(4, 0x0000b18).get();
    r0 = MEMORY.ref(4, 0x0000b1c).get();
    FUN_000079e(r0, r1, r2, r3);
    r1 = CPU.movT(0, 0x5);
    r1 = CPU.lslT(r1, 24);
    r0 = CPU.mvnT(0, r1);
    MEMORY.ref(2, r1).setu(r0);
    r0 = CPU.movT(0, 0x0);
    FUN_000084a(r0);
    r0 = CPU.movT(0, 0x1);
    FUN_000084a(r0);
    FUN_0000840();
    CPU.sp().value += 0x14;
  }

  @Method(0x000094a)
  public static void FUN_000094a(int r0) {
    int r1;
    int r2;
    final int r4;

    r4 = MEMORY.ref(4, 0x0000b20).get();
    MEMORY.ref(1, r4).setu(r0);
    FUN_0000838();
    r0 = MEMORY.ref(4, CPU.sp().value).get();
    r1 = MEMORY.ref(4, 0x0000b24).get();
    r2 = CPU.movT(0, 0x4e);
    CpuSet(r0, r1, r2);
    r0 = MEMORY.ref(4, 0x0000ad8).get();
    r1 = MEMORY.ref(4, 0x0000b04).get();
    FUN_0001010(r0, r1);
    r0 = MEMORY.ref(4, 0x0000b04).get();
    r2 = MEMORY.ref(4, 0x0000b28).get();
    MEMORY.ref(4, r0).setu(r2);
    r1 = MEMORY.ref(4, 0x0000ad8).get();
    FUN_0001398(r0, r1);
  }

  @Method(0x0000974)
  public static void FUN_0000974() {
    final int r0 = MEMORY.ref(4, 0x0000ad8).get();
    final int r1 = MEMORY.ref(4, 0x0000b04).get();
    final int r2 = MEMORY.ref(4, 0x0000b2c).get();
    FUN_0000f5c(r0, r1, r2);
  }

  @Method(0x0000982)
  public static void FUN_0000982() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r6 = MEMORY.ref(4, 0x0000b04).get();
    r4 = MEMORY.ref(4, 0x0000b30).get();
    r7 = CPU.movT(0, 0x2);

    //LAB_000098a
    do {
      r5 = CPU.movT(0, 0x34);

      //LAB_000098c
      do {
        r0 = MEMORY.ref(4, r6).get();
        r6 += 0x4;
        r1 = MEMORY.ref(4, r6).get();
        r6 += 0x4;
        r2 = MEMORY.ref(4, r6).get();
        r6 += 0x4;
        r3 = MEMORY.ref(4, r6).get();
        r6 += 0x4;
        MEMORY.ref(4, r4).setu(r0);
        r4 += 0x4;
        MEMORY.ref(4, r4).setu(r1);
        r4 += 0x4;
        MEMORY.ref(4, r4).setu(r2);
        r4 += 0x4;
        MEMORY.ref(4, r4).setu(r3);
        r4 += 0x4;
        r5 = CPU.subT(r5, 0x1);
      } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >

      r4 = CPU.addT(r4, 0xc0);
      r7 = CPU.subT(r7, 0x1);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >

    r7 = CPU.movT(0, 0x3);

    //LAB_000099c
    do {
      r3 = CPU.lslT(r7, 10);
      r0 = MEMORY.ref(4, 0x0000b34).get();
      r0 = CPU.addT(r0, r3);
      r1 = MEMORY.ref(4, 0x0000b38).get();
      r1 = CPU.addT(r1, r3);
      r2 = CPU.movT(0, 0x1);
      r2 = CPU.lslT(r2, 8);
      r0 = FUN_0000bc0(r0, r1, r2);
      r7 = CPU.subT(r7, 0x1);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >

    r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(r7);
    FUN_0000ab2(0x3000564, 0x800, r5);
  }

  @Method(0x00009c2)
  public static void FUN_00009c2(final int r0) {
    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0); // fill value for FUN_0000aac
    MEMORY.ref(2, 0x4000000).setu(0x80);
    if((r0 & 0x80) != 0) {
      FUN_0000aac(0, 0x4000200, 0x8, 0x85000000, 0x80, r0);
      MEMORY.ref(2, 0x40001e2).setu(~0x8);
      MEMORY.ref(1, 0x4000410).setu(~0x8);
      FUN_0000aac(0, 0x4000004, 0x8, 0x85000000, 0x80, r0);
      FUN_0000aac(0, 0x4000000, 0x10, 0x85000000, 0x80, r0);
      FUN_0000aac(0, 0x40000b0, 0x18, 0x85000000, 0x80, r0);
      MEMORY.ref(4, 0x40000d0).setu(0x18);
      MEMORY.ref(2, 0x40000d0).setu(0x100);
      MEMORY.ref(2, 0x40000e0).setu(0x100);
      MEMORY.ref(2, 0x40000d6).setu(0x100);
      MEMORY.ref(2, 0x40000e6).setu(0x100);
    }

    //LAB_0000a18
    FUN_0000aac(0, 0x4000110, 0x8, 0x85000000, 0x20, r0);
    MEMORY.ref(2, 0x4000114).setu(0x8000);
    MEMORY.ref(1, 0x4000120).setu(0x7);
    FUN_0000aac(0, 0x4000120, 0x7, 0x85000000, 0x20, r0);

    if((r0 & 0x40) != 0) {
      final int r0_0 = MEMORY.ref(4, 0x0000b44).get();
      MEMORY.ref(1, 0x4000084).setu(r0_0);
      MEMORY.ref(1, 0x4000084).setu(0x80);
      MEMORY.ref(4, 0x4000080).setu(r0_0);
      MEMORY.ref(2, 0x4000088).and(0x3ff);
      MEMORY.ref(1, 0x4000070).setu(0x70);
      FUN_0000aac(0, 0x4000090, 0x8, 0x85000000, 0x40, r0);
      MEMORY.ref(1, 0x4000050).setu(0x8);
      FUN_0000aac(0, 0x4000070, 0x8, 0x85000000, 0x40, r0);
      MEMORY.ref(1, 0x4000084).setu(0);
    }

    //LAB_0000a6a
    FUN_0000aac(0, 0x2000000, 0x10000, 0x85000000, 0x1, r0);
    FUN_0000aac(0, 0x6000000, 0x6000, 0x85000000, 0x8, r0);
    FUN_0000aac(0, 0x7000000, 0x100, 0x85000000, 0x10, r0);
    FUN_0000aac(0, 0x5000000, 0x100, 0x85000000, 0x4, r0);
    FUN_0000aac(0, 0x3000000, 0x1f80, 0x85000000, 0x2, r0);
    CPU.sp().value += 0x4;
  }

  @Method(0x0000aac)
  public static void FUN_0000aac(final int r0unused, final int r1dest, final int r2length, final int r5flags, final int r6mask, final int r7flags) {
    if((r7flags & r6mask) != 0) {
      FUN_0000ab2(r1dest, r2length, r5flags);
    }
  }

  @Method(0x0000ab2)
  public static void FUN_0000ab2(final int r1dest, final int r2length, final int r5flags) {
    final int src = CPU.sp().value;
    FUN_0000bc0(src, r1dest, r2length | r5flags);
  }

  @Method(0x0000b4c)
  public static void CpuSet(final int src, final int dest, final int lenMode) {
    int r0 = src;
    int r1 = dest;
    int r3;
    int r4;
    int r5;

    r4 = CPU.lslT(lenMode, 11);
    r4 = CPU.lsrT(r4, 9);
    FUN_0000b9c(r0, r4);
    if(!CPU.cpsr().getZero()) { // !=
      r5 = CPU.movT(0, 0x0);
      r3 = CPU.lsrT(lenMode, 27);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r5 = CPU.addT(r1, r4);
        r3 = CPU.lsrT(lenMode, 25);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          r3 = MEMORY.ref(4, r0).get();
          r0 += 0x4;

          //LAB_0000b66
          do {
            r1 = CPU.cmpT(r1, r5);
            if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
              return;
            }
            MEMORY.ref(4, r1).setu(r3);
            r1 += 0x4;
          } while(true);
        }

        //LAB_0000b6e
        do {
          r1 = CPU.cmpT(r1, r5);
          if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
            return;
          }
          r3 = MEMORY.ref(4, r0).get();
          r0 += 0x4;
          MEMORY.ref(4, r1).setu(r3);
          r1 += 0x4;
        } while(true);
      }

      //LAB_0000b78
      r4 = CPU.lsrT(r4, 1);
      r3 = CPU.lsrT(lenMode, 25);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r3 = MEMORY.ref(2, r0).getUnsigned();

        //LAB_0000b80
        do {
          r5 = CPU.cmpT(r5, r4);
          if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
            return;
          }
          MEMORY.ref(2, r1 + r5).setu(r3);
          r5 = CPU.addT(r5, 0x2);
        } while(true);
      }

      //LAB_0000b8a
      do {
        r5 = CPU.cmpT(r5, r4);
        if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
          break;
        }
        r3 = MEMORY.ref(2, r0 + r5).getUnsigned();
        MEMORY.ref(2, r1 + r5).setu(r3);
        r5 = CPU.addT(r5, 0x2);
      } while(true);
    }

    //LAB_0000b96
  }

  @Method(0x0000b9c)
  public static void FUN_0000b9c(final int r0, final int r4) {
    CPU.r12().value = r4;
    MEMORY.call(0x0000ba4, r0);
  }

  @Method(0x0000ba4)
  public static /*boolean returns as CPU flags*/ void isValidAddressRange(final int r0/*, int r1 actually stored in r12*/) {
    CPU.cmpA(CPU.r12().value, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.r12().value = CPU.r12().value & ~0xfe000000;
      CPU.r12().value = r0 + CPU.r12().value;
      CPU.tstA(r0, 0xe000000);
      CPU.setCFlag(false);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.tstA(CPU.r12().value, 0xe000000);
        CPU.setCFlag(false);
      }
    }

    //LAB_0000bbc
//    return r0;
  }

  @Method(0x0000bc0)
  public static int FUN_0000bc0(final int src, final int dst, final int lengthAndFlags) {
    final int r3 = 0x0000bc4;
    return (int)MEMORY.call(r3, src, dst, lengthAndFlags);
  }

  @Method(0x0000bc4)
  public static int FUN_0000bc4(int src, int dst, final int lengthAndFlags) {
    final int endAddress = dst + (lengthAndFlags & 0x1f_ffff) * 0x4;

    CPU.r12().value = endAddress;
    isValidAddressRange(src);
    if(!CPU.cpsr().getZero()) { // !=
      if((lengthAndFlags & 0x100_0000) != 0) { // Fill with single value
        final int fill = MEMORY.ref(4, src).getUnsigned();

        //LAB_0000c04
        while(dst < endAddress) {
          MEMORY.memfill(dst, 0x20, fill);
          dst += 0x20;
        }
      } else {
        //LAB_0000c14
        while(dst < endAddress) {
          MEMORY.memcpy(dst, src, 0x20);
          src += 0x20;
          dst += 0x20;
        }
      }
    }

    //LAB_0000c24
    return src;
  }

  @Method(0x0000f5c)
  public static void FUN_0000f5c(final int r0, final int r1, final int r2) {
    final int r3 = 0x0000f60;
    MEMORY.call(r3, r0, r1, r2);
  }

  @Method(0x0000f60)
  public static void FUN_0000f60(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    final int r6;
    int r7;
    int addressf60 = CPU.sp().value - 0x24;
    CPU.sp().value = addressf60;
    addressf60 += 0x4;
    addressf60 += 0x4;
    addressf60 += 0x4;
    addressf60 += 0x4;
    MEMORY.ref(4, addressf60).setu(CPU.r8().value);
    addressf60 += 0x4;
    MEMORY.ref(4, addressf60).setu(CPU.r9().value);
    addressf60 += 0x4;
    MEMORY.ref(4, addressf60).setu(CPU.r10().value);
    addressf60 += 0x4;
    MEMORY.ref(4, addressf60).setu(CPU.r11().value);
    addressf60 += 0x4;
    MEMORY.ref(4, addressf60).setu(CPU.lr().value);
    addressf60 += 0x4;
    CPU.sp().value = CPU.sp().value - 0x8;
    final int addressf68 = r2;
    r7 = MEMORY.ref(2, addressf68).getUnsigned();

    CPU.r12().value = CPU.movA(r0, r7);
    isValidAddressRange(r0);
    if(!CPU.cpsr().getZero()) { // !=
      final int addressf78 = r2 + 0x2;
      r6 = MEMORY.ref(1, addressf78).getUnsigned();
      CPU.r10().value = 0x8 - r6;
      CPU.lr().value = 0x0;
      final int addressf84 = r2 + 0x4;
      CPU.r11().value = MEMORY.ref(4, addressf84).getUnsigned();
      CPU.r8().value = CPU.r11().value >>> 31;
      final int addressf8c = r2 + 0x4;
      CPU.r11().value = MEMORY.ref(4, addressf8c).getUnsigned();
      CPU.r11().value = CPU.r11().value << 1;
      CPU.r11().value = CPU.r11().value >>> 1;
      final int addressf98 = CPU.sp().value + 0x4;
      MEMORY.ref(4, addressf98).setu(CPU.r11().value);
      final int addressf9c = r2 + 0x3;
      r2 = MEMORY.ref(1, addressf9c).getUnsigned();
      r3 = 0x0;

      //LAB_0000fa4
      do {
        r7 = CPU.subA(r7, 0x1);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          break;
        }
        CPU.r11().value = 0xff;
        r5 = CPU.r11().value >> CPU.r10().value;
        final int addressfb4 = r0;
        CPU.r9().value = MEMORY.ref(1, addressfb4).getUnsigned();
        r0 = r0 + 0x1;
        r4 = 0x0;

        //LAB_0000fbc
        do {
          CPU.cmpA(r4, 0x8);
          if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
            break;
          }
          CPU.r11().value = CPU.r9().value & r5;
          if(r4 != 0) {
            CPU.setCFlag((CPU.r11().value & 0x1 << r4 - 1) != 0);
          }
          CPU.r12().value = CPU.movA(r0, CPU.r11().value >>> r4);
          if(CPU.cpsr().getZero()) { // ==
            CPU.cmpA(CPU.r8().value, 0x0);
          }
          if(!CPU.cpsr().getZero()) { // !=
            final int addressfd4 = CPU.sp().value + 0x4;
            CPU.r11().value = MEMORY.ref(4, addressfd4).getUnsigned();
            CPU.r12().value = CPU.r12().value + CPU.r11().value;
          }

          //LAB_0000fdc
          CPU.lr().value = CPU.lr().value | CPU.r12().value << r3;
          r3 = r3 + r2;
          CPU.cmpA(r3, 0x20);
          if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
            final int addressfec = r1;
            MEMORY.ref(4, addressfec).setu(CPU.lr().value);
            r1 = r1 + 0x4;
            CPU.lr().value = 0x0;
            r3 = 0x0;
          }

          //LAB_0000ff8
          r5 = r5 << r6;
          r4 = r4 + r6;
        } while(true);
      } while(true);
    }

    //LAB_0001004
    CPU.sp().value = CPU.sp().value + 0x8;
    int address1008 = CPU.sp().value;
    address1008 += 0x4;
    address1008 += 0x4;
    address1008 += 0x4;
    address1008 += 0x4;
    CPU.r8().value = MEMORY.ref(4, address1008).getUnsigned();
    address1008 += 0x4;
    CPU.r9().value = MEMORY.ref(4, address1008).getUnsigned();
    address1008 += 0x4;
    CPU.r10().value = MEMORY.ref(4, address1008).getUnsigned();
    address1008 += 0x4;
    CPU.r11().value = MEMORY.ref(4, address1008).getUnsigned();
    address1008 += 0x4;
    CPU.lr().value = MEMORY.ref(4, address1008).getUnsigned();
    address1008 += 0x4;
    CPU.sp().value = address1008;
  }

  @Method(0x0001010)
  public static void FUN_0001010(final int r0, final int r1) {
    final int r3 = 0x0001014;
    MEMORY.call(r3, r0, r1);
  }

  @Method(0x0001014)
  public static void FUN_0001014(int r0, int r1) {
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    final int r7;

    int address1014 = CPU.sp().value - 0x24;
    CPU.sp().value = address1014;
    address1014 += 0x4;
    address1014 += 0x4;
    address1014 += 0x4;
    address1014 += 0x4;
    MEMORY.ref(4, address1014).setu(CPU.r8().value);
    address1014 += 0x4;
    MEMORY.ref(4, address1014).setu(CPU.r9().value);
    address1014 += 0x4;
    MEMORY.ref(4, address1014).setu(CPU.r10().value);
    address1014 += 0x4;
    MEMORY.ref(4, address1014).setu(CPU.r11().value);
    address1014 += 0x4;
    MEMORY.ref(4, address1014).setu(CPU.lr().value);
    address1014 += 0x4;
    CPU.sp().value = CPU.sp().value - 0x8;
    CPU.r12().value = CPU.movA(r0, 0x2000000);
    CPU.setCFlag(false);
    isValidAddressRange(r0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = r0 + 0x4;
      r7 = r2 + 0x1;
      final int address1030 = r0;
      CPU.r10().value = MEMORY.ref(1, address1030).getUnsigned();
      r4 = CPU.r10().value & 0xf;
      r3 = 0x0;
      CPU.lr().value = 0x0;
      CPU.r10().value = r4 & 0x7;
      CPU.r11().value = CPU.r10().value + 0x4;
      final int address1048 = CPU.sp().value + 0x4;
      MEMORY.ref(4, address1048).setu(CPU.r11().value);
      final int address104c = r0;
      CPU.r10().value = MEMORY.ref(4, address104c).getUnsigned();
      CPU.r12().value = CPU.r10().value >>> 8;
      final int address1054 = r2;
      CPU.r10().value = MEMORY.ref(1, address1054).getUnsigned();
      CPU.r10().value = CPU.r10().value + 0x1;
      r0 = r2 + (CPU.r10().value << 1);
      r2 = r7;

      //LAB_0001064
      do {
        CPU.cmpA(CPU.r12().value, 0x0);
        if(CPU.cpsr().getZero() || !CPU.cpsr().getOverflow()) { // <=
          break;
        }
        CPU.r8().value = 0x20;
        final int address1070 = r0;
        r5 = MEMORY.ref(4, address1070).getUnsigned();
        r0 = r0 + 0x4;

        //LAB_0001074
        do {
          CPU.r8().value = CPU.subA(CPU.r8().value, 0x1);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            break;
          }
          CPU.r10().value = 0x1;
          CPU.r9().value = CPU.r10().value & r5 >>> 31;
          final int address1084 = r2;
          r6 = MEMORY.ref(1, address1084).getUnsigned();
          r6 = r6 << CPU.r9().value;
          CPU.r10().value = r2 >>> 1;
          CPU.r10().value = CPU.r10().value << 1;
          final int address1094 = r2;
          CPU.r11().value = MEMORY.ref(1, address1094).getUnsigned();
          CPU.r11().value = CPU.r11().value & 0x3f;
          CPU.r11().value = CPU.r11().value + 0x1;
          CPU.r10().value = CPU.r10().value + (CPU.r11().value << 1);
          r2 = CPU.r10().value + CPU.r9().value;
          CPU.tstA(r6, 0x80);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = r3 >>> r4;
            final int address10b4 = r2;
            CPU.r10().value = MEMORY.ref(1, address10b4).getUnsigned();
            CPU.r11().value = 0x20 - r4;
            r3 = r3 | CPU.r10().value << CPU.r11().value;
            r2 = r7;
            CPU.lr().value = CPU.lr().value + 0x1;
            final int address10c8 = CPU.sp().value + 0x4;
            CPU.r11().value = MEMORY.ref(4, address10c8).getUnsigned();
            CPU.cmpA(CPU.lr().value, CPU.r11().value);
            if(CPU.cpsr().getZero()) { // ==
              final int address10d0 = r1;
              MEMORY.ref(4, address10d0).setu(r3);
              r1 = r1 + 0x4;
            }
            if(CPU.cpsr().getZero()) { // ==
              CPU.r12().value = CPU.r12().value - 0x4;
            }
            if(CPU.cpsr().getZero()) { // ==
              CPU.lr().value = 0x0;
            }
          }

          //LAB_00010dc
          CPU.cmpA(CPU.r12().value, 0x0);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()) { // >
            r5 = r5 << 1;
          }
        } while(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()); // >
      } while(true);
    }

    //LAB_00010ec
    CPU.sp().value = CPU.sp().value + 0x8;
    int address10f0 = CPU.sp().value;
    address10f0 += 0x4;
    address10f0 += 0x4;
    address10f0 += 0x4;
    address10f0 += 0x4;
    CPU.r8().value = MEMORY.ref(4, address10f0).getUnsigned();
    address10f0 += 0x4;
    CPU.r9().value = MEMORY.ref(4, address10f0).getUnsigned();
    address10f0 += 0x4;
    CPU.r10().value = MEMORY.ref(4, address10f0).getUnsigned();
    address10f0 += 0x4;
    CPU.r11().value = MEMORY.ref(4, address10f0).getUnsigned();
    address10f0 += 0x4;
    CPU.lr().value = MEMORY.ref(4, address10f0).getUnsigned();
    address10f0 += 0x4;
    CPU.sp().value = address10f0;
  }

  @Method(0x00010f8)
  public static void FUN_00010f8(final int r0, final int r1) {
    final int r3 = 0x00010fc;
    MEMORY.call(r3, r0, r1);
  }

  @Method(0x00010fc)
  public static void FUN_00010fc(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    final int address1100 = r0;
    r5 = MEMORY.ref(4, address1100).getUnsigned();
    r0 = r0 + 0x4;
    r2 = r5 >>> 8;

    CPU.r12().value = CPU.movA(r0, r2);
    isValidAddressRange(r0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_0001114
      do {
        CPU.cmpA(r2, 0x0);
        if(CPU.cpsr().getZero() || !CPU.cpsr().getOverflow()) { // <=
          break;
        }
        final int address111c = r0;
        CPU.lr().value = MEMORY.ref(1, address111c).getUnsigned();
        r0 = r0 + 0x1;
        r4 = 0x8;

        //LAB_0001124
        do {
          r4 = CPU.subA(r4, 0x1);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            break;
          }
          CPU.tstA(CPU.lr().value, 0x80);
          if(CPU.cpsr().getZero()) { // ==
            final int address1134 = r0;
            r6 = MEMORY.ref(1, address1134).getUnsigned();
            r0 = r0 + 0x1;
            final int address1138 = r1;
            MEMORY.ref(1, address1138).setu(r6);
            r1 = r1 + 0x1;
            r2 = r2 - 0x1;
          } else {
            //LAB_0001144
            final int address1144 = r0;
            r5 = MEMORY.ref(1, address1144).getUnsigned();
            r6 = 0x3;
            r3 = r6 + (r5 >> 4);
            final int address1150 = r0;
            r6 = MEMORY.ref(1, address1150).getUnsigned();
            r0 = r0 + 0x1;
            r5 = r6 & 0xf;
            CPU.r12().value = r5 << 8;
            final int address115c = r0;
            r6 = MEMORY.ref(1, address115c).getUnsigned();
            r0 = r0 + 0x1;
            r5 = r6 | CPU.r12().value;
            CPU.r12().value = r5 + 0x1;
            r2 = r2 - r3;

            //LAB_000116c
            do {
              final int address116c = r1 - CPU.r12().value;
              r5 = MEMORY.ref(1, address116c).getUnsigned();
              final int address1170 = r1;
              MEMORY.ref(1, address1170).setu(r5);
              r1 = r1 + 0x1;
              r3 = CPU.subA(r3, 0x1);
            } while(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()); // >
          }

          //LAB_000117c
          CPU.cmpA(r2, 0x0);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()) { // >
            CPU.lr().value = CPU.lr().value << 1;
          }
        } while(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()); // >
      } while(true);
    }

    //LAB_000118c
  }

  @Method(0x0001398)
  public static void FUN_0001398(int r0, int r1) {
    int r2;
    int r3;
    int r4;

    r4 = MEMORY.ref(4, r0).get();
    r0 += 0x4;
    r4 = CPU.lsrT(r4, 8);
    FUN_0000b9c(r0, r1); // flags come from this method
    if(!CPU.cpsr().getZero()) { // !=
      r2 = MEMORY.ref(2, r0).getUnsigned();
      r0 = CPU.addT(r0, 0x2);
      MEMORY.ref(2, r1).setu(r2);
      r1 = CPU.addT(r1, 0x2);

      //LAB_00013ac
      do {
        r4 = CPU.subT(r4, 0x2);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          break;
        }
        r3 = MEMORY.ref(2, r0).getUnsigned();
        r2 = CPU.addT(r3, r2);
        r0 = CPU.addT(r0, 0x2);
        MEMORY.ref(2, r1).setu(r2);
        r1 = CPU.addT(r1, 0x2);
      } while(true);
    }

    //LAB_00013bc
  }

  @Method(0x00013c4)
  public static void FUN_00013c4(int r0, int r1, int r2) {
    int r4;
    int r5;
    final int r7;

    r4 = CPU.addT(r2, 0x0);
    r5 = CPU.addT(r1, 0x0);
    r7 = CPU.addT(r0, 0x0);
    CPU.cmpT(r2, 0x1);
    if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
      CPU.cmpT(r4, 0x10);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r4 = CPU.movT(0, 0x10);
      }

      //LAB_00013d6
      r0 = CPU.addT(r7, 0x0);
      FUN_00023b0(r0);
      MEMORY.ref(4, r7 + 0x2c).setu(r5);
      r0 = MEMORY.ref(4, 0x0001424).get();
      MEMORY.ref(1, r7 + 0x8).setu(r4);
      MEMORY.ref(4, r7 + 0x4).setu(r0);
      r0 = CPU.movT(0, 0x0);

      //LAB_00013f2
      CPU.cmpT(r4, 0x0);

      //LAB_00013e8
      while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r1 = CPU.subT(r4, 0x1);
        r4 = CPU.lslT(r1, 24);
        r4 = CPU.lsrT(r4, 24);
        MEMORY.ref(1, r5).setu(r0);
        r5 = CPU.addT(r5, 0x50);

        CPU.cmpT(r4, 0x0);
      }

      r1 = MEMORY.ref(4, 0x0001428).get();
      r4 = MEMORY.ref(4, 0x000142c).get();
      r1 = MEMORY.ref(4, r1 + 0x30).get();
      r2 = MEMORY.ref(4, r1).get();
      r2 = CPU.cmpT(r2, r4);
      if(CPU.cpsr().getZero()) { // ==
        r2 = CPU.addT(r2, 0x1);
        MEMORY.ref(4, r1).setu(r2);
        r2 = MEMORY.ref(4, r1 + 0x20).get();
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(4, r7 + 0x38).setu(r2);
          r2 = MEMORY.ref(4, r1 + 0x24).get();
          MEMORY.ref(4, r7 + 0x3c).setu(r2);
          MEMORY.ref(4, r1 + 0x20).setu(r0);
        }

        //LAB_0001414
        r0 = MEMORY.ref(4, 0x0001430).get();
        MEMORY.ref(4, r1 + 0x24).setu(r7);
        MEMORY.ref(4, r1 + 0x20).setu(r0);
        MEMORY.ref(4, r1).setu(r4);
        MEMORY.ref(4, r7 + 0x34).setu(r4);
      }
    }

    //LAB_000141e
  }

  @Method(0x0001434)
  public static void FUN_0001434(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0001664)
  public static void FUN_0001664(int r0) {
    int r1;
    int r2;
    int r3;
    final int r7;

    r7 = CPU.addT(r0, 0x0);
    r1 = MEMORY.ref(4, 0x00016dc).get();
    r0 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r1 + 0x6).setu(r0);
    MEMORY.ref(2, r1 + 0x12).setu(r0);
    r0 = MEMORY.ref(4, 0x00016e0).get();
    r2 = CPU.movT(0, 0x8f);
    MEMORY.ref(2, r0 + 0x4).setu(r2);
    r2 = MEMORY.ref(4, 0x00016e4).get();
    MEMORY.ref(2, r0 + 0x2).setu(r2);
    r2 = MEMORY.ref(1, r0 + 0x9).getUnsigned();
    r2 = CPU.lslT(r2, 26);
    r2 = CPU.lsrT(r2, 26);
    r3 = CPU.movT(0, 0x40);
    r2 = CPU.orrT(r2, r3);
    r3 = CPU.movT(0, 0x35);
    r3 = CPU.lslT(r3, 4);
    MEMORY.ref(1, r0 + 0x9).setu(r2);
    r2 = CPU.addT(r7, r3);
    MEMORY.ref(4, r0 + 0x3c).setu(r2);
    r0 = MEMORY.ref(4, 0x00016e8).get();
    r3 = CPU.movT(0, 0x13);
    r3 = CPU.lslT(r3, 7);
    MEMORY.ref(4, r1).setu(r0);
    r0 = CPU.addT(r7, r3);
    MEMORY.ref(4, r1 + 0x8).setu(r0);
    r0 = MEMORY.ref(4, 0x00016ec).get();
    r2 = MEMORY.ref(4, 0x00016f4).get();
    MEMORY.ref(4, r1 + 0xc).setu(r0);
    r0 = MEMORY.ref(4, 0x00016f0).get();
    MEMORY.ref(4, r0 + 0x30).setu(r7);
    r0 = CPU.movT(0, 0x0);
    MEMORY.ref(4, CPU.sp().value).setu(r0);
    r0 = CPU.sp().value;
    r1 = CPU.addT(r7, 0x0);
    CpuSet(r0, r1, r2);
    r0 = CPU.movT(0, 0x8);
    MEMORY.ref(1, r7 + 0x6).setu(r0);
    r0 = CPU.movT(0, 0xf);
    MEMORY.ref(1, r7 + 0x7).setu(r0);
    r0 = MEMORY.ref(4, 0x00016f8).get();
    MEMORY.ref(4, r7 + 0x38).setu(r0);
    r0 = MEMORY.ref(4, 0x00016fc).get();
    MEMORY.ref(4, r7 + 0x28).setu(r0);
    MEMORY.ref(4, r7 + 0x2c).setu(r0);
    MEMORY.ref(4, r7 + 0x30).setu(r0);
    MEMORY.ref(4, r7 + 0x3c).setu(r0);
    r0 = MEMORY.ref(4, 0x0001700).get();
    MEMORY.ref(4, r7 + 0x34).setu(r0);
    r0 = CPU.movT(0, 0x1);
    r0 = CPU.lslT(r0, 18);
    FUN_000170a(r0);
    r0 = MEMORY.ref(4, 0x0001704).get();
    MEMORY.ref(4, r7).setu(r0);
  }

  @Method(0x000170a)
  public static void FUN_000170a(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x000179c)
  public static void FUN_000179c(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;
    final int r7;

    r1 = MEMORY.ref(4, 0x0001818).get();
    r5 = MEMORY.ref(4, 0x000181c).get();
    r7 = MEMORY.ref(4, r1 + 0x30).get();
    r1 = MEMORY.ref(4, r7).get();
    r1 = CPU.cmpT(r1, r5);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.addT(r1, 0x1);
      MEMORY.ref(4, r7).setu(r1);
      r1 = CPU.lslT(r0, 24);
      r1 = CPU.lsrT(r1, 24);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.lslT(r1, 25);
        r1 = CPU.lsrT(r1, 25);
        MEMORY.ref(1, r7 + 0x5).setu(r1);
      }

      //LAB_00017ba
      r1 = CPU.movT(0, 0xf);
      r1 = CPU.lslT(r1, 8);
      r1 = CPU.andT(r1, r0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.lsrT(r1, 8);
        MEMORY.ref(1, r7 + 0x6).setu(r1);
        r1 = CPU.movT(0, 0xc);
        r3 = CPU.movT(0, 0x0);
        r2 = CPU.addT(r7, 0x7);
        r2 = CPU.addT(r2, 0x49);

        //LAB_00017ce
        do {
          MEMORY.ref(1, r2).setu(r3);
          r2 = CPU.addT(r2, 0x40);
          r1 = CPU.subT(r1, 0x1);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_00017d6
      r1 = CPU.movT(0, 0xf);
      r1 = CPU.lslT(r1, 12);
      r1 = CPU.andT(r1, r0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.lsrT(r1, 12);
        MEMORY.ref(1, r7 + 0x7).setu(r1);
      }

      //LAB_00017e2
      r1 = CPU.movT(0, 0xb);
      r1 = CPU.lslT(r1, 20);
      r1 = CPU.andT(r1, r0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0x3);
        r3 = CPU.lslT(r3, 20);
        r2 = MEMORY.ref(4, 0x0001820).get();
        r1 = CPU.andT(r1, r3);
        r3 = MEMORY.ref(1, r2 + 0x9).getUnsigned();
        r1 = CPU.lsrT(r1, 14);
        r3 = CPU.lslT(r3, 26);
        r3 = CPU.lsrT(r3, 26);
        r1 = CPU.orrT(r1, r3);
        MEMORY.ref(1, r2 + 0x9).setu(r1);
      }

      //LAB_00017fe
      r4 = CPU.movT(0, 0xf);
      r4 = CPU.lslT(r4, 16);
      r4 = CPU.andT(r4, r0);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_0001878();
        r0 = CPU.addT(r4, 0x0);
        FUN_000170a(r0);
      }

      //LAB_0001810
      MEMORY.ref(4, r7).setu(r5);
    }

    //LAB_0001812
  }

  @Method(0x0001878)
  public static void FUN_0001878() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0001928)
  public static void FUN_0001928() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4 = 0;
    int r5;
    int r6;
    int r7;

    CPU.sp().value -= 0x34;
    r1 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x0);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
    r0 = CPU.movT(0, 0x10);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
    r7 = CPU.mvnT(0, r1);
    r0 = CPU.movT(0, 0xff);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    FUN_00009c2(r0);
    r0 = MEMORY.ref(4, 0x0001d2c).get();
    r5 = CPU.movT(0, 0x1);
    MEMORY.ref(1, r0).setu(r5);
    r0 = CPU.movT(0, 0x1);
    FUN_0000800(r0);
    r6 = MEMORY.ref(4, 0x0001d30).get();
    r0 = CPU.movT(0, 0x8);
    r1 = CPU.lslT(r0, 23);
    MEMORY.ref(2, r6).setu(r5);
    MEMORY.ref(2, r1 + 0x4).setu(r0);
    r0 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
    r0 = CPU.lsrT(r0, 15);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_0000284();
    }

    //LAB_0001962
    FUN_0000874();
    r0 = CPU.movT(0, 0xef);
    r0 = CPU.lslT(r0, 7);
    r1 = CPU.movT(0, 0x1);
    r1 = CPU.lslT(r1, 26);
    MEMORY.ref(2, r1 + 0xe).setu(r0);
    r0 = CPU.movT(0, 0x54);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
    r0 = CPU.movT(0, 0x76);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    r0 = CPU.movT(0, 0x15);
    r0 = CPU.lslT(r0, 10);
    MEMORY.ref(4, r1 + 0x38).setu(r0);
    r0 = CPU.movT(0, 0x3b);
    r0 = CPU.lslT(r0, 9);
    MEMORY.ref(4, r1 + 0x3c).setu(r0);
    r1 = MEMORY.ref(4, 0x0001d38).get();
    r0 = MEMORY.ref(4, 0x0001d34).get();
    MEMORY.ref(4, r1 + 0x10).setu(r0);
    FUN_0000726();
    FUN_0002d68();
    r0 = MEMORY.ref(4, 0x0001d3c).get();
    FUN_0001664(r0);
    r0 = MEMORY.ref(4, 0x0001d40).get();
    FUN_000179c(r0);
    r1 = MEMORY.ref(4, 0x0001d44).get();
    r0 = MEMORY.ref(4, 0x0001d48).get();
    r2 = CPU.movT(0, 0x6);
    FUN_00013c4(r0, r1, r2);
    r1 = MEMORY.ref(4, 0x0001d4c).get();
    r0 = MEMORY.ref(4, 0x0001d50).get();
    r2 = CPU.movT(0, 0x6);
    FUN_00013c4(r0, r1, r2);

    //LAB_0001c62
    r7 = CPU.addT(r7, 0x1);
    CPU.cmpT(r7, 0xd2);

    //LAB_00019b4
    while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r5 = CPU.movT(0, 0x7);

      //LAB_0001b0a
      r5 = CPU.subT(r5, 0x1);

      //LAB_00019b8
      while(!CPU.cpsr().getNegative()) { // positive
        r0 = CPU.movT(0, 0x6);
        r2 = CPU.subT(r0, r5);
        r0 = CPU.lslT(r2, 2);
        r0 = CPU.addT(r0, r2);
        r0 = CPU.addT(r0, 0x8);
        r0 = CPU.cmpT(r0, r7);
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r2);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r3 = MEMORY.ref(4, 0x0001d54).get();
          r1 = CPU.lslT(r5, 2);
          r2 = MEMORY.ref(4, r3 + r1).get();
          r2 = CPU.addT(r2, 0x1);
          MEMORY.ref(4, r3 + r1).setu(r2);
        }

        //LAB_00019d2
        r3 = MEMORY.ref(4, 0x0001d54).get();
        r1 = CPU.lslT(r5, 2);
        r2 = MEMORY.ref(4, r3 + r1).get();
        r3 = MEMORY.ref(4, 0x0001d58).get();
        r1 = CPU.lslT(r5, 4);
        r1 = CPU.addT(r1, r3);
        r4 = CPU.lslT(r5, 3);
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
        r6 = MEMORY.ref(4, r1 + 0x8).get();
        r3 = CPU.movT(0, 0x7);
        r3 = CPU.lslT(r3, 24);
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r4);
        r4 = CPU.addT(r4, r3);
        CPU.cmpT(r6, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r0 = CPU.cmpT(r0, r7);
          if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
            r6 = CPU.addT(r6, 0x2);
            MEMORY.ref(4, r1 + 0x8).setu(r6);
          }

          //LAB_00019fa
          r0 = CPU.lslT(r5, 16);
          r0 = CPU.asrT(r0, 16);
          r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          FUN_0000738(r0, r1);
          r0 = CPU.movT(0, 0x14);
          r0 = CPU.mulT(r0, r5);
          r1 = MEMORY.ref(4, 0x0001d5c).get();
          r1 = CPU.addT(r0, r1);
          MEMORY.ref(4, CPU.sp().value + 0x28).setu(r1);
          MEMORY.ref(4, CPU.sp().value + 0x24).setu(r1);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          FUN_0000768(r0, r1);
          r0 = CPU.lslT(r5, 5);
          r3 = MEMORY.ref(4, 0x0001d60).get();
          r2 = CPU.movT(0, 0x1);
          r1 = CPU.addT(r0, r3);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r3 = CPU.movT(0, 0x8);
          r0 = CPU.addT(r0, 0xc);
          FUN_0003730(r0, r1, r2, r3);
          r3 = CPU.movT(0, 0x60);
          r6 = CPU.cmnT(r6, r3);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r0 = MEMORY.ref(4, r4).get();
            r2 = CPU.lslT(r3, 3);
            r2 = CPU.orrT(r2, r0);
            r0 = CPU.movT(0, 0x3f);
            r0 = CPU.mvnT(r0, r0);
            r1 = CPU.addT(r0, 0x0);
            MEMORY.ref(4, r4).setu(r2);
            if(r6 >= r0 || r5 < 4) {
              //LAB_0001a44
              r3 = CPU.movT(0, 0x4b);
              r6 = CPU.cmnT(r6, r3);
              if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
                CPU.cmpT(r6, 0x0);
                if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                  r0 = MEMORY.ref(2, r4).getUnsigned();
                  r3 = CPU.movT(0, 0x1);
                  r3 = CPU.lslT(r3, 15);
                  r0 = CPU.orrT(r0, r3);
                  MEMORY.ref(2, r4).setu(r0);
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
                  r2 = MEMORY.ref(4, 0x0001d64).get();
                  r0 = CPU.addT(r0, r2);
                  r2 = MEMORY.ref(2, r4 + 0x4).getUnsigned();
                  r0 = MEMORY.ref(2, r0 + 0x4).getUnsigned();
                  r2 = CPU.lsrT(r2, 10);
                  r2 = CPU.lslT(r2, 10);
                  r0 = CPU.addT(r0, 0x4);
                  r0 = CPU.lslT(r0, 22);
                  r0 = CPU.lsrT(r0, 22);
                  r0 = CPU.orrT(r0, r2);
                  MEMORY.ref(2, r4 + 0x4).setu(r0);
                  r0 = CPU.movT(0, 0x1f);
                  r0 = CPU.mvnT(r0, r0);
                } else {
                  //LAB_0001a76
                  r3 = CPU.movT(0, 0x3);
                  r3 = CPU.lslT(r3, 8);
                  r2 = CPU.bicT(r2, r3);
                  r0 = CPU.movT(0, 0xf);
                  r0 = CPU.mvnT(r0, r0);
                  r1 = CPU.lslT(r0, 1);
                  MEMORY.ref(4, r4).setu(r2);
                }
              }
            }

            //LAB_0001a84
            r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = MEMORY.ref(4, 0x0001d68).get();
            r2 = MEMORY.ref(2, r2 + 0x8).getUnsigned();
            r0 = CPU.addT(r2, r0);
            r2 = MEMORY.ref(4, r4).get();
            r2 = CPU.andT(r2, r3);
            r0 = CPU.lslT(r0, 23);
            r0 = CPU.lsrT(r0, 23);
            r0 = CPU.lslT(r0, 16);
            r0 = CPU.orrT(r0, r2);
            MEMORY.ref(4, r4).setu(r0);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r2 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
            r1 = CPU.addT(r2, r1);
            r0 = CPU.lsrT(r0, 8);
            r0 = CPU.lslT(r0, 8);
            r1 = CPU.lslT(r1, 24);
            r1 = CPU.lsrT(r1, 24);
            r0 = CPU.orrT(r0, r1);
            MEMORY.ref(4, r4).setu(r0);
          }

          //LAB_0001aac
          r0 = CPU.negT(0, r6);
          r1 = CPU.lslT(r0, 28);
          r1 = CPU.lsrT(r1, 28);
          r1 = CPU.lslT(r1, 1);
          r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r0 = CPU.asrT(r0, 4);
          r2 = CPU.lslT(r2, 2);
          r0 = CPU.addT(r0, 0x1);
          r2 = CPU.addT(r2, 0x1);
          FUN_00007bc(r0, r1, r2);
        }

        //LAB_0001ac2
        r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r0 = CPU.subT(r2, 0x7);
        r0 = CPU.subT(r0, 0x38);
        CPU.cmpT(r0, 0x22);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = MEMORY.ref(4, 0x0001d6c).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r0 = CPU.addT(r0, r2);
          r0 = CPU.subT(r0, 0x40);
          r1 = MEMORY.ref(1, r0 + 0x1).getUnsigned();
          r0 = MEMORY.ref(4, r4).get();
          r2 = CPU.lsrT(r0, 8);
          r2 = CPU.lslT(r2, 8);
          r0 = CPU.addT(r0, r1);
          r0 = CPU.lslT(r0, 24);
          r0 = CPU.lsrT(r0, 24);
          r0 = CPU.orrT(r0, r2);
          MEMORY.ref(4, r4).setu(r0);
        }

        //LAB_0001ae6
        r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r1 = CPU.subT(r2, 0x7);
        r1 = CPU.subT(r1, 0x59);
        CPU.cmpT(r1, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = CPU.movT(0, 0x5);
          r0 = FUN_0003720(r0, r1);
          r0 = CPU.subT(r0, 0x8);
          r0 = FUN_000039c(r0);
          r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r1 = CPU.lslT(r0, 2);
          r0 = CPU.lslT(r2, 2);
          r2 = CPU.addT(r0, 0x1);
          r0 = CPU.movT(0, 0x0);
          FUN_00007bc(r0, r1, r2);
        }

        r5 = CPU.subT(r5, 0x1);
      }

      //LAB_0001b10
      r4 = CPU.movT(0, 0x7);
      r4 = CPU.lslT(r4, 24);
      if(r7 == 0x6c || r7 == 0xb4) {
        //LAB_0001b1c
        r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r1 = CPU.movT(0, 0x6);
        r0 = CPU.subT(r0, 0x38);
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
        r0 = CPU.subT(r0, 0x80);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
        r0 = CPU.movT(0, 0xa);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
        r0 = MEMORY.ref(4, 0x0001d70).get();
        r1 = MEMORY.ref(4, 0x0001d38).get();
        MEMORY.ref(4, r1 + 0x10).setu(r0);
      } else {
        //LAB_0001b38
        CPU.cmpT(r7, 0x6c);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r0 = CPU.subT(r0, 0x3);
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x1);
          } else {
            //LAB_0001b4c
            r0 = CPU.movT(0, 0x2);
          }

          //LAB_0001b4e
          r3 = CPU.movT(0, 0x3);
          r1 = MEMORY.ref(4, r4 + 0x48).get();
          r3 = CPU.lslT(r3, 8);
          r1 = CPU.bicT(r1, r3);
          r0 = CPU.lslT(r0, 30);
          r0 = CPU.lsrT(r0, 30);
          r0 = CPU.lslT(r0, 8);
          r0 = CPU.orrT(r0, r1);
          r1 = MEMORY.ref(4, 0x0001d68).get();
          r1 = CPU.andT(r1, r0);
          r3 = CPU.movT(0, 0x1);
          r3 = CPU.lslT(r3, 18);
          r0 = CPU.addT(r0, r3);
          r3 = MEMORY.ref(4, 0x0001d68).get();
          r0 = CPU.bicT(r0, r3);
          r0 = CPU.orrT(r0, r1);
          MEMORY.ref(4, r4 + 0x48).setu(r0);
          r5 = CPU.movT(0, 0x0);

          //LAB_0001b72
          do {
            r0 = CPU.lslT(r5, 3);
            r0 = CPU.addT(r0, r4);
            r1 = CPU.addT(r0, 0x7);
            r1 = CPU.addT(r1, 0x79);
            r2 = CPU.movT(0, 0x3);
            r6 = CPU.addT(r1, 0x0);
            CpuSet(r0, r1, r2);
            r0 = MEMORY.ref(2, r6).getUnsigned();
            r3 = CPU.movT(0, 0x3);
            r3 = CPU.lslT(r3, 10);
            r0 = CPU.eorT(r0, r3);
            r5 = CPU.addT(r5, 0x1);
            CPU.cmpT(r5, 0x9);
            MEMORY.ref(2, r6).setu(r0);
          } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <

          r0 = CPU.movT(0, 0x6);
          r1 = CPU.addT(r7, 0x0);
          r0 = FUN_0003720(r0, r1);
          CPU.cmpT(r1, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r1 = CPU.addT(r1, 0x1);
            r0 = CPU.subT(r0, 0x1);
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
            r0 = CPU.lslT(r0, 8);
            r0 = CPU.orrT(r0, r1);
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
            r1 = MEMORY.ref(4, 0x0001d38).get();
            MEMORY.ref(2, r1 + 0x12).setu(r0);
          }

          //LAB_0001bb2
          r0 = MEMORY.ref(4, 0x0001d74).get();
          r1 = MEMORY.ref(4, 0x0001d38).get();
          MEMORY.ref(2, r1 + 0xa).setu(r0);
          r0 = MEMORY.ref(4, 0x0001d78).get();
        } else {
          //LAB_0001bbc
          r0 = MEMORY.ref(4, 0x0001d7c).get();
        }

        //LAB_0001bbe
        r1 = CPU.movT(0, 0x1);
        r1 = CPU.lslT(r1, 26);
        MEMORY.ref(2, r1).setu(r0);
      }

      //LAB_0001bc4
      r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      r0 = CPU.lslT(r0, 8);
      r1 = CPU.movT(0, 0x1);
      r1 = CPU.lslT(r1, 26);
      MEMORY.ref(4, r1 + 0x38).setu(r0);
      r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r0 = CPU.lslT(r0, 8);
      MEMORY.ref(4, r1 + 0x3c).setu(r0);

      if(r7 >= 16) {
        FUN_0001dc4();

        if(r7 == 16) {
          r1 = MEMORY.ref(4, 0x0001d80).get();
          r0 = MEMORY.ref(4, 0x0001d48).get();
          FUN_0001434(r0, r1);
          //LAB_0001be4
        } else if(r7 == 0xa2) {
          r1 = MEMORY.ref(4, 0x0001d84).get();
          r0 = MEMORY.ref(4, 0x0001d48).get();
          FUN_0001434(r0, r1);
        }
      }

      //LAB_0001bf0
      r0 = CPU.subT(r7, 0x7);
      r0 = CPU.subT(r0, 0x3a);
      CPU.cmpT(r0, 0x4f);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r0 = MEMORY.ref(4, 0x0001d88).get();
          r3 = CPU.movT(0, 0x1);
          r0 = MEMORY.ref(4, r0 + 0x24).get();
          r0 = CPU.cmnT(r0, r3);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = MEMORY.ref(4, 0x0001d8c).get();
            r0 = MEMORY.ref(1, r0).getUnsigned();
            CPU.cmpT(r0, 0xf3);
            if(CPU.cpsr().getZero()) { // ==
              r1 = MEMORY.ref(4, 0x0001d90).get();
              r0 = MEMORY.ref(4, 0x0001d50).get();
              FUN_0001434(r0, r1);
              r0 = CPU.movT(0, 0x1);
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
            }
          }
        }
      }

      //LAB_0001c1c
      CPU.cmpT(r7, 0x38);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = MEMORY.ref(4, CPU.sp().value).get();
          CPU.cmpT(r1, 0x20);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r1 = MEMORY.ref(4, CPU.sp().value).get();
            r1 = CPU.addT(r1, 0x2);
            MEMORY.ref(4, CPU.sp().value).setu(r1);
          }

          //LAB_0001c32
          r2 = CPU.movT(0, 0x1f);
          r0 = CPU.movT(0, 0x6);
          r1 = MEMORY.ref(4, CPU.sp().value).get();
          FUN_00007bc(r0, r1, r2);
        }
      }

      //LAB_0001c3c
      r0 = FUN_0002b34();
      r1 = MEMORY.ref(4, 0x0001d30).get();
      r0 = CPU.movT(0, 0x1);
      MEMORY.ref(2, r1 + 0x8).setu(r0);
      FUN_0003728();
      CPU.cmpT(r7, 0x10);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r1 = CPU.addT(r1, 0x1);
        r0 = CPU.subT(r0, 0x1);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
        r0 = CPU.lslT(r0, 8);
        r0 = CPU.orrT(r0, r1);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
        r1 = MEMORY.ref(4, 0x0001d38).get();
        MEMORY.ref(2, r1 + 0x12).setu(r0);
      }

      r7 = CPU.addT(r7, 0x1);
      CPU.cmpT(r7, 0xd2);
    }

    //LAB_0001c6a
    r0 = MEMORY.ref(4, 0x0001d94).get();
    r0 = FUN_00006e8(r0);
    r6 = CPU.movT(0, 0x0);
    r7 = CPU.addT(r0, 0x0);
    r5 = MEMORY.ref(4, 0x0001d98).get();
    if(r0 != 0 || MEMORY.ref(4, CPU.sp().value + 0x20).get() != 0) {
      //LAB_0001c80
      r0 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r5 + 0xb).setu(r0);
      MEMORY.ref(1, r5 + 0x7).setu(r6);

      //LAB_0001c86
      do {
        r0 = FUN_0002b34();
        r0 = CPU.lslT(r0, 24);
        r0 = CPU.lsrT(r0, 24);
        MEMORY.ref(1, r5 + 0xa).setu(r0);
        if(!CPU.cpsr().getZero()) { // !=
          break;
        }
        FUN_0001dc4();
        FUN_0003728();
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r0 = MEMORY.ref(1, r5 + 0x7).getUnsigned();
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r0 = MEMORY.ref(1, r5 + 0xb).getUnsigned();
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = MEMORY.ref(4, 0x0001d8c).get();
              r0 = MEMORY.ref(1, r0).getUnsigned();
              r0 = CPU.mvnT(r0, r0);
              r3 = CPU.movT(0, 0xf3);
              r0 = CPU.andT(r0, r3);
              if(!CPU.cpsr().getZero()) { // !=
                r1 = MEMORY.ref(4, 0x0001d9c).get();
                r0 = MEMORY.ref(4, 0x0001d50).get();
                FUN_0001434(r0, r1);
                MEMORY.ref(1, r5 + 0xb).setu(r6);
              }
            } else {
              //LAB_0001cc2
              r1 = MEMORY.ref(4, CPU.sp().value).get();
              CPU.cmpT(r1, 0x0);
              if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                break;
              }
              r1 = MEMORY.ref(4, CPU.sp().value).get();
              r2 = CPU.movT(0, 0x1f);
              r1 = CPU.subT(r1, 0x1);
              MEMORY.ref(4, CPU.sp().value).setu(r1);
              r0 = CPU.movT(0, 0x6);
              FUN_00007bc(r0, r1, r2);
            }
          }
        }
      } while(true);
    }

    //LAB_0001cd8
    r1 = MEMORY.ref(4, 0x0001da0).get();
    r0 = MEMORY.ref(4, 0x0001d38).get();
    MEMORY.ref(4, r0 + 0x10).setu(r1);
    MEMORY.ref(4, r0 + 0x14).setu(r6);
    r1 = CPU.movT(0, 0x0);

    //LAB_0001ce2
    do {
      r2 = CPU.lslT(r1, 3);
      r7 = MEMORY.ref(4, r4 + r2).get(); //NOTE: r4 uninitialized
      r3 = CPU.movT(0, 0x3);
      r3 = CPU.lslT(r3, 10);
      r7 = CPU.bicT(r7, r3);
      r1 = CPU.addT(r1, 0x1);
      CPU.cmpT(r1, 0x9);
      MEMORY.ref(4, r4 + r2).setu(r7);
    } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <

    r7 = CPU.movT(0, 0x0);
    r7 = CPU.mvnT(r7, r7);
    r4 = CPU.addT(r0, 0x0);

    //LAB_0001cfc
    //LAB_0001d16
    r7 = CPU.addT(r7, 0x1);
    CPU.cmpT(r7, 0x32);
    while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      FUN_0001dc4();
      FUN_0003728();
      r0 = CPU.lsrT(r7, 1);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        CPU.cmpT(r0, 0x10);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r0 = CPU.addT(r0, 0x1);
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
          MEMORY.ref(4, r4 + 0x14).setu(r0);
        }
      }

      r7 = CPU.addT(r7, 0x1);
      CPU.cmpT(r7, 0x32);
    }

    FUN_0001878();
    r0 = MEMORY.ref(1, r5 + 0xa).getUnsigned();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.movT(0, 0xde);
    } else {
      //LAB_0001da4
      r0 = CPU.movT(0, 0xff);
    }

    //LAB_0001da6
    FUN_00009c2(r0);
    CPU.sp().value += 0x34;
  }

  @Method(0x0001dc4)
  public static void FUN_0001dc4() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x00023b0)
  public static void FUN_00023b0(int r0) {
    final int r1 = CPU.movT(0, 0x0);
    final int r2 = CPU.movT(0, 0x0);
    final int r3 = CPU.movT(0, 0x0);
    final int r4 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r0).setu(r1);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r2);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r3);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r4);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r1);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r2);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r3);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r4);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r1);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r2);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r3);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r4);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r1);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r2);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r3);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(r4);
    r0 += 0x4;
  }

  @Method(0x0002b34)
  public static int FUN_0002b34() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0002d68)
  public static void FUN_0002d68() {
    final int r3 = MEMORY.ref(4, 0x0003098).get();
    final int r1 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r3 + 0xf).setu(r1);
  }

  @Method(0x0003720)
  public static int FUN_0003720(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0003728)
  public static void FUN_0003728() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x0003730)
  public static void FUN_0003730(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }
}
