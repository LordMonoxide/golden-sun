package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;

public class TileAttributes04 implements MemoryRef {
  private final Value ref;

  public final IntRef val_00;

  public TileAttributes04(final Value ref) {
    this.ref = ref;

    this.val_00 = ref.offset(4, 0x00).cast(IntRef::new);
  }

  public int getTile() {
    return this.val_00.get() & 0xfff;
  }

  public void setTile(final int tile) {
    this.val_00.and(~0xfff).or(tile & 0xfff);
  }

  public int getLayerChange() {
    return this.val_00.get() >>> 12 & 0x3;
  }

  public int getPriority() {
    return this.val_00.get() >>> 14 & 0x3;
  }

  public int getType() {
    return this.val_00.get() >>> 16 & 0xff;
  }

  public void setType(final int type) {
    this.val_00.and(~0xff_0000).or((type & 0xff) << 16);
  }

  public int getHeight() {
    return this.val_00.get() >>> 24 & 0xff;
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
