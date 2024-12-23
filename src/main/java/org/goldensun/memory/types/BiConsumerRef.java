package org.goldensun.memory.types;

import org.goldensun.memory.Value;

import java.util.function.BiConsumer;

public class BiConsumerRef<T, U> implements MemoryRef {
  private final Value ref;

  public static <T, U> Class<BiConsumerRef<T, U>> classFor(final Class<T> t, final Class<U> u) {
    //noinspection unchecked
    return (Class<BiConsumerRef<T, U>>)(Class<?>)BiConsumerRef.class;
  }

  public BiConsumerRef(final Value ref) {
    this.ref = ref;
  }

  public void run(final T t, final U u) {
    this.ref.call(t, u);
  }

  public void set(final BiConsumer<T, U> val) {
    this.ref.set(val);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
