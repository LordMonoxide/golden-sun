package org.goldensun;

import org.goldensun.battle.BattleStruct82c;
import org.goldensun.battle.Camera4c;
import org.goldensun.battle.EnemyStats54;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Unit14c;
import org.goldensun.types.VblankTransfer0c;
import org.goldensun.types.VblankTransferQueue184;
import org.goldensun.types.Vec3;

import static org.goldensun.CopiedSegment8000770.div16;
import static org.goldensun.CopiedSegment8000770.memfill32;
import static org.goldensun.CopiedSegment8000770.mul16;
import static org.goldensun.CopiedSegment8000770.transformVector;
import static org.goldensun.GoldenSun.queueVblankNand16;
import static org.goldensun.GoldenSun.queueVblankOr16;
import static org.goldensun.GoldenSun.queueVblankNand16_80000;
import static org.goldensun.GoldenSun.FUN_800543c;
import static org.goldensun.GoldenSun.FUN_8005490;
import static org.goldensun.GoldenSun.FUN_80054e4;
import static org.goldensun.GoldenSun.FUN_8005534;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.divideU;
import static org.goldensun.GoldenSun.initMatrixStack;
import static org.goldensun.GoldenSun.rotateMatrixX;
import static org.goldensun.GoldenSun.rotateMatrixY;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sqrt16;
import static org.goldensun.GoldenSun.translateMatrix;
import static org.goldensun.GoldenSun.FUN_80051d8;
import static org.goldensun.GoldenSun.FUN_8005258;
import static org.goldensun.GoldenSun.FUN_8005268;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars._200047c;
import static org.goldensun.GoldenSunVars.actorProperties_80c7420;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.vblankTransferQueue_2002090;
import static org.goldensun.GoldenSun_801.FUN_8015118;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015128;
import static org.goldensun.GoldenSun_801.FUN_80151c8;
import static org.goldensun.GoldenSun_807.checkLevelUp_;
import static org.goldensun.GoldenSun_807.readFlagsByte_;
import static org.goldensun.GoldenSun_807.loadEnemyUnit_;
import static org.goldensun.GoldenSun_807.getEnemyStats_;
import static org.goldensun.GoldenSun_807.addCoins_;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_807.getItem_;
import static org.goldensun.GoldenSun_807.giveItem_;
import static org.goldensun.GoldenSun_807.lcgRand_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.recalcStats_;
import static org.goldensun.GoldenSun_807.setFlag_;
import static org.goldensun.GoldenSun_80b.FUN_80b5028;
import static org.goldensun.GoldenSun_80b.FUN_80b5038;
import static org.goldensun.GoldenSun_80b.FUN_80b5048;
import static org.goldensun.GoldenSun_80b.FUN_80b595c;
import static org.goldensun.GoldenSun_80b.FUN_80b845c;
import static org.goldensun.GoldenSun_80b.FUN_80bb65c;
import static org.goldensun.GoldenSun_80b.getBattleChars;
import static org.goldensun.GoldenSun_80b.getLivingUnitIds;
import static org.goldensun.GoldenSun_80b.getUnitIds;
import static org.goldensun.GoldenSun_80b.loadUnitSprites;
import static org.goldensun.GoldenSun_80b.getCombatantForUnit;
import static org.goldensun.GoldenSun_80d.FUN_80d6888;
import static org.goldensun.GoldenSun_80e.FUN_80ed408;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80c {
  private GoldenSun_80c() { }

  @Method(0x80c0098)
  public static void FUN_80c0098(int r0) {
    int r2 = 0x3020100;

    //LAB_80c00a0
    for(int r3 = 0; r3 < 64; r3++) {
      MEMORY.ref(4, r0).setu(r2);
      r0 += 0x4;
      r2 += 0x4040404;
    }

    r2 = 0x3020100;

    //LAB_80c00b0
    for(int r3 = 0; r3 < 56; r3++) {
      MEMORY.ref(4, r0).setu(r2);
      r0 += 0x4;
      r2 += 0x4040404;
    }

    MEMORY.call(0x3000168, r0, 0x220, -1); // memfill32
  }

  @Method(0x80c00d8)
  public static void FUN_80c00d8(final int r0) {
    MEMORY.call(0x3000168, r0, 0x100, -1); // memfill32
    MEMORY.call(0x3000168, r0 + 0x100, 0x80, 0x3ff03ff); // memfill32

    int r2 = 0x2010200;
    int r6 = r0 + 0x180;

    //LAB_80c0102
    for(int r3 = 0; r3 < 240; r3++) {
      MEMORY.ref(4, r6).setu(r2);
      r6 += 0x4;
      r2 += 0x20002;
    }

    MEMORY.call(0x3000168, r6, 0x280, 0x3ff03ff); // memfill32
  }

  /** Something related to rendering the battle background */
  @Method(0x80c0130)
  public static void FUN_80c0130() {
    final int r3 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    if(MEMORY.ref(4, r3 + 0x8).get() == 0x2) {
      final int r4 = boardWramMallocHead_3001e50.offset(10 * 0x4).get();
      final int r0 = r4 + MEMORY.ref(4, r4).get() * 0x140;
      GPU.BG2CNT.setu(MEMORY.ref(2, r0 + 0x20).getUnsigned());
      DMA.channels[0].SAD.setu(r0 + 0x22);
      DMA.channels[0].DAD.setu(GPU.BG2CNT.getAddress());
      DMA.channels[0].CNT.setu(0xa2600001);
      DMA.channels[3].SAD.setu(r4 + 0x10);
      DMA.channels[3].DAD.setu(GPU.BG2PA.getAddress());
      DMA.channels[3].CNT.setu(0x84000004);
    }
  }

  @Method(0x80c01bc)
  public static void FUN_80c01bc() {
    final int r0;
    final int r1;
    int r2;
    int r3;
    final int r4;

    r3 = 0x3001ef8;
    r0 = MEMORY.ref(4, r3).get();
    r3 = r3 - 0x78;
    r1 = MEMORY.ref(4, r0).get();
    r4 = MEMORY.ref(4, r3).get();
    r2 = 0x34 - r1;
    if(r2 > 0x20) {
      r2 = 0x20;
    }

    //LAB_80c01d2
    if(r2 < 0) {
      r2 = 0x0;
    }

    //LAB_80c01d8
    r3 = 0x3001ad0;
    MEMORY.ref(2, r3 + 0x2).setu(r2);
    if((r1 & 0xffff_ffffL) <= (0x50 & 0xffff_ffffL)) {
      r2 = r1 << 1;
      r2 = r2 + r1;
      r3 = r2 << 4;
      r3 = r3 - r2;
      r2 = 0xaf80;
      r3 = r3 << 3;
      r3 = r3 + r2;
      MEMORY.ref(2, r4 + 0x36).setu(r3);
    }

    //LAB_80c01f0
    r3 = MEMORY.ref(4, r0).get();
    r2 = r3 + 0x1;
    MEMORY.ref(4, r0).setu(r2);
    if((r2 & 0xffff_ffffL) <= 80) {
      FUN_80c0cec(0, 0, 0, 0xb4 - r2);
    } else {
      //LAB_80c020a
      FUN_80c0cec(0, 0, 0, 100);
    }

    //LAB_80c0216
  }

  @Method(0x80c0228)
  public static void FUN_80c0228() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;

    r3 = 0x3001ef8;
    r3 = MEMORY.ref(4, r3).get();
    r0 = MEMORY.ref(4, r3).get();
    if((r0 & 0xffff_ffffL) < 80) {
      r3 = r0 & 0x7;
      r4 = r3 + 0xf081;
      r3 = r0;
      if(r0 < 0) {
        r3 = r0 + 0x7;
      }

      //LAB_80c0244
      r3 = r3 >> 3;
      r2 = 0xd - r3;
      r5 = 0x6006000;
      r3 = r2 << 6;
      r1 = 0x0;
      r2 = r3 + r5;

      //LAB_80c0252
      do {
        r1 = r1 + 0x1;
        MEMORY.ref(2, r2).setu(r4);
        r2 = r2 + 0x2;
      } while(r1 != 0x20);

      r4 = r4 | 0x800;
      r3 = r0;
      if(r3 < 0) {
        r3 = r3 + 0x7;
      }

      //LAB_80c026a
      r3 = r3 >> 3;
      r2 = r3;
      r2 = r2 + 0xd;
      if((r2 & 0xffff_ffffL) <= 20) {
        r0 = 0x6006000;
        r3 = r2 << 6;
        r1 = 0x0;
        r2 = r3 + r0;

        //LAB_80c027c
        do {
          r1 = r1 + 0x1;
          MEMORY.ref(2, r2).setu(r4);
          r2 = r2 + 0x2;
        } while(r1 != 0x20);
      }
    }

    //LAB_80c0286
  }

  @Method(0x80c0298)
  public static void FUN_80c0298() {
    GPU.BG0VOFS.setu(0);
  }

  @Method(0x80c02a4)
  public static void FUN_80c02a4(final int r0, final int entranceId) {
    int r2;
    int r3;
    final int r4;
    int r5;
    final int r6;
    final int r11;

    CPU.sp().value -= 0x94;
    final int r7 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    r11 = mallocSlotChip(42, 0x4);
    if(entranceId != 0x15b) {
      //LAB_80c02ce
      DMA.channels[3].SAD.setu(0x80c5b30);
      DMA.channels[3].DAD.setu(0x6005020);
      DMA.channels[3].CNT.setu(0x84000008);
      DMA.channels[3].SAD.setu(0x80c5b50);
      DMA.channels[3].DAD.setu(0x6005040);
      DMA.channels[3].CNT.setu(0x84000008);
      DMA.channels[3].SAD.setu(0x80c5b70);
      DMA.channels[3].DAD.setu(0x6005060);
      DMA.channels[3].CNT.setu(0x84000008);
      DMA.channels[3].SAD.setu(0x80c5b90);
      DMA.channels[3].DAD.setu(0x6005080);
      DMA.channels[3].CNT.setu(0x84000008);
      DMA.channels[3].SAD.setu(0x80c5bb0);
      DMA.channels[3].DAD.setu(0x60050a0);
      DMA.channels[3].CNT.setu(0x84000008);
      DMA.channels[3].SAD.setu(0x80c5bd0);
      DMA.channels[3].DAD.setu(0x60050c0);
      DMA.channels[3].CNT.setu(0x84000008);
      DMA.channels[3].SAD.setu(0x80c5bf0);
      DMA.channels[3].DAD.setu(0x60050e0);
      DMA.channels[3].CNT.setu(0x84000008);

      GPU.DISPCNT.setu(1);

      MEMORY.ref(4, r7 + 0xc).setu(1);
      MEMORY.ref(4, r7 + 0x8).setu(1);
      MEMORY.ref(4, r7 + 0x10).setu(0);

      r4 = CPU.sp().value + 0x90;
      MEMORY.ref(4, r4).setu(0x33333333);
      DMA.channels[3].SAD.setu(r4);
      DMA.channels[3].DAD.setu(0x6005000);
      DMA.channels[3].CNT.setu(0x85000008);

      MEMORY.ref(4, r4).setu(0);
      DMA.channels[3].SAD.setu(r4);
      DMA.channels[3].DAD.setu(0x6005100);
      DMA.channels[3].CNT.setu(0x85000008);

      GPU.BG1CNT.setu(0xc04);
      GPU.BG0CNT.or(0x2);
      MEMORY.ref(4, r7 + 0x8).setu(2);
      r2 = 0x6006000;

      //LAB_80c036a
      for(int i = 0; i < 32; i++) {
        //LAB_80c0372
        //LAB_80c03b8
        for(r3 = 0; r3 < 32; r3++) {
          MEMORY.ref(2, r2).setu(i > 20 ? 0xf088 : 0xf080);
          r2 = r2 + 0x2;
        }
      }

      r6 = 0x3001ad0;
      MEMORY.ref(2, r6 + 0x2).setu(32);
      MEMORY.ref(2, r6 + 0x6).setu(32);
      MEMORY.ref(2, r6 + 0x4).setu(8);
      sleep(1);
      GPU.WIN0H.setu(240);
      GPU.WIN0V.setu(136);
      GPU.WIN1H.setu(240);
      GPU.WIN1V.setu(136);
      GPU.WININ.setu(0x3537);
      GPU.WINOUT.setu(0x3f21);
      queueVblankNand16(GPU.DISPCNT.getAddress(), 0x7741);
      FUN_80c0cec(0, 0, 0, 180);
      MEMORY.ref(4, r11).setu(0);
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c01bc"), 0xc80);
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c0228"), 0x480);
      setInterruptHandler(2, 32, getRunnable(GoldenSun_80c.class, "FUN_80c0298"));
      MEMORY.ref(2, r6 + 0x2).setu(32);
      sleep(1);
      FUN_8015128(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._41.get());
      sleep(20);
      queueVblankNand16_80000(GPU.BG0CNT.getAddress(), 2);
      queueVblankOr16(GPU.BG0CNT.getAddress(), 0);
      FUN_80b595c(r0);
      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c01bc"));
      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c0228"));
      MEMORY.ref(2, r6 + 0x2).setu(0);
      setInterruptHandler(2, 0, null);
    } else {
      //LAB_80c04c8
      final BattleStruct82c r10 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
      MEMORY.ref(4, r7 + 0xc).setu(1);
      MEMORY.ref(4, r7 + 0x10).setu(0);
      final int r8 = getUnitIds(0x3, null);

      //LAB_80c04e8
      for(int i = 0; i != r8; i++) {
        if(i < 8) {
          r5 = i;
        } else {
          r5 = i + 120;
        }

        //LAB_80c04f2
        if(getUnit_(r5).id_128.get() != 0x94) {
          getCombatantForUnit(r5).scale_18.set(0xb333);
        }

        //LAB_80c0510
      }

      //LAB_80c0516
      r4 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
      INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

      r2 = vblankTransferQueue_2002090.count_00.get();
      if(r2 < 32) {
        vblankTransferQueue_2002090.queue_04.get(r2).src_00.set(0x6041);
        vblankTransferQueue_2002090.queue_04.get(r2).dst_04.set(GPU.DISPCNT.getAddress());
        vblankTransferQueue_2002090.queue_04.get(r2).cnt_08.set(0x20000);
        vblankTransferQueue_2002090.count_00.incr();
      }

      //LAB_80c0544
      INTERRUPTS.INT_MASTER_ENABLE.setu(r4);

      sleep(1);
      r10.backgroundPointerTableId_648.set(0x21);
      r5 = CPU.sp().value + 0x3c;
      final int[] monsterIds = new int[8];
      final int monsterCount = getUnitIds(0x2, monsterIds);
      MEMORY.ref(4, r5 + 0x14).setu(monsterCount);
      MEMORY.ref(2, r5 + 0x24 + monsterCount * 0x2).setu(0xff);
      loadUnitSprites(monsterIds, 0);
      FUN_80c9028(r5);
      FUN_80c0cec(0, 0, 0, 100);
      MEMORY.ref(4, r11).setu(0);
      setInterruptHandler(2, 32, getRunnable(GoldenSun_80c.class, "FUN_80c0298"));
      sleep(1);
      sleep(20);
      FUN_8015128(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._41.get());
      queueVblankNand16_80000(GPU.BG0CNT.getAddress(), 2);
      queueVblankOr16(GPU.BG0CNT.getAddress(), 0);
      GPU.BLDCNT.setu(0x3f40);

      final int[] unitIds = new int[15];
      final int unitCount = getUnitIds(0x3, unitIds);
      unitIds[unitCount] = 0xff;
      loadUnitSprites(unitIds, 0);

      final int[] charIds = new int[8];
      final int charCount = getUnitIds(0x1, charIds);

      //LAB_80c0630
      for(int i = 0; i < charCount; i++) {
        FUN_80c0f98(charIds[i], 1);
      }

      //LAB_80c0640
      //LAB_80c0648
      for(int i = 0; i < 16; i++) {
        GPU.BLDALPHA.setu(i | 0x1000);
        sleep(1);
      }

      //LAB_80c0670
      for(int i = 0; i < charCount; i++) {
        FUN_80c0f98(charIds[i], 0);
      }

      //LAB_80c0680
      FUN_80b595c(r0);
      MEMORY.ref(2, 0x3001ad2).setu(0);
      sleep(1);
      setInterruptHandler(2, 0, null);
    }

    //LAB_80c069c
    setInterruptHandler(2, 0, null);
    GPU.BG1CNT.setu(0x1f83);
    sleep(1);
    GPU.BG1CNT.setu(0x1f83);
    GPU.BG0CNT.and(~0x2);
    MEMORY.ref(2, 0x3001ad4).setu(8);
    GPU.DISPCNT.setu(0x1541);
    freeSlot(42);
    CPU.sp().value += 0x94;
  }

  @Method(0x80c0700)
  public static void FUN_80c0700(final int r0, final int r1) {
    final BattleStruct82c struct = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int oldIme = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);
    if(r1 == 0) {
      DMA.channels[3].SAD.setu(struct._544.getAddress());
      DMA.channels[3].DAD.setu(0x50000c0);
      DMA.channels[3].CNT.setu(0x80000080);
    } else {
      //LAB_80c072a
      final int r2 = 0x10000 - r1 * 0x444;
      struct._644.set(r2);
      multiplyColours(struct._544.getAddress(), 0x50000c0, r2, 0x80);
    }

    //LAB_80c074a
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldIme);
  }

  @Method(0x80c0774)
  public static void FUN_80c0774(final int r0, final int r1, final int r2) {
    int r6 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    if(MEMORY.ref(4, r6 + 0x8).get() == 0) {
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c0130"), 0x4ff);
    }

    //LAB_80c078c
    MEMORY.ref(4, r6 + 0x8).setu(r0);

    if(r0 == 0x1) {
      final int r4 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
      INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

      final int count = vblankTransferQueue_2002090.count_00.get();
      if(count < 32) {
        final VblankTransfer0c r3 = vblankTransferQueue_2002090.queue_04.get(count);
        r3.src_00.set(0x1f83);
        r3.dst_04.set(GPU.BG1CNT.getAddress());
        r3.cnt_08.set(0x20000);
        vblankTransferQueue_2002090.count_00.incr();
      }

      //LAB_80c07be
      INTERRUPTS.INT_MASTER_ENABLE.setu(r4);
    }

    //LAB_80c07c0
    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(0x50000a0);
    DMA.channels[3].CNT.setu(0x80000010);
    MEMORY.ref(2, 0x50000bc).setu(MEMORY.ref(2, 0x50001e8).getUnsigned());

    if(r2 == 0x80) {
      DMA.channels[3].SAD.setu(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._544.getAddress());
      DMA.channels[3].DAD.setu(0x50000c0);
      DMA.channels[3].CNT.setu(0x80000080);
      //LAB_80c07ec
    } else if(r2 != 0) {
      final ArrayRef<UnsignedShortRef> r12 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._544;

      //LAB_80c0802
      for(r6 = 0; r6 < 0x80; r6++) {
        final int r3 = r12.get(r6).get();
        int r = r3 & 0x1f;
        int g = r3 >>> 5 & 0x1f;
        int b = r3 >>> 10 & 0x1f;

        if(r > r2) {
          r -= r2;
        } else {
          //LAB_80c0864
          r = 0;
        }

        //LAB_80c0866
        if(g > r2) {
          g -= r2;
        } else {
          //LAB_80c086e
          g = 0;
        }

        //LAB_80c0870
        if(b > r2) {
          b -= r2;
        } else {
          //LAB_80c0878
          b = 0;
        }

        //LAB_80c087a
        MEMORY.ref(2, 0x50000c0 + r6 * 0x2).setu(b << 10 | g << 5 | r);
      }
    }

    //LAB_80c088e
    FUN_80c0098(0x6003800);
    FUN_80c00d8(0x600f800);
  }

  @Method(0x80c08a8)
  public static void FUN_80c08a8() {
    CPU.sp().value -= 0x4;
    final int r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(mallocSlotBoard(10, 0x2a0));
    DMA.channels[3].CNT.setu(0x850000a8);
    CPU.sp().value += 0x4;

    final int r5 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    MEMORY.ref(4, r5 + 0x8).setu(0);
  }

  @Method(0x80c08e0)
  public static void FUN_80c08e0() {
    freeSlot(10);
  }

  @Method(0x80c08ec)
  public static void loadBattleBackground(final int r0, final int pointerTableId, final int r2) {
    final int r10 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    final int r8 = getPointerTableEntry(pointerTableId);
    final int r6 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();

    final int addr = mallocSlotChip(49, 0x230);
    DMA.channels[3].SAD.setu(0x80b5138);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x8400008c);
    MEMORY.setFunction(addr, GoldenSun_80b.class, "decompressBattleBackground", int.class, int.class);

    final int r3 = boardWramMallocHead_3001e50.offset(49 * 0x4).get();
    MEMORY.call(r3, r8 + 0x100, 0x6008000);
    freeSlot(49);

    DMA.channels[3].SAD.setu(r8);
    DMA.channels[3].DAD.setu(r6 + 0x544);
    DMA.channels[3].CNT.setu(0x84000040);

    if(r2 >= 0) {
      MEMORY.ref(4, r6 + 0x644).setu(0x10000 - r2 * 0x444);
      multiplyColours(r6 + 0x544, 0x50000c0, 0x10000 - r2 * 0x444, 0x80);
    }

    //LAB_80c0974
    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(0x50000a0);
    DMA.channels[3].CNT.setu(0x80000010);
    MEMORY.ref(2, 0x50000bc).setu(MEMORY.ref(2, 0x50001e8).getUnsigned());
    FUN_80c0098(0x6003800);
    FUN_80c00d8(0x600f800);
    MEMORY.call(0x3000164, 0x600ffc0, 0x40); // memzero

    if(MEMORY.ref(4, r10 + 0x8).get() == 0) {
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c0130"), 0x4ff);
    }

    //LAB_80c09ae
    MEMORY.ref(4, r10 + 0x8).setu(r0);

    if(r0 == 1) {
      GPU.BG1CNT.setu(0x1f83);
    }

    //LAB_80c09be
  }

  @Method(0x80c0a24)
  public static void FUN_80c0a24(int r0, int r1, int r2, int r3, final int a4) {
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x10;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    r2 = boardWramMallocHead_3001e50.offset(10 * 0x4).get();
    CPU.r10().value = r0;
    r0 = 0x80;
    r1 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    r0 = r0 << 4;
    CPU.r9().value = r2;
    r2 = 0x0;
    CPU.r11().value = r0;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    if(a4 >= 0x10000) {
      MEMORY.ref(4, CPU.sp().value).setu(0x2000);
      r2 = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new).rotationY_36.get();
      r2 = -r2;
      r3 = r2 << 1;
      r3 = r3 + r2;
      r2 = 0xd0;
      r2 = r2 << 7;
      r2 = r2 + r3;
      CPU.r11().value = r2;
    }

    //LAB_80c0a78
    r3 = CPU.r9().value;
    if(r3 != 0) {
      //LAB_80c0a80
      r0 = MEMORY.ref(4, r1 + 0x8).get();
      if(r0 == 0x1 || MEMORY.ref(4, r1 + 0xc).get() == 0x1) {
        //LAB_80c0a8c
        r3 = MEMORY.ref(4, r1 + 0x10).get();
        if(r3 == 0) {
          r2 = 0x3001ad0;
          r1 = CPU.r11().value;
          r3 = r1 >> 8;
          MEMORY.ref(2, r2 + 0x4).setu(r3);
        }
      }

      //LAB_80c0a9a
      if(r0 == 0x2) {
        //LAB_80c0aa0
        r3 = CPU.r9().value;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0x1;
        r2 = r2 ^ r3;
        r3 = r2 << 2;
        r3 = r3 + r2;
        r3 = r3 << 6;
        r1 = 0x80;
        r3 = r3 + CPU.r9().value;
        r1 = r1 << 9;
        r7 = r3;
        r0 = (int)MEMORY.call(0x300013c, a4, r1);
        r6 = CPU.r9().value;
        r6 = r6 + 0x10;
        r5 = r0 >> 8;
        r3 = 0x0;
        MEMORY.ref(2, r6).setu(r5);
        MEMORY.ref(2, r6 + 0x2).setu(r3);
        MEMORY.ref(2, r6 + 0x4).setu(r3);
        MEMORY.ref(2, r6 + 0x6).setu(r5);
        CPU.lr().value = r0;
        r0 = 0xffff0000;
        r3 = a4 + r0;
        CPU.r8().value = r3;
        r7 = r7 + 0x20;
        r0 = CPU.r10().value;
        r1 = CPU.r8().value;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r1 = r0;
        r0 = CPU.lr().value;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r3 = r0;
        r1 = CPU.r8().value;
        r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r0 = r0 << 0;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r1 = r0;
        r0 = CPU.lr().value;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r2 = 0x7fff;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = r3 + r2;
        r3 = r3 >> 8;
        r3 = r3 + r1;
        r3 = r3 + CPU.r11().value;
        MEMORY.ref(4, r6 + 0x8).setu(r3);
        r0 = r0 + r2;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = 0xfffff000;
        r0 = r0 >> 8;
        r0 = r0 + r2;
        r5 = r5 << 16;
        r1 = 0x80;
        r0 = r0 + r3;
        r5 = r5 >> 16;
        r1 = r1 << 7;
        MEMORY.ref(4, r6 + 0xc).setu(r0);
        r1 = r1 - r0;
        r2 = 0x300013c;
        r0 = r5;
        r0 = (int)MEMORY.call(r2, r0, r1);
        r0 = r0 >> 16;
        r6 = r0 + 0x1;
        r0 = 0x16b;
        r5 = 0x0;
        r0 = readFlag_(r0);
        if(r0 == 0) {
          r3 = 0x3f8e;

          //LAB_80c0b40
          do {
            r5 = r5 + 0x1;
            MEMORY.ref(2, r7).setu(r3);
            r7 = r7 + 0x2;
          } while((r5 & 0xffff_ffffL) <= (0xf & 0xffff_ffffL));
        }

        //LAB_80c0b4a
        if((r6 & 0xffff_ffffL) > (0x88 & 0xffff_ffffL)) {
          r6 = 0x88;
        }

        //LAB_80c0b50
        if((r5 & 0xffff_ffffL) < (r6 & 0xffff_ffffL)) {
          r3 = MEMORY.ref(4, CPU.sp().value).get();
          r2 = r3 << 16;
          r3 = 0x478a;
          r2 = r2 >>> 16;
          r2 = r2 | r3;

          //LAB_80c0b5e
          do {
            r5 = r5 + 0x1;
            MEMORY.ref(2, r7).setu(r2);
            r7 = r7 + 0x2;
          } while((r5 & 0xffff_ffffL) < (r6 & 0xffff_ffffL));
        }

        //LAB_80c0b94
        if((r5 & 0xffff_ffffL) <= (0x87 & 0xffff_ffffL)) {
          r0 = MEMORY.ref(4, CPU.sp().value).get();
          r3 = 0x478e;
          r2 = r0 << 16;
          r2 = r2 >>> 16;
          r2 = r2 | r3;

          //LAB_80c0ba2
          do {
            r5 = r5 + 0x1;
            MEMORY.ref(2, r7).setu(r2);
            r7 = r7 + 0x2;
          } while((r5 & 0xffff_ffffL) <= (0x87 & 0xffff_ffffL));
        }

        //LAB_80c0bac
        if((r5 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL)) {
          r3 = 0x3f8e;

          //LAB_80c0bb2
          do {
            r5 = r5 + 0x1;
            MEMORY.ref(2, r7).setu(r3);
            r7 = r7 + 0x2;
          } while((r5 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        }

        //LAB_80c0bc8
        r1 = CPU.r9().value;
        r3 = MEMORY.ref(4, r1).get();
        r2 = 0x1;
        r3 = r3 ^ r2;
        MEMORY.ref(4, r1).setu(r3);
      }
    }

    //LAB_80c0bd2
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80c0cec)
  public static void FUN_80c0cec(final int x, final int y, final int z, int r3) {
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    final int r7 = divideS(r3 << 16, 100);
    camera._0c.set(x, y, z);
    final Vec3 r9 = new Vec3();
    r9.zero();
    FUN_8005258(0x1fe0000, div16(0x1fe0000, 0xc000), 0x3fc0000);
    initMatrixStack();
    translateMatrix(camera._0c);
    rotateMatrixY(camera.rotationY_36.get());
    rotateMatrixX(camera.rotationX_34.get());
    transformVector(new Vec3().set(0, 0, 0x1fe0000), camera._00);
    r3 = 0x3001ce0;
    MEMORY.ref(4, r3 + 0xc).setu(120);
    MEMORY.ref(4, r3 + 0x10).setu(120);
    initMatrixStack();
    FUN_80051d8(camera._00, camera._0c);
    final Vec3 r6 = new Vec3();
    FUN_8005268(r9, r6);
    FUN_80c0a24(0x780000, 0x780000, 120 - r6.getX() << 8, 120 - r6.getY() << 8, r7);
    FUN_8005258(r7 * 0x1fe, div16(r7 * 0x1fe, 0xc000), r7 * 0x3fc);
  }

  @Method(0x80c0df4)
  public static void FUN_80c0df4(final int unitId0, final int unitId1, final int r2) {
    final Actor70 actor0 = getCombatantForUnit(unitId0).actor_00.deref();
    final Actor70 actor1 = getCombatantForUnit(unitId1).actor_00.deref();
    FUN_80c0cec((actor1.pos_08.getX() + actor0.pos_08.getX()) / 2, 0, (actor1.pos_08.getZ() + actor0.pos_08.getZ()) / 2, r2);
  }

  @Method(0x80c0f98)
  public static void FUN_80c0f98(final int charId, final int r1) {
    final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(charId);
    if(combatant != null) {
      final Actor70 actor = combatant.actor_00.derefNullable();
      if(actor != null) {
        final int spriteType = actor.spriteType_54.get() & 0xf;
        if(spriteType == 1) {
          //LAB_80c0fbe
          final Sprite38 sprite = actor.sprite_50.deref();
          sprite.packet_00.attribs_04.flags_01.and(~0xc).or((r1 & 0x3) << 2);
          sprite.shadowPacket_0c.attribs_04.flags_01.and(~0xc).or((r1 & 0x3) << 2);
        } else if(spriteType == 2) {
          //LAB_80c0fde
          final int sprites = actor.sprite_50.getPointer();

          //LAB_80c0fec
          for(int spriteIndex = 0; spriteIndex < 4; spriteIndex++) {
            final int sprite = MEMORY.ref(4, sprites + spriteIndex * 0x4).get();
            if(sprite == 0) {
              break;
            }

            MEMORY.ref(1, sprite + 0x5).and(~0xc).or((r1 & 0x3) << 2);
            MEMORY.ref(1, sprite + 0x11).and(~0xc).or((r1 & 0x3) << 2);
          }
        }
      }
    }

    //FUN_80c100c
  }

  @Method(0x80c1054)
  public static void FUN_80c1054() {
    final int[] unitIds = new int[15];
    final int unitCount = getUnitIds(0x3, unitIds);

    //LAB_80c106c
    for(int i = 0; i < unitCount; i++) {
      FUN_80c0f98(unitIds[i], 0);
    }

    //LAB_80c107c
  }

  @Method(0x80c1084)
  public static void FUN_80c1084() {
    final BattleStruct82c r0 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    if(r0 != null) {
      if(r0._650.get() != 0) {
        GPU.BLDCNT.setu(0x3f90);
        GPU.BLDALPHA.setu(0x10);
        final int r3 = r0._64e.get();
        GPU.BLDY.setu(MEMORY.ref(1, 0x80c5c10 + r3).get());
        int r1 = r3 + 1 & 0xf;
        if(r3 > 14) {
          r1 = r1 | 0x10;
        }

        //LAB_80c10c4
        r0._64e.set(r1);
      }
    }
  }

  @Method(0x80c10e8)
  public static void FUN_80c10e8(final int r0, final int r1) {
    final BattleStruct82c r5 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    if(r1 == 0) {
      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c1084"));
      GPU.BLDY.setu(r1);
      FUN_80c1054();
      sleep(1);
      queueVblankNand16(GPU.BLDCNT.getAddress(), 0);
    }

    //LAB_80c1122
    if(r5 != null && r1 != 0) {
      r5._650.set(r1);
      r5._64e.set(0);
      GPU.BLDY.setu(0);
      GPU.BLDALPHA.setu(0x10);

      final int[] unitIds = new int[15];
      final int unitCount = getUnitIds(0x3, unitIds);

      //LAB_80c1162
      for(int r6 = 0; r6 < unitCount; r6++) {
        FUN_80c0f98(unitIds[r6], r1 & 0x1);
      }

      //LAB_80c1178
      if(r0 != 0) {
        //LAB_80c1192
        int r0_0;
        for(int r6 = 0; r6 < 14 && (r0_0 = MEMORY.ref(2, r0 + r6 * 0x2).getUnsigned()) != 0xff; r6++) {
          FUN_80c0f98(r0_0, r1 & 0x1 ^ 0x1);
        }
      }

      //LAB_80c11ac
      sleep(1);
      queueVblankNand16(GPU.BLDCNT.getAddress(), 0);
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c1084"), 0x480);
    }

    //LAB_80c11c4
  }

  @Method(0x80c11ec)
  public static int FUN_80c11ec() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r2 = 0x3001e50;
    CPU.r12().value = r2;
    r3 = CPU.r12().value;
    r3 = r3 + 0xa0;
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x10;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    r3 = CPU.r12().value;
    r3 = r3 + 0x9c;
    r3 = MEMORY.ref(4, r3).get();
    r2 = 0x9e;
    CPU.r10().value = r3;
    r2 = r2 << 5;
    r2 = r2 + CPU.r10().value;
    r3 = 0x0;
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.r12().value;
    r3 = r3 + 0xb8;
    r3 = MEMORY.ref(4, r3).get();
    CPU.r11().value = r3;
    r3 = 0x3000118;
    CPU.r9().value = r3;

    //LAB_80c1230
    for(int sp08 = 0; sp08 < 16; sp08++) {
      final int r7 = CPU.r10().value + 0x11c0 + sp08 * 0x1c;

      jmp_80c1348:
      {
        r0 = MEMORY.ref(4, r7 + 0x18).get();
        if(r0 != 0) {
          r3 = MEMORY.ref(4, r7).get();
          r3 = r3 >> 8;
          r0 = r3;
          r0 = r0 * r3;
          r3 = MEMORY.ref(4, r7 + 0x4).get();
          r3 = r3 >> 8;
          r2 = r3;
          r2 = r2 * r3;
          r3 = r2;
          r0 = r0 + r3;
          r3 = MEMORY.ref(4, r7 + 0x8).get();
          r3 = r3 >> 8;
          r2 = r3;
          r2 = r2 * r3;
          r3 = r2;
          r0 = r0 + r3;
          r0 = sqrt16(r0);
          r3 = 0xfff;
          if(r0 <= r3) {
            r3 = 0x0;
            MEMORY.ref(4, r7 + 0x18).setu(r3);
          } else {
            //LAB_80c1266
            r1 = 0x80;
            r1 = r1 << 9;
            r0 = div16(r0, r1);
            r3 = MEMORY.ref(4, r7 + 0x18).get();
            r3 = r3 - 0x1;
            r2 = 0x2;
            MEMORY.ref(4, r7 + 0x18).setu(r3);
            r6 = 0x3000118;
            CPU.r8().value = r0;
            r5 = r7;
            CPU.lr().value = r2;

            //LAB_80c1280
            do {
              r4 = MEMORY.ref(4, r5).get();
              r0 = -r4;
              r0 = r0 >> 8;
              r1 = CPU.r8().value;
              r0 = (int)MEMORY.call(r6, r0, r1);
              r1 = 0x98;
              r1 = r1 << 9;
              r0 = (int)MEMORY.call(r6, r0, r1);
              r3 = MEMORY.ref(4, r5 + 0xc).get();
              r2 = r3 >> 7;
              r3 = r3 - r2;
              r3 = r3 + r0;
              MEMORY.ref(4, r5 + 0xc).setu(r3);
              r4 = r4 + r3;
              r3 = 0x1;
              r3 = -r3;
              CPU.lr().value = CPU.lr().value + r3;
              r2 = CPU.lr().value;
              MEMORY.ref(4, r5).setu(r4);
              r5 += 0x4;
            } while(r2 >= 0);
          }

          //LAB_80c12ae
          r0 = MEMORY.ref(4, r7 + 0x18).get();
          if(r0 != 0) {
            break jmp_80c1348;
          }
        }

        //LAB_80c12b4
        if(MEMORY.ref(4, CPU.r10().value + 0x13bc).get() < 25) {
          r5 = rand();
          r3 = rand() + 0x10000;
          r6 = r3 >>> 1;
          CPU.r8().value = r3;
          MEMORY.ref(4, r7).setu((int)MEMORY.call(CPU.r9().value, cos(r5), r6));
          MEMORY.ref(4, r7 + 0x4).setu((int)MEMORY.call(CPU.r9().value, sin(r5), r6));

          if((MEMORY.ref(4, r7).get() & 0x1) != 0) {
            MEMORY.ref(4, r7).neg();
          }

          //LAB_80c1302
          if((MEMORY.ref(4, r7 + 0x4).get() & 0x1) != 0) {
            MEMORY.ref(4, r7 + 0x4).neg();
          }

          //LAB_80c1310
          MEMORY.ref(4, r7 + 0x8).setu(rand() + 0x8000 >>> 2);
          r0 = -MEMORY.ref(4, r7).get();
          r3 = MEMORY.ref(4, r7 + 0x4).get();
          MEMORY.ref(4, r7 + 0x10).setu((r0 >> 8) + (-r3 >> 7));
          MEMORY.ref(4, r7 + 0x14).setu(0);
          MEMORY.ref(4, r7 + 0xc).setu((r0 >> 7) + (r3 >> 8));
          r3 = (CPU.r8().value >>> 13) + 1;
          MEMORY.ref(4, r7 + 0x18).setu(r3);
          r0 = r3;
        }

        //LAB_80c1344
        if(r0 == 0) {
          continue;
        }
      }

      //LAB_80c1348
      r3 = MEMORY.ref(4, r7).get();
      r3 = r3 >> 10;
      r5 = r3;
      r3 = MEMORY.ref(4, r7 + 0x4).get();
      r3 = r3 >> 10;
      r4 = r3;
      r6 = r0;
      r5 = r5 + 0x40;
      r4 = r4 + 0x40;
      if(r6 < 0) {
        r6 = 0x0;
      } else {
        //LAB_80c1362
        if(r6 > 6) {
          r6 = 6;
        }
      }

      //LAB_80c1368
      r3 = 0x80c3620;
      r2 = 0x80c3604;
      r0 = MEMORY.ref(1, r3 + r6).getUnsigned();
      r3 = r6 << 2;
      r1 = MEMORY.ref(4, r2 + r3).get();
      r3 = r0 >>> 1;
      r2 = r5 - r3;
      MEMORY.ref(4, CPU.sp().value).setu(r0);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
      r1 = r1 + CPU.r10().value;
      r3 = r4 - r3;
      r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      MEMORY.call(CPU.r11().value, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());

      //LAB_80c1384
    }

    //LAB_80c1392
    r3 = 0x3001e50;
    r3 = r3 + 0xbc;
    r3 = MEMORY.ref(4, r3).get();
    r5 = 0x9c;
    r5 = r5 << 5;
    CPU.r11().value = r3;
    r5 = r5 + CPU.r10().value;
    int r7_0 = 0x2;

    //LAB_80c13a2
    do {
      r1 = MEMORY.ref(4, r5).get();
      r3 = MEMORY.ref(4, r5 + 0x8).get();
      r2 = MEMORY.ref(4, r5 + 0x4).get();
      r1 = r1 + r3;
      r3 = MEMORY.ref(4, r5 + 0xc).get();
      MEMORY.ref(4, r5).setu(r1);
      r4 = r1 >> 10;
      r1 = MEMORY.ref(4, r5 + 0x10).get();
      r2 = r2 + r3;
      MEMORY.ref(4, r5 + 0x4).setu(r2);
      r6 = r2 >> 10;
      r2 = r1;
      if(r1 < 0) {
        r2 = r1 + 0x7;
      }

      //LAB_80c13c0
      r2 = r2 >> 3;
      r3 = 0x3;
      r0 = r3 - r2;
      if(r0 >= 0) {
        r3 = r1 + 0x1;
        MEMORY.ref(4, r5 + 0x10).setu(r3);
        r2 = 0x80c3628;
        r3 = r0 << 2;
        r1 = MEMORY.ref(4, r2 + r3).get();
        r0 = 0x20;
        r2 = r4;
        r3 = r6;
        MEMORY.ref(4, CPU.sp().value).setu(r0);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
        r1 = r1 + CPU.r10().value;
        r2 = r2 + 0x30;
        r3 = r3 + 0x30;
        r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        MEMORY.call(CPU.r11().value, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }

      //LAB_80c13ea
      r7_0 = r7_0 - 0x1;
      r5 = r5 + 0x14;
    } while(r7_0 >= 0);

    r2 = 0x13bc;
    r2 = r2 + CPU.r10().value;
    r3 = MEMORY.ref(4, r2).get();
    r3 = r3 + 0x1;
    MEMORY.ref(4, r2).setu(r3);
    r2 = 0x9e;
    r2 = r2 << 5;
    r2 = r2 + CPU.r10().value;
    r3 = 0x1;
    MEMORY.ref(4, r2).setu(r3);
    CPU.sp().value += 0x10;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7_0 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7_0;
    return r0;
  }

  @Method(0x80c1438)
  public static void FUN_80c1438() {
    final int r0 = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    final int r3 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    if(r0 != 0 && MEMORY.ref(4, r3 + 0x13c0).get() != 0) {
      MEMORY.ref(4, r3 + 0x13c0).setu(0);
      FUN_80054e4(r0, 0x6004000, 0x4000);
    }

    //LAB_80c1464
  }

  @Method(0x80c1470)
  public static void FUN_80c1470(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x24;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    r2 = MEMORY.ref(4, 0x3001f00).get();
    MEMORY.ref(4, r2 + 0x8).setu(1);
    CPU.r11().value = mallocSlotBoard(39, 0x13d0);
    mallocSlotChip(40, 0x4000);
    r7 = CPU.r11().value + 0x11c0;
    CPU.r9().value = 15;

    //LAB_80c14ac
    do {
      r5 = rand();
      r3 = 0x10000 + rand();
      r6 = r3 >>> 1;
      CPU.r8().value = r3;
      MEMORY.ref(4, r7).setu(mul16(cos(r5), r6));
      MEMORY.ref(4, r7 + 0x4).setu(mul16(sin(r5), r6));

      if((MEMORY.ref(4, r7).get() & 0x1) != 0) {
        MEMORY.ref(4, r7).neg();
      }

      //LAB_80c14ee
      if((MEMORY.ref(4, r7 + 0x4).get() & 0x1) != 0) {
        MEMORY.ref(4, r7 + 0x4).neg();
      }

      //LAB_80c14fe
      MEMORY.ref(4, r7 + 0x8).setu(rand() + 0x8000 >>> 2);
      r0 = MEMORY.ref(4, r7).get();
      r3 = MEMORY.ref(4, r7 + 0x4).get();
      r2 = r3 >> 8;
      r0 = -r0;
      r3 = -r3;
      r1 = r0 >> 7;
      r3 = r3 >> 7;
      r0 = r0 >> 8;
      r1 = r1 + r2;
      r3 = r3 + r0;
      MEMORY.ref(4, r7 + 0xc).setu(r1);
      MEMORY.ref(4, r7 + 0x10).setu(r3);
      r1 = CPU.r8().value;
      MEMORY.ref(4, r7 + 0x14).setu(0);
      r3 = r1 >>> 13;
      r3 = r3 + 0x1;
      MEMORY.ref(4, r7 + 0x18).setu(r3);
      r7 = r7 + 0x1c;
      CPU.r9().value--;
    } while(CPU.r9().value >= 0);

    r7 = 0;
    r5 = CPU.r11().value + 0x1380;
    CPU.r9().value = 2;

    //LAB_80c1552
    do {
      MEMORY.ref(4, r5).setu(mul16(cos(r7), 0x1000));
      MEMORY.ref(4, r5 + 0x4).setu(mul16(sin(r7), 0x1000));
      MEMORY.ref(4, r5 + 0x8).setu(mul16(cos(r7), 0x200));
      MEMORY.ref(4, r5 + 0xc).setu(mul16(sin(r7), 0x200));
      MEMORY.ref(4, r5 + 0x10).setu(0);
      r7 = r7 + 0x5555;
      r5 = r5 + 0x14;
      CPU.r9().value--;
    } while(CPU.r9().value >= 0);

    MEMORY.ref(4, CPU.r11().value + 0x13bc).setu(0);
    MEMORY.ref(4, CPU.r11().value + 0x13c0).setu(0);
    MEMORY.ref(4, CPU.r11().value + 0x13cc).setu(0);
    MEMORY.memfill(MEMORY.ref(4, 0x3001ef0).get(), 0x4000, 0);
    r5 = getPointerTableEntry(201);
    MEMORY.memcpy(0x5000000, r5, 0x80);
    decompress(r5 + 0x80, CPU.r11().value);

    r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    if(r1 == 0) {
      //LAB_80c1606
      r0 = 200;
    } else if(r1 == 0x1) {
      //LAB_80c160a
      r0 = 201;
      //LAB_80c15fe
    } else if(r1 == 0x2) {
      //LAB_80c160e
      r0 = 202;
    } else {
      //LAB_80c1612
      r0 = 203;
    }

    //LAB_80c1614
    DMA.channels[3].SAD.setu(getPointerTableEntry(r0));
    DMA.channels[3].DAD.setu(0x5000000);
    DMA.channels[3].CNT.setu(0x84000020);
    GPU.BG2X.setu(0);
    GPU.BG2Y.setu(0);
    GPU.BG2PA.setu(0x100);
    GPU.BG2PB.setu(0);
    GPU.BG2PC.setu(0);
    GPU.BG2PD.setu(0x100);
    FUN_80c9000(46, 7, 7, 3, 3);
    FUN_80c9000(47, 7, 7, 3, 2);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c11ec"), 0xc80);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c1438"), 0xc80);
    CPU.sp().value += 0x24;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80c16d0)
  public static void FUN_80c16d0() {
    MEMORY.memfill(0x6004000, 0x4000, 0);
    freeSlot(47);
    freeSlot(46);
    freeSlot(40);
    freeSlot(39);
    GPU.DISPCNT.setu(0x1341);
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c1438"));
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c11ec"));
  }

  /**
   * Multiplies a colour array by a multiplier
   * @param src Source colour array
   * @param dst Dest colour array
   * @param multiplier .16
   * @param count Number of elements in arrays
   */
  @Method(0x80c1724)
  public static void multiplyColours(final int src, final int dst, int multiplier, final int count) {
    if(multiplier > 0x10000) {
      multiplier = 0x10000;
    }

    //LAB_80c173a
    //LAB_80c1750
    for(int i = 0; i < count; i++) {
      final int r4 = MEMORY.ref(2, src + i * 0x2).getUnsigned();
      MEMORY.ref(2, dst + i * 0x2).setu((r4 & 0x7c00) * multiplier >>> 16 & 0x7c00 | (r4 & 0x3e0) * multiplier >>> 16 & 0x3e0 | (r4 & 0x1f) * multiplier >>> 16 & 0x1f);
    }

    //LAB_80c178a
  }

  @Method(0x80c1798)
  public static void FUN_80c1798(final int r0, final int r1, final int r2, final int r3) {
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    final BattleStruct82c sp04 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    CPU.sp().value -= 0xf0;
    sleep(1);
    FUN_80c0774(1, sp04.backgroundPointerTableId_648.get(), 0);
    MEMORY.memfill(0x6004000, 0x4000, 0);
    queueVblankNand16(GPU.DISPCNT.getAddress(), 0x3741);
    queueVblankNand16(GPU.BG2CNT.getAddress(), 0x784);
    queueVblankNand16(GPU.BLDCNT.getAddress(), 0x3f44);
    sleep(1);
    GPU.WIN0H.setu(0xf0);
    GPU.WIN0V.setu(0x1088);
    GPU.WININ.setu(0x3f);
    GPU.WINOUT.setu(0x11);

    if(r2 == 0) {
      queueVblankNand16(GPU.BLDALPHA.getAddress(), 0x100e);
      FUN_80c1470(r1);
      CPU.r8().value = 0;
      final Vec3 r6 = new Vec3();
      CPU.r9().value = 0;

      //LAB_80c183a
      do {
        final int r5 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
        if(CPU.r8().value <= 0x18) {
          sp04._644.set(0x10000 - CPU.r9().value);
          multiplyColours(sp04._544.getAddress(), 0x50000c0, sp04._644.get(), 0x80);
        }

        //LAB_80c1860
        FUN_80b845c(r0, r6);
        MEMORY.ref(4, r5 + 0x13c4).setu(0x40 - r6.getX() << 8);
        MEMORY.ref(4, r5 + 0x13c8).setu(0x40 - r6.getY() << 8);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(vblankTransferQueue_2002090.count_00.get() < 32) {
          final VblankTransfer0c queue = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
          queue.src_00.set(r5 + 0x13c4);
          queue.dst_04.set(GPU.BG2X.getAddress());
          queue.cnt_08.set(0x84000002);
          vblankTransferQueue_2002090.count_00.incr();
        }

        //LAB_80c18a8
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        MEMORY.ref(4, r5 + 0x13cc).setu(1);
        sleep(1);
        CPU.r8().value++;
        CPU.r9().value += 0x44;
      } while(CPU.r8().value <= 0x2c);

      FUN_80c16d0();
      //LAB_80c18ce
    } else if(r2 == 0x1) {
      FUN_80c9038(r1);
      final Vec3 r7 = new Vec3();
      CPU.r8().value = 0x27;

      //LAB_80c18e8
      do {
        final int r5 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
        FUN_80b845c(r0, r7);
        MEMORY.ref(4, r5 + 0x13c4).setu(0x40 - r7.getX() << 8);
        MEMORY.ref(4, r5 + 0x13c8).setu(0x40 - r7.getY() << 8);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(vblankTransferQueue_2002090.count_00.get() < 32) {
          final VblankTransfer0c queue = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
          queue.src_00.set(r5 + 0x13c4);
          queue.dst_04.set(GPU.BG2X.getAddress());
          queue.cnt_08.set(0x84000002);
          vblankTransferQueue_2002090.count_00.incr();
        }

        //LAB_80c1936
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        MEMORY.ref(4, r5 + 0x13cc).setu(1);
        sleep(1);
        CPU.r8().value--;
      } while(CPU.r8().value >= 0);

      FUN_80c9040();

      //LAB_80c1958
    } else if(r2 == 0x2) {
      final int struct = CPU.sp().value + 0x5c;
      MEMORY.ref(4, struct).setu(r1);
      MEMORY.ref(4, struct + 0x8).setu(r0);
      MEMORY.ref(4, struct + 0xc).setu(r0);
      MEMORY.ref(4, struct + 0x10).setu(1);
      MEMORY.ref(4, struct + 0x14).setu(1);
      MEMORY.ref(4, struct + 0x18).setu(r3);
      MEMORY.ref(4, struct + 0x1c).setu(0);
      MEMORY.ref(2, struct + 0x24).setu(r0);
      FUN_80c9020(struct);
    } else {
      //LAB_80c197e
      final int struct = CPU.sp().value + 0x8;
      MEMORY.ref(4, struct).setu(r1);
      MEMORY.ref(4, struct + 0x8).setu(r0);
      MEMORY.ref(4, struct + 0xc).setu(r0);
      MEMORY.ref(4, struct + 0x10).setu(1);
      MEMORY.ref(4, struct + 0x14).setu(1);
      MEMORY.ref(4, struct + 0x18).setu(0);
      MEMORY.ref(4, struct + 0x1c).setu(0);
      MEMORY.ref(2, struct + 0x24).setu(r0);
      FUN_80c9030(struct);
    }

    //LAB_80c199e
    CPU.sp().value += 0xf0;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
  }

  @Method(0x80c1a14)
  public static void FUN_80c1a14() {
    FUN_80c0700(0, 0);
  }

  @Method(0x80c1a34)
  public static int FUN_80c1a34(final int r0) {
    final int r10 = 0x80c5c38 + r0 * 0x10;
    int r9 = 0;
    int r11 = 0;

    //LAB_80c1a5e
    int r7;
    for(r7 = 0; r7 < 5 && MEMORY.ref(1, r10 + 0x6 + r7).getUnsigned() == 0; r7++) {
      //
    }

    //LAB_80c1a6c
    if(r7 == 5) {
      return -1;
    }

    //LAB_80c1a76
    //LAB_80c1a7e
    for(int i = 0; i < 5; i++) {
      if(MEMORY.ref(1, r10 + 0xb + i).getUnsigned() != 0) {
        final int r6 = MEMORY.ref(1, r10 + 0x1 + i).getUnsigned();
        final EnemyStats54 enemy = getEnemyStats_(r6 + 0x8);
        if(enemy != null) {
          if(enemy.level_0f.get() > 3 && readFlag_(0x174) == 0 && readFlag_(0x608 + r6) == 0) {
            //LAB_80c1ad8
            return -2;
          }

          //LAB_80c1abe
          r11 += enemy.level_0f.get();
          r9++;
        }
      }

      //LAB_80c1ac6
    }

    if(r9 == 0) {
      return -3;
    }

    //LAB_80c1ade
    //LAB_80c1ae6
    return divideS(r11, r9);
  }

  @Method(0x80c1afc)
  public static int FUN_80c1afc(final int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r6;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x10;
    CPU.r9().value = 0;
    CPU.r10().value = mallocBoard(0x80);
    CPU.r8().value = 0;

    final int[] charIds = new int[5];
    final int charCount = getBattleChars(charIds);

    //LAB_80c1b30
    for(int i = 0; i < charCount; i++) {
      CPU.r8().value += getUnit_(charIds[i]).level_0f.get();
    }

    //LAB_80c1b42
    CPU.r8().value = MathHelper.clamp(divideS(CPU.r8().value, charCount) + readFlagsByte_(0x3f8), 1, 99);

    //LAB_80c1b74
    for(int i = 0; i < 32; i++) {
      MEMORY.ref(2, CPU.r10().value + i * 0x4 + 0x2).or(0xffff);
    }

    final int r7 = 0x80c73f8;

    //LAB_80c1b94
    for(int i = 0; i < 20; i++) {
      getEnemyStats_(MEMORY.ref(2, r7 + i * 0x2).getUnsigned());
      clearFlag_(MEMORY.ref(2, r7 + i * 0x2).getUnsigned() + 0x600);
    }

    //LAB_80c1bb0
    for(int i = 0; i < 380; i++) {
      final int r0_0 = FUN_80c1a34(i);
      if(r0_0 >= 0 && r0_0 <= CPU.r8().value + 3) {
        r3 = 999;
        r6 = -1;
        r4 = 0x0;
        r1 = CPU.r10().value;

        //LAB_80c1bcc
        do {
          r2 = MEMORY.ref(2, r1 + 0x2).get();
          if(r2 < r3) {
            r3 = r2;
            r6 = r4;
          }

          //LAB_80c1bd8
          r4 = r4 + 0x1;
          r1 = r1 + 0x4;
        } while(r4 < 32);

        if(r6 >= 0) {
          r3 = CPU.r10().value + r6 * 0x4;
          MEMORY.ref(2, r3).setu(i);
          MEMORY.ref(2, r3 + 0x2).setu(r0_0);
          CPU.r9().value++;
        }
      }

      //LAB_80c1bf0
    }

    if(CPU.r9().value > 32) {
      CPU.r9().value = 32;
    }

    //LAB_80c1c02
    final int r5;
    if(CPU.r9().value != 0) {
      r3 = CPU.r9().value * rand() >>> 16;
      r3 = CPU.r10().value + r3 * 0x4;
      r5 = MEMORY.ref(2, r3).get();
      r3 = MEMORY.ref(2, r3 + 0x2).get();
      r3 = CPU.r8().value - r3;
      MEMORY.ref(4, r0).setu(r3);
    } else {
      //LAB_80c1c28
      MEMORY.ref(4, r0).setu(CPU.r9().value);
      r5 = 0x1;
    }

    //LAB_80c1c30
    setMallocAddress(CPU.r10().value);
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    return r5;
  }

  @Method(0x80c1c54)
  public static int FUN_80c1c54(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0xc;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
    CPU.r10().value = r1;
    CPU.r9().value = mallocBoard(0x24);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    final Unit14c r7 = getUnit_(r0);
    MEMORY.call(0x3001388, CPU.r9().value, r7.baseMaxHp_10.getAddress(), 0x24); // memcpy
    r1 = CPU.r10().value;
    r3 = r1 << 1;
    r3 = r3 + CPU.r10().value;
    r5 = r7.baseMaxHp_10.get();
    r0 = r3 << 5;
    r1 = 0xa;
    r0 = r0 + CPU.r10().value;
    CPU.r11().value = r3;
    r0 = divideS(r0, r1);
    r5 = r5 + r0;
    r0 = CPU.r9().value;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r0 + r2).get();
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1cb6
    r1 = 0x270f;
    CPU.r8().value = r1;
    if(r5 > CPU.r8().value) {
      r5 = CPU.r8().value;
    }

    //LAB_80c1cc0
    r3 = CPU.r10().value;
    r3 = r3 << 4;
    r7.baseMaxHp_10.set(r5);
    r1 = CPU.r10().value;
    r0 = r3 - r1;
    r1 = 0xa;
    r5 = r7.baseMaxPp_12.get();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = divideS(r0, r1);
    r5 = r5 + r0;
    r0 = CPU.r9().value;
    r2 = 0x2;
    r3 = MEMORY.ref(2, r0 + r2).get();
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1cee
    if(r5 > CPU.r8().value) {
      r5 = CPU.r8().value;
    }

    //LAB_80c1cf4
    r1 = CPU.r10().value;
    r1 = r1 << 5;
    r2 = CPU.r10().value;
    r0 = r1 - r2;
    r0 = r0 << 2;
    r7.baseMaxPp_12.set(r5);
    CPU.r8().value = r1;
    r0 = r0 - r2;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    r5 = r7.baseAttack_18.get();
    r5 = r5 + r0;
    r0 = CPU.r9().value;
    r3 = MEMORY.ref(2, r0 + 0x8).getUnsigned();
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1d22
    r6 = 0x3e7;
    if(r5 > r6) {
      r5 = r6;
    }

    //LAB_80c1d2a
    r0 = CPU.r8().value;
    r7.baseAttack_18.set(r5);
    r1 = 0xa;
    r0 = r0 + CPU.r10().value;
    r0 = divideS(r0, r1);
    r1 = CPU.r9().value;
    r3 = MEMORY.ref(2, r1 + 0xa).getUnsigned();
    r5 = r7.baseDefence_1a.get();
    r5 = r5 + r0;
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1d4e
    if(r5 > r6) {
      r5 = r6;
    }

    //LAB_80c1d54
    r2 = CPU.r11().value;
    r0 = r2 << 4;
    r7.baseDefence_1a.set(r5);
    r1 = 0xa;
    r0 = r0 + CPU.r11().value;
    r0 = divideS(r0, r1);
    r5 = r7.baseAgility_1c.get();
    r5 = r5 + r0;
    r0 = CPU.r9().value;
    r3 = MEMORY.ref(2, r0 + 0xc).getUnsigned();
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1d7a
    if(r5 > r6) {
      r5 = r6;
    }

    //LAB_80c1d80
    r1 = 0x14;
    r7.baseAgility_1c.set(r5);
    CPU.r8().value = r1;

    //LAB_80c1d8a
    for(r4 = 0; r4 < 4; r4++) {
      r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r2 = r7.powerResist_24.get(r4).power_00.get();
      r1 = CPU.r10().value;
      r3 = r0 - r1;
      r5 = r2 + r3;
      r1 = CPU.r9().value;
      r2 = CPU.r8().value;
      r3 = MEMORY.ref(2, r2 + r1).get();
      r0 = r3 << 3;
      r0 = r0 - r3;
      r0 = divideS(r0, 10);
      if(r5 < r0) {
        r5 = r0;
      }

      //LAB_80c1dae
      if(r5 > 200) {
        r5 = 200;
      }

      //LAB_80c1db4
      r7.powerResist_24.get(r4).power_00.set(r5);
      CPU.r8().value += 0x4;
    }

    r7.level_0f.add(CPU.r10().value);
    recalcStats_(MEMORY.ref(4, CPU.sp().value + 0x8).get());
    r0 = CPU.r9().value;
    setMallocAddress(r0);
    CPU.sp().value += 0xc;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80c1df4)
  public static int FUN_80c1df4(int r0) {
    final BattleStruct82c r5 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int r4 = r5._40.get();

    //LAB_80c1e12
    int r1;
    for(r1 = 0; r1 < r4 && r5._10.get(r1).get() != r0; r1++) {
      //
    }

    //LAB_80c1e20
    if(r1 != r4) {
      if(r5._34.get(r1).get() < 0) {
        r5._34.get(r1).set(1);
        r5._1c.get(r1).set(3);
        r0 = 0x8001;
      } else {
        //LAB_80c1e40
        //LAB_80c1e46
        for(int i = 0; i < 32; i++) {
          r0 = modS(r5._34.get(r1).get() + 1, 9);
          r5._34.get(r1).set(r0);

          if((r5._1c.get(r1).get() & 0x1 << r0) == 0) {
            break;
          }

          //LAB_80c1e44
        }

        //LAB_80c1e6e
        r5._1c.get(r1).or(0x1 << r5._34.get(r1).get());
        r0 = r5._34.get(r1).get();
      }
      //LAB_80c1e82
    } else if(r4 < 5) {
      r5._34.get(r4).set(-1);
      r5._10.get(r4).set(r0);
      r5._1c.get(r4).set(0);
      r5._40.incr();
      r0 = 9;
    } else {
      //LAB_80c1ea8
      r0 = -1;
    }

    //LAB_80c1eac
    return r0;
  }

  @Method(0x80c1ebc)
  public static void FUN_80c1ebc(final int unitId) {
    final BattleStruct82c r6 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int r5 = r6._40.get();
    final Unit14c r12 = getUnit_(unitId);
    if(r12.class_129.get() == 0) {
      //LAB_80c1ef0
      int r1;
      for(r1 = 0; r1 < r5 && r6._10.get(r1).get() != r12.id_128.get(); r1++) {
        //
      }

      //LAB_80c1efe
      if(r1 != r5) {
        if(r6._1c.get(r1).get() != 0) {
          //LAB_80c1f18
          int r4;
          for(r4 = 0; r4 < 14 && r12.name_00.get(r4).get() != 0; r4++) {
            //
          }

          //LAB_80c1f26
          final int r0;
          if(r4 > 0) {
            r0 = r12.name_00.get(r4 - 1).get() - '1';
          } else {
            r0 = 32;
          }

          //LAB_80c1f36
          r6._1c.get(r1).and(~(0x1 << r0));
        }
      }
    }

    //LAB_80c1f42
  }

  @Method(0x80c1f50)
  public static void FUN_80c1f50(final int r0) {
    //LAB_80c1f58
    for(int r5 = 0; r5 < 6; r5++) {
      final Unit14c r2 = getUnit_(r5 + 0x80);
      if(r2._12a.get() == 1) {
        if(r2.id_128.get() == r0) {
          //LAB_80c1f86
          int i = 0;
          do {
            if(r2.name_00.get(i).get() == 0) {
              r2.name_00.get(i).set('1');
              r2.name_00.get(i + 1).set(0);
              return;
            }
            i++;
            if(i > 13) {
              return;
            }
          } while(true);
        }
      }

      //LAB_80c1f9a
    }

    //LAB_80c1fa0
  }

  @Method(0x80c1fa8)
  public static int FUN_80c1fa8(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    r3 = 0xbe;
    r3 = r3 << 1;
    CPU.sp().value -= 0x14;
    r5 = 0x0;
    if((r0 & 0xffff_ffffL) >= (r3 & 0xffff_ffffL)) {
      r0 = 0x1;
    }

    //LAB_80c1fb8
    r2 = 0x80c5c38;
    r3 = r0 << 4;
    r3 = r3 + r2;
    r6 = CPU.sp().value;
    r0 = r3;
    r2 = r3 + 0x1;
    r0 = r0 + 0xb;
    r4 = r6;
    r1 = 0x4;

    //LAB_80c1fca
    do {
      r3 = MEMORY.ref(1, r0).getUnsigned();
      r0 = r0 + 0x1;
      if(r3 != 0) {
        r3 = MEMORY.ref(1, r2).getUnsigned();
        r3 = r3 + 0x8;
        MEMORY.ref(4, r4).setu(r3);
        r4 += 0x4;
        r5 = r5 + 0x1;
      }

      //LAB_80c1fda
      r1 = r1 - 0x1;
      r2 = r2 + 0x1;
    } while(r1 >= 0);

    r0 = rand();
    r3 = r5;
    r3 = r3 * r0;
    r3 = r3 >>> 16;
    r3 = r3 << 2;
    r0 = MEMORY.ref(4, r6 + r3).get();
    CPU.sp().value += 0x14;
    return r0;
  }

  @Method(0x80c1ffc)
  public static int FUN_80c1ffc(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    int r7;
    int r8;
    int r9;
    int r10;
    int r11;

    CPU.sp().value -= 0x7c;
    final BattleStruct82c sp18 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    r5 = r0;
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(0);
    sp18._40.set(0);
    final int sp1c = CPU.sp().value + 0x60;

    if(readFlag_(0x173) != 0) {
      r5 = FUN_80c1afc(CPU.sp().value + 0x20);
    }

    //LAB_80c2034
    if((r5 & 0xffff_ffffL) >= 380) {
      r5 = 0x1;
    }

    //LAB_80c203e
    int sp14 = 0x80c5c38 + r5 * 0x10;
    r3 = MEMORY.ref(1, sp14 + 0x6).getUnsigned();
    r1 = 0x0;
    if(r3 == 0) {
      r2 = sp14 + 0x6;

      //LAB_80c2056
      do {
        r1 = r1 + 0x1;
        r2 = r2 + 0x1;
        if(r1 > 0x4) {
          break;
        }
      } while(MEMORY.ref(1, r2).getUnsigned() == 0);
    }

    //LAB_80c2064
    if(r1 == 5) {
      sp14 = 0x80c5c48;
    }

    //LAB_80c2070
    final int sp08 = sp14 + 0x1;
    int sp10 = 0;
    r11 = 6;
    r5 = sp14 + 0x6;

    //LAB_80c2082
    for(r7 = 0; r7 < 5; r7++) {
      if(MEMORY.ref(1, r5).getUnsigned() != 0) {
        r0 = FUN_80c23c0(MEMORY.ref(1, sp08 + r7).getUnsigned() + 8);
        r3 = (-r0 | r0) >>> 31;
        r3 = 2 - r3;
        r11 -= r3 * MEMORY.ref(1, r5).getUnsigned();
      }

      //LAB_80c20aa
      r5 = r5 + 0x1;
    }

    final int sp0c = CPU.sp().value + 0x38;
    r6 = CPU.sp().value + 0x4c;
    r9 = sp14 + 0xb;
    r10 = sp14 + 0x6;
    r8 = 0;

    //LAB_80c20ca
    for(r7 = 0; r7 < 5; r7++) {
      r2 = MEMORY.ref(1, r10).getUnsigned();
      r3 = MEMORY.ref(1, r9).getUnsigned();
      MEMORY.ref(4, r8 + sp0c).setu(r2);
      r5 = r3 - r2;
      if(r5 > 0) {
        r0 = FUN_80c23c0(MEMORY.ref(1, sp08 + r7).getUnsigned() + 8);
        r1 = (-r0 | r0) >>> 31;
        r1 = 2 - r1;
        r0 = divideS(r11, r1);
        if(r5 > r0) {
          r5 = r0;
        }

        //LAB_80c2106
        MEMORY.ref(4, r8 + r6).setu((r5 + 1) * rand() >>> 16);
      } else {
        //LAB_80c2116
        MEMORY.ref(4, r8 + r6).setu(0);
      }

      //LAB_80c211c
      r10++;
      r9++;
      r8 += 0x4;
    }

    //LAB_80c212a
    do {
      r8 = 0;

      //LAB_80c2132
      for(r7 = 0; r7 < 5; r7++) {
        if(MEMORY.ref(4, r6 + r7 * 0x4).get() != 0) {
          r0 = FUN_80c23c0(MEMORY.ref(1, sp08 + r7).getUnsigned() + 8);
          r2 = (-r0 | r0) >>> 31;
          r2 = 2 - r2;
          if(r2 > r11) {
            MEMORY.ref(4, r6 + r7 * 0x4).setu(0);
          } else {
            //LAB_80c2162
            MEMORY.ref(4, sp0c + r7 * 0x4).incr();
            MEMORY.ref(4, r6 + r7 * 0x4).decr();
            r11 -= r2;
            r8 = 1;
          }
        }

        //LAB_80c2178
      }
    } while(r8 != 0);

    sp18._42.set(MEMORY.ref(1, sp14).getUnsigned());
    r3 = sp18._42.get();
    if(r3 == 0) {
      //LAB_80c219e
      r8 = CPU.sp().value + 0x24;

      //LAB_80c21a6
      for(r7 = 0; r7 < 5; r7++) {
        MEMORY.ref(4, r8 + r7 * 0x4).setu(r7);
      }

      //LAB_80c21b2
      for(r7 = 0; r7 < 10; r7++) {
        r5 = rand() * 5 >>> 16;
        r3 = rand() * 5 >>> 16;
        r5 = r5 << 2;
        r3 = r3 << 2;
        r1 = MEMORY.ref(4, r8 + r5).get();
        r2 = MEMORY.ref(4, r8 + r3).get();
        MEMORY.ref(4, r8 + r5).setu(r2);
        MEMORY.ref(4, r8 + r3).setu(r1);
      }

      //LAB_80c21e6
      for(r7 = 0; r7 < 5; r7++) {
        r2 = MEMORY.ref(4, r8 + r7 * 0x4).get();
        if(MEMORY.ref(4, sp0c + r2 * 0x4).get() > 0) {
          r3 = MEMORY.ref(1, sp08 + r2).getUnsigned() + 8;
          r1 = MEMORY.ref(4, sp0c + r2 * 0x4).get();

          //LAB_80c21fe
          for(int i = 0; i < r1; i++) {
            MEMORY.ref(2, sp1c + sp10 * 0x2).setu(r3);
            sp10++;
          }
        }

        //LAB_80c2210
      }
    } else if(r3 == 0x1) {
      //LAB_80c221a
      r8 = CPU.sp().value + 0x24;

      //LAB_80c222a
      do {
        r5 = 0;

        //LAB_80c2232
        for(r7 = 0; r7 < 5; r7++) {
          if(MEMORY.ref(4, sp0c + r7 * 0x4).get() != 0) {
            MEMORY.ref(4, CPU.sp().value + 0x24 + r5 * 0x4).setu(r7);
            r5++;
          }

          //LAB_80c223c
        }

        if(r5 == 0) {
          break;
        }

        r3 = r5 * rand() >>> 16;
        r2 = MEMORY.ref(4, r8 + r3 * 0x4).get();
        MEMORY.ref(2, sp1c + sp10 * 0x2).setu(MEMORY.ref(1, sp08 + r2).getUnsigned() + 8);
        MEMORY.ref(4, sp0c + r2 * 0x4).decr();
        sp10++;
      } while(true);
    } else {
      //LAB_80c22b0
      for(r7 = 0; r7 < 5; r7++) {
        //LAB_80c2284
        r2 = MEMORY.ref(4, sp0c + r7 * 0x4).get();
        r1 = MEMORY.ref(1, sp08 + r7).getUnsigned() + 0x8;

        //LAB_80c229e
        while(r2 > 0) {
          MEMORY.ref(2, sp1c + sp10 * 0x2).setu(r1);
          r2 = r2 - 0x1;
          sp10++;
        }

        //LAB_80c22ae
      }
    }

    //LAB_80c22b4
    MEMORY.ref(2, sp1c + sp10 * 0x2).setu(0);
    sp18._3c.set(6);
    sp18._3e.set(0);

    //LAB_80c22d8
    for(r7 = 128; r7 < 134; r7++) {
      MEMORY.call(0x3000164, getUnit_(r7).getAddress(), 0x14c); // memzero
    }

    //LAB_80c22f8
    for(r7 = 0; r7 < 6 && MEMORY.ref(2, sp1c + r7 * 0x2).getUnsigned() != 0; r7++) {
      r4 = FUN_80c1df4(MEMORY.ref(2, sp1c + r7 * 0x2).getUnsigned());
      if((r4 & 0x8000) != 0) {
        FUN_80c1f50(MEMORY.ref(2, sp1c + r7 * 0x2).getUnsigned());
      }

      //LAB_80c231a
      loadEnemyUnit_(r7 + 0x80, MEMORY.ref(2, sp1c + r7 * 0x2).getUnsigned(), r4 & 0x7fff);

      r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      if(r1 != 0) {
        FUN_80c1c54(r7 + 0x80, r1);
      }

      //LAB_80c233c
    }

    //LAB_80c234e
    CPU.sp().value += 0x7c;
    return r7;
  }

  @Method(0x80c2368)
  public static int FUN_80c2368(int r0) {
    int r3;

    r3 = 0x80c7420;
    r0 = r0 << 3;
    r0 = r0 + r3;
    r3 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
    r0 = r3 >>> 5;
    if(r0 > 0x4) {
      r0 = 0x1;
      r0 = -r0;
    }

    //LAB_80c237c
    return r0;
  }

  @Method(0x80c2384)
  public static int getActorPropertiesSprite(final int index) {
    if((index & 0xffff_ffffL) >= 170) {
      return actorProperties_80c7420.get(0).spriteDataIndex_00.get();
    }

    //LAB_80c2390
    return actorProperties_80c7420.get(index).spriteDataIndex_00.get();
  }

  @Method(0x80c23a0)
  public static int FUN_80c23a0(final int index) {
    if((index & 0xffff_ffffL) >= 170) {
      return actorProperties_80c7420.get(0).spriteDataIndex_00.get();
    }

    //LAB_80c23ac
    return actorProperties_80c7420.get(index)._03.get() << 27 >>> 28;
  }

  @Method(0x80c23c0)
  public static int FUN_80c23c0(final int index) {
    if((index & 0xffff_ffffL) >= 170) {
      return 0;
    }

    //LAB_80c23ca
    return (actorProperties_80c7420.get(index)._02.get() << 31) != 0 ? 1 : 0;
  }

  @Method(0x80c23e8)
  public static int FUN_80c23e8(int r0) {
    int r2;
    int r3;

    if((r0 & 0xffff_ffffL) > (0xab & 0xffff_ffffL)) {
      r0 = 0x1;
    } else {
      //LAB_80c23f2
      r3 = 0x80c7420;
      r2 = r0 << 3;
      r2 = r2 + r3;
      r3 = MEMORY.ref(1, r2 + 0x2).getUnsigned();
      r3 = r3 << 27;
      r3 = r3 >>> 28;
      r0 = r3;
      if(r3 == 0) {
        r0 = 0x1;
      }
    }

    //LAB_80c2406
    return r0;
  }

  @Method(0x80c2410)
  public static int FUN_80c2410(final int actorId) {
    if((actorId & 0xffff_ffffL) >= 170) {
      return 0;
    }

    //LAB_80c241a
    //LAB_80c242c
    return actorProperties_80c7420.get(actorId)._02.get() >>> 5;
  }

  @Method(0x80c2434)
  public static int FUN_80c2434(final int r0) {
    if((r0 & 0xffff_ffffL) >= 172) {
      return 0;
    }

    //LAB_80c243e
    //LAB_80c244a
    return MEMORY.ref(1, 0x80c7420 + r0 * 0x8 + 0x3).getUnsigned() << 31 >>> 31;
  }

  @Method(0x80c2454)
  public static int FUN_80c2454(final int r0) {
    if(r0 < 0 || r0 > 171) {
      return 0;
    }

    //LAB_80c245e
    //LAB_80c2466
    return MEMORY.ref(1, 0x80c7420 + 0x4 + r0 * 0x8).getUnsigned();
  }

  @Method(0x80c2470)
  public static int FUN_80c2470(final int r0) {
    final int r2;
    int r5;
    final int r6;

    r6 = r0 & 0x1ff;
    r5 = 0x0;
    if(r6 == 0) {
      return 0;
    }

    r2 = getItem_(r6).flags_03.get();
    if((r2 & 0x8) != 0) {
      r5 = 0x1;
    }

    //LAB_80c2492
    r5 = r5 << 1;
    if((r2 & 0x4) != 0) {
      r5 = r5 + 0x1;
    }

    //LAB_80c249e
    r5 = r5 << 9;
    r5 = r5 + r6;

    //LAB_80c24a4
    return r5;
  }

  @Method(0x80c24b0)
  public static void FUN_80c24b0() {
    final BattleStruct82c r0 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    _200047c.set(0);
    r0._530.set(0);
    r0._534.set(0);
    r0._538.set(0);

    //LAB_80c24d4
    for(int i = 0; i < 4; i++) {
      r0._53c.get(i).set(0);
    }
  }

  /** Battle rewards? */
  @Method(0x80c24f0)
  public static int FUN_80c24f0(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.r11().value = r1;
    r5 = r0;
    final Unit14c r8 = getUnit_(r5);
    r0 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();
    r7 = r0 + 0x530;
    if((r5 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
      r0 = 0x1;
      r0 = -r0;
    } else {
      //LAB_80c251c
      r3 = r8.class_129.get();
      if(r3 != 0) {
        r0 = 0x2;
        r0 = -r0;
      } else {
        //LAB_80c252c
        r2 = MEMORY.ref(2, r0 + 0x10).getUnsigned();
        r3 = r8.id_128.get();
        r6 = 0x0;
        r5 = 0x0;
        if(r2 != r3) {
          r1 = r0 + 0x10;

          //LAB_80c2544
          do {
            r5 = r5 + 0x1;
            if(r5 > 0x5) {
              break;
            }
            r1 = r1 + 0x2;
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r3 = r8.id_128.get();
          } while(r2 != r3);
        }

        //LAB_80c2554
        if(r5 != 0x6) {
          r6 = r5;
        }

        //LAB_80c255a
        r3 = MEMORY.ref(2, r0 + 0x3e).getUnsigned();
        if(r3 == 0x2) {
          r3 = MEMORY.ref(4, r7 + 0x8).get();
        } else {
          r3 = MEMORY.ref(2, r0 + 0x3c).getUnsigned();
          if(r6 < r3) {
            MEMORY.ref(2, r0 + 0x3c).setu(r6);
          }

          //LAB_80c2568
          r3 = MEMORY.ref(4, r7 + 0x8).get();
          if(r3 != 0) {
            MEMORY.ref(2, r0 + 0x3e).setu(1);
          }
        }

        //LAB_80c2574
        r3 = r3 + 0x1;
        MEMORY.ref(4, r7 + 0x8).setu(r3);
        if(readFlag_(0x173) == 0) {
          //LAB_80c2584
          setFlag_(r8.id_128.get() + 0x600);
          final EnemyStats54 enemy = getEnemyStats_(r8.id_128.get());
          if(CPU.r11().value == 0) {
            //LAB_80c2646
            r2 = enemy.coins_4c.get();
            r3 = MEMORY.ref(4, r7).get();
            r3 = r3 + r2;
            MEMORY.ref(4, r7).setu(r3);
            r2 = enemy.exp_52.get();
            r3 = MEMORY.ref(4, r7 + 0x4).get();
            r3 = r3 + r2;
            MEMORY.ref(4, r7 + 0x4).setu(r3);
          } else {
            r3 = enemy.coins_4c.get();
            if(r3 != 0) {
              r6 = 0x0;
              r5 = 0x0;

              //LAB_80c25c8
              do {
                r0 = divideU(r8.level_0f.get(), 10);
                r0 = r0 << 24;
                r0 = r0 >>> 24;
                r0 = r0 + 0x1;
                if(r5 >= r0) {
                  break;
                }

                //LAB_80c25b6
                r0 = rand();
                r3 = r0 << 1;
                r3 = r3 + r0;
                r3 = r3 << 1;
                r3 = r3 >>> 16;
                r3 = r6 + r3;
                r6 = r3 + 0x1;
                r5 = r5 + 0x1;
              } while(true);

              r5 = enemy.coins_4c.get();
              r0 = divideS(r5 * 3, 10);
              if(r6 < r0) {
                r6 = r0;
              }

              //LAB_80c25f0
              r3 = MEMORY.ref(4, r7).get();
              r2 = r6 + r5;
              r3 = r3 + r2;
              MEMORY.ref(4, r7).setu(r3);
            }

            //LAB_80c25f8
            r3 = enemy.exp_52.get();
            if(r3 != 0) {
              r6 = 0x0;
              r5 = 0x0;

              //LAB_80c2618
              do {
                r0 = divideU(r8.level_0f.get(), 10);
                r0 = r0 << 24;
                r0 = r0 >>> 24;
                r0 = r0 + 0x1;
                if(r5 >= r0) {
                  break;
                }

                //LAB_80c260a
                r0 = rand();
                r0 = r0 << 2;
                r0 = r0 >>> 16;
                r0 = r6 + r0;
                r6 = r0 + 0x1;
                r5 = r5 + 0x1;
              } while(true);

              r5 = enemy.exp_52.get();
              r0 = divideS(r5 * 3, 10);
              if(r6 < r0) {
                r6 = r0;
              }

              //LAB_80c2640
              r2 = r6 + r5;
              MEMORY.ref(4, r7 + 0x4).addu(r2);
            }
          }

          //LAB_80c265e
          r2 = enemy.item_4e.get();
          if(r2 != 0) {
            if(enemy.itemChance_50.get() != 0) {
              r5 = 0x0;
              if(MEMORY.ref(2, r7 + 0xc).getUnsigned() != r2) {
                r1 = r7 + 0xc;

                //LAB_80c2686
                do {
                  r5 = r5 + 0x1;
                  if(r5 > 0x3) {
                    break;
                  }
                  r1 = r1 + 0x2;
                  r2 = MEMORY.ref(2, r1).getUnsigned();
                } while(r2 != enemy.item_4e.get());
              }

              //LAB_80c2698
              if(r5 == 0x4) {
                r0 = enemy.itemChance_50.get();
                if(CPU.r11().value != 0) {
                  r0 = r0 - 0x2;
                }

                //LAB_80c26a8
                if(r0 < 0) {
                  r0 = 0x0;
                }

                //LAB_80c26ae
                r5 = 0x20000 >> r0;
                if(r5 > (lcgRand_() & 0xffff)) {
                  int r8_0 = 0x40000000;
                  r6 = r7;
                  int r10 = -1;
                  r5 = 0x0;
                  r6 = r6 + 0xc;

                  //LAB_80c26d2
                  do {
                    r0 = MEMORY.ref(2, r6).getUnsigned();
                    r6 = r6 + 0x2;
                    r0 = FUN_80c2470(r0);
                    if(r0 < r8_0) {
                      r8_0 = r0;
                      r10 = r5;
                    }

                    //LAB_80c26e2
                    r5 = r5 + 0x1;
                  } while(r5 <= 0x3);

                  if(FUN_80c2470(enemy.item_4e.get()) > r8_0) {
                    MEMORY.ref(2, r7 + 0xc + r10 * 0x2).setu(enemy.item_4e.get());
                  }
                }
              }
            }
          }
        }

        //LAB_80c2702
        r0 = 0x0;
      }
    }

    //LAB_80c2704
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80c2724)
  public static void FUN_80c2724() {
    int r3 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();
    CPU.sp().value -= 0x38;
    final int sp14 = r3 + 0x530;
    int r0 = MEMORY.ref(4, sp14 + 0x4).get();
    if(r0 != 0) {
      FUN_8015120(r0, 5);
      FUN_80151c8(0x83a);
      FUN_80bb65c();
    }

    //LAB_80c2756
    final int[] unitIds = new int[8];
    final int unitCount = getLivingUnitIds(0x1, unitIds);
    final int r11 = mallocBoard(0x14c);

    //LAB_80c277c
    int r8 = CPU.sp().value + 0x28;

    //LAB_80c2782
    for(int sp08 = 0; sp08 < unitCount; sp08++) {
      final int unitId = unitIds[sp08];
      final Unit14c r10 = getUnit_(unitId);
      r10.exp_124.add(MEMORY.ref(4, sp14 + 0x4).get());

      //LAB_80c28ee
      do {
        MEMORY.call(0x3001388, r11, r10.getAddress(), 0x14c); // memcpy

        if(checkLevelUp_(unitId, r8) == 0) {
          break;
        }

        //LAB_80c27a4
        playSound_(0x59);
        FUN_8015118();
        FUN_8015120(r10.class_129.get(), 3);
        FUN_8015120(unitIds[sp08], 1);
        FUN_8015120(r10.level_0f.get(), 5);
        FUN_80151c8(0x89a);
        FUN_80bb65c();

        //LAB_80c27e4
        for(int r7 = 0; r7 < 32; r7++) {
          final int r5 = r10.psynergy_58.get(r7).get() & 0xffff;
          if((r5 & 0x3fff) != 0 && r5 >>> 15 != 0) {
            //LAB_80c2806
            int r1;
            for(r1 = 0; r1 < 32 && r5 != MEMORY.ref(2, r11 + 0x58 + r1 * 0x4).getUnsigned(); r1++) {
              //
            }

            //LAB_80c2814
            if(r1 == 0x20) {
              FUN_8015118();
              FUN_8015120(r10.class_129.get(), 3);
              FUN_8015120(unitId, 1);
              FUN_8015120(r5 & 0x3fff, 4);
              playSound_(0x9a);
              FUN_80151c8(0x89b);
              FUN_80bb65c();
            }
          }

          //LAB_80c284c
        }

        r0 = MEMORY.ref(2, r8 + 0x4).get();
        if(r0 != 0) {
          FUN_8015120(r0, 5);
          FUN_80151c8(0x89c);
          FUN_80bb65c();
        }

        //LAB_80c286c
        r0 = MEMORY.ref(2, r8 + 0x6).get();
        if(r0 != 0) {
          FUN_8015120(r0, 5);
          FUN_80151c8(0x89d);
          FUN_80bb65c();
        }

        //LAB_80c2886
        r0 = MEMORY.ref(2, r8 + 0x8).get();
        if(r0 != 0) {
          FUN_8015120(r0, 5);
          FUN_80151c8(0x89e);
          FUN_80bb65c();
        }

        //LAB_80c28a0
        r0 = MEMORY.ref(2, r8 + 0xa).get();
        if(r0 != 0) {
          FUN_8015120(r0, 5);
          FUN_80151c8(0x89f);
          FUN_80bb65c();
        }

        //LAB_80c28ba
        r0 = MEMORY.ref(2, r8 + 0xc).get();
        if(r0 != 0) {
          FUN_8015120(r0, 5);
          FUN_80151c8(0x8a0);
          FUN_80bb65c();
        }

        //LAB_80c28d4
        r0 = MEMORY.ref(2, r8 + 0xe).get();
        if(r0 != 0) {
          FUN_8015120(r0, 5);
          FUN_80151c8(0x8a1);
          FUN_80bb65c();
        }
      } while(true);

      //LAB_80c290a
    }

    //LAB_80c291e
    setMallocAddress(r11);
    r0 = MEMORY.ref(4, sp14).get();
    if(r0 != 0) {
      FUN_8015120(r0, 5);
      FUN_80151c8(0x83b);
      addCoins_(MEMORY.ref(4, sp14).get());
      FUN_80bb65c();
    }

    //LAB_80c2944
    //LAB_80c2948
    do {
      int r7 = -1;
      r8 = -1;

      //LAB_80c2952
      for(int r6 = 0; r6 < 4; r6++) {
        r3 = MEMORY.ref(2, sp14 + 0xc + r6 * 0x2).getUnsigned();
        if(r3 != 0) {
          r0 = FUN_80c2470(r3);
          if(r0 >= r8) {
            r8 = r0;
            r7 = r6;
          }
        }

        //LAB_80c2968
      }

      if(r7 == -1) {
        break;
      }

      FUN_8015120(MEMORY.ref(2, sp14 + 0xc + r7 * 0x2).getUnsigned(), 2);
      FUN_80151c8(0x83c);
      FUN_80bb65c();
      if(giveItem_(MEMORY.ref(2, sp14 + 0xc + r7 * 0x2).getUnsigned()) == -1) {
        _200047c.set(MEMORY.ref(2, sp14 + 0xc + r7 * 0x2).getUnsigned());
        break;
      }

      //LAB_80c29a8
      MEMORY.ref(2, sp14 + 0xc + r7 * 0x2).setu(0);
    } while(true);

    //LAB_80c29b0
    CPU.sp().value += 0x38;
  }

  /** {@link GoldenSun_80e#FUN_80ed408} */
  @Method(0x80c9000)
  public static int FUN_80c9000(final int mallocSlot, final int op1, final int op2, final int branch1, final int branch2) {
    return (int)MEMORY.call(0x80ed408, mallocSlot, op1, op2, branch1, branch2);
  }

  /** {@link GoldenSun_80e#FUN_80e3a3c} */
  @Method(0x80c9008)
  public static void FUN_80c9008(final int r0) {
    MEMORY.call(0x80e3a3c, r0);
  }

  /** {@link GoldenSun_80d#FUN_80d6578} */
  @Method(0x80c9010)
  public static void FUN_80c9010(final int r0) {
    MEMORY.call(0x80d6578, r0);
  }

  /** {@link GoldenSun_80d#FUN_80d6660} */
  @Method(0x80c9018)
  public static void FUN_80c9018(final int r0) {
    MEMORY.call(0x80d6660, r0);
  }

  /** {@link GoldenSun_80c#FUN_80cb7f8} */
  @Method(0x80c9020)
  public static void FUN_80c9020(final int r0) {
    MEMORY.call(0x80cb7f8, r0);
  }

  /** {@link GoldenSun_80c#FUN_80cbc0c} */
  @Method(0x80c9028)
  public static void FUN_80c9028(final int r0) {
    MEMORY.call(0x80cbc0c, r0);
  }

  /** {@link GoldenSun_80c#FUN_80cc5d8} */
  @Method(0x80c9030)
  public static void FUN_80c9030(final int r0) {
    MEMORY.call(0x80cc5d8, r0);
  }

  /** {@link GoldenSun_80c#FUN_80ccaec} */
  @Method(0x80c9038)
  public static void FUN_80c9038(final int r0) {
    MEMORY.call(0x80ccaec, r0);
  }

  /** {@link GoldenSun_80c#FUN_80ccbdc} */
  @Method(0x80c9040)
  public static void FUN_80c9040() {
    MEMORY.call(0x80ccbdc);
  }

  @Method(0x80c9048)
  public static void FUN_80c9048() {
    GPU.BLDCNT.setu(0);
    GPU.BLDALPHA.setu(0x100e);
    GPU.WIN0H.setu(0xf0);
    GPU.WIN0V.setu(0x1088);
    GPU.WIN1H.setu(0xf0);
    GPU.WIN1V.setu(0x1088);
    GPU.WININ.setu(0x3537);
    GPU.WINOUT.setu(0x3f21);

    final int r4 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    final VblankTransferQueue184 r1 = vblankTransferQueue_2002090;
    if(r1.count_00.get() < 32) {
      final VblankTransfer0c r3 = r1.queue_04.get(r1.count_00.get());
      r3.src_00.set(0x7741);
      r3.dst_04.set(GPU.DISPCNT.getAddress());
      r3.cnt_08.set(0x20000);
      r1.count_00.incr();
    }

    //LAB_80c90d4
    INTERRUPTS.INT_MASTER_ENABLE.setu(r4);
    sleep(1);
  }

  @Method(0x80cd104)
  public static void FUN_80cd104(final int r0, final int r1) {
    int r2;
    int r5;
    int r6;
    int r8;
    int r10;

    final int sp00 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    final int r9 = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    final int[] r11 = new int[0x80];

    //LAB_80cd130
    for(r5 = 0; r5 < 0x80; r5++) {
      r11[r5] = rand() & 0x3f;
    }

    r8 = 0;
    r10 = 1;
    if(r0 == 0x1) {
      r5 = 0x0;

      //LAB_80cd14c
      do {
        r8 = r8 + r10;
        r10 = r10 + 1;

        //LAB_80cd15e
        for(; r5 < r8; r5++) {
          //LAB_80cd162
          for(r6 = 0; r6 < 0x80; r6++) {
            final int r1_0 = r5 - r11[r6];
            if(r1_0 >= 0x0 && r1_0 <= 0x7f) {
              r2 = r6 / 8 * 0x10 + r1_0 / 8;
              r2 = r2 << 3;
              r2 = r2 + (r6 & 0x7);
              r2 = r2 << 3;
              r2 = r2 + (r1_0 & 0x7);
              MEMORY.ref(1, r9 + r2).setu(1 - r1);
            }

            //LAB_80cd19a
          }
        }

        //LAB_80cd1a6
        MEMORY.ref(4, sp00 + 0x7824).setu(1);
        sleep(1);
      } while(r8 <= 0x100);
    } else {
      //LAB_80cd1c0
      r6 = 0x0;

      //LAB_80cd1ca
      do {
        r8 = r8 + r10 / 2;
        r10 = r10 + 4;

        //LAB_80cd1e6
        for(; r6 < r8; r6++) {
          //LAB_80cd1ea
          for(r5 = 0; r5 < 0x80; r5++) {
            final int r1_0 = r6 - r11[r5];
            if(r1_0 >= 0 && r1_0 <= 0x7f) {
              r2 = r1_0 / 8 * 0x10 + r5 / 8;
              r2 = r2 << 3;
              r2 = r2 + (r1_0 & 0x7);
              r2 = r2 << 3;
              r2 = r2 + (r5 & 0x7);
              MEMORY.ref(1, r9 + r2).setu(1 - r1);
            }

            //LAB_80cd222
          }
        }

        //LAB_80cd22e
        MEMORY.ref(4, sp00 + 0x7824).setu(1);
        sleep(1);
      } while(r8 < 0xc0);
    }

    //LAB_80cd244
  }

  @Method(0x80cd260)
  public static void FUN_80cd260() {
    final int r6 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    if(MEMORY.ref(4, r6 + 0x7824).get() == 0x1) {
      final int r5 = boardWramMallocHead_3001e50.offset(40 * 0x4).get();

      switch(MEMORY.ref(4, r6 + 0x7780).get()) {
        case 0 ->
          //LAB_80cd298
          MEMORY.memcpy(0x6004000, r5, 0x4000);

        case 1 -> {
          //LAB_80cd2a8
          MEMORY.memcpy(0x6004000, r5, 0x4000);
          memfill32(r5, 0x4000, MEMORY.ref(4, r6 + 0x7784).get());
        }

        case 2 -> {
          //LAB_80cd2ca
          if(MEMORY.ref(4, r6 + 0x7784).get() == 50) {
            FUN_8005534(r5, 0x6004000, 0x4000);
          } else {
            //LAB_80cd2e2
            FUN_80054e4(r5, 0x6004000, 0x4000);
          }
        }

        case 3 ->
          //LAB_80cd2f0
          FUN_8005490(r5, MEMORY.ref(4, r6 + 0x7784).get(), 0x6004000, 0x4000);

        case 4 ->
          //LAB_80cd304
          FUN_800543c(r5, MEMORY.ref(4, r6 + 0x7784).get(), 0x6004000, 0x4000);
      }

      //LAB_80cd316
      MEMORY.ref(4, r6 + 0x7824).setu(0);
      MEMORY.ref(4, r6 + 0x7820).setu(1);
    } else {
      //LAB_80cd326
      MEMORY.ref(4, r6 + 0x7820).incr();
    }

    //LAB_80cd32e
  }

  @Method(0x80cd4b4)
  public static void FUN_80cd4b4() {
    final int r2 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    final BattleStruct82c r0 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    if(MEMORY.ref(4, r2 + 0x77b4).get() > 0) {
      MEMORY.ref(4, r2 + 0x77b8).incr();
      multiplyColours(r0._544.getAddress(), 0x50000c0, 0x10000 - MEMORY.ref(4, r2 + 0x77b8).get() * 0x444, 0x80);
      MEMORY.ref(4, r2 + 0x77b4).decr();
    }
  }

  @Method(0x80cd508)
  public static void FUN_80cd508() {
    MEMORY.memfill(boardWramMallocHead_3001e50.offset(39 * 0x4).get() + 0x7818, 0x8, 0);
  }

  @Method(0x80cd52c)
  public static void FUN_80cd52c() {
    final int r6 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();

    //LAB_80cd546
    for(int r4 = 0; r4 < 8; r4++) {
      if(MEMORY.ref(1, r6 + 0x7818 + r4).getUnsigned() != 0) {
        MEMORY.ref(1, r6 + 0x7818 + r4).decr();

        if(MEMORY.ref(1, r6 + 0x7818 + r4).getUnsigned() == 0) {
          final int r3 = MEMORY.ref(4, r6 + 0x7828).get();
          FUN_80d6888(MEMORY.ref(2, r3 + 0x24 + r4 * 0x2).get(), 0, -1, -1, 0);
        }
      }

      //LAB_80cd572
    }
  }

  @Method(0x80cd594)
  public static void FUN_80cd594(final int r0) {
    int r1;

    final int r9 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    final BattleStruct82c r10 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int sp00 = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    final int r11 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    FUN_80cd508();
    MEMORY.ref(4, r11 + 0xc).setu(1);
    sleep(1);

    GPU.BLDCNT.setu(0);

    r1 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    final VblankTransferQueue184 r6 = vblankTransferQueue_2002090;
    if(r6.count_00.get() < 32) {
      final VblankTransfer0c r3 = r6.queue_04.get(r6.count_00.get());
      r3.src_00.set(0x7741);
      r3.dst_04.set(GPU.DISPCNT.getAddress());
      r3.cnt_08.set(0x20000);
      r6.count_00.incr();
    }

    //LAB_80cd61c
    INTERRUPTS.INT_MASTER_ENABLE.setu(r1);

    final int r2 = 0x3001ad0;
    MEMORY.ref(2, r2 + 0x6).setu(32);
    sleep(1);
    FUN_80b5038(1, r10.backgroundPointerTableId_648.get(), 0);
    MEMORY.ref(4, r9 + 0x77b4).setu(0);
    MEMORY.ref(4, r9 + 0x77b8).setu(0);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"), 0xc80);

    r1 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    if(r6.count_00.get() < 32) {
      final VblankTransfer0c r3 = r6.queue_04.get(r6.count_00.get());
      r3.src_00.set(0x7341);
      r3.dst_04.set(GPU.DISPCNT.getAddress());
      r3.cnt_08.set(0x20000);
      r6.count_00.incr();
    }

    //LAB_80cd680
    INTERRUPTS.INT_MASTER_ENABLE.setu(r1);

    sleep(1);
    GPU.BG2CNT.setu(r0 | 0x784);

    r1 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    if(r6.count_00.get() < 32) {
      final VblankTransfer0c r3 = r6.queue_04.get(r6.count_00.get());
      r3.src_00.set(0x7341);
      r3.dst_04.set(GPU.DISPCNT.getAddress());
      r3.cnt_08.set(0x20000);
      r6.count_00.incr();
    }

    //LAB_80cd6d8
    INTERRUPTS.INT_MASTER_ENABLE.setu(r1);

    FUN_80b5028(0, 0, 0, 100);
    MEMORY.ref(4, r11 + 0xc).setu(0);
    sleep(1);
    GPU.BLDCNT.setu(0x3f44);
    GPU.BLDALPHA.setu(0x100e);
    GPU.BG2X.setu(0);
    GPU.BG2Y.setu(-0x1000);
    GPU.BG2PA.setu(0x80);
    GPU.BG2PB.setu(0);
    GPU.BG2PC.setu(0);
    GPU.BG2PD.setu(0x100);
    GPU.WIN0H.setu(0xf0);
    GPU.WIN0V.setu(0x1088);
    GPU.WIN1H.setu(0xf0);
    GPU.WIN1V.setu(0x1088);
    GPU.WININ.setu(0x3537);
    GPU.WINOUT.setu(0x3f21);

    r1 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    if(r6.count_00.get() < 32) {
      final VblankTransfer0c r3 = r6.queue_04.get(r6.count_00.get());
      r3.src_00.set(0x7741);
      r3.dst_04.set(GPU.DISPCNT.getAddress());
      r3.cnt_08.set(0x20000);
      r6.count_00.incr();
    }

    //LAB_80cd7b2
    INTERRUPTS.INT_MASTER_ENABLE.setu(r1);

    //LAB_80cd7cc
    int r5 = 0;
    for(int r12 = 0; r12 < 16; r12++) {
      //LAB_80cd7d4
      for(int r4 = 0; r4 < 8; r4++) {
        MEMORY.ref(2, 0x6003800 + r5).setu((short)(r12 * 0x1000 + 0x100 + r4 * 0x200 | (r12 * 0x8 + r4) * 0x2));
        r5 = r5 + 0x2;
      }
    }

    MEMORY.memfill(sp00, 0x4000, 0);
    MEMORY.memfill(0x6004000, 0x4000, 0);
    r1 = 0x3001ad0;
    MEMORY.ref(4, r9 + 0x77a8).setu(0);
    MEMORY.ref(4, r9 + 0x77a0).setu(MEMORY.ref(2, r1 + 0x4).getUnsigned());
    MEMORY.ref(4, r9 + 0x77a4).setu(MEMORY.ref(2, r1 + 0x6).getUnsigned());
    sleep(1);
  }

  @Method(0x80cdb24)
  public static void FUN_80cdb24(int r0) {
    int r1;
    int r4;
    int r5;
    int r6;
    int r7;

    FUN_80cd594(r0);
    GPU.BG2CNT.setu(r0 | 0x6784);
    r5 = 0x0;
    r7 = 0x0;
    r6 = 0x0;

    //LAB_80cdb4c
    for(int r12 = 0; r12 < 16; r12++) {
      r0 = r6 + 0x100;
      r1 = r7 << 1;

      //LAB_80cdb64
      for(r4 = 0; r4 < 8; r4++) {
        MEMORY.ref(2, 0x6003800 + r5).setu((short)(r0 | r1));
        r0 = r0 + 0x200;
        r1 = r1 + 0x2;
        r5 = r5 + 0x2;
      }

      //LAB_80cdb94
      for(r4 = 0; r4 < 8; r4++) {
        MEMORY.ref(2, 0x6003800 + r5).setu(0);
        r5 = r5 + 0x2;
      }

      r6 = r6 + 0x1000;
      r7 = r7 + 0x8;
    }
  }

  @Method(0x80cdbc0)
  public static void FUN_80cdbc0() {
    final int r5 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    final int r7 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();
    playSound_(0x121);
    final int r6 = 0x3001ad0;
    MEMORY.ref(2, r6 + 0x4).setu(MEMORY.ref(4, r5 + 0x77a0).get());
    final int r2 = 0x3001ce0;
    MEMORY.ref(2, r6 + 0x6).setu(MEMORY.ref(4, r5 + 0x77a4).get());
    MEMORY.ref(4, r2 + 0xc).setu(120);
    MEMORY.ref(4, r2 + 0x10).setu(120);
    GPU.BG2CNT.setu(0x787);
    MEMORY.memfill(0x6004000, 0x4000, 0);
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"));
    MEMORY.ref(2, r6 + 0x6).setu(32);

    int r4 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    final VblankTransferQueue184 r1 = vblankTransferQueue_2002090;
    if(r1.count_00.get() < 32) {
      final VblankTransfer0c r3 = r1.queue_04.get(r1.count_00.get());
      r3.src_00.set(0x7341);
      r3.dst_04.set(GPU.DISPCNT.getAddress());
      r3.cnt_08.set(0x20000);
      r1.count_00.incr();
    }

    //LAB_80cdc6e
    INTERRUPTS.INT_MASTER_ENABLE.setu(r4);

    GPU.BLDCNT.setu(0);
    sleep(1);
    FUN_80b5038(2, MEMORY.ref(2, r7 + 0x648).getUnsigned(), 7);
    sleep(1);

    //LAB_80cdcb0
    for(int i = 0; i < 8; i++) {
      FUN_80b5048(MEMORY.ref(2, r7 + 0x648).getUnsigned(), 21 - i * 3);
      sleep(1);
    }

    r4 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    if(r1.count_00.get() < 32) {
      final VblankTransfer0c r3 = r1.queue_04.get(r1.count_00.get());
      r3.src_00.set(0x7541);
      r3.dst_04.set(GPU.DISPCNT.getAddress());
      r3.cnt_08.set(0x20000);
      r1.count_00.incr();
    }

    //LAB_80cdcf6
    INTERRUPTS.INT_MASTER_ENABLE.setu(r4);

    sleep(1);
  }

  @Method(0x80cdd14)
  public static void FUN_80cdd14() {
    final int r2 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    final BattleStruct82c r5 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    MEMORY.ref(4, r2 + 0xc).setu(1);
    queueVblankNand16(GPU.DISPCNT.getAddress(), 0x1541);
    sleep(1);
    FUN_80b5038(2, r5.backgroundPointerTableId_648.get(), 0);
    sleep(1);
  }

  @Method(0x80cdd58)
  public static void FUN_80cdd58() {
    int r0;
    int r1;
    int r2;
    int r4;
    int r6;

    CPU.push(CPU.r8().value);
    CPU.r8().value = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    final BattleStruct82c r5 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    r6 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    FUN_80cd508();
    FUN_80b5038(2, r5.backgroundPointerTableId_648.get(), 0);
    r2 = 0x3001ad0;
    MEMORY.ref(2, r2 + 0x6).setu(32);
    MEMORY.ref(4, r6 + 0xc).setu(0);
    MEMORY.memfill(0x6003fc0, 0x40, 0);
    memfill32(0x600f900, 0x200, -1);
    r0 = 0x0;
    r6 = 0x0;
    r4 = 0x0;

    //LAB_80cddb2
    do {
      r1 = 0x0;
      r2 = r4 + 0x100;

      //LAB_80cddb8
      do {
        if(r1 > 0xf) {
          MEMORY.ref(2, 0x600fb00 + r0).setu(0xff);
        } else {
          //LAB_80cdde4
          MEMORY.ref(2, 0x600fb00 + r0).setu(r2);
        }

        //LAB_80cdde8
        r1 = r1 + 0x1;
        r2 = r2 + 0x1;
        r0 = r0 + 0x2;
      } while(r1 != 0x20);

      r6 = r6 + 0x1;
      r4 = r4 + 0x10;
    } while(r6 != 0x10);

    GPU.DISPCNT.setu(0x7741);
    GPU.BG1CNT.setu(0x1f81);
    GPU.BLDCNT.setu(0x3f42);
    GPU.WIN0H.setu(240);
    GPU.WIN0V.setu(0x1088);
    GPU.WIN1H.setu(240);
    GPU.WIN1V.setu(0x1088);
    GPU.WININ.setu(0x3537);
    GPU.WINOUT.setu(0x3f21);
    GPU.BLDALPHA.setu(0x100e);
    MEMORY.memfill(CPU.r8().value, 0x4000, 0);
    MEMORY.memfill(0x6004000, 0x4000, 0);
    sleep(1);
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80cde90)
  public static void FUN_80cde90(int r0, int r1, int r2, int r3, final int a4) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r6 = r3;
    r3 = 0x3001ef0;
    r5 = r1;
    r3 = MEMORY.ref(4, r3).get();
    r4 = r2;
    r1 = r6 - r5;
    r2 = 0x80;
    CPU.r8().value = r0;
    r7 = r4 - r0;
    CPU.r10().value = r1;
    CPU.r9().value = r2;
    CPU.r11().value = r3;
    if(r5 < 0) {
      r5 = 0x0;
    }

    //LAB_80cdebe
    if(r5 > 0x7f) {
      r5 = 0x7f;
    }

    //LAB_80cdec4
    if(r6 < 0) {
      r6 = 0x0;
    }

    //LAB_80cdeca
    if(r6 > 0x7f) {
      r6 = 0x7f;
    }

    //LAB_80cded0
    r2 = r7;
    if(r7 < 0) {
      r2 = -r7;
    }

    //LAB_80cded8
    r3 = CPU.r10().value;
    if(r3 < 0) {
      r3 = -r3;
    }

    //LAB_80cdee0
    if(r2 < r3) {
      r3 = CPU.r10().value;
      if(r3 < 0) {
        CPU.r12().value = CPU.r8().value;
        CPU.r8().value = r4;
        r4 = CPU.r12().value;
        CPU.r12().value = r5;
        r1 = CPU.r8().value;
        r5 = r6;
        r6 = CPU.r12().value;
        r7 = r4 - r1;
      }

      //LAB_80cdefa
      r1 = r6 - r5;
      r0 = r7 << 8;
      if(r7 < 0) {
        r2 = CPU.r8().value;
        r3 = r2 - r4;
        r0 = r3 << 8;
      }

      //LAB_80cdf08
      if(r1 < 0) {
        r1 = r5 - r6;
      }

      //LAB_80cdf0e
      r0 = divideS(r0, r1);
      CPU.r12().value = r0;
      r0 = r5;
      r1 = CPU.r8().value;
      if(r0 != r6) {
        r3 = 0x80;
        r5 = 0xfffffeff;
        r3 = r3 << 1;
        r4 = 0x7;
        CPU.lr().value = r3;
        CPU.r8().value = r5;

        //LAB_80cdf28
        do {
          r2 = r0 >>> 3;
          r3 = r1 >>> 3;
          r2 = r2 << 4;
          r2 = r2 + r3;
          r3 = r0;
          r3 = r3 & r4;
          r2 = r2 << 3;
          r2 = r2 + r3;
          r3 = r1;
          r3 = r3 & r4;
          r2 = r2 << 3;
          r5 = CPU.r11().value;
          r2 = r2 + r3;
          r3 = MEMORY.ref(1, r5 + r2).getUnsigned();
          r5 = a4;
          if(r3 < r5) {
            r3 = CPU.r11().value;
            MEMORY.ref(1, r3 + r2).setu(r5);
          }

          //LAB_80cdf4e
          CPU.r9().value = CPU.r9().value + CPU.r12().value;
          r3 = CPU.r9().value;
          r5 = CPU.lr().value;
          r3 = r3 & r5;
          if(r3 != 0) {
            if(r7 > 0) {
              r1 = r1 + 0x1;
            } else {
              //LAB_80cdf62
              r1 = r1 - 0x1;
            }

            //LAB_80cdf64
            r2 = CPU.r9().value;
            r3 = CPU.r8().value;
            r2 = r2 & r3;
            CPU.r9().value = r2;
          }

          //LAB_80cdf6c
          r0 = r0 + 0x1;
        } while(r0 != r6);
      }
    } else {
      //LAB_80cdf74
      if(r7 < 0) {
        CPU.r12().value = CPU.r8().value;
        CPU.r8().value = r4;
        r4 = CPU.r12().value;
        CPU.r12().value = r5;
        r5 = r6;
        r6 = CPU.r12().value;
        r2 = r6 - r5;
        r1 = CPU.r8().value;
        CPU.r10().value = r2;
        r7 = r4 - r1;
        r1 = CPU.r10().value;
      } else {
        //LAB_80cdf90
        r1 = r6 - r5;
      }

      //LAB_80cdf92
      r0 = r1 << 8;
      if(r1 < 0) {
        r3 = r5 - r6;
        r0 = r3 << 8;
      }

      //LAB_80cdf9c
      if(r7 >= 0) {
        r1 = r7;
        r0 = divideS(r0, r1);
        CPU.r12().value = r0;
      } else {
        //LAB_80cdfae
        r3 = CPU.r8().value;
        r1 = r3 - r4;
        r0 = divideS(r0, r1);
        CPU.r12().value = r0;
      }

      //LAB_80cdfbc
      r0 = CPU.r8().value;
      r1 = r5;
      if(r0 != r4) {
        r6 = 0xfffffeff;
        r7 = 0x80;
        r5 = 0x7;
        r7 = r7 << 1;
        CPU.lr().value = r6;

        //LAB_80cdfce
        do {
          r2 = r1 >>> 3;
          r3 = r0 >>> 3;
          r2 = r2 << 4;
          r2 = r2 + r3;
          r3 = r1;
          r3 = r3 & r5;
          r2 = r2 << 3;
          r2 = r2 + r3;
          r3 = r0;
          r3 = r3 & r5;
          r2 = r2 << 3;
          r6 = CPU.r11().value;
          r2 = r2 + r3;
          r3 = MEMORY.ref(1, r6 + r2).getUnsigned();
          r6 = a4;
          if(r3 < r6) {
            r3 = CPU.r11().value;
            MEMORY.ref(1, r3 + r2).setu(r6);
          }

          //LAB_80cdff4
          CPU.r9().value = CPU.r9().value + CPU.r12().value;
          r3 = CPU.r9().value;
          r3 = r3 & r7;
          if(r3 != 0) {
            r6 = CPU.r10().value;
            if(r6 > 0) {
              r1 = r1 + 0x1;
            } else {
              //LAB_80ce008
              r1 = r1 - 0x1;
            }

            //LAB_80ce00a
            r2 = CPU.r9().value;
            r3 = CPU.lr().value;
            r2 = r2 & r3;
            CPU.r9().value = r2;
          }

          //LAB_80ce012
          r0 = r0 + 0x1;
        } while(r0 != r4);
      }
    }

    //LAB_80ce018
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80cef64)
  public static void FUN_80cef64(final int r0, final int r1) {
    if(r0 == 0) {
      FUN_80ed408(46, 7, 7, 3, 2);
      MEMORY.ref(4, r1).setu(MEMORY.ref(4, 0x3001f08).get());
      FUN_80ed408(47, 7, 7, 3, 3);
    } else {
      //LAB_80cef96
      FUN_80ed408(46, 7, 7, 7, 2);
      MEMORY.ref(4, r1).setu(MEMORY.ref(4, 0x3001f08).get());
      FUN_80ed408(47, 7, 7, 7, 3);
    }

    //LAB_80cefbe
    MEMORY.ref(4, r1 + 0x4).setu(MEMORY.ref(4, 0x3001f0c).get());
  }
}
