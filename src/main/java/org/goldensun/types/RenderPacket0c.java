package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;

public class RenderPacket0c implements MemoryRef {
  private final Value ref;

  public final Pointer<RenderPacket0c> next_00;
  public final ObjAttributes08 attribs_04;

  public RenderPacket0c(final Value ref) {
    this.ref = ref;

    this.next_00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, RenderPacket0c::new));
    this.attribs_04 = ref.offset(4, 0x04).cast(ObjAttributes08::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
