package org.goldensun.cpu;

public enum InterruptType {
  LCD_VBLANK(0),
  LCD_HBLANK(1),
  LCD_VCOUNT_MATCH(2),
  TIMER_0_OVERFLOW(3),
  TIMER_1_OVERFLOW(4),
  TIMER_2_OVERFLOW(5),
  TIMER_3_OVERFLOW(6),
  SERIAL_COMM(7),
  DMA_0(8),
  DMA_1(9),
  DMA_2(10),
  DMA_3(11),
  KEYPAD(12),
  GAMEPAK(13),
  ;

  public final int bit;
  public final int mask;

  InterruptType(final int bit) {
    this.bit = bit;
    this.mask = 0x1 << this.bit;
  }
}
