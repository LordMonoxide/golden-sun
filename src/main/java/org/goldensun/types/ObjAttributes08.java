package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class ObjAttributes08 implements MemoryRef {
  private final Value ref;

  public final UnsignedShortRef attrib0_00;
  public final UnsignedByteRef y_00; // Overlap
  public final UnsignedByteRef flags_01; // Overlap
  public final UnsignedShortRef attrib1_02;
  public final UnsignedShortRef attrib2_04;
  public final UnsignedShortRef rotationScaling_06;

  public ObjAttributes08(final Value ref) {
    this.ref = ref;

    this.attrib0_00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
    this.y_00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
    this.flags_01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
    this.attrib1_02 = ref.offset(2, 0x02).cast(UnsignedShortRef::new);
    this.attrib2_04 = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
    this.rotationScaling_06 = ref.offset(2, 0x06).cast(UnsignedShortRef::new);
  }

  public int getPaletteNumber() {
    return this.attrib2_04.get() >>> 12;
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
