package org.goldensun.memory;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.MathHelper;
import org.goldensun.cpu.InstructionSet;
import org.goldensun.memory.segments.TempSegment;
import org.goldensun.memory.types.QuadConsumer;
import org.goldensun.memory.types.QuintConsumer;
import org.goldensun.memory.types.TriConsumer;
import org.goldensun.memory.types.TriFunction;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Memory {
  private static final Logger LOGGER = LogManager.getFormatterLogger();

  private final Object lock = new Object();

  private final List<Segment> segments = new ArrayList<>();

  public static final int TEMP_FLAG = 0xffff_0000;
  private static final int TEMP_MASK = 0x0000_ffff;

  private final TempSegment temp = new TempSegment();

  public static final IntSet readWatches = new IntOpenHashSet();
  public static final IntSet writeWatches = new IntOpenHashSet();

  public Memory() {
    this.addSegment(this.temp);
  }

  public static void addWatch(final int address) {
    readWatches.add(address);
    writeWatches.add(address);
  }

  public static void addReadWatch(final int address) {
    readWatches.add(address);
  }

  public static void addWriteWatch(final int address) {
    writeWatches.add(address);
  }

  public static void removeWatch(final int address) {
    readWatches.remove(address);
    writeWatches.remove(address);
  }

  public static void removeReadWatch(final int address) {
    readWatches.remove(address);
  }

  public static void removeWriteWatch(final int address) {
    writeWatches.remove(address);
  }

  public void dump(int address, final int size) {
    address &= ~0xf;

    for(int i = 0; i < size; i++) {
      if(i % 0x10 == 0) {
        if(i != 0) {
          System.out.println();
        }

        System.out.printf("%07x  ", address + i);
      }

      System.out.printf("%02x ", this.get(address + i, 1) & 0xff);
    }

    System.out.println();
  }

  public void waitForLock(final Runnable callback) {
    synchronized(this.lock) {
      callback.run();
    }
  }

  public <T> T waitForLock(final Supplier<T> callback) {
    synchronized(this.lock) {
      return callback.get();
    }
  }

  private void checkAlignment(final int address, final int size) {
    // Don't check alignment for temps - they use special storage
    if(size > 4 || (size & 1) != 0 || (address & TEMP_FLAG) == TEMP_FLAG) {
      return;
    }

    if((address & size - 1) != 0) {
      throw new MisalignedAccessException("Misaligned memory access at address " + Integer.toHexString(address) + " for size " + size);
    }
  }

  public <T extends Segment> T addSegment(final T segment) {
    synchronized(this.lock) {
      this.segments.add(segment);
      return segment;
    }
  }

  private Segment getSegment(final int address) {
    for(final Segment segment : this.segments) {
      if(segment.accepts(address)) {
        return segment;
      }
    }

    throw new IllegalAddressException("There is no memory segment at " + Integer.toHexString(address) + ')');
  }

  public int get(final int address, final int size) {
    this.checkAlignment(address, size);

    synchronized(this.lock) {
      final Segment segment = this.getSegment(address);
      final int val = segment.get(address - segment.getAddress(), size);

      if(readWatches.contains(address)) {
        LOGGER.error("%08x read %x", address, val);
        LOGGER.error("", new Throwable());
      }

      return val;
    }
  }

  public void set(final int address, final int size, final int data) {
    this.checkAlignment(address, size);

    synchronized(this.lock) {
      final Segment segment = this.getSegment(address);
      final int addr = address - segment.getAddress();
      segment.set(addr, size, data);
    }

    if(writeWatches.contains(address)) {
      LOGGER.error("%08x set to %x", address, data);
      LOGGER.error("", new Throwable());
    }
  }

  public byte[] getBytes(final int address, final int size) {
    synchronized(this.lock) {
      final Segment segment = this.getSegment(address);
      return segment.getBytes(address - segment.getAddress(), size);
    }
  }

  public void getBytes(final int address, final byte[] dest, final int offset, final int size) {
    if(readWatches.contains(address)) {
      LOGGER.error("%08x read", address);
      LOGGER.error("", new Throwable());
    }

    synchronized(this.lock) {
      final Segment segment = this.getSegment(address);
      segment.getBytes(address - segment.getAddress(), dest, offset, size);
    }
  }

  public void setBytes(final int address, final byte[] data) {
    this.setBytes(address, data, 0, data.length);
  }

  public void setBytes(final int address, final byte[] data, final int offset, final int size) {
    synchronized(this.lock) {
      final Segment segment = this.getSegment(address);
      segment.setBytes(address - segment.getAddress(), data, offset, size);
    }

    for(final int watch : writeWatches) {
      if(watch >= address && watch < address + size) {
        LOGGER.error("%08x set to %x", watch, this.get(watch, 4));
        LOGGER.error("", new Throwable());
      }
    }
  }

  public void memcpy(final int dest, final int src, final int length) {
    if(dest == src || length == 0) {
      return;
    }

    synchronized(this.lock) {
      final Segment srcSegment = this.getSegment(src);
      Segment destSegment = this.getSegment(dest);

      if(destSegment == srcSegment) {
        srcSegment.memcpy(dest - srcSegment.getAddress(), src - srcSegment.getAddress(), length);
      } else {
        final byte[] data = srcSegment.getBytes(src - srcSegment.getAddress(), length);

        int offset = 0;
        while(offset < data.length) {
          final int copyLen = Math.min(data.length, destSegment.getLength());
          destSegment.setBytes(dest + offset - destSegment.getAddress(), data, offset, copyLen);
          offset += copyLen;

          if(offset < data.length) {
            destSegment = this.getSegment(dest + offset);
          }
        }
      }

      for(final int watch : writeWatches) {
        if(watch >= dest && watch < dest + length) {
          LOGGER.error("%08x set to %x", watch, this.get(watch, (watch & 0x3) == 0 ? 4 : (watch & 0x1) == 0 ? 2 : 1));
          LOGGER.error("", new Throwable());
        }
      }
    }
  }

  public void memfill(final int addr, final int length, final int value) {
    if(length == 0) {
      return;
    }

    synchronized(this.lock) {
      final Segment srcSegment = this.getSegment(addr);
      srcSegment.memfill(addr - srcSegment.getAddress(), length, value);

      for(final int watch : writeWatches) {
        if(watch >= addr && watch < addr + length) {
          LOGGER.error("%08x set to %x", watch, value);
          LOGGER.error("", new Throwable());
        }
      }
    }
  }

  public Object call(final int address, final Object... params) {
    return this.call((address & 0x1) == 0 ? InstructionSet.ARM : InstructionSet.THUMB, address, params);
  }

  public Object call(final InstructionSet instructionSet, final int address, final Object... params) {
    return this.unaligned(instructionSet == InstructionSet.ARM ? 4 : 2, address).call(params);
  }

  public Value unaligned(final int byteSize, final int address) {
    return new MemoryValue(byteSize, address);
  }

  public Value ref(final int byteSize, final int address) {
    this.checkAlignment(address, byteSize);
    return new MemoryValue(byteSize, address);
  }

  public <T> T ref(final int byteSize, final int address, final Function<Value, T> constructor) {
    if(address == 0) {
      return null;
    }

    return constructor.apply(this.ref(byteSize, address));
  }

  public TemporaryReservation temp() {
    return this.temp(4);
  }

  public TemporaryReservation temp(final int length) {
    return new TemporaryReservation(this.temp.allocate(length), length);
  }

  public void releaseTemp(final int address, final int length) {
    this.temp.release(address & TEMP_MASK, length);
  }

  private record MethodInfo(java.lang.reflect.Method method, boolean ignoreExtraParams) { }

  public void addFunctions(final Class<?> cls) {
    LOGGER.info("Adding function references from %s", cls);

    synchronized(this.lock) {
      final Int2ObjectMap<MethodInfo> methods = new Int2ObjectOpenHashMap<>();

      for(final java.lang.reflect.Method method : cls.getMethods()) {
        if(method.isAnnotationPresent(Method.class)) {
          final Method address = method.getAnnotation(Method.class);
          final int addr = address.value();

          if(methods.containsKey(addr)) {
            throw new RuntimeException(cls + " contains two methods at address " + Integer.toHexString(addr));
          }

          methods.put(addr, new MethodInfo(method, address.ignoreExtraParams()));
        }
      }

      if(methods.isEmpty()) {
        throw new RuntimeException(cls + " contained no methods with Method annotations");
      }

      for(final Int2ObjectMap.Entry<MethodInfo> entry : methods.int2ObjectEntrySet()) {
        this.setFunction(entry.getIntKey(), entry.getValue().method, null, entry.getValue().ignoreExtraParams);
      }
    }
  }

  public void setFunction(final int address, final Class<?> cls, final String method, final Class<?>... params) {
    try {
      final java.lang.reflect.Method m = cls.getMethod(method, params);
      this.setFunction(address, m, null, false);
    } catch(final NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  public void setFunction(final int address, final java.lang.reflect.Method function, @Nullable final Object instance, final boolean ignoreExtraParams) {
    this.checkAlignment(address, 2);

    final Segment segment = this.getSegment(address);
    segment.setFunction(address - segment.getAddress(), function, instance, ignoreExtraParams);
  }

  private MethodBinding getFunction(final int address) {
    this.checkAlignment(address, 2);

    final Segment segment = this.getSegment(address);
    return segment.getFunction(address - segment.getAddress());
  }

  private boolean isFunction(final int address) {
    this.checkAlignment(address, 2);

    final Segment segment = this.getSegment(address);
    return segment.isFunction(address - segment.getAddress());
  }

  public class MemoryValue extends Value {
    private final int address;
    private Segment segment;
    private int segmentOffset;

    public MemoryValue(final int byteSize, final int address) {
      super(byteSize);
      this.address = address;
    }

    private Segment getSegment() {
      if(this.segment == null) {
        this.segment = Memory.this.getSegment(this.address);
        this.segmentOffset = this.address - this.segment.getAddress();
      }

      return this.segment;
    }

    @Override
    public Value offset(final int offset) {
      if(offset == 0) {
        return this;
      }

      return Memory.this.ref(this.getSize(), this.address + offset);
    }

    @Override
    public Value offset(final int size, final int offset) {
      if(offset == 0 && size == this.getSize()) {
        return this;
      }

      return Memory.this.ref(size, this.address + offset);
    }

    @Override
    public Value deref(final int size) {
      if(this.getSize() != 4) {
        throw new UnsupportedOperationException("Can only dereference 4-byte values %s".formatted(this));
      }

      if((this.address & TEMP_FLAG) != TEMP_FLAG && Memory.this.isFunction(this.address)) {
        throw new UnsupportedOperationException("Can't dereference callback %s".formatted(this));
      }

      try {
        return Memory.this.ref(size, this.getUnsigned());
      } catch(final MisalignedAccessException e) {
        LOGGER.error("Misaligned deref %s", this);
        LOGGER.error("", new Throwable());
        throw e;
      }
    }

    @Override
    public Value derefUnaligned(final int size) {
      if(this.getSize() != 4) {
        throw new UnsupportedOperationException("Can only dereference 4-byte values %s".formatted(this));
      }

      if((this.address & TEMP_FLAG) != TEMP_FLAG && Memory.this.isFunction(this.address)) {
        throw new UnsupportedOperationException("Can't dereference callback %s".formatted(this));
      }

      try {
        return Memory.this.unaligned(size, this.getUnsigned());
      } catch(final MisalignedAccessException e) {
        LOGGER.error("Misaligned deref %s", this);
        LOGGER.error("", new Throwable());
        throw e;
      }
    }

    @Override
    public int getAddress() {
      return this.address;
    }

    @Override
    public String toString() {
      return super.toString() + " @ " + Integer.toHexString(this.address);
    }

    @Override
    public int getUnsigned() {
      synchronized(Memory.this.lock) {
        final Segment segment = this.getSegment();

        final int val;
        if(this.getSize() == 4 && (this.segmentOffset & 0x3) != 0) {
          final int wordOffset = this.segmentOffset & 0x3;
          val = segment.get(this.segmentOffset, 0x4 - wordOffset) | segment.get(this.segmentOffset & ~0x3, wordOffset) << (4 - wordOffset) * 8;
        } else if(this.getSize() == 2 && (this.address & 0x1) != 0) {
          val = segment.get(this.segmentOffset, 0x1) | segment.get(this.segmentOffset - 0x1, 0x1) << 8;
        } else {
          val = segment.get(this.segmentOffset, this.getSize());
        }

        if(readWatches.contains(this.address)) {
          LOGGER.error("%08x read %x", this.address, val);
          LOGGER.error("", new Throwable());
        }

        return val;
      }
    }

    @Override
    public int get() {
      return MathHelper.sign(this.getUnsigned(), this.getSize());
    }

    @Override
    public Object call(final Object... params) {
      final MethodBinding binding = this.getSegment().getFunction(this.segmentOffset & ~0x1);
      final java.lang.reflect.Method method = binding.method();

      try {
        final Object[] finalParams;

        if(method.getParameterCount() < params.length && binding.ignoreExtraParams()) {
          finalParams = new Object[method.getParameterCount()];
          System.arraycopy(params, 0, finalParams, 0, finalParams.length);
        } else {
          finalParams = params;
        }

        return method.invoke(binding.instance(), finalParams);
      } catch(final IllegalArgumentException e) {
        LOGGER.error("Bad dynamic method call to %08x: expected %d params, got %d", this.address, method.getParameterCount(), params.length);
        LOGGER.error("Params:");

        for(final Object param : params) {
          LOGGER.error("%s: %s", param.getClass(), param);
        }

        throw e;
      } catch(final IllegalAccessException e) {
        throw new RuntimeException(e);
      } catch(final InvocationTargetException e) {
        if(e.getTargetException() instanceof RuntimeException) {
          throw (RuntimeException)e.getTargetException();
        }

        if(e.getTargetException() instanceof Error) {
          throw (Error)e.getTargetException();
        }

        throw new RuntimeException(e.getTargetException());
      }
    }

    @Override
    public Value set(final int value) {
      synchronized(Memory.this.lock) {
        this.getSegment().set(this.segmentOffset, this.getSize(), value);
      }

      if(writeWatches.contains(this.address)) {
        LOGGER.error("%08x set to %x", this.address, value);
        LOGGER.error("", new Throwable());
      }

      return this;
    }

    @Override
    public Value setu(final int value) {
      final long valueLong = value & (0b1L << this.getSize() * 8) - 1;
      this.validateUnsigned(valueLong);
      this.set((int)valueLong);
      return this;
    }

    @Override
    public Value set(final Runnable function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("run"), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public <T> Value set(final Consumer<T> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("accept", Object.class), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public <T, U> Value set(final BiConsumer<T, U> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("accept", Object.class, Object.class), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public <T, U, V> Value set(final TriConsumer<T, U, V> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("accept", Object.class, Object.class, Object.class), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public <T, U, V, W> Value set(final QuadConsumer<T, U, V, W> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("accept", Object.class, Object.class, Object.class, Object.class), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public <T, U, V, W, X> Value set(final QuintConsumer<T, U, V, W, X> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("accept", Object.class, Object.class, Object.class, Object.class, Object.class), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public Value set(final Function<?, ?> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("apply", Object.class), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public Value set(final BiFunction<?, ?, ?> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("apply", Object.class, Object.class), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public Value set(final TriFunction<?, ?, ?, ?> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("apply", Object.class, Object.class, Object.class), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    @Override
    public <T> Value set(final Supplier<T> function) {
      try {
        this.getSegment().setFunction(this.segmentOffset, function.getClass().getMethod("get"), function, false);
      } catch(final NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
      return this;
    }
  }

  public final class TemporaryReservation {
    public final int address;
    public final int length;
    private boolean released;

    private TemporaryReservation(final int address, final int length) {
      this.address = address | TEMP_FLAG;
      this.length = length;
    }

    public Value get() {
      if(this.released) {
        throw new IllegalStateException("Can't get temporary reservation once released");
      }

      return Memory.this.ref(4, this.address);
    }

    public void release() {
      this.released = true;
      Memory.this.releaseTemp(this.address, this.length);
    }
  }
}
