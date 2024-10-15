package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class CopiedSegment3002400 {
  private CopiedSegment3002400() { }

  @Method(0x3002400)
  public static void FUN_3002400(final int r0) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int address3002400 = CPU.sp().value - 0x18;
    CPU.sp().value = address3002400;
    address3002400 += 0x4;
    address3002400 += 0x4;
    address3002400 += 0x4;
    MEMORY.ref(4, address3002400).setu(CPU.r8().value);
    address3002400 += 0x4;
    MEMORY.ref(4, address3002400).setu(CPU.r9().value);
    address3002400 += 0x4;
    MEMORY.ref(4, address3002400).setu(CPU.lr().value);
    address3002400 += 0x4;
    final int address3002404 = 0x300240c + 0xc4;
    r2 = MEMORY.ref(4, address3002404).getUnsigned();
    CPU.r12().value = 0x40;
    CPU.r9().value = r0;

    //LAB_3002414
    do {
      int address3002414 = r2 - 0x10;
      r2 = address3002414;
      r3 = MEMORY.ref(4, address3002414).getUnsigned();
      address3002414 += 0x4;
      r4 = MEMORY.ref(4, address3002414).getUnsigned();
      address3002414 += 0x4;
      r5 = MEMORY.ref(4, address3002414).getUnsigned();
      address3002414 += 0x4;
      r6 = MEMORY.ref(4, address3002414).getUnsigned();
      address3002414 += 0x4;

      r6 = CPU.movA(0, r6);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_3002458(r0, 0x80, r2, r3, r4, r5, r6);
      }

      r6 = CPU.movA(0, r5);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_3002458(r0, 0x80, r2, r3, r4, r5, r6);
      }

      r6 = CPU.movA(0, r4);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_3002458(r0, 0x80, r2, r3, r4, r5, r6);
      }

      r6 = CPU.movA(0, r3);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_3002458(r0, 0x80, r2, r3, r4, r5, r6);
      }

      CPU.r12().value = CPU.subA(CPU.r12().value, 0x1);
    } while(!CPU.cpsr().getZero()); // !=

    CPU.lr().value = 0x300248c;
    MEMORY.call(0x3000168, r0, 0x400, 0xc0_00c0); // memfill32

    // lr is set to this address before the bx to memfill32
    FUN_300248c();
  }

  @Method(0x3002458)
  public static void FUN_3002458(int r0, int r1, final int r2, final int r3, final int r4, final int r5, int r6) {
    int r7;

    //LAB_3002458
    do {
      int address3002458 = r6;
      r6 = MEMORY.ref(4, address3002458).getUnsigned();
      address3002458 += 0x4;
      r7 = MEMORY.ref(4, address3002458).getUnsigned();
      address3002458 += 0x4;
      CPU.r8().value = MEMORY.ref(4, address3002458).getUnsigned();
      address3002458 += 0x4;
      r6 = address3002458;
      int address300245c = r0;
      MEMORY.ref(4, address300245c).setu(r7);
      address300245c += 0x4;
      MEMORY.ref(4, address300245c).setu(CPU.r8().value);
      address300245c += 0x4;
      r0 = address300245c;
      r1 = CPU.subA(r1, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        FUN_300248c();
        return;
      }
      CPU.cmpA(r6, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        return;
      }
      int address3002470 = r6;
      r6 = MEMORY.ref(4, address3002470).getUnsigned();
      address3002470 += 0x4;
      r7 = MEMORY.ref(4, address3002470).getUnsigned();
      address3002470 += 0x4;
      CPU.r8().value = MEMORY.ref(4, address3002470).getUnsigned();
      address3002470 += 0x4;
      r6 = address3002470;
      int address3002474 = r0;
      MEMORY.ref(4, address3002474).setu(r7);
      address3002474 += 0x4;
      MEMORY.ref(4, address3002474).setu(CPU.r8().value);
      address3002474 += 0x4;
      r0 = address3002474;
      r1 = CPU.subA(r1, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        FUN_300248c();
        return;
      }
      CPU.cmpA(r6, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        return;
      }
    } while(true);
  }

  @Method(0x300248c)
  public static void FUN_300248c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    r0 = CPU.r9().value + 0x6;
    final int address3002490 = 0x3002498 + 0x40;
    r2 = MEMORY.ref(4, address3002490).getUnsigned();
    final int address3002494 = r2;
    r4 = MEMORY.ref(1, address3002494).getUnsigned();
    final int address3002498 = 0x30024a0 + 0x3c;
    r1 = MEMORY.ref(4, address3002498).getUnsigned();
    CPU.cmpA(r4, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_30024a4
      do {
        int address30024a4 = r1;
        r2 = MEMORY.ref(4, address30024a4).getUnsigned();
        address30024a4 += 0x4;
        r3 = MEMORY.ref(4, address30024a4).getUnsigned();
        address30024a4 += 0x4;
        r1 = address30024a4;
        final int address30024a8 = r0 + 0x20;
        MEMORY.ref(2, address30024a8).setu(r2);
        r0 = address30024a8;
        r2 = r2 >>> 16;
        final int address30024b0 = r0 - 0x18;
        MEMORY.ref(2, address30024b0).setu(r2);
        final int address30024b4 = r0 - 0x10;
        MEMORY.ref(2, address30024b4).setu(r3);
        r3 = r3 >>> 16;
        final int address30024bc = r0 - 0x8;
        MEMORY.ref(2, address30024bc).setu(r3);
        r4 = CPU.subA(r4, 0x1);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_30024c8
    int address30024c8 = CPU.sp().value;
    address30024c8 += 0x4;
    address30024c8 += 0x4;
    address30024c8 += 0x4;
    CPU.r8().value = MEMORY.ref(4, address30024c8).getUnsigned();
    address30024c8 += 0x4;
    CPU.r9().value = MEMORY.ref(4, address30024c8).getUnsigned();
    address30024c8 += 0x4;
    CPU.lr().value = MEMORY.ref(4, address30024c8).getUnsigned();
    address30024c8 += 0x4;
    CPU.sp().value = address30024c8;

    //TODO should this exit all the way out?
  }
}
