package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class EventStruct0c implements MemoryRef {
  private final Value ref;

  //TODO Yeah I dunno there's a bunch of overlap here

  public final IntRef _00;
  public final UnsignedByteRef _01;
  /** This seems to be actor index, at least for movable pillars */
  public final UnsignedShortRef _04_s;
  public final UnsignedByteRef _04_b;
  public final ShortRef _06;
  public final IntRef callback_08;
  public final UnsignedShortRef _08_s;

  public EventStruct0c(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(IntRef::new);
    this._01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
    this._04_s = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
    this._04_b = ref.offset(1, 0x04).cast(UnsignedByteRef::new);
    this._06 = ref.offset(2, 0x06).cast(ShortRef::new);
    this.callback_08 = ref.offset(4, 0x08).cast(IntRef::new);
    this._08_s = ref.offset(2, 0x08).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
