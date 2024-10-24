package org.goldensun.memory.types;

import org.goldensun.memory.Value;

import java.util.function.Consumer;

public class ConsumerRef<T> implements MemoryRef {
  private final Value ref;

  public static <T> Class<ConsumerRef<T>> classFor(final Class<T> t) {
    //noinspection unchecked
    return (Class<ConsumerRef<T>>)(Class<?>)ConsumerRef.class;
  }

  public ConsumerRef(final Value ref) {
    this.ref = ref;
  }

  public void run(final T val) {
    this.ref.call(val);
  }

  public void set(final Consumer<T> val) {
    this.ref.set(val);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
