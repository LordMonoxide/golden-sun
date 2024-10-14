package org.goldensun.memory.types;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
  void accept(T t, U u, V v, R r);
}
