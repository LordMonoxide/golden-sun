package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class ChoiceMenu98 implements MemoryRef {
  private final Value ref;

  public final ArrayRef<Option14> options_00;
  public final Pointer<Panel24> panel_78;

  public final ArrayRef<UnsignedByteRef> icons_84;

  public final ShortRef selectedOption_8c;
  public final ShortRef count_8e;
  public final ShortRef panelW_90;
  /** The text IDs shown in the panel, this is the first index and is offset by the selected option (or icon index + 31, if this value is 0) */
  public final ShortRef textIdGroup_92;
  public final ShortRef y_94;

  public ChoiceMenu98(final Value ref) {
    this.ref = ref;

    this.options_00 = ref.offset(4, 0x00).cast(ArrayRef.of(Option14.class, 6, 0x14, Option14::new));
    this.panel_78 = ref.offset(4, 0x78).cast(Pointer.deferred(4, Panel24::new));

    this.icons_84 = ref.offset(1, 0x84).cast(ArrayRef.of(UnsignedByteRef.class, 6, 0x1, UnsignedByteRef::new));

    this.selectedOption_8c = ref.offset(2, 0x8c).cast(ShortRef::new);
    this.count_8e = ref.offset(2, 0x8e).cast(ShortRef::new);
    this.panelW_90 = ref.offset(2, 0x90).cast(ShortRef::new);
    this.textIdGroup_92 = ref.offset(2, 0x92).cast(ShortRef::new);
    this.y_94 = ref.offset(2, 0x94).cast(ShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Option14 implements MemoryRef {
    private final Value ref;

    public final RenderPacket0c packet_00;
    public final ShortRef x_0c;
    public final ShortRef y_0e;

    public final UnsignedShortRef vramSlot_12;

    public Option14(final Value ref) {
      this.ref = ref;

      this.packet_00 = ref.offset(4, 0x00).cast(RenderPacket0c::new);
      this.x_0c = ref.offset(2, 0x0c).cast(ShortRef::new);
      this.y_0e = ref.offset(2, 0x0e).cast(ShortRef::new);

      this.vramSlot_12 = ref.offset(2, 0x12).cast(UnsignedShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
