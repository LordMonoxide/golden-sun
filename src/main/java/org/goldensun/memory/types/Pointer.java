package org.goldensun.memory.types;

import org.goldensun.Hardware;
import org.goldensun.memory.Memory;
import org.goldensun.memory.MisalignedAccessException;
import org.goldensun.memory.Value;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

public class Pointer<T extends MemoryRef> implements MemoryRef {
  /**
   * Lazy mode - don't resolve pointer until used
   */
  public static <T extends MemoryRef> Function<Value, Pointer<T>> deferred(final int size, final Function<Value, T> constructor) {
    return ref -> new Pointer<>(ref, constructor, size, false);
  }

  public static <T extends MemoryRef> Class<Pointer<T>> classFor(final Class<T> t) {
    //noinspection unchecked
    return (Class<Pointer<T>>)(Class<?>)Pointer.class;
  }

  private final Value ref;
  private final Function<Value, T> constructor;
  private final int size;
  @Nullable
  private T cache;

  public Pointer(final Value ref, final Function<Value, T> constructor, final int size, final boolean precache) {
    this.ref = ref;

    if(ref.getSize() != 4) {
      throw new IllegalArgumentException("Pointers must be 4 bytes");
    }

    this.constructor = constructor;
    this.size = size;

    if(precache) {
      try {
        this.updateCache();
      } catch(final IllegalArgumentException | MisalignedAccessException ignored) {}
    }
  }

  private void updateCache() {
    if(this.isNull()) {
      this.cache = null;
      return;
    }

    this.cache = this.constructor.apply(this.ref.derefUnaligned(this.size));
  }

  public boolean isNull() {
    if(this.cache != null && (this.getAddress() & Memory.TEMP_FLAG) == Memory.TEMP_FLAG) {
      return false;
    }

    return this.ref.getUnsigned() == 0;
  }

  public T deref() {
    final T value = this.derefNullable();

    if(value == null) {
      throw new NullPointerException("Pointer " + Integer.toHexString(this.getAddress()) + " is null");
    }

    return value;
  }

  @Nullable
  public T derefNullable() {
    if(this.isNull()) {
      this.cache = null;
      return null;
    }

    if(this.cache == null || this.ref.getUnsigned() != this.cache.getAddress()) {
      this.updateCache();
    }

    return this.cache;
  }

  public Pointer<T> set(final T ref) {
    this.ref.setu(ref.getAddress());
    this.cache = ref;
    return this;
  }

  public Pointer<T> setNullable(@Nullable final T ref) {
    if(ref == null) {
      this.clear();
    } else {
      this.set(ref);
    }

    return this;
  }

  public Pointer<T> add(final int amount) {
    this.ref.addu(amount);
    this.cache = null;
    return this;
  }

  public Pointer<T> sub(final int amount) {
    this.ref.subu(amount);
    this.cache = null;
    return this;
  }

  public Pointer<T> incr() {
    this.add(this.size);
    this.cache = null;
    return this;
  }

  public Pointer<T> decr() {
    this.sub(this.size);
    this.cache = null;
    return this;
  }

  public int getPointer() {
    return this.ref.getUnsigned();
  }

  public Pointer<T> setPointer(final int address) {
    this.ref.setu(address);
    this.cache = null;
    return this;
  }

  public Pointer<T> set(final int address, final Class<? extends T> type) {
    try {
      return this.set(type.getConstructor(Value.class).newInstance(Hardware.MEMORY.ref(this.size, address)));
    } catch(final InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  public Pointer<T> clear() {
    this.ref.setu(0);
    this.cache = null;
    return this;
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  @Override
  public String toString() {
    if(this.isNull()) {
      return "Null ptr @ %08x".formatted(this.getAddress());
    }

    return "Ptr %08x (%s) @ %08x".formatted(this.getPointer(), this.deref().getClass().getSimpleName(), this.getAddress());
  }
}
