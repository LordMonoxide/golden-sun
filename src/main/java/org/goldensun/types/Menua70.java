package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Menua70 implements MemoryRef {
  private final Value ref;

  public final IntRef _08;
  public final Pointer<Panel24> panel_0c;
  public final Pointer<Panel24> panel_10;
  public final ArrayRef<Pointer<GraphicsStruct1c>> _14;
  public final ArrayRef<ByteRef> _1c;
  public final ArrayRef<UnsignedByteRef> _1e;
  public final Pointer<Panel24> panel_20;
  public final Pointer<Panel24> panel_24;
  public final Pointer<Panel24> panel_28;
  public final Pointer<Panel24> panel_2c;
  public final Pointer<Panel24> panel_30;
  public final Pointer<Panel24> panel_34;
  public final Pointer<Panel24> panel_38;
  public final Pointer<Panel24> panel_3c;
  public final Pointer<Panel24> panel_40;
  public final GraphicsStruct1c _44;
  public final ArrayRef<Pointer<GraphicsStruct1c>> _48;

  public final Pointer<Panel24> panel_10c;

  public final UnsignedByteRef _110;
  public final UnsignedByteRef _111;
  public final UnsignedByteRef _112;
  public final UnsignedByteRef _113;
  public final ArrayRef<Pointer<Sprite38>> charSprites_114;
  public final ArrayRef<ShortRef> _134;
  public final ArrayRef<ShortRef> _144;
  public final ArrayRef<IntRef> _154;
  public final ArrayRef<UnsignedShortRef> _174;
  public final ArrayRef<ShortRef> abilityId_178;
  public final Pointer<GraphicsStruct1c> _17c;

  /** TODO ptr */
  public final IntRef _184;

  public final ArrayRef<UnsignedShortRef> items_1c8;
  public final ArrayRef<UnsignedShortRef> partyMemberIds_208;
  public final UnsignedByteRef itemCount_218;
  public final UnsignedByteRef partyMemberCount_219;
  public final ArrayRef<UnsignedByteRef> _21a;
  public final Pointer<GraphicsStruct1c> _21c;
  public final UnsignedShortRef _220;
  public final UnsignedShortRef _222;
  public final ArrayRef<Pointer<Sprite38>> _224;
  public final ArrayRef<ShortRef> _234;
  public final ArrayRef<ShortRef> _23c;
  public final ArrayRef<IntRef> _244;
  public final ArrayRef<UnsignedByteRef> _254;
  public final ArrayRef<UnsignedByteRef> _256;
  public final ArrayRef<UnsignedByteRef> _258;
  public final ShortRef _25a;
  public final ByteRef _25c;
  public final ByteRef _25d;

  public final ArrayRef<UnsignedByteRef> _260;
  public final UnsignedByteRef _268;

  /** TODO */
  public final Value _36c;

  public final Pointer<GraphicsStruct1c> _380;

  public final UnsignedShortRef vramSlot_390;
  public final UnsignedShortRef downArrow_392;
  public final UnsignedShortRef upArrow_394;

  public final UnsignedShortRef spriteDataIndex_3a4;

  public final ByteRef _3a7;
  public final ByteRef _3a8;
  public final ByteRef _3a9;
  public final ByteRef _3aa;
  public final ByteRef _3ab;
  public final ByteRef _3ac;

  public final ArrayRef<FieldPsynergy720.Sub48> _3b0;

  public Menua70(final Value ref) {
    this.ref = ref;

    this._08 = ref.offset(4, 0x08).cast(IntRef::new);
    this.panel_0c = ref.offset(4, 0x0c).cast(Pointer.deferred(4, Panel24::new));
    this.panel_10 = ref.offset(4, 0x10).cast(Pointer.deferred(4, Panel24::new));
    this._14 = ref.offset(4, 0x14).cast(ArrayRef.of(Pointer.classFor(GraphicsStruct1c.class), 2, 0x4, Pointer.deferred(4, GraphicsStruct1c::new)));
    this._1c = ref.offset(1, 0x1c).cast(ArrayRef.of(ByteRef.class, 2, 0x1, ByteRef::new));
    this._1e = ref.offset(1, 0x1e).cast(ArrayRef.of(UnsignedByteRef.class, 2, 0x1, UnsignedByteRef::new));
    this.panel_20 = ref.offset(4, 0x20).cast(Pointer.deferred(4, Panel24::new));
    this.panel_24 = ref.offset(4, 0x24).cast(Pointer.deferred(4, Panel24::new));
    this.panel_28 = ref.offset(4, 0x28).cast(Pointer.deferred(4, Panel24::new));
    this.panel_2c = ref.offset(4, 0x2c).cast(Pointer.deferred(4, Panel24::new));
    this.panel_30 = ref.offset(4, 0x30).cast(Pointer.deferred(4, Panel24::new));
    this.panel_34 = ref.offset(4, 0x34).cast(Pointer.deferred(4, Panel24::new));
    this.panel_38 = ref.offset(4, 0x38).cast(Pointer.deferred(4, Panel24::new));
    this.panel_3c = ref.offset(4, 0x3c).cast(Pointer.deferred(4, Panel24::new));
    this.panel_40 = ref.offset(4, 0x40).cast(Pointer.deferred(4, Panel24::new));
    this._44 = ref.offset(4, 0x44).cast(GraphicsStruct1c::new);
    this._48 = ref.offset(4, 0x48).cast(ArrayRef.of(Pointer.classFor(GraphicsStruct1c.class), 32, 0x4, Pointer.deferred(4, GraphicsStruct1c::new)));

    this.panel_10c = ref.offset(4, 0x10c).cast(Pointer.deferred(4, Panel24::new));

    this._110 = ref.offset(1, 0x110).cast(UnsignedByteRef::new);
    this._111 = ref.offset(1, 0x111).cast(UnsignedByteRef::new);
    this._112 = ref.offset(1, 0x112).cast(UnsignedByteRef::new);
    this._113 = ref.offset(1, 0x113).cast(UnsignedByteRef::new);
    this.charSprites_114 = ref.offset(4, 0x114).cast(ArrayRef.of(Pointer.classFor(Sprite38.class), 8, 0x4, Pointer.deferred(4, Sprite38::new)));
    this._134 = ref.offset(2, 0x134).cast(ArrayRef.of(ShortRef.class, 8, 0x2, ShortRef::new));
    this._144 = ref.offset(2, 0x144).cast(ArrayRef.of(ShortRef.class, 8, 0x2, ShortRef::new));
    this._154 = ref.offset(4, 0x154).cast(ArrayRef.of(IntRef.class, 8, 0x4, IntRef::new));
    this._174 = ref.offset(2, 0x174).cast(ArrayRef.of(UnsignedShortRef.class, 2, 0x2, UnsignedShortRef::new));
    this.abilityId_178 = ref.offset(2, 0x178).cast(ArrayRef.of(ShortRef.class, 2, 0x2, ShortRef::new));
    this._17c = ref.offset(4, 0x17c).cast(Pointer.deferred(4, GraphicsStruct1c::new));

    this._184 = ref.offset(4, 0x184).cast(IntRef::new);

    this.items_1c8 = ref.offset(2, 0x1c8).cast(ArrayRef.of(UnsignedShortRef.class, 0x20, 0x2, UnsignedShortRef::new));
    this.partyMemberIds_208 = ref.offset(2, 0x208).cast(ArrayRef.of(UnsignedShortRef.class, 8, 0x2, UnsignedShortRef::new));
    this.itemCount_218 = ref.offset(1, 0x218).cast(UnsignedByteRef::new);
    this.partyMemberCount_219 = ref.offset(1, 0x219).cast(UnsignedByteRef::new);
    this._21a = ref.offset(1, 0x21a).cast(ArrayRef.of(UnsignedByteRef.class, 2, 0x1, UnsignedByteRef::new));
    this._21c = ref.offset(4, 0x21c).cast(Pointer.deferred(4, GraphicsStruct1c::new));
    this._220 = ref.offset(2, 0x220).cast(UnsignedShortRef::new);
    this._222 = ref.offset(2, 0x222).cast(UnsignedShortRef::new);
    this._224 = ref.offset(4, 0x224).cast(ArrayRef.of(Pointer.classFor(Sprite38.class), 4, 0x4, Pointer.deferred(4, Sprite38::new)));
    this._234 = ref.offset(2, 0x234).cast(ArrayRef.of(ShortRef.class, 4, 0x2, ShortRef::new));
    this._23c = ref.offset(2, 0x23c).cast(ArrayRef.of(ShortRef.class, 4, 0x2, ShortRef::new));
    this._244 = ref.offset(4, 0x244).cast(ArrayRef.of(IntRef.class, 4, 0x4, IntRef::new));
    this._254 = ref.offset(1, 0x254).cast(ArrayRef.of(UnsignedByteRef.class, 2, 0x1, UnsignedByteRef::new));
    this._256 = ref.offset(1, 0x256).cast(ArrayRef.of(UnsignedByteRef.class, 2, 0x1, UnsignedByteRef::new));
    this._258 = ref.offset(1, 0x258).cast(ArrayRef.of(UnsignedByteRef.class, 2, 0x1, UnsignedByteRef::new));
    this._25a = ref.offset(2, 0x25a).cast(ShortRef::new);
    this._25c = ref.offset(1, 0x25c).cast(ByteRef::new);
    this._25d = ref.offset(1, 0x25d).cast(ByteRef::new);

    this._260 = ref.offset(1, 0x260).cast(ArrayRef.of(UnsignedByteRef.class, 8, 0x1, UnsignedByteRef::new));
    this._268 = ref.offset(1, 0x268).cast(UnsignedByteRef::new);

    this._36c = ref.offset(2, 0x36c);

    this._380 = ref.offset(4, 0x380).cast(Pointer.deferred(4, GraphicsStruct1c::new));

    this.vramSlot_390 = ref.offset(2, 0x390).cast(UnsignedShortRef::new);
    this.downArrow_392 = ref.offset(2, 0x392).cast(UnsignedShortRef::new);
    this.upArrow_394 = ref.offset(2, 0x394).cast(UnsignedShortRef::new);

    this.spriteDataIndex_3a4 = ref.offset(2, 0x3a4).cast(UnsignedShortRef::new);

    this._3a7 = ref.offset(1, 0x3a7).cast(ByteRef::new);
    this._3a8 = ref.offset(1, 0x3a8).cast(ByteRef::new);
    this._3a9 = ref.offset(1, 0x3a9).cast(ByteRef::new);
    this._3aa = ref.offset(1, 0x3aa).cast(ByteRef::new);
    this._3ab = ref.offset(1, 0x3ab).cast(ByteRef::new);
    this._3ac = ref.offset(1, 0x3ac).cast(ByteRef::new);

    this._3b0 = ref.offset(4, 0x3b0).cast(ArrayRef.of(FieldPsynergy720.Sub48.class, 18, 0x48, FieldPsynergy720.Sub48::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
