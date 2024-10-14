package org.goldensun.cpu;

public class PlainRegister implements Register {
  public int value;

  @Override
  public int get() {
    return this.value;
  }

  @Override
  public void set(final int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "0x%1$x (%1$d)".formatted(this.value);
  }
}
