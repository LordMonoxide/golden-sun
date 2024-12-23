package org.goldensun.gpu;

public class ObjPixel {
  public int palette;
  public int priority;
  public ObjMode mode = ObjMode.NORMAL;

  public void set(final int palette, final int priority, final ObjMode mode) {
    this.palette = palette;
    this.priority = priority;
    this.mode = mode;
  }
}
