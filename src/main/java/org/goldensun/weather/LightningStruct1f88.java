package org.goldensun.weather;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.BoolRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;

public class LightningStruct1f88 implements MemoryRef {
  private final Value ref;

  public final ArrayRef<ShortRef> dest_0000;
  public final ArrayRef<ShortRef> current_0a80;
  public final ArrayRef<ShortRef> step_1500;
  public final ShortRef ticksRemaining_1f80;
  public final BoolRef repeat_1f82;
  public final BoolRef quiet_1f84;

  public LightningStruct1f88(final Value ref) {
    this.ref = ref;

    this.dest_0000 = ref.offset(2, 0x0000).cast(ArrayRef.of(ShortRef.class, 0xa80, 0x2, ShortRef::new));
    this.current_0a80 = ref.offset(2, 0x0a80).cast(ArrayRef.of(ShortRef.class, 0xa80, 0x2, ShortRef::new));
    this.step_1500 = ref.offset(2, 0x1500).cast(ArrayRef.of(ShortRef.class, 0xa80, 0x2, ShortRef::new));
    this.ticksRemaining_1f80 = ref.offset(2, 0x1f80).cast(ShortRef::new);
    this.repeat_1f82 = ref.offset(2, 0x1f82).cast(BoolRef::new);
    this.quiet_1f84 = ref.offset(2, 0x1f84).cast(BoolRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
