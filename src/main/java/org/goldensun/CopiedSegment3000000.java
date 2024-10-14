package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.FUN_8000770;
import static org.goldensun.GoldenSun.FUN_8000af0;

/** Copied by {@link GoldenSun#FUN_800300c} from 8000770 */
public final class CopiedSegment3000000 {
  private CopiedSegment3000000() { }

  @Method(0x3000000)
  public static void FUN_3000000() {
    FUN_8000770();
  }

  @Method(0x3000380)
  public static int FUN_3000380(final int r0, final int r1) {
    return FUN_8000af0(r0, r1);
  }
}
