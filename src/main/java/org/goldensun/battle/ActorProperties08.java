package org.goldensun.battle;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class ActorProperties08 implements MemoryRef {
  private final Value ref;

  public final UnsignedShortRef spriteDataIndex_00;
  public final UnsignedByteRef _02;
  public final UnsignedByteRef _03;

  public ActorProperties08(final Value ref) {
    this.ref = ref;

    this.spriteDataIndex_00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
    this._02 = ref.offset(1, 0x02).cast(UnsignedByteRef::new);
    this._03 = ref.offset(1, 0x03).cast(UnsignedByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
