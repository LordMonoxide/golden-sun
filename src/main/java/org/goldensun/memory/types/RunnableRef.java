package org.goldensun.memory.types;

import org.goldensun.memory.Value;

public class RunnableRef implements MemoryRef {
  private final Value ref;

  public RunnableRef(final Value ref) {
    this.ref = ref;
  }

  public void run() {
    this.ref.call();
  }

  public void set(final Runnable val) {
    this.ref.set(val);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  @Override
  public String toString() {
    return "RunnableRef @ " + Integer.toHexString(this.getAddress());
  }
}
