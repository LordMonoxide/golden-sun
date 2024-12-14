package org.goldensun.memory.types;

import org.goldensun.memory.Value;

import javax.annotation.Nullable;

public class ByteRef implements MemoryRef {
  @Nullable
  private final Value ref;

  private byte val;

  public ByteRef() {
    this.ref = null;
  }

  public ByteRef(final Value ref) {
    this.ref = ref;

    if(ref.getSize() != 1) {
      throw new IllegalArgumentException("Size of byte refs must be 1");
    }
  }

  public int get() {
    if(this.ref != null) {
      return (byte)this.ref.getUnsigned();
    }

    return this.val;
  }

  public ByteRef set(final int val) {
    if(this.ref != null) {
      this.ref.set(val);
    } else {
      this.val = (byte)val;
    }

    return this;
  }

  public int getUnsigned() {
    return this.get() & 0xff;
  }

  public ByteRef setUnsigned(final int val) {
    if(this.ref != null) {
      this.ref.setu(val);
    } else {
      this.val = (byte)val;
    }

    return this;
  }

  public ByteRef add(final int amount) {
    return this.set((byte)(this.get() + amount));
  }

  public ByteRef addUnsigned(final int amount) {
    return this.setUnsigned(this.getUnsigned() + amount);
  }

  public ByteRef sub(final int amount) {
    return this.set((byte)(this.get() - amount));
  }

  public ByteRef subUnsigned(final int amount) {
    return this.setUnsigned(this.getUnsigned() - amount);
  }

  public ByteRef incr() {
    return this.add(1);
  }

  public ByteRef decr() {
    return this.sub(1);
  }

  public ByteRef not() {
    return this.set(~this.get());
  }

  public ByteRef and(final int val) {
    return this.set(this.get() & val);
  }

  public ByteRef and(final UnsignedByteRef val) {
    return this.and(val.get());
  }

  public ByteRef or(final int val) {
    return this.set(this.get() | val);
  }

  public ByteRef or(final UnsignedByteRef val) {
    return this.or(val.get());
  }

  public ByteRef xor(final int val) {
    return this.set(this.get() ^ val);
  }

  @Override
  public int getAddress() {
    return this.ref != null ? this.ref.getAddress() : 0;
  }

  @Override
  public String toString() {
    return Integer.toHexString(this.get()) + (this.ref == null ? " (local)" : " @ " + Integer.toHexString(this.getAddress()));
  }
}
