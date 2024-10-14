package org.goldensun.memory.types;

@FunctionalInterface
public interface TriConsumer<T, U, V> {
  void accept(T t, U u, V v);
}
