package org.goldensun.cpu;

public enum CpuMode {
  USER(0b10000),
  FIQ(0b10001),
  IRQ(0b10010),
  SUPERVISOR(0b10011),
  ABORT(0b10111),
  UNDEFINED(0b11011),
  SYSTEM(0b11111),
  ;

  public final int bits;

  CpuMode(final int bits) {
    this.bits = bits;
  }

  public static CpuMode fromBits(final int bits) {
    for(final CpuMode mode : values()) {
      if(mode.bits == bits) {
        return mode;
      }
    }

    return USER;
  }
}
