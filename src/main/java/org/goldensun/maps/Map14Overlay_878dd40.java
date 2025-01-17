package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.memory.Method;
import org.goldensun.types.Structccc;

import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.Hardware.MEMORY;

public final class Map14Overlay_878dd40 {
  private Map14Overlay_878dd40() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008030)
  public static int getRooms() {
    return 0x20080c0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008038)
  public static int getLadders() {
    return 0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x200803c)
  public static int getTransitions() {
    return 0x2008120;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008044)
  public static int getActors() {
    return 0x2008130;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x200804c)
  public static int getEvents() {
    return 0x2008148;
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x2008054)
  public static int init() {
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x204);
    r1._1c8.set(16);

    if(readFlag(0x814) != 0) {
      FUN_20080b8(0x8d);
      FUN_20080a0(0x10000, 0x10000, 0x10000);
      FUN_20080b0();
    }

    //LAB_2008090
    return 0;
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
