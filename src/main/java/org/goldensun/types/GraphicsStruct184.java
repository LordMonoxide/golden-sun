package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class GraphicsStruct184 implements MemoryRef {
  private final Value ref;

  public final UnsignedShortRef count_00;
  public final UnsignedShortRef _02;
  public final ArrayRef<GraphicsStruct0c> _04;

  public GraphicsStruct184(final Value ref) {
    this.ref = ref;

    this.count_00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
    this._02 = ref.offset(2, 0x02).cast(UnsignedShortRef::new);
    this._04 = ref.offset(4, 0x04).cast(ArrayRef.of(GraphicsStruct0c.class, 32, 0xc, GraphicsStruct0c::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
