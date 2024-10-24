package org.goldensun.memory;

import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.BiConsumerRef;
import org.goldensun.memory.types.BiFunctionRef;
import org.goldensun.memory.types.ConsumerRef;
import org.goldensun.memory.types.FunctionRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.memory.types.TriConsumerRef;
import org.goldensun.memory.types.TriFunctionRef;
import org.goldensun.memory.types.UnboundedArrayRef;

import java.lang.reflect.Field;

import static org.goldensun.Hardware.MEMORY;

public final class MemoryHelper {
  private MemoryHelper() { }

  public static int getMethodAddress(final Class<?> cls, final String method, final Class<?>... paramTypes) {
    try {
      return cls.getMethod(method, paramTypes).getAnnotation(Method.class).value();
    } catch(final NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  public static RunnableRef getRunnable(final Class<?> cls, final String method) {
    return MEMORY.ref(2, getMethodAddress(cls, method), RunnableRef::new);
  }

  public static <T> ConsumerRef<T> getConsumer(final Class<?> cls, final String method, final Class<T> t) {
    return MEMORY.ref(2, getMethodAddress(cls, method, t), ConsumerRef::new);
  }

  public static <T, U> BiConsumerRef<T, U> getBiConsumer(final Class<?> cls, final String method, final Class<T> t, final Class<U> u) {
    return MEMORY.ref(2, getMethodAddress(cls, method, t, u), BiConsumerRef::new);
  }

  public static <T, U, V> TriConsumerRef<T, U, V> getTriConsumer(final Class<?> cls, final String method, final Class<T> t, final Class<U> u, final Class<V> v) {
    return MEMORY.ref(2, getMethodAddress(cls, method, t, u, v), TriConsumerRef::new);
  }

  public static <T, R> FunctionRef<T, R> getFunction(final Class<?> cls, final String method, final Class<T> t, final Class<R> r) {
    return MEMORY.ref(2, getMethodAddress(cls, method, t), FunctionRef::new);
  }

  public static <T, U, R> BiFunctionRef<T, U, R> getBiFunction(final Class<?> cls, final String method, final Class<T> t, final Class<U> u, final Class<R> r) {
    return MEMORY.ref(2, getMethodAddress(cls, method, t, u), BiFunctionRef::new);
  }

  public static <T, U, V, R> TriFunctionRef<T, U, V, R> getTriFunction(final Class<?> cls, final String method, final Class<T> t, final Class<U> u, final Class<V> v, final Class<R> r) {
    return MEMORY.ref(2, getMethodAddress(cls, method, t, u, v), TriFunctionRef::new);
  }

  public static <T extends MemoryRef> void copyPointerTypes(final T dest, final T src) {
    try {
      for(final Field field : dest.getClass().getFields()) {
        if(field.getType() == Pointer.class) {
          final Pointer srcPtr = (Pointer)src.getClass().getField(field.getName()).get(src);
          final Pointer destPtr = (Pointer)field.get(dest);

          if(srcPtr.isNull()) {
            destPtr.clear();
          } else {
            if(srcPtr.deref() instanceof ArrayRef<?> || srcPtr.deref() instanceof UnboundedArrayRef<?>) {
              continue;
            }

            destPtr.set(srcPtr.deref().getClass().getConstructor(Value.class).newInstance(MEMORY.ref(4, destPtr.getPointer())));

            copyPointerTypes(destPtr.deref(), srcPtr.deref());
          }
        }
      }
    } catch(final Exception e) {
      throw new RuntimeException("Failed to copy pointers", e);
    }
  }
}
