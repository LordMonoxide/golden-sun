package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_80b {
  private GoldenSun_80b() { }

  @Method(0x80b0020)
  public static void FUN_80b0020(final int r0) {
    MEMORY.call(r0);
  }

  @Method(0x80b0028)
  public static void FUN_80b0028(final int r0) {
    MEMORY.call(0x80b0958, r0);
  }

  @Method(0x80b0030)
  public static void FUN_80b0030(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x80b09fc, r0, r1, r2, r3);
  }

  @Method(0x80b0038)
  public static void FUN_80b0038(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80b0a20, r0, r1, r2);
  }

  @Method(0x80b0a20)
  public static void FUN_80b0a20(final int r0, int r1, int r2) {
    int r3;
    int r4;
    final int r5;
    final int r6;

    r5 = MEMORY.ref(4, r0).get();
    r6 = MEMORY.ref(4, 0x80b0a54).get();
    r3 = CPU.movT(0, 0x1);
    r4 = MEMORY.ref(4, 0x80b0a58).get();
    MEMORY.ref(1, r0 + 0xd).setu(r3);
    r3 = MEMORY.ref(4, 0x80b0a5c).get();
    MEMORY.ref(2, r5 + 0x6).setu(r1);
    MEMORY.ref(2, r0 + 0x8).setu(r1);
    MEMORY.ref(2, r0 + 0x4).setu(r1);
    r1 = CPU.andT(r1, r6);
    r1 = CPU.andT(r1, r3);
    MEMORY.ref(1, r0 + 0xc).setu(r4);
    r3 = MEMORY.ref(4, 0x80b0a60).get();
    r4 = MEMORY.ref(2, r5 + 0x16).getUnsigned();
    r3 = CPU.andT(r3, r4);
    r3 = CPU.orrT(r3, r1);
    MEMORY.ref(2, r5 + 0x16).setu(r3);
    r3 = MEMORY.ref(4, r0).get();
    MEMORY.ref(2, r0 + 0xa).setu(r2);
    MEMORY.ref(2, r0 + 0x6).setu(r2);
    MEMORY.ref(2, r3 + 0x8).setu(r2);
    r2 = CPU.andT(r2, r6);
    MEMORY.ref(1, r3 + 0x14).setu(r2);
  }

  @Method(0x80b50a0)
  public static int FUN_80b50a0(final int r0) {
    throw new RuntimeException("Not implemented");
  }
}
