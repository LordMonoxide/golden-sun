package org.goldensun.gpu;

public class DispCnt {
  public static final int BG_MODE_MASK = 0b111;
  public static final int BG_MODE_SHIFT = 0;
  public static final int CGB_MODE_MASK = 0b1000;
  public static final int CGB_MODE_SHIFT = 3;
  public static final int DISPLAY_FRAME_SELECT_MASK = 0b1_0000;
  public static final int DISPLAY_FRAME_SELECT_SHIFT = 4;
  public static final int HBLANK_INTERVAL_FREE_MASK = 0b10_0000;
  public static final int HBLANK_INTERVAL_FREE_SHIFT = 5;
  public static final int OBJ_CHARACTER_VRAM_MAPPING_MASK = 0b1000_0000;
  public static final int OBJ_CHARACTER_VRAM_MAPPING_SHIFT = 7;
  public static final int FORCED_BLANK_MASK = 0b1000_0000;
  public static final int FORCED_BLANK_SHIFT = 7;
  public static final int DISPLAY_BG0_MASK = 0b1_0000_0000;
  public static final int DISPLAY_BG0_SHIFT = 8;
  public static final int DISPLAY_BG1_MASK = 0b10_0000_0000;
  public static final int DISPLAY_BG1_SHIFT = 9;
  public static final int DISPLAY_BG2_MASK = 0b100_0000_0000;
  public static final int DISPLAY_BG2_SHIFT = 10;
  public static final int DISPLAY_BG3_MASK = 0b1000_0000_0000;
  public static final int DISPLAY_BG3_SHIFT = 11;
  public static final int DISPLAY_OBJ_MASK = 0b1_0000_0000_0000;
  public static final int DISPLAY_OBJ_SHIFT = 12;
  public static final int WINDOW_0_DISPLAY_MASK = 0b10_0000_0000_0000;
  public static final int WINDOW_0_DISPLAY_SHIFT = 13;
  public static final int WINDOW_1_DISPLAY_MASK = 0b100_0000_0000_0000;
  public static final int WINDOW_1_DISPLAY_SHIFT = 14;
  public static final int OBJ_WINDOW_DISPLAY_MASK = 0b1000_0000_0000_0000;
  public static final int OBJ_WINDOW_DISPLAY_SHIFT = 15;

  public int bgMode;
  /** For bgMode 4/5 only */
  public int displayFrameSelect;
  /** Allow access to OAM during H-Blank */
  public boolean hblankIntervalFree;
  public ObjCharacterVramMapping objCharacterVramMapping = ObjCharacterVramMapping.TWO_DIMENSIONAL;
  /** Allow fast access to VRAM/palette/OAM */
  public boolean forcedBlank;
  public final boolean[] displayBg = new boolean[4];
  public boolean displayObj;
  public boolean window0Display;
  public boolean window1Display;
  public boolean objWindowDisplay;

  public int pack() {
    return
      this.bgMode << BG_MODE_SHIFT & BG_MODE_MASK |
      this.displayFrameSelect << DISPLAY_FRAME_SELECT_SHIFT & DISPLAY_FRAME_SELECT_MASK |
      (this.hblankIntervalFree ? HBLANK_INTERVAL_FREE_MASK : 0) |
      this.objCharacterVramMapping.ordinal() << OBJ_CHARACTER_VRAM_MAPPING_SHIFT & OBJ_CHARACTER_VRAM_MAPPING_MASK |
      (this.forcedBlank ? FORCED_BLANK_MASK : 0) |
      (this.displayBg[0] ? DISPLAY_BG0_MASK : 0) |
      (this.displayBg[1] ? DISPLAY_BG1_MASK : 0) |
      (this.displayBg[2] ? DISPLAY_BG2_MASK : 0) |
      (this.displayBg[3] ? DISPLAY_BG3_MASK : 0) |
      (this.displayObj ? DISPLAY_OBJ_MASK : 0) |
      (this.window0Display ? WINDOW_0_DISPLAY_MASK : 0) |
      (this.window1Display ? WINDOW_1_DISPLAY_MASK : 0) |
      (this.objWindowDisplay ? OBJ_WINDOW_DISPLAY_MASK : 0)
    ;
  }

  public void unpack(final int val) {
    this.bgMode = (val & BG_MODE_MASK) >>> BG_MODE_SHIFT;
    this.displayFrameSelect = (val & DISPLAY_FRAME_SELECT_MASK) >>> DISPLAY_FRAME_SELECT_SHIFT;
    this.hblankIntervalFree = (val & HBLANK_INTERVAL_FREE_MASK) != 0;
    this.objCharacterVramMapping = ObjCharacterVramMapping.values()[(val & OBJ_CHARACTER_VRAM_MAPPING_MASK) >>> OBJ_CHARACTER_VRAM_MAPPING_SHIFT];
    this.forcedBlank = (val & FORCED_BLANK_MASK) != 0;
    this.displayBg[0] = (val & DISPLAY_BG0_MASK) != 0;
    this.displayBg[1] = (val & DISPLAY_BG1_MASK) != 0;
    this.displayBg[2] = (val & DISPLAY_BG2_MASK) != 0;
    this.displayBg[3] = (val & DISPLAY_BG3_MASK) != 0;
    this.displayObj = (val & DISPLAY_OBJ_MASK) != 0;
    this.window0Display = (val & WINDOW_0_DISPLAY_MASK) != 0;
    this.window1Display = (val & WINDOW_1_DISPLAY_MASK) != 0;
    this.objWindowDisplay = (val & OBJ_WINDOW_DISPLAY_MASK) != 0;
  }

  public enum ObjCharacterVramMapping {
    TWO_DIMENSIONAL,
    ONE_DIMENSIONAL,
  }
}
