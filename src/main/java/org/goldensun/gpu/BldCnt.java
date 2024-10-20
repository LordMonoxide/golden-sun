package org.goldensun.gpu;

public class BldCnt {
  private static final int BG0_1ST_TARGET_PIXEL_MASK = 0b1;
  private static final int BG0_1ST_TARGET_PIXEL_SHIFT = 0;
  private static final int BG1_1ST_TARGET_PIXEL_MASK = 0b10;
  private static final int BG1_1ST_TARGET_PIXEL_SHIFT = 1;
  private static final int BG2_1ST_TARGET_PIXEL_MASK = 0b100;
  private static final int BG2_1ST_TARGET_PIXEL_SHIFT = 2;
  private static final int BG3_1ST_TARGET_PIXEL_MASK = 0b1000;
  private static final int BG3_1ST_TARGET_PIXEL_SHIFT = 3;
  private static final int OBJ_1ST_TARGET_PIXEL_MASK = 0b1_0000;
  private static final int OBJ_1ST_TARGET_PIXEL_SHIFT = 4;
  private static final int BD_1ST_TARGET_PIXEL_MASK = 0b10_0000;
  private static final int BD_1ST_TARGET_PIXEL_SHIFT = 5;
  private static final int BLENDING_MODE_MASK = 0b1100_0000;
  private static final int BLENDING_MODE_SHIFT = 6;
  private static final int BG0_2ND_TARGET_PIXEL_MASK = 0b1_0000_0000;
  private static final int BG0_2ND_TARGET_PIXEL_SHIFT = 8;
  private static final int BG1_2ND_TARGET_PIXEL_MASK = 0b10_0000_0000;
  private static final int BG1_2ND_TARGET_PIXEL_SHIFT = 9;
  private static final int BG2_2ND_TARGET_PIXEL_MASK = 0b100_0000_0000;
  private static final int BG2_2ND_TARGET_PIXEL_SHIFT = 10;
  private static final int BG3_2ND_TARGET_PIXEL_MASK = 0b1000_0000_0000;
  private static final int BG3_2ND_TARGET_PIXEL_SHIFT = 11;
  private static final int OBJ_2ND_TARGET_PIXEL_MASK = 0b1_0000_0000_0000;
  private static final int OBJ_2ND_TARGET_PIXEL_SHIFT = 12;
  private static final int BD_2ND_TARGET_PIXEL_MASK = 0b10_0000_0000_0000;
  private static final int BD_2ND_TARGET_PIXEL_SHIFT = 13;

  public boolean bg0FirstTargetPixel;
  public boolean bg1FirstTargetPixel;
  public boolean bg2FirstTargetPixel;
  public boolean bg3FirstTargetPixel;
  public boolean objFirstTargetPixel;
  public boolean bdFirstTargetPixel;
  public BlendingMode blendingMode = BlendingMode.NONE;
  public boolean bg0SecondTargetPixel;
  public boolean bg1SecondTargetPixel;
  public boolean bg2SecondTargetPixel;
  public boolean bg3SecondTargetPixel;
  public boolean objSecondTargetPixel;
  public boolean bdSecondTargetPixel;

  public int pack() {
    return
      (this.bg0FirstTargetPixel ? BG0_1ST_TARGET_PIXEL_MASK : 0) |
      (this.bg1FirstTargetPixel ? BG1_1ST_TARGET_PIXEL_MASK : 0) |
      (this.bg2FirstTargetPixel ? BG2_1ST_TARGET_PIXEL_MASK : 0) |
      (this.bg3FirstTargetPixel ? BG3_1ST_TARGET_PIXEL_MASK : 0) |
      (this.objFirstTargetPixel ? OBJ_1ST_TARGET_PIXEL_MASK : 0) |
      (this.bdFirstTargetPixel ? BD_1ST_TARGET_PIXEL_MASK : 0) |
      this.blendingMode.ordinal() << BLENDING_MODE_SHIFT & BLENDING_MODE_MASK |
      (this.bg0SecondTargetPixel ? BG0_2ND_TARGET_PIXEL_MASK : 0) |
      (this.bg1SecondTargetPixel ? BG1_2ND_TARGET_PIXEL_MASK : 0) |
      (this.bg2SecondTargetPixel ? BG2_2ND_TARGET_PIXEL_MASK : 0) |
      (this.bg3SecondTargetPixel ? BG3_2ND_TARGET_PIXEL_MASK : 0) |
      (this.objSecondTargetPixel ? OBJ_2ND_TARGET_PIXEL_MASK : 0) |
      (this.bdSecondTargetPixel ? BD_2ND_TARGET_PIXEL_MASK : 0)
    ;
  }

  public void unpack(final int val) {
    this.bg0FirstTargetPixel = (val & BG0_1ST_TARGET_PIXEL_MASK) != 0;
    this.bg1FirstTargetPixel = (val & BG1_1ST_TARGET_PIXEL_MASK) != 0;
    this.bg2FirstTargetPixel = (val & BG2_1ST_TARGET_PIXEL_MASK) != 0;
    this.bg3FirstTargetPixel = (val & BG3_1ST_TARGET_PIXEL_MASK) != 0;
    this.objFirstTargetPixel = (val & OBJ_1ST_TARGET_PIXEL_MASK) != 0;
    this.bdFirstTargetPixel = (val & BD_1ST_TARGET_PIXEL_MASK) != 0;
    this.blendingMode = BlendingMode.values()[(val & BLENDING_MODE_MASK) >>> BLENDING_MODE_SHIFT];
    this.bg0SecondTargetPixel = (val & BG0_2ND_TARGET_PIXEL_MASK) != 0;
    this.bg1SecondTargetPixel = (val & BG1_2ND_TARGET_PIXEL_MASK) != 0;
    this.bg2SecondTargetPixel = (val & BG2_2ND_TARGET_PIXEL_MASK) != 0;
    this.bg3SecondTargetPixel = (val & BG3_2ND_TARGET_PIXEL_MASK) != 0;
    this.objSecondTargetPixel = (val & OBJ_2ND_TARGET_PIXEL_MASK) != 0;
    this.bdSecondTargetPixel = (val & BD_2ND_TARGET_PIXEL_MASK) != 0;
  }

  public enum BlendingMode {
    NONE,
    ALPHA,
    ADDITIVE,
    SUBTRACTIVE,
  }
}
