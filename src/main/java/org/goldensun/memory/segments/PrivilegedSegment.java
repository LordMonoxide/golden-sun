package org.goldensun.memory.segments;

import org.goldensun.memory.MethodBinding;
import org.goldensun.memory.Segment;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

public class PrivilegedSegment extends Segment {
  private final Segment segment;
  private final PrivilegeGate gate;
  private final boolean readable;

  public PrivilegedSegment(final Segment segment, final PrivilegeGate gate, final boolean readable) {
    super(segment.getAddress(), segment.getLength());
    this.segment = segment;
    this.gate = gate;
    this.readable = readable;
  }

  @Override
  public int get(final int offset, final int size) {
    if(!this.readable) {
      this.gate.test(this.getAddress() + offset);
    }

    return this.segment.get(offset, size);
  }

  @Override
  public byte[] getBytes(final int offset, final int size) {
    if(!this.readable) {
      this.gate.test(this.getAddress() + offset);
    }

    return this.segment.getBytes(offset, size);
  }

  @Override
  public void getBytes(final int offset, final byte[] dest, final int dataOffset, final int dataSize) {
    if(!this.readable) {
      this.gate.test(this.getAddress() + offset);
    }

    this.segment.getBytes(offset, dest, dataOffset, dataSize);
  }

  @Override
  public void set(final int offset, final int size, final int value) {
    this.gate.test(this.getAddress() + offset);
    this.segment.set(offset, size, value);
  }

  @Override
  public void setBytes(final int offset, final byte[] data) {
    this.gate.test(this.getAddress() + offset);
    this.segment.setBytes(offset, data);
  }

  @Override
  public void setBytes(final int offset, final byte[] data, final int dataOffset, final int dataLength) {
    this.gate.test(this.getAddress() + offset);
    this.segment.setBytes(offset, data, dataOffset, dataLength);
  }

  @Override
  public void memcpy(final int dest, final int src, final int length) {
    this.gate.test(this.getAddress() + dest);
    this.segment.memcpy(dest, src, length);
  }

  @Override
  protected void setFunction(final int offset, final Method function, @Nullable final Object instance, final boolean ignoreExtraParams) {
    this.gate.test(this.getAddress() + offset);
    super.setFunction(offset, function, instance, ignoreExtraParams);
  }

  @Override
  protected MethodBinding getFunction(final int offset) {
    if(!this.readable) {
      this.gate.test(this.getAddress() + offset);
    }

    return super.getFunction(offset);
  }

  @Override
  protected boolean isFunction(final int offset) {
    if(!this.readable) {
      this.gate.test(this.getAddress() + offset);
    }

    return super.isFunction(offset);
  }
}
