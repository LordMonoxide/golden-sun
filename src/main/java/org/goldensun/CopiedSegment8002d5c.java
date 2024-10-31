package org.goldensun;

import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#FUN_8002fb0} from 8002d5c */
public final class CopiedSegment8002d5c {
  private CopiedSegment8002d5c() { }

  /** This seems to rewrite function pointers in decompressed THUMB code */
  public static void FUN_8002d5c(int r0, int r1) {
    r1 = r1 + r1;
    final int r2 = r0 + r1;
    r0 = r0 + 0x2;
    final int r6 = r0;

    //LAB_300201c
    while(r0 < r2) {
      int r12 = MEMORY.ref(2, r0).getUnsigned();
      r0 = r0 + 0x2;
      if(r12 >>> 11 == 0x1f) {
        int r3 = MEMORY.ref(2, r0 - 0x4).getUnsigned();
        if(r3 >>> 11 == 0x1e) {
          r12 = r12 & ~0xf800 | (r3 & ~0xf800) << 11;
          r12 = r12 << 1;
          r12 = r12 - (r0 - r6);
          r3 = r12 >>> 12 & ~0xf800 | 0xf000;
          r12 = r12 >>> 1;
          r12 = r12 | 0xf800;
          MEMORY.ref(2, r0 - 0x4).setu(r3);
          MEMORY.ref(2, r0 - 0x2).setu(r12);
        }
      }
    }

    //LAB_3002074
  }
}
