package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.memory.Method;

import static org.goldensun.Hardware.MEMORY;

/** Third/fourth rooms in Sol Sanctum */
public final class Map15Overlay_878de18 {
  private Map15Overlay_878de18() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008030)
  public static int getRooms() {
    final int r0;

    r0 = 0x20080c0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008038)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x200803c)
  public static int getTransitions() {
    final int r0;

    r0 = 0x2008120;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008044)
  public static int getActors() {
    final int r0;

    r0 = 0x2008130;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x200804c)
  public static int getEvents() {
    final int r0;

    r0 = 0x2008148;
    return r0;
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x2008054)
  public static int init() {
    int r0;
    int r1;
    int r2;
    int r3;

    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = r3 + 0x44;
    MEMORY.ref(4, r2).setu(r3);
    r3 = r3 - 0x3c;
    r2 = r1 + r3;
    r3 = 0x10;
    MEMORY.ref(4, r2).setu(r3);
    r0 = 0x814;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x8d;
      FUN_20080b8(r0);
      r0 = 0x80;
      r1 = 0x80;
      r2 = 0x80;
      r0 = r0 << 9;
      r1 = r1 << 9;
      r2 = r2 << 9;
      FUN_20080a0(r0, r1, r2);
      FUN_20080b0();
    }

    //LAB_2008090
    r0 = 0x0;
    return r0;
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x20080a0)
  public static void FUN_20080a0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x20080a8)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_808#FUN_808a2f8} */
  @Method(0x20080b0)
  public static void FUN_20080b0() {
    MEMORY.call(0x808a2f8);
  }

  /** {@link GoldenSun_808#FUN_808a5e0} */
  @Method(0x20080b8)
  public static void FUN_20080b8(final int r0) {
    MEMORY.call(0x808a5e0, r0);
  }
}
