package org.goldensun.memory.segments;

import org.goldensun.MathHelper;
import org.goldensun.memory.Segment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RomSegment extends Segment {
  public static RomSegment fromFile(final int address, final int length, final Path path) {
    try {
      final byte[] data = Files.readAllBytes(path);
      return new RomSegment(address, length, data);
    } catch(final IOException e) {
      throw new RuntimeException(e);
    }
  }

  private final byte[] data;

  public RomSegment(final int address, final int length, final byte[] data) {
    super(address, length);
    this.data = new byte[length];
    System.arraycopy(data, 0, this.data, 0, Math.min(length, data.length));
  }

  public RomSegment(final int address, final int length) {
    super(address, length);
    this.data = new byte[length];
  }

  @Override
  public int get(final int offset, final int size) {
    return MathHelper.get(this.data, offset, size);
  }

  @Override
  public void set(final int offset, final int size, final int value) {
    throw new ReadOnlyMemoryException("Memory at " + Integer.toHexString(offset) + " is read only");
  }

  @Override
  public byte[] getBytes(final int offset, final int size) {
    final byte[] data = new byte[size];
    System.arraycopy(this.data, offset, data, 0, size);
    return data;
  }

  @Override
  public void getBytes(final int offset, final byte[] dest, final int dataOffset, final int dataSize) {
    System.arraycopy(this.data, offset, dest, dataOffset, dataSize);
  }

  public static class ReadOnlyMemoryException extends RuntimeException {
    public ReadOnlyMemoryException() {
      super();
    }

    public ReadOnlyMemoryException(final String message) {
      super(message);
    }

    public ReadOnlyMemoryException(final String message, final Throwable cause) {
      super(message, cause);
    }

    public ReadOnlyMemoryException(final Throwable cause) {
      super(cause);
    }

    protected ReadOnlyMemoryException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
    }
  }
}
