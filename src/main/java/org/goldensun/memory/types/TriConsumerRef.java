package org.goldensun.memory.types;

import org.goldensun.memory.Value;

public class TriConsumerRef<T, U, V> implements MemoryRef {
  private final Value ref;

  public static <T, U, V> Class<TriConsumerRef<T, U, V>> classFor(final Class<T> t, final Class<U> u, final Class<V> v) {
    //noinspection unchecked
    return (Class<TriConsumerRef<T, U, V>>)(Class<?>)TriConsumerRef.class;
  }

  public TriConsumerRef(final Value ref) {
    this.ref = ref;
  }

  public void run(final T t, final U u, final V v) {
    this.ref.call(t, u, v);
  }

  public void set(final TriConsumer<T, U, V> val) {
    this.ref.set(val);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
