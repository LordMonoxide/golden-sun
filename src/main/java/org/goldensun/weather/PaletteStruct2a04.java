package org.goldensun.weather;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class PaletteStruct2a04 implements MemoryRef {
  private final Value ref;

  public final ArrayRef<UnsignedShortRef> backgroundPaletteBackup_0000;
  public final ArrayRef<UnsignedShortRef> foregroundPaletteBackup_01c0;
  /** Original palette is loaded here and step is added each tick */
  public final ArrayRef<ShortRef> current_0380;
  /** The final palette */
  public final ArrayRef<ShortRef> dest_0e00;
  public final ArrayRef<ShortRef> step_1880;
  public final ArrayRef<ArrayRef<UnsignedShortRef>> _2300;
  public final UnsignedByteRef bufferIndex_2a00;
  public final ByteRef totalTicks_2a01;
  public final ByteRef currentTicks_2a02;

  public PaletteStruct2a04(final Value ref) {
    this.ref = ref;

    this.backgroundPaletteBackup_0000 = ref.offset(2, 0x0000).cast(ArrayRef.of(UnsignedShortRef.class, 0xe0, 0x2, UnsignedShortRef::new));
    this.foregroundPaletteBackup_01c0 = ref.offset(2, 0x01c0).cast(ArrayRef.of(UnsignedShortRef.class, 0xe0, 0x2, UnsignedShortRef::new));
    this.current_0380 = ref.offset(2, 0x0380).cast(ArrayRef.of(ShortRef.class, 0xa80, 0x2, ShortRef::new));
    this.dest_0e00 = ref.offset(2, 0x0e00).cast(ArrayRef.of(ShortRef.class, 0xa80, 0x2, ShortRef::new));
    this.step_1880 = ref.offset(2, 0x1880).cast(ArrayRef.of(ShortRef.class, 0xa80, 0x2, ShortRef::new));
    this._2300 = ref.offset(2, 0x2300).cast(ArrayRef.of(ArrayRef.classFor(UnsignedShortRef.class), 2, 0x380, ArrayRef.of(UnsignedShortRef.class, 0x1c0, 0x2, UnsignedShortRef::new)));
    this.bufferIndex_2a00 = ref.offset(1, 0x2a00).cast(UnsignedByteRef::new);
    this.totalTicks_2a01 = ref.offset(1, 0x2a01).cast(ByteRef::new);
    this.currentTicks_2a02 = ref.offset(1, 0x2a02).cast(ByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
