package org.goldensun.memory.types;

import org.goldensun.memory.Value;

import javax.annotation.Nullable;

public class IntRef implements MemoryRef {
  @Nullable
  private final Value ref;

  private int val;

  public IntRef() {
    this.ref = null;
  }

  public IntRef(final Value ref) {
    this.ref = ref;

    if(ref.getSize() != 4) {
      throw new IllegalArgumentException("Size of int refs must be 4");
    }
  }

  public int get() {
    if(this.ref != null) {
      return (int)this.ref.getUnsigned();
    }

    return this.val;
  }

  public IntRef set(final int val) {
    if(this.ref != null) {
      this.ref.setu(val);
      return this;
    }

    this.val = val;
    return this;
  }

  public IntRef add(final int amount) {
    return this.set(this.get() + amount);
  }

  public IntRef sub(final int amount) {
    return this.set(this.get() - amount);
  }

  public IntRef mul(final int amount) {
    return this.set(this.get() * amount);
  }

  public IntRef div(final int amount) {
    return this.set(this.get() / amount);
  }

  public IntRef mod(final int amount) {
    return this.set(this.get() % amount);
  }

  public IntRef incr() {
    return this.add(1);
  }

  public IntRef decr() {
    return this.sub(1);
  }

  public IntRef not() {
    return this.set(~this.get());
  }

  public IntRef neg() {
    return this.set(-this.get());
  }

  public IntRef and(final int val) {
    return this.set(this.get() & val);
  }

  public IntRef or(final int val) {
    return this.set(this.get() | val);
  }

  public IntRef xor(final int val) {
    return this.set(this.get() ^ val);
  }

  public IntRef shl(final int bits) {
    return this.set(this.get() << bits);
  }

  public IntRef shr(final int bits) {
    return this.set(this.get() >>> bits);
  }

  public IntRef shra(final int bits) {
    return this.set(this.get() >> bits);
  }

  public IntRef abs() {
    if(this.ref != null) {
      this.ref.abs();
    } else {
      this.val = Math.abs(this.val);
    }

    return this;
  }

  @Override
  public int getAddress() {
    if(this.ref == null) {
      throw new IllegalStateException("Can't get address of non-memulated variable");
    }

    return this.ref.getAddress();
  }

  @Override
  public String toString() {
    return Integer.toHexString(this.get()) + (this.ref == null ? " (local)" : " @ " + Integer.toHexString(this.getAddress()));
  }
}
