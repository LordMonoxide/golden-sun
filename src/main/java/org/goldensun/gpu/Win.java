package org.goldensun.gpu;

public class Win {
  public static final int BG_ENABLE_MASK = 0b1;
  public static final int BG_ENABLE_SHIFT = 0;
  public static final int OBJ_ENABLE_MASK = 0b1_0000;
  public static final int OBJ_ENABLE_SHIFT = 4;
  public static final int COLOUR_SPECIAL_EFFECT_MASK = 0b10_0000;
  public static final int COLOUR_SPECIAL_EFFECT_SHIFT = 5;

  public boolean[] win0BgEnable = new boolean[4];
  public boolean win0ObjEnable;
  public boolean win0ColourSpecialEffect;

  public int pack() {
    int packed =
      (this.win0ObjEnable ? OBJ_ENABLE_MASK : 0) |
      (this.win0ColourSpecialEffect ? COLOUR_SPECIAL_EFFECT_MASK : 0)
    ;

    for(int i = 0; i < 4; i++) {
      if(this.win0BgEnable[i]) {
        packed |= BG_ENABLE_MASK << i;
      }
    }

    return packed;
  }

  public void unpack(final int val) {
    this.win0ObjEnable = (val & OBJ_ENABLE_MASK) != 0;
    this.win0ColourSpecialEffect = (val & COLOUR_SPECIAL_EFFECT_MASK) != 0;

    for(int i = 0; i < 4; i++) {
      this.win0BgEnable[i] = (val & BG_ENABLE_MASK << i) != 0;
    }
  }
}
