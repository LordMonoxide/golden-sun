package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;

public class GraphicsStruct0c implements MemoryRef {
  private final Value ref;

  /** TODO pointer */
  public final IntRef _00;
  /** TODO pointer */
  public final IntRef _04;
  /** TODO pointer */
  public final IntRef _08;

  public GraphicsStruct0c(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(IntRef::new);
    this._04 = ref.offset(4, 0x04).cast(IntRef::new);
    this._08 = ref.offset(4, 0x08).cast(IntRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
