package org.goldensun.memory.segments;

import org.goldensun.MathHelper;
import org.goldensun.memory.Segment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class RamSegment extends Segment {
  private final byte[] data;
  private final int mask;

  public static RamSegment fromFile(final int address, final int length, final Path path) {
    try {
      final byte[] data = Files.readAllBytes(path);
      return new RamSegment(address, length, data);
    } catch(final IOException e) {
      throw new RuntimeException(e);
    }
  }

  public RamSegment(final int address, final int length) {
    this(address, length, 0xffff_ffff);
  }

  public RamSegment(final int address, final int length, final int mask) {
    super(address, length);
    this.mask = mask;
    this.data = new byte[length];
  }

  public RamSegment(final int address, final int length, final byte[] data) {
    this(address, length, 0xffff_ffff, data);
  }

  public RamSegment(final int address, final int length, final int mask, final byte[] data) {
    this(address, length, mask);
    System.arraycopy(data, 0, this.data, 0, Math.min(length, data.length));
  }

  @Override
  public boolean accepts(final int address) {
    return super.accepts(address & this.mask);
  }

  @Override
  public int get(final int offset, final int size) {
    return MathHelper.get(this.data, offset & this.mask, size);
  }

  @Override
  public void set(int offset, final int size, final int value) {
    offset &= this.mask;
    this.removeFunction(offset & 0xffff_fffe);
    MathHelper.set(this.data, offset, size, value);
  }

  @Override
  public byte[] getBytes(final int offset, final int size) {
    final byte[] data = new byte[size];
    System.arraycopy(this.data, offset & this.mask, data, 0, size);
    return data;
  }

  @Override
  public void getBytes(int offset, final byte[] dest, int dataOffset, final int dataSize) {
    offset &= this.mask;
    dataOffset &= this.mask;
    System.arraycopy(this.data, offset, dest, dataOffset, dataSize);
  }

  @Override
  public void setBytes(int offset, final byte[] data) {
    offset &= this.mask;
    this.removeFunctions(offset, offset + data.length);
    System.arraycopy(data, 0, this.data, offset, data.length);
  }

  @Override
  public void setBytes(int offset, final byte[] data, int dataOffset, final int dataLength) {
    offset &= this.mask;
    dataOffset &= this.mask;
    this.removeFunctions(offset, offset + data.length);
    System.arraycopy(data, dataOffset, this.data, offset, dataLength);
  }

  @Override
  public void memcpy(int dest, final int src, final int length) {
    dest &= this.mask;
    this.removeFunctions(dest, dest + length);
    System.arraycopy(this.data, src, this.data, dest, length);
  }

  @Override
  public void memfill(int addr, final int length, final int value) {
    addr &= this.mask;
    this.removeFunctions(addr, addr + length);
    Arrays.fill(this.data, addr, addr + length, (byte)value);
  }
}
