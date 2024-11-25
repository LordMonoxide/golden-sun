package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;

import javax.annotation.Nullable;

public class Vec3s implements MemoryRef {
  @Nullable
  private final Value ref;

  public final ShortRef x_00;
  public final ShortRef y_02;
  public final ShortRef z_04;

  public Vec3s() {
    this.ref = null;
    this.x_00 = new ShortRef();
    this.y_02 = new ShortRef();
    this.z_04 = new ShortRef();
  }

  public Vec3s(final Value ref) {
    this.ref = ref;

    this.x_00 = ref.offset(2, 0x00).cast(ShortRef::new);
    this.y_02 = ref.offset(2, 0x02).cast(ShortRef::new);
    this.z_04 = ref.offset(2, 0x04).cast(ShortRef::new);
  }

  public int getX() {
    return this.x_00.get();
  }

  public int getY() {
    return this.y_02.get();
  }

  public int getZ() {
    return this.z_04.get();
  }

  public Vec3s set(final int x, final int y, final int z) {
    this.x_00.set(x);
    this.y_02.set(y);
    this.z_04.set(z);
    return this;
  }

  public Vec3s set(final Vec3s other) {
    return this.set(other.getX(), other.getY(), other.getZ());
  }

  public Vec3s setX(final int x) {
    this.x_00.set(x);
    return this;
  }

  public Vec3s setY(final int y) {
    this.y_02.set(y);
    return this;
  }

  public Vec3s setZ(final int z) {
    this.z_04.set(z);
    return this;
  }

  public Vec3s zero() {
    return this.set(0, 0, 0);
  }

  @Override
  public int getAddress() {
    if(this.ref == null) {
      throw new NullPointerException("Can't get address of non-heap object");
    }

    return this.ref.getAddress();
  }

  @Override
  public String toString() {
    return "Vec3s {x: " + this.x_00 + ", y: " + this.y_02 + ", z: " + this.z_04 + '}' + (this.ref == null ? " (local)" : " @ " + Integer.toHexString(this.getAddress()));
  }
}
