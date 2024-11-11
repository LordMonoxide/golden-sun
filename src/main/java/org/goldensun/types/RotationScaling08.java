package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;

/** OAM rotation/scaling parameters */
public class RotationScaling08 implements MemoryRef {
  private final Value ref;

  /** Signed .8 */
  public final ShortRef pa_00;
  /** Signed .8 */
  public final ShortRef pb_02;
  /** Signed .8 */
  public final ShortRef pc_04;
  /** Signed .8 */
  public final ShortRef pd_06;

  public RotationScaling08(final Value ref) {
    this.ref = ref;

    this.pa_00 = ref.offset(2, 0x00).cast(ShortRef::new);
    this.pb_02 = ref.offset(2, 0x02).cast(ShortRef::new);
    this.pc_04 = ref.offset(2, 0x04).cast(ShortRef::new);
    this.pd_06 = ref.offset(2, 0x06).cast(ShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
