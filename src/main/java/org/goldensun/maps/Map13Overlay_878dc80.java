package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.memory.Method;

import static org.goldensun.Hardware.MEMORY;

public final class Map13Overlay_878dc80 {
  private Map13Overlay_878dc80() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008030)
  public static int getRooms() {
    final int r0;

    r0 = 0x20080c8;
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

    r0 = 0x2008110;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008044)
  public static int getActors() {
    final int r0;

    r0 = 0x200811c;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x200804c)
  public static int getEvents() {
    final int r0;

    r0 = 0x2008134;
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
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r0 = 0xa2;
    r2 = r2 + 0x44;
    r0 = r0 << 1;
    MEMORY.ref(4, r3).setu(r2);
    setFlag(r0);
    r0 = 0x814;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x8d;
      FUN_20080c0(r0);
      r0 = 0x80;
      r1 = 0x80;
      r2 = 0x80;
      r0 = r0 << 9;
      r1 = r1 << 9;
      r2 = r2 << 9;
      FUN_20080a0(r0, r1, r2);
      FUN_20080b8();
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

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x20080b0)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2f8} */
  @Method(0x20080b8)
  public static void FUN_20080b8() {
    MEMORY.call(0x808a2f8);
  }

  /** {@link GoldenSun_808#FUN_808a5e0} */
  @Method(0x20080c0)
  public static void FUN_20080c0(final int r0) {
    MEMORY.call(0x808a5e0, r0);
  }
}
