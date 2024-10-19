package org.goldensun.memory;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

public abstract class Segment {
  private final int address;
  private final int length;

  private final Int2ObjectMap<MethodBinding> functions = new Int2ObjectOpenHashMap<>();

  public Segment(final int address, final int length) {
    this.address = address;
    this.length = length;
  }

  public int getAddress() {
    return this.address;
  }

  public int getLength() {
    return this.length;
  }

  public boolean accepts(final int address) {
    return address >= this.address && address < this.address + this.length;
  }

  public abstract int get(final int offset, final int size);
  public abstract void set(final int offset, final int size, final int value);

  public byte[] getBytes(final int offset, final int size) {
    final byte[] data = new byte[size];
    this.getBytes(offset, data, 0, size);
    return data;
  }

  public void getBytes(final int offset, final byte[] dest, final int dataOffset, final int dataSize) {
    throw new UnsupportedOperationException("This memory segment does not support direct reads (address: " + Integer.toHexString(this.getAddress() + offset) + ')');
  }

  public void setBytes(final int offset, final byte[] data) {
    this.setBytes(offset, data, 0, data.length);
  }

  public void setBytes(final int offset, final byte[] data, final int dataOffset, final int dataLength) {
    throw new UnsupportedOperationException("This memory segment does not support direct writes (address: " + Integer.toHexString(this.getAddress() + offset) + ')');
  }

  public void memcpy(final int dest, final int src, final int length) {
    throw new UnsupportedOperationException("This memory segment does not support memcpy (address: " + Integer.toHexString(this.getAddress() + dest) + ')');
  }

  public void memfill(final int addr, final int length, int value) {
    this.removeFunctions(addr, addr + length);

    value &= 0xff;
    final int fill = value << 24 | value << 16 | value << 8 | value;

    for(int i = 0; i < length; i += 0x4) {
      this.set(addr + i, 4, fill);
    }

    for(int i = 0; i < (length & 0x3); i++) {
      this.set(addr + i, 1, fill);
    }

    throw new UnsupportedOperationException("This memory segment does not support memcpy (address: " + Integer.toHexString(this.getAddress() + addr) + ')');
  }

  protected void setFunction(final int offset, final Method function, @Nullable final Object instance, final boolean ignoreExtraParams) {
    function.setAccessible(true);

    this.functions.put(offset, new MethodBinding(function, instance, ignoreExtraParams));
  }

  protected void removeFunction(final int offset) {
    this.functions.remove(offset);
  }

  public void removeFunctions(final int start, final int end) {
    this.functions.int2ObjectEntrySet().removeIf(entry -> entry.getIntKey() >= start && entry.getIntKey() < end);
  }

  protected MethodBinding getFunction(final int offset) {
    final MethodBinding method = this.functions.get(offset);

    if(method == null) {
      throw new UnsupportedOperationException("There is no method at 0x" + Integer.toHexString(this.getAddress() + offset) + ". The value is 0x" + Integer.toHexString(this.get(offset, 4)) + '.');
    }

    return method;
  }

  protected boolean isFunction(final int offset) {
    return this.functions.containsKey(offset & 0xffff_fffc);
  }
}
