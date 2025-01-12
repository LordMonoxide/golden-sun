package org.goldensun.battle;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.types.Vec3;

/** malloc struct 12 */
public class Camera4c implements MemoryRef {
  private final Value ref;

  public final Vec3 _00;
  public final Vec3 _0c;
  public final Pointer<Vec3> _18;
  public final Pointer<Vec3> _1c;
  public final IntRef _20;
  public final ShortRef rotationX_34;
  public final ShortRef rotationY_36;

  public Camera4c(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(Vec3::new);
    this._0c = ref.offset(4, 0x0c).cast(Vec3::new);
    this._18 = ref.offset(4, 0x18).cast(Pointer.deferred(4, Vec3::new));
    this._1c = ref.offset(4, 0x1c).cast(Pointer.deferred(4, Vec3::new));
    this._20 = ref.offset(4, 0x20).cast(IntRef::new);
    this.rotationX_34 = ref.offset(2, 0x34).cast(ShortRef::new);
    this.rotationY_36 = ref.offset(2, 0x36).cast(ShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
