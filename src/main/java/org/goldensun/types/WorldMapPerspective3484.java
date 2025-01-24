package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;

/** Contains arrays of affine params for pseudo-3D world map background */
public class WorldMapPerspective3484 implements MemoryRef {
  private final Value ref;

  public final ArrayRef<Sub14> _000;
  public final ArrayRef<ArrayRef<Sub20>> _c80;

  public WorldMapPerspective3484(final Value ref) {
    this.ref = ref;

    this._000 = ref.offset(4, 0x000).cast(ArrayRef.of(Sub14.class, 0xa0, 0x14, Sub14::new));
    this._c80 = ref.offset(4, 0xc80).cast(ArrayRef.of(ArrayRef.classFor(Sub20.class), 2, 0x1400, ArrayRef.of(Sub20.class, 0xa0, 0x20, Sub20::new)));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub14 implements MemoryRef {
    private final Value ref;

    public final IntRef _00;
    public final IntRef _04;
    public final IntRef x_08;
    public final IntRef y_0c;
    public final ShortRef pa_10;
    public final ShortRef pc_12;

    public Sub14(final Value ref) {
      this.ref = ref;

      this._00 = ref.offset(4, 0x00).cast(IntRef::new);
      this._04 = ref.offset(4, 0x04).cast(IntRef::new);
      this.x_08 = ref.offset(4, 0x08).cast(IntRef::new);
      this.y_0c = ref.offset(4, 0x0c).cast(IntRef::new);
      this.pa_10 = ref.offset(2, 0x10).cast(ShortRef::new);
      this.pc_12 = ref.offset(2, 0x12).cast(ShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }

  public static class Sub20 implements MemoryRef {
    private final Value ref;

    public final BgParams10 bg2_00;
    public final BgParams10 bg3_10;

    public Sub20(final Value ref) {
      this.ref = ref;

      this.bg2_00 = ref.offset(2, 0x00).cast(BgParams10::new);
      this.bg3_10 = ref.offset(2, 0x10).cast(BgParams10::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }

  public static class BgParams10 implements MemoryRef {
    private final Value ref;

    public final ShortRef pa_00;

    public final ShortRef pc_04;

    public final IntRef x_08;
    public final IntRef y_0c;

    public BgParams10(final Value ref) {
      this.ref = ref;

      this.pa_00 = ref.offset(2, 0x00).cast(ShortRef::new);

      this.pc_04 = ref.offset(2, 0x04).cast(ShortRef::new);

      this.x_08 = ref.offset(4, 0x08).cast(IntRef::new);
      this.y_0c = ref.offset(4, 0x0c).cast(IntRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
