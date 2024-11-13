package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_818 {
  private GoldenSun_818() { }

  @Method(0x8185000)
  public static int getSpriteData(final int index) {
    return (int)MEMORY.call(0x8185008, index);
  }

  @Method(0x8185008)
  public static int FUN_8185008(final int r0) {
    return 0x8185024 + (r0 & 0xfff) * 0x14;
  }
}
