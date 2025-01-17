package org.goldensun;

import org.goldensun.battle.BattleStruct82c;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.GraphicsStruct28;
import org.goldensun.types.Item2c;
import org.goldensun.types.Map194;
import org.goldensun.types.Panel24;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.SaveStruct1100;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Struct12fc;
import org.goldensun.types.Structccc;
import org.goldensun.types.TileAttributes04;
import org.goldensun.types.Unit14c;
import org.goldensun.types.Vec3;
import org.goldensun.types.Vec3s;

import javax.annotation.Nullable;

import static org.goldensun.GoldenSun.FUN_8005ac0;
import static org.goldensun.GoldenSun.allocateSpriteSlot;
import static org.goldensun.GoldenSun.FUN_80045e8;
import static org.goldensun.GoldenSun.FUN_80053e8;
import static org.goldensun.GoldenSun.FUN_8005a78;
import static org.goldensun.GoldenSun.FUN_800fec8;
import static org.goldensun.GoldenSun.FUN_800ff54;
import static org.goldensun.GoldenSun.addRotScaleParams;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.disableTickCallback;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.divideU;
import static org.goldensun.GoldenSun.drawSprite_;
import static org.goldensun.GoldenSun.enableTickCallback;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.insertIntoRenderQueue;
import static org.goldensun.GoldenSun.loadSaveList;
import static org.goldensun.GoldenSun.loadSavePreview;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.saveGame;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.unloadSaveList;
import static org.goldensun.GoldenSunVars._200044c;
import static org.goldensun.GoldenSunVars._3001c9c;
import static org.goldensun.GoldenSunVars._3001cd0;
import static org.goldensun.GoldenSunVars._3001cfc;
import static org.goldensun.GoldenSunVars._3001d08;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars._80134fc;
import static org.goldensun.GoldenSunVars.accumulatedButtons_3001af8;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.mapId_2000400;
import static org.goldensun.GoldenSunVars.playerMapActorIndex_2000434;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.ticks_3001800;
import static org.goldensun.GoldenSunVars.tileAttribs_2010000;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.GoldenSun_802.FUN_8021620;
import static org.goldensun.GoldenSun_802.FUN_80216b4;
import static org.goldensun.GoldenSun_802.FUN_80216e8;
import static org.goldensun.GoldenSun_802.FUN_8021750;
import static org.goldensun.GoldenSun_802.FUN_80217a4;
import static org.goldensun.GoldenSun_802.FUN_8028df4;
import static org.goldensun.GoldenSun_802.drawSaveMenu;
import static org.goldensun.GoldenSun_802.handleAMenu;
import static org.goldensun.GoldenSun_807.calculateBuildDate_;
import static org.goldensun.GoldenSun_807.getAbility_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_807.getDjinnCount_;
import static org.goldensun.GoldenSun_807.getItem_;
import static org.goldensun.GoldenSun_807.getPartyMemberIds_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_808.FUN_808a278;
import static org.goldensun.GoldenSun_808.FUN_808a5f0;
import static org.goldensun.GoldenSun_808.getInteractedTileType_;
import static org.goldensun.GoldenSun_808.getRoomNameStringId_;
import static org.goldensun.GoldenSun_80a.FUN_80a1038;
import static org.goldensun.GoldenSun_80a.FUN_80a1040;
import static org.goldensun.GoldenSun_80a.handleItemMenu_;
import static org.goldensun.GoldenSun_80a.handlePsynergyMenu_;
import static org.goldensun.GoldenSun_80a.handleStatusMenu_;
import static org.goldensun.GoldenSun_80b.FUN_80b0020;
import static org.goldensun.GoldenSun_80b.FUN_80b0030;
import static org.goldensun.GoldenSun_80b.FUN_80b0038;
import static org.goldensun.GoldenSun_80b.getBattleChars_;
import static org.goldensun.GoldenSun_80b.FUN_80b5130;
import static org.goldensun.GoldenSun_80f.FUN_80f9048;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_801 {
  private GoldenSun_801() { }

  /** Causes the first map to shake */
  @Method(0x8010000)
  public static void FUN_8010000() {
    final Map194 r8 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Vec3 r1_0 = r8._00.derefNullable();
    if(r1_0 != null) {
      //LAB_8010024
      int r7 = r1_0.getX() + 0xff880000;
      int r6 = r1_0.getZ() - r1_0.getY() + 0xffa00000;
      final int r12 = r8._04.get();
      final int r5 = r8._08.get();
      final int r0 = r8._ec.get() + r12;
      final int lr = r8._f0.get() + r5;
      int r1 = r8._f4.get() - r12 + 0xff100000;
      int r3 = r8._f8.get() - r5 + 0xff600000;

      if(r1 < r0) {
        r1 = r0;
      }

      //LAB_801006e
      if(r3 < lr) {
        r3 = lr;
      }

      //LAB_8010074
      if(r7 < r0) {
        r7 = r0;
      }

      //LAB_801007a
      if(r7 > r1) {
        r7 = r1;
      }

      //LAB_8010080
      if(r6 < lr) {
        r6 = lr;
      }

      //LAB_8010086
      if(r6 > r3) {
        r6 = r3;
      }

      //LAB_801008c
      if(r12 != 0) {
        r7 = r7 + (int)MEMORY.call(0x3000118, r8._04.get(), rand() - rand());
        r8._04.set((int)MEMORY.call(0x3000118, r8._04.get(), r8._0c.get()));
      }

      //LAB_80100c4
      if(r5 != 0) {
        r6 = r6 + (int)MEMORY.call(0x3000118, r8._08.get(), rand() - rand());
        r8._08.set((int)MEMORY.call(0x3000118, r8._08.get(), r8._0c.get()));
      }

      //LAB_80100fa
      r8._e4.set(r7);
      r8._e8.set(r6);

      //LAB_8010112
      for(int r10 = 0; r10 < 3; r10++) {
        final Map194.Sub30 r4 = r8.layers_104.get(r10);
        r7 = (int)MEMORY.call(0x3000118, r8._e4.get(), r4._10.get());
        r6 = (int)MEMORY.call(0x3000118, r8._e8.get(), r4._14.get());

        if(r4._18.get() != 0) {
          r4._20.add(r4._18.get());
          r7 = r7 + r4._20.get() & (r4._28.get() << 19 | 0x7ffff);
        }

        //LAB_8010142
        if(r4._1c.get() != 0) {
          r4._24.add(r4._1c.get());
          r6 = r6 + r4._24.get() & (r4._2a.get() << 19 | 0x7ffff);
        }

        //LAB_801015a
        r7 = r7 + r4._08.get();
        r6 = r6 + r4._0c.get();
        final int r8_0 = r7 / 0x80000;
        final int r5_0 = r6 / 0x80000;

        if(((r4._00.get() ^ r7) & 0x80000) != 0) {
          //LAB_80101a4
          FUN_800ff54(r10, r4._00.get() < r7 ? r8_0 + 30 : r8_0, r5_0);
        }

        //LAB_80101aa
        if(((r4._04.get() ^ r6) & 0x100000) != 0) {
          //LAB_80101d2
          FUN_800fec8(r10, r8_0, r4._04.get() < r6 ? r5_0 + 20 : r5_0);
        }

        //LAB_80101d8
        MEMORY.ref(2, 0x3001ad0 + (3 - r10) * 0x4).setu(r7 >> 16);
        MEMORY.ref(2, 0x3001ad2 + (3 - r10) * 0x4).setu(r6 >> 16);
        r4._00.set(r7);
        r4._04.set(r6);
      }
    }

    //LAB_80101fe
  }

  @Method(0x8010230)
  public static void FUN_8010230(int r0, final int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r11;

    r7 = r0;
    final Map194 sp14 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    r0 = r1 - 0x600000;
    r3 = sp14._ec.get();
    r7 = r7 - 0x780000;
    if(r7 < r3) {
      r7 = r3;
    }

    //LAB_8010266
    r3 = sp14._f4.get();
    r3 = r3 - 0xf00000;
    if(r7 > r3) {
      r7 = r3;
    }

    //LAB_8010276
    r3 = sp14._f0.get();
    if(r0 < r3) {
      r0 = r3;
    }

    //LAB_8010282
    r3 = sp14._f8.get();
    r3 = r3 - 0xa00000;
    if(r0 > r3) {
      r0 = r3;
    }

    //LAB_8010292
    sp14._e4.set(r7);
    sp14._e8.set(r0);

    //LAB_80102a6
    for(int sp1c = 0; sp1c < 3; sp1c++) {
      final Map194.Sub30 lr = sp14.layers_104.get(sp1c);
      if(sp14._100.get(sp1c).get() == 0) {
        break;
      }

      //LAB_80102b8
      r4 = 0x16;
      r7 = (int)MEMORY.call(0x3000118, sp14._e4.get(), lr._10.get());
      r0 = (int)MEMORY.call(0x3000118, sp14._e8.get(), lr._14.get());

      r2 = lr._18.get();
      if(r2 != 0) {
        lr._20.add(r2);
        r7 = r7 + lr._20.get() & (lr._28.get() << 19 | 0x7ffff);
      }

      //LAB_80102f4
      r2 = lr._1c.get();
      if(r2 != 0) {
        lr._24.add(r2);
        r0 = r0 + lr._24.get() & (lr._2a.get() << 19 | 0x7ffff);
        r4 = 0x20;
      }

      //LAB_8010312
      r7 = (r7 + lr._08.get()) / 0x80000;
      r0 = (r0 + lr._0c.get()) / 0x80000;
      r6 = (r0 / 2 & 0x7f) * 0x80;
      r11 = r4 >> 1;
      final int sp18 = 0x6002800 + sp1c * 0x800;
      r5 = (r0 & 0x1e) * 0x20;
      final int sp08 = r7 / 2;

      //LAB_8010370
      for(r8 = 0; r8 < r11; r8++) {
        r4 = sp08 & 0x7f;
        r0 = r7 & 0x1e;

        //LAB_8010380
        for(int r12 = 0; r12 < 0x10; r12++) {
          final int sp04 = tileAttribs_2010000.get(r6 + r4).getTile() * 0x8;
          final int sp00 = sp18 + (r5 + r0) * 0x2;
          MEMORY.ref(4, sp00).setu(MEMORY.ref(4, 0x2020000 + sp04).get());
          MEMORY.ref(4, sp00 + 0x40).setu(MEMORY.ref(4, 0x2020004 + sp04).get());
          r4 = r4 + 1 & 0x7f;
          r0 = r0 + 2 & 0x1e;
        }

        r6 = r6 + 0x80 & 0x3f80;
        r5 = r5 + 0x40 & 0x3c0;
      }

      //LAB_80103da
    }

    //LAB_80103e6
  }

  @Method(0x8010424)
  public static void FUN_8010424(final int x1, final int y1, final int x2, final int y2, final int a4, final int a5) {
    final UnboundedArrayRef<TileAttributes04> sp08 = tileAttribs_2010000.slice(y1 * 0x80 + x1);
    final UnboundedArrayRef<TileAttributes04> sp04 = tileAttribs_2010000.slice(y2 * 0x80 + x2);
    final Map194 r2_0 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int[] r9 = new int[6];

    //LAB_801045e
    for(int i = 0; i < 3; i++) {
      r9[i * 2    ] = r2_0.layers_104.get(i)._00.get() >> 20;
      r9[i * 2 + 1] = r2_0.layers_104.get(i)._04.get() >> 20;
    }

    //LAB_801048a
    int tileIndex = 0;
    for(int y = y2; y < y2 + a5; y++) {
      //LAB_80104a2
      for(int x = x2; x < x2 + a4; x++) {
        final int tile = sp08.get(tileIndex).getTile();
        sp04.get(tileIndex).setTile(tile);
        tileIndex++;

        //LAB_80104d0
        final int r3_0 = (y & 0xf) * 0x20 + (x & 0xf);
        for(int i = 0; i < 3; i++) {
          if(x >= r9[i * 2] && x < r9[i * 2] + 16 && y >= r9[i * 2 + 1] && y < r9[i * 2 + 1] + 12) {
            MEMORY.ref(4, 0x6002800 + i * 0x800 + r3_0 * 0x4).setu(MEMORY.ref(4, 0x2020000 + tile * 0x8).get());
            MEMORY.ref(4, 0x6002840 + i * 0x800 + r3_0 * 0x4).setu(MEMORY.ref(4, 0x2020004 + tile * 0x8).get());
            break;
          }

          //LAB_8010504
        }

        //LAB_8010512
      }

      //LAB_8010518
      tileIndex += 0x80 - a4;
    }

    //LAB_801052c
  }

  @Method(0x8010560)
  public static void FUN_8010560(final int r0, final int r1, final int r2) {
    int r7 = r0;

    //LAB_8010580
    int r12;
    while((r12 = MEMORY.ref(2, r7).getUnsigned()) != 0xffff) {
      FUN_8010424(r12, MEMORY.ref(2, r7 + 0x2).get() & 0xffff, r1, r2, MEMORY.ref(2, r7 + 0x4).get() & 0xffff, MEMORY.ref(2, r7 + 0x6).get() & 0xffff);
      sleep(MEMORY.ref(2, r7 + 0x8).get() & 0xffff);
      r7 = r7 + 0xa;
    }

    //LAB_80105be
  }

  @Method(0x80105d4)
  public static void FUN_80105d4(final int x1, final int y1, final int x2, final int y2, final int x3, final int y3) {
    final UnboundedArrayRef<TileAttributes04> sp08 = tileAttribs_2010000.slice(y1 * 0x80 + x1);
    final UnboundedArrayRef<TileAttributes04> sp04 = tileAttribs_2010000.slice(y3 * 0x80 + x3);
    final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int[] r9 = new int[6];

    //LAB_8010612
    for(int r5 = 0; r5 < 3; r5++) {
      final Map194.Sub30 layer = map.layers_104.get(r5);
      r9[r5] = layer._00.get() >> 20;
      r9[r5 + 1] = layer._04.get() >> 20;
    }

    //LAB_801063a
    int tileIndex = 0;
    for(int y = y3; y < y3 + y2; y++) {
      //LAB_8010652
      for(int x = x3; x < x3 + x2; x++) {
        sp04.get(tileIndex).val_00.set(sp08.get(tileIndex).val_00.get());
        final int tile = sp08.get(tileIndex).getTile();
        final int r4 = ((y & 0xf) * 0x20 + (x & 0xf)) * 0x4;

        //LAB_8010678
        for(int r5 = 0; r5 < 3; r5++) {
          if(x >= r9[r5] && x < r9[r5] + 16 && y >= r9[r5 + 1] && y < r9[r5 + 1] + 12) {
            MEMORY.ref(4, 0x6002800 + r4 + r5 * 0x800).setu(MEMORY.ref(4, 0x2020000 + tile * 0x8).get());
            MEMORY.ref(4, 0x6002840 + r4 + r5 * 0x800).setu(MEMORY.ref(4, 0x2020004 + tile * 0x8).get());
            break;
          }
        }

        tileIndex++;
      }

      //LAB_80106c0
      tileIndex += 0x80 - x2;
    }

    //LAB_80106d4
  }

  @Method(0x8010704)
  public static void FUN_8010704(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    final UnboundedArrayRef<TileAttributes04> r10 = tileAttribs_2010000.slice(a5 * 0x80 + a4);
    final UnboundedArrayRef<TileAttributes04> r8 = tileAttribs_2010000.slice(r1 * 0x80 + r0);

    //LAB_8010732
    for(int r5 = 0; r5 < r3; r5++) {
      //LAB_8010748
      for(int r4 = 0; r4 < r2; r4++) {
        r10.get(r5 * 0x80 + r4).val_00.and(0xfff).or(r8.get(r5 * 0x80 + r4).val_00.get() & ~0xfff);
      }

      //LAB_8010762
    }

    //LAB_8010770
  }

  @Method(0x80108e4)
  public static int FUN_80108e4(int r0, int r1, final int r2, int r3, final int a4) {
    final Map194 r2_1 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    int r6 = r2_1.layers_104.get(0)._0c.get();
    final int r10 = r1 & 0x1;
    r0 = r0 * 2;
    final int r9 = r0;
    final int r8 = r2 & 0x1;
    final int r2_0 = r2_1.getAddress() + 0x338 + ((r9 + r8) * 0x2 + r10) * 0x2; //TODO huh?

    if(a4 == 0) {
      r0 = 0;
    }

    if(a4 == 0 && r3 == MEMORY.ref(2, r2_0).getUnsigned()) {
      return r0;
    }

    //LAB_8010932
    MEMORY.ref(2, r2_0).setu(r3);
    final int r7 = mallocSlotChip(14, 0x400);
    FUN_80053e8(r6 + MEMORY.ref(4, r6 + r3 * 0x4).get(), r7);
    final int r5 = 0x2020000 + ((r9 + r8) * 0x20 + r10) * 0x40;

    //LAB_801095e
    for(r6 = 0; r6 < 0x10; r6++) {
      DMA.channels[3].SAD.setu(r7 + r6 * 0x40);
      DMA.channels[3].DAD.setu(r5 + r6 * 0x80);
      DMA.channels[3].CNT.setu(0x84000010);
    }

    if(a4 != 0) {
      r1 = 0x6004000 + ((r9 + r8) * 0x40 + r10) * 0x20;

      //LAB_801098e
      for(r6 = 0; r6 < 0x10; r6++) {
        //LAB_8010990
        for(int i = 0; i < 0x10; i++) {
          r3 = MEMORY.ref(2, r7 + i * 0x4).getUnsigned();
          MEMORY.ref(2, r1).setu(tileAttribs_2010000.get(r3).val_00.get() & 0xffff);
          MEMORY.ref(2, r1 + 0x40).setu(tileAttribs_2010000.get(r3).val_00.get() >>> 16);
          r1 += 0x2;
        }

        r1 += 0x60;
      }
    }

    //LAB_80109b6
    freeSlot(14);

    //LAB_80109be
    return 1;
  }

  @Method(0x80109e8)
  public static void FUN_80109e8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80113e4)
  public static void FUN_80113e4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x8011498).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x10;
    r1 = CPU.movT(0x0);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
    r3 = MEMORY.ref(4, r3).get();
    if(r3 != 0) {
      r2 = MEMORY.ref(4, r3).get();
      r3 += 0x4;

      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
      r3 = MEMORY.ref(4, r3 + 0x4).get();
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    }

    //LAB_801140e
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get() - 0x1000000;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r3 = CPU.asrT(r3, 25);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    r3 = r1 - 0x1400000;
    r3 = CPU.asrT(r3, 25);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    CPU.r9().value = 0;
    CPU.r11().value = 0;

    //LAB_801142a
    do {
      r6 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      CPU.r10().value = 0;

      //LAB_8011430
      do {
        r3 = r6 & 0xf;
        r5 = 0;
        CPU.r8().value = r6;
        r7 = CPU.lslT(r3, 4);

        //LAB_801143c
        do {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r1 = CPU.addT(r3, r5);
          r3 = CPU.addT(r1, 0x0);
          r2 = CPU.movT(0xf);
          r3 = CPU.andT(r3, r2);
          r4 = CPU.addT(r7, r3);
          r2 = CPU.movT(0x9c);
          r3 = CPU.lslT(r4, 1);
          r2 = CPU.lslT(r2, 1);
          r3 = CPU.addT(r3, r2);
          r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r4 = MEMORY.ref(2, r2 + r3).getUnsigned();
          r3 = CPU.movT(0x1);
          r4 += CPU.r11().value;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r0 = CPU.r9().value;
          r2 = CPU.r8().value;
          r3 = CPU.addT(r4, 0x0);
          r5 = CPU.addT(r5, 0x1);
          FUN_80108e4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
          CPU.cmpT(r5, 0x1);
        } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

        r3 = CPU.movT(0x1);
        CPU.r10().value += r3;
        r1 = CPU.r10().value;
        r6 = CPU.addT(r6, 0x1);
        CPU.cmpT(r1, 0x1);
      } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

      r2 = CPU.movT(0xa0);
      CPU.r9().value += r3;
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.r9().value;
      CPU.r11().value += r2;
      CPU.cmpT(r3, 0x1);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8011590)
  public static void FUN_8011590() {
    final int r5 = boardWramMallocHead_3001e50.offset(7 * 0x4).get();
    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    r7._fc.set(0x1);
    disableTickCallback(getRunnable(GoldenSun_801.class, "FUN_801179c"));
    DMA.channels[3].SAD.setu(0x6004000);
    DMA.channels[3].DAD.setu(0x201c000);
    DMA.channels[3].CNT.setu(0x84000800);

    sleep(1);
    FUN_8012388(r5 + (_3001e40.get() & 0x1) * 0x1400 + 0xc80, tileAttribs_2010000);
    r7._100.get(0).set(0xc8);
    r7._100.get(1).set(0);
    r7._100.get(2).set(0xff);
    r7._103.set(0);
    _3001cfc.set(0x8011569);
  }

  @Method(0x8011644)
  public static void FUN_8011644() {
    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int r5 = r7.layers_104.get(0)._18.get();
    final int r8 = MEMORY.ref(2, 0x5000000).get();
    FUN_80053e8(getPointerTableEntry(MEMORY.ref(4, r5).get()), tileAttribs_2010000.getAddress());
    MEMORY.ref(2, 0x2010000).setu(r8);
    DMA.channels[3].SAD.setu(tileAttribs_2010000.getAddress());
    DMA.channels[3].DAD.setu(0x5000000);
    DMA.channels[3].CNT.setu(0x84000070);

    decompress(getPointerTableEntry(MEMORY.ref(4, r5 + 0x4).get()), 0x2038000);
    decompress(getPointerTableEntry(MEMORY.ref(4, r5 + 0x8).get()), 0x203a000);
    decompress(getPointerTableEntry(MEMORY.ref(4, r5 + 0xc).get()), 0x203c000);
    decompress(getPointerTableEntry(MEMORY.ref(4, r5 + 0x10).get()), 0x203e000);

    _3001cfc.set(0x801161c); //TODO function
    r7._100.get(0).set(0);
    r7._100.get(1).set(0);
    r7._100.get(2).set(0x9f);
    r7._103.set(0);
    sleep(1);
    decompress(getPointerTableEntry(213), 0x2010000);
    FUN_80113e4();
    r7._fc.set(0);
    enableTickCallback(getRunnable(GoldenSun_801.class, "FUN_801179c"));
    sleep(1);
  }

  @Method(0x801179c)
  public static void FUN_801179c() {
    int r0;
    int r1;
    int r2;
    int r4;

    final Map194 r8 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    //LAB_80117c0
    for(int i = 0; i < 0x10; i++) {
      final Map194.Sub0c r5 = r8._18.get(i);

      if(r5._00.get() != 0 && r5._0a.get() == 0) {
        //LAB_80117cc
        do {
          if(r5._08.get() != 0) {
            //LAB_801186c
            r5._08.decr();
            break;
          }

          r4 = r5._04.get();
          r0 = MEMORY.ref(2, r4).getUnsigned();
          r4 += 0x2;
          if(r0 == 0xffff) {
            r5._04.set(r5._00.get());
          } else {
            //LAB_80117e4
            if((r0 & 0xff00) != 0xfe00) {
              //LAB_8011804
              r2 = MEMORY.ref(2, r4).getUnsigned();
              r4 += 0x2;
              r1 = MEMORY.ref(2, r4).getUnsigned();
              r5._08.set(MEMORY.ref(2, r4 + 0x2).getUnsigned());
              if(r8._16.get() == 0) {
                if(r0 >= 0x600) {
                  r0 = 0x201c000 + r0 * 0x20;
                } else {
                  //LAB_801182e
                  r0 = 0x6004000 + r0 * 0x20;
                }

                r1 = 0x6004000 + r1 * 0x20;
                r2 = r2 * 0x8;
              } else {
                //LAB_801183c
                if(r0 >= 0x200) {
                  r0 = 0x2020000 + r0 * 0x40;
                } else {
                  //LAB_8011852
                  r0 = 0x6008000 + r0 * 0x40;
                }

                //LAB_801185c
                r1 = 0x6008000 + r1 * 0x40;
                r2 = r2 * 0x10;
              }

              //LAB_801185e
              DMA.channels[3].SAD.setu(r0);
              DMA.channels[3].DAD.setu(r1);
              DMA.channels[3].CNT.setu(0x84000000 | r2);

              r5._04.add(0x8);
            } else {
              r2 = r0 & 0xff;
              if(r2 == 0xff) {
                break;
              }
              r5._04.set(r5._00.get() + r2 * 0x4);
            }
          }
        } while(true);
      }

      //LAB_8011872
    }
  }

  @Method(0x80118a8)
  public static void FUN_80118a8(final int r0) {
    boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._18.get(r0)._0a.set(0);
  }

  @Method(0x80118c0)
  public static void FUN_80118c0(final int r0) {
    boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._18.get(r0)._0a.set(0x1);
  }

  @Method(0x80118d8)
  public static void FUN_80118d8(final int r0) {
    final Map194 r5 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r5._18.getAddress());
    DMA.channels[3].CNT.setu(0x85000030);

    int r4 = r0;
    int r6 = 0;

    int r1 = MEMORY.ref(2, r4).getUnsigned();
    r4 += 0x2;

    //LAB_801191a
    while(r1 != 0xffff) {
      if((r1 & 0xff00) == 0xfd00) {
        final int r0_0;
        if((r1 & 0x80) != 0) {
          r0_0 = 1;
        } else {
          r0_0 = 0;
        }

        //LAB_8011936
        final Map194.Sub0c r3 = r5._18.get(r1 & 0xf);
        r3._00.set(r4);
        r3._04.set(r4);
        r3._08.set(0);
        r3._0a.set(r0_0);
        r6++;
      }

      //LAB_801194a
      r1 = MEMORY.ref(2, r4).getUnsigned();
      r4 += 0x2;
    }

    //LAB_8011954
    if(r6 != 0) {
      setTickCallback(getRunnable(GoldenSun_801.class, "FUN_801179c"), 0xc80);
    }

    //LAB_8011962
    CPU.sp().value += 0x4;
  }

  @Method(0x8011984)
  public static void FUN_8011984() {
    if(boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._fc.get() == 0) {
      disableTickCallback(getRunnable(GoldenSun_801.class, "FUN_801179c"));
    }

    //LAB_801199c
  }

  @Method(0x80119a8)
  public static void FUN_80119a8() {
    if(boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._fc.get() == 0) {
      enableTickCallback(getRunnable(GoldenSun_801.class, "FUN_801179c"));
    }

    //LAB_80119c0
  }

  @Method(0x80119cc)
  public static void FUN_80119cc() {
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Map194.Sub0c r4 = r3._d8;

    if(r4._00.get() != 0 && r4._0a.get() == 0) {
      //LAB_80119e4
      do {
        if(r4._08.get() != 0) {
          //LAB_8011a60
          r4._08.decr();
          break;
        }

        int r0 = r4._04.get();
        final int r1 = MEMORY.ref(2, r0).getUnsigned();
        r0 += 0x2;

        if(r1 == 0xffff) {
          r4._04.set(r4._00.get());
          //LAB_80119fe
        } else if((r1 & 0xff00) == 0xfe00) {
          final int r2 = r1 & 0xff;
          if(r2 == 0xff) {
            break;
          }

          r4._04.set(r4._00.get() + r2 * 0x4);
          //LAB_8011a1e
        } else if((r1 & 0xf000) == 0x3000) {
          GPU.BLDCNT.setu(r1);
          r3._103.set(r1 & 0xff);
          r4._04.add(0x2);
        } else {
          //LAB_8011a3e
          if((r3._103.get() & 0xc0) == 0x40) {
            GPU.BLDALPHA.setu(r1);
          } else {
            //LAB_8011a50
            GPU.BLDY.setu(r1);
          }

          //LAB_8011a52
          r4._08.set(MEMORY.ref(2, r0).getUnsigned());
          r4._04.add(0x4);
        }
      } while(true);
    }

    //LAB_8011a66
  }

  @Method(0x8011a84)
  public static void FUN_8011a84(final int r0) {
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Map194.Sub0c r4 = r3._d8;

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r4.getAddress());
    DMA.channels[3].CNT.setu(0x85000003);
    CPU.sp().value += 0x4;

    if(MEMORY.ref(2, r0).getUnsigned() != 0xffff) {
      r4._00.set(r0);
      r4._04.set(r0);
      r4._08.set(0);
      r4._0a.set(0);
      setTickCallback(getRunnable(GoldenSun_801.class, "FUN_80119cc"), 0xc80);
    }

    //LAB_8011ac2
  }

  @Method(0x8011ae0)
  public static void FUN_8011ae0() {
    disableTickCallback(getRunnable(GoldenSun_801.class, "FUN_80119cc"));
  }

  @Method(0x8011ce0)
  public static int FUN_8011ce0(int r0, final int r1, final int r2) {
    r0 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.lslT(r0, 24);
    r0 = CPU.asrT(r0, 24);
    r0 = CPU.lslT(r0, 19);
    return r0;
  }

  @Method(0x8011cec)
  public static int FUN_8011cec(final int r0, final int r1, int r2) {
    r2 = MEMORY.ref(1, r0).get() << 19;
    return r2 + r1 * ((MEMORY.ref(1, r0 + 0x1).get() << 19) - r2) / 0x10;
  }

  @Method(0x8011d10)
  public static int FUN_8011d10(final int r0, int r1, final int r2) {
    r1 = MEMORY.ref(1, r0).get() << 19;
    final int r3 = MEMORY.ref(1, r0 + 0x1).get() << 19;
    return r1 + r2 * (r3 - r1) / 0x10;
  }

  @Method(0x8011d34)
  public static int FUN_8011d34(int r0, int r1, final int r2) {
    final int r4;

    r4 = MEMORY.ref(1, r0).get() << 19;
    r0 = MEMORY.ref(1, r0 + 0x1).get() << 19;
    r1 = r1 + r2;
    if(r1 == 0xf) {
      return Math.max(r0, r4);
    }

    //LAB_8011d54
    CPU.cmpT(r1, 0xe);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      return r4;
    }

    //LAB_8011d5a
    return r0;
  }

  @Method(0x8011d60)
  public static int FUN_8011d60(int r0, int r1, int r2) {
    int r3;
    final int r4;
    final int r5;

    r3 = CPU.movT(0x0);
    r3 = MEMORY.ref(1, r0 + r3).get();
    r4 = CPU.lslT(r3, 19);
    r3 = CPU.movT(0x1);
    r3 = MEMORY.ref(1, r0 + r3).get();
    r0 = CPU.lslT(r3, 19);
    r5 = CPU.addT(r2, 0x0);
    r2 = CPU.addT(r4, 0x0);
    r0 = CPU.cmpT(r0, r4);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r2 = CPU.addT(r0, 0x0);
    }

    //LAB_8011d78
    r3 = CPU.subT(r5, r1);
    r1 = CPU.addT(r3, 0x0);
    r1 = CPU.addT(r1, 0xf);
    CPU.cmpT(r1, 0xf);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r2, 0x0);
    } else {
      //LAB_8011d86
      CPU.cmpT(r1, 0xe);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r0 = CPU.addT(r4, 0x0);
      }
    }

    //LAB_8011d8c
    return r0;
  }

  @Method(0x8011e2c)
  public static int FUN_8011e2c(int r0, int r1, int r2) {
    int r3;
    int r4;
    r3 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(1, r3).get();
    r4 = MEMORY.ref(1, r3 + 0x1).get();
    r2 = CPU.lslT(r2, 4);
    r1 = CPU.addT(r1, r2);
    r0 = CPU.lslT(r0, 19);
    r3 = MEMORY.ref(1, 0x80132fc + r1).getUnsigned();
    r4 = CPU.lslT(r4, 19);
    r4 = CPU.subT(r4, r0);
    r3 = CPU.mulT(r3, r4);
    r0 = CPU.addT(r0, r3);
    return r0;
  }

  @Method(0x8011e50)
  public static int FUN_8011e50(int r0, final int r1, final int r2) {
    CPU.cmpT(r1, 0x7);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r0 = MEMORY.ref(1, r0).get();
    } else {
      //LAB_8011e5e
      r0 = MEMORY.ref(1, r0 + 0x1).get();
    }

    //LAB_8011e64
    return r0 << 19;
  }

  @Method(0x8011e6c)
  public static int FUN_8011e6c(int r0, final int r1, final int r2) {
    CPU.cmpT(r2, 0x7);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r0 = MEMORY.ref(1, r0).get();
    } else {
      //LAB_8011e7a
      r0 = MEMORY.ref(1, r0 + 0x1).get();
    }

    //LAB_8011e80
    return r0 << 19;
  }

  @Method(0x8011f14)
  public static int FUN_8011f14(final int r0, final int r1, final int r2) {
    return MEMORY.ref(1, r0 + MEMORY.ref(1, 0x80133fc + r1 + r2 * 0x10).getUnsigned()).get() << 19;
  }

  @Method(0x8011f28)
  public static int FUN_8011f28(final int r0, final int r1, final int r2) {
    final int r3 = MEMORY.ref(1, 0x80133fc + r2 * 0x10 - r1 + 0xf).getUnsigned();
    return MEMORY.ref(1, r0 + r3).get() << 19;
  }

  @Method(0x8011f54)
  public static int getHeight(final int mapLayer, final int x, final int z) {
    final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final UnboundedArrayRef<TileAttributes04> tiles;
    if(map != null) {
      tiles = map.layers_104.get(mapLayer & 0x3).tiles_2c.deref();
    } else {
      tiles = tileAttribs_2010000;
    }

    final int r5 = x >> 16;
    final int r6 = z >> 16;

    //LAB_8011f7a
    final int r1_1 = tiles.get(r6 / 0x10 * 0x80 + r5 / 0x10).getHeight() * 0x4;
    return _80134fc.get(MEMORY.ref(1, 0x202c000 + r1_1).getUnsigned() & 0xf).deref().run(0x202c001 + r1_1, r5 & 0xf, r6 & 0xf);
  }

  @Method(0x8011fd8)
  public static int FUN_8011fd8(final int mapLayer, final int x, final int z) {
    final Map194 r5 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    final UnboundedArrayRef<TileAttributes04> tiles;
    if(r5 != null) {
      tiles = r5.layers_104.get(mapLayer & 0x3).tiles_2c.deref();
    } else {
      tiles = tileAttribs_2010000;
    }

    //LAB_8011ffe
    return MEMORY.ref(1, 0x202c000 + tiles.get((x >> 16) / 0x10 + (z >> 16) / 0x10 * 0x80).getHeight() * 0x4).getUnsigned() & 0xf;
  }

  @Method(0x8012038)
  public static int getTileType(final int mapLayer, final int x, final int z) {
    final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    final UnboundedArrayRef<TileAttributes04> tiles;
    if(map != null) {
      tiles = map.layers_104.get(mapLayer & 0x3).tiles_2c.deref();
    } else {
      tiles = tileAttribs_2010000;
    }

    //LAB_801205e
    return tiles.get((z >> 20) * 0x80 + (x >> 20)).getType();
  }

  @Method(0x8012078)
  public static void FUN_8012078(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80120dc)
  public static int FUN_80120dc(final Actor70 r0, final Vec3 r1) {
    final int r5 = r1.getX() >> 16;
    final int r6 = r1.getZ() >> 16;
    final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    if(map == null) {
      return 0;
    }

    final int layer = r0.layer_22.get();
    final TileAttributes04 tileAttribs;
    if(layer < 3) {
      tileAttribs = map.layers_104.get(layer).tiles_2c.deref().get(r5 / 0x10 + r6 / 0x10 * 0x80);
    } else {
      //LAB_801210e
      tileAttribs = tileAttribs_2010000.get(r5 / 0x10 + r6 / 0x10 * 0x80);
    }

    //LAB_8012110
    if(tileAttribs.getType() == 0xff) {
      return 2;
    }

    final int height = tileAttribs.getHeight();
    final int r0_0 = _80134fc.get(MEMORY.ref(1, 0x202c000 + height * 0x4).getUnsigned() & 0xf).deref().run(0x202c001 + height * 0x4, r5 & 0xf, r6 & 0xf) - r0._14.get();
    if(r0_0 > 0x80000) {
      return 1;
    }

    if(r0_0 < -0xc0000) {
      return -1;
    }

    //LAB_801217c
    return 0;
  }

  @Method(0x801219c)
  public static int FUN_801219c(final Vec3 vec) {
    final int r4 = vec.getX() / 0x10000;
    final int r0 = (vec.getZ() - vec.getY()) / 0x10000;

    final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    if(map == null) {
      return 0;
    }

    //LAB_80121c6
    final int r3 = map.layers_104.get(2).tiles_2c.deref().get(r0 / 0x10 * 0x80 + r4 / 0x10).getTile() ^ 0xff;
    return ((-r3 | r3) >>> 31) - 1;
  }

  @Method(0x8012204)
  public static int FUN_8012204(final Vec3 r0) {
    final int halfX = r0.getX() >> 17;
    final int halfZ = r0.getZ() >> 17;
    final int r5 = (halfZ / 8 & 0x3f) * 0x40 + (halfX / 8 & 0x3f);
    final int r4 = (halfZ / 2 & 0x3) * 0x2 + (halfX / 4 & 0x1);
    int r2 = MEMORY.ref(1, 0x202c800 + r4 + MEMORY.ref(1, 0x6005000 + r5).getUnsigned() * 0x8).getUnsigned();
    if(r2 != 0) {
      final int r0_0;
      if((halfX & 0x2) == 0) {
        r0_0 = r2 & 0xf;
      } else {
        r0_0 = r2 >>> 4;
      }

      //LAB_801226a
      if(r0_0 != 0) {
        return r0_0;
      }
    }

    //LAB_801226e
    r2 = MEMORY.ref(1, 0x202c000 + r4 + MEMORY.ref(1, 0x6004000 + r5).getUnsigned() * 0x8).getUnsigned();
    if(r2 == 0) {
      return 7;
    }

    final int r0_0;
    if((halfX & 0x2) == 0) {
      r0_0 = r2 & 0xf;
    } else {
      r0_0 = r2 >>> 4;
    }

    //LAB_8012290
    if(r0_0 == 0) {
      //LAB_8012294
      return 7;
    }

    //LAB_8012296
    return r0_0;
  }

  @Method(0x80122c8)
  public static int FUN_80122c8(final Vec3 vec, final int r1) {
    final int r7 = FUN_8012204(vec);

    final int r0 = 0x2020000 + ((vec.getZ() / 0x200000 & 0x1f) * 0x20 + (vec.getX() / 0x200000 & 0x1f)) * 0x4;

    int r4 = 0;
    if((MEMORY.ref(1, r0 + 0x3).getUnsigned() & 0x80) != 0) {
      r4 = 0x10;
    }

    //LAB_801230a
    MEMORY.ref(4, r1).setu(MEMORY.ref(4, r0).get() << 1 >>> 25);

    if(MEMORY.ref(4, r1).get() == 0x15) {
      r4 = 0x20;
    }

    //LAB_8012318
    return MEMORY.ref(1, 0x801353c + r4 + r7).getUnsigned();
  }

  @Method(0x8012330)
  public static void FUN_8012330(final int r0, final int r1, final int r2) {
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    if(r0 >= 0) {
      r3._04.set(r0);
    }

    //LAB_801233c
    if(r1 >= 0) {
      r3._08.set(r1);
    }

    //LAB_8012342
    if(r2 >= 0) {
      r3._0c.set(r2);
    }

    //LAB_8012348
  }

  @Method(0x8012350)
  public static void FUN_8012350() {
    int r6;

    final Map194 r5 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    r6 = 0;

    //LAB_801235c
    //LAB_801236e
    while(r5._04.get() > 0xff || r5._08.get() > 0xff) {
      sleep(1);

      r6++;
      if(r6 >= 0x12c) {
        break;
      }
    }

    //LAB_8012378
    r5._0c.set(0);
  }

  @Method(0x8012388)
  public static void FUN_8012388(final int r0, final UnboundedArrayRef<TileAttributes04> r1) {
    final int size = 0x27c;
    final int addr = mallocSlotChip(49, size);
    DMA.channels[3].SAD.setu(0x8009e7c);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 0x4);

    final int r4 = boardWramMallocHead_3001e50.offset(49 * 0x4).get();
    MEMORY.call(r4, r0, r1, 0x203c000, 0x201d000);
    freeSlot(49);
  }

  /** {@link GoldenSun_801#FUN_8015f30} */
  @Method(0x8015000)
  public static void FUN_8015000() {
    MEMORY.call(0x8015f30);
  }

  /** {@link GoldenSun_801#FUN_8016018} */
  @Method(0x8015008)
  public static void FUN_8015008(final int r0) {
    MEMORY.call(0x8016018, r0);
  }

  /** {@link GoldenSun_801#addPanel} */
  @Method(0x8015010)
  public static Panel24 addPanel_(final int x, final int y, final int w, final int h, final int flags) {
    return (Panel24)MEMORY.call(0x80162d4, x, y, w, h, flags);
  }

  /** {@link GoldenSun_801#FUN_8016418} */
  @Method(0x8015018)
  public static void FUN_8015018(@Nullable final Panel24 r0, final int r1) {
    MEMORY.call(0x8016418, r0, r1);
  }

  @Method(0x8015020)
  public static void FUN_8015020(final int r0, final int r1) {
    FUN_801964c(r0, r1);
  }

  /** {@link GoldenSun_801#decompressString} */
  @Method(0x8015028)
  public static void decompressString_(final int stringId, final int out, final int len) {
    MEMORY.call(0x80196c4, stringId, out, len);
  }

  /** {@link GoldenSun_801#FUN_8017658} */
  @Method(0x8015038)
  public static Panel24 FUN_8015038(final int r0, final int r1, final int r2, final int r3) {
    return (Panel24)MEMORY.call(0x8017658, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_801#FUN_801776c} */
  @Method(0x8015040)
  public static void FUN_8015040(final int r0, final int r1) {
    MEMORY.call(0x801776c, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8017364} */
  @Method(0x8015048)
  public static int FUN_8015048() {
    return (int)MEMORY.call(0x8017364);
  }

  /** {@link GoldenSun_801#FUN_8017394} */
  @Method(0x8015050)
  public static int FUN_8015050(final Panel24 r0) {
    return (int)MEMORY.call(0x8017394, r0);
  }

  /** {@link GoldenSun_801#FUN_8017620} */
  @Method(0x8015058)
  public static void FUN_8015058(final int r0) {
    MEMORY.call(0x8017620, r0);
  }

  /** {@link GoldenSun_801#FUN_8016478} */
  @Method(0x8015060)
  public static void FUN_8015060(final Panel24 r0) {
    MEMORY.call(0x8016478, r0);
  }

  /** {@link GoldenSun_801#FUN_80164d4} */
  @Method(0x8015068)
  public static void FUN_8015068(final Panel24 panel, final int x0, final int y0, final int x1, final int y1) {
    MEMORY.call(0x80164d4, panel, x0, y0, x1, y1);
  }

  /** {@link GoldenSun_801#FUN_801e41c} */
  @Method(0x8015070)
  public static void FUN_8015070(final Panel24 r0, final int x, final int y, final int w, final int h) {
    MEMORY.call(0x801e41c, r0, x, y, w, h);
  }

  /** {@link GoldenSun_801#FUN_801e74c} */
  @Method(0x8015078)
  public static void FUN_8015078(final int r0, final Panel24 panel, final int x, final int y) {
    MEMORY.call(0x801e74c, r0, panel, x, y);
  }

  /** {@link GoldenSun_801#drawIcon} */
  @Method(0x8015080)
  public static void drawIcon_(final int iconId, final Panel24 panel, final int x, final int y) {
    MEMORY.call(0x801e7c0, iconId, panel, x, y);
  }

  /** {@link GoldenSun_801#FUN_801e8b0} */
  @Method(0x8015090)
  public static void FUN_8015090(final int string, final Panel24 panel, final int x, final int y) {
    MEMORY.call(0x801e8b0, string, panel, x, y);
  }

  /** {@link GoldenSun_801#FUN_801e940} */
  @Method(0x8015098)
  public static void FUN_8015098(final int string, final Panel24 panel, final int x, final int y) {
    MEMORY.call(0x801e940, string, panel, x, y);
  }

  /** {@link GoldenSun_801#drawNumber} */
  @Method(0x80150a8)
  public static void drawNumber_(final int number, final int digits, final Panel24 panel, final int x, final int y) {
    MEMORY.call(0x801e9d4, number, digits, panel, x, y);
  }

  /** {@link GoldenSun_801#FUN_801ea08} */
  @Method(0x80150b0)
  public static void FUN_80150b0(final int number, final int digits, final Panel24 panel, final int x, final int y) {
    MEMORY.call(0x801ea08, number, digits, panel, x, y);
  }

  /** {@link GoldenSun_801#FUN_801e71c} */
  @Method(0x80150b8)
  public static void FUN_80150b8(final int r0) {
    MEMORY.call(0x801e71c, r0);
  }

  /** {@link GoldenSun_801#FUN_801eadc} */
  @Method(0x80150c8)
  public static GraphicsStruct1c FUN_80150c8(final int vramSlot, final int r1, final Panel24 r2, final int x, final int y) {
    return (GraphicsStruct1c)MEMORY.call(0x801eadc, vramSlot, r1, r2, x, y);
  }

  /** {@link GoldenSun_801#FUN_801eb64} */
  @Method(0x80150d0)
  public static GraphicsStruct1c FUN_80150d0(final int r0, final int r1, final Panel24 r2, final int r3, final int a4) {
    return (GraphicsStruct1c)MEMORY.call(0x801eb64, r0, r1, r2, r3, a4);
  }

  /** {@link GoldenSun_801#FUN_801ec6c} */
  @Method(0x80150d8)
  public static GraphicsStruct1c FUN_80150d8(final int r0, final int r1, final int r2, final Panel24 r3, final int a4, final int a5) {
    return (GraphicsStruct1c)MEMORY.call(0x801ec6c, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun_801#FUN_801ed40} */
  @Method(0x80150e0)
  public static void FUN_80150e0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x801ed40, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8019da8} */
  @Method(0x80150f8)
  public static Panel24 FUN_80150f8(final int spriteDataIndex, final int r1, final int x, final int y) {
    return (Panel24)MEMORY.call(0x8019da8, spriteDataIndex, r1, x, y);
  }

  /** {@link GoldenSun_801#FUN_8019e48} */
  @Method(0x8015100)
  public static void FUN_8015100(final int r0) {
    MEMORY.call(0x8019e48, r0);
  }

  /** {@link GoldenSun_801#FUN_80187ac} */
  @Method(0x8015108)
  public static int FUN_8015108(final int r0, final int r1, final int r2, final int r3, final int a4) {
    return (int)MEMORY.call(0x80187ac, r0, r1, r2, r3, a4);
  }

  /** {@link GoldenSun_801#FUN_80187fc} */
  @Method(0x8015110)
  public static int FUN_8015110(final int r0, final int r1, final int r2, final int r3, final int a4) {
    return (int)MEMORY.call(0x80187fc, r0, r1, r2, r3, a4);
  }

  /** {@link GoldenSun_801#FUN_80198dc} */
  @Method(0x8015118)
  public static void FUN_8015118() {
    MEMORY.call(0x80198dc);
  }

  /** {@link GoldenSun_801#FUN_8019908} */
  @Method(0x8015120)
  public static void FUN_8015120(final int r0, final int r1) {
    MEMORY.call(0x8019908, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_801ef08} */
  @Method(0x8015128)
  public static void FUN_8015128(final int r0) {
    MEMORY.call(0x801ef08, r0);
  }

  /** {@link GoldenSun_801#FUN_801f200} */
  @Method(0x8015130)
  public static void FUN_8015130(final int r0) {
    MEMORY.call(0x801f200, r0);
  }

  /** {@link GoldenSun_801#FUN_801f5d4} */
  @Method(0x8015138)
  public static void FUN_8015138() {
    MEMORY.call(0x801f5d4);
  }

  /** {@link GoldenSun_801#FUN_8019a54} */
  @Method(0x8015140)
  public static void FUN_8015140() {
    MEMORY.call(0x8019a54);
  }

  /** {@link GoldenSun_802#FUN_8027114} */
  @Method(0x80151c0)
  public static int FUN_80151c0(final BattleStruct82c.Turn10 r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x8027114, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_80175a0} */
  @Method(0x80151c8)
  public static void FUN_80151c8(final int r0) {
    MEMORY.call(0x80175a0, r0);
  }

  /** {@link GoldenSun_801#FUN_80174f8} */
  @Method(0x80151d0)
  public static void FUN_80151d0(final int r0) {
    MEMORY.call(0x80174f8, r0);
  }

  /** {@link GoldenSun_801#FUN_8019d2c} */
  @Method(0x80151e0)
  public static int FUN_80151e0(final int r0) {
    return (int)MEMORY.call(0x8019d2c, r0);
  }

  /** {@link GoldenSun_801#handleIngameMenus} */
  @Method(0x80151e8)
  public static void handleIngameMenus_() {
    MEMORY.call(0x801c244);
  }

  /** {@link GoldenSun_802#handleTitleScreenChoiceMenu} */
  @Method(0x80151f0)
  public static int handleTitleScreenChoiceMenu_() {
    return (int)MEMORY.call(0x80289e8);
  }

  /** {@link GoldenSun_801#FUN_801c34c} */
  @Method(0x8015200)
  public static void FUN_8015200() {
    MEMORY.call(0x801c34c);
  }

  /** {@link GoldenSun_801#FUN_801c428} */
  @Method(0x8015208)
  public static void FUN_8015208() {
    MEMORY.call(0x801c428);
  }

  /** {@link GoldenSun_801#FUN_8019aa0} */
  @Method(0x8015210)
  public static void FUN_8015210(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8019aa0, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_80174d8} */
  @Method(0x8015218)
  public static void FUN_8015218() {
    MEMORY.call(0x80174d8);
  }

  /** {@link GoldenSun_801#FUN_801c0dc} */
  @Method(0x8015228)
  public static void FUN_8015228(final int r0, final int r1) {
    MEMORY.call(0x801c0dc, r0, r1);
  }

  /** {@link GoldenSun_801#queueRenderPacketXy} */
  @Method(0x8015230)
  public static void queueRenderPacketXy_(final RenderPacket0c renderPacket, final int x, final int y) {
    MEMORY.call(0x801c154, renderPacket, x, y);
  }

  /** {@link GoldenSun_801#clearVramSlot2} */
  @Method(0x8015238)
  public static void clearVramSlot2_(final int vramSlot) {
    MEMORY.call(0x801c17c, vramSlot);
  }

  /** {@link GoldenSun_801#FUN_801edec} */
  @Method(0x8015268)
  public static void FUN_8015268(final int r0) {
    MEMORY.call(0x801edec, r0);
  }

  /** {@link GoldenSun_801#drawPanelBackground} */
  @Method(0x8015270)
  public static void drawPanelBackground_(final Panel24 panel) {
    MEMORY.call(0x8016498, panel);
  }

  /** {@link GoldenSun_801#FUN_80164ac} */
  @Method(0x8015278)
  public static void FUN_8015278(@Nullable final Panel24 panel) {
    MEMORY.call(0x80164ac, panel);
  }

  /** {@link GoldenSun_801#FUN_8019000} */
  @Method(0x8015280)
  public static void FUN_8015280(final Panel24 r0, final int r1, final int r2, final int r3, final int a4) {
    MEMORY.call(0x8019000, r0, r1, r2, r3, a4);
  }

  @Method(0x8015288)
  public static int FUN_8015288() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015290)
  public static int FUN_8015290() {
    throw new RuntimeException("Not implemented");
  }

  /** {@link GoldenSun_801#FUN_801bcd4} */
  @Method(0x8015298)
  public static int FUN_8015298(final int r0, final int itemId, final int vramSlot, final int r3) {
    return (int)MEMORY.call(0x801bcd4, r0, itemId, vramSlot, r3);
  }

  /** {@link GoldenSun_801#FUN_801e318} */
  @Method(0x80152a8)
  public static void FUN_80152a8() {
    MEMORY.call(0x801e318);
  }

  /** {@link GoldenSun_802#FUN_802281c} */
  @Method(0x80152b8)
  public static void FUN_80152b8(final int r0) {
    MEMORY.call(0x802281c, r0);
  }

  /** {@link GoldenSun_802#loadLoadGameMenu} */
  @Method(0x80152f0)
  public static int loadLoadGameMenu_(final int mode) {
    return (int)MEMORY.call(0x80208e4, mode);
  }

  /** {@link GoldenSun_801#FUN_801fba8} */
  @Method(0x80152f8)
  public static int FUN_80152f8() {
    return (int)MEMORY.call(0x801fba8);
  }

  /** {@link GoldenSun_801#FUN_801f77c} */
  @Method(0x8015318)
  public static int FUN_8015318() {
    return (int)MEMORY.call(0x801f77c);
  }

  /** {@link GoldenSun_802#FUN_8020bd8} */
  @Method(0x8015320)
  public static int FUN_8015320(final int r0) {
    return (int)MEMORY.call(0x8020bd8, r0);
  }

  /** {@link GoldenSun_801#FUN_801ccc0} */
  @Method(0x8015360)
  public static void FUN_8015360(final int r0, final int r1) {
    MEMORY.call(0x801ccc0, r0, r1);
  }

  /** {@link GoldenSun_802#FUN_8029504} */
  @Method(0x8015370)
  public static int FUN_8015370() {
    return (int)MEMORY.call(0x8029504);
  }

  /** {@link GoldenSun_802#FUN_8028db4} */
  @Method(0x8015388)
  public static int FUN_8015388(final int defaultOption) {
    return (int)MEMORY.call(0x8028db4, defaultOption);
  }

  /** {@link GoldenSun_802#FUN_8028df4} */
  @Method(0x8015390)
  public static int FUN_8015390(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(0x8028df4, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_802#FUN_8028e54} */
  @Method(0x80153b0)
  public static int FUN_80153b0(final int x, final int y, final int defaultOption) {
    return (int)MEMORY.call(0x8028e54, x, y, defaultOption);
  }

  /** {@link GoldenSun_801#FUN_801e3c8} */
  @Method(0x80153e0)
  public static void FUN_80153e0(final int r0) {
    MEMORY.call(0x801e3c8, r0);
  }

  /** {@link GoldenSun_802#FUN_8021bc8} */
  @Method(0x80153f0)
  public static int FUN_80153f0(final int r0) {
    return (int)MEMORY.call(0x8021bc8, r0);
  }

  /** {@link GoldenSun_801#drawPanelBackground} */
  @Method(0x8015408)
  public static void drawPanelBackground_(final int x, final int y, final int w, final int h) {
    MEMORY.call(0x80170f8, x, y, w, h);
  }

  /** {@link GoldenSun_801#clearPanelBuffer} */
  @Method(0x8015410)
  public static void FUN_8015410(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8016178, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_802#FUN_80219c8} */
  @Method(0x8015418)
  public static void FUN_8015418(final int r0) {
    MEMORY.call(0x80219c8, r0);
  }

  /** {@link GoldenSun_802#FUN_8021390} */
  @Method(0x8015420)
  public static void FUN_8015420(final int charId) {
    MEMORY.call(0x8021390, charId);
  }

  /** {@link GoldenSun_802#FUN_8021488} */
  @Method(0x8015428)
  public static void FUN_8015428(final int r0, final int r1) {
    MEMORY.call(0x8021488, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_801a370} */
  @Method(0x8015250)
  public static void FUN_8015250(final int itemId) {
    MEMORY.call(0x801a370, itemId);
  }

  /** {@link GoldenSun_801#FUN_801fc84} */
  @Method(0x8015300)
  public static int FUN_8015300() {
    return (int)MEMORY.call(0x801fc84);
  }

  /** {@link GoldenSun_801#FUN_801f730} */
  @Method(0x8015400)
  public static int FUN_8015400(final int r0) {
    return (int)MEMORY.call(0x801f730, r0);
  }

  @Method(0x80155d0)
  public static int FUN_80155d0(final Panel24 panel, int r1, int r2, int r3, final int a4) {
    int r4;
    int r5 = 0; // uninitialized
    int r6;
    int r7;

    int address80155d0 = CPU.sp().value - 0x1c;
    CPU.sp().value = address80155d0;
    address80155d0 += 0x4;
    address80155d0 += 0x4;
    address80155d0 += 0x4;
    MEMORY.ref(4, address80155d0).setu(CPU.r8().value);
    address80155d0 += 0x4;
    MEMORY.ref(4, address80155d0).setu(CPU.r9().value);
    address80155d0 += 0x4;
    MEMORY.ref(4, address80155d0).setu(CPU.r10().value);
    address80155d0 += 0x4;
    MEMORY.ref(4, address80155d0).setu(CPU.lr().value);
    r7 = r3;
    CPU.sp().value = CPU.sp().value - 0x2c;
    r3 = a4;
    CPU.r9().value = r2;
    CPU.r12().value = r1 - 0x20;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(panel.h_0a.get());

    int r0;
    CPU.cmpA(CPU.r12().value, 0x6f);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = 0x1;
    } else {
      if(r1 >= 0 && r1 < 0x100 || r3 != 0 && r1 >= 0xde && r1 < 0xe0) {
        //LAB_801561c
        CPU.cmpA(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = r3 + (r1 << 5);
          MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
          r1 = 0x1100;
          r1 = r1 + 0x11;
          r2 = 0x3300;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
          r2 = r2 + 0x33;
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
          r2 = 0x0;
          r3 = MEMORY.ref(1, 0x80370d4 + CPU.r12().value).getUnsigned();
          CPU.cmpA(r7, 0x1f);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            CPU.r10().value = 0x2500;
            CPU.r10().value = CPU.r10().value + 0x6000000;

            //LAB_8015664
            do {
              CPU.lr().value = 0x0;
              r4 = r2 + 0x1;
              r3 = r7 + r2;
              CPU.r8().value = r3 >>> 3;
              r3 = r3 & 0x7;
              r6 = r3 << 1;

              //LAB_801567c
              do {
                CPU.tstA(CPU.lr().value, 0x1);
                r5 = r5 >>> 4;
                if(CPU.cpsr().getZero()) { // ==
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x18).getUnsigned();
                  r5 = MEMORY.ref(1, r3).getUnsigned();
                  r3 = r3 + 0x1;
                  MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
                }
                r3 = r5 & 0xd;
                CPU.cmpA(r3, 0x1);
                if(CPU.cpsr().getZero()) { // ==
                  r3 = r5 & 0xf;
                  CPU.cmpA(r3, 0x1);
                  CPU.r12().value = MEMORY.ref(4, CPU.sp().value + 0x10).getUnsigned();
                  r1 = CPU.r9().value + CPU.lr().value;
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x14).getUnsigned();
                  r2 = r1 >>> 3;
                  if(CPU.cpsr().getZero()) { // ==
                    CPU.r12().value = r0;
                  }
                  CPU.cmpA(r2, 0x1d);
                  if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).getUnsigned();
                    r3 = r0 - 0x2;
                    r0 = r3 * r2 + CPU.r8().value;
                    r3 = r1 & 0x7;
                    r3 = r6 | r3 >>> 2;
                    r1 = r1 & 0x3;
                    r1 = r1 << 2;
                    r0 = CPU.r10().value + (r0 << 5);
                    r0 = r0 | r3 << 1;
                    r3 = 0xf;
                    r2 = MEMORY.ref(2, r0).getUnsigned();
                    r3 = r3 << r1;
                    r2 = r2 & ~r3;
                    r3 = r3 & CPU.r12().value;
                    r2 = r2 | r3;
                    MEMORY.ref(2, r0).setu(r2);
                  }
                }

                //LAB_8015700
                CPU.lr().value = CPU.lr().value + 0x1;
                CPU.cmpA(CPU.lr().value, 0x7);
              } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

              r2 = r4;
              CPU.cmpA(r4, 0x7);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                break;
              }
              r3 = r7 + r4;
              CPU.cmpA(r3, 0x1f);
            } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
          }

          //LAB_8015724
          final int address8015724 = CPU.sp().value + 0xc;
          r0 = MEMORY.ref(4, address8015724).getUnsigned();
          CPU.sp().value = CPU.sp().value + 0x2c;
          int address80158e0 = CPU.sp().value;
          address80158e0 += 0x4;
          address80158e0 += 0x4;
          address80158e0 += 0x4;
          CPU.r8().value = MEMORY.ref(4, address80158e0).getUnsigned();
          address80158e0 += 0x4;
          CPU.r9().value = MEMORY.ref(4, address80158e0).getUnsigned();
          address80158e0 += 0x4;
          CPU.r10().value = MEMORY.ref(4, address80158e0).getUnsigned();
          address80158e0 += 0x4;
          CPU.lr().value = MEMORY.ref(4, address80158e0).getUnsigned();
          address80158e0 += 0x4;
          CPU.sp().value = address80158e0;
          return r0;
        }

        //LAB_801572c
        CPU.lr().value = r1 - 0xde;
        r3 = CPU.r12().value + (CPU.r12().value << 1);
        r3 = CPU.r12().value + (r3 << 2);
        r3 = r3 << 1;
        r1 = r3 + 0x8032224;
        r1 = r1 + 0x2;
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(r1);
      } else {
        //LAB_8015750
        r3 = r1 - 0x20;
        r3 = r3 << 5;
        r0 = r3 + 0x8032224;
        r0 = r0 + 0x8;
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(r0);
      }

      //LAB_8015768
      r0 = MEMORY.ref(2, 0x8032224 + r3).getUnsigned();
      CPU.cmpA(CPU.lr().value, 0x1);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        CPU.r9().value = CPU.r9().value - 0x3;
        r7 = r7 - 0x2;
        r1 = 0x0;
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
      } else {
        //LAB_8015788
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
      }

      //LAB_801578c
      r2 = MEMORY.ref(4, CPU.sp().value + 0x24).getUnsigned();
      r1 = 0x0;
      r2 = r2 + 0x2;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);

      //LAB_801579c
      do {
        CPU.cmpA(r1, 0x3);
        if(CPU.cpsr().getZero()) { // ==
          r5 = 0x1111;
        } else {
          r5 = 0x5555;
        }
        r3 = panel.flags_16.get();
        CPU.tstA(r3, 0x40);
        if(!CPU.cpsr().getZero()) { // !=
          CPU.cmpA(r1, 0x1);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            if(CPU.cpsr().getZero()) { // ==
              CPU.r9().value = CPU.r9().value + 0x2;
            } else {
              CPU.r9().value = CPU.r9().value - 0x1;
            }
          } else {
            //LAB_80157d8
            CPU.cmpA(r1, 0x2);
            if(CPU.cpsr().getZero()) { // ==
              CPU.r9().value = CPU.r9().value - 0x1;
              r7 = r7 + 0x1;
            } else {
              //LAB_80157f4
              r7 = r7 - 0x1;
            }
          }
        }

        //LAB_80157f8
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4).getUnsigned();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x24).getUnsigned();
        r2 = 0x0;
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
        CPU.cmpA(r7, 0x1f);
        CPU.r12().value = MEMORY.ref(2, r0).getUnsigned();
        r1 = r1 + 0x1;
        MEMORY.ref(4, CPU.sp().value).setu(r1);
        CPU.r12().value = CPU.r12().value << 16;
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r6 = 0x2500;
          r6 = r6 + 0x6000000;

          //LAB_8015828
          do {
            CPU.lr().value = 0x0;
            r4 = r2 + 0x1;
            r3 = r7 + r2;
            CPU.r10().value = r3 >>> 3;
            r3 = r3 & 0x7;
            CPU.r8().value = r3 << 1;

            //LAB_8015840
            do {
              CPU.cmpA(CPU.r12().value, 0x0);
              if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                r1 = CPU.r9().value + CPU.lr().value;
                r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).getUnsigned();
                r2 = r1 >>> 3;
                r3 = r0 - 0x2;
                r0 = r3 * r2 + CPU.r10().value;
                r3 = r1 & 0x7;
                r3 = CPU.r8().value | r3 >>> 2;
                r1 = r1 & 0x3;
                r1 = r1 << 2;
                r0 = r6 + (r0 << 5);
                r0 = r0 | r3 << 1;
                r3 = 0xf;
                r2 = MEMORY.ref(2, r0).getUnsigned();
                r3 = r3 << r1;
                r2 = r2 & ~r3;
                r3 = r3 & r5;
                r2 = r2 | r3;
                MEMORY.ref(2, r0).setu(r2);
              }

              //LAB_8015890
              CPU.setCFlag((CPU.r12().value & 0x1 << 31) != 0);
              CPU.r12().value = CPU.movA(r0, CPU.r12().value << 1);
              if(CPU.cpsr().getZero()) { // ==
                break;
              }
              CPU.lr().value = CPU.lr().value + 0x1;
              CPU.cmpA(CPU.lr().value, 0xd);
            } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

            //LAB_80158a4
            r2 = r4;
            CPU.cmpA(r4, 0xb);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              break;
            }
            r1 = MEMORY.ref(4, CPU.sp().value + 0x8).getUnsigned();
            r3 = r7 + r4;
            CPU.r12().value = MEMORY.ref(2, r1).getUnsigned();
            r1 = r1 + 0x2;
            CPU.cmpA(r3, 0x1f);
            CPU.r12().value = CPU.r12().value << 16;
            MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
        }

        //LAB_80158cc
        r1 = MEMORY.ref(4, CPU.sp().value).getUnsigned();
        CPU.cmpA(r1, 0x3);
      } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

      r0 = MEMORY.ref(4, CPU.sp().value + 0x20).getUnsigned();
    }

    //LAB_80158dc
    CPU.sp().value = CPU.sp().value + 0x2c;
    int address80158e0 = CPU.sp().value;
    address80158e0 += 0x4;
    address80158e0 += 0x4;
    address80158e0 += 0x4;
    CPU.r8().value = MEMORY.ref(4, address80158e0).getUnsigned();
    address80158e0 += 0x4;
    CPU.r9().value = MEMORY.ref(4, address80158e0).getUnsigned();
    address80158e0 += 0x4;
    CPU.r10().value = MEMORY.ref(4, address80158e0).getUnsigned();
    address80158e0 += 0x4;
    CPU.lr().value = MEMORY.ref(4, address80158e0).getUnsigned();
    address80158e0 += 0x4;
    CPU.sp().value = address80158e0;
    return r0;
  }

  @Method(0x8015e8c)
  public static @Nullable GraphicsStruct1c FUN_8015e8c() {
    final Struct12fc r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final GraphicsStruct1c r0 = r3._d98.derefNullable();
    if(r0 != null) {
      final GraphicsStruct1c r2 = r0._00.derefNullable();
      if(r2 == null) {
        r3._d9c.set(r3._d98);
      }

      //LAB_8015ea8
      r3._d98.setNullable(r2);
      r0._00.clear();
    }

    //LAB_8015eae
    return r0;
  }

  @Method(0x8015ec0)
  public static void FUN_8015ec0(final GraphicsStruct1c r0) {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(r0.getAddress() >= r2._698.getAddress() && r0.getAddress() < r2._d98.getAddress()) {
      final Pointer<GraphicsStruct1c> r2_0 = r2._d9c.deref();
      r2._d9c.set(r0._00);
      r2_0.set(r0);
      r0._00.clear();
    }

    //LAB_8015ee6
  }

  @Method(0x8015ef4)
  public static void FUN_8015ef4() {
    final Struct12fc r0 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r0._d98.set(r0._698.get(0));

    //LAB_8015f08
    for(int i = 0; i < 0x3f; i++) {
      r0._698.get(i)._00.set(r0._698.get(i + 1));
    }

    r0._698.get(63)._00.clear();
    r0._d9c.set(r0._698.get(63)._00);
  }

  @Method(0x8015f30)
  public static void FUN_8015f30() {
    final Struct12fc addr = MEMORY.ref(4, mallocSlotBoard(15, 0x12fc), Struct12fc::new);

    CPU.sp().value -= 0x4;
    final int r5 = CPU.sp().value;
    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(addr.getAddress());
    DMA.channels[3].CNT.setu(0x850004bf);

    MEMORY.ref(4, r5).setu(0xf000f000);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(addr._00.getAddress());
    DMA.channels[3].CNT.setu(0x85000140);

    addr._ea3.set(0x1);
    addr._ea7.set(0xf);
    addr.vramSlot_12b6.set(0x63);

    FUN_8015ef4();
    FUN_8019d0c();
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_80160fc"), 0x480);
    FUN_80173f4();
    CPU.sp().value += 0x4;
  }

  @Method(0x8015fb8)
  public static void FUN_8015fb8(final int r0, final int r1) {
    final int r4 = (r1 & 0x3ff) * 0x20;
    DMA.channels[3].SAD.setu(0x6000010 + (r0 & 0x3ff) * 0x20);
    DMA.channels[3].DAD.setu(0x6000000 + r4);
    DMA.channels[3].CNT.setu(0x80000008);
    MEMORY.call(0x3000164, 0x600000c + r4, 0x14); // memzero
  }

  @Method(0x8016018)
  public static void FUN_8016018(final int r0) {
    CPU.push(CPU.r9().value);
    CPU.sp().value -= 0x4;
    final Struct12fc r5 = MEMORY.ref(4, mallocSlotBoard(15, 0x12fc), Struct12fc::new);
    final int r4 = CPU.sp().value;
    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r5.getAddress());
    DMA.channels[3].CNT.setu(0x850004bf);
    r5._ea3.set(1);
    r5.vramSlot_12b6.set(99);
    r5._ea5.set(1);
    r5._ea7.set(15);
    MEMORY.ref(4, r4).setu(0xf000f000);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r5.getAddress());
    DMA.channels[3].CNT.setu(0x85000140);
    FUN_8015ef4();
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_80160fc"), 0x480);
    FUN_8017464(r0);
    CPU.r9().value = CPU.sp().value + 0x4;
    FUN_8015fb8(0xf013, 0x80);
    CPU.r9().value = CPU.sp().value + 0x4;
    FUN_8015fb8(0xf014, 0x81);
    CPU.r9().value = CPU.sp().value + 0x4;
    FUN_8015fb8(0xf015, 0x82);

    //LAB_80160ac
    for(int i = 0; i < 3; i++) {
      r5._da0.get(i).set(4);
    }

    CPU.sp().value += 0x4;
    CPU.r9().value = CPU.pop();
  }

  /** Called from interrupt handler */
  @Method(0x80160fc)
  public static void FUN_80160fc() {
    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(r7._ea6.get() == 0) {
      int r4 = r7._ea3.get();
      if(r4 != 0) {
        if((r4 & 0x1) != 0) {
          r4 = 0x3f;
        }

        //LAB_8016126
        r4 = (r4 & 0x3f) >>> 1;

        //LAB_8016134
        for(int i = 0; r4 != 0; i++) {
          if((r4 & 0x1) != 0) {
            // Loads textbox backgrounds into vram
            DMA.channels[3].SAD.setu(r7._00.get(i).getAddress());
            DMA.channels[3].DAD.setu(0x6002000 + i * 0x100);
            DMA.channels[3].CNT.setu(0x84000040);
          }

          //LAB_801614a
          r4 = r4 >>> 1;
        }

        r7._ea3.set(0);
      }
    }

    //LAB_801615a
  }

  @Method(0x8016178)
  public static void clearPanelBuffer(final int baseX, final int baseY, final int w, final int h) {
    final Struct12fc r10 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int addr = r10._00.getAddress() + (baseY * 32 + baseX) * 0x2; //TODO
    final int adjustedW = MathHelper.clamp(w, 2, 30);
    final int adjustedH = MathHelper.clamp(baseY + h > 20 ? 20 - baseY : h, 2, 30);

    //LAB_80161be
    FUN_801e260(baseX, baseY, adjustedW, adjustedH);

    final int skip = (32 - adjustedW) * 0x2;

    //LAB_80161dc
    int tile = 0xf000; // palette 0xf
    for(int y = 0; y < adjustedH; y++) {
      if(r10._ea5.get() != 0) {
        if(baseY + y <= 16) {
          tile = 0xf000; // palette 0xf
        } else {
          tile = 0xf07f; // palette 0xf, tile 0x7f
        }
      }

      //LAB_80161f0
      //LAB_80161f6
      for(int x = 0; x < adjustedW; x++) {
        MEMORY.ref(2, addr).setu(tile);
        addr += 0x2;
      }

      //LAB_8016200
      addr += skip;
    }

    //LAB_8016208
    r10._ea3.set(0x1);
  }

  @Method(0x8016230)
  public static void FUN_8016230(final Panel24 r0) {
    r0._1a.set(0);

    final Struct12fc r10 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r2 = r0.flags_16.get();
    final int r5 = r0.x_0c.get();
    final int r6 = r0.y_0e.get();
    final int r7 = r0.w_08.get();
    final int r8 = r0.h_0a.get();

    if((r2 & 0x8) != 0) {
      if((r2 & 0x20) != 0) {
        drawPanelBackground(r5, r6, r7, r8);
        MEMORY.call(0x3000168, 0x6002500, 0xf00, 0x44444444);
      } else {
        //LAB_801627c
        MEMORY.call(0x3000168, 0x6002500, 0xf00, 0);
      }

      //LAB_801628a
      FUN_8017248(r5, r6, r7, r8, 0);
    } else {
      //LAB_801629c
      drawPanelBackground(r5, r6, r7, r8);
    }

    //LAB_80162a8
    r10._ea3.set(0x1);
  }

  @Method(0x80162d4)
  public static Panel24 addPanel(final int x, final int y, final int w, final int h, final int flags) {
    final Struct12fc addr = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    for(int i = 0; i < 8; i++) {
      final Panel24 struct = addr._500.get(i);

      if((struct.flags_16.get() & 0x1) == 0 && struct._1a.get() == 0) {
        //LAB_8016318
        struct._00.clear();
        struct._04.set(struct); // why?
        struct.x_0c.set(x);
        struct.y_0e.set(y);
        struct.w_08.set(w);
        struct.h_0a.set(h);
        struct._10.set(0x1);
        struct._14.set(0);
        struct.flags_16.set(0x1);
        FUN_80173ac();

        if((flags & 0x8) != 0) {
          struct.flags_16.or(0x8);
        }

        //LAB_8016352
        if((flags & 0x20) != 0) {
          struct.flags_16.or(0x20);
        }

        //LAB_8016362
        if((flags & 0x40) != 0) {
          struct.flags_16.or(0x40);
        }

        //LAB_8016380
        if((flags & 0x80) != 0) {
          struct.flags_16.or(0x80);
        }

        //LAB_8016390
        if((flags & 0x100) != 0) {
          struct.flags_16.or(0x100);
        }

        //LAB_80163a4
        if((flags & 0x2) != 0) {
          struct.flags_16.or(0x2);
          struct._18.set(0);
          struct._1a.set(0x1);
          FUN_8016230(struct);
        } else {
          //LAB_80163ce
          struct._18.set(0x7);
          struct._1a.set(0x8);
          FUN_80163ec(struct);
          sleep(1);
        }

        //LAB_80163e0
        return struct;
      }
    }

    return null;
  }

  @Method(0x80163ec)
  public static void FUN_80163ec(final Panel24 r0) {
    if((r0.flags_16.get() & 0x2) == 0) {
      //LAB_8016402
      while(r0._1a.get() != 0) {
        sleep(1);
      }
    }

    //LAB_8016410
  }

  @Method(0x8016418)
  public static void FUN_8016418(@Nullable final Panel24 panel, final int r1) {
    if(panel != null) {
      FUN_8016478(panel);
      panel.flags_16.set(0);
      panel.currentX_1c.set(panel.x_0c.get());
      panel.currentY_1e.set(panel.y_0e.get());
      panel.currentW_20.set(panel.w_08.get());
      panel.currentH_22.set(panel.h_0a.get());

      if(r1 != 0) {
        clearPanelBuffer(panel.x_0c.get(), panel.y_0e.get(), panel.w_08.get(), panel.h_0a.get());
        panel._00.clear();
        panel._04.clear();
        panel.w_08.set(0);
        panel.h_0a.set(0);
        panel.x_0c.set(0);
        panel.y_0e.set(0);
        panel._10.set(0);
        panel._12.set(0);
        panel._14.set(0);
        panel.flags_16.set(0);
        panel._18.set(0);
        panel._1a.set(0);
        panel.currentX_1c.set(0);
        panel.currentY_1e.set(0);
        panel.currentW_20.set(0);
        panel.currentH_22.set(0);
      } else {
        //LAB_801646c
        panel._18.set(r1);
        panel._1a.set(0x4);
      }
    }

    //LAB_8016472
  }

  @Method(0x8016478)
  public static void FUN_8016478(final Panel24 panel) {
    if((panel.flags_16.get() & 0x8) == 0) {
      drawPanelBackground(panel);
      FUN_80164ac(panel);
    }

    //LAB_8016490
  }

  @Method(0x8016498)
  public static void drawPanelBackground(final Panel24 panel) {
    drawPanelBackground(panel.x_0c.get(), panel.y_0e.get(), panel.w_08.get(), panel.h_0a.get());
  }

  @Method(0x80164ac)
  public static void FUN_80164ac(@Nullable final Panel24 panel) {
    if(panel != null) {
      GraphicsStruct1c r0 = panel._00.derefNullable();
      panel._04.set(panel);
      panel._00.clear();

      //LAB_80164c0
      while(r0 != null) {
        final GraphicsStruct1c r5 = r0._00.derefNullable();
        FUN_8016594(r0);
        r0 = r5;
      }
    }

    //LAB_80164cc
  }

  @Method(0x80164d4)
  public static void FUN_80164d4(final Panel24 panel, final int x0, final int y0, final int x1, final int y1) {
    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int left = panel.x_0c.get() + (x0 >>> 3);
    final int right = panel.x_0c.get() + (x1 + 7 >>> 3);
    final int top = panel.y_0e.get() + (y0 >>> 3);
    final int bottom = panel.y_0e.get() + (y1 + 7 >>> 3);
    final int r5 = left + 1;
    final int r7 = top + 1;
    final int width = right - left;
    final int height = bottom - top;
    FUN_801e260(r5, r7, width, height);
    int addr = r8._00.getAddress() + (r7 * 0x20 + r5) * 0x2;

    //LAB_801652e
    for(int y2 = 0; y2 < height; y2++) {
      //LAB_8016536
      for(int x2 = 0; x2 < width; x2++) {
        MEMORY.ref(2, addr).setu(0xf020);
        addr += 0x2;
      }

      //LAB_8016540
      addr += (32 - width) * 2;
    }

    //LAB_8016548
    r8._ea3.set(0x1);
  }

  @Method(0x8016584)
  public static void FUN_8016584(@Nullable final Panel24 r0, final GraphicsStruct1c r1) {
    if(r0 != null) {
      final Panel24 r3 = r0._04.deref();
      r3._00.set(r1);
      r0._04.setPointer(r1.getAddress()); //TODO huh?
    }

    //LAB_8016590
  }

  @Method(0x8016594)
  public static void FUN_8016594(final GraphicsStruct1c r0) {
    FUN_8015ec0(r0);

    if(r0._04.get() != 0) {
      clearVramSlot(r0.slot_0e.get());

      if(r0._04.get() == 2) {
        final Struct12fc r1 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
        r1._12d0.get(r0.packet_10.attribs_04.getPaletteNumber()).set(999);
      }
    }

    //LAB_80165c0
    r0._05.set(0);
  }

  @Method(0x80165d8)
  public static GraphicsStruct28 FUN_80165d8(final Panel24 r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    final ArrayRef<GraphicsStruct28> r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._620;
    GraphicsStruct28 r0_0 = null;

    //LAB_80165fe
    //LAB_80165f4
    for(int i = 0; i < 3; i++) {
      final GraphicsStruct28 struct = r4.get(i);

      if(struct._00.isNull()) {
        r0_0 = struct;
        break;
      }
    }

    //LAB_8016604
    if(r0_0 == null) {
      return null;
    }

    r0_0._00.set(r0);
    r0_0._04.set(r2 << 8);
    r0_0._06.set(r3 << 8);
    r0_0._12.set(r1);
    r0_0._14.set(0);
    r0_0._16.set(0xf);
    r0_0._18.set(0);
    r0_0._1a.set(0xa);
    r0_0._1e.set(r2 << 8);
    r0_0._20.set(0);
    r0_0._24.set(a5);

    if(a4 != 0) {
      //LAB_8016636
      for(int i = 0; i < 4; i++) {
        r0_0._08.get(i).set(MEMORY.ref(2, a4 + i * 0x2).getUnsigned());
      }
    } else {
      //LAB_801664c
      //LAB_8016654
      for(int i = 0; i < 4; i++) {
        r0_0._08.get(i).set(0);
      }
    }

    //LAB_8016664
    r0_0._10.set(0);

    //LAB_8016668
    return r0_0;
  }

  @Method(0x8016670)
  public static int FUN_8016670(final Panel24 r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    final int r6;

    r3 = 0x3001e8c;
    r3 = MEMORY.ref(4, r3).get();
    r6 = r1;
    r5 = 0x0;
    r1 = r3 + 0x620;
    r4 = 0x0;

    //LAB_8016688
    do {
      if(r4 == 0x3) {
        break;
      }
      r3 = MEMORY.ref(4, r1).get();
      if(r3 == 0) {
        //LAB_8016698
        r5 = r1;
        break;
      }
      r3 = MEMORY.ref(2, r3 + 0x14).getUnsigned();
      if(r3 != 0) {
        //LAB_8016698
        r5 = r1;
        break;
      }

      //LAB_8016684
      r1 = r1 + 0x28;
      r4 = r4 + 0x1;
    } while(true);

    //LAB_801669a
    if(r5 != 0) {
      r3 = MEMORY.ref(4, r5).get();
      if(r3 == 0) {
        MEMORY.ref(2, r5 + 0x6).setu(0xa00);
        MEMORY.ref(4, r5).setu(r0.getAddress());
        MEMORY.ref(2, r5 + 0x4).setu(0x300);
        //LAB_80166b2
      } else if(r2 == 0) {
        r2 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
        if(r2 == 0) {
          MEMORY.ref(2, r5 + 0x6).setu(0xa00);
          //LAB_80166c6
        } else if((r2 & 0xffff_ffffL) < 0xd00) {
          MEMORY.ref(2, r5 + 0x6).addu(0xd00);
        } else {
          //LAB_80166d4
          FUN_80167d8(MEMORY.ref(4, r5, GraphicsStruct28::new));
        }

        //LAB_80166da
        MEMORY.ref(2, r5 + 0x4).setu(0x300);
      }

      //LAB_80166e0
      MEMORY.ref(2, r5 + 0x1e).setu(0x300);
      r3 = MEMORY.ref(4, r5).get();
      MEMORY.ref(2, r3 + 0x14).setu(0);
      MEMORY.ref(2, r5 + 0x16).setu(15);
      MEMORY.ref(2, r5 + 0x1a).setu(10);
      MEMORY.ref(2, r5 + 0x12).setu(r6);
      MEMORY.ref(2, r5 + 0x14).setu(0);
      MEMORY.ref(2, r5 + 0x18).setu(0);
      MEMORY.ref(2, r5 + 0x10).setu(0);
      MEMORY.ref(2, r5 + 0x20).setu(0);
      r4 = 0x0;
      r3 = r5 + 0x8;

      //LAB_8016704
      do {
        r4 = r4 + 0x1;
        MEMORY.ref(2, r3).setu(0);
        r3 = r3 + 0x2;
      } while((r4 & 0xffff_ffffL) < 4);
    }

    //LAB_801670e
    return r5;
  }

  @Method(0x801671c)
  public static void FUN_801671c() {
    MEMORY.call(0x3000168, 0x6002500, 0xf00, 0); // memfill32
  }

  @Method(0x8016738)
  public static void FUN_8016738() {
    MEMORY.call(0x3000168, 0x6002500, 0xf00, 0x44444444); // memfill32
  }

  @Method(0x80167ac)
  public static void FUN_80167ac(final GraphicsStruct28 r0) {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r2._eae.set(r0._16.get());
    r2._eac.set(r0._18.get());
    r2._ea8.set(r0._1a.get());
  }

  @Method(0x80167d8)
  public static void FUN_80167d8(final GraphicsStruct28 r0) {
    r0._1c.set(0x2);
  }

  @Method(0x80167e0)
  public static void FUN_80167e0(final int r0) {
    //LAB_8016818
    for(int r7 = 0; r7 < 30; r7++) {
      DMA.channels[3].SAD.setu(0x6002520 + r7 * 0x80 + r0 * 0x18);
      DMA.channels[3].DAD.setu(0x6002520 + r7 * 0x80);
      DMA.channels[3].CNT.setu(0x84000000 | 0x18 - r0 * 0x6);

      MEMORY.call(0x3000168, 0x6002500 + r7 * 0x80 + (0x20 - r0 * 0x6) * 0x4, r0 * 0x18, 0); // memfill
    }
  }

  @Method(0x8016868)
  public static void FUN_8016868() {
    final ArrayRef<GraphicsStruct28> addr = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._620;

    //LAB_801687e
    for(int r7 = 0; r7 < 3; r7++) {
      final GraphicsStruct28 r5 = addr.get(r7);

      final Panel24 r2 = r5._00.derefNullable();
      if(r2 != null) {
        if(r2._18.get() == 0 && r2._1a.get() == 0) {
          if(r2.flags_16.get() == 0) {
            r5._00.clear();
          } else {
            //LAB_8016894
            if(r2._12.get() != 0) {
              FUN_8019854(r5);
            } else {
              //LAB_80168a2
              final int r0 = FUN_80168f4(r5);

              if(r0 == 8) {
                //LAB_80168b2
                r5._00.deref()._14.set(0x1); // Without this, "catch" and the "have you got everything" dialogues will not advance
              } else if(r0 == 9) {
                //LAB_80168b8
                final Panel24 r0_0 = r5._00.deref();
                FUN_8016418(r0_0, r0_0.flags_16.get() & 0x2);
                r5._04.set(0);
                r5._06.set(0);
                r5._12.set(0);
                r5._14.set(0);
                r5._16.set(0);
                r5._18.set(0);
                r5._1a.set(0);
                r0_0._14.set(0x1);
              }
            }
          }
        }
      }

      //LAB_80168dc
    }
  }

  @Method(0x80168f4)
  public static int FUN_80168f4(final GraphicsStruct28 r6) {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r7;
    int r10;

    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r3 = _200044c.get();
    r2 = MEMORY.ref(1, 0x807380b + r3).getUnsigned();
    CPU.sp().value -= 0x34;
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r2);
    if(r8._ea5.get() != 0) {
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(MathHelper.clamp(_3001cd0.getUnsigned(), 0, 2) * 5 + 3);
    }

    //LAB_8016944
    if(r6._1c.get() != 0) {
      FUN_80167e0(0x1);
      r6._1c.decr();

      CPU.sp().value += 0x34;
      return 0;
    }

    //LAB_8016958
    if(heldButtonsLastFrame_3001ae8.get() == 0 && r6._22.get() != 0) {
      r6._22.decr();

      CPU.sp().value += 0x34;
      return 0;
    }

    //LAB_8016972
    do {
      if(r6._20.get() == 0) {
        r7 = r8.text_eb0.get(r6._12.get()).get();
      } else {
        r7 = 0;
      }

      //LAB_8016988
      jmp_8016ede:
      {
        switch(r7) {
          case 0x3:
            r6._04.set(r6._1e.get());

            if((r6._00.deref().flags_16.get() & 0x8) == 0) {
              //LAB_8016a42
              r6._06.add(0xf00);

              if(r6._10.get() <= 2) {
                //LAB_8016a56
                r6._10.incr();
              }
            } else if(r6._06.get() > 0xcff) {
              FUN_80167d8(r6);
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            } else {
              //LAB_8016a38
              r6._06.add(0xd00);
            }
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x1:
            if(r8._ea4.get() != 0 && r6._14.get() < 0x384) {
              accumulatedButtons_3001af8.set(0);
            }

            //LAB_8016a9a
            r6._14.set(0x397);
            if(FUN_80199ec(r6) == 0) {
              final Panel24 r0_0 = r6._00.deref();
              if(r0_0.w_08.get() != 0) {
                //LAB_8016ab4
                if(r0_0.h_0a.get() != 0) {
                  //LAB_8016abc
                  if(r8._12f8.get() == 0) {
                    //LAB_8016ac8
                    FUN_8018cac(r0_0, 0x1, r0_0.w_08.get() * 4 - 8, r0_0.h_0a.get() * 8 - 16, 0x1);
                    r8._12f8.set(0x1);
                  }
                }
              }
            } else {
              //LAB_8016afa
              final Panel24 r5 = r6._00.deref();
              MEMORY.ref(4, CPU.sp().value + 0x30).setu(r5.x_0c.get());
              MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r5.w_08.get());
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r5.y_0e.get());
              MEMORY.ref(4, CPU.sp().value + 0x18).setu(r5.h_0a.get());
              r8._12f8.set(0);
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r6._12.get());
              FUN_8016478(r5);
              r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              if(r6._24.get() == 0 && (r5.w_08.get() | r5.h_0a.get()) != 0) {
                clearPanelBuffer(r5.x_0c.get(), r5.y_0e.get(), r5.w_08.get(), r5.h_0a.get());
              }

              //LAB_8016b3c
              r4 = CPU.addT(r4, 0x1);
              r4 = CPU.andT(r4, 0x1ff);
              if(r8.text_eb0.get(r4).get() != 0) {
                if((r5.h_0a.get() | r5.w_08.get()) != 0) {
                  r7 = r6._24.get();
                  if(r7 != 0) {
                    clearPanelBuffer(r5.x_0c.get(), r5.y_0e.get(), r5.w_08.get(), r5.h_0a.get());
                  } else {
                    //LAB_8016b70
                    FUN_801868c(r4, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24, r6._08, r7);

                    r1 = r5.flags_16.get();
                    if((r1 & 0x80) != 0) {
                      r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                      if(r3 != r2) {
                        MEMORY.ref(4, CPU.sp().value + 0x2c).subu(r2 - r3);
                      }

                      //LAB_8016bb8
                      if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() < 0) {
                        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7);
                      }
                    }

                    //LAB_8016bc0
                    if((r1 & 0x100) == 0) {
                      MEMORY.ref(4, CPU.sp().value + 0x30).setu(MEMORY.ref(4, CPU.sp().value + 0x30).get() + (MEMORY.ref(4, CPU.sp().value + 0x1c).get() - MEMORY.ref(4, CPU.sp().value + 0x28).get()) / 4);
                      FUN_801868c(r4, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24, r6._08, 0x2);
                    }

                    //LAB_8016bf6
                    r5.x_0c.set(MEMORY.ref(4, CPU.sp().value + 0x30).get());
                    r5.y_0e.set(MEMORY.ref(4, CPU.sp().value + 0x2c).get());
                    r5.w_08.set(MEMORY.ref(4, CPU.sp().value + 0x28).get());
                    r5.h_0a.set(MEMORY.ref(4, CPU.sp().value + 0x24).get());
                  }

                  //LAB_8016c06
                  drawPanelBackground(r5.x_0c.get(), r5.y_0e.get(), r5.w_08.get(), r5.h_0a.get());
                }
              }

              //LAB_8016c12
              r6._04.set(r6._1e.get());
              r6._06.set(0);
              r6._10.set(0);
              clearVramSlot(r8.vramSlot_12b6.get());
              r8.vramSlot_12b6.set(0x63);
            }
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x2:
            if(r8._ea4.get() != 0 && r6._14.get() < 0x384) {
              accumulatedButtons_3001af8.set(0);
            }

            //LAB_8016c46
            if(FUN_80199ec(r6) != 0) {
              //LAB_801696e
              CPU.sp().value += 0x34;
              return 0x9;
            }

            //LAB_8016c52
            r6._14.set(0x397);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x5:
            if(r6._14.get() == 0) {
              r6._14.set(0x14);
            }

            r8._12f6.set(0);
            FUN_801999c(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x6:
            if(r6._14.get() == 0) {
              r6._14.set(0x78);
            }

            //LAB_8016c6c
            r8._12f6.set(0);
            FUN_801999c(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x4:
            if(r6._14.get() == 0) {
              r6._14.set(0x3c);
            }

            //LAB_8016c86
            r8._12f6.set(0);

            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x8:
            r6._12.incr().and(0x1ff);
            r6._16.set(r8.text_eb0.get(r6._12.get()).get());
            FUN_80167ac(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x9:
            r6._12.incr().and(0x1ff);
            r6._18.set(r8.text_eb0.get(r6._12.get()).get());
            FUN_80167ac(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0xa:
            r6._12.incr().and(0x1ff);
            r6._1a.set(r8.text_eb0.get(r6._12.get()).get());
            FUN_80167ac(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x7:
            r6._16.set(0xf);
            r6._18.set(0);
            r6._1a.set(0xa);
            FUN_80167ac(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0xf:
            r6._12.incr().and(0x1ff);
            r6._00.deref()._12.set(r8.text_eb0.get(r6._12.get()).get());
            r6._12.incr().and(0x1ff);
            r6._14.set(0xa);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x0:
          case 0x1e:
            r6._20.set(0x1);
            CPU.sp().value += 0x34;
            return 0x8;

          case 0xb:
          case 0xc:
          case 0xd:
          case 0xe:
          case 0x10:
          case 0x11:
          case 0x12:
          case 0x13:
          case 0x14:
          case 0x15:
          case 0x16:
          case 0x17:
          case 0x18:
          case 0x19:
          case 0x1a:
          case 0x1b:
          case 0x1c:
          case 0x1d:
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;
        }

        //LAB_8016d76
        r3 = r6._04.get();
        r2 = CPU.addT(r3, 0x0);
        r2 = CPU.addT(r2, 0x80);
        if(r2 < 0) {
          r2 = r3 + 0x17f;
        }

        //LAB_8016d84
        int r5_0 = CPU.asrT(r2, 8);
        r2 = r6._06.get();
        r3 = CPU.addT(r2, 0x0);
        r3 = CPU.addT(r3, 0x80);
        if(r3 < 0) {
          r3 = r2 + 0x17f;
        }

        //LAB_8016d94
        r3 = CPU.asrT(r3, 8);
        CPU.r12().value = r3;
        r3 = _200044c.get();
        r2 = MEMORY.ref(1, 0x807380e + r3).getUnsigned();
        r3 = r8._ea4.get();
        r10 = r2;
        r2 = r6._12.get();
        if(r3 != 0) {
          r5_0 = CPU.addT(r5_0, 0x8);
        }

        //LAB_8016db6
        r3 = CPU.addT(r2, 0x1);
        r3 = CPU.andT(r3, 0x1ff);
        r4 = r8.text_eb0.get(r3).get();
        if(r4 == 0xde) {
          r7 = r7 | 0x4000;
          r6._12.incr().and(0x1ff);
          //LAB_8016dec
        } else if(r4 == 0xdf) {
          r7 = r7 | 0x8000;
          r6._12.incr().and(0x1ff);
        }

        //LAB_8016dfe
        if((r6._00.deref().flags_16.get() & 0x8) == 0) {
          CPU.cmpT(r7, 0x20);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            CPU.cmpT(r4, 0x20);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r3 = MEMORY.ref(2, 0x8032224 + (r7 - 0x20) * 0x20).getUnsigned() + MEMORY.ref(2, 0x8032224 + (r4 - 0x20) * 0x20).getUnsigned();
              if(r3 >= 0 && r3 < 0x10) {
                r7 = r4 << 8 | r7;
                r6._12.incr().and(0x1ff);
              }
            }
          }
        }

        //LAB_8016e3e
        r4 = FUN_8018cac(r6._00.deref(), r7, r5_0, CPU.r12().value, 0);
        r3 = _200044c.get();
        r3 = MEMORY.ref(1, 0x8073808 + r3).getUnsigned();
        r6._22.set(r3);
        if(r4 != 0) {
          if(r8._12f4.get() != 0) {
            if(r8._12f6.get() == 0) {
              if(r7 != 0x20) {
                playSound_(r8._12f4.get() + (r7 & 0x3));
                r8._12f6.set(r10);
              }
            } else {
              //LAB_8016eb0
              r8._12f6.decr();
            }
          }

          //LAB_8016eb6
          r0 = r4 << 8;
          if(r7 == 0x20) {
            r0 = r0 + r6._08.get(r6._10.get()).get();
          }

          //LAB_8016ec6
          r6._04.add(r0); //TODO overflowver
        }

        //LAB_8016ecc
        if(r7 == 0x20 && r8._ea5.get() == 0) {
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
        }
      }

      //LAB_8016ede
      //NOTE inline decr
      if(r6._14.get() == 0 || r6._14.decr().get() == 0) {
        //LAB_8016ef2
        r6._12.incr().and(0x1ff);
      }

      //LAB_8016efc
      MEMORY.ref(4, CPU.sp().value + 0x20).decr();
    } while(MEMORY.ref(4, CPU.sp().value + 0x20).get() != 0);

    //LAB_8016f08
    //LAB_8016f18
    //LAB_8016f1a
    CPU.sp().value += 0x34;
    return 0;
  }

  @Method(0x8016f2c)
  public static void FUN_8016f2c() {
    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    //LAB_8016f40
    for(int i = 0; i < 8; i++) {
      final Panel24 panel = r7._500.get(i);

      if(panel.flags_16.get() != 0) {
        if(panel._18.get() != 0) {
          animatePanelBackground(panel, 0);
          panel._18.decr();
          //LAB_8016f5e
        } else if(panel._1a.get() != 0) {
          FUN_8016230(panel);
        }
      } else {
        //LAB_8016f6e
        final int r2 = panel._1a.get();
        if(r2 != 0) {
          if(panel._18.get() != r2) {
            clearPanelBuffer(panel.currentX_1c.get(), panel.currentY_1e.get(), panel.currentW_20.get(), panel.currentH_22.get());
            animatePanelBackground(panel, 1);
            panel._18.incr();
            r7._ea3.set(0x1);
          } else {
            //LAB_8016faa
            clearPanelBuffer(panel.currentX_1c.get(), panel.currentY_1e.get(), panel.currentW_20.get(), panel.currentH_22.get());
            panel._00.clear();
            panel._04.clear();
            panel.w_08.set(0);
            panel.h_0a.set(0);
            panel.x_0c.set(0);
            panel.y_0e.set(0);
            panel._10.set(0);
            panel._12.set(0);
            panel._14.set(0);
            panel.flags_16.set(0);
            panel._18.set(0);
            panel._1a.set(0);
            panel.currentX_1c.set(0);
            panel.currentY_1e.set(0);
            panel.currentW_20.set(0);
            panel.currentH_22.set(0);
            r7._ea3.set(0x1);
          }
        }
      }

      //LAB_8016fe6
    }
  }

  @Method(0x8017004)
  public static void animatePanelBackground(final Panel24 panel, final int r1) {
    final int x = ((int)MEMORY.call(0x300013c, panel._1a.get() << 17, panel._18.get() * panel.w_08.get() << 16) >> 16) + panel.x_0c.get();
    final int y = ((int)MEMORY.call(0x300013c, panel._1a.get() << 17, panel._18.get() * panel.h_0a.get() << 16) >> 16) + panel.y_0e.get();
    final int w = (int)MEMORY.call(0x300013c, panel._1a.get() << 17, (panel._1a.get() - panel._18.get()) * panel.w_08.get() << 16) >> 15;
    final int h = (int)MEMORY.call(0x300013c, panel._1a.get() << 17, (panel._1a.get() - panel._18.get()) * panel.h_0a.get() << 16) >> 15;

    drawPanelBackground(x, y, w, h);

    if(r1 != 0) {
      panel.currentX_1c.set(x);
      panel.currentY_1e.set(y);
      panel.currentW_20.set(w);
      panel.currentH_22.set(h);
    }

    //LAB_80170ac
  }

  @Method(0x80170c4)
  public static int fillShorts(final int dst, final int val, final int count) {
    if(count <= 0) {
      //LAB_80170e8
      return dst;
    }

    CPU.sp().value -= 0x4;
    MEMORY.ref(2, CPU.sp().value + 0x2).setu(val);
    DMA.channels[3].SAD.setu(CPU.sp().value + 0x2);
    DMA.channels[3].DAD.setu(dst);
    DMA.channels[3].CNT.setu(0x81000000 | count);
    CPU.sp().value += 0x4;
    return dst + count * 0x2;
  }

  @Method(0x80170f8)
  public static void drawPanelBackground(final int x, final int y, final int w, final int h) {
    final Struct12fc r11 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int addr = r11._00.getAddress() + (y * 32 + x) * 0x2; //TODO
    if(w > 1 && h > 1 && w <= 30 && h <= 30) {
      FUN_801e260(x, y, w, h);

      //LAB_801714c
      MEMORY.ref(2, addr).setu(r11._ea4.get() != 0 ? 0xf01c : 0xf010);
      addr += 0x2;
      addr = fillShorts(addr, 0xf011f011, w - 2);

      //LAB_801718a
      MEMORY.ref(2, addr).setu(r11._ea4.get() != 0 ? 0xf41c : 0xf012);
      addr += 0x2;
      final int skip = (32 - w) * 0x2;
      addr += skip;

      //LAB_80171a2
      for(int r6 = 1; r6 < h - 1; r6++) {
        MEMORY.ref(2, addr).setu(0xf016);
        addr += 0x2;

        if(w != 2) {
          addr = fillShorts(addr, 0xf020f020, w - 2);
        }

        //LAB_80171ca
        MEMORY.ref(2, addr).setu(0xf017);
        addr += skip + 0x2;
      }

      //LAB_80171d8
      //LAB_80171f6
      MEMORY.ref(2, addr).setu(r11._ea4.get() != 0 ? 0xf81c : 0xf013);
      addr = fillShorts(addr + 0x2, 0xf014f014, w - 2);

      //LAB_8017226
      MEMORY.ref(2, addr).setu(r11._ea4.get() != 0 ? 0xfc1c : 0xf015);
      r11._ea3.set(0x1);
    }

    //LAB_8017230
  }

  @Method(0x8017248)
  public static void FUN_8017248(int r0, int r1, int r2, int r3, final int a4) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.lr().value = r3;
    r3 = 0x3001e8c;
    r1 = r1 << 5;
    r3 = MEMORY.ref(4, r3).get();
    r1 = r1 + r0;
    CPU.sp().value -= 0x4;
    r1 = r1 << 1;
    r6 = r2;
    r4 = a4;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r1 = r1 + r3;
    if((r6 & 0xffff_ffffL) > (0x1 & 0xffff_ffffL)) {
      r2 = CPU.lr().value;
      if((r2 & 0xffff_ffffL) > (0x1 & 0xffff_ffffL)) {
        if((r6 & 0xffff_ffffL) <= (0x1e & 0xffff_ffffL)) {
          if((r2 & 0xffff_ffffL) <= (0x1e & 0xffff_ffffL)) {
            r1 = r1 + 0x40;
            if(r4 == 0) {
              r3 = 0x1;
              r3 = -r3;
              r3 = r3 + CPU.lr().value;
              r5 = 0x1;
              CPU.r8().value = r3;
              if((r5 & 0xffff_ffffL) < (CPU.r8().value & 0xffff_ffffL)) {
                r3 = 0x20;
                r3 = r3 - r6;
                r3 = r3 << 1;
                r2 = r6 - 0x1;
                CPU.r10().value = r3;
                r3 = 0x127;
                CPU.r12().value = r2;
                CPU.r9().value = CPU.r12().value;
                CPU.r11().value = r3;

                //LAB_80172a4
                do {
                  r4 = 0x1;
                  r1 = r1 + 0x2;
                  if((r4 & 0xffff_ffffL) < (CPU.r9().value & 0xffff_ffffL)) {
                    r3 = CPU.lr().value;
                    r3 = r3 - 0x2;
                    r2 = r3;
                    r7 = 0xfff;
                    r3 = CPU.r11().value;
                    r6 = 0xf000;
                    r0 = r3 + r5;

                    //LAB_80172ba
                    do {
                      r3 = r0;
                      r3 = r3 & r7;
                      r3 = r3 | r6;
                      r4 = r4 + 0x1;
                      MEMORY.ref(2, r1).setu(r3);
                      r0 = r0 + r2;
                      r1 = r1 + 0x2;
                      CPU.cmpT(r4, CPU.r12().value);
                    } while((r4 & 0xffff_ffffL) < (CPU.r12().value & 0xffff_ffffL));
                  }

                  //LAB_80172cc
                  r1 = r1 + 0x2;
                  r5 = r5 + 0x1;
                  r1 = r1 + CPU.r10().value;
                } while((r5 & 0xffff_ffffL) < (CPU.r8().value & 0xffff_ffffL));
              }
            } else {
              //LAB_80172e8
              r0 = CPU.lr().value;
              r5 = 0x1;
              r0 = r0 - 0x1;
              if((r5 & 0xffff_ffffL) < (r0 & 0xffff_ffffL)) {
                r3 = 0x20;
                r3 = r3 - r6;
                r2 = 0x127;
                r3 = r3 << 1;
                CPU.r10().value = r3;
                CPU.r9().value = r2;
                CPU.r8().value = r0;

                //LAB_8017300
                do {
                  r4 = 0x0;
                  if((r4 & 0xffff_ffffL) < (r6 & 0xffff_ffffL)) {
                    r3 = 0x2;
                    r3 = -r3;
                    r3 = r3 + CPU.lr().value;
                    r2 = 0xfff;
                    CPU.r11().value = r3;
                    r7 = 0xf000;
                    r3 = CPU.r9().value;
                    CPU.r12().value = r2;
                    r0 = r5 + r3;

                    //LAB_8017318
                    do {
                      r3 = r0;
                      r2 = CPU.r12().value;
                      r3 = r3 & r2;
                      r3 = r3 | r7;
                      r4 = r4 + 0x1;
                      MEMORY.ref(2, r1).setu(r3);
                      r0 = r0 + CPU.r11().value;
                      r1 = r1 + 0x2;
                    } while((r4 & 0xffff_ffffL) < (r6 & 0xffff_ffffL));
                  }

                  //LAB_801732c
                  r5 = r5 + 0x1;
                  r1 = r1 + CPU.r10().value;
                } while((r5 & 0xffff_ffffL) < (CPU.r8().value & 0xffff_ffffL));
              }
            }

            //LAB_8017334
            r3 = MEMORY.ref(4, CPU.sp().value).get();
            r1 = 0xea3;
            r2 = r3 + r1;
            r3 = 0x1;
            MEMORY.ref(1, r2).setu(r3);
          }
        }
      }
    }

    //LAB_8017350
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8017364)
  public static int FUN_8017364() {
    final ArrayRef<GraphicsStruct28> r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._620;

    //LAB_8017372
    for(int r1 = 0; r1 < 3; r1++) {
      final Panel24 r3 = r2.get(r1)._00.derefNullable();
      if(r3 != null) {
        if(r3._14.get() == 0) {
          return 0;
        }
      }

      //LAB_8017380
    }

    //LAB_801738a
    return 1;
  }

  @Method(0x8017394)
  public static int FUN_8017394(final Panel24 r0) {
    if(r0.flags_16.get() == 0 && r0._1a.get() == 0) {
      return 1;
    }

    return 0;
  }

  @Method(0x80173ac)
  public static void FUN_80173ac() {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r2._ea8.set(10);
    r2._eaa.set(1);
    r2._eac.set(0);
    r2._eae.set(15);
    r2._12b0.set(9);
  }

  @Method(0x80173f4)
  public static void FUN_80173f4() {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r5._12b8.set(allocateSpriteSlot(0x5f, 0x2000, 0));
    r5._12b0.set(0x9);
    r5._ea8.set(0xa);
    r5._eac.set(0);
    r5._eae.set(0xf);
    r5.textOffset_12b2.set(0);
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_801789c"), 0xc80);
  }

  @Method(0x8017464)
  public static void FUN_8017464(final int r0) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(r0 != 0) {
      r5._12b8.set(allocateSpriteSlot(95, 0x2000, 0));
    }

    //LAB_8017480
    r5._12b0.set(9);
    r5._ea8.set(10);
    r5._eac.set(0);
    r5._eae.set(15);
    r5.textOffset_12b2.set(0);
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_801789c"), 0xc80);
  }

  @Method(0x80174d8)
  public static void FUN_80174d8() {
    final int r5 = boardWramMallocHead_3001e50.offset(37 * 0x4).get();
    final Panel24 r0 = MEMORY.ref(4, r5).deref(4).cast(Panel24::new);
    if(r0 != null) {
      FUN_8016418(r0, 1);
      MEMORY.ref(4, r5).setu(0);
    }
  }

  @Method(0x80174f8)
  public static void FUN_80174f8(final int r0) {
    final int r3;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001e8c;
    r6 = MEMORY.ref(4, r3).get();
    r7 = MEMORY.ref(4, r3 + 0x58).get();
    MEMORY.ref(1, r6 + 0xea5).setu(2);
    CPU.r8().value = 0;
    CPU.r10().value = FUN_8018038(r0, 1);
    MEMORY.ref(1, r6 + 0xea5).setu(1);
    if(MEMORY.ref(2, r6 + 0xeb0 + CPU.r10().value * 0x2).getUnsigned() != 0) {
      final Panel24 r0_0 = MEMORY.ref(4, r7).deref(4).cast(Panel24::new);
      final Panel24 r5;
      if(r0_0 == null) {
        r5 = addPanel(0, 15, 30, 6, 0xa);
        MEMORY.ref(4, r7).setu(r5.getAddress());
        FUN_8017248(0, 15, 30, 6, 1);
        MEMORY.ref(4, r7 + 0x8).setu(CPU.r8().value);
      } else {
        //LAB_8017564
        r5 = r0_0;
      }

      //LAB_8017566
      if(r5 != null) {
        CPU.r8().value = FUN_8016670(r5, CPU.r10().value, MEMORY.ref(4, r7 + 0x8).get());
        MEMORY.ref(4, r7 + 0x4).setu(CPU.r8().value);
        MEMORY.ref(4, r7 + 0x8).setu(0);
        if(CPU.r8().value == 0) {
          FUN_8016418(r5, 1);
        }
      }
    }

    //LAB_8017588
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x80175a0)
  public static void FUN_80175a0(final int r0) {
    FUN_80174f8(r0);

    //LAB_80175ae
    while(FUN_8017364() == 0) {
      //LAB_80175a8
      sleep(1);
    }

    sleep(1);
  }

  @Method(0x8017620)
  public static void FUN_8017620(final int r0) {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    if(r2 != null) {
      if((r0 & 0x1) != 0) {
        r2._12fa.set(1);
      }

      //LAB_801763a
      if((r0 & 0x2) != 0) {
        r2._12fb.set(1);
      }
    }
  }

  @Method(0x8017658)
  public static Panel24 FUN_8017658(final int r0, final int r1, final int r2, final int r3) {
    CPU.sp().value -= 0x24;

    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
    r8._12f4.set(r3 << 4 >>> 20);
    r8._12f6.set(0);
    final int r10 = FUN_8018038(r0, 0x1);

    if(r8.text_eb0.get(r10).get() == 0) {
      CPU.sp().value += 0x24;
      return null;
    }

    final int r9 = CPU.sp().value + 0x1c;
    FUN_801868c(r10, CPU.sp().value + 0x18, CPU.sp().value + 0x14, CPU.sp().value + 0x10, CPU.sp().value + 0xc, MEMORY.ref(2, r9, ArrayRef.of(UnsignedShortRef.class, 8, 0x2, UnsignedShortRef::new)), 0); //TODO
    final int r2_0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    final int r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();

    if(r2_0 == 0 && r4 == 0) {
      CPU.sp().value += 0x24;
      return null;
    }

    //LAB_80176cc
    int r7 = 0;
    if((r3 & 0x1) == 0) {
      r7 = r7 | 0x2;
    }

    //LAB_80176d8
    if((r3 & 0x8) != 0) {
      r7 = r7 | 0x8;
    }

    //LAB_80176e4
    if((r3 & 0x10) != 0) {
      r7 = r7 | 0x80;
    }

    //LAB_80176f0
    if((r3 & 0x20) != 0) {
      r7 = r7 | 0x100;
    }

    //LAB_80176fe
    final Panel24 r6 = addPanel(MEMORY.ref(4, CPU.sp().value + 0x18).get(), MEMORY.ref(4, CPU.sp().value + 0x14).get(), r2_0, r4, r7);
    if(r6 == null) {
      CPU.sp().value += 0x24;
      return null;
    }

    if(FUN_80165d8(r6, r10, 0, 0, r9, 0) == null) {
      FUN_8016418(r6, 0x1);
      CPU.sp().value += 0x24;
      return null;
    }

    //LAB_8017736
    r8._12fa.set(0);
    r8._12fb.set(0);

    //LAB_8017744
    CPU.sp().value += 0x24;
    return r6;
  }

  @Method(0x801776c)
  public static void FUN_801776c(final int r0, final int flags) {
    int r2;
    int r3;

    CPU.sp().value -= 0x1c;

    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    if((flags & 0x2) != 0) {
      r8._12f9.set(0x1);
    }

    //LAB_80177a2
    MEMORY.ref(4, CPU.sp().value).setu(CPU.sp().value + 0xc);
    FUN_80187ac(r0, CPU.sp().value + 0x18, CPU.sp().value + 0x14, CPU.sp().value + 0x10, MEMORY.ref(4, CPU.sp().value).get());
    r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    MEMORY.ref(4, CPU.sp().value + 0x18).setu((30 - r2) / 2);
    r2 = (8 - MEMORY.ref(4, CPU.sp().value + 0xc).get()) / 2;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu((8 - r2) / 2);

    if((flags & 0x8) != 0) {
      r3 = r2 + 0x4;
    } else {
      //LAB_80177d2
      if((flags & 0x40) != 0) {
        r3 = r2 + 0xc;
      } else {
        //LAB_80177e0
        FUN_808a278(playerMapActorIndex_2000434.get(), CPU.sp().value + 0x4);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get() >> 3;
        if(r3 > 9) {
          r3 -= 5;
        } else {
          //LAB_80177fe
          r3 += 4;
        }
      }
    }

    //LAB_8017800
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);

    final Panel24 r5 = FUN_8017658(r0, MEMORY.ref(4, CPU.sp().value + 0x18).get(), MEMORY.ref(4, CPU.sp().value + 0x14).get(), flags & 0x1);
    if(r5 != null) {
      //LAB_8017816
      while(FUN_8017364() == 0) {
        sleep(0x1);
      }

      if((flags & 0x20) != 0) {
        r8._ea6.set(0x1);
      }

      //LAB_8017838
      if((flags & 0x4) == 0) {
        FUN_8016418(r5, flags & 0x1);

        //LAB_801784a
        while(FUN_8017394(r5) == 0) {
          sleep(0x1);
        }
      }
    }

    //LAB_801785a
    r8._12f9.set(0);
    r8._12f4.set(0);
    r8._12f6.set(0);
    sleep(0x3);

    CPU.sp().value += 0x1c;
  }

  @Method(0x801789c)
  public static void FUN_801789c() {
    FUN_8016f2c();
    FUN_8016868();
    FUN_80191cc();
  }

  @Method(0x80178b0)
  public static int FUN_80178b0(final int r0, final int r1) {
    CPU.sp().value -= 0x184;

    int r10 = r0 << 8 >> 16;
    final int r5 = r0 & 0xff;
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.call(0x3000164, CPU.sp().value + 0x4, 0x180);

    final int r9;
    final int r11;
    if(r6._ea4.get() != 0) {
      r9 = 0;
      r11 = 0x8;
    } else {
      //LAB_80178f0
      r9 = 1;
      r11 = r6._eae.get();
    }

    //LAB_80178fa
    int r7 = 0x8032224 + (r5 - 0x20) * 0x20; //TODO
    int r8 = MEMORY.ref(2, r7).getUnsigned();
    r7 = r7 + 0x2;
    if(r6._eac.get() == 1) {
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x35, r9);
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x36, r9);
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x24, r11);
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x25, r11);
      r8++;
    } else {
      //LAB_801794c
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x35, r9);
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x24, r11);
    }

    //LAB_8017964
    int r2 = r10 & 0xffff;
    if(r2 != 0) {
      r7 = 0x8031e24 + r2 * 0x20; //TODO
      r10 = MEMORY.ref(2, r7).get();
      r7 = r7 + 0x2;
      if(r6._eac.get() == 1) {
        final int r6_0 = CPU.sp().value + 0x4 + r8;
        MEMORY.call(0x3000214, r7, r6_0 + 0x31, r9);
        MEMORY.call(0x3000214, r7, r6_0 + 0x32, r9);
        MEMORY.call(0x3000214, r7, r6_0 + 0x20, r11);
        MEMORY.call(0x3000214, r7, r6_0 + 0x21, r11);
        r10 = (short)(r10 + 1);
      } else {
        //LAB_80179ce
        final int r5_0 = CPU.sp().value + 0x4 + r8;
        MEMORY.call(0x3000214, r7, r5_0 + 0x31, r9);
        MEMORY.call(0x3000214, r7, r5_0 + 0x20, r11);
      }

      //LAB_80179ec
      r8 += r10 & 0xffff;
    }

    //LAB_80179f4
    int r1_0 = CPU.sp().value + 0xb;

    //LAB_80179fa
    int sp00 = r1;
    for(int r6_0 = 0; r6_0 < 2; r6_0++) {
      //LAB_80179fc
      for(int r5_0 = 0; r5_0 < 2; r5_0++) {
        //LAB_80179fe
        for(int r4_0 = 0; r4_0 < 8; r4_0++) {
          r2 = 0;

          //LAB_8017a02
          for(int r0_0 = 7; r0_0 >= 0; r0_0--) {
            r2 = MEMORY.ref(1, r1_0).getUnsigned() + r2 * 0x10;
            r1_0--;
          }

          MEMORY.ref(4, sp00).setu(r2);
          sp00 += 0x4;

          r1_0 += 0x18;
        }

        r1_0 -= 0x78;
      }

      r1_0 += 0x70;
    }

    CPU.sp().value += 0x184;
    return r8;
  }

  /** Text width? */
  @Method(0x8017a64)
  public static int FUN_8017a64(final ArrayRef<UnsignedShortRef> str) {
    int chr;
    int r1 = 0;

    //LAB_8017a72
    for(int i = 0; (chr = str.get(i).get()) != 0; i++) {
      if(chr == 32) {
        r1 += 0x4;
        //LAB_8017a7a
      } else if(chr < 0 || chr >= 0x100) {
        //LAB_8017a90
        r1 += 0xa;
      } else if(chr < 0xde || chr > 0xdf) {
        r1 += MEMORY.ref(2, 0x8032224 + (chr - 32) * 0x20).getUnsigned();
      }

      //LAB_8017a92
    }

    //LAB_8017a9a
    return r1;
  }

  @Method(0x8017aa4)
  public static void FUN_8017aa4(@Nullable ArrayRef<UnsignedShortRef> str, final Panel24 r1, final int x, final int y) {
    int currentX = x;
    int currentY = y;
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r5 = 0;
    if(str == null) {
      //LAB_8017aca
      r6.text_eb0.get(r6.textOffset_12b2.get()).set(0);
      r6.textOffset_12b2.incr().and(0x1ff);
      str = r6.text_eb0;
    }

    int chr = str.get(r5++).get();
    if(chr > 0xff) {
      chr = 0x40;
    }

    //LAB_8017af4
    while(chr != 0) {
      if(chr > 0x1e) {
        //LAB_8017b9a
        if((r1.flags_16.get() & 0x8) == 0) {
          final int nextChr = str.get(r5).get();
          if(chr > ' ') {
            if(nextChr > ' ') {
              final int r3_0 = MEMORY.ref(2, 0x8032224 + (chr - ' ') * 0x20).getUnsigned() + MEMORY.ref(2, 0x8032224 + (nextChr - ' ') * 0x20).getUnsigned();
              if(r3_0 >= 0 && r3_0 < 0x10) {
                chr = nextChr << 8 | chr;
                r5++;
              }
            }
          }
        }

        //LAB_8017bd4
        currentX = currentX + FUN_8018cac(r1, chr, currentX, currentY, 0);
      } else {
        switch(chr) {
          case 0x8:
            r6._eae.set(str.get(r5++).get());
            break;

          case 0x9:
            r6._eac.set(str.get(r5++).get());
            break;

          case 0xa:
            r6._ea8.set(str.get(r5++).get());
            break;

          case 0xb:
          case 0xc:
          case 0x11:
          case 0x1d:
            //LAB_8017b84
            r5++;
            break;

          case 0x7:
            FUN_80173ac();
            break;

          case 0x3:
            currentX = x;
            currentY += 0xf;
            break;

          case 0xe:
          case 0xf:
          case 0x1c:
            r5 += 0x2;
            break;
        }
      }

      //LAB_8017be6
      chr = str.get(r5++).get();
      if(chr > 0xff) {
        chr = 0x40;
      }
    }

    //LAB_8017bf6
  }

  @Method(0x8017c8c)
  public static void FUN_8017c8c(@Nullable ArrayRef<UnsignedShortRef> text, final Panel24 r1, final int x, final int y) {
    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int currentY = y;
    int currentX = x;
    final int originalX = (short)currentX;

    int r6 = 0;
    if(text == null) {
      r8.text_eb0.get(r8.textOffset_12b2.get()).set(0);
      r8.textOffset_12b2.incr().and(0x1ff);
      text = r8.text_eb0;
    }

    //LAB_8017cd0
    int r3;

    //LAB_8017cdc
    while((r3 = text.get(r6++).get()) != 0) {
      final int r5 = r3 & 0xffff;
      if(r5 > 30) {
        //LAB_8017d80
        FUN_8018efc(r1, r5, currentX, currentY, 0);

        if((r5 - 0xde & 0xffff) > 1) {
          currentX++;
        }
      } else {
        switch(r5) {
          case 3:
            currentX = originalX;
            currentY++;
            break;

          case 0xe:
          case 0xf:
          case 0x1c:
            r6++;

          case 0x7:
          case 0x8:
          case 0x9:
          case 0xa:
          case 0xb:
          case 0xc:
          case 0x11:
          case 0x1d:
            r6++;
            break;
        }
      }

      //LAB_8017da4
    }

    //LAB_8017db2
    r8._ea3.set(0x1);
  }

  /**
   * Convert number to ascii
   *
   * @param out output buffer
   * @param number number to split up into digits
   * @param digits max number of digits to output
   * @return pointer into the output buffer where the number starts (takes max digits into account)
   */
  @Method(0x8017dd4)
  public static int convertNumberToAscii(final int out, final int number, final int digits) {
    int r6 = number;
    int r9 = 0;
    if(r6 < 0) {
      if(digits == 0) {
        r9 = 1;
      }

      //LAB_8017df4
      r6 = -r6;
    }

    //LAB_8017df6
    MEMORY.ref(1, out).setu(' ');
    int r5 = out + 0xc;

    //LAB_8017e00
    do {
      MEMORY.ref(1, r5).setu('0' + modS(r6, 10));
      r6 = divideS(r6, 10);
      r5--;
    } while(r5 != out);

    MEMORY.ref(1, out + 0xd).setu(0);
    int r2_1 = out;
    int r0_0 = 1;

    jmp_8017e48:
    if(r0_0 != 0xd) {
      //LAB_8017e2a
      while(MEMORY.ref(1, r2_1 + 0x1).getUnsigned() == '0') {
        if(r0_0 != 0xc) {
          MEMORY.ref(1, r2_1 + 0x1).setu(' ');
        }

        r2_1++;
        r0_0++;

        //LAB_8017e2e
        if(r0_0 == 0xd) {
          break jmp_8017e48;
        }
      }

      //LAB_8017e40
      if(r9 != 0) {
        MEMORY.ref(1, r2_1).setu(0x2d);
      }
    }

    //LAB_8017e48
    if(digits != 0) {
      //LAB_8017e6a
      //LAB_8017e74
      return out - Math.min(0xc, digits) + 0xd;
    }

    r0_0 = 0;

    //LAB_8017e58
    while(MEMORY.ref(1, out + r0_0).getUnsigned() == ' ') {
      r0_0++;
      if(r0_0 == 0xc) {
        break;
      }
    }

    //LAB_8017e66
    //LAB_8017e7a
    return out + r0_0;
  }

  @Method(0x8017e88) //TODO r1 is ASCII char name
  public static int FUN_8017e88(int r0, int r1, int r2, int r3, final int a4, final int a5, final int a6) {
    int r4;
    int r5;
    int r6;
    final int r7;
    final int r8;
    final int r9;
    final int r10;
    final int lr;

    CPU.sp().value -= 0x20;
    r10 = r0;
    r5 = CPU.addT(r1, 0x0);
    r0 = CPU.addT(r2, 0x0);
    r2 = a6;
    r7 = CPU.addT(r3, 0x0);
    r3 = r10;
    r8 = a4;
    lr = r2;
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x8017edc).get();
      r2 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r2 = MEMORY.ref(4, 0x8017ee4).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
      r3 = CPU.lslT(r0, 1);
      r1 = MEMORY.ref(4, 0x8017ee0).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
      MEMORY.ref(2, r3 + r7).setu(r1);
      r3 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r3 + r7).setu(r1);
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
    }

    //LAB_8017ec8
    r4 = r8;
    if(r4 == 1 || r4 == 3 && a5 == 0) {
      //LAB_8017ee8
      r9 = CPU.sp().value;
      r3 = MEMORY.ref(4, 0x8017fa4).get();
      r1 = CPU.movT(0x0);
      r2 = r9;
      CPU.r12().value = r1;
      r1 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();
      r3 += 0x4;

      MEMORY.ref(4, r2).setu(r1);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);
      r2 += 0x4;

      r1 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();
      r3 += 0x4;

      MEMORY.ref(4, r2).setu(r1);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);
      r2 += 0x4;

      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();

      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);

      r2 = MEMORY.ref(2, r5).getUnsigned();
      CPU.cmpT(r2, 0x1d);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
        r3 = CPU.subT(r3, 0x1);
        CPU.r12().value = r3;
        r5 = CPU.addT(r5, 0x4);
      }

      //LAB_8017f0c
      if(CPU.r12().value == 0) {
        CPU.r12().value = 2;
        if(r2 != 0x41 && r2 != 0x49 && r2 != 0x55 && r2 != 0x45 && r2 != 0x4f) {
          CPU.r12().value = 1;
        }
      }

      //LAB_8017f2e
      r3 = CPU.movT(0x7);
      r6 = CPU.r12().value;
      r6 = CPU.andT(r6, r3);
      r3 = CPU.lslT(r6, 2);
      r1 = r9;
      r4 = MEMORY.ref(4, r1 + r3).get();
      r3 = MEMORY.ref(1, r4).getUnsigned();
      r1 = CPU.lslT(r3, 24);
      r6 = CPU.movT(0x0);
      r4 = CPU.addT(r4, 0x1);
      CPU.cmpT(r1, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, 0x8017fa8).get();
        CPU.r12().value = r2;

        //LAB_8017f4a
        do {
          r2 = CPU.lslT(r0, 1);
          r3 = CPU.asrT(r1, 24);
          MEMORY.ref(2, r2 + r7).setu(r3);
          r0 = CPU.addT(r0, 0x1);
          r3 = CPU.r12().value;
          r6 = CPU.addT(r6, 0x1);
          r0 = CPU.andT(r0, r3);
          CPU.cmpT(r6, 0x7);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r3 = MEMORY.ref(1, r4).getUnsigned();
          r3 = CPU.lslT(r3, 24);
          r4 = CPU.addT(r4, 0x1);
          r1 = CPU.addT(r3, 0x0);
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }
      r2 = MEMORY.ref(2, r5).getUnsigned();
    } else {
      //LAB_8017f6a
      r3 = MEMORY.ref(2, r5).getUnsigned();
      r2 = MEMORY.ref(2, r5).getUnsigned();
      CPU.cmpT(r3, 0x1d);
      if(CPU.cpsr().getZero()) { // ==
        r5 = CPU.addT(r5, 0x4);
        r2 = MEMORY.ref(2, r5).getUnsigned();
      }
    }

    //LAB_8017f76
    r3 = CPU.addT(r2, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = MEMORY.ref(4, 0x8017fa8).get();
      r4 = CPU.movT(0x1);
      r1 = CPU.movT(0x0);

      //LAB_8017f82
      do {
        r2 = CPU.lslT(r2, 16);
        r2 = CPU.asrT(r2, 16);
        r3 = CPU.lslT(r0, 1);
        MEMORY.ref(2, r3 + r7).setu(r2);
        r2 = CPU.lslT(r2, 16);
        r0 = CPU.addT(r0, 0x1);
        r2 = CPU.lsrT(r2, 16);
        r5 = CPU.addT(r5, 0x2);
        r0 = CPU.andT(r0, r6);
        if(r2 == 'S' || r2 == 's') {
          //LAB_8017f9c
          r2 = lr;
          MEMORY.ref(4, r2).setu(r4); // Name ends in "S"
        } else {
          //LAB_8017fac
          r3 = lr;
          MEMORY.ref(4, r3).setu(r1);
        }

        //LAB_8017fb0
        r2 = MEMORY.ref(2, r5).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8017fb8
    r4 = r8;
    if(r4 == 0x2 || r4 == 0x3 && a5 != 0) {
      //LAB_8017fc8
      r1 = lr;
      r3 = MEMORY.ref(4, r1).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, 0x8018004).get();
        r3 = CPU.lslT(r0, 1);
        MEMORY.ref(2, r3 + r7).setu(r2);
        r3 = MEMORY.ref(4, 0x8018014).get();
        r0 = CPU.addT(r0, 0x1);
        r0 = CPU.andT(r0, r3);
      }

      //LAB_8017fdc
      r2 = MEMORY.ref(4, 0x8018008).get();
      r3 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r3 + r7).setu(r2);
      r3 = MEMORY.ref(4, 0x8018014).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r3);
    }

    //LAB_8017fe8
    r2 = r10;
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = MEMORY.ref(4, 0x8018014).get();
      r3 = MEMORY.ref(4, 0x801800c).get();
      r2 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, 0x1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.andT(r0, r1);
      r3 = MEMORY.ref(4, 0x8018010).get();
      r2 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, 0x1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.andT(r0, r1);
      r3 = MEMORY.ref(4, 0x8018034).get();
      r2 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r1);
    }

    //LAB_8018024
    CPU.sp().value += 0x20;
    return r0;
  }

  @Method(0x8018038)
  public static int FUN_8018038(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r9;
    final int r11;

    CPU.sp().value -= 0x84;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
    r11 = r1;
    final Struct12fc sp2c = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(0x1);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
    r6 = sp2c.textOffset_12b2.get();
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0x1);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r6);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(0);
    final int r8 = sp2c.text_eb0.getAddress(); //TODO
    int r7 = 0;

    if(MEMORY.ref(4, CPU.sp().value + 0x30).get() == -1) {
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(sp2c._12b4.get());
    } else {
      //LAB_8018092
      r5 = 0x140;
      r1 = mallocSlotChip(50, r5);
      DMA.channels[3].SAD.setu(0x8015430);
      DMA.channels[3].DAD.setu(r1);
      DMA.channels[3].CNT.setu(0x84000000 | r5 / 0x4);

      MEMORY.setFunction(r1, CopiedSegment8015430.class, "FUN_8015430", int.class);

      r9 = boardWramMallocHead_3001e50.offset(50 * 0x4).get();
      final int r10 = CPU.sp().value + 0x38;
      FUN_8019bac(r10, MEMORY.ref(4, CPU.sp().value + 0x30).get());
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(CPU.sp().value + 0x54);

      //LAB_80180c8
      do {
        r0 = (int)MEMORY.call(r9, r10);
        r5 = CPU.addT(r7, 0x0);
        r7 = CPU.addT(r0, 0x0);
        CPU.cmpT(r7, 0xff);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r7 = 0x40;
        }

        //LAB_80180d8
        jmp_8018614:
        if(MEMORY.ref(4, CPU.sp().value + 0x10).get() != 0) {
          //LAB_80180e4
          switch(r7) {
            case 0x12, 0x11, 0x1d, 0x8, 0x9 -> MEMORY.call(r9, r10);

            case 0x16 -> FUN_8019944(0x5, r11);

            case 0x14 -> {
              MEMORY.call(r9, r10);
              FUN_8019944(0x2, r11);
            }

            case 0x15 -> FUN_8019944(0x4, r11);

            case 0x13 -> {
              MEMORY.call(r9, r10);
              FUN_8019944(0x3, r11);
            }

            case 0x0, 0x2, 0x1e -> MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);

            case 0x17 -> FUN_8019944(0x6, r11);

            case 0x1 -> {
              //LAB_8018166
              MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
              r7 = 0x2;
            }
          }
        } else {
          //LAB_8018188
          if(sp2c._12fa.get() != 0) {
            if(MEMORY.ref(4, CPU.sp().value + 0x28).get() == 0) {
              if(r7 != 0xde && r7 != 0xdf) {
                MEMORY.ref(2, r8 + r6 * 0x2).setu(0x5);
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, 0x1ff);
              }
            }
          }

          //LAB_80181b0
          if(sp2c._12fb.get() != 0) {
            if(MEMORY.ref(4, CPU.sp().value + 0x28).get() == 0) {
              if(r7 != 0xde && r7 != 0xdf) {
                if(r5 <= 0x100) {
                  if(r5 > 0x7f) {
                    if(r5 != 0xde && r5 != 0xdf && r5 != 0x20 && r5 != 0xa5 && r5 != 0xa1 && r5 != 0xa4) {
                      MEMORY.ref(2, r8 + r6 * 0x2).setu(0xde);
                      r6 = CPU.addT(r6, 0x1);
                      r6 = CPU.andT(r6, 0x1ff);
                    }
                  }
                }
              }
            }
          }

          //LAB_801820e
          if(r7 > 0x1f) {
            if(sp2c._12fa.get() != 0 && (r7 == ' ' || MEMORY.ref(4, CPU.sp().value + 0x1c).get() < 0 || MEMORY.ref(4, CPU.sp().value + 0x1c).get() > 0xa)) {
              //LAB_8018228
              MEMORY.ref(2, r8 + r6 * 0x2).setu('.');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
              MEMORY.ref(2, r8 + r6 * 0x2).setu('.');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
              MEMORY.ref(2, r8 + r6 * 0x2).setu('.');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x1);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              CPU.cmpT(r1, 0xa);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                r7 = ' ';
              }
            }

            //LAB_8018268
            if(r7 == '"') {
              MEMORY.ref(4, CPU.sp().value + 0x24).xor(0x1);
              if(MEMORY.ref(4, CPU.sp().value + 0x24).get() != 0) {
                r7 = 0x8e;
              }
            }

            //LAB_801827a
            MEMORY.ref(2, r8 + r6 * 0x2).setu(r7);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            MEMORY.ref(4, CPU.sp().value + 0x28).setu(0);
            break jmp_8018614;
          }

          if(r7 == 0x0 || r7 == 0x2) {
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
            break jmp_8018614;
          }

          if(r7 == 0x8 || r7 == 0x9) {
            //LAB_8018320
            MEMORY.ref(2, r8 + r6 * 0x2).setu(r7);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            MEMORY.ref(2, r8 + r6 * 0x2).setu((int)MEMORY.call(r9, r10) - 1);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            break jmp_8018614;
          }

          if(r7 == 0x10) {
            //LAB_8018486
            final Unit14c charData = getUnit_(playerMapActorIndex_2000434.get());

            //LAB_801849a
            for(r4 = 0; r4 < 15; r4++) {
              MEMORY.ref(2, CPU.sp().value + 0x54 + r4 * 0x2).setu(charData.name_00.get(r4).get());
            }

            r6 = FUN_8017e88(0, CPU.sp().value + 0x54, r6, r8, 0, 0, CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          if(r7 == 0x11) { // Character name
            //LAB_80184e4
            final Unit14c charData = getUnit_((int)MEMORY.call(r9, r10) - 1);

            //LAB_80184f8
            for(r4 = 0; r4 < 15; r4++) { // Copies Isaac's name
              MEMORY.ref(2, CPU.sp().value + 0x54 + r4 * 0x2).setu(charData.name_00.get(r4).get());
            }

            //LAB_8018506
            r6 = FUN_8017e88(0, CPU.sp().value + 0x54, r6, r8, 0, 0, CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          if(r7 == 0x12) {
            //LAB_80184aa
            r5 = (int)MEMORY.call(r9, r10) - 1;
            final Unit14c charData = getUnit_(FUN_8019944(0x1, r11));

            //LAB_80184c4
            for(r4 = 0; r4 < 15; r4++) {
              MEMORY.ref(2, CPU.sp().value + 0x54 + r4 * 0x2).setu(charData.name_00.get(r4).get());
            }

            r6 = FUN_8017e88(0, CPU.sp().value + 0x54, r6, r8, r5, MEMORY.ref(4, CPU.sp().value + 0x18).get(), CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          if(r7 == 0x13) {
            //LAB_80183a6
            r5 = (int)MEMORY.call(r9, r10) - 1;
            decompressString(FUN_8019944(0x3, r11) + 0x741, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x18);
            r6 = FUN_8017e88(0, MEMORY.ref(4, CPU.sp().value + 0xc).get(), r6, r8, r5, MEMORY.ref(4, CPU.sp().value + 0x18).get(), CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          //LAB_801828c
          if(r7 == 0x14) {
            //LAB_80183d8
            r5 = (int)MEMORY.call(r9, r10) - 1;
            r2 = FUN_8019944(0x2, r11) & 0x1ff;
            decompressString(r2 + 0x182, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x18);
            r6 = FUN_8017e88(0, MEMORY.ref(4, CPU.sp().value + 0xc).get(), r6, r8, r5, MEMORY.ref(4, CPU.sp().value + 0x18).get(), CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          if(r7 == 0x15) {
            //LAB_801840e
            decompressString(FUN_8019944(0x4, r11) + 0x333, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x18);
            r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r0 = CPU.addT(r6, 0x0);

            //LAB_8018432
            while(r2 != 0) {
              MEMORY.ref(2, r8 + r0 * 0x2).setu(r2);
              r1 = CPU.addT(r1, 0x2);
              r2 = MEMORY.ref(2, r1).getUnsigned();
              r0 = CPU.addT(r0, 0x1);
              r0 = CPU.andT(r0, 0x1ff);
            }

            r6 = CPU.addT(r0, 0x0);
            break jmp_8018614;
          }

          if(r7 == 0x16) {
            //LAB_8018344
            r1 = FUN_8019944(0x5, r11);
            r3 = r1;
            if(r1 < 0) {
              r3 = -r1;
            }

            //LAB_8018356
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(0x1);
            if(r3 <= 1) {
              MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
            }

            //LAB_8018362
            r5 = CPU.sp().value + 0x44;
            r0 = convertNumberToAscii(r5, r1, 0);
            r4 = CPU.subT(r0, r5);
            if(r4 != 0x10) {
              //LAB_8018374
              //LAB_801837c
              r0 = r4 + r5;
              r1 = r0;

              //LAB_8018384
              while(MEMORY.ref(1, r0).getUnsigned() != 0) {
                MEMORY.ref(2, r8 + r6 * 0x2).setu(MEMORY.ref(1, r1).getUnsigned());
                r6++;
                r4++;
                r1++;
                r6 = CPU.andT(r6, 0x1ff);
                if(r4 == 0x10) {
                  break;
                }

                //LAB_801839c
                r0++;
              }
            }
            break jmp_8018614;
          }

          //LAB_80182e6
          if(r7 == 0x17) {
            //LAB_8018448
            decompressString(getRoomNameStringId_(FUN_8019944(0x6, r11), 0x1) + 0x99b, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x18);
            r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r0 = r6;

            //LAB_8018470
            while(r2 != 0) {
              MEMORY.ref(2, r8 + r0 * 0x2).setu(r2);
              r1 += 0x2;
              r2 = MEMORY.ref(2, r1).getUnsigned();
              r0 = r0 + 1 & 0x1ff;
            }

            r6 = r0;
            break jmp_8018614;
          }

          //LAB_80182ec
          if(r7 == 0x18) {
            //LAB_8018546
            MEMORY.ref(2, r8 + r6 * 0x2).setu(0x8f);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            MEMORY.ref(2, r8 + r6 * 0x2).setu('-');
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            break jmp_8018614;
          }

          //LAB_80182d2
          if(r7 == 0x19) {
            //LAB_8018588
            if(MEMORY.ref(4, CPU.sp().value + 0x18).get() != 0) {
              if(MEMORY.ref(4, CPU.sp().value + 0x34).get() != 0) {
                MEMORY.ref(2, r8 + r6 * 0x2).setu('e');
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, 0x1ff);
              }

              //LAB_80185a2
              MEMORY.ref(2, r8 + r6 * 0x2).setu('s');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
            }
            break jmp_8018614;
          }

          if(r7 == 0x1a) {
            //LAB_801851e
            r0 = (int)MEMORY.call(r9, r10);
            r0 = CPU.subT(r0, 0x1);
            r0 = CPU.lslT(r0, 1);
            r3 = CPU.lslT(r6, 1);
            r2 = CPU.addT(r0, 0x0);
            r6 = CPU.addT(r6, 0x1);
            r2 = CPU.addT(r2, 0x80);
            r6 = CPU.andT(r6, 0x1ff);
            MEMORY.ref(2, r8 + r3).setu(r2);
            r0 = CPU.addT(r0, 0x81);
            MEMORY.ref(2, r8 + r6 * 0x2).setu(r0);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            break jmp_8018614;
          }

          if(r7 == 0x1b) {
            //LAB_80185c0
            MEMORY.ref(2, r8 + r6 * 0x2).setu('\'');
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            if(MEMORY.ref(4, CPU.sp().value + 0x34).get() == 0) {
              MEMORY.ref(2, r8 + r6 * 0x2).setu('s');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
            }
            break jmp_8018614;
          }

          //LAB_80182f4
          if(r7 == 0x1d) {
            //LAB_8018320
            MEMORY.ref(2, r8 + r6 * 0x2).setu(0x1d);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            r0 = (int)MEMORY.call(r9, r10);
            r0 = CPU.addT(r0, 0xffff);
            MEMORY.ref(2, r8 + r6 * 0x2).setu(r0);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            break jmp_8018614;
          }

          if(r7 == 0x1e) {
            //LAB_801831a
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
            break jmp_8018614;
          }

          if(r7 == 0x1 || r7 == 0x3) {
            MEMORY.ref(4, CPU.sp().value + 0x28).setu(1);
          }

          //LAB_80185f4
          MEMORY.ref(2, r8 + r6 * 0x2).setu(r7);
          r6 = CPU.addT(r6, 0x1);
          r6 = CPU.andT(r6, 0x1ff);
          if(r7 == 0x73 || r7 == 0x53) {
            //LAB_8018608
            r3 = 1;
          } else {
            //LAB_8018610
            r3 = 0;
          }

          //LAB_8018612
          MEMORY.ref(4, CPU.sp().value + 0x34).setu(r3);
        }

        //LAB_8018614
        MEMORY.ref(4, CPU.sp().value + 0x1c).incr();
      } while(MEMORY.ref(4, CPU.sp().value + 0x14).get() != 0 && MEMORY.ref(4, CPU.sp().value + 0x1c).get() < 0x200);

      //LAB_8018628
      r3 = CPU.lslT(r6, 1);
      r6 = CPU.addT(r6, 0x1);
      MEMORY.ref(2, r8 + r3).setu(r7);
      r6 = CPU.andT(r6, 0x1ff);
      r2 = CPU.lslT(r6, 1);
      MEMORY.ref(2, r8 + r2).setu(0);
      r3 = CPU.addT(r6, 0x1);
      r3 = CPU.andT(r3, 0x1ff);
      sp2c.textOffset_12b2.set(r3);
      freeSlot(50);
      r0 = MEMORY.ref(2, CPU.sp().value + 0x20).getUnsigned();
      sp2c._12b4.set(r0);
    }

    //LAB_801865a
    if(r11 != 0) {
      FUN_80198dc();
    }

    //LAB_8018678
    r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
    CPU.sp().value += 0x84;
    return r0;
  }

  @Method(0x801868c)
  public static void FUN_801868c(final int r0, final int r1, final int r2, final int r3, final int a4, final ArrayRef<UnsignedShortRef> a5, final int a6) {
    final Struct12fc r9 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r10 = 30;
    int r7 = MEMORY.ref(4, r2).get();
    int r6 = MEMORY.ref(4, r1).get();
    if((a6 & 0x2) == 0) {
      if((a6 & 0x1) != 0) {
        FUN_8018a50(r0, r3, a4, a5);
      } else {
        //LAB_80186d6
        FUN_8018850(r0, r3, a4, a5);
      }
    }

    //LAB_80186e0
    if(MEMORY.ref(4, r3).get() != 0 || MEMORY.ref(4, a4).get() != 0) {
      //LAB_80186ee
      if((a6 & 0x2) == 0) {
        MEMORY.ref(4, r3).addu(0x13).shr(3);
        MEMORY.ref(4, a4).addu(0xf).shr(3);
        if(r9._ea4.get() != 0) {
          MEMORY.ref(4, r3).addu(0x2);
          r10 = 29;
        }

        //LAB_8018722
      }

      //LAB_8018724
      final int r3_0 = r6 + MEMORY.ref(4, r3).get();
      if(r3_0 > r10) {
        r6 = Math.max(r6 - (r3_0 - r10), 0);
      }

      //LAB_8018738
      final int r3_1 = r7 + MEMORY.ref(4, a4).get();
      if(r3_1 > 20) {
        r7 = Math.max(r7 - (r3_1 - 20), 0);
      }

      //LAB_801875a
      MEMORY.ref(4, r1).setu(MathHelper.clamp(r6, 0, r10 - MEMORY.ref(4, r3).get()));
      MEMORY.ref(4, r2).setu(MathHelper.clamp(r7, 0, 20 - MEMORY.ref(4, a4).get()));
    }

    //LAB_8018776
  }

  @Method(0x80187ac)
  public static int FUN_80187ac(final int r0, final int r1, final int r2, final int r3, final int a4) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r0_0 = FUN_8018038(r0, 0);

    if(r5.text_eb0.get(r0_0).get() == 0) {
      return 0;
    }

    //LAB_80187d6
    FUN_801868c(r0_0, r1, r2, r3, a4, null, 0);
    return 1;
  }

  @Method(0x80187fc)
  public static int FUN_80187fc(final int r0, final int r1, final int r2, final int r3, final int a4) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r0_0 = FUN_8018038(r0, 0);
    if(r5.text_eb0.get(r0_0).get() == 0) {
      return 0;
    }

    //LAB_8018826
    FUN_801868c(r0_0, r1, r2, r3, a4, null, 0x1);

    //LAB_801883e
    return 1;
  }

  @Method(0x8018850)
  public static void FUN_8018850(int chrIndex, int r1, final int r2, @Nullable final ArrayRef<UnsignedShortRef> r6) {
    int r3;
    int r5;
    int r7;
    int r10;
    int r11;
    int r12;

    CPU.sp().value -= 0x20;
    final int sp0c = r1;
    final Struct12fc r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r5 = 0;
    r7 = 0;
    r1 = 0;
    final int r8 = CPU.sp().value + 0x18;
    final int r9 = CPU.sp().value + 0x10;
    r10 = 0;
    r11 = 0xf;
    r12 = 0;

    //LAB_801888a
    do {
      int chr;
      do {
        chr = r4.text_eb0.get(chrIndex).get();
        chrIndex = CPU.addT(chrIndex, 0x1);
        chrIndex = CPU.andT(chrIndex, 0x1ff);
        if(chr < ' ') {
          //LAB_80188c6
          switch(chr) { // textbox control code
            case 3:
              r5++;
              MEMORY.ref(2, r8 + r12).setu(r5);
              MEMORY.ref(2, r9 + r12).setu(r1);
              r7 = CPU.cmpT(r7, r1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = r1;
              }

              //LAB_801895a
              r3 = r10;
              CPU.cmpT(r3, 0x2);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r10++;
                r12 = r10 * 0x2;
              }

              //LAB_801896a
              r5 = 0;
              r1 = 0;
              r11 += 0xf;
              continue;

            case 0xe:
            case 0x1c:
              chrIndex = CPU.addT(chrIndex, 0x1);
              chrIndex = CPU.andT(chrIndex, 0x1ff);

            case 8:
            case 0xa:
            case 0xf:
            case 0x11:
              chrIndex = CPU.addT(chrIndex, 0x1);
              chrIndex = CPU.andT(chrIndex, 0x1ff);
              continue;

            case 9:
              r4._eac.set(r4.text_eb0.get(chrIndex).get());
              chrIndex = CPU.addT(chrIndex, 0x1);
              chrIndex = CPU.andT(chrIndex, 0x1ff);
              continue;

            case 0:
            case 1:
              r5 = CPU.addT(r5, 0x1);
              MEMORY.ref(2, r8 + r12).setu(r5);
              MEMORY.ref(2, r9 + r12).setu(r1);
              r7 = CPU.cmpT(r7, r1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = r1;
              }

              //LAB_80189b4
              if(r4._ea4.get() != 0) {
                r7 += 0x2;
              }

              //LAB_80189c0
              MEMORY.ref(4, sp0c).setu(r7);
              MEMORY.ref(4, r2).setu(r11);
              r3 = r7 + 0x13;
              r7 = CPU.lsrT(r3, 3);
              r3 = CPU.lslT(r7, 3);
              r7 = CPU.addT(r3, 0x0);
              r7 = CPU.subT(r7, 0x10);
              if(r6 != null) {
                r5 = 0;

                //LAB_80189de
                for(int r2_0 = 0; r2_0 <= r10; r2_0++) {
                  r3 = MEMORY.ref(2, r8 + r5).getUnsigned();
                  CPU.cmpT(r3, 0x1);
                  if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                    r6.get(r2_0).set(0);
                  } else {
                    //LAB_8018a08
                    //LAB_8018a16
                    int r0_0 = divideS(Math.max(0, r7 - MEMORY.ref(2, r9 + r5).getUnsigned() - 4) << 8, MEMORY.ref(2, r8 + r5).getUnsigned() - 1);
                    CPU.cmpT(r0_0, 0xc00);
                    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                      r0_0 = 0x200;
                    }

                    //LAB_8018a32
                    r6.get(r2_0).set(r0_0);
                  }

                  //LAB_8018a34
                  r5 += 0x2;
                }
              }

              //LAB_8018a3e
              CPU.sp().value += 0x20;
              return;

            default:
              continue;
          }
        }
        if(chr != ' ') {
          break;
        }
        r1 += 0x5;
        r5++; // number of spaces
      } while(true);

      //LAB_80188a8
      int r2_0 = MEMORY.ref(2, 0x8032224 + (chr - ' ') * 0x20).getUnsigned(); //TODO
      if(r4._eac.get() == 1 || r4._eac.get() == 5) {
        //LAB_80188c0
        r2_0++;
      }

      //LAB_80188c2
      r1 += r2_0;
    } while(true);
  }

  @Method(0x8018a50)
  public static void FUN_8018a50(int r0, int r1, int r2, @Nullable final ArrayRef<UnsignedShortRef> array) {
    int r3;
    int r4;
    int r6;
    int r7;
    int r8 = 0;
    final int r9;
    int r10;
    final int r11;
    final int lr;

    CPU.sp().value -= 0x5c;

    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
    r1 = CPU.sp().value + 0x1c;
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, r1).setu(0xf);
    MEMORY.ref(4, r1 + 0x4).setu(0xf);
    MEMORY.ref(4, r1 + 0x8).setu(0xf);
    MEMORY.ref(4, r1 + 0xc).setu(0xf);
    MEMORY.ref(4, r1 + 0x10).setu(0xf);
    MEMORY.ref(4, r1 + 0x14).setu(0xf);
    MEMORY.ref(4, r1 + 0x18).setu(0xf);
    MEMORY.ref(4, r1 + 0x1c).setu(0xf);
    MEMORY.ref(4, r1 + 0x20).setu(0xf);
    MEMORY.ref(4, r1 + 0x24).setu(0xf);
    MEMORY.ref(4, r1 + 0x28).setu(0xf);
    MEMORY.ref(4, r1 + 0x2c).setu(0xf);
    MEMORY.ref(4, r1 + 0x30).setu(0xf);
    MEMORY.ref(4, r1 + 0x34).setu(0xf);
    MEMORY.ref(4, r1 + 0x38).setu(0xf);
    MEMORY.ref(4, r1 + 0x3c).setu(0xf);
    lr = r2;
    r9 = CPU.sp().value + 0x14;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    r10 = 0;
    r4 = 0;
    r6 = 0;
    r7 = 0;
    CPU.r12().value = 0;
    r11 = CPU.sp().value + 0xc;

    //LAB_8018aa4
    loop:
    do {
      r2 = r5.text_eb0.get(r0).get();
      r0 = r0 + 1 & 0x1ff;
      if(r2 > 0x1f) {
        if(r2 != ' ') {
          //LAB_8018ac2
          r2 = MEMORY.ref(2, 0x8032224 + (r2 - ' ') * 0x20).getUnsigned();
          r3 = r5._eac.get();
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          if(r3 == 1 || r3 == 5) {
            //LAB_8018ada
            r2++;
          }

          //LAB_8018adc
          r4 += r2;
        } else {
          r4 += 0x5;
          r6++;
        }
        continue;
      }

      //LAB_8018ae0
      switch(r2) {
        case 3:
          r6++;
          MEMORY.ref(2, r9 + CPU.r12().value).setu(r6);
          MEMORY.ref(2, r11 + CPU.r12().value).setu(r4);
          if(r7 == 0) {
            CPU.cmpT(r10, r4);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r10 = r4;
            }
          }

          //LAB_8018b76
          r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          CPU.cmpT(r3, 0x2);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            r3 = CPU.addT(r3, 0x1);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
            r3 = CPU.lslT(r3, 1);
            CPU.r12().value = r3;
          }

          //LAB_8018b84
          r6 = 0;
          r4 = 0;
          MEMORY.ref(4, r1 + r7 * 0x4).addu(0xf);
          break;

        case 0:
          r6++;
          MEMORY.ref(2, r9 + CPU.r12().value).setu(r6);
          MEMORY.ref(2, r11 + CPU.r12().value).setu(r4);
          if(r7 == 0) {
            CPU.cmpT(r10, r4);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r10 = r4;
            }
          }

          //LAB_8018ba8
          r7++;
          break loop;

        case 1:
          r6++;
          MEMORY.ref(2, r9 + CPU.r12().value).setu(r6);
          MEMORY.ref(2, r11 + CPU.r12().value).setu(r4);

          if(r7 == 0) {
            CPU.cmpT(r10, r4);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r10 = r4;
            }
          }

          //LAB_8018bc2
          r7++;
          break;

        case 0xe:
        case 0x1c:
          r0 = r0 + 1 & 0x1ff;
          r0 = r0 + 1 & 0x1ff;
          break;

        case 9:
          r5._eac.set(r5.text_eb0.get(r0).get());
          // fall through

        case 8:
        case 0xa:
        case 0xf:
        case 0x11:
          r0 = r0 + 1 & 0x1ff;
          break;
      }
    } while(true);

    //LAB_8018be6
    if(r5._ea4.get() != 0) {
      r10 += 2;
    }

    //LAB_8018bf4
    //LAB_8018bfe
    for(r4 = 0; r4 < r7; r4++) {
      if(r4 == 0) {
        MEMORY.ref(4, lr).setu(MEMORY.ref(4, r1).get());
      } else {
        //LAB_8018c0a
        r3 = MEMORY.ref(4, lr).get();
        r2 = MEMORY.ref(4, r1 + r4 * 0x4).get();
        r3 = CPU.cmpT(r3, r2);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          MEMORY.ref(4, lr).setu(r2);
        }
      }

      //LAB_8018c18
    }

    //LAB_8018c20
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    MEMORY.ref(4, r3).setu(r10);
    r3 = r10 + 0x13;
    r3 = CPU.lsrT(r3, 3);
    r3 = CPU.lslT(r3, 3);
    r3 = CPU.subT(r3, 0x10);
    r10 = r3;
    if(array != null) {
      //LAB_8018c3c
      for(r6 = 0; r6 <= MEMORY.ref(4, CPU.sp().value + 0x4).get(); r6++) {
        if(MEMORY.ref(2, r9 + r6 * 0x2).getUnsigned() <= 1) {
          array.get(r8).set(0);
        } else {
          //LAB_8018c6c
          //LAB_8018c7c
          array.get(r8).set(divideS(Math.max(0, r10 - MEMORY.ref(2, r11 + r6 * 0x2).getUnsigned() - 0x4) << 8, MEMORY.ref(2, r9 + r6 * 0x2).getUnsigned() - 1));
        }

        //LAB_8018c8e
        r8++;
      }
    }

    //LAB_8018c9a
    CPU.sp().value += 0x5c;
  }

  @Method(0x8018cac)
  public static int FUN_8018cac(final Panel24 r8, final int r7, final int x, final int y, final int a4) {
    int r0;
    int r1;
    int r9;
    final int r10;

    CPU.sp().value -= 0x90;

    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int sp04 = r6._12b0.get();
    final int r11 = r6._ea8.get();
    if(a4 != 1) {
      if((r8.flags_16.get() & 0x8) != 0) {
        if(boardWramMallocHead_3001e50.offset(37 * 0x4).get() == r8.getAddress()) {
          if(r7 == 0x20) {
            CPU.sp().value += 0x90;
            return 0x3;
          }
        }

        //LAB_8018d06
        if(r7 == 0x20) {
          CPU.sp().value += 0x90;
          return 0x4;
        }

        r10 = getPointerTableEntry(19);

        //LAB_8018d18
        final int size = 0x318;
        final int addr = mallocChip(size);
        DMA.channels[3].SAD.setu(0x80155d0);
        DMA.channels[3].DAD.setu(addr);
        DMA.channels[3].CNT.setu(0x84000000 | size / 0x4);

        MEMORY.setFunction(addr, GoldenSun_801.class, "FUN_80155d0", Panel24.class, int.class, int.class, int.class, int.class);
        final int ret = (int)MEMORY.call(addr, r8, r7, x, y, r10);
        setMallocAddress(addr);

        CPU.sp().value += 0x90;
        return ret;
      }
    }

    //LAB_8018d50
    r9 = 0x5;
    if(r7 == 0x20) {
      r0 = r9;
    } else {
      //LAB_8018d5a
      final GraphicsStruct1c r5 = FUN_8015e8c();
      r0 = 0;
      if(r5 != null) {
        //LAB_8018d68
        r1 = r5.getAddress() - r6._698.getAddress(); //TODO
        r1 = CPU.mulT(r1, 0xb6db6db7);
        r5._04.set(0);
        r5._05.set(1);
        r10 = r1;
        if(a4 == 1) {
          r9 = 0x1;
          r5._05.set(0x2);
        } else {
          //LAB_8018d8e
          final int r3 = r6._eac.get();
          if(r3 == 2) {
            r5._05.set(0x4);
            r5.rotation_0c.set(0);
          } else if(r3 == 3) {
            //LAB_8018dac
            r5._05.set(0x5);
            //LAB_8018da2
          } else if(r3 == 4) {
            //LAB_8018db2
            r5._05.set(0x6);
            r5.rotation_0c.set(0x8);
          } else if(r3 == 5) {
            //LAB_8018dbc
            r5._05.set(0x7);
            r5.rotation_0c.set(0);
          }

          //LAB_8018dc6
          r0 = FUN_80178b0(r7, CPU.sp().value + 0x10);
          if(r0 == 0) {
            r0 = 1;
          }

          //LAB_8018dd4
          r9 = r0;
        }

        //LAB_8018dd6
        if(r5._05.get() == 2) {
          if(r6.vramSlot_12b6.get() == 0x63) {
            r6.vramSlot_12b6.set(getFreeVramSlot());
          }

          //LAB_8018df0
          r5.packet_10.attribs_04.attrib1_02.and(~0x1ff).or((r8.x_0c.get() + r8.w_08.get() - 2) * 8 + 4 & 0x1ff);
          r5.packet_10.attribs_04.y_00.set((r8.y_0e.get() + r8.h_0a.get() - 2) * 8 - 1);
        } else {
          //LAB_8018e5c
          r1 = r10 + r6._12b8.get();
          DMA.channels[3].SAD.setu(CPU.sp().value + 0x10);
          DMA.channels[3].DAD.setu(0x6010000 + r1 * 0x20);
          DMA.channels[3].CNT.setu(0x84000020);

          r5.packet_10.attribs_04.attrib0_00.set(y + (r11 >>> 1) + r8.y_0e.get() * 8 - 2);
          r5.packet_10.attribs_04.attrib1_02.set(x + (sp04 >>> 1) + r8.x_0c.get() * 8 + 2 | 0x4000);
          r5.packet_10.attribs_04.attrib2_04.set(r10 + r6._12b8.get());
        }

        //LAB_8018eac
        r5.z_0f.set(0xfe);
        r5.x_06.set(r5.packet_10.attribs_04.attrib1_02.get() << 23 >>> 23);
        r5.y_08.set(r5.packet_10.attribs_04.y_00.get());
        r5.slot_0e.set(r10);
        r5._00.clear();
        FUN_8016584(r8, r5);

        //LAB_8018ecc
        r0 = r9;
      }
    }

    //LAB_8018ee8
    CPU.sp().value += 0x90;
    return r0;
  }

  @Method(0x8018efc)
  public static void FUN_8018efc(final Panel24 r0, final int chr, final int x, final int y, final int a4) {
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if((y & 0xffff_ffffL) <= (r0.h_0a.get() - 2 & 0xffff_ffffL)) {
      if((x & 0xffff_ffffL) <= (r0.w_08.get() - 2 & 0xffff_ffffL)) {
        if(a4 != 1) {
          //LAB_8018fcc
          CPU.cmpT(chr, 0xff);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            final int offset = (r0.y_0e.get() + y + 1) * 0x20 + r0.x_0c.get() + x + 1;
            if(offset < 640) {
              MEMORY.ref(2, r6.getAddress() + offset * 0x2).setu(chr | 0xf000); //TODO
            }
          }
        } else {
          final GraphicsStruct1c r5 = FUN_8015e8c();
          if(r5 != null) {
            r5._05.set(0x2);
            if(r6.vramSlot_12b6.get() == 0x63) {
              r6.vramSlot_12b6.set(getFreeVramSlot());
            }

            //LAB_8018f5a
            r5.packet_10.attribs_04.attrib1_02.and(~0x1ff).or((r0.x_0c.get() + r0.w_08.get() - 2) * 0x8 + 0x4 & 0x1ff);
            r5.packet_10.attribs_04.y_00.set((r0.y_0e.get() + r0.h_0a.get() - 2) * 0x8 - 1);
            r5.x_06.set(r5.packet_10.attribs_04.attrib1_02.get() << 23 >>> 23);
            r5.y_08.set(r5.packet_10.attribs_04.y_00.get());
            r5._00.clear();
            r5.slot_0e.set((r5.getAddress() - r6.getAddress() - 0x698) * 0xb6db6db7); //TODO
            if(r5._05.get() == 0) {
              r5._05.set(0);
            }

            //LAB_8018fc2
            FUN_8016584(r0, r5);
          }
        }
      }
    }

    //LAB_8018ff0
  }

  @Method(0x8019000)
  public static void FUN_8019000(final Panel24 r0, int r1, int r2, int r3, final int a4) {
    int r4;
    int r5;
    final int r7;

    r4 = r3;
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r3 = r0.h_0a.get();
    r7 = r1;
    r4 = r4 + 0x1;
    r1 = r2;
    r3 = r3 - 0x1;
    r2 = a4;
    r1 = r1 + 0x1;
    if((r4 & 0xffff_ffffL) <= (r3 & 0xffff_ffffL)) {
      r3 = r0.w_08.get();
      r3 = r3 - 0x1;
      if((r1 & 0xffff_ffffL) <= (r3 & 0xffff_ffffL)) {
        r5 = 0xf000;
        if(r2 != 0x3) {
          if((r2 & 0xffff_ffffL) > (0x3 & 0xffff_ffffL)) {
            //LAB_8019038
            r5 = 0x1000;
            if(r2 != 0x4) {
              //LAB_8019040
              r5 = 0x0;
            }
          } else {
            r5 = 0xe000;
            if(r2 != 0x2) {
              r5 = 0x0;
            }
          }
        }

        //LAB_8019042
        if(r2 != 0x1) {
          if((r2 & 0xffff_ffffL) >= (0x1 & 0xffff_ffffL) && (r2 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL)) {
            r2 = r0.y_0e.get() + r4;
            r3 = r0.x_0c.get() + r1;
            r2 = r2 << 5;
            final int r0_0 = r2 + r3;
            if((r0_0 & 0xffff_ffffL) < 640) {
              MEMORY.ref(2, r6._00.getAddress() + r0_0 * 0x2).setu(r5 | r7);
            }
          } else {
            //LAB_801906a
            r2 = r0.y_0e.get();
            r3 = r0.x_0c.get();
            r2 = r2 + r4;
            r3 = r3 + r1;
            r2 = r2 << 5;
            final int r0_0 = r2 + r3;
            if((r0_0 & 0xffff_ffffL) < 640) {
              MEMORY.ref(2, r6._00.getAddress() + r0_0 * 0x2).setu(r7);
            }
          }
        }
      }
    }

    //LAB_8019082
  }

  @Method(0x801908c)
  public static void FUN_801908c(final GraphicsStruct1c r0) {
    CPU.sp().value -= 0x8;

    int r7 = 0x100;
    if(r0._05.get() == 0x9) {
      //LAB_80190b6
      r7 = MEMORY.ref(2, 0x80366f8 + (r0.rotation_0c.get() & 0x1f) * 0x2).getUnsigned(); //TODO
      r0.rotation_0c.incr();
    } else if(r0._05.get() == 0xa) {
      //LAB_80190c8
      r7 = MEMORY.ref(2, 0x80366f8 + (r0.rotation_0c.get() & 0x1f) * 0x2).getUnsigned() >>> 1; //TODO
      r0.rotation_0c.incr();
    } else if(r0._05.get() == 0xb) {
      //LAB_80190da
      if(r0.rotation_0c.get() < 8) {
        r7 = MEMORY.ref(2, 0x80366f8 + 0x20 + r0.rotation_0c.get() * 0x4).getUnsigned(); //TODO
        r0.rotation_0c.incr();
      }
    } else if(r0._05.get() == 0xc) {
      //LAB_80190f0
      if(r0.rotation_0c.get() < 8) {
        r7 = MEMORY.ref(2, 0x80366f8 + 0x20 + r0.rotation_0c.get() * 0x4).getUnsigned() >>> 1; //TODO
        r0.rotation_0c.incr();
      }
    }

    //LAB_8019106
    final RenderPacket0c packet = r0.packet_10;
    if(r7 == 0x100) {
      packet.attribs_04.attrib1_02.and(~0x3e00); // mask off upper flags
      packet.attribs_04.flags_01.and(~0x3); // mask off rotation/scaling and double size
      packet.attribs_04.attrib1_02.or(r0.x_06.get() & 0x1ff); // x
      packet.attribs_04.y_00.set(r0.y_08.get()); // y
    } else {
      //LAB_8019124
      MEMORY.ref(2, CPU.sp().value).setu(r7 & 0xffff);
      MEMORY.ref(2, CPU.sp().value + 0x2).setu(r7 & 0xffff);
      MEMORY.ref(2, CPU.sp().value + 0x4).set(0);
      packet.attribs_04.attrib1_02.and(~0x3e00).or((addRotScaleParams(CPU.sp().value) & 0x1f) << 9); // upper flags

      if(r7 > 0x100) {
        packet.attribs_04.flags_01.or(0x3); // mask off rotation/scaling and double size
        packet.attribs_04.attrib1_02.and(~0x1ff).or(r0.x_06.get() - 8 & 0x1ff); // x
        packet.attribs_04.y_00.set((r0.y_08.get() & 0xff) - 8); // y
      } else {
        //LAB_8019194
        packet.attribs_04.flags_01.and(~0x3).or(0x1); // mask off double size and mask on rotation/scaling
        packet.attribs_04.attrib1_02.and(~0x1ff).or(r0.x_06.get() & 0x1ff); // x
        packet.attribs_04.y_00.set(r0.y_08.get()); // y
      }
    }

    //LAB_80191b4
    CPU.sp().value += 0x8;
  }

  @Method(0x80191cc)
  public static void FUN_80191cc() {
    CPU.sp().value -= 0x18;

    final Struct12fc r9 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    //LAB_80191ee
    for(int r11 = 0; r11 < 8; r11++) {
      final Panel24 r10 = r9._500.get(r11);

      if((r10.flags_16.get() & 0x1) != 0) {
        //LAB_80191fc
        GraphicsStruct1c r6 = r10._00.derefNullable();

        //LAB_8019206
        while(r6 != null) {
          final RenderPacket0c r7 = r6.packet_10;

          if(r10._12.get() == 0x4) {
            r6.rotation_0c.set(0x2);
            r6._05.set(0x8);
          }

          //LAB_801921a
          int r5;
          switch(r6._05.get()) {
            case 2:
              if(r9.vramSlot_12b6.get() != 0x60) {
                //LAB_8019288
                //TODO
                final int r2 = 0x80368d4 + (ticks_3001800.get() >>> 2 & 0x7) * 0x80;
                r7.attribs_04.attrib2_04.and(~0x3ff).or(allocateSpriteSlot(r9.vramSlot_12b6.get(), 0x80, r2) & 0x3ff);
                r6.slot_0e.set(r7.attribs_04.attrib2_04.get() & 0xff);
                r5 = r7.attribs_04.flags_01.get() & ~0xc & ~0x10 | 0x20;
                r5 = r5 & 0x3f | 0x80;
                r7.attribs_04.flags_01.set(r5);
                r7.attribs_04.attrib1_02.and(~0xc000); // mask off obj size
                r7.attribs_04.y_00.set(r6.y_08.get() + MEMORY.ref(1, 0x8033e60 + modU(ticks_3001800.get(), 0x50)).getUnsigned() + 2);
                r7.attribs_04.flags_01.set(r5 & ~0x3);
                r7.attribs_04.attrib1_02.and(~0x3e00); // mask off rotation/scaling/flip
              }
              break;

            case 5:
              if((ticks_3001800.get() & 0x1) != 0) {
                //LAB_801931e
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6.x_06.get() + ((rand() * 3 >>> 16) + (rand() * 3 >>> 16) >>> 1) - 1 & 0x1ff);
                r7.attribs_04.y_00.set(r6.y_08.get() + ((rand() * 3 >>> 16) + (rand() * 3 >>> 16) >>> 1) - 1);
              }
              break;

            case 6:
              if(r6.rotation_0c.get() == 0) {
                r7.attribs_04.attrib1_02.and(~0x3e00); // mask off rotation/scaling/flip
                r7.attribs_04.flags_01.and(~0x3);
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6.x_06.get() & 0x1ff);
                r7.attribs_04.y_00.set(r6.y_08.get());
              } else {
                //LAB_8019388
                MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x2000200);
                MEMORY.ref(4, CPU.sp().value + 0x14).and(~0xffff);
                r7.attribs_04.attrib1_02.and(~0x3e00).or((addRotScaleParams(CPU.sp().value + 0x10) & 0x1f) << 9);
                r7.attribs_04.flags_01.or(0x3);
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6.x_06.get() - 5 & 0x1ff);
                r7.attribs_04.y_00.set(r6.y_08.get() - 5);
                r6.rotation_0c.decr();
              }
              break;

            case 7:
              r5 = CPU.sp().value + 0x10;
              MEMORY.ref(2, r5).setu(0x100);
              MEMORY.ref(2, r5 + 0x2).setu(0x100);
              r6.rotation_0c.add(0x300);
              MEMORY.ref(2, r5 + 0x4).setu(r6.rotation_0c.get());
              r7.attribs_04.attrib1_02.and(~0x3e00).or((addRotScaleParams(r5) & 0x1f) << 9);
              r7.attribs_04.flags_01.and(~0x3).or(0x1);
              r7.attribs_04.attrib1_02.and(~0x1ff).or(r6.x_06.get() - (sin(MEMORY.ref(2, r5 + 0x4).getUnsigned() + 0xe800) >> 14) - 2 & 0x1ff);
              r7.attribs_04.y_00.set(r6.y_08.get() - (cos(MEMORY.ref(2, r5 + 0x4).getUnsigned() + 0x6800) >> 14) - 2);
              break;

            case 4:
              if((ticks_3001800.get() & 0x1) != 0) {
                r6.rotation_0c.incr();
              }

              //LAB_801948e
              r7.attribs_04.attrib1_02.and(~0x1ff).or(r6.x_06.get() + MEMORY.ref(1, 0x8033eb0 + (modU(r6.rotation_0c.get(), 0x14) & 0xffff) * 0x2).get() & 0x1ff);
              r7.attribs_04.y_00.set(r6.y_08.get() + MEMORY.ref(1, 0x8033eb0 + (modU(r6.rotation_0c.get(), 0x14) & 0xffff) * 0x2 + 0x1).getUnsigned() - 2);
              break;

            case 0x11:
              r6.rotation_0c.incr();
              r7.attribs_04.y_00.set(r6.y_08.get() - MEMORY.ref(1, 0x8033ee8 + (r6.rotation_0c.get() & 0xf)).getUnsigned()); //TODO
              break;

            case 0xe:
            case 0xf:
            case 0x10:
              r6.rotation_0c.incr();
              r7.attribs_04.y_00.set(r6.y_08.get() + MEMORY.ref(1, 0x8033ee8 + (r6.rotation_0c.get() & 0xf)).getUnsigned()); //TODO
              break;

            case 0x12:
              r6.rotation_0c.incr();
              r7.attribs_04.attrib1_02.and(~0x1ff).or(r6.x_06.get() - MEMORY.ref(1, 0x8033ee8 + (r6.rotation_0c.get() & 0xf)).get() & 0x1ff); //TODO
              r7.attribs_04.y_00.set(r6.y_08.get() + MEMORY.ref(1, 0x8033ee8 + r6.rotation_0c.get() & 0xf).getUnsigned()); //TODO
              break;

            case 8:
              if(r6.rotation_0c.get() != 0) {
                MEMORY.ref(2, CPU.sp().value + 0x10).setu(0x140);
                MEMORY.ref(2, CPU.sp().value + 0x12).setu(0x140);
                MEMORY.ref(2, CPU.sp().value + 0x14).setu(0);
                r7.attribs_04.attrib1_02.and(~0x3e00).or((addRotScaleParams(CPU.sp().value + 0x10) & 0x1f) << 9);
                r7.attribs_04.flags_01.or(0x3);
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6.x_06.get() - 8 & 0x1ff);
                r7.attribs_04.y_00.set(r6.y_08.get() - 8);
                r6.rotation_0c.and(0xffff);
              } else {
                //LAB_80195b0
                r7.attribs_04.attrib1_02.and(~0x3e00);
                r7.attribs_04.flags_01.and(~0x3);
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6.x_06.get() & 0x1ff);
                r7.attribs_04.y_00.set(r6.y_08.get());
              }
              break;

            case 9:
            case 0xa:
            case 0xb:
            case 0xc:
              FUN_801908c(r6);
              break;
          }

          //default/end
          //LAB_80195e0
          if(r6._05.get() == 0x2) {
            if(r9.vramSlot_12b6.get() != 0x60) {
              insertIntoRenderQueue(r7, r6.z_0f.get());
            }
          } else {
            //LAB_80195fa
            if(r6._05.get() != 0xd) {
              insertIntoRenderQueue(r7, r6.z_0f.get());
            }
          }

          //LAB_8019606
          r6 = r6._00.derefNullable();

          //LAB_801960c
        }
      }

      //LAB_8019618
    }

    //LAB_8019628
    CPU.sp().value += 0x18;
  }

  @Method(0x801964c)
  public static void FUN_801964c(final int r0, final int r1) {
    decompressString(r0, r1, 0x7fffffff);
  }

  @Method(0x801965c)
  public static void FUN_801965c(final int r0, final ArrayRef<UnsignedShortRef> out, final int len) {
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r6.textOffset_12b2.set(0);
    FUN_8018038(r0, 1);

    int i;
    for(i = 0; i < len; i++) {
      final int chr = r6.text_eb0.get(i).get();
      out.get(i).set(chr);
      if(chr == 0) {
        break;
      }

      //LAB_8019690
    }

    //LAB_80196a8
    //LAB_80196ac
    //LAB_80196ae
    out.get(i).set(0);
  }

  @Method(0x80196c4)
  public static void decompressString(final int stringId, final int out, final int len) {
    int r3;
    final int r5;
    int r6;
    int r7;

    r7 = len;
    r3 = boardWramMallocHead_3001e50.offset(50 * 0x4).get();
    CPU.sp().value -= 0xc;
    r6 = out;

    if(r3 == 0) {
      final int size = 0x140;
      final int addr = mallocSlotChip(50, size);
      DMA.channels[3].SAD.setu(0x8015430);
      DMA.channels[3].DAD.setu(addr);
      DMA.channels[3].CNT.setu(0x84000000 | size / 0x4);

      MEMORY.setFunction(addr, CopiedSegment8015430.class, "FUN_8015430", int.class);

      r3 = addr;
    }

    //LAB_8019706
    r5 = CPU.sp().value;
    FUN_8019bac(r5, stringId);

    //LAB_8019770
    int r0_0 = (int)MEMORY.call(r3, r5);

    //LAB_8019718
    while(r0_0 != 0) {
      if(r0_0 == 0xe) {
        //LAB_8019730
        r7 -= 0x3;
        if(r7 <= 0) {
          break;
        }
        MEMORY.ref(2, r6).setu(r0_0);
        r6 += 0x2;
        r0_0 = (int)MEMORY.call(r3, r5) + 0xffff;
        MEMORY.ref(2, r6).setu(r0_0);
        r6 += 0x2;
        r0_0 = (int)MEMORY.call(r3, r5) + 0xffff;
        //LAB_801972a
      } else if(r0_0 >= 0x8 && r0_0 <= 0xc || r0_0 == 0xf) {
        //LAB_8019750
        r7--;
        if(r7 <= 0) {
          break;
        }
        MEMORY.ref(2, r6).setu(r0_0);
        r6 += 0x2;
        r0_0 = (int)MEMORY.call(r3, r5) + 0xffff;
      } else {
        //LAB_8019766
        r7--;
        if(r7 <= 0) {
          break;
        }
      }

      //LAB_801976c
      MEMORY.ref(2, r6).setu(r0_0);
      r6 += 0x2;

      r0_0 = (int)MEMORY.call(r3, r5);
    }

    //LAB_801977a
    if(r3 == 0) {
      freeSlot(50);
    }

    //LAB_8019786
    CPU.sp().value += 0xc;
    MEMORY.ref(2, r6).setu(0);
  }

  @Method(0x8019854)
  public static void FUN_8019854(final GraphicsStruct28 r0) {
    final Panel24 r3 = r0._00.deref();

    if(r3._12.get() == 4) {
      drawPanelBackground(r3.x_0c.get() - 1, r3.y_0e.get() - 1, r3.w_08.get() + 2, r3.h_0a.get() + 2);
      r0._14.decr();

      if(r0._14.get() == 0) {
        r3._12.set(r0._14.get());
        clearPanelBuffer(r3.x_0c.get() - 1, r3.y_0e.get() - 1, r3.w_08.get() + 2, r3.h_0a.get() + 2);
        drawPanelBackground(r3.x_0c.get(), r3.y_0e.get(), r3.w_08.get(), r3.h_0a.get());
      }
    }

    //LAB_80198c4
  }

  @Method(0x80198dc)
  public static void FUN_80198dc() {
    final Struct12fc r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    //LAB_80198ee
    for(int r1 = 0; r1 < 8; r1++) {
      r3._12bc.get(r1).set(0);
      r3._12dc.get(r1).set(0);
    }
  }

  @Method(0x8019908)
  public static void FUN_8019908(final int charId, final int r1) {
    final Struct12fc r1_0 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    //LAB_801991c
    for(int i = 0; i < 8; i++) {
      if(r1_0._12dc.get(i).get() == 0) {
        r1_0._12bc.get(i).set(charId);
        r1_0._12dc.get(i).set(r1);
        break;
      }

      //LAB_8019928
    }

    //LAB_8019932
  }

  @Method(0x8019944)
  public static int FUN_8019944(final int r0, final int r1) {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r6 = 0;

    for(int i = 0; i < 8; i++) {
      if(r2._12dc.get(i).get() == r0) {
        r6 = r2._12bc.get(i).get();

        if(r1 != 0) {
          r2._12bc.get(i).set(0);
          r2._12dc.get(i).set(0);
        }
      }
    }

    //LAB_8019988
    return r6;
  }

  @Method(0x801999c)
  public static int FUN_801999c(final GraphicsStruct28 r0) {
    int r5 = 0;
    if(boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._12f9.get() != 0 && FUN_80f9048() == 0) {
      r5 = 1;
    }

    //LAB_80199ba
    if((heldButtonsLastFrame_3001ae8.get() & 0x303) != 0) { // A/B/L/R
      r5 = 1;
    }

    //LAB_80199c8
    if(r5 == 0) {
      //LAB_80199d4
      return 0;
    }

    r0._14.set(0);

    //LAB_80199d6
    return 1;
  }

  @Method(0x80199ec)
  public static int FUN_80199ec(final GraphicsStruct28 r0) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r3 = r5._12f9.get();
    int r6 = 0;

    if(r3 != 0 && FUN_80f9048() == 0) {
      r6 = 1;
    }

    //LAB_8019a0a
    final int input;
    if(r5._ea4.get() != 0) {
      input = accumulatedButtons_3001af8.get();
    } else {
      input = pressedButtons_3001c94.get();
    }

    //LAB_8019a1c
    if((input & 0x303) != 0) { // A/B/L/R
      r6 = 1;
    }

    //LAB_8019a26
    if(r6 == 0) {
      //LAB_8019a32
      return 0;
    }

    r0._14.set(0);

    //LAB_8019a34
    return 1;
  }

  @Method(0x8019a54)
  public static void FUN_8019a54() {
    final ArrayRef<GraphicsStruct28> r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._620;

    //LAB_8019a62
    for(int r6 = 0; r6 < 3; r6++) {
      final GraphicsStruct28 r5 = r3.get(r6);
      final Panel24 r0 = r5._00.derefNullable();

      if(r0 != null) {
        if(r0._18.get() == 0 && r0._1a.get() == 0) {
          final int r2 = r0.flags_16.get();
          if(r2 != 0 && r0._14.get() != 0) {
            FUN_8016418(r0, r2 & 0x2);
          }
        }
      }

      //LAB_8019a88
    }

    sleep(0xa);
  }

  @Method(0x8019aa0)
  public static void FUN_8019aa0(final int r0, final int r1, final int r2) {
    CPU.sp().value -= 0x18;
    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0x8);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x8);
    final int r10 = FUN_8018038(r0, 0x1);

    if(r8.text_eb0.get(r10).get() != 0) { // Address of textbox text ("Isaac, wake up!")
      FUN_80187ac(r0, CPU.sp().value + 0x14, CPU.sp().value + 0x10, CPU.sp().value + 0xc, CPU.sp().value + 0x8);
      final int r2_0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      final int r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      final int r0_0 = 30 - r2_0 >> 1;
      final int r3 = 15 - r4 >> 1;
      final int r1_0 = r3 + r2;
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0_0);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1_0);

      final Panel24 r5;
      if(r1 != 0) {
        r5 = addPanel(r0_0, r1_0, r2_0, r4, 0);
      } else {
        //LAB_8019b10
        r5 = addPanel(r0_0, r1_0, 0, 0, 0x2);
        r5.w_08.set(0);
        r5.h_0a.set(0);
      }

      //LAB_8019b22
      if(FUN_80165d8(r5, r10, 0, 0, 0, 0) != null) {
        //LAB_8019b46
        //LAB_8019b40
        while(FUN_8017364() == 0) {
          sleep(0x1);
        }

        if(r1 == 0) {
          FUN_8016418(r5, 0);

          //LAB_8019b5c
          while(FUN_8017394(r5) == 0) {
            sleep(0x1);
          }
        } else {
          //LAB_8019b6e
          FUN_8016418(r5, 1);
        }

        //LAB_8019b76
        r8._12f4.set(0);
        r8._12f6.set(0);
      } else {
        FUN_8016418(r5, 0x1);
      }
    }

    //LAB_8019b84
    CPU.sp().value += 0x18;
  }

  @Method(0x8019ba0)
  public static int FUN_8019ba0(final int r0) {
    return FUN_8018038(r0, 1);
  }

  @Method(0x8019bac)
  public static void FUN_8019bac(final int r0, final int r1) {
    final int size = 0x60;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x8015570);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(addr, CopiedSegment8015570.class, "FUN_8015570", int.class, int.class);
    MEMORY.call(addr, r0, r1);
    setMallocAddress(addr);
  }

  @Method(0x8019d0c)
  public static void FUN_8019d0c() {
    final Struct12fc r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r3._12ec.set(999);
    r3._12ee.set(999);
  }

  @Method(0x8019d2c)
  public static int FUN_8019d2c(final int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;

    r1 = -1;
    r2 = 0;
    CPU.cmpT(r0, 0x13);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r4 = 0x80367e4; //TODO
      r3 = MEMORY.ref(2, r4).get();
      if(r3 != -1) {
        if(r3 == r0) {
          r1 = MEMORY.ref(2, r4 + 0x2).get();
        } else {
          //LAB_8019d4c
          do {
            r2 = CPU.addT(r2, 0x2);
            r3 = MEMORY.ref(2, r4 + r2 * 0x2).get();
            if(r3 == -1) {
              return -1;
            }
          } while(r3 != r0);

          r2 = CPU.addT(r2, 0x1);
          r1 = MEMORY.ref(2, r4 + r2 * 0x2).get();
        }
      }
    } else {
      //LAB_8019d66
      r4 = 0x803680c; //TODO
      r3 = MEMORY.ref(2, r4).get();
      if(r3 != -1) {
        if(r3 == r0) {
          r1 = MEMORY.ref(2, r4 + 0x2).get();
        } else {
          //LAB_8019d7e
          do {
            r2 = CPU.addT(r2, 0x2);
            r3 = MEMORY.ref(2, r4 + r2 * 0x2).get();
            if(r3 == -1) {
              return -1;
            }
          } while(r3 != r0);

          r2 = CPU.addT(r2, 0x1);
          r1 = MEMORY.ref(2, r4 + r2 * 0x2).get();
        }

        //LAB_8019d96
        r1 = CPU.addT(r1, 0x80);
      }
    }

    //LAB_8019d98
    return r1;
  }

  @Method(0x8019da8)
  public static Panel24 FUN_8019da8(final int spriteDataIndex, final int r1, final int x, final int y) {
    if(FUN_8019d2c(spriteDataIndex) == -1) {
      return null;
    }

    //LAB_8019dd4
    final Panel24 r5;
    final int r8;
    if(boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea4.get() != 0) {
      r5 = addPanel(x, y, 0x6, 0x5, 0x2);
      r8 = 0;
    } else {
      //LAB_8019dfe
      r5 = addPanel(x, y, 0x5, 0x5, 0x2);
      r8 = -4;
    }

    //LAB_8019e10
    if(r5 != null) {
      FUN_801ec6c(spriteDataIndex, r1, -1, r5, r8, -4);
    }

    //LAB_8019e2a
    //LAB_8019e2c
    return r5;
  }

  @Method(0x8019e48)
  public static void FUN_8019e48(int r0) {
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r3;

    r0 = FUN_8019d2c(r0);
    if(r0 != -1) {
      if(r6._12ee.get() == r0) {
        r3 = 1;
        //LAB_8019e78
      } else if(r6._12ec.get() == r0) {
        r3 = 0;
      } else {
        return;
      }

      //LAB_8019e84
      r0 = r6._12f0.get(r3).get();

      //LAB_8019e8e
      for(int r1 = 0; r1 < 8; r1++) {
        final Panel24 r5 = r6._500.get(r1);
        final GraphicsStruct1c r2 = r5._00.derefNullable();

        // Retail bug: null check added to fix null pointer dereference
        if(r2 != null && r2._04.get() == 2 && r2.slot_0e.get() == r0) {
          //LAB_8019e6e
          FUN_8016418(r5, 0x2);
          break;
        }

        //LAB_8019e9c
      }
    }

    //LAB_8019ea4
  }

  @Method(0x8019ed0)
  public static int FUN_8019ed0() {
    return (0x802e108 - 0x802de88) / 0x4;
  }

  @Method(0x8019ee4)
  public static void FUN_8019ee4(final int itemId, final int r1, final int r2, final int r3, final int a4) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x801a088)
  public static int FUN_801a088(final int itemId, final int r1) {
    final Item2c sp00 = getItem_(itemId & 0x1ff);
    final int r5 = MEMORY.ref(4, 0x3001e94).get();
    if(r5 == 0) {
      return -1;
    }

    //LAB_801a0bc
    int sp04 = 0;
    if((r1 & 0x1) != 0x0) {
      MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x8029a10 + 0x8).get());
      MEMORY.ref(2, r5 + 0x600).setu(0x2);
      MEMORY.ref(2, r5 + 0x602).setu(0x2);
      FUN_801a5a4(r5, 0);
      sp04 = 0x1;
    }

    //LAB_801a0ec
    MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x8029ee4 + sp00.icon_06.get() * 0x4).get());
    MEMORY.ref(2, r5 + 0x600).setu(0x2);
    MEMORY.ref(2, r5 + 0x602).setu(0x2);

    FUN_801a5a4(r5, sp04);

    if((r1 & 0x8) != 0x0 && (itemId & 0x400) != 0x0) {
      MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x8029acc + 0x4).get());
      MEMORY.ref(2, r5 + 0x600).setu(0x2);
      MEMORY.ref(2, r5 + 0x602).setu(0x2);
      FUN_801a5a4(r5, 0x1);
    }

    //LAB_801a148
    if((r1 & 0x10) != 0x0 && (itemId & 0x200) != 0x0) {
      MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x8029acc).get());
      MEMORY.ref(2, r5 + 0x600).setu(0x2);
      MEMORY.ref(2, r5 + 0x602).setu(0x2);
      FUN_801a5a4(r5, 0x1);
    }

    //LAB_801a180
    if((r1 & 0x20) != 0x0 && (itemId & 0x200) != 0x0) {
      if((sp00.flags_03.get() & Item2c.FLAG_CURSED_01) != 0 && (sp00.flags_03.get() & Item2c.FLAG_CANT_REMOVE_02) != 0x0) {
        MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x8029acc + 0x8).get());
        MEMORY.ref(2, r5 + 0x600).setu(0x2);
        MEMORY.ref(2, r5 + 0x602).setu(0x2);
        FUN_801a5a4(r5, 0x1);
      }
    }

    //LAB_801a1cc
    int r10 = 0;
    if((r1 & 0x2) != 0) {
      r10 = ((itemId & 0xf800) >>> 11) + 1;
      if(r10 <= 1) {
        r10 = 0;
      }
    }

    //LAB_801a1f0
    if((r1 & 0x4) != 0) {
      r10 = ((itemId & 0xf800) >>> 11) + 1;
    }

    //LAB_801a20a
    if(r10 != 0x0 && r10 <= 0x1e) {
      MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x8029b68 + modS(r10, 10) * 0x4).get());
      MEMORY.ref(2, r5 + 0x600).setu(0x2);
      MEMORY.ref(2, r5 + 0x602).setu(0x2);
      FUN_801a5a4(r5, 0x1);

      final int r0 = divideS(r10, 10);
      if(r0 != 0) {
        MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x8029b68 + 0x24 + r0 * 0x4).get());
        MEMORY.ref(2, r5 + 0x600).setu(0x2);
        MEMORY.ref(2, r5 + 0x602).setu(0x2);
        FUN_801a5a4(r5, 0x1);
      }
    }

    //LAB_801a26e
    //LAB_801a272
    return 0x100;
  }

  @Method(0x801a2a4)
  public static int FUN_801a2a4(final int itemId, final int r1, final int vramSlot) {
    final int r5 = mallocSlotChip(17, 0x608);
    FUN_801a088(itemId, r1);
    allocateSpriteSlot(vramSlot, 0x80, r5 + 0x400);
    freeSlot(17);
    return 1;
  }

  @Method(0x801a2ec)
  public static int FUN_801a2ec(final int itemId, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x801a32c)
  public static int FUN_801a32c(final int itemId, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  /** Opening a chest */
  @Method(0x801a370)
  public static void FUN_801a370(final int itemId) {
    final int r6 = boardWramMallocHead_3001e50.offset(17 * 0x4).get();
    final Item2c item = getItem_(itemId & 0x1ff);
    if(itemId != 0) {
      MEMORY.ref(4, r6 + 0x604).setu(MEMORY.ref(4, 0x8029ee4 + item.icon_06.get() * 0x4).get());
    } else {
      //LAB_801a394
      MEMORY.ref(4, r6 + 0x604).setu(MEMORY.ref(4, 0x8029ee4).get());
    }

    //LAB_801a39e
    MEMORY.ref(2, r6 + 0x600).setu(0x2);
    MEMORY.ref(2, r6 + 0x602).setu(0x2);
    FUN_801a5a4(r6, 0);
  }

  @Method(0x801a3d0)
  public static void FUN_801a3d0(final int itemId, final int r1, final int r2, final int r3, final int a4) {
    FUN_801a404(getAbility_(itemId).icon_04.get(), r1, r2, r3, a4);
  }

  @Method(0x801a404)
  public static void FUN_801a404(final int r0, final int r1, final int r2, final int r3, final int a4) {
    final int r5 = mallocSlotChip(17, 0x608);
    final int r6;
    if(r0 >= FUN_8019ed0()) {
      r6 = 0;
    } else {
      r6 = r0;
    }

    //LAB_801a430
    final int r8;
    if(r1 != 0) {
      MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x8029a10 + 0x8).get());
      MEMORY.ref(2, r5 + 0x600).setu(2);
      MEMORY.ref(2, r5 + 0x602).setu(2);
      FUN_801a5a4(r5, 0);
      r8 = 1;
    } else {
      r8 = 0;
    }

    //LAB_801a45a
    MEMORY.ref(4, r5 + 0x604).setu(MEMORY.ref(4, 0x802de88 + r6 * 0x4).get());
    MEMORY.ref(2, r5 + 0x600).setu(2);
    MEMORY.ref(2, r5 + 0x602).setu(2);
    FUN_801a5a4(r5, r8);

    if(a4 == 0) {
      MEMORY.ref(4, r2).setu(getFreeVramSlot());
    }

    //LAB_801a48c
    MEMORY.ref(4, r3).setu(allocateSpriteSlot(MEMORY.ref(4, r2).get(), 0x80, r5 + 0x400));
    freeSlot(17);
  }

  @Method(0x801a4fc)
  public static void FUN_801a4fc(int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    if(r0 < 0 || r0 > 0x7f) {
      r0 -= 0x70;
    }

    final int r6 = mallocSlotChip(17, 0x608);
    final int ptr = getPointerTableEntry(240);

    //LAB_801a522
    final int r5_0 = ptr + MEMORY.ref(2, ptr + r0 * 0x2).getUnsigned();
    MEMORY.ref(4, 0x604 + r6).setu(r5_0 + 0x20);
    MEMORY.ref(2, 0x600 + r6).setu(0x4);
    MEMORY.ref(2, 0x602 + r6).setu(0x4);
    FUN_801a5a4(r6, 0);
    if(a5 == 0) {
      MEMORY.ref(4, r2).setu(getFreeVramSlot());
    }

    //LAB_801a556
    MEMORY.ref(4, r3).setu(allocateSpriteSlot(MEMORY.ref(4, r2).get(), 0x200, r6 + 0x400));
    freeSlot(17);
    DMA.channels[3].SAD.setu(r5_0);
    DMA.channels[3].DAD.setu(0x5000200 + a4 * 0x20);
    DMA.channels[3].CNT.setu(0x80000010);
  }

  @Method(0x801a5a4)
  public static void FUN_801a5a4(final int r0, final int r1) {
    final int size1 = 0x278;
    DMA.channels[3].SAD.setu(0x8015afc);
    DMA.channels[3].DAD.setu(mallocSlotChip(49, size1));
    DMA.channels[3].CNT.setu(0x84000000 | size1 / 4);

    MEMORY.setFunction(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), CopiedSegment8015afc.class, "FUN_8015afc", int.class, int.class);
    MEMORY.call(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), MEMORY.ref(4, r0 + 0x604).get(), r0);
    freeSlot(49);

    final int addr;
    final int size2;
    if(r1 != 0) {
      addr = 0x8015d74;
      size2 = 0x9c;
    } else {
      //LAB_801a5fe
      addr = 0x8015e10;
      size2 = 0x7c;
    }

    //LAB_801a612
    DMA.channels[3].SAD.setu(addr);
    DMA.channels[3].DAD.setu(mallocSlotChip(49, size2));
    DMA.channels[3].CNT.setu(0x84000000 | size2 / 4);

    MEMORY.setFunction(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), CopiedSegment_8015d74_8015e10.class, "FUN_%x".formatted(addr), int.class, int.class, int.class, int.class);
    MEMORY.call(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), r0, r0 + 0x400, MEMORY.ref(2, r0 + 0x600).getUnsigned(), MEMORY.ref(2, r0 + 0x602).getUnsigned());
    freeSlot(49);
  }

  @Method(0x801bc34)
  public static int FUN_801bc34(int r0, final int r1) {
    CPU.sp().value -= 0xc;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(-1);

    switch(r0) {
      case 1:
      case 6:
        FUN_8019ee4(r1, 0, CPU.sp().value + 0x8, CPU.sp().value + 0x4, 0);
        break;

      case 2: {
        final int slot = getFreeVramSlot();
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(slot);
        if(slot == 0x60) {
          CPU.sp().value += 0xc;
          return -1;
        }

        FUN_801a2a4(r1, 0x1a, slot);
        break;
      }

      case 9: {
        final int slot = getFreeVramSlot();
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(slot);
        if(slot == 0x60) {
          //LAB_801bca6
          CPU.sp().value += 0xc;
          return -1;
        }

        //LAB_801bcac
        FUN_801a32c(r1, 0, slot);
        break;
      }

      case 4:
        FUN_801a3d0(r1, 0x1, CPU.sp().value + 0x8, CPU.sp().value + 0x4, 0);
        break;
    }

    //LAB_801bcc6
    r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();

    //LAB_801bcc8
    CPU.sp().value += 0xc;
    return r0;
  }

  @Method(0x801bcd4)
  public static int FUN_801bcd4(final int r0, final int itemId, final int vramSlot, final int r3) {
    CPU.sp().value -= 0xc;
    int r4 = vramSlot;
    if(r4 == -1) {
      r4 = getFreeVramSlot();
      if(r4 == 0x60) {
        CPU.sp().value += 0xc;
        return -1;
      }
    }

    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);

    //LAB_801bcfe
    switch(r0) {
      case 1, 6 -> FUN_8019ee4(itemId, r3, CPU.sp().value + 0x8, CPU.sp().value + 0x4, 0x1);
      case 2 -> FUN_801a2a4(itemId, 0x3a, r4);
      case 7 -> FUN_801a2a4(itemId, 0x2a, r4);
      case 4 -> FUN_801a3d0(itemId, r3, CPU.sp().value + 0x8, CPU.sp().value + 0x4, 0x1);
      case 8 -> FUN_801a2ec(itemId, 0, r4);
      case 9 -> FUN_801a32c(itemId, 0, r4);
    }

    r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();

    //case 3:
    //case 5:
    //LAB_801bd84
    //LAB_801bd86
    CPU.sp().value += 0xc;
    return r4;
  }

  @Method(0x801c0dc)
  public static void FUN_801c0dc(int r0, int r1) {
    int r2;
    int r3;
    final int r5;
    final int r6;

    r5 = r0;
    r6 = r1;
    r0 = getFreeVramSlot();
    MEMORY.ref(4, r6).setu(r0);
    r0 = allocateSpriteSlot(r0, 0x80, 0x80342f8);
    r2 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
    r0 = r0 & 0x3ff;
    r3 = r2 & ~0x3ff | r0;
    MEMORY.ref(2, r5 + 0x8).setu(r3);
    r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
    r2 = r3 & ~0xc & ~0x10 | 0x20;
    r1 = MEMORY.ref(1, r5 + 0x7).getUnsigned();
    r2 = r2 & ~0x3;
    r3 = r1 & ~0x3e & 0x3f;
    MEMORY.ref(1, r5 + 0x7).setu(r3);
    r2 = r2 & 0x3f | 0x80;
    MEMORY.ref(1, r5 + 0x5).setu(r2);
    MEMORY.ref(1, r5 + 0x9).and(~0xc);
  }

  @Method(0x801c154)
  public static void queueRenderPacketXy(final RenderPacket0c renderPacket, final int x, final int y) {
    renderPacket.attribs_04.attrib1_02.and(~0x1ff).or(x & 0x1ff);
    renderPacket.attribs_04.y_00.set(y);
    insertIntoRenderQueue(renderPacket, 252);
  }

  @Method(0x801c17c)
  public static void clearVramSlot2(final int vramSlot) {
    clearVramSlot(vramSlot);
  }

  @Method(0x801c244)
  public static void handleIngameMenus() {
    final Structccc r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    int r5 = 0;

    //LAB_801c24c
    do {
      FUN_801c2d0();
      r5 = handleAMenu(r5);
      FUN_801c2e4();

      switch(r5) {
        case 0:
          int r0 = getInteractedTileType_();
          if(r0 == 0) {
            r0 = 0xff;
          }

          //LAB_801c286
          r6.interactedTileType_17a.set(r0);
          return;

        case 1:
          if(handlePsynergyMenu_() != -1) {
            return;
          }
          break;

        case 2:
          if(FUN_80a1040() == 0) {
            return;
          }
          break;

        case 3:
          if(handleItemMenu_() != -1) {
            return;
          }
          break;

        case 4:
          if(handleStatusMenu_() != -1) {
            return;
          }
          break;

        default:
          return;
      }
    } while(true);

    //LAB_801c2c2
  }

  @Method(0x801c2d0)
  public static void FUN_801c2d0() {
    FUN_801ef08(1);
    sleep(1);
  }

  @Method(0x801c2e4)
  public static void FUN_801c2e4() {
    FUN_801f5d4();
  }

  @Method(0x801c34c)
  public static void FUN_801c34c() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;

    CPU.sp().value -= 0x14;
    final Structccc r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(8);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(8);
    r0 = getRoomNameStringId_(mapId_2000400.get(), entranceId_2000402.get());
    r5 = r0 + 0x99b;
    r0 = CPU.sp().value + 0x4;
    r1 = CPU.sp().value + 0x10;
    r2 = CPU.sp().value + 0xc;
    r3 = CPU.sp().value + 0x8;
    MEMORY.ref(4, CPU.sp().value).setu(r0);
    FUN_80187ac(r5, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r0 = 30 - r2 >> 1;
    r1 = 10 - r3 >> 1;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
    r6.panel_230.set(addPanel(r0, r1, r2, r3, 0x2));
    FUN_801e74c(r5, r6.panel_230.deref(), 0, 0);
    r6._234.set(90);
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_801c3e8"), 0xc80);
    CPU.sp().value += 0x14;
  }

  @Method(0x801c3e8)
  public static void FUN_801c3e8() {
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._234.decr();

    if(r1._234.get() == 0) {
      FUN_8016418(r1.panel_230.deref(), 2);
      clearTickCallback(getRunnable(GoldenSun_801.class, "FUN_801c3e8"));
    }
  }

  @Method(0x801c428)
  public static void FUN_801c428() {
    final Panel24 panel = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).panel_230.derefNullable();
    if(panel != null) {
      if(panel.flags_16.get() != 0) {
        FUN_8016418(panel, 0x2);
        clearTickCallback(getRunnable(GoldenSun_801.class, "FUN_801c3e8"));
      }
    }

    //LAB_801c44c
  }

  /**
   * Applies r/g/b multipliers to source colour vec and returns a packed 15-bit blended colour
   * @param colour source
   * @param r red multiplier (.16)
   * @param g green multiplier (.16)
   * @param b blue multiplier (.16)
   * @return 15-bit packed result colour
   */
  @Method(0x801cc50)
  public static int blendColour(final Vec3s colour, int r, int g, int b) {
    r = MathHelper.clamp((int)MEMORY.call(0x3000118, colour.getX() << 16, r) >> 16, 0, 0x1f);
    g = MathHelper.clamp((int)MEMORY.call(0x3000118, colour.getY() << 16, g) >> 16, 0, 0x1f) << 5;
    b = MathHelper.clamp((int)MEMORY.call(0x3000118, colour.getZ() << 16, b) >> 16, 0, 0x1f) << 10;
    return b | g | r;
  }

  @Method(0x801ccc0)
  public static void FUN_801ccc0(final int r0, final int r1) {
    final int r6 = (short)(r1 - 7);
    final int r5 = modS(r0 + 0xc, 0x18) << 18 >> 16;
    final int r = MathHelper.clamp((short)(MEMORY.ref(1, 0x8036750 + modS(r5, 0x60)).getUnsigned() + r6), 0, 0x1f);
    final int g = MathHelper.clamp((short)(MEMORY.ref(1, 0x8036750 + modS(r5 + 0x20, 0x60)).getUnsigned() + r6), 0, 0x1f);
    final int b = MathHelper.clamp((short)(MEMORY.ref(1, 0x8036750 + modS(r5 + 0x40, 0x60)).getUnsigned() + r6), 0, 0x1f);

    final Vec3s colour = new Vec3s();
    colour.set(r, g, b);
    MEMORY.ref(2, 0x50001e8).setu(blendColour(colour, 0xeeee, 0xcccc, 0x11110));
    MEMORY.ref(2, 0x50001ea).setu(blendColour(colour, 0xd555, 0xbbbb, 0xeeee));
    MEMORY.ref(2, 0x50001ec).setu(blendColour(colour, 0xbbbb, 0xaaaa, 0xcccc));
    MEMORY.ref(2, 0x50001ee).setu(blendColour(colour, 0xa221, 0x9999, 0xaaaa));
    MEMORY.ref(2, 0x50001f0).setu(blendColour(colour, 0x10888, 0xdddd, 0x13333));
    MEMORY.ref(2, 0x50001f2).setu(blendColour(colour, 0x12221, 0xeeee, 0x15555));
    MEMORY.ref(2, 0x50001f4).setu(blendColour(colour, 0x13bbb, 0x10000, 0x17777));
  }

  @Method(0x801d4cc)
  public static int FUN_801d4cc() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x801d94c)
  public static void FUN_801d94c() {
    final int r5 = boardWramMallocHead_3001e50.offset(20 * 0x4).get();
    FUN_80b0020(r5 + 0x5a4);
    FUN_80217a4(MEMORY.ref(4, r5 + 0x610 + MEMORY.ref(2, r5 + 0x574).getUnsigned() * 0x4).get());
  }

  @Method(0x801d980)
  public static void FUN_801d980() {
    CPU.sp().value -= 0x4;
    final int r1 = mallocSlotBoard(20, 0x628);
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(0x8500018a);
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_801d94c"), 0xc80);
    CPU.sp().value += 0x4;
  }

  @Method(0x801d9bc)
  public static void FUN_801d9bc() {
    clearTickCallback(getRunnable(GoldenSun_801.class, "FUN_801d94c"));
    freeSlot(20);
  }

  @Method(0x801d9d4)
  public static Panel24 FUN_801d9d4() {
    int r1;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    final int r11 = boardWramMallocHead_3001e50.offset(20 * 0x4).get();
    int r10 = 0x3;
    CPU.sp().value -= 0xc;
    final int r9 = readFlag_(0x17e);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(0);
    if(r9 != 0) {
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(0x2);
      r10 = 0x1;
    }

    //LAB_801da08
    if(debug_3001f54.get() != 0) {
      r10 += 0x3;
    }

    //LAB_801da14
    r1 = 0x8 - r10;
    r3 = r10 * 3;
    r4 = CPU.addT(r3, 0x1);
    r3 = CPU.addT(r1, r4);
    if(r3 > 0x13) {
      r1 = 0x1;
      r4 = 0x13;
    }

    //LAB_801da2a
    final Panel24 r8 = addPanel(0x5, r1, 0x14, r4, 0x2);
    if(r10 > 1) {
      r6 = 0x3;
      r5 = r10 - 1;

      //LAB_801da46
      do {
        FUN_801e41c(r8, 0, r6, 0x13, r6);
        r6 += 0x3;
        r5--;
      } while(r5 != 0);
    }

    //LAB_801da5c
    if(r9 == 0) {
      FUN_801e74c(0xc23, r8, 0x30, 0x4);
      FUN_801e74c(0xc24, r8, 0x30, 0x1c);
      r7 = 0x34;
    } else {
      r7 = 0x4;
    }

    //LAB_801da82
    FUN_801e74c(0xc25, r8, 0x30, r7);
    r7 += 0x18;
    if(debug_3001f54.get() != 0) {
      r7 += 0x18;
      FUN_801e74c(0xc27, r8, 0x30, r7);
      r7 += 0x18;
      FUN_801e74c(0xc28, r8, 0x30, r7);
      FUN_801e74c(0xc29, r8, 0x30, r7);
    }

    //LAB_801dac4
    r5 = getFreeVramSlot();
    if(r5 < 0x60) {
      allocateSpriteSlot(r5, 0x80, 0x80310a4);
      final GraphicsStruct1c r0_0 = FUN_801eadc(r5, 0x40000000, r8, 0, 0);
      MEMORY.ref(4, r11 + 0x5a4).setu(r0_0 == null ? 0 : r0_0.getAddress());
      FUN_80b0038(r11 + 0x5a4, r8.x_0c.get() * 0x8, r8.y_0e.get() * 0x8 + 0x10);
    }

    //LAB_801db02
    r7 = -0x4;
    r6 = 0x80367dc + MEMORY.ref(4, CPU.sp().value + 0x8).get();

    //LAB_801db1a
    for(r5 = 0; r5 < r10; r5++) {
      final GraphicsStruct1c struct = FUN_8021750(MEMORY.ref(1, r6 + r5).get(), 0, r8, 0xc, r7);
      MEMORY.ref(4, r11 + 0x610 + r5 * 0x4).setu(struct == null ? 0 : struct.getAddress()); //TODO

      r7 += 0x18;
    }

    //LAB_801db3c
    CPU.sp().value += 0xc;
    return r8;
  }

  @Method(0x801db70)
  public static int FUN_801db70() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x14;

    MEMORY.ref(4, CPU.sp().value + 0xc).setu(0x1);
    CPU.r11().value = 0x3;
    r5 = readFlag_(0x17e);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    FUN_801d980();
    CPU.r10().value = boardWramMallocHead_3001e50.offset(20 * 0x4).get();
    final Panel24 sp10 = FUN_801d9d4();
    r4 = -0x18;
    if(debug_3001f54.get() != 0) {
      r4 += 0x8;
    }

    //LAB_801dbb4
    final GraphicsStruct1c sp08 = FUN_8021620(0x6, sp10, 0x28, r4);
    sleep(1);
    CPU.r8().value = MEMORY.ref(2, CPU.r10().value + 0x574).getUnsigned();
    if(r5 != 0) {
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(0x2);
      CPU.r11().value = 0x1;
    }

    //LAB_801dbdc
    if(debug_3001f54.get() != 0) {
      CPU.r11().value += 0x3;
    }

    //LAB_801dbe6
    do {
      if(MEMORY.ref(4, CPU.sp().value + 0xc).get() != 0) {
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(0);
        CPU.r8().value = modS(CPU.r8().value + CPU.r11().value, CPU.r11().value);
        MEMORY.ref(2, CPU.r10().value + 0x574).setu(CPU.r8().value);
        r4 = 0;
        r6 = MEMORY.ref(4, CPU.sp().value + 0x4).get();

        //LAB_801dc18
        while(r4 < CPU.r11().value) {
          final GraphicsStruct1c struct = MEMORY.ref(4, CPU.r10().value + 0x610 + r4 * 0x4).deref(4).cast(GraphicsStruct1c::new);
          struct.z_0f.set(0xfb);
          FUN_80a1038(struct);
          FUN_80216e8(MEMORY.ref(1, 0x80367dc + r6).get(), struct.slot_0e.get(), r4 != MEMORY.ref(2, CPU.r10().value + 0x574).getUnsigned() ? 1 : 0);
          r4++;
          r6++;
        }

        //LAB_801dc4c
        r2 = sp10.y_0e.get();
        r1 = sp10.x_0c.get();
        r0 = CPU.r8().value;
        r3 = CPU.lslT(r0, 1);
        r3 += CPU.r8().value;
        r3 = CPU.addT(r3, r2);
        r3 = CPU.lslT(r3, 3);
        r4 = CPU.addT(r3, 0x0);
        r0 = MEMORY.ref(4, 0x801dd1c).get();
        r4 = CPU.addT(r4, 0x10);
        r1 = CPU.lslT(r1, 3);
        r0 += CPU.r10().value;
        r2 = CPU.addT(r4, 0x0);
        r3 = CPU.movT(0x3);
        FUN_80b0030(r0, r1, r2, r3);
      }

      //LAB_801dc6e
      FUN_80216b4(sp08);
      sleep(1);
      r1 = MEMORY.ref(4, 0x801dd20).get();
      r2 = MEMORY.ref(4, r1).get();
      r3 = CPU.movT(0x1);
      r2 = CPU.andT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0x70);
        r5 = CPU.r8().value;
        playSound_(r0);
        break;
      }

      //LAB_801dc90
      r2 = MEMORY.ref(4, r1).get();
      r3 = CPU.movT(0xa);
      r2 = CPU.andT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r5 = -1;
        playSound_(0x71);
        break;
      }

      //LAB_801dca6
      r1 = MEMORY.ref(4, 0x801dd24).get();
      r2 = MEMORY.ref(4, r1).get();
      r3 = CPU.movT(0x40);
      r2 = CPU.andT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0x6f);
        playSound_(r0);
        r2 = CPU.movT(0x1);
        r2 = CPU.negT(r2);
        r3 = CPU.movT(0x1);
        CPU.r8().value += r2;
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
      } else {
        //LAB_801dcc4
        r3 = MEMORY.ref(4, r1).get();
        r2 = CPU.movT(0x80);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.movT(0x6f);
          playSound_(r0);
          r0 = CPU.movT(0x1);
          CPU.r8().value += r0;
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
        }
      }
    } while(true);

    //LAB_801dcdc
    FUN_8016418(sp10, 0x2);
    FUN_801d9bc();
    sleep(1);

    if(r5 >= 0) {
      r5 += MEMORY.ref(4, CPU.sp().value + 0x4).get();
    }

    //LAB_801dcf6
    CPU.sp().value += 0x14;
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r5;
  }

  @Method(0x801de5c)
  public static int FUN_801de5c(final ArrayRef<UnsignedShortRef> text, int r1, int r2, int r3) {
    int r0;
    int r4;
    int r5;
    int r6;
    int r8;
    int r9;
    int r10;

    CPU.sp().value -= 0x44;

    int sp10 = r1;
    int sp0c = r2;
    r8 = r3;
    r5 = 0x800;
    r6 = 0;
    final Struct12fc r11 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int sp08 = mallocChip(r5);
    final int sp04 = getPointerTableEntry(19);
    final int sp00 = r11._ea7.get() << 12;

    r10 = CPU.sp().value + 0x14;
    MEMORY.call(0x3000164, r10, 0x10); // memzero

    if(sp00 == 0xf000) {
      r2 = r11._eae.get();
      MEMORY.ref(1, r10 + 0x1).setu(MEMORY.ref(1, 0x80371b4 + (r2 & 0xf)).getUnsigned());
      MEMORY.ref(1, r10 + 0x3).setu(0x3);
      MEMORY.call(0x3000168, sp08, r5, 0x4040404); // memfill32
    } else {
      //LAB_801ded4
      MEMORY.ref(1, r10 + 0x1).setu(r11._eae.get() & 0xf);
      MEMORY.ref(1, r10 + 0x3).setu(0x1);
      MEMORY.call(0x3000168, sp08, r5, 0xe0e0e0e); // memfill32
    }

    //LAB_801def6
    if(text != null) {
      //LAB_801defc
      //LAB_801e036
      int chr = text.get(r6).get();
      r6++;

      //LAB_801defe
      while(chr != 0) {
        if(chr > 0x1e) {
          //LAB_801dfb6
          r5 = sp04 + (chr & 0xff) * 0x20;
          r0 = sp08 + r8;
          r9 = 0;

          //LAB_801dfca
          do {
            r2 = MEMORY.ref(4, r5).get();
            r5 += 0x4;
            r4 = 0x3;

            //LAB_801dfce
            do {
              r3 = MEMORY.ref(1, r10 + (r2 & 0xf)).getUnsigned();
              if(r3 != 0) {
                MEMORY.ref(1, r0).setu(r3);
              }
              r0++;

              //LAB_801dfde
              r2 = r2 >>> 4;
              r3 = MEMORY.ref(1, r10 + (r2 & 0xf)).getUnsigned();
              if(r3 != 0) {
                MEMORY.ref(1, r0).setu(r3);
              }
              r0++;

              //LAB_801dff2
              r4--;
              r2 = r2 >>> 4;
            } while(r4 >= 0);

            r9++;
            r0 += 0xf8;
          } while(r9 < 8);

          if(chr == 0xf01d || chr == 0xf01f) {
            //LAB_801e014
            r8 += 0x8;
          } else {
            //LAB_801e01a
            if(chr == 0xf01e) {
              r3 = 0x3;
            } else {
              //LAB_801e024
              if(chr > 0x1f) {
                r3 = MEMORY.ref(1, 0x80370d4 + (chr & 0xff) - 0x20).getUnsigned();
              } else {
                //LAB_801e032
                r3 = 0x1;
              }
            }

            //LAB_801e034
            r8 += r3;
          }
        } else {
          //LAB_801df0a
          switch(chr) {
            case 8:
              r1 = text.get(r6).get();
              r6++;
              r11._eae.set(r1);
              MEMORY.ref(1, r10 + 0x1).setu(MEMORY.ref(1, 0x80371b4 + (r1 & 0xf)).getUnsigned());
              break;

            case 7:
            case 9:
            case 10:
              r11._eae.set(0xf);
              MEMORY.ref(1, r10 + 0x1).setu(MEMORY.ref(1, 0x80371b4 + 0xf).getUnsigned());
              break;

            case 3:
              r8 += MEMORY.ref(1, 0x80370d4).getUnsigned();
              break;

            case 14:
            case 15:
            case 0x1c:
              r6++;

            case 11:
            case 12:
            case 0x11:
            case 0x1d:
              r6++;
              break;
          }
        }

        chr = text.get(r6).get();
        r6++;
      }
    }

    //LAB_801e042
    r5 = sp08;
    r0 = r5;
    final int r6_0 = r8 + 0x7 >>> 3;
    r10 = r6_0 * 0x4;
    r8 = r6_0 * 0x8;
    r9 = 0x7;

    //LAB_801e05e
    do {
      r4 = r6_0;

      //LAB_801e06a
      while(r4 != 0) {
        r1 = MEMORY.ref(4, r5).get();
        r2 = MEMORY.ref(4, r5 + 0x4).get();
        r3 = CPU.lslT(r1, 4);
        r1 = CPU.orrT(r1, r3);
        r3 = CPU.lsrT(r2, 4);
        r2 = CPU.orrT(r2, r3);
        r3 = 0xff00ff0;
        r1 = CPU.andT(r1, r3);
        r2 = CPU.andT(r2, 0xff00ff);
        r3 = CPU.lslT(r1, 8);
        r1 = CPU.orrT(r1, r3);
        r3 = CPU.lsrT(r2, 8);
        r2 = CPU.orrT(r2, r3);
        r3 = CPU.lslT(r1, 4);
        r3 = CPU.lsrT(r3, 16);
        r2 = CPU.lslT(r2, 16);
        r3 = CPU.orrT(r3, r2);
        r4 = CPU.subT(r4, 0x1);
        r5 = CPU.addT(r5, 0x8);
        MEMORY.ref(4, r0).setu(r3);
        r0 += 0x4;
      }

      //LAB_801e096
      r3 = r0 - r10;
      r0 = r3 + 0x100;
      r3 = r5 - r8;
      r5 = r3 + 0x100;
      r9--;
    } while(r9 >= 0);

    if(r6_0 != 0) {
      //LAB_801e0b6
      r0 = sp08;
      r9 = r6_0;

      //LAB_801e0d0
      do {
        r2 = r11._ea2.get();
        r5 = 0x7f;
        if(r2 != 0) {
          r5 = 0xff;
        }

        //LAB_801e0dc
        r1 = MEMORY.ref(2, sp10).getUnsigned() & 0x3ff;
        r3 = r1 - 0x80;
        if((r3 < 0 || r3 >= 0x80) && (r2 == 0 || r1 < 0x200 || r1 >= 0x280)) {
          //LAB_801e100
          r1 = r11._ea0.get() & r5;
          r4 = 0;
          //LAB_801e112
          while(r11._da0.get(r1).get() != 0) {
            r1++;
            r4++;
            r1 = r1 & r5;
            r4 = CPU.cmpT(r4, r5);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              break;
            }
          }

          //LAB_801e12a
          r11._ea0.set(r5 & 0x1);
          r11._da0.get(r1).set(0x1);
          CPU.cmpT(r1, 0x7f);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r1 = r1 + 0x180;
          } else {
            //LAB_801e190
            r1 = r1 | 0x80;
          }

          //LAB_801e194
          MEMORY.ref(2, sp10).setu(sp00 | r1);
          MEMORY.ref(2, sp0c).setu(sp00 | r1);
        }

        //LAB_801e1a0
        MEMORY.ref(4, 0x6000000 + r1 * 0x20).setu(MEMORY.ref(4, r0).get());
        MEMORY.ref(4, 0x6000004 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x100).get());
        MEMORY.ref(4, 0x6000008 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x200).get());
        MEMORY.ref(4, 0x600000c + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x300).get());
        MEMORY.ref(4, 0x6000010 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x400).get());
        MEMORY.ref(4, 0x6000014 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x500).get());
        MEMORY.ref(4, 0x6000018 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x600).get());
        MEMORY.ref(4, 0x600001c + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x700).get());
        sp10 += 0x2;
        sp0c += 0x2;
        r0 += 0x4;
        r9--;
      } while(r9 != 0);
    }

    //LAB_801e22a
    setMallocAddress(sp08);

    CPU.sp().value += 0x44;
    return r6_0;
  }

  @Method(0x801e260)
  public static void FUN_801e260(final int baseX, final int baseY, final int w, final int h) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int addr = r5._00.getAddress() + (baseX + baseY * 32) * 0x2; //TODO
    final int skip = (32 - w) * 0x2;

    //LAB_801e296
    for(int y = 0; y < h; y++) {
      //LAB_801e2ac
      for(int x = 0; x < w; x++) {
        final int tile = MEMORY.ref(2, addr).getUnsigned() & 0x3ff;
        addr += 0x2;

        if(tile >= 0x80 && tile < 0x100 || r5._ea2.get() != 0 && tile > 0x1ff && tile < 0x280) {
          //LAB_801e2ca
          r5._da0.get(tile & 0xff ^ 0x80).and(0xfc);
        }

        //LAB_801e2e0
      }

      //LAB_801e2e6
      addr += skip;
    }

    //LAB_801e2f0
  }

  @Method(0x801e318)
  public static void FUN_801e318() {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r7 = r5._ea2.get();
    int r4 = 0;

    //LAB_801e334
    for(int r6 = 0; r6 < 20; r6++) {
      //LAB_801e34c
      for(int r0 = 0; r0 < 30; r0++) {
        final int r1 = MEMORY.ref(2, r5._00.getAddress() + r4).getUnsigned() & 0x3ff; //TODO
        r4 = r4 + 0x2;
        if(r1 >= 0x80 && r1 < 0x100 || r7 != 0 && r1 > 0x1ff && r1 <= 0x27f) {
          //LAB_801e368
          r5._da0.get(r1 & 0xff ^ 0x80).or(0x2);
        }

        //LAB_801e37e
      }

      //LAB_801e384
    }

    //LAB_801e394
    for(int r6 = 0; r6 < 0x100; r6++) {
      if(r5._da0.get(r6).get() == 1) {
        r5._da0.get(r6).set(0);
      }

      //LAB_801e39c
    }
  }

  @Method(0x801e3c8)
  public static void FUN_801e3c8(final int r0) {
    final Struct12fc r1 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    if(r0 != 0) {
      r1._ea2.set(0x1);

      //LAB_801e3e4
      for(int r3 = 0x80; r3 < 0x100; r3++) {
        r1._da0.get(r3).set(0);
      }
    } else {
      //LAB_801e3f0
      r1._ea2.set(0);

      //LAB_801e402
      for(int r3 = 0; r3 < 0x80; r3++) {
        r1._da0.get(0x80 + r3).set(0);
      }
    }

    //LAB_801e40c
  }

  @Method(0x801e41c)
  public static void FUN_801e41c(final Panel24 r5, final int x, final int y, final int w, final int h) {
    int r0;
    int r1;
    int r3;
    int r4;

    final Struct12fc r9 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r10 = w;
    int r7 = x;
    int r8 = y;

    if(r7 == r10) {
      //LAB_801e43c
      if(r8 != h) {
        //LAB_801e442
        CPU.cmpT(r8, h);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r8 = h;
        }

        //LAB_801e44c
        FUN_801e260(r10 + r5.x_0c.get(), r8 + r5.y_0e.get(), 0x1, h - r8);
        r4 = r8;
        r0 = r9._00.getAddress() + ((r5.y_0e.get() + r8) * 0x20 + r5.x_0c.get() + r10) * 0x2; //TODO
        CPU.cmpT(r4, h);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          //LAB_801e478
          do {
            r1 = MEMORY.ref(2, r0).getUnsigned();
            r3 = r1 - 0xf009;

            if(r4 == r8) {
              switch(r3) {
                case 1 ->
                  //LAB_801e560
                  r1 = 0xf00d;

                case 5 ->
                  //LAB_801e4d4
                  r1 = 0xf009;

                case 6, 7, 9, 10, 11, 12, 13, 14 ->
                  //LAB_801e564
                  r1 = 0xf00f;

                case 8 ->
                  //LAB_801e4d0
                  r1 = 0xf018;
              }
              //LAB_801e4d8
            } else if(r4 == h) {
              switch(r3) {
                case 0 ->
                  //LAB_801e560
                  r1 = 0xf00d;

                case 5 ->
                  //LAB_801e534
                  r1 = 0xf00a;

                case 6, 7, 8, 9, 10, 12, 13, 14, 15 ->
                  //LAB_801e564
                  r1 = 0xf00f;

                case 11 ->
                  //LAB_801e530
                  r1 = 0xf019;
              }
            } else {
              //LAB_801e538
              switch(r3) {
                case 0, 1, 5 ->
                  //LAB_801e560
                  r1 = 0xf00d;
              }
            }

            //LAB_801e566
            MEMORY.ref(2, r0).setu(r1);
            r0 += 0x40;
            r4++;
            r4 = CPU.cmpT(r4, h);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
        }
      }
    } else {
      //LAB_801e572
      if(r8 == h) {
        //LAB_801e578
        if(r7 != r10) {
          //LAB_801e57e
          CPU.cmpT(r7, r10);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r4 = CPU.addT(r7, 0x0);
            r7 = r10;
            r10 = r4;
          }

          //LAB_801e588
          FUN_801e260(r5.x_0c.get() + r7, r8 + r5.y_0e.get(), r10 - r7, 0x1);
          r4 = r7;
          r0 = r9._00.getAddress() + ((r5.y_0e.get() + r8) * 0x20 + r5.x_0c.get() + r7) * 0x2; //TODO
          CPU.cmpT(r4, r10);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            //LAB_801e5b4
            do {
              r1 = MEMORY.ref(2, r0).getUnsigned();
              r3 = r1 - 0xf009;
              if(r4 == r7) {
                switch(r3) {
                  case 3 ->
                    //LAB_801e6b0
                    r1 = 0xf00d;

                  case 5, 7, 8, 9, 10, 11, 12, 14, 15, 16 ->
                    //LAB_801e6b4
                    r1 = 0xf00e;

                  case 6 ->
                    //LAB_801e618
                    r1 = 0xf00b;

                  case 13 ->
                    //LAB_801e614
                    r1 = 0xf01a;
                }
                //LAB_801e61c
              } else if(r4 == r10) {
                switch(r3) {
                  case 2 ->
                    //LAB_801e6b0
                    r1 = 0xf00d;

                  case 5, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17 ->
                    //LAB_801e6b4
                    r1 = 0xf00e;

                  case 6 ->
                    //LAB_801e680
                    r1 = 0xf00c;

                  case 14 ->
                    //LAB_801e67c
                    r1 = 0xf01b;
                }
              } else {
                //LAB_801e684
                switch(r3) {
                  case 2, 3, 6 ->
                    //LAB_801e6b0
                    r1 = 0xf00d;

                  case 5 ->
                    //LAB_801e6b4
                    r1 = 0xf00e;
                }
              }

              //LAB_801e6b6
              MEMORY.ref(2, r0).setu(r1);
              r0 += 0x2;
              r4++;
            } while(r4 <= r10);
          }
        }
      }
    }

    //LAB_801e6c2
  }

  @Method(0x801e71c)
  public static void FUN_801e71c(final int r0) {
    boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._eae.set(r0 & 0xf);
  }

  @Method(0x801e74c)
  public static void FUN_801e74c(final int r0, final Panel24 panel, final int x, final int y) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r5.textOffset_12b2.set(0);
    FUN_8018038(r0, 0x1);
    r5.text_eb0.get(r5.textOffset_12b2.get()).set(0);
    r5.textOffset_12b2.incr().and(0x1ff);
    FUN_8017aa4(r5.text_eb0, panel, x, y);
  }

  @Method(0x801e7c0)
  public static void drawIcon(final int iconId, final Panel24 panel, final int x, final int y) {
    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r7.textOffset_12b2.set(0);
    FUN_8018038(iconId, 0x1);
    r7.text_eb0.get(r7.textOffset_12b2.get()).set(0);
    r7.textOffset_12b2.incr().and(0x1ff);

    final int r1_0 = (panel.y_0e.get() + (y >>> 3) + 0x1) * 0x20 + panel.x_0c.get() + (x >>> 3) + 0x1;
    if(r1_0 >= 0 && r1_0 < 0x280) {
      FUN_801de5c(r7.text_eb0, r7._00.getAddress() + r1_0 * 0x2, 0x6002000 + r1_0 * 0x2, x & 0x7);
    }

    //LAB_801e848
  }

  /** Called immediately getting to the title screen with no save data, string is Isaac's name. Possible string buffer overflow. */
  @Method(0x801e858)
  public static void FUN_801e858(final int string, final Panel24 panel, final int x, final int y) {
    final ArrayRef<UnsignedShortRef> r6 = MEMORY.ref(2, mallocBoard(0x200), ArrayRef.of(UnsignedShortRef.class, 0x100, 0x2, UnsignedShortRef::new));

    //LAB_801e87a
    int i;
    for(i = 0; MEMORY.ref(1, string + i).getUnsigned() != 0; i++) {
      r6.get(i).set(MEMORY.ref(1, string + i).getUnsigned());
    }

    //LAB_801e888
    r6.get(i).set(0);
    FUN_8017aa4(r6, panel, x, y);
    setMallocAddress(r6.getAddress());
  }

  @Method(0x801e8b0)
  public static void FUN_801e8b0(final int string, final Panel24 panel, final int x, final int y) {
    final ArrayRef<UnsignedShortRef> r6 = MEMORY.ref(4, mallocBoard(0x200), ArrayRef.of(UnsignedShortRef.class, 0x100, 0x2, UnsignedShortRef::new));

    //LAB_801e8d6
    int i;
    for(i = 0; MEMORY.ref(1, string + i).getUnsigned() != 0; i++) {
      r6.get(i).set(MEMORY.ref(1, string + i).getUnsigned());
    }

    //LAB_801e8e4
    r6.get(i).set(0);

    final int r1_0 = (panel.y_0e.get() + (y >>> 3) + 1) * 0x20 + panel.x_0c.get() + (x >>> 3) + 1;
    if(r1_0 < 640) {
      FUN_801de5c(r6, boardWramMallocHead_3001e50.offset(15 * 0x4).get() + r1_0 * 0x2, 0x6002000 + r1_0 * 0x2, x & 0x7); //TODO
    }

    // This was inside the above condition, but it should always be deallocated
    setMallocAddress(r6.getAddress());

    //LAB_801e932
  }

  @Method(0x801e940)
  public static void FUN_801e940(final int string, final Panel24 panel, final int x, final int y) {
    final ArrayRef<UnsignedShortRef> r6 = MEMORY.ref(4, mallocBoard(0x200), ArrayRef.of(UnsignedShortRef.class, 0x100, 0x2, UnsignedShortRef::new));

    //LAB_801e962
    int i;
    for(i = 0; MEMORY.ref(1, string + i).getUnsigned() != 0; i++) {
      r6.get(i).set(MEMORY.ref(1, string + i).getUnsigned());
    }

    //LAB_801e970
    r6.get(i).set(0);

    FUN_8017c8c(r6, panel, x >>> 3, y >>> 3);
    setMallocAddress(r6.getAddress());
  }

  @Method(0x801e9d4)
  public static void drawNumber(final int number, final int digits, final Panel24 panel, final int x, final int y) {
    CPU.sp().value -= 0x10;
    FUN_801e8b0(convertNumberToAscii(CPU.sp().value, number, digits), panel, x, y);
    CPU.sp().value += 0x10;
  }

  @Method(0x801ea08)
  public static void FUN_801ea08(final int number, final int digits, final Panel24 panel, final int x, final int y) {
    CPU.sp().value -= 0x10;
    FUN_801e940(convertNumberToAscii(CPU.sp().value, number, digits), panel, x, y);
    CPU.sp().value += 0x10;
  }

  @Method(0x801ea3c)
  public static void FUN_801ea3c(final int r0, final Panel24 r1, final int r2, final int r3, final int a4) {
    CPU.sp().value -= 0x20;
    final int r10 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    final int numStr = convertNumberToAscii(CPU.sp().value + 0x10, r0, 0x4);

    final ArrayRef<UnsignedShortRef> r4 = MEMORY.ref(4, CPU.sp().value, ArrayRef.of(UnsignedShortRef.class, 7, 0x2, UnsignedShortRef::new));
    r4.get(0).set(a4 == 0 ? 0xf01d : 0xf01f);
    r4.get(1).set(0xf01e);

    //LAB_801ea76
    for(int i = 0; i < 5; i++) {
      r4.get(2 + i).set(MEMORY.ref(1, numStr + i).getUnsigned());
    }

    r4.get(6).set(0);

    final int r1_0 = (r1.y_0e.get() + (r3 >>> 3) + 1) * 0x20 + r1.x_0c.get() + (r2 >>> 3) + 1;
    if(r1_0 < 0x280) {
      FUN_801de5c(r4, r10 + r1_0 * 0x2, 0x6002000 + r1_0 * 0x2, r2 & 0x7);
    }

    //LAB_801eab8
    CPU.sp().value += 0x20;
  }

  @Method(0x801eadc)
  public static GraphicsStruct1c FUN_801eadc(final int vramSlot, final int r1, final Panel24 r2, final int x, final int y) {
    final GraphicsStruct1c r5 = FUN_8015e8c();
    if(r5 == null) {
      clearVramSlot(vramSlot);
      return null;
    }

    //LAB_801eb00
    final int r1_0 = x + r2.x_0c.get() * 0x8 + 0x8 & 0x1ff;
    final int r2_0 = y + r2.y_0e.get() * 0x8 + 0x8 & 0xff;
    r5._00.clear();
    r5.packet_10.attribs_04.attrib0_00.set(r2_0);
    r5.packet_10.attribs_04.attrib1_02.set(r1_0);
    MEMORY.ref(4, r5.packet_10.attribs_04.attrib0_00.getAddress()).oru(r1); //TODO
    r5.packet_10.attribs_04.attrib2_04.set(vramSlots_3001b10.get(vramSlot).vramAddr_02.get() >>> 5);
    r5.packet_10.attribs_04.rotationScaling_06.set(0);
    r5.z_0f.set(0xff);
    r5.x_06.set(r1_0);
    r5.y_08.set(r2_0);
    r5.slot_0e.set(vramSlot);
    r5._04.set(0x1);
    r5._05.set(0x1);
    FUN_8016584(r2, r5);

    //LAB_801eb50
    return r5;
  }

  @Method(0x801eb64)
  public static GraphicsStruct1c FUN_801eb64(final int r0, final int r1, final Panel24 r2, final int r3, final int a4) {
    final int r0_0 = FUN_801bc34(r0, r1);
    if(r0_0 < 0) {
      return null;
    }

    //LAB_801eb78
    //LAB_801eb88
    return FUN_801eadc(r0_0, 0x40000000, r2, r3, a4);
  }

  @Method(0x801ec6c)
  public static GraphicsStruct1c FUN_801ec6c(int r0, final int r1, final int r2, final Panel24 r3, final int a4, final int a5) {
    CPU.sp().value -= 0x10;

    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(readFlag_(0x20) != 0) {
      if(r0 == 0) {
        r0 = 0x12;
      }

      //LAB_801ec94
      if(r0 == 1) {
        r0 = 0x13;
      }
    }

    //LAB_801ec9a
    final int r5 = FUN_8019d2c(r0);
    if(r5 == -1) {
      CPU.sp().value += 0x10;
      return null;
    }

    int r6 = r2;
    if(r6 < 0 || r6 > 1) {
      if(r7._12ee.get() == 999) {
        r6 = 1;
      } else if(r7._12ec.get() == 999) {
        r6 = 0;
      } else {
        CPU.sp().value += 0x10;
        return null;
      }
    }

    //LAB_801ecca
    final int r8 = 0xe + r6;
    FUN_801a4fc(r5, r1, CPU.sp().value + 0xc, CPU.sp().value + 0x8, r8, 0);

    final GraphicsStruct1c r0_0 = FUN_801eadc(MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x80000000, r3, a4, a5);
    if(r0_0 != null) {
      r0_0.packet_10.attribs_04.attrib2_04.and(0xfff).or(r8 << 12);
      r0_0._04.set(0x2);
    }

    //LAB_801ed0c
    MEMORY.ref(2, r7._12ec.getAddress() + r6 * 0x2).setu(r5); //TODO huh?
    r7._12f0.get(r6).set(MEMORY.ref(4, CPU.sp().value + 0xc).get());

    //LAB_801ed1c
    CPU.sp().value += 0x10;
    return r0_0;
  }

  @Method(0x801ed40)
  public static void FUN_801ed40(int r0, final int r1, final int r2) {
    int r5;
    int r6;

    CPU.sp().value -= 0x10;
    r6 = r0;
    r5 = r1;
    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(readFlag_(0x20) != 0) {
      if(r5 == 0) {
        r5 = 0x12;
      }

      //LAB_801ed62
      if(r5 == 1) {
        r5 = 0x13;
      }
    }

    //LAB_801ed68
    r0 = FUN_8019d2c(r5);
    if(r0 != -1) {
      CPU.cmpT(r6, 0x1);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r6 = 1;
        if(r7._12ee.get() != r0) {
          if(r7._12ec.get() != r0) {
            CPU.sp().value += 0x10;
            return;
          }
          r6 = 0;
        }
      }

      //LAB_801ed92
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r7._12f0.get(r6).get());
      FUN_801a4fc(r0, r2, CPU.sp().value + 0xc, CPU.sp().value + 0x8, r6 + 0xe, 0x1);
    }

    //LAB_801edb0
    CPU.sp().value += 0x10;
  }

  @Method(0x801edec)
  public static void FUN_801edec(final int r0) {
    final int r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    if(r7 == 0) {
      CPU.sp().value -= 0x4;
      MEMORY.ref(2, CPU.sp().value + 0x2).setu(0xe0e0);
      DMA.channels[3].SAD.setu(CPU.sp().value + 0x2);
      DMA.channels[3].DAD.setu(r0);
      DMA.channels[3].CNT.setu(0x810000a0);
      CPU.sp().value += 0x4;
    } else {
      //LAB_801ee24
      final int size = 0x214;
      final int addr = mallocChip(size);
      DMA.channels[3].SAD.setu(0x80158e8);
      DMA.channels[3].DAD.setu(addr);
      DMA.channels[3].CNT.setu(0x84000000 | size / 4);

      MEMORY.setFunction(addr, CopiedSegment80158e8.class, "FUN_80158e8", int.class, int.class);
      MEMORY.call(addr, r0, r7);

      setMallocAddress(addr);
    }

    //LAB_801ee4e
  }

  @Method(0x801eea0)
  public static void FUN_801eea0(int r0) {
    final int r5 = boardWramMallocHead_3001e50.offset(16 * 0x4).get();
    final int r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea5.get();

    final int charCount;
    int r7;
    if(r3 != 0) {
      charCount = getBattleChars_(null);
      r7 = 3;
    } else {
      //LAB_801eec2
      charCount = getCharCount_();
      r7 = 4;
    }

    //LAB_801eec6
    if((r0 & 0x1) != 0) {
      r7++;
    } else {
      //LAB_801eed2
      r0 = r0 & ~0x2;
    }

    //LAB_801eed8
    final int r1;
    if((r0 & 0x2) != 0) {
      r1 = charCount * 0x6 + 0x6;
    } else {
      r1 = charCount * 0x6 + 0x1;
    }

    //LAB_801eeea
    MEMORY.ref(2, r5 + 0x4).setu(30 - r1);
    MEMORY.ref(2, r5 + 0x6).setu(0);
    MEMORY.ref(2, r5 + 0x8).setu(r1);
    MEMORY.ref(2, r5 + 0xa).setu(r7);
    MEMORY.ref(2, r5 + 0xc).setu(r0);
  }

  @Method(0x801ef08)
  public static void FUN_801ef08(final int r0) {
    final int r5 = mallocSlotBoard(16, 0x10);
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r6._ea6.set(0x1);
    FUN_801eea0(r0);
    MEMORY.ref(4, r5).setu(addPanel(MEMORY.ref(2, r5 + 0x4).getUnsigned(), MEMORY.ref(2, r5 + 0x6).getUnsigned(), MEMORY.ref(2, r5 + 0x8).getUnsigned(), MEMORY.ref(2, r5 + 0xa).getUnsigned(), 0x6).getAddress());
    FUN_801f200(r0);
    r6._ea6.set(0);
  }

  @Method(0x801ef68)
  public static void FUN_801ef68(final Panel24 r0, int r1) {
    int r0_0;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x801eff4).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x4;
    CPU.r9().value = r3;
    r3 = CPU.movT(0x0);
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r3 = r0.w_08.get();
    r3 = CPU.subT(r3, 0x1);
    r2 = CPU.movT(0x1);
    CPU.r11().value = r3;
    r3 = CPU.addT(r1, 0x0);
    r3 = CPU.andT(r3, r2);
    r7 = r0.h_0a.get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = CPU.movT(0x3);
      r3 = CPU.negT(r3);
      r1 = CPU.andT(r1, r3);
    }

    //LAB_801ef9c
    r3 = CPU.movT(0x2);
    r3 = CPU.andT(r3, r1);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      MEMORY.ref(4, CPU.sp().value).setu(0x5);
      r2 = CPU.movT(0x0);
    }

    //LAB_801efaa
    r1 = MEMORY.ref(4, 0x801eff8).get();
    r5 = CPU.addT(r2, 0x0);
    r2 = CPU.addT(r1, 0x0);
    r3 = MEMORY.ref(1, r2 + r5).get();

    //LAB_801efb0
    while(r3 >= 0) {
      r3 = MEMORY.ref(1, r2 + r5).get();
      r2 = MEMORY.ref(4, CPU.sp().value).get();
      r0_0 = CPU.addT(r3, r2);
      CPU.cmpT(r0_0, CPU.r11().value);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r4 = CPU.movT(0x0);
        CPU.cmpT(r7, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, 0x801effc).get();
          r2 = CPU.subT(r7, 0x1);
          CPU.r12().value = r2;
          r2 = MEMORY.ref(4, 0x801f000).get();
          CPU.r10().value = r3;
          r3 = CPU.addT(r3, 0x1);
          CPU.r8().value = r3;
          CPU.lr().value = r2;

          //LAB_801efd0
          do {
            r2 = r0.y_0e.get();
            r3 = r0.x_0c.get();
            r2 = CPU.addT(r2, r4);
            r3 = CPU.addT(r3, r0_0);
            r2 = CPU.lslT(r2, 5);
            r2 = CPU.addT(r2, r3);
            r2 = CPU.lslT(r2, 1);
            r3 = CPU.r9().value;
            r1 = CPU.addT(r2, r3);
            CPU.cmpT(r4, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r2 = CPU.r10().value;
              MEMORY.ref(2, r1).setu(r2);
            } else {
              //LAB_801efea
              CPU.cmpT(r4, CPU.r12().value);
              if(CPU.cpsr().getZero()) { // ==
                r3 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
              } else {
                //LAB_801f004
                r2 = CPU.lr().value;

                //LAB_801f006
                MEMORY.ref(2, r1).setu(r2);
              }
            }

            //LAB_801f008
            r4 = CPU.addT(r4, 0x1);
            r4 = CPU.cmpT(r4, r7);
          } while(!CPU.cpsr().getZero()); // !=

          r1 = MEMORY.ref(4, 0x801f06c).get();
        }
      }

      //LAB_801f010
      r5 = CPU.addT(r5, 0x1);
      r2 = CPU.addT(r1, 0x0);
      r3 = MEMORY.ref(1, r2 + r5).get();
    }

    r3 = MEMORY.ref(4, 0x801f070).get();
    r3 += CPU.r9().value;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = r0.h_0a.get();
      r2 = r0.y_0e.get();
      r2 = CPU.addT(r2, r3);
      r3 = r0.x_0c.get();
      r2 = CPU.lslT(r2, 6);
      r3 = CPU.lslT(r3, 1);
      r2 += CPU.r9().value;
      r2 = CPU.addT(r2, r3);
      r1 = CPU.addT(r2, 0x0);
      r3 = MEMORY.ref(4, 0x801f060).get();
      r1 = CPU.subT(r1, 0x40);
      r0_0 = CPU.movT(0x1);
      MEMORY.ref(2, r1).setu(r3);
      r1 = CPU.addT(r1, 0x2);
      CPU.cmpT(r0_0, CPU.r11().value);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r3 = MEMORY.ref(4, 0x801f064).get();

        //LAB_801f046
        do {
          r0_0 = CPU.addT(r0_0, 0x1);
          MEMORY.ref(2, r1).setu(r3);
          r1 = CPU.addT(r1, 0x2);
          CPU.cmpT(r0_0, CPU.r11().value);
        } while(!CPU.cpsr().getCarry()); // unsigned <
      }

      //LAB_801f050
      r3 = MEMORY.ref(4, 0x801f068).get();
      MEMORY.ref(2, r1).setu(r3);
    }

    //LAB_801f054
    r2 = MEMORY.ref(4, 0x801f074).get();
    r3 = CPU.movT(0x1);
    r2 += CPU.r9().value;
    MEMORY.ref(1, r2).setu(r3);

    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x801f088)
  public static void FUN_801f088(final Panel24 r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x14;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
    CPU.r9().value = r3;
    r3 = MEMORY.ref(4, 0x801f1cc).get();
    r3 = MEMORY.ref(4, r3).get();
    r1 = MEMORY.ref(4, 0x801f1d0).get();
    int r0_0 = CPU.r9().value;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0_0);
    r3 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r5 = CPU.addT(r2, 0x0);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      DMA.channels[3].SAD.setu(FUN_80045e8());
      DMA.channels[3].DAD.setu(0x50001c0);
      DMA.channels[3].CNT.setu(0x80000010);

      r3 = MEMORY.ref(4, 0x801f1e0).get();
      r2 = MEMORY.ref(4, 0x801f1e4).get();
      r3 = MEMORY.ref(2, r3).getUnsigned();
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_801f0ca
    r3 = r0.x_0c.get();
    r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    r2 = CPU.addT(r2, r3);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    r3 = r0.y_0e.get();
    r5 = CPU.addT(r5, r3);
    r5 = CPU.lslT(r5, 5);
    r3 = CPU.movT(0x4);
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);

    //LAB_801f0de
    do {
      r0_0 = MEMORY.ref(4, CPU.sp().value).get();
      r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      r3 = CPU.addT(r0_0, r1);
      r3 = CPU.lslT(r3, 1);
      r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
      CPU.r10().value = r3;
      r3 = MEMORY.ref(4, 0x801f1e8).get();
      CPU.r8().value = r3;
      r3 = MEMORY.ref(4, 0x801f1ec).get();
      r1 = CPU.r10().value;
      r0_0 = MEMORY.ref(4, 0x801f1f0).get();
      r1 = CPU.andT(r1, r3);
      r2 = CPU.r9().value;
      CPU.r12().value = r0_0;
      CPU.r10().value = r1;
      CPU.cmpT(r2, 0x7);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = MEMORY.ref(4, 0x801f1f4).get();
        r0_0 = MEMORY.ref(4, 0x801f1f8).get();
        CPU.r8().value = r3;
        CPU.r12().value = r0_0;
      } else {
        //LAB_801f10a
        r1 = CPU.r9().value;
        CPU.cmpT(r1, 0x0);
        if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
          r1 = CPU.lslT(r1, 2);
          r2 = CPU.r8().value;
          r2 = CPU.lslT(r2, r1);
          CPU.r8().value = r2;
          r3 = MEMORY.ref(4, 0x801f1f4).get();
          r2 = CPU.movT(0x20);
          r2 = CPU.subT(r2, r1);
          r3 = CPU.lsrT(r3, r2);
          r0_0 = CPU.r8().value;
          r0_0 = CPU.orrT(r0_0, r3);
          r3 = CPU.r12().value;
          r3 = CPU.lslT(r3, r1);
          CPU.r12().value = r3;
          r3 = MEMORY.ref(4, 0x801f1f8).get();
          CPU.r8().value = r0_0;
          r3 = CPU.lsrT(r3, r2);
          r0_0 = CPU.r12().value;
          r0_0 = CPU.orrT(r0_0, r3);
          CPU.r12().value = r0_0;
        }
      }

      //LAB_801f136
      r2 = MEMORY.ref(4, 0x801f1fc).get();
      CPU.lr().value = 0;
      CPU.r11().value = r2;
      r7 = CPU.movT(0x0);

      //TODO I took some pretty big logical leaps here so these loop conditions may not be right

      //LAB_801f142
      //LAB_801f190
      while(CPU.lr().value < 3) {
        r3 = CPU.r10().value * 0x20 - r7;
        r4 = MEMORY.ref(4, r3 + CPU.r11().value).get();
        r1 = CPU.movT(0x0);
        r0_0 = CPU.movT(0x0);
        r5 = CPU.movT(0xf);

        //LAB_801f152
        do {
          r2 = CPU.addT(r4, 0x0);
          r2 = CPU.andT(r2, r5);
          CPU.cmpT(r2, 0xe);
          if(CPU.cpsr().getZero()) { // ==
            r2 = CPU.lslT(r1, 2);
            r3 = CPU.addT(r5, 0x0);
            r3 = CPU.lslT(r3, r2);
            r2 = CPU.r8().value;
            r3 = CPU.andT(r3, r2);
            r0_0 = CPU.orrT(r0_0, r3);
          } else {
            //LAB_801f164
            CPU.cmpT(r2, 0x1);
            if(CPU.cpsr().getZero()) { // ==
              r2 = CPU.lslT(r1, 2);
              r3 = CPU.addT(r5, 0x0);
              r3 = CPU.lslT(r3, r2);
              r2 = CPU.r12().value;
              r3 = CPU.andT(r3, r2);
              r0_0 = CPU.orrT(r0_0, r3);
            } else {
              //LAB_801f176
              r3 = CPU.lslT(r1, 2);
              r2 = CPU.lslT(r2, r3);
              r0_0 = CPU.orrT(r0_0, r2);
            }
          }

          //LAB_801f17c
          r1 = CPU.addT(r1, 0x1);
          r4 = CPU.lsrT(r4, 4);
          CPU.cmpT(r1, 0x7);
        } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

        MEMORY.ref(4, CPU.r11().value + CPU.r10().value * 0x20 - r7).setu(r0_0);
        r7 += 0x4;
        CPU.lr().value++;

        if(MEMORY.ref(4, CPU.sp().value + 0x4).get() == 0) {
          break;
        }
      }

      //LAB_801f1a4
      r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r0_0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      r2 = CPU.movT(0x8);
      r2 = CPU.negT(r2);
      r3 = CPU.subT(r3, 0x1);
      r0_0 = CPU.addT(r0_0, 0x1);
      CPU.r9().value += r2;
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0_0);
      CPU.cmpT(r3, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    CPU.sp().value += 0x14;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x801f200)
  public static void FUN_801f200(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);

    final int r6 = boardWramMallocHead_3001e50.offset(16 * 0x4).get();
    CPU.sp().value -= 0x34;
    r5 = 0;
    r7 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();
    CPU.r11().value = r0;
    final Panel24 r8 = MEMORY.ref(4, r6).deref(4).cast(Panel24::new);
    final Struct12fc sp20 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
    r3 = sp20._ea5.get();
    if(r3 != 0) {
      r0 = getBattleChars_(null);
      r2 = CPU.movT(0x1);
      r3 = CPU.movT(0x0);
      r2 = CPU.negT(r2);
      CPU.r10().value = r3;
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);
      CPU.cmpT(CPU.r10().value, r0);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r4 = CPU.sp().value;
        r4 = CPU.addT(r4, 0x28);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
        r3 = CPU.movT(0x58);
        r3 = MEMORY.ref(2, r7 + r3).getUnsigned();
        r0 = CPU.addT(r4, 0x0);
        r1 = CPU.movT(0xff);
        MEMORY.ref(2, r0).setu(r3);
        r1 = CPU.lslT(r1, 16);
        r3 = CPU.lslT(r3, 16);
        r3 = CPU.cmpT(r3, r1);
        if(!CPU.cpsr().getZero()) { // !=
          r2 = CPU.addT(r7, 0x0);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r2 = CPU.addT(r2, 0x58);
          r1 = CPU.movT(0x0);

          //LAB_801f26a
          do {
            r3 = CPU.movT(0x1);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            CPU.r10().value += r3;
            r1 = CPU.addT(r1, 0x2);
            CPU.cmpT(CPU.r10().value, r4);
            if(CPU.cpsr().getCarry()) { // unsigned >=
              break;
            }
            r2 = CPU.addT(r2, 0x2);
            r3 = MEMORY.ref(2, r2).getUnsigned();
            r4 = CPU.movT(0xff);
            MEMORY.ref(2, r1 + r0).setu(r3);
            r4 = CPU.lslT(r4, 16);
            r3 = CPU.lslT(r3, 16);
            r3 = CPU.cmpT(r3, r4);
          } while(!CPU.cpsr().getZero()); // !=
        }
      }
    } else {
      //LAB_801f288
      r0 = getCharCount_();
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
      r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r0 = CPU.movT(0x0);
      CPU.r10().value = r0;
      CPU.cmpT(CPU.r10().value, r1);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r2 = CPU.sp().value;
        r3 = MEMORY.ref(4, 0x801f2c4).get();
        r4 = CPU.movT(0xfc);
        r2 = CPU.addT(r2, 0x28);
        r4 = CPU.lslT(r4, 1);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
        r1 = CPU.addT(r2, 0x0);
        r2 = CPU.addT(r3, r4);

        //LAB_801f2a8
        do {
          r3 = MEMORY.ref(1, r2).getUnsigned();
          MEMORY.ref(2, r1).setu(r3);
          r0 = CPU.movT(0x1);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          CPU.r10().value += r0;
          r2 = CPU.addT(r2, 0x1);
          r1 = CPU.addT(r1, 0x2);
          CPU.cmpT(CPU.r10().value, r3);
        } while(!CPU.cpsr().getCarry()); // unsigned <
      } else {
        //LAB_801f2c8
        r4 = CPU.sp().value;
        r4 = CPU.addT(r4, 0x28);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
      }

      //LAB_801f2ce
      r0 = CPU.r10().value;
      r3 = MEMORY.ref(4, 0x801f304).get();
      r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      r2 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r1 + r2).setu(r3);
    }

    //LAB_801f2d8
    r3 = CPU.movT(0x1);
    r2 = CPU.r10().value;
    r3 = CPU.negT(r3);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
    CPU.cmpT(CPU.r11().value, r3);
    if(CPU.cpsr().getZero()) { // ==
      r4 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
      CPU.r11().value = r4;
    }

    //LAB_801f2e8
    r3 = CPU.movT(0x1);
    r0 = CPU.r11().value;
    r3 = CPU.andT(r3, r0);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = CPU.movT(0x3);
      r3 = CPU.negT(r3);
      r0 = CPU.andT(r0, r3);
      CPU.r11().value = r0;
    }

    //LAB_801f2fa
    if(sp20._ea5.get() == 0 || FUN_80b5130(0, 0) == 0) {
      //LAB_801f31c
      r3 = CPU.movT(0x3);
      r4 = CPU.r11().value;
      r3 = CPU.negT(r3);
      r4 = CPU.andT(r4, r3);
      CPU.r11().value = r4;
    }

    //LAB_801f326
    r0 = CPU.r11().value;
    CPU.cmpT(r0, 0x9);
    if(CPU.cpsr().getZero()) { // ==
      r0 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
      r1 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
      r2 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
      r3 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
      clearPanelBuffer(r0, r1, r2, r3);
    } else {
      //LAB_801f33a
      sp20._ea6.set(1);
      r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
      CPU.cmpT(r3, CPU.r11().value);
      if(CPU.cpsr().getZero()) { // ==
        drawPanelBackground(r8);
        FUN_801ef68(r8, CPU.r11().value);
      } else {
        //LAB_801f35a
        clearPanelBuffer(MEMORY.ref(2, r6 + 0x4).getUnsigned(), MEMORY.ref(2, r6 + 0x6).getUnsigned(), MEMORY.ref(2, r6 + 0x8).getUnsigned(), MEMORY.ref(2, r6 + 0xa).getUnsigned());
        FUN_801eea0(CPU.r11().value);
        r8.w_08.set(MEMORY.ref(2, r6 + 0x8).getUnsigned());
        r8.h_0a.set(MEMORY.ref(2, r6 + 0xa).getUnsigned());
        r8.x_0c.set(MEMORY.ref(2, r6 + 0x4).getUnsigned());
        drawPanelBackground(MEMORY.ref(2, r6 + 0x4).getUnsigned(), MEMORY.ref(2, r6 + 0x6).getUnsigned(), MEMORY.ref(2, r6 + 0x8).getUnsigned(), MEMORY.ref(2, r6 + 0xa).getUnsigned());
        FUN_801ef68(r8, CPU.r11().value);
      }

      //LAB_801f392
      r3 = CPU.movT(0x2);
      r2 = CPU.r11().value;
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r5 = CPU.movT(0x5);
      }

      //LAB_801f39e
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r3 = CPU.movT(0x0);
      CPU.r10().value = r3;
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_801f3aa
        r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r0 = CPU.sp().value;
        r1 = CPU.lslT(r1, 3);
        r2 = CPU.addT(r5, 0x1);
        r0 = CPU.addT(r0, 0x28);
        r5 = CPU.lslT(r5, 3);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        CPU.r9().value = r5;

        //LAB_801f3c2
        do {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          final Unit14c charData = getUnit_(MEMORY.ref(2, r3 + r4).getUnsigned());
          if(charData.hp_38.get() == 0) {
            FUN_801e71c(0x2);
            //LAB_801f3e2
          } else if(charData.hp_38.get() <= charData.maxHp_34.get() / 4) {
            FUN_801e71c(0x4);
          } else {
            //LAB_801f3f6
            FUN_801e71c(0xf);
          }

          //LAB_801f3fc
          sp20._ea7.set(0xe);
          if(sp20._ea5.get() != 0) {
            sp20._ea7.set(0x5);
          }

          //LAB_801f418
          MEMORY.ref(4, CPU.sp().value).setu(0);
          FUN_801ea3c(charData.hp_38.get(), r8, CPU.r9().value, MEMORY.ref(4, CPU.sp().value + 0x14).get() + 0x8, MEMORY.ref(4, CPU.sp().value).get());
          sp20._ea7.set(0xf);
          FUN_801e8b0(charData.name_00.getAddress(), r8, CPU.r9().value, MEMORY.ref(4, CPU.sp().value + 0x14).get());
          FUN_801e71c(0xf);
          r1 = charData.maxHp_34.get();
          CPU.cmpT(r1, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            final int r6_0 = charData.hp_38.get();
            r0 = CPU.lslT(r6_0, 2);
            r0 = CPU.addT(r0, r6_0);
            r0 = CPU.lslT(r0, 3);
            r0 = divideS(r0, r1);
            r3 = CPU.addT(r0, 0x0);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              CPU.cmpT(r6_0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r3 = CPU.movT(0x1);
              }
            }

            //LAB_801f460
            r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            r2 = CPU.addT(r2, 0x2);
            FUN_801f088(r8, r1, r2, r3);
          }

          //LAB_801f46c
          r1 = CPU.movT(0x1);
          r3 = CPU.r11().value;
          r3 = CPU.andT(r3, r1);
          if(r3 != 0) {
            sp20._ea7.set(0xe);

            if(sp20._ea5.get() != 0) {
              sp20._ea7.set(5);
            }

            //LAB_801f48e
            r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r0 = charData.pp_3a.get();
            r3 = CPU.addT(r3, 0x10);
            MEMORY.ref(4, CPU.sp().value).setu(r1);
            r2 = CPU.r9().value;
            FUN_801ea3c(r0, r8, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
            r1 = charData.maxPp_36.get();
            CPU.cmpT(r1, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              final int r6_0 = charData.pp_3a.get();
              r0 = CPU.lslT(r6_0, 2);
              r0 = CPU.addT(r0, r6_0);
              r0 = CPU.lslT(r0, 3);
              r0 = divideS(r0, r1);
              r3 = CPU.addT(r0, 0x0);
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                CPU.cmpT(r6_0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r3 = CPU.movT(0x1);
                }
              }

              //LAB_801f4c2
              r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
              r2 = CPU.addT(r2, 0x3);
              FUN_801f088(r8, r1, r2, r3);
            }
          }

          //LAB_801f4ce
          r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = CPU.movT(0x1);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r0 = CPU.addT(r0, 0x6);
          r1 = CPU.movT(0x30);
          r2 = CPU.addT(r2, 0x2);
          CPU.r10().value += r3;
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
          CPU.r9().value += r1;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
          CPU.cmpT(CPU.r10().value, r4);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_801f4ea
      CPU.r10().value = 0;
      sp20._ea7.set(0xf);
      r3 = sp20._ea5.get();
      if(r3 != 0) {
        r3 = CPU.movT(0x2);
        r0 = CPU.r11().value;
        r3 = CPU.andT(r3, r0);
        if(r3 != 0) {
          r3 = CPU.movT(0x1);
          r3 = CPU.andT(r3, r0);
          r7 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          if(r3 != 0) {
            r7 = CPU.addT(r7, 0x1);
          }

          //LAB_801f518
          final int r6_0 = CPU.sp().value + 0x24;
          FUN_80b5130(0, r6_0);
          FUN_8019000(r8, 0x5001, 0, r7, CPU.r10().value);
          FUN_8019000(r8, 0x5002, 2, r7, CPU.r10().value);
          FUN_8019000(r8, 0x5003, 0, r7 + 1, CPU.r10().value);
          FUN_8019000(r8, 0x5004, 2, r7 + 1, CPU.r10().value);
          FUN_8018efc(r8, MEMORY.ref(1, r6_0).getUnsigned() + 0x30, 0x1, r7, CPU.r10().value);
          FUN_8018efc(r8, MEMORY.ref(1, r6_0 + 0x1).getUnsigned() + 0x30, 0x3, r7, CPU.r10().value);
          FUN_8018efc(r8, MEMORY.ref(1, r6_0 + 0x2).getUnsigned() + 0x30, 0x1, r7 + 1, CPU.r10().value);
          FUN_8018efc(r8, MEMORY.ref(1, r6_0 + 0x3).getUnsigned() + 0x30, 0x3, r7 + 1, CPU.r10().value);
        }
      }

      //LAB_801f59c
      sp20._ea6.set(0);
    }

    //LAB_801f5a6
    CPU.sp().value += 0x34;
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x801f5d4)
  public static void FUN_801f5d4() {
    final int r3 = boardWramMallocHead_3001e50.offset(16 * 0x4).get();
    FUN_8016418(MEMORY.ref(4, r3).deref(4).cast(Panel24::new), 0x1);
    freeSlot(16);
  }

  @Method(0x801f680)
  public static int decodeTime(final int timestamp, final int out) {
    CPU.sp().value -= 0x40;
    final int r6 = Math.min(59999, divideU(timestamp, 3600));
    final int div = divideU(r6, 60);
    final int mod = modU(r6, 60);
    final int num1 = convertNumberToAscii(CPU.sp().value, div, 0x3);
    MEMORY.ref(1, out).setu(MEMORY.ref(1, num1).getUnsigned());
    MEMORY.ref(1, out + 0x1).setu(MEMORY.ref(1, num1 + 0x1).getUnsigned());
    MEMORY.ref(1, out + 0x2).setu(MEMORY.ref(1, num1 + 0x2).getUnsigned());
    MEMORY.ref(1, out + 0x3).setu(0x3a);
    final int num2 = convertNumberToAscii(CPU.sp().value, mod + 100, 0x2);
    MEMORY.ref(1, out + 0x4).setu(MEMORY.ref(1, num2).getUnsigned());
    MEMORY.ref(1, out + 0x5).setu(MEMORY.ref(1, num2 + 0x1).getUnsigned());
    MEMORY.ref(1, out + 0x6).setu(0);
    CPU.sp().value += 0x40;
    return out;
  }

  @Method(0x801f704)
  public static int FUN_801f704() {
    final ArrayRef<SaveStruct1100.Preview40> r2 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new)._1040;

    //LAB_801f712
    for(int r0 = 0; r0 < 3; r0++) {
      if(r2.get(r0).level_1c.get() == 0) {
        return r0;
      }
    }

    //LAB_801f722
    return 999;
  }

  @Method(0x801f730)
  public static int FUN_801f730(final int r0) {
    int r5 = -9;

    if(loadSaveList() == 0) {
      r5 = loadSavePreview();

      if(r0 != 0) {
        final SaveStruct1100 r3 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);

        //LAB_801f754
        for(int r1 = 0; r1 < 3; r1++) {
          if(r3._1040.get(r1)._31.get() != 0) {
            r5--;
          }

          //LAB_801f760
        }
      }
    }

    //LAB_801f766
    unloadSaveList();
    return r5;
  }

  @Method(0x801f77c)
  public static int FUN_801f77c() {
    int r5 = 0;
    int r6 = -9;

    if(loadSaveList() == 0) {
      r6 = loadSavePreview();

      final SaveStruct1100 saveStruct = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);
      MEMORY.ref(2, 0x2002010).setu(0);
      MEMORY.ref(2, 0x200200c).setu(0);

      //LAB_801f7a8
      for(int saveSlot = 0; saveSlot < 3; saveSlot++) {
        final SaveStruct1100.Preview40 preview = saveStruct._1040.get(saveSlot);
        if(preview._31.get() != 0) {
          MEMORY.ref(2, 0x2002010).setu(0x1); // Is clear data?
          r5++;
        }

        //LAB_801f7b4
        if(preview._32.get() != 0) {
          MEMORY.ref(2, 0x200200c).setu(0x1);
        }

        //LAB_801f7be
      }

      if((heldButtonsLastFrame_3001ae8.get() & 0x120) != 0x120) { // Left/R
        MEMORY.ref(2, 0x2002010).setu(0);
      }
    }

    //LAB_801f7f6
    unloadSaveList();

    if(r6 != 0 && r5 == r6) {
      return r6 + 100; // All games are cleared?
    }

    //LAB_801f810
    //LAB_801f812
    return r6;
  }

  @Method(0x801f818)
  public static int FUN_801f818() {
    CPU.sp().value -= 0x1c;
    int r8 = 0;
    MEMORY.ref(4, 0x2000240).setu(calculateBuildDate_());
    MEMORY.ref(4, 0x2000244).setu(_3001c9c.get());
    MEMORY.ref(4, 0x2001100).setu(_3001c9c.get());
    MEMORY.ref(1, 0x200046a).setu(_3001d08.get());
    final Unit14c charData = getUnit_(playerMapActorIndex_2000434.get());

    //LAB_801f860
    for(int r5 = 0; r5 < 12; r5++) {
      MEMORY.ref(1, 0x2000000 + r5).setu(charData.name_00.get(r5).get());
    }

    MEMORY.ref(1, 0x200000c).setu(charData.level_0f.get());
    MEMORY.ref(4, 0x2000010).setu(MEMORY.ref(4, 0x2000244).get());
    MEMORY.ref(2, 0x200000e).setu(getRoomNameStringId_(mapId_2000400.get(), entranceId_2000402.get()));
    MEMORY.ref(1, 0x200000d).setu(charData.class_129.get());
    MEMORY.ref(4, 0x2000014).setu(MEMORY.ref(4, 0x2000240 + 0x10).get());
    MEMORY.ref(1, 0x2000018).setu(getDjinnCount_(0));
    MEMORY.ref(1, 0x2000019).setu(getDjinnCount_(0x1));
    MEMORY.ref(1, 0x200001a).setu(getDjinnCount_(0x2));
    MEMORY.ref(1, 0x200001b).setu(getDjinnCount_(0x3));

    final int r6 = CPU.sp().value;
    getPartyMemberIds_(r6);

    //LAB_801f8e4
    int r5;
    for(r5 = 0; r5 < 4 && MEMORY.ref(2, r6 + r5 * 0x2).getUnsigned() != 0xff; r5++) {
      MEMORY.ref(1, 0x200001c + r5).setu(MEMORY.ref(2, r6 + r5 * 0x2).getUnsigned());
    }

    //LAB_801f8f8
    MEMORY.ref(1, 0x200001c + r5).setu(-1);
    MEMORY.ref(1, 0x2000024).setu(MEMORY.ref(1, 0x2000445).getUnsigned());
    MEMORY.ref(1, 0x2000025).setu(MEMORY.ref(1, 0x2000446).getUnsigned());
    MEMORY.ref(1, 0x2000021).setu(MEMORY.ref(1, 0x200044f).getUnsigned());
    MEMORY.ref(1, 0x2000022).setu(0);

    //LAB_801f936
    for(r5 = 0x30; r5 < 0x80; r5++) {
      if(readFlag_(r5) != 0) {
        MEMORY.ref(1, 0x2000022).incr();
      }

      //LAB_801f946
    }

    final int r0 = readFlag_(0x20);
    MEMORY.ref(1, 0x2000023).setu((-r0 | r0) >>> 31);
    MEMORY.ref(2, 0x2000026).setu(MEMORY.ref(4, 0x2000240).get());

    //LAB_801f96e
    //LAB_801f974
    for(r5 = 0; r5 < 0x3c8; r5++) {
      r8 += MEMORY.ref(4, 0x2000040 + r5 * 0x4).get();
    }

    MEMORY.ref(4, 0x200002c).setu(r8);

    CPU.sp().value += 0x1c;
    return r8;
  }

  @Method(0x801fba8)
  public static int FUN_801fba8() {
    int r8 = 0;
    if(loadSaveList() != 0) {
      FUN_801776c(0xa, 0x1);
      r8 = -9;
    } else {
      //LAB_801fbca
      loadSavePreview();

      int r5 = drawSaveMenu(0, 2);
      if(r5 == -1) {
        r8 = -1;
        //LAB_801fbe4
      } else if((FUN_8005a78(r5, 0x2000000) | FUN_8005a78(r5 + 0x3, 0x2001000)) != 0) {
        FUN_801776c(0xc, 0x1);
        r8 = -2;
      } else {
        //LAB_801fc12
        r5 = FUN_801f704();
        if(r5 == 999) {
          FUN_801776c(0xd, 0x1);
          r8 = -5;
          //LAB_801fc2a
        } else if((saveGame(r5, 0x2000000) | saveGame(r5 + 0x3, 0x2001000)) != 0) {
          FUN_801776c(0xd, 0x1);
          r8 = -3;
        } else {
          //LAB_801fc52
          FUN_801776c(0x19, 0x1);
        }
      }
    }

    //LAB_801fc5a
    unloadSaveList();
    return r8;
  }

  @Method(0x801fc84)
  public static int FUN_801fc84() {
    int r7 = 0;
    if(loadSaveList() != 0) {
      FUN_801776c(10, 1);
      r7 = -9;
    } else {
      //LAB_801fc9e
      loadSavePreview();
      final int r6 = drawSaveMenu(0, 3);
      if(r6 == -1) {
        r7 = -1;
      } else {
        //LAB_801fcb8
        FUN_8017658(22, 8, 1, 2);

        //LAB_801fccc
        while(FUN_8017364() == 0) {
          //LAB_801fcc6
          sleep(1);
        }

        if(FUN_8028df4(1, 0, 3, 1) != 0) {
          FUN_8019a54();
        } else {
          //LAB_801fcea
          FUN_8019a54();

          if((FUN_8005ac0(r6) | FUN_8005ac0(r6 + 0x3)) != 0) {
            FUN_801776c(13, 1);
            r7 = -4;
          } else {
            //LAB_801fd10
            FUN_801776c(24, 1);
          }
        }
      }
    }

    //LAB_801fd18
    unloadSaveList();
    return r7;
  }

  @Method(0x801fd34)
  public static void FUN_801fd34() {
    //LAB_801fd3c
    for(int r5 = 0; r5 < 4; r5++) {
      int r3 = sin((ticks_3001800.get() + r5 * 8) * 0x300) / 0x4000;
      r3 = r3 + 0x14 << 10 | r3 + 0x10 << 5 | r3 * 2 + 0x16;
      MEMORY.ref(2, 0x50001d0 + r5 * 0x2).setu(r3);
    }
  }

  @Method(0x801fd84)
  public static void FUN_801fd84() {
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_801fd34"), 0xc80);
  }

  @Method(0x801fd98)
  public static void FUN_801fd98() {
    clearTickCallback(getRunnable(GoldenSun_801.class, "FUN_801fd34"));
  }

  @Method(0x801fda8)
  public static void FUN_801fda8(final Panel24 panel, int x, int y, final int w, final int h) {
    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    x = x + panel.x_0c.get() + 1;
    y = y + panel.y_0e.get() + 1;
    int r6 = w;
    int r5 = h;
    if(x < 0) {
      r6 = r6 + x;
      x = 0;
    }

    //LAB_801fdc6
    if(r6 + x >= 30) {
      r6 = 30 - x;
    }

    //LAB_801fdd0
    if(y < 0) {
      r5 = r5 + y;
      y = 0;
    }

    //LAB_801fdd8
    if(y + r5 >= 30) {
      r5 = 20 - y;
    }

    //LAB_801fde2
    if(r6 > 0 && r5 > 0) {
      //LAB_801fdf0
      for(int i = 0; i < r5; i++) {
        //LAB_801fdfa
        for(int r0_0 = 0; r0_0 < r6; r0_0++) {
          MEMORY.ref(2, r7.getAddress() + (y + i) * 0x40 + (x + r0_0) * 0x2).setu(0xe006); //TODO
        }

        //LAB_801fe04
      }

      r7._ea3.set(0x1);
    }

    //LAB_801fe24
  }

  @Method(0x801fe2c)
  public static void loadCharacterSprites(final Panel24 panel, final int x, final int y, final SaveStruct1100.Preview40 preview) {
    final int r1_0 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();

    //LAB_801fe72
    for(int charIndex = 0; charIndex < 4 && preview.charIds.get(charIndex).get() != -1; charIndex++) {
      final Sprite38 r5 = loadSprite_(FUN_808a5f0(preview.charIds.get(charIndex).get(), preview._33.get()));
      if(r5 != null) {
        setSpriteAnimation_(r5, 0x1);
        r5._26.set(0);
        r5.packet_00.attribs_04.attrib2_04.and(~0xc00);
      }

      //LAB_801fea6
      MEMORY.ref(4, r1_0 + 0x114 + charIndex * 0x4).setu(r5 == null ? 0 : r5.getAddress());
      MEMORY.ref(2, r1_0 + 0x134 + charIndex * 0x2).setu((x + panel.x_0c.get() + charIndex * 0x3) * 0x8 + 0x10);
      MEMORY.ref(2, r1_0 + 0x134 + 0x10 + charIndex * 0x2).setu((y + panel.y_0e.get()) * 0x8 + 0x10);
      MEMORY.ref(4, r1_0 + 0x114 + 0x40 + charIndex * 0x4).setu(0x10000);
    }

    //LAB_801feee
    setTickCallback(getRunnable(GoldenSun_801.class, "drawCharacters"), 0xc80);
  }

  @Method(0x801ff14)
  public static void clearCharacterSprites() {
    final int r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    clearTickCallback(getRunnable(GoldenSun_801.class, "drawCharacters"));

    //LAB_801ff2e
    for(int r6 = 0; r6 < 4; r6++) {
      final int r0 = MEMORY.ref(4, r7 + 0x114 + r6 * 0x4).get();
      if(r0 != 0) {
        clearSprite_(MEMORY.ref(4, r0, Sprite38::new));
        MEMORY.ref(4, r7 + 0x114 + r6 * 0x4).setu(0);
      }

      //LAB_801ff3c
    }
  }

  @Method(0x801ff58)
  public static void drawCharacters() {
    CPU.sp().value -= 0x1c;

    final int r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    final int r4 = CPU.sp().value + 0x4;
    final int r6 = CPU.sp().value + 0xc;

    //LAB_801ff7e
    for(int r8 = 0; r8 < 4; r8++) {
      final int r0_0 = MEMORY.ref(4, r3 + 0x114 + r8 * 0x4).get();

      if(r0_0 != 0) {
        MEMORY.ref(4, r4).setu(MEMORY.ref(4, r3 + 0x114 + 0x40 + r8 * 0x4).get());
        MEMORY.ref(4, r4 + 0x4).setu(MEMORY.ref(4, r3 + 0x114 + 0x40 + r8 * 0x4).get());

        MEMORY.ref(4, r6).setu(MEMORY.ref(2, r3 + 0x134 + r8 * 0x2).get() << 16);
        MEMORY.ref(4, r6 + 0x4).setu(0x1f40000);
        MEMORY.ref(4, r6 + 0x8).setu(0x1f40000 + (MEMORY.ref(2, r3 + 0x134 + 0x10 + r8 * 0x2).get() << 16));
        MEMORY.ref(4, r6 + 0xc).setu(0);

        drawSprite_(MEMORY.ref(4, r0_0, Sprite38::new), r6, r4, 0x4000);
      }

      //LAB_801ffb6
    }

    CPU.sp().value += 0x1c;
  }

  @Method(0x801ffd8)
  public static void loadDjinnSprites(@Nullable final Panel24 r0, final int x, final int y) {
    if(r0 != null) {
      final int r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();

      //LAB_8020008
      for(int r7 = 0; r7 < 4; r7++) {
        final Sprite38 r5 = loadSprite_(MEMORY.ref(4, 0x8073854 + r7 * 0x4).get());
        if(r5 != null) {
          setSpriteAnimation_(r5, 0x2);
          r5._26.set(0);
          r5.packet_00.attribs_04.attrib2_04.and(~0xc00);
        }

        //LAB_8020032
        MEMORY.ref(4, r3 + 0x224 + r7 * 0x4).setu(r5 == null ? 0 : r5.getAddress()); //TODO
        MEMORY.ref(2, r3 + 0x234 + r7 * 0x2).setu(0x10 + (r0.x_0c.get() + x + r7 * 0x3) * 0x8);
        MEMORY.ref(2, r3 + 0x234 + 0x8 + r7 * 0x2).setu(0x10 + (r0.y_0e.get() + y) * 0x8);
      }

      setTickCallback(getRunnable(GoldenSun_802.class, "drawDjinn"), 0xc80);
    }

    //LAB_8020068
  }
}
