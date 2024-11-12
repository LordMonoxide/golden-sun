package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;

public class Vec3 implements MemoryRef {
  private final Value ref;

  public final IntRef x_00;
  public final IntRef y_04;
  public final IntRef z_08;

  public Vec3(final Value ref) {
    this.ref = ref;

    this.x_00 = ref.offset(4, 0x00).cast(IntRef::new);
    this.y_04 = ref.offset(4, 0x04).cast(IntRef::new);
    this.z_08 = ref.offset(4, 0x08).cast(IntRef::new);
  }

  public int getX() {
    return this.x_00.get();
  }

  public int getY() {
    return this.y_04.get();
  }

  public int getZ() {
    return this.z_08.get();
  }

  public Vec3 set(final int x, final int y, final int z) {
    this.x_00.set(x);
    this.y_04.set(y);
    this.z_08.set(z);
    return this;
  }

  public Vec3 set(final Vec3 other) {
    return this.set(other.getX(), other.getY(), other.getZ());
  }

  public Vec3 setX(final int x) {
    this.x_00.set(x);
    return this;
  }

  public Vec3 setY(final int y) {
    this.y_04.set(y);
    return this;
  }

  public Vec3 setZ(final int z) {
    this.z_08.set(z);
    return this;
  }

  public Vec3 zero() {
    return this.set(0, 0, 0);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
