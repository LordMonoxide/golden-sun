package org.goldensun.gpu;

public class DispStat {
  private static final int VBLANK_FLAG_MASK = 0b1;
  private static final int VBLANK_FLAG_SHIFT = 0;
  private static final int HBLANK_FLAG_MASK = 0b10;
  private static final int HBLANK_FLAG_SHIFT = 1;
  private static final int VCOUNT_FLAG_MASK = 0b100;
  private static final int VCOUNT_FLAG_SHIFT = 2;
  private static final int VBLANK_IRQ_ENABLE_MASK = 0b1000;
  private static final int VBLANK_IRQ_ENABLE_SHIFT = 3;
  private static final int HBLANK_IRQ_ENABLE_MASK = 0b1_0000;
  private static final int HBLANK_IRQ_ENABLE_SHIFT = 4;
  private static final int VCOUNT_IRQ_ENABLE_MASK = 0b10_0000;
  private static final int VCOUNT_IRQ_ENABLE_SHIFT = 5;
  private static final int VCOUNT_SETTING_MASK = 0b1111_1111_0000_0000;
  private static final int VCOUNT_SETTING_SHIFT = 8;

  public boolean vblankFlag;
  public boolean hblankFlag;
  public boolean vcountFlag;
  public boolean vblankIrqEnable;
  public boolean hblankIrqEnable;
  public boolean vcountIrqEnable;
  public int vcountSetting;

  public int pack() {
    return
      (this.vblankFlag ? VBLANK_FLAG_MASK : 0) |
      (this.hblankFlag ? HBLANK_FLAG_MASK : 0) |
      (this.vcountFlag ? VCOUNT_FLAG_MASK : 0) |
      (this.vblankIrqEnable ? VBLANK_IRQ_ENABLE_MASK : 0) |
      (this.hblankIrqEnable ? HBLANK_IRQ_ENABLE_MASK : 0) |
      (this.vcountIrqEnable ? VCOUNT_IRQ_ENABLE_MASK : 0) |
      this.vcountSetting << VCOUNT_SETTING_SHIFT & VCOUNT_SETTING_MASK
    ;
  }

  public void unpack(final int val) {
    if((val & VBLANK_FLAG_MASK) != 0 && this.vblankFlag) {
      throw new RuntimeException("Cannot set VBLANK flag");
    }

    if((val & HBLANK_FLAG_MASK) != 0 && this.hblankFlag) {
      throw new RuntimeException("Cannot set HBLANK flag");
    }

    if((val & VCOUNT_FLAG_MASK) != 0 && this.vcountFlag) {
      throw new RuntimeException("Cannot set VCOUNT flag");
    }

    this.vblankFlag = (val & VBLANK_FLAG_MASK) != 0;
    this.hblankFlag = (val & HBLANK_FLAG_MASK) != 0;
    this.vcountFlag = (val & VCOUNT_FLAG_MASK) != 0;
    this.vblankIrqEnable = (val & VBLANK_IRQ_ENABLE_MASK) != 0;
    this.hblankIrqEnable = (val & HBLANK_IRQ_ENABLE_MASK) != 0;
    this.vcountIrqEnable = (val & VCOUNT_IRQ_ENABLE_MASK) != 0;
    this.vcountSetting = (val & VCOUNT_SETTING_MASK) >>> VCOUNT_SETTING_SHIFT;
  }
}
