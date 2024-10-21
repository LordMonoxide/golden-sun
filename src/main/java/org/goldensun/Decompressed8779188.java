package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.MEMORY;

public final class Decompressed8779188 {
  private Decompressed8779188() { }

  @Method(0x2008030)
  public static int FUN_2008030() {
    return MEMORY.ref(4, 0x2008034).get();
  }

  @Method(0x2008044)
  public static int FUN_2008044() {
    return MEMORY.ref(4, 0x2008048).get();
  }

  @Method(0x200804c)
  public static int FUN_200804c() {
    return MEMORY.ref(4, 0x2008050).get();
  }
}
