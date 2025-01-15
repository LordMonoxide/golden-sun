package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Ability10 implements MemoryRef {
  private final Value ref;

  public final UnsignedByteRef target_00;
  /**
   * <ul>
   *   <li>0x1 - ?</li>
   *   <li>0x2 - ?</li>
   *   <li>0x4 - Usable outside battle</li>
   *   <li>0x8 - Usable in battle</li>
   *   <li>0xf0 - Damage type?</li>
   * </ul>
   */
  public final UnsignedByteRef flags_01;
  public final UnsignedByteRef element_02;
  public final UnsignedByteRef effect_03;
  public final UnsignedByteRef _04;

  public final UnsignedByteRef _08;
  public final UnsignedByteRef cost_09;
  public final UnsignedShortRef power_0a;
  public final UnsignedByteRef fieldPsynergyId_0c;

  public Ability10(final Value ref) {
    this.ref = ref;

    this.target_00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
    this.flags_01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
    this.element_02 = ref.offset(1, 0x02).cast(UnsignedByteRef::new);
    this.effect_03 = ref.offset(1, 0x03).cast(UnsignedByteRef::new);
    this._04 = ref.offset(1, 0x04).cast(UnsignedByteRef::new);

    this._08 = ref.offset(1, 0x08).cast(UnsignedByteRef::new);
    this.cost_09 = ref.offset(1, 0x09).cast(UnsignedByteRef::new);
    this.power_0a = ref.offset(2, 0x0a).cast(UnsignedShortRef::new);
    this.fieldPsynergyId_0c = ref.offset(1, 0x0c).cast(UnsignedByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
