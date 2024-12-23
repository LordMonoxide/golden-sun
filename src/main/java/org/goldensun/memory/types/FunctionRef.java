package org.goldensun.memory.types;

import org.goldensun.memory.Value;

import java.util.function.Function;

public class FunctionRef<T, R> implements MemoryRef {
  private final Value ref;

  public static <T, R> Class<FunctionRef<T, R>> classFor(final Class<T> t, final Class<R> r) {
    //noinspection unchecked
    return (Class<FunctionRef<T, R>>)(Class<?>)FunctionRef.class;
  }

  public FunctionRef(final Value ref) {
    this.ref = ref;
  }

  public R run(final T t) {
    //noinspection unchecked
    return (R)this.ref.call(t);
  }

  public void set(final Function<T, R> val) {
    this.ref.set(val);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
