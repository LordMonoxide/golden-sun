package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Structccc implements MemoryRef {
  private final Value ref;

  /** TODO ptrs */
  public final ArrayRef<IntRef> _00;
  public final Pointer<UnboundedArrayRef<EventStruct0c>> events_10;
  /**
   * This array is janky
   * - There's room for 66 elements
   * - getMapActors has a check for 0xc0 elements
   * - 8096cdc iterates over 67 elements
   * TODO WARNING I'm making this array 67 elements long, but the last element will run into {@link #_11c} (which just so happens to start with an Actor)
   */
  public final ArrayRef<Pointer<Actor70>> actors_14;
  public final ArrayRef<Sub08> _11c;
  public final ShortRef _16c;
  public final ShortRef _16e;
  public final ShortRef _170;
  public final ShortRef shouldOpenMenu_172;
  public final ShortRef _174;
  public final ShortRef _176;
  public final ShortRef interactedActor_178;
  public final ShortRef interactedTileType_17a;
  public final ShortRef _17c;
  public final ShortRef _17e;
  public final ShortRef _180;
  public final ShortRef _182;
  public final ShortRef _184;
  public final ShortRef _186;
  public final Value _188;

  public final ShortRef _19a;
  public final ShortRef _19c;
  public final ShortRef _19e;
  public final ArrayRef<UnsignedByteRef> _1a0;
  public final IntRef _1a8;
  public final IntRef _1ac;
  public final IntRef _1b0;
  public final IntRef _1b4;
  public final Pointer<UnboundedArrayRef<TileAttributes04>> tiles_1b8;
  public final Pointer<UnboundedArrayRef<TileAttributes04>> oldTiles_1bc;
  public final IntRef _1c0;

  public final UnsignedShortRef _1c6;
  public final IntRef _1c8;
  public final IntRef _1cc;

  public final ShortRef _1d8;
  public final ShortRef _1da;
  public final ShortRef _1dc;
  public final ShortRef _1de;
  public final Pointer<Actor70> actor_1e0;

  public final IntRef actorIndex_1f4;
  public final Pointer<Panel24> _1f8;
  public final Pointer<Panel24> _1fc;
  public final Value _200;
  public final Value _218;

  public final Pointer<Panel24> panel_230;

  public final Value _236;

  public final Value _776;

  public final ShortRef _cb6;
  public final ShortRef _cb8;

  public final ShortRef _cc0;
  public final ShortRef _cc2;
  public final ShortRef _cc4;
  public final ByteRef _cc6;
  public final ByteRef _cc7;
  /** -1 for none */
  public final ShortRef soundId_cc8;

  public Structccc(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(ArrayRef.of(IntRef.class, 4, 0x4, IntRef::new));
    this.events_10 = ref.offset(4, 0x10).cast(Pointer.deferred(4, UnboundedArrayRef.of(0xc, EventStruct0c::new)));
    this.actors_14 = ref.offset(4, 0x14).cast(ArrayRef.of(Pointer.classFor(Actor70.class), 67, 0x4, Pointer.deferred(4, Actor70::new)));
    this._11c = ref.offset(4, 0x11c).cast(ArrayRef.of(Sub08.class, 10, 0x8, Sub08::new));
    this._16c = ref.offset(2, 0x16c).cast(ShortRef::new);
    this._16e = ref.offset(2, 0x16e).cast(ShortRef::new);
    this._170 = ref.offset(2, 0x170).cast(ShortRef::new);
    this.shouldOpenMenu_172 = ref.offset(2, 0x172).cast(ShortRef::new);
    this._174 = ref.offset(2, 0x174).cast(ShortRef::new);
    this._176 = ref.offset(2, 0x176).cast(ShortRef::new);
    this.interactedActor_178 = ref.offset(2, 0x178).cast(ShortRef::new);
    this.interactedTileType_17a = ref.offset(2, 0x17a).cast(ShortRef::new);
    this._17c = ref.offset(2, 0x17c).cast(ShortRef::new);
    this._17e = ref.offset(2, 0x17e).cast(ShortRef::new);
    this._180 = ref.offset(2, 0x180).cast(ShortRef::new);
    this._182 = ref.offset(2, 0x182).cast(ShortRef::new);
    this._184 = ref.offset(2, 0x184).cast(ShortRef::new);
    this._186 = ref.offset(2, 0x186).cast(ShortRef::new);
    this._188 = ref.offset(4, 0x188);

    this._19a = ref.offset(2, 0x19a).cast(ShortRef::new);
    this._19c = ref.offset(2, 0x19c).cast(ShortRef::new);
    this._19e = ref.offset(2, 0x19e).cast(ShortRef::new);
    this._1a0 = ref.offset(1, 0x1a0).cast(ArrayRef.of(UnsignedByteRef.class, 8, 0x1, UnsignedByteRef::new));
    this._1a8 = ref.offset(4, 0x1a8).cast(IntRef::new);
    this._1ac = ref.offset(4, 0x1ac).cast(IntRef::new);
    this._1b0 = ref.offset(4, 0x1b0).cast(IntRef::new);
    this._1b4 = ref.offset(4, 0x1b4).cast(IntRef::new);
    this.tiles_1b8 = ref.offset(4, 0x1b8).cast(Pointer.deferred(4, UnboundedArrayRef.of(0x4, TileAttributes04::new)));
    this.oldTiles_1bc = ref.offset(4, 0x1bc).cast(Pointer.deferred(4, UnboundedArrayRef.of(0x4, TileAttributes04::new)));
    this._1c0 = ref.offset(4, 0x1c0).cast(IntRef::new);

    this._1c6 = ref.offset(2, 0x1c6).cast(UnsignedShortRef::new);
    this._1c8 = ref.offset(4, 0x1c8).cast(IntRef::new);
    this._1cc = ref.offset(4, 0x1cc).cast(IntRef::new);

    this._1d8 = ref.offset(2, 0x1d8).cast(ShortRef::new);
    this._1da = ref.offset(2, 0x1da).cast(ShortRef::new);
    this._1dc = ref.offset(2, 0x1dc).cast(ShortRef::new);
    this._1de = ref.offset(2, 0x1de).cast(ShortRef::new);
    this.actor_1e0 = ref.offset(4, 0x1e0).cast(Pointer.deferred(4, Actor70::new));

    this.actorIndex_1f4 = ref.offset(4, 0x1f4).cast(IntRef::new);
    this._1f8 = ref.offset(4, 0x1f8).cast(Pointer.deferred(4, Panel24::new));
    this._1fc = ref.offset(4, 0x1fc).cast(Pointer.deferred(4, Panel24::new));
    this._200 = ref.offset(4, 0x200);
    this._218 = ref.offset(4, 0x218);

    this.panel_230 = ref.offset(4, 0x230).cast(Pointer.deferred(4, Panel24::new));

    this._236 = ref.offset(2, 0x236);

    this._776 = ref.offset(2, 0x776);

    this._cb6 = ref.offset(2, 0xcb6).cast(ShortRef::new);
    this._cb8 = ref.offset(2, 0xcb8).cast(ShortRef::new);

    this._cc0 = ref.offset(2, 0xcc0).cast(ShortRef::new);
    this._cc2 = ref.offset(2, 0xcc2).cast(ShortRef::new);
    this._cc4 = ref.offset(2, 0xcc4).cast(ShortRef::new);
    this._cc6 = ref.offset(1, 0xcc6).cast(ByteRef::new);
    this._cc7 = ref.offset(1, 0xcc7).cast(ByteRef::new);
    this.soundId_cc8 = ref.offset(2, 0xcc8).cast(ShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub08 implements MemoryRef {
    private final Value ref;

    public final Pointer<Actor70> actor_00;
    public final UnsignedByteRef _04;

    public final ByteRef x_06;
    public final ByteRef z_07;

    public Sub08(final Value ref) {
      this.ref = ref;

      this.actor_00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, Actor70::new));
      this._04 = ref.offset(1, 0x04).cast(UnsignedByteRef::new);

      this.x_06 = ref.offset(1, 0x06).cast(ByteRef::new);
      this.z_07 = ref.offset(1, 0x07).cast(ByteRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
