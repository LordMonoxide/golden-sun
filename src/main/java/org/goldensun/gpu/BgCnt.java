package org.goldensun.gpu;

public class BgCnt {
  private static final int PRIORITY_MASK = 0b11;
  private static final int PRIORITY_SHIFT = 0;
  private static final int CHARACTER_BASE_BLOCK_MASK = 0b1100;
  private static final int CHARACTER_BASE_BLOCK_SHIFT = 2;
  private static final int MOSAIC_MASK = 0b100_0000;
  private static final int MOSAIC_SHIFT = 6;
  private static final int PALETTES_MASK = 0b1000_0000;
  private static final int PALETTES_SHIFT = 7;
  private static final int SCREEN_BASE_BLOCK_MASK = 0b1_1111_0000_0000;
  private static final int SCREEN_BASE_BLOCK_SHIFT = 8;
  private static final int SCREEN_SIZE_X_MASK = 0b100_0000_0000_0000;
  private static final int SCREEN_SIZE_X_SHIFT = 14;
  private static final int SCREEN_SIZE_Y_MASK = 0b1000_0000_0000_0000;
  private static final int SCREEN_SIZE_Y_SHIFT = 15;

  public int priority;
  /** Tile address */
  public int characterBaseBlock;
  public boolean mosaic;
  public ColoursPalettes coloursPalettes = ColoursPalettes._16_16;
  /** Map address */
  public int screenBaseBlock;
  public int screenSizeX;
  public int screenSizeY;

  public int pack() {
    return
      this.priority << PRIORITY_SHIFT & PRIORITY_MASK |
      this.characterBaseBlock / 0x4000 << CHARACTER_BASE_BLOCK_SHIFT & CHARACTER_BASE_BLOCK_MASK |
      (this.mosaic ? MOSAIC_MASK : 0) |
      this.coloursPalettes.ordinal() << PALETTES_SHIFT & PALETTES_MASK |
      this.screenBaseBlock / 0x800 << SCREEN_BASE_BLOCK_SHIFT & SCREEN_BASE_BLOCK_MASK |
      this.screenSizeX / 256 - 1 << SCREEN_SIZE_X_SHIFT & SCREEN_SIZE_X_MASK |
      this.screenSizeY / 256 - 1 << SCREEN_SIZE_Y_SHIFT & SCREEN_SIZE_Y_MASK
    ;
  }

  public void unpack(final int val) {
    this.priority = (val & PRIORITY_MASK) >>> PRIORITY_SHIFT;
    this.characterBaseBlock = ((val & CHARACTER_BASE_BLOCK_MASK) >>> CHARACTER_BASE_BLOCK_SHIFT) * 0x4000;
    this.mosaic = (val & MOSAIC_MASK) != 0;
    this.coloursPalettes = ColoursPalettes.values()[(val & PALETTES_MASK) >>> PALETTES_SHIFT];
    this.screenBaseBlock = ((val & SCREEN_BASE_BLOCK_MASK) >>> SCREEN_BASE_BLOCK_SHIFT) * 0x800;
    this.screenSizeX = (((val & SCREEN_SIZE_X_MASK) >>> SCREEN_SIZE_X_SHIFT) + 1) * 256;
    this.screenSizeY = (((val & SCREEN_SIZE_Y_MASK) >>> SCREEN_SIZE_Y_SHIFT) + 1) * 256;
  }

  public enum ColoursPalettes {
    /** 16 colours, 16 palettes */
    _16_16,
    /** 256 colours, 1 palette */
    _256_1,
  }
}
