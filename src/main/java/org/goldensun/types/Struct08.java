package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Struct08 implements MemoryRef {
  private final Value ref;

  public final Pointer<RunnableRef> _00;
  public final UnsignedShortRef _04;
  public final UnsignedByteRef _06;

  public Struct08(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, RunnableRef::new));
    this._04 = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
    this._06 = ref.offset(1, 0x06).cast(UnsignedByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
