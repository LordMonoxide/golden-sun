package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_80a {
  private GoldenSun_80a() { }

  /** {@link GoldenSun_80a#FUN_80a17c4} */
  @Method(0x80a1038)
  public static void FUN_80a1038(final int r0) {
    MEMORY.call(0x80a17c4, r0);
  }

  @Method(0x80a17c4)
  public static void FUN_80a17c4(final int r0) {
    if(r0 != 0) {
      MEMORY.ref(1, r0 + 0x5).setu(0x1);
      MEMORY.ref(2, r0 + 0x16).and(~0x1ff).or(MEMORY.ref(2, r0 + 0x6).getUnsigned() & 0x1ff);
      MEMORY.ref(1, r0 + 0x14).setu(MEMORY.ref(2, r0 + 0x8).getUnsigned());
      MEMORY.ref(1, r0 + 0x17).and(~0x3e);
      MEMORY.ref(1, r0 + 0x15).and(~0x3);
    }

    //LAB_80a17f6
  }
}
