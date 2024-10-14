package org.goldensun.memory.types;

import org.goldensun.memory.Value;

import javax.annotation.Nullable;

public class ShortRef implements MemoryRef {
  @Nullable
  private final Value ref;

  private short val;

  public ShortRef() {
    this.ref = null;
  }

  public ShortRef(final Value ref) {
    this.ref = ref;

    if(ref.getSize() != 2) {
      throw new IllegalArgumentException("Size of short refs must be 2");
    }
  }

  public short get() {
    if(this.ref != null) {
      return (short)this.ref.getUnsigned();
    }

    return this.val;
  }

  public ShortRef set(final int val) {
    if(this.ref != null) {
      this.ref.setu(val);
    } else {
      this.val = (short)val;
    }

    return this;
  }

  public ShortRef add(final int val) {
    return this.set(this.get() + val);
  }

  public ShortRef sub(final int val) {
    return this.set(this.get() - val);
  }

  public ShortRef mul(final int val) {
    return this.set(this.get() * val);
  }

  public ShortRef div(final int val) {
    return this.set(this.get() / val);
  }

  public ShortRef mod(final int val) {
    return this.set(this.get() % val);
  }

  public ShortRef incr() {
    return this.add(1);
  }

  public ShortRef decr() {
    return this.sub(1);
  }

  public ShortRef not() {
    return this.set(~this.get());
  }

  public ShortRef and(final int val) {
    return this.set(this.get() & val);
  }

  public ShortRef or(final int val) {
    return this.set(this.get() | val);
  }

  public ShortRef xor(final int val) {
    return this.set(this.get() ^ val);
  }

  public ShortRef shl(final int bits) {
    return this.set(this.get() << bits);
  }

  public ShortRef shr(final int bits) {
    return this.set(this.get() >>> bits);
  }

  public ShortRef shra(final int bits) {
    return this.set(this.get() >> bits);
  }

  public ShortRef neg() {
    return this.set(-this.get());
  }

  @Override
  public int getAddress() {
    if(this.ref == null) {
      return 0;
    }

    return this.ref.getAddress();
  }

  @Override
  public String toString() {
    return Integer.toHexString(this.get()) + (this.ref == null ? " (local)" : " @ " + Integer.toHexString(this.getAddress()));
  }
}
