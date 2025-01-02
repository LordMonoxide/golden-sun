package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;

import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.sin;

/** 4x3 column-major with translation vector in 4th column */
public class Matrix30 implements MemoryRef {
  private final Value ref;

  private final ArrayRef<IntRef> data_00;
  private final int[] data;

  public Matrix30(final Value ref) {
    this.ref = ref;

    this.data_00 = ref.offset(4, 0x00).cast(ArrayRef.of(IntRef.class, 12, 0x4, IntRef::new));
    this.data = null;
  }

  public Matrix30() {
    this.ref = null;
    this.data_00 = null;
    this.data = new int[12];
  }

  public int get(final int index) {
    if(this.ref == null) {
      return this.data[index];
    }

    return this.data_00.get(index).get();
  }

  public Matrix30 set(final int index, final int value) {
    if(this.ref == null) {
      this.data[index] = value;
    } else {
      this.data_00.get(index).set(value);
    }
    return this;
  }

  public Matrix30 identity() {
    this.set(0, 0x10000);
    this.set(1, 0);
    this.set(2, 0);
    this.set(3, 0);
    this.set(4, 0x10000);
    this.set(5, 0);
    this.set(6, 0);
    this.set(7, 0);
    this.set(8, 0x10000);
    this.set(9, 0);
    this.set(10, 0);
    this.set(11, 0);
    return this;
  }

  public Matrix30 translate(final Vec3 translation) {
    this.set( 9, this.get( 9) + translation.getX());
    this.set(10, this.get(10) + translation.getY());
    this.set(11, this.get(11) + translation.getZ());
    return this;
  }

  public Matrix30 translation(final Vec3 translation) {
    return this.identity().translate(translation);
  }

  public Matrix30 rotationX(final int angle) {
    final int sin = sin(angle);
    final int cos = cos(angle);
    this.identity();
    this.set(4, cos);
    this.set(5, sin);
    this.set(7, -sin);
    this.set(8, cos);
    return this;
  }

  public Matrix30 rotationY(final int angle) {
    final int sin = sin(angle);
    final int cos = cos(angle);
    this.identity();
    this.set(0, cos);
    this.set(2, -sin);
    this.set(6, sin);
    this.set(8, cos);
    return this;
  }

  @Override
  public int getAddress() {
    if(this.ref == null) {
      throw new NullPointerException("Can't get address of non-heap object");
    }

    return this.ref.getAddress();
  }
}
