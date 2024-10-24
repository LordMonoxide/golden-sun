package org.goldensun.memory.types;

import org.goldensun.memory.Value;

public class TriFunctionRef<T, U, V, R> implements MemoryRef {
  private final Value ref;

  public static <T, U, V, R> Class<TriFunctionRef<T, U, V, R>> classFor(final Class<T> t, final Class<U> u, final Class<V> v, final Class<R> r) {
    //noinspection unchecked
    return (Class<TriFunctionRef<T, U, V, R>>)(Class<?>)TriFunctionRef.class;
  }

  public TriFunctionRef(final Value ref) {
    this.ref = ref;
  }

  public R run(final T t, final U u, final V v) {
    //noinspection unchecked
    return (R)this.ref.call(t, u, v);
  }

  public void set(final TriFunction<T, U, V, R> val) {
    this.ref.set(val);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
