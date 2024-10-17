package org.goldensun.memory;

import org.goldensun.MathHelper;
import org.goldensun.memory.types.QuadConsumer;
import org.goldensun.memory.types.QuintConsumer;
import org.goldensun.memory.types.TriFunction;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Value {
  private final int size;
  private int value;

  public Value(final int byteSize) {
    this.size = byteSize;
  }

  public Value offset(final int offset) {
    throw new UnsupportedOperationException("Can't offset register");
  }

  public Value offset(final Value offset) {
    return this.offset(offset.getUnsigned());
  }

  public Value offset(final int size, final int offset) {
    throw new UnsupportedOperationException("Can't offset register");
  }

  public Value offset(final int size, final Value offset) {
    return this.offset(size, offset.getUnsigned());
  }

  public int getSize() {
    return this.size;
  }

  public <T> T cast(final Function<Value, T> constructor) {
    return constructor.apply(this);
  }

  public int getAddress() {
    throw new UnsupportedOperationException("Can't get address of register");
  }

  public Value deref(final int size) {
    throw new UnsupportedOperationException("Can't dereference registers");
  }

  public Value derefUnaligned(final int size) {
    throw new UnsupportedOperationException("Can't dereference registers");
  }

  public int getUnsigned() {
    return MathHelper.unsign(this.value, this.size);
  }

  public int get() {
    return MathHelper.sign(this.value, this.size);
  }

  public Object call(final Object... params) {
    throw new RuntimeException("Can't call a register");
  }

  public String getString() {
    if(this.size != 1) {
      throw new RuntimeException("Byte size for string values must be set to 1");
    }

    final StringBuilder sb = new StringBuilder();

    for(int offset = 0; ; offset++) {
      final char ascii = (char)this.offset(1, offset).getUnsigned();

      if(ascii == 0) {
        break;
      }

      sb.append(ascii);
    }

    return sb.toString();
  }

  public String getString(final int length) {
    if(this.size != 1) {
      throw new RuntimeException("Byte size for string values must be set to 1");
    }

    final StringBuilder sb = new StringBuilder();

    for(int offset = 0; offset < length; offset++) {
      sb.append((char)this.offset(1, offset).getUnsigned());
    }

    return sb.toString();
  }

  protected void validateUnsigned(final long value) {
    if(value < 0 || value >= 0b1L << this.size * 8) {
      throw new RuntimeException("Can't set " + this.size + "-byte value to " + Long.toHexString(value));
    }
  }

  protected void validateSigned(final int value) {
    if(value < ~(0b1 << this.size * 8 - 1) + 1 || value >= 0b1L << this.size * 8 - 1) {
      throw new RuntimeException("Can't set " + this.size + "-byte value to " + Integer.toHexString(value));
    }
  }

  public Value set(int value) {
    if((value & 0b1 << this.size * 8 - 1) != 0) {
      value |= -(0b1 << this.size * 8);
    }

    this.validateSigned(value);
    this.value = value;
    return this;
  }

  public Value setu(final int value) {
    final long valueLong = value & (0b1L << this.size * 8) - 1;
    this.validateUnsigned(valueLong);
    this.value = (int)valueLong;
    return this;
  }

  public Value set(final String string) {
    if(this.size != 1) {
      throw new RuntimeException("Byte size for string values must be set to 1");
    }

    for(int offset = 0; offset < string.length(); offset++) {
      this.offset(offset).set((byte)string.charAt(offset));
    }

    this.offset(string.length()).set(0);
    return this;
  }

  public Value set(final Runnable function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public <T> Value set(final Consumer<T> function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public <T, U> Value set(final BiConsumer<T, U> function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public <T, U, V, W> Value set(final QuadConsumer<T, U, V, W> function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public <T, U, V, W, X> Value set(final QuintConsumer<T, U, V, W, X> function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public Value set(final Function<?, ?> function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public Value set(final BiFunction<?, ?, ?> function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public Value set(final TriFunction<?, ?, ?, ?> function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public <T> Value set(final Supplier<T> function) {
    throw new RuntimeException("Can't store functions in registers");
  }

  public Value add(final int amount) {
    return this.set(this.get() + amount);
  }

  public Value add(final Value amount) {
    return this.add(amount.get());
  }

  public Value addu(final int amount) {
    return this.setu(this.getUnsigned() + amount);
  }

  public Value addu(final Value amount) {
    return this.addu(amount.getUnsigned());
  }

  public Value incr() {
    return this.setu(this.getUnsigned() + 1);
  }

  public Value sub(final int amount) {
    return this.add(-amount);
  }

  public Value sub(final Value amount) {
    return this.sub(amount.getUnsigned());
  }

  public Value subu(final int amount) {
    return this.addu(-amount);
  }

  public Value subu(final Value amount) {
    return this.subu(amount.getUnsigned());
  }

  public Value decr() {
    return this.subu(1);
  }

  public Value mul(final int amount) {
    return this.set(this.get() * amount);
  }

  public Value mul(final Value amount) {
    return this.mul(amount.getUnsigned());
  }

  public Value mulu(final int amount) {
    return this.setu(this.getUnsigned() * amount);
  }

  public Value mulu(final Value amount) {
    return this.mulu(amount.getUnsigned());
  }

  public Value div(final int amount) {
    return this.set(this.get() / amount);
  }

  public Value div(final Value amount) {
    return this.div(amount.getUnsigned());
  }

  public Value divu(final int amount) {
    return this.setu(this.getUnsigned() / amount);
  }

  public Value divu(final Value amount) {
    return this.divu(amount.getUnsigned());
  }

  public Value mod(final int amount) {
    return this.set(this.get() % amount);
  }

  public Value mod(final Value amount) {
    return this.mod(amount.getUnsigned());
  }

  public Value modu(final int amount) {
    return this.setu(this.getUnsigned() % amount);
  }

  public Value modu(final Value amount) {
    return this.modu(amount.getUnsigned());
  }

  public Value and(final int amount) {
    return this.setu(this.getUnsigned() & amount);
  }

  public Value and(final Value amount) {
    return this.and(amount.getUnsigned());
  }

  public Value or(final int amount) {
    return this.set(this.getUnsigned() | amount);
  }

  public Value or(final Value amount) {
    return this.or(amount.getUnsigned());
  }

  public Value oru(final int amount) {
    return this.setu(this.getUnsigned() | amount);
  }

  public Value oru(final Value amount) {
    return this.oru(amount.getUnsigned());
  }

  public Value xor(final int amount) {
    return this.set(this.getUnsigned() ^ amount);
  }

  public Value xor(final Value amount) {
    return this.xor(amount.getUnsigned());
  }

  public Value xoru(final int amount) {
    return this.setu(this.getUnsigned() ^ amount);
  }

  public Value xoru(final Value amount) {
    return this.xoru(amount.getUnsigned());
  }

  public Value not() {
    return this.set(~this.getUnsigned());
  }

  public Value notu() {
    return this.setu(~this.getUnsigned());
  }

  public Value neg() {
    return this.set(-this.get());
  }

  public Value abs() {
    return this.set(Math.abs(this.get()));
  }

  public Value shl(final int bits) {
    return this.setu(this.getUnsigned() << bits & (0b1 << this.size * 8) - 1);
  }

  public Value shl(final Value bits) {
    return this.shl(bits.getUnsigned());
  }

  public Value shr(final int bits) {
    return this.setu(this.getUnsigned() >>> bits);
  }

  public Value shr(final Value bits) {
    return this.shr(bits.getUnsigned());
  }

  public Value shra(final int bits) {
    return this.setu(this.getUnsigned() >> bits);
  }

  public Value shra(final Value bits) {
    return this.shra(bits.getUnsigned());
  }

  @Override
  public String toString() {
    return '[' + Integer.toHexString(this.getUnsigned()) + "] (" + this.size + "b)";
  }
}
