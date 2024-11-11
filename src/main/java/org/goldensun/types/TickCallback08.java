package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;

public class TickCallback08 implements MemoryRef {
  private final Value ref;

  public final Pointer<RunnableRef> callback_00;
  /** Upper byte is class/type of callback, entire thing is used as priority for sorting */
  public final ShortRef classAndPriority_04;
  public final UnsignedByteRef _06;

  public TickCallback08(final Value ref) {
    this.ref = ref;

    this.callback_00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, RunnableRef::new));
    this.classAndPriority_04 = ref.offset(2, 0x04).cast(ShortRef::new);
    this._06 = ref.offset(1, 0x06).cast(UnsignedByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
