package org.goldensun.memory.segments;

import org.goldensun.memory.Segment;

public class MirroredSegment extends Segment {
  private final Segment mirror;

  public MirroredSegment(final Segment mirror, final int address) {
    super(address, mirror.getLength());
    this.mirror = mirror;
  }

  @Override
  public int get(final int offset, final int size) {
    return this.mirror.get(offset, size);
  }

  @Override
  public void set(final int offset, final int size, final int value) {
    this.mirror.set(offset, size, value);
  }

  @Override
  public byte[] getBytes(final int offset, final int size) {
    return this.mirror.getBytes(offset, size);
  }

  @Override
  public void getBytes(final int offset, final byte[] dest, final int dataOffset, final int dataSize) {
    this.mirror.getBytes(offset, dest, dataOffset, dataSize);
  }

  @Override
  public void setBytes(final int offset, final byte[] data) {
    this.mirror.setBytes(offset, data);
  }

  @Override
  public void setBytes(final int offset, final byte[] data, final int dataOffset, final int dataLength) {
    this.mirror.setBytes(offset, data, dataOffset, dataLength);
  }

  @Override
  public void memcpy(final int dest, final int src, final int length) {
    this.mirror.memcpy(dest, src, length);
  }

  @Override
  public void memfill(final int addr, final int length, final int value) {
    this.mirror.memfill(addr, length, value);
  }
}
