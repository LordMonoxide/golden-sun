package org.goldensun.memory;

import org.goldensun.Hardware;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnboundedArrayRef;

import java.lang.reflect.Field;

public final class MemoryHelper {
  private MemoryHelper() { }

  public static int getMethodAddress(final Class<?> cls, final String method, final Class<?>... paramTypes) {
    try {
      return cls.getMethod(method, paramTypes).getAnnotation(Method.class).value();
    } catch(final NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
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

            destPtr.set(srcPtr.deref().getClass().getConstructor(Value.class).newInstance(Hardware.MEMORY.ref(4, destPtr.getPointer())));

            copyPointerTypes(destPtr.deref(), srcPtr.deref());
          }
        }
      }
    } catch(final Exception e) {
      throw new RuntimeException("Failed to copy pointers", e);
    }
  }
}
