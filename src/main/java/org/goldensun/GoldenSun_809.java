package org.goldensun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.input.Input;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ConsumerRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.EventStruct0c;
import org.goldensun.types.FieldPsynergy720;
import org.goldensun.types.Map194;
import org.goldensun.types.Panel24;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;
import org.goldensun.types.Struct12fc;
import org.goldensun.types.Structccc;
import org.goldensun.types.Unit14c;
import org.goldensun.types.VblankTransfer0c;
import org.goldensun.types.Vec3;
import org.goldensun.weather.LightningStruct1f88;
import org.goldensun.weather.PaletteStruct2a04;

import static org.goldensun.CopiedSegment8000770.FUN_300013c;
import static org.goldensun.CopiedSegment8000770.mul16;
import static org.goldensun.CopiedSegment8000770.sqrt;
import static org.goldensun.GoldenSun.allocateSpriteSlot;
import static org.goldensun.GoldenSun.FUN_8005268;
import static org.goldensun.GoldenSun.FUN_80053e8;
import static org.goldensun.GoldenSun.FUN_8009088;
import static org.goldensun.GoldenSun.setActorSpriteScript_;
import static org.goldensun.GoldenSun.FUN_80090e0;
import static org.goldensun.GoldenSun.FUN_8009128;
import static org.goldensun.GoldenSun.FUN_8009140;
import static org.goldensun.GoldenSun.FUN_8009148;
import static org.goldensun.GoldenSun.moveActorTo_;
import static org.goldensun.GoldenSun.FUN_8009158;
import static org.goldensun.GoldenSun.FUN_80091d8;
import static org.goldensun.GoldenSun.FUN_80091e0;
import static org.goldensun.GoldenSun.FUN_8009220;
import static org.goldensun.GoldenSun.FUN_8009240;
import static org.goldensun.GoldenSun.FUN_80092a0;
import static org.goldensun.GoldenSun.FUN_80092a8;
import static org.goldensun.GoldenSun.FUN_800b684;
import static org.goldensun.GoldenSun.FUN_800ca6c;
import static org.goldensun.GoldenSun.moveActorTo;
import static org.goldensun.GoldenSun.FUN_800d924;
import static org.goldensun.GoldenSun.addLayerToSprite;
import static org.goldensun.GoldenSun.addLayerToSprite_;
import static org.goldensun.GoldenSun.atan2;
import static org.goldensun.GoldenSun.clearActor_;
import static org.goldensun.GoldenSun.clearSpriteLayer;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.drawSprite_;
import static org.goldensun.GoldenSun.fadeInBrightness;
import static org.goldensun.GoldenSun.fadeOutBrightness;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.getHeight_;
import static org.goldensun.GoldenSun.getTileType_;
import static org.goldensun.GoldenSun.insertIntoRenderQueue;
import static org.goldensun.GoldenSun.loadActor_;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.rotVec3;
import static org.goldensun.GoldenSun.setActorAnimation_;
import static org.goldensun.GoldenSun.setActorPosition_;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.sqrt16;
import static org.goldensun.GoldenSunVars._200040e;
import static org.goldensun.GoldenSunVars._2000410;
import static org.goldensun.GoldenSunVars._2000412;
import static org.goldensun.GoldenSunVars._2000414;
import static org.goldensun.GoldenSunVars._2000416;
import static org.goldensun.GoldenSunVars._200041a;
import static org.goldensun.GoldenSunVars._200042e;
import static org.goldensun.GoldenSunVars._2000432;
import static org.goldensun.GoldenSunVars._200044a;
import static org.goldensun.GoldenSunVars._200044c;
import static org.goldensun.GoldenSunVars.boundPsynergy1_2000460;
import static org.goldensun.GoldenSunVars.boundPsynergy2_2000462;
import static org.goldensun.GoldenSunVars._2000474;
import static org.goldensun.GoldenSunVars._2000476;
import static org.goldensun.GoldenSunVars._200048a;
import static org.goldensun.GoldenSunVars._200048c;
import static org.goldensun.GoldenSunVars._20004a4;
import static org.goldensun.GoldenSunVars._3001810;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.charIds_2000438;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.mapId_2000400;
import static org.goldensun.GoldenSunVars.playerMapActorIndex_2000434;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.tileAttribs_2010000;
import static org.goldensun.GoldenSunVars.vblankTransferQueue_2002090;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.GoldenSun_801.FUN_8015038;
import static org.goldensun.GoldenSun_801.FUN_8015040;
import static org.goldensun.GoldenSun_801.FUN_8015048;
import static org.goldensun.GoldenSun_801.FUN_8015050;
import static org.goldensun.GoldenSun_801.FUN_80150f8;
import static org.goldensun.GoldenSun_801.FUN_8015100;
import static org.goldensun.GoldenSun_801.FUN_8015108;
import static org.goldensun.GoldenSun_801.FUN_8015110;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015140;
import static org.goldensun.GoldenSun_801.FUN_80151e0;
import static org.goldensun.GoldenSun_801.FUN_8015208;
import static org.goldensun.GoldenSun_801.FUN_8015360;
import static org.goldensun.GoldenSun_801.FUN_8015390;
import static org.goldensun.GoldenSun_801.FUN_8015420;
import static org.goldensun.GoldenSun_801.FUN_8015428;
import static org.goldensun.GoldenSun_807.FUN_80772b0;
import static org.goldensun.GoldenSun_807.addArtifact_;
import static org.goldensun.GoldenSun_807.cacheEncounterRateBoost_;
import static org.goldensun.GoldenSun_807.addChar_;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.getAbility_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getItemCount_;
import static org.goldensun.GoldenSun_807.getItem_;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_807.giveItem_;
import static org.goldensun.GoldenSun_807.hasAbility_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.removeChar_;
import static org.goldensun.GoldenSun_807.setFlag_;
import static org.goldensun.GoldenSun_808.FUN_808adf0;
import static org.goldensun.GoldenSun_808.FUN_808b074;
import static org.goldensun.GoldenSun_808.getEncounterId;
import static org.goldensun.GoldenSun_808.FUN_808b320;
import static org.goldensun.GoldenSun_808.loadActorSet;
import static org.goldensun.GoldenSun_808.FUN_808b824;
import static org.goldensun.GoldenSun_808.FUN_808d394;
import static org.goldensun.GoldenSun_808.FUN_808d5a4;
import static org.goldensun.GoldenSun_808.findFieldPsynergyTarget;
import static org.goldensun.GoldenSun_808.FUN_808e0b0;
import static org.goldensun.GoldenSun_808.FUN_808e118;
import static org.goldensun.GoldenSun_808.FUN_808e4b4;
import static org.goldensun.GoldenSun_808.FUN_808fecc;
import static org.goldensun.GoldenSun_808.FUN_808fefc;
import static org.goldensun.GoldenSun_808.getMapActor;
import static org.goldensun.GoldenSun_80b.FUN_80b0058;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.GoldenSun_818.getSpriteData;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_809 {
  private GoldenSun_809() { }

  private static final Logger LOGGER = LogManager.getFormatterLogger(GoldenSun_809.class);

  @Method(0x80901c0)
  public static void FUN_80901c0(final int r0, final int r1) {

    final int r2 = r0 >> 8 & 0xff;
    final int r6 = r0 & 0xff;

    switch(r2) {
      case 0 -> {
        fadeInBrightness(0);
        fadeOutBrightness(r1);
      }

      case 1 -> {
        FUN_8091200(0x8000, 0);
        calculatePaletteModificationSteps(r1);
      }

      case 2 -> {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0x20);
        MEMORY.ref(2, r5 + 0x534).setu(0x3f);
        MEMORY.ref(2, r5 + 0x536).setu(0x1);
        setTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f52c"), 0xc80);
        setTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f498"), 0x480);
        sleep(0x1);
        MEMORY.ref(1, r5 + 0x53a).setu(0x20);
        MEMORY.ref(1, r5 + 0x53B).setu(0x40);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
      }

      case 3 -> {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0x20);
        FUN_80907b0(0);
        sleep(1);
        setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8090658"), 0xc80);
        MEMORY.ref(1, r5 + 0x53a).setu(0x20);
        MEMORY.ref(1, r5 + 0x53b).setu(0x40);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
      }

      case 4 -> {
        final int r5 = FUN_808fecc();
        if(r6 == 0) {
          setTickCallback(getRunnable(GoldenSun_809.class, "FUN_80903bc"), 0xc80);
          setInterruptHandler(1, 0, getRunnable(GoldenSun_809.class, "FUN_8090584"));
          MEMORY.ref(1, r5 + 0x53a).setu(r6);
          MEMORY.ref(1, r5 + 0x53b).setu(0x50);
          MEMORY.ref(1, r5 + 0x53c).setu(r1);
          MEMORY.ref(1, r5 + 0x53d).setu(r6);
        } else {
          //LAB_8090322
          setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8090488"), 0xc80);
          setInterruptHandler(1, 0, getRunnable(GoldenSun_809.class, "FUN_8090584"));
          MEMORY.ref(1, r5 + 0x53a).setu(0);
          MEMORY.ref(1, r5 + 0x53b).setu(0x50);
          MEMORY.ref(1, r5 + 0x53c).setu(r1);
          MEMORY.ref(1, r5 + 0x53d).setu(0);
        }
      }
    }

    //LAB_8090352
  }

  @Method(0x80903bc)
  public static void FUN_80903bc() {
    final int r6 = boardWramMallocHead_3001e50.offset(31 * 0x4).get();
    final int r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    int r2 = MEMORY.ref(1, r6 + 0x53c).get();
    if(r2 != 0) {
      if(MEMORY.ref(1, r6 + 0x53d).get() >= r2) {
        MEMORY.ref(1, r6 + 0x53c).setu(0);
        clearTickCallback(getRunnable(GoldenSun_809.class, "FUN_80903bc"));
        setInterruptHandler(1, 0, null);
        return;
      }

      //LAB_80903f6
      MEMORY.ref(1, r6 + 0x53d).incr();
      MEMORY.ref(2, r6 + 0x52a).setu(MEMORY.ref(1, r6 + 0x53a).get() + divideS(MEMORY.ref(1, r6 + 0x53d).get() * (MEMORY.ref(1, r6 + 0x53b).get() - MEMORY.ref(1, r6 + 0x53a).get()), MEMORY.ref(1, r6 + 0x53c).get()));
    }

    //LAB_809042a
    r2 = MEMORY.ref(2, r6 + 0x52a).getUnsigned();
    if(r2 > 79) {
      MEMORY.ref(2, r7 + 0x100).setu(0xc8);
      MEMORY.ref(2, r7 + 0x102).setu(0xfa);
    } else {
      //LAB_809044a
      MEMORY.ref(2, r7 + 0x100).setu(r2);
      MEMORY.ref(2, r7 + 0x102).setu(0x9f - r2);
    }
  }

  @Method(0x8090584)
  public static void FUN_8090584() {
    final int r12 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();

    //LAB_8090592
    while(true) {
      final int r3 = MEMORY.ref(2, r12 + 0x108).getUnsigned();

      if(r3 == 0) {
        //LAB_8090648
        if(GPU.VCOUNT.getUnsigned() < 159) {
          MEMORY.ref(2, r12 + 0x108).incr();
          continue;
        }
      } else if(r3 == 1) {
        //LAB_80905fc
        if(GPU.VCOUNT.getUnsigned() >= MEMORY.ref(2, r12 + 0x104).getUnsigned()) {
          GPU.DISPCNT.and(~0x7).or(0x2); // Change to BG mode 2
          MEMORY.ref(2, r12 + 0x108).incr();
          continue;
        }
        //LAB_8090620
        if(GPU.VCOUNT.getUnsigned() >= MEMORY.ref(2, r12 + 0x106).getUnsigned()) {
          GPU.DISPCNT.and(~0x7); // Change to BG mode 0
          MEMORY.ref(2, r12 + 0x108).setu(3);
          continue;
        }
      } else if(r3 == 2) {
        //LAB_80905cc
        if(GPU.VCOUNT.getUnsigned() >= MEMORY.ref(2, r12 + 0x106).getUnsigned()) {
          GPU.DISPCNT.and(~0x7); // Change to BG mode 0
          MEMORY.ref(2, r12 + 0x108).setu(9);
        }
      } else if(r3 == 3) {
        if(GPU.VCOUNT.getUnsigned() >= MEMORY.ref(2, r12 + 0x104).getUnsigned()) {
          GPU.DISPCNT.and(~0x7).or(0x2); // Change to BG mode 2
          MEMORY.ref(2, r12 + 0x108).setu(9);
        }
      }
      break;
    }

    //LAB_8090652
  }

  @Method(0x80907b0)
  public static void FUN_80907b0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  /** Calculates the amount the palette will have to change each tick */
  @Method(0x809088c)
  public static void calculatePaletteModificationSteps(final ArrayRef<ShortRef> original, final ArrayRef<ShortRef> dest, final ArrayRef<ShortRef> out, final int steps) {
    if(steps > 0) {
      //LAB_80908a8
      for(int i = 0; i < 0x540; i++) {
        out.get(i).set(divideS(dest.get(i).get() - original.get(i).get(), steps));
      }
    }

    //LAB_80908ca
  }

  @Method(0x80908e0)
  public static void tickPaletteModifier() {
    if(readFlag_(0x152) != 0) {
      return;
    }

    //LAB_80908fa
    final PaletteStruct2a04 r6 = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);
    if(r6.totalTicks_2a01.get() == 0) {
      return;
    }

    //LAB_8090908
    r6.currentTicks_2a02.incr();

    if(r6.currentTicks_2a02.get() < r6.totalTicks_2a01.get()) {
      //LAB_8090928
      for(int i = 0; i < 0x540; i++) {
        r6.current_0380.get(i).add(r6.step_1880.get(i).get());
      }
    } else {
      //LAB_8090948
      MEMORY.call(0x3001388, r6.current_0380.getAddress(), r6.dest_0e00.getAddress(), 0xa80); // memcpy
      r6.totalTicks_2a01.set(0);
    }

    r6.bufferIndex_2a00.xor(0x1);

    //LAB_8090966
    //LAB_80909a8
    for(int i = 0; i < 0x1c0; i++) {
      r6._2300.get(r6.bufferIndex_2a00.get()).get(i).set(r6.current_0380.get(i * 3).get() & 0x7c00 | r6.current_0380.get(i * 3 + 1).get() >>> 5 & 0x3e0 | r6.current_0380.get(i * 3 + 2).get() >>> 10 & 0x1f);
    }

    final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    if(vblankTransferQueue_2002090.count_00.get() < 0x20) {
      final VblankTransfer0c transfer = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
      transfer.src_00.set(r6._2300.get(r6.bufferIndex_2a00.get()).getAddress());
      transfer.dst_04.set(0x5000000);
      transfer.cnt_08.set(0x84000070);
      vblankTransferQueue_2002090.count_00.incr();
    }

    if(vblankTransferQueue_2002090.count_00.get() < 0x20) {
      final VblankTransfer0c transfer = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
      transfer.src_00.set(r6._2300.get(r6.bufferIndex_2a00.get()).get(0xe0).getAddress());
      transfer.dst_04.set(0x5000200);
      transfer.cnt_08.set(0x84000070);
      vblankTransferQueue_2002090.count_00.incr();
    }

    //LAB_8090a42
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);

    //LAB_8090a44
  }

  @Method(0x8090a5c)
  public static void FUN_8090a5c(int r0, final int src, final int dst, final int mode) {
    int r4;
    int r5;
    int r6;
    int r7;

    if(r0 == 0x8000) {
      r0 = MEMORY.ref(2, 0x5000000).getUnsigned();
    }

    //LAB_8090a86
    final int count;
    if(mode == 1 || mode == 2) {
      count = 0xe0;
    } else {
      count = 0x1c0;
    }

    final int r10;
    final int r8;
    if(mode == 2) {
      r10 = src + 0x1c0;
      r8 = dst + 0x540;
    } else {
      r10 = src;
      r8 = dst;
    }

    //LAB_8090aa4
    if(r0 >= 0 && r0 < 0x8000) {
      MEMORY.ref(2, r8).setu(r0 & 0x7c00);
      MEMORY.ref(2, r8 + 0x2).setu((r0 & 0x3e0) << 5);
      MEMORY.ref(2, r8 + 0x4).setu((r0 & 0x1f) << 10);
      DMA.channels[3].SAD.setu(r8);
      DMA.channels[3].DAD.setu(r8 + 0x6);
      DMA.channels[3].CNT.setu(0x80000000 | (count - 1) * 6 / 2);
      //LAB_8090afe
    } else if(r0 < 0 || r0 >= 0x100000) {
      //LAB_8090f3e
      if((r0 & 0x200000) != 0) {
        final int sp20 = r0 & 0x1f;
        final int sp1c = r0 >>> 5 & 0x1f;
        final int r11 = r0 >>> 10 & 0x1f;

        //LAB_8090f6e
        for(int i = 0; i < count; i++) {
          r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
          r4 = divideS((r4 << 11 & 0xf800) + (r4 << 7 & 0x1f000) + (r4 & 0x7c00), 0x60);
          MEMORY.ref(2, r8 + i * 0x6).setu(min_7c00(r11 * r4));
          MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(min_7c00(sp1c * r4));
          MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(min_7c00(sp20 * r4));
        }
        //LAB_8090fde
      } else if((r0 & 0x400000) != 0) {
        //LAB_8090fea
        final int sp18 = r0 & 0x1f;
        final int sp14 = r0 >>> 5 & 0x1f;
        final int r11 = r0 >>> 10 & 0x1f;

        //LAB_8091010
        //LAB_8091028
        for(int i = 0; i < count; i++) {
          r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
          r4 = divideS((r4 & 0x1f) + (r4 >>> 5 & 0x1f) + (r4 >>> 10 & 0x1f) << 4, sp18 + sp14 + r11);
          r7 = clamp_0_1f((int)MEMORY.call(0x3000118, sp18 * r4 >>> 4 << 16, sp18 << 16 >> 4) >>> 16);
          r6 = clamp_0_1f((int)MEMORY.call(0x3000118, sp14 * r4 >>> 4 << 16, sp14 << 16 >> 4) >>> 16);
          r5 = clamp_0_1f((int)MEMORY.call(0x3000118, r11 * r4 >>> 4 << 16, r11 << 16 >> 4) >>> 16);
          MEMORY.ref(2, r8 + i * 0x6).setu(MEMORY.ref(2, 0x809e92e + r5 * 0x2).getUnsigned());
          MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(MEMORY.ref(2, 0x809e92e + r6 * 0x2).getUnsigned());
          MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(MEMORY.ref(2, 0x809e92e + r7 * 0x2).getUnsigned());
        }
      } else if((r0 & 0x800000) != 0) {
        //LAB_8091114
        for(int i = 0; i < count; i++) {
          r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
          MEMORY.ref(2, r8 + i * 0x6).setu(r4 & 0x7c00);
          MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu((r4 & 0x3e0) << 5);
          MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu((r4 & 0x1f) << 10);
        }
      } else {
        //LAB_809113e
        if(mode == 2) {
          r0 = r0 + 0x540;
        }

        //LAB_8091148
        DMA.channels[3].SAD.setu(r0);
        DMA.channels[3].DAD.setu(r8);
        DMA.channels[3].CNT.setu(0x84000000 | count * 3 / 0x4);
      }
    } else {
      //LAB_8090b08
      //LAB_8090b12
      switch(r0) {
        case 0x10001 -> {
          //LAB_8090b44
          //LAB_8090b48
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
            r4 = divideS((r4 << 11 & 0xf800) + (r4 << 7 & 0x1f000) + (r4 & 0x7c00), 0x7);
            MEMORY.ref(2, r8 + i * 0x6).setu(r4);
            MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(r4);
            MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(r4);
          }
        }

        case 0x10002 -> {
          //LAB_8090b92
          //LAB_8090b98
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
            r4 = divideS((r4 & 0x1f) + (r4 >>> 5 & 0x1f) + (r4 >>> 10 & 0x1f), 0xa);
            r5 = MathHelper.clamp(r4 * 3 + 5, 8, 28);
            r7 = MathHelper.clamp(r4 * 3 + 5, 8, 28);
            r6 = MathHelper.clamp(r4 * 4 + 5, 8, 28);
            MEMORY.ref(2, r8 + i * 0x6).setu(MEMORY.ref(2, 0x809e96e + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(MEMORY.ref(2, 0x809e96e + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(MEMORY.ref(2, 0x809e96e + r6 * 0x2).getUnsigned());
          }
        }

        case 0x10003 -> {
          //LAB_8090c2e
          //LAB_8090c32
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
            r6 = r4 & 0x1f;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;

            if((r6 | r7 | r5) != 0) {
              r6 = clamp_0_1f(r6 - (r6 >>> 1) + 10);
              r7 = clamp_0_1f(r7 - divideS(r7, 3) + 8);
              r5 = clamp_0_1f(r5 - 7);
            }

            //LAB_8090c7e
            MEMORY.ref(2, r8 + i * 0x6).setu(MEMORY.ref(2, 0x809e9ae + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(MEMORY.ref(2, 0x809e96e + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(MEMORY.ref(2, 0x809e92e + r6 * 0x2).getUnsigned());
          }
        }

        case 0x10004 -> {
          //LAB_8090cc0
          //LAB_8090cc4
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
            r6 = clamp_0_1f(MathHelper.clamp(r4 & 0x1f, 10, 28));
            r7 = clamp_0_1f(MathHelper.clamp(r4 >>> 5 & 0x1f, 16, 24) + 2);
            r5 = clamp_0_1f(MathHelper.clamp(r4 >>> 10 & 0x1f, 16, 26) + 2);
            MEMORY.ref(2, r8 + i * 0x6).setu(MEMORY.ref(2, 0x809e92e + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(MEMORY.ref(2, 0x809e92e + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(MEMORY.ref(2, 0x809e92e + r6 * 0x2).getUnsigned());
          }
        }

        case 0x10005 -> {
          //LAB_8090d5a
          //LAB_8090d5e
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
            r6 = r4 & 0x1f;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;
            r0 = clamp_0_1f(divideS(r6 + r7 + r5, 3));
            r6 = clamp_0_1f(r6 / 2 + r0);
            r7 = clamp_0_1f(r7 / 2 + r0);
            r5 = clamp_0_1f(r5 / 2 + r0);
            MEMORY.ref(2, r8 + i * 0x6).setu(MEMORY.ref(2, 0x809e9ae + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(MEMORY.ref(2, 0x809e9ae + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(MEMORY.ref(2, 0x809e9ae + r6 * 0x2).getUnsigned());
          }
        }

        case 0x10006 -> {
          //LAB_8090ddc
          //LAB_8090de0
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
            r6 = r4 & 0x1f;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;
            r6 = clamp_0_1f(r6 + r7 / 8 + r5 / 8);
            r7 = r7 - divideS(r7, 3);
            r5 = r5 - divideS(r5, 3);
            MEMORY.ref(2, r8 + i * 0x6).setu(MEMORY.ref(2, 0x809e92e + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(MEMORY.ref(2, 0x809e92e + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(MEMORY.ref(2, 0x809e96e + r6 * 0x2).getUnsigned());
          }
        }

        case 0x10007 -> {
          //LAB_8090e70
          //LAB_8090e74
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
            r6 = r4 & 0x1f;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;
            r6 = clamp_0_1f(r6 - (r6 >>> 1) + 6);
            r7 = clamp_0_1f(r7 - divideS(r7, 3) + 4);
            r5 = clamp_0_1f(r5 - 6);
            MEMORY.ref(2, r8 + i * 0x6).setu(MEMORY.ref(2, 0x809e9ae + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu(MEMORY.ref(2, 0x809e96e + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu(MEMORY.ref(2, 0x809e92e + r6 * 0x2).getUnsigned());
          }
        }

        default -> {
          //LAB_8090ef0
          //LAB_8090f14
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10 + i * 0x2).getUnsigned();
            MEMORY.ref(2, r8 + i * 0x6).setu(r4 & 0x7c00);
            MEMORY.ref(2, r8 + i * 0x6 + 0x2).setu((r4 & 0x3e0) << 5);
            MEMORY.ref(2, r8 + i * 0x6 + 0x4).setu((r4 & 0x1f) << 10);
          }
        }
      }
    }

    //LAB_809115e
  }

  /** Used for lightning, field psynergy. TODO this code is not correctly restoring palettes, leaving things the wrong colour. */
  @Method(0x8091174)
  public static void allocatePaletteModifier() {
    final PaletteStruct2a04 addr = MEMORY.ref(4, mallocSlotBoard(32, 0x2a04), PaletteStruct2a04::new);
    MEMORY.memfill(addr.getAddress(), 0x2a04, 0);

    DMA.channels[3].SAD.setu(0x5000000);
    DMA.channels[3].DAD.setu(addr.backgroundPaletteBackup_0000.getAddress());
    DMA.channels[3].CNT.setu(0x84000070);

    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(addr.foregroundPaletteBackup_01c0.getAddress());
    DMA.channels[3].CNT.setu(0x84000070);

    FUN_8090a5c(0x10000, addr.backgroundPaletteBackup_0000.getAddress(), addr.dest_0e00.getAddress(), 0);
    setTickCallback(getRunnable(GoldenSun_809.class, "tickPaletteModifier"), 0xc8f);
  }

  @Method(0x8091200)
  public static void FUN_8091200(final int r0, final int mode) {
    final PaletteStruct2a04 r1_0 = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);

    if(r1_0 != null) {
      FUN_8090a5c(r0, r1_0.backgroundPaletteBackup_0000.getAddress(), r1_0.dest_0e00.getAddress(), mode);
    }

    //LAB_8091218
  }

  @Method(0x8091220)
  public static void FUN_8091220(final int r0, final int mode) {
    final PaletteStruct2a04 r1_0 = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);

    if(r1_0 != null) {
      FUN_8090a5c(r0, r1_0.backgroundPaletteBackup_0000.getAddress(), r1_0.current_0380.getAddress(), mode);
    }

    //LAB_8091238
  }

  @Method(0x8091240)
  public static void FUN_8091240(final int r0) {
    final PaletteStruct2a04 r3 = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);

    if(r3 != null) {
      r3.backgroundPaletteBackup_0000.get(0).set(r0);
    }

    //LAB_809124c
  }

  @Method(0x8091254)
  public static void calculatePaletteModificationSteps(final int ticks) {
    final PaletteStruct2a04 r4 = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);

    if(r4 != null) {
      r4.totalTicks_2a01.set(ticks);
      r4.currentTicks_2a02.set(0);
      calculatePaletteModificationSteps(r4.current_0380, r4.dest_0e00, r4.step_1880, ticks);
    }

    //LAB_8091286
  }

  @Method(0x8091294)
  public static int clamp_0_1f(final int val) {
    return MathHelper.clamp(val, 0, 0x1f);
  }

  @Method(0x80912a8)
  public static int min_7c00(final int val) {
    return Math.min(val, 0x7c00);
  }

  @Method(0x80912b8)
  public static void FUN_80912b8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._e4.getAddress();
    CPU.r11().value = boardWramMallocHead_3001e50.offset(36 * 0x4).get();
    CPU.sp().value -= 0x10;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(MEMORY.ref(2, r3 + 0x2).get());
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(MEMORY.ref(2, r3 + 0x6).get());
    r5 = CPU.r11().value;
    r3 = MEMORY.ref(4, r5 + 0x18).get();
    if(r3 != 0x0) {
      //LAB_80912ea
      CPU.r10().value = MEMORY.ref(4, r3 + 0x10).get();
      r1 = MEMORY.ref(2, r3 + 0x16).get();
      r7 = MEMORY.ref(4, r3 + 0x8).get();
      MEMORY.ref(4, CPU.sp().value).setu(r1);
      r3 = r3 + 0x22;
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r1 = 0xbd;
      CPU.r8().value = r3;
      r3 = 0x3001b10;
      r1 = r1 << 1;
      r2 = 0xfff80000;
      r3 = r3 + r1;
      r7 = r7 + r2;
      r3 = MEMORY.ref(2, r3).getUnsigned();
      r2 = 0x80;
      r2 = r2 << 13;
      r3 = r3 >>> 5;
      r2 = r2 + CPU.r10().value;
      CPU.r9().value = r3;
      r0 = getHeight_(CPU.r8().value, r7, r2);
      r6 = r0 >> 16;
      r0 = getHeight_(CPU.r8().value, r7, CPU.r10().value + 0x200000);
      r0 = r0 >> 16;
      r0 = r0 - 0x10;
      if(r0 > r6) {
        r6 = r0;
      }

      //LAB_8091336
      if(r6 > 0x0) {
        r3 = MEMORY.ref(4, CPU.sp().value).get();
        if(r6 > r3) {
          r3 = 0x40000800;
          r1 = 0xd;
          MEMORY.ref(4, r5 + 0x4).setu(r3);
          r3 = 0x80;
          r2 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
          r3 = r3 << 3;
          r1 = -r1;
          MEMORY.ref(4, r5 + 0x8).setu(r3);
          r3 = r1;
          r3 = r3 & r2;
          MEMORY.ref(1, r5 + 0x9).setu(r3);
          r3 = 0x3ff;
          r2 = CPU.r9().value;
          r2 = r2 & r3;
          r0 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
          r3 = 0xfffffc00;
          r3 = r3 & r0;
          r3 = r3 | r2;
          MEMORY.ref(2, r5 + 0x8).setu(r3);
          r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
          r1 = r1 & r3;
          r3 = 0x4;
          r1 = r1 | r3;
          MEMORY.ref(1, r5 + 0x5).setu(r1);
          r3 = 0xfff0;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r2 = r7 >> 16;
          r2 = r2 & r3;
          r3 = 0x1ff;
          r2 = r2 - r1;
          r2 = r2 & r3;
          r1 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
          r3 = 0xfffffe00;
          r3 = r3 & r1;
          r3 = r3 | r2;
          MEMORY.ref(2, r5 + 0x6).setu(r3);
          r2 = CPU.r10().value;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = r2 >> 16;
          r2 = 0xf0;
          r3 = r3 & r2;
          r3 = r3 - r1;
          r3 = r3 - r6;
          r3 = r3 + 0x10;
          MEMORY.ref(1, r5 + 0x4).setu(r3);
          insertIntoRenderQueue(MEMORY.ref(4, r5, RenderPacket0c::new), 0);
        }
      }

      //LAB_80913c8
      r2 = 0x80;
      r2 = r2 << 13;
      r7 = r7 + r2;
      r1 = r7;
      r2 = r2 + CPU.r10().value;
      r0 = CPU.r8().value;
      r0 = getHeight_(r0, r1, r2);
      r2 = 0x80;
      r2 = r2 << 14;
      r6 = r0 >> 16;
      r2 = r2 + CPU.r10().value;
      r0 = CPU.r8().value;
      r1 = r7;
      r0 = getHeight_(r0, r1, r2);
      r0 = r0 >> 16;
      r5 = CPU.r11().value;
      r0 = r0 - 0x10;
      r5 = r5 + 0xc;
      CPU.cmpT(r0, r6);
      if(r0 > r6) {
        r6 = r0;
      }

      //LAB_80913f6
      CPU.cmpT(r6, 0x0);
      if(r6 > 0x0) {
        r2 = MEMORY.ref(4, CPU.sp().value).get();
        CPU.cmpT(r6, r2);
        if(r6 > r2) {
          r3 = 0x40000800;
          r2 = 0xd;
          r1 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
          MEMORY.ref(4, r5 + 0x4).setu(r3);
          r2 = -r2;
          r3 = 0x0;
          MEMORY.ref(4, r5 + 0x8).setu(r3);
          r3 = r2;
          r3 = r3 & r1;
          MEMORY.ref(1, r5 + 0x9).setu(r3);
          r3 = 0x3ff;
          r1 = CPU.r9().value;
          r1 = r1 & r3;
          CPU.r9().value = r1;
          r3 = 0xfffffc00;
          r1 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
          r3 = r3 & r1;
          r1 = CPU.r9().value;
          r3 = r3 | r1;
          MEMORY.ref(2, r5 + 0x8).setu(r3);
          r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
          r2 = r2 & r3;
          r3 = 0x4;
          r2 = r2 | r3;
          r3 = 0xfff0;
          MEMORY.ref(1, r5 + 0x5).setu(r2);
          r2 = r7 >> 16;
          r2 = r2 & r3;
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r2 = r2 - r3;
          r3 = 0x1ff;
          r1 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
          r2 = r2 & r3;
          r3 = 0xfffffe00;
          r3 = r3 & r1;
          r3 = r3 | r2;
          r1 = CPU.r10().value;
          MEMORY.ref(2, r5 + 0x6).setu(r3);
          r2 = 0xf0;
          r3 = r1 >> 16;
          r3 = r3 & r2;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = r3 - r2;
          r3 = r3 - r6;
          r3 = r3 + 0x10;
          MEMORY.ref(1, r5 + 0x4).setu(r3);
          insertIntoRenderQueue(MEMORY.ref(4, r5, RenderPacket0c::new), 0);
        }
      }
    }

    //LAB_8091480
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8091494)
  public static void FUN_8091494(Actor70 r0) {
    CPU.sp().value -= 0x4;
    final int r7 = mallocSlotBoard(36, 0x1c);
    final int r4 = mallocSlotChip(14, 0x400);

    final int r5 = CPU.sp().value;
    MEMORY.ref(4, r5).setu(0x11111111);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000080);

    allocateSpriteSlot(94, 0x200, r4);
    freeSlot(14);
    setTickCallback(getRunnable(GoldenSun_809.class, "FUN_80912b8"), 0xc80);

    GPU.BLDCNT.setu(0x3f9e);
    GPU.BLDALPHA.setu(0x10);
    GPU.BLDY.setu(0x1f);

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(r7);
    DMA.channels[3].CNT.setu(0x85000007);

    if(r0 == null) {
      r0 = getMapActor(playerMapActorIndex_2000434.get());
    }

    //LAB_8091514
    MEMORY.ref(4, r7 + 0x18).setu(r0.getAddress());
    CPU.sp().value += 0x4;
  }


  @Method(0x8091560)
  public static int FUN_8091560(int r0) {
    int r1;
    final int r2;
    int r3;

    r2 = CPU.addT(r0, 0x0);
    r0 = 0x809e9f0;
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r1 = CPU.movT(0x0);
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_809156e
      do {
        r1 = CPU.addT(r1, 0x1);
        r0 = CPU.addT(r0, 0x4);
        CPU.cmpT(r1, 0x81);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          break;
        }
        r3 = MEMORY.ref(2, r0).getUnsigned();
        r3 = CPU.cmpT(r3, r2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_809157c
    return r0;
  }

  @Method(0x8091584)
  public static int FUN_8091584(final int mapActorIndex) {
    final Actor70 r0 = getMapActor(mapActorIndex);

    if(r0.spriteType_54.get() != 1 || r0.sprite_50.isNull() || r0.sprite_50.deref().layers_28.get(0).isNull()) {
      //LAB_80915a0
      return 0;
    }

    //LAB_80915a4
    return r0.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get();
  }

  @Method(0x80915ac)
  public static int FUN_80915ac(final int r0) {
    if(_200044a.get() == 0) {
      return 0;
    }

    final int r0_0 = MEMORY.ref(1, FUN_8091560(r0) + 0x2).getUnsigned();
    if(r0_0 == 0xff) {
      //LAB_80915c4
      return 0;
    }

    //LAB_80915c8
    //LAB_80915ce
    return r0_0 + 0x100;
  }

  @Method(0x80915dc)
  public static int FUN_80915dc(final int r0) {
    return MEMORY.ref(1, FUN_8091560(FUN_8091584(r0)) + 0x3).getUnsigned();
  }

  @Method(0x80915ec)
  public static void FUN_80915ec() {
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    if(debug_3001f54.get() != 0) {
      if((pressedButtons_3001c94.get() & Input.BUTTON_L) != 0) {
        r1._1cc.set(0);
      }

      //LAB_8091612
      if((pressedButtons_3001c94.get() & Input.BUTTON_R) != 0) {
        r1._1cc.set(-1);
      }
    }

    //LAB_809162a
  }

  @Method(0x809163c)
  public static void FUN_809163c(final int sleepFrames) {
    if(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1cc.get() == 0 && sleepFrames != 0) {
      sleep(sleepFrames);
    }

    //LAB_8091656
  }

  @Method(0x8091660)
  public static void stopPlayerAndSetIdle() {
    final Actor70 actor = getMapActor(playerMapActorIndex_2000434.get());
    actor.velocity_24.setX(0);
    actor.velocity_24.setZ(0);
    actor.velocityScalar_30.set(0x10000);
    actor.acceleration_34.set(0x8000);
    actor.dest_38.setX(0x80000000);
    actor.dest_38.setZ(0x80000000);

    if(_2000432.get() == 1) {
      setActorAnimation_(actor, 12); // ladder idle
    } else {
      //LAB_809169e
      setActorAnimation_(actor, 1);
    }

    //LAB_80916a4
  }

  @Method(0x80916b0)
  public static void FUN_80916b0() {
    final Structccc r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    FUN_8015208();
    stopPlayerAndSetIdle();

    if(r6._cb6.get() != 0) {
      FUN_808e118();
    }

    //LAB_80916ce
    r6._cc2.set(0);
    r6._cc4.set(0);
    r6._1c8.set(0x10);
    r6._1cc.set(0);
    r6._1da.set(-1);
    r6._1dc.set(-1);
    r6._1de.set(-1);
    setTickCallback(getRunnable(GoldenSun_809.class, "FUN_80915ec"), 0xc80);
    clearFlag_(0x132);
    r6.actorIndex_1f4.set(playerMapActorIndex_2000434.get());
    r6._1f8.clear();
  }

  @Method(0x8091750)
  public static void FUN_8091750() {
    clearTickCallback(getRunnable(GoldenSun_809.class, "FUN_80915ec"));
    FUN_809335c(MEMORY.ref(4, 0x2000240 + 0x1f4).get(), 0x1);
    cacheEncounterRateBoost_();
  }

  @Method(0x80917ac)
  public static void FUN_80917ac(final int r0) {
    loadActorSet(r0, FUN_808b824());
  }

  @Method(0x80917d0)
  public static void FUN_80917d0(final int charId, final int r1) {
    addChar_(charId);

    if(r1 != 0) {
      FUN_8015420(charId);
    }
  }

  @Method(0x80917f4)
  public static void FUN_80917f4(final int r0, final int r1) {
    addChar_(r0);
    addChar_(r1);
    FUN_8015428(r0, r1);
  }

  @Method(0x8091814)
  public static int FUN_8091814(final int r0) {
    final int r5 = r0 >>> 10 & 0xf;

    if(r5 > 7) {
      return -1;
    }

    //LAB_809182a
    if(readFlag_(r5) == 0) {
      return -2;
    }

    //LAB_809183a
    if(hasAbility_(r5, r0 & 0x3ff) == 0) {
      return -3;
    }

    //LAB_809184c
    //LAB_809184e
    return 0;
  }

  @Method(0x8091858)
  public static void FUN_8091858() {
    if(FUN_8091814(boundPsynergy1_2000460.get()) != 0) {
      boundPsynergy1_2000460.set(0);
    }

    //LAB_8091870
    if(FUN_8091814(boundPsynergy2_2000462.get()) != 0) {
      boundPsynergy2_2000462.set(0);
    }

    //LAB_8091882
  }

  @Method(0x8091890)
  public static void removeCharAndHealRemainingChars(final int charId) {
    removeChar_(charId);
    FUN_8091858();
    final Unit14c r6 = getUnit_(charId);
    r6.hp_38.set(r6.maxHp_34.get());
    r6.pp_3a.set(r6.maxPp_36.get());
    r6.fractionHp_14.set(MathHelper.clamp(divideS(r6.hp_38.get() << 14, r6.hp_38.get()), 0, 0x4000));

    if(r6.fractionHp_14.get() == 0 && r6.hp_38.get() != 0) {
      r6.fractionHp_14.set(1);
    }

    //LAB_80918de
    r6.fractionPp_16.set(MathHelper.clamp(divideS(r6.pp_3a.get() << 14, r6.maxPp_36.get()), 0, 0x4000));

    if(r6.fractionPp_16.get() == 0 && r6.pp_3a.get() != 0) {
      r6.fractionPp_16.set(1);
    }

    //LAB_8091910
    r6.affliction_131.set(0);

    //LAB_809192c
    int r8 = 0;
    for(int r5 = 0; r5 < getCharCount_(); r5++) {
      if(getUnit_(charIds_2000438.get(r5).get()).hp_38.get() != 0) {
        r8++;
      }

      //LAB_8091942
    }

    //LAB_8091948
    if(r8 == 0) {
      final Unit14c charData = getUnit_(playerMapActorIndex_2000434.get());
      charData.hp_38.set(1);
      charData.fractionHp_14.set(MathHelper.clamp(divideS(0x4000, charData.maxHp_34.get()), 0, 0x4000));

      if(charData.fractionHp_14.get() == 0 && charData.hp_38.get() != 0) {
        charData.fractionHp_14.set(1);
      }

      //LAB_8091992
      charData.fractionPp_16.set(divideS(charData.pp_3a.get() << 14, charData.maxPp_36.get()));

      if(charData.fractionPp_16.get() == 0 && charData.pp_3a.get() != 0) {
        charData.fractionPp_16.set(1);
      }
    }

    //LAB_80919c4
  }

  @Method(0x80919d8)
  public static int FUN_80919d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091a58)
  public static int FUN_8091a58(final int itemId, final int r1) {
    final Structccc r11 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    CPU.sp().value -= 0xc;
    final int sp00 = r11._1d8.get();
    int r8 = giveItem_(itemId);
    if(r8 == -1) {
      //LAB_8091a8c
      FUN_8015120(itemId, 2);
      FUN_8015040(0x96a, 1);
      FUN_8015040(0x977, 1);
      final int r9 = CPU.sp().value + 0x8;
      final int r10 = CPU.sp().value + 0x4;

      //LAB_8091ab0
      int r5;
      do {
        do {
          FUN_8015040(0x978, 1);

          if(FUN_80b0058(r9, r10) != -1) {
            //LAB_8091b34
            r5 = getItemCount_(MEMORY.ref(4, CPU.sp().value + 0x8).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());

            //LAB_8091b48
            for(int i = 0; i < r5; i++) {
              FUN_80772b0(MEMORY.ref(4, CPU.sp().value + 0x8).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }

            //LAB_8091b56
            r8 = giveItem_(itemId);
            playSound_(0x53);

            if(r8 == playerMapActorIndex_2000434.get()) {
              FUN_8015120(itemId, 2);
              FUN_8015040(0x96a, 3);
            } else {
              //LAB_8091b84
              FUN_8015120(itemId, 2);
              FUN_8015120(r8, 1);
              FUN_8015040(0x96b, 3);
            }

            //LAB_8091b9c
            r11._1d8.set(sp00);
            CPU.sp().value += 0xc;
            return r8;
          }

          if((getItem_(itemId).flags_03.get() & 0x8) == 0) {
            break;
          }

          FUN_8015120(itemId, 2);
          FUN_8015040(0x97c, 1);
        } while(true);

        //LAB_8091aee
        FUN_8015120(itemId, 2);
        FUN_8015040(0x979, 5);
        r5 = FUN_8091d84(1);
        FUN_8015140();
      } while(r5 != 0x0);

      addArtifact_(itemId, 1);
      FUN_8015120(itemId, 2);
      FUN_8015040(0x97a, 1);
      r11._1d8.set(sp00);
    } else {
      //LAB_8091baa
      playSound_(0x53);
      FUN_8015120(itemId, 2);
      FUN_8015040(0x96a, 3);

      if(r8 != playerMapActorIndex_2000434.get()) {
        FUN_8015120(itemId, 2);
        FUN_8015120(r8, 1);
        FUN_8015040(0x96b, 3);
      }

      //LAB_8091be8
      r11._1d8.set(sp00);
    }

    //LAB_8091bee
    CPU.sp().value += 0xc;
    return r8;
  }

  @Method(0x8091c44)
  public static void waitForActorAnimationToFinish(final int actorIndex, final int animationIndex) {
    final Actor70 actor = getMapActor(actorIndex);
    if(actor != null) {
      if(actor.spriteType_54.get() == 1) {
        final Sprite38 r3 = actor.sprite_50.deref();
        int r5 = 0;

        sleep(0x1);

        //LAB_8091c66
        //LAB_8091c64
        while(animationIndex == r3.anim_24.get()) {
          r5++;

          if(r5 > 0x59) {
            break;
          }
          sleep(0x1);
        }
      }
    }

    //LAB_8091c76
  }

  /** Opening cutscene just before leaving the house */
  @Method(0x8091c7c)
  public static int FUN_8091c7c(final int mapActorIndex, final int r1) {
    final Structccc r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final int r11 = MEMORY.ref(2, FUN_808d394(r6.actorIndex_1f4.get())).get();
    final Panel24 r10 = r6._1f8.deref();
    final Panel24 r5 = r6._1fc.derefNullable();
    int sp00 = 0x1;

    //LAB_8091cc6
    while(pressedButtons_3001c94.get() != 0) {
      sleep(1);
    }

    //LAB_8091cd4
    //LAB_8091cda
    while(FUN_8015048() == 0) {
      sleep(1);
    }

    sleep(3);

    if(r1 == 0) {
      int r1_0 = r10.y_0e.get() + r10.h_0a.get();
      if(r5 != null) {
        final int r2 = r5.y_0e.get() + r5.h_0a.get();
        if(r1_0 < r2) {
          r1_0 = r2;
        }
      }

      //LAB_8091d06
      if(r1_0 > 0xf) {
        sp00 = 0;
      }
    }

    //LAB_8091d0e
    final int r5_0 = FUN_8015390(sp00, r6._cc2.get(), r6._cc4.get(), 0);
    if(r5_0 != 0) {
      setActorAnimationIfLoaded(mapActorIndex, 0x4);
      FUN_8015100(r11);
      FUN_8015140();
      waitForActorAnimationToFinish(mapActorIndex, 0x4);
    } else {
      //LAB_8091d48
      setActorAnimationIfLoaded(mapActorIndex, 0x3);
      FUN_8015100(r11);
      FUN_8015140();
      waitForActorAnimationToFinish(mapActorIndex, 0x3);
    }

    //LAB_8091d62
    return r5_0;
  }

  @Method(0x8091d84)
  public static int FUN_8091d84(final int r0) {
    return FUN_8015390(r0, 0, 0, 0);
  }

  @Method(0x8091dc8)
  public static void FUN_8091dc8() {
    final Structccc r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    FUN_808fefc(r5._1c0.get(), r5._1c8.get());
    r5._1c6.set(0x1);
  }

  /** Called after confirming character names */
  @Method(0x8091df4)
  public static void FUN_8091df4() {
    final Structccc r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    FUN_80901c0(r5._1c0.get(), r5._1c8.get());
    r5._1c6.set(0);
  }

  @Method(0x8091e20)
  public static void FUN_8091e20() {
    sleep(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c8.get());
  }

  @Method(0x8091e3c)
  public static void setMapAndEntranceId(final int mapId, final int entranceId) {
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._170.set(999);
    mapId_2000400.set(mapId);
    entranceId_2000402.set(entranceId);
  }

  @Method(0x8091e9c)
  public static void FUN_8091e9c(final int r0) {
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._170.set(r0);
  }

  @Method(0x8091eb0)
  public static void startEncounter(final int encounterSet, final int encounterIndex) {
    final Structccc r7 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r7.encounterId_17c.set(getEncounterId(encounterSet, encounterIndex));

    if(encounterSet == 0x62 && encounterIndex == 0) {
      _2000416.set(33);
    }

    //LAB_8091ed8
    if(r7._19e.get() == 3) {
      FUN_808adf0(getMapActor(playerMapActorIndex_2000434.get()).pos_08);
    }

    //LAB_8091ef8
    FUN_808b320(encounterSet, encounterIndex);
  }

  @Method(0x8091f14)
  public static void FUN_8091f14(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r8().value);
    r3 = 0x3001ebc;
    r5 = 0x80;
    r3 = MEMORY.ref(4, r3).get();
    r5 = r5 << 4;
    CPU.r8().value = r3;
    r5 = r5 & r0;
    r3 = 0xff;
    r7 = r1;
    r0 = r0 & r3;
    if(r5 == 0x0) {
      FUN_809537c(r0);
    }

    //LAB_8091f34
    r1 = 0x96;
    r1 = r1 << 1;
    r6 = 0x2000240;
    r3 = r7 + r1;
    r1 = 0x8d;
    r1 = r1 << 2;
    r3 = r3 | r5;
    r2 = r6 + r1;
    MEMORY.ref(2, r2).setu(r3);
    r0 = r7;
    r0 = FUN_808b074(r0);
    r3 = 0xbe;
    r3 = r3 << 1;
    r3 = r3 + CPU.r8().value;
    MEMORY.ref(2, r3).setu(r0);
    r3 = 0xcf;
    r3 = r3 << 1;
    r3 = r3 + CPU.r8().value;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 == 0x3) {
      FUN_808adf0(getMapActor(playerMapActorIndex_2000434.get()).pos_08);
    }

    //LAB_8091f74
    FUN_808b320(0, 0);
    CPU.r8().value = CPU.pop();
  }

  @Method(0x8091f90)
  public static void FUN_8091f90(final int r0, final int r1) {
    _200040e.set(r0);
    _2000410.set(r1);
  }

  @Method(0x8091fa8)
  public static void FUN_8091fa8(final int r0, final int r1) {
    _2000412.set(r0);
    _2000414.set(r1);
  }

  @Method(0x8091ff0)
  public static void FUN_8091ff0(int r0) {
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).soundId_cc8.set(r0);

    if((short)r0 == -1) {
      r0 = 0x121;
    }

    //LAB_809200c
    playSound_(0x12a);
    playSound_(r0);
  }

  @Method(0x809202c)
  public static void FUN_809202c() {
    final int soundIndex = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).soundId_cc8.get();
    if(soundIndex != -1) {
      playSound_(soundIndex);
    }

    //LAB_8092046
  }

  @Method(0x8092054)
  public static Actor70 getMapActor_(final int actorIndex) {
    return getMapActor(actorIndex);
  }

  @Method(0x8092064)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      actor.velocityScalar_30.set(velocityScaler);
      actor.acceleration_34.set(acceleration);
    }

    //LAB_8092076
  }

  @Method(0x809207c)
  public static void FUN_809207c(final int mapActorIndex, final int spriteScript) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      actor._5a.or(0x1);
      FUN_8093a6c(actor, spriteScript);
    }

    //LAB_809209a
  }

  @Method(0x80920a0)
  public static void FUN_80920a0(final int mapActorIndex) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      actor._5a.or(0x1);
      FUN_8009140(actor);
    }

    //LAB_80920ba
  }

  @Method(0x80920c0)
  public static void FUN_80920c0(final int mapActorIndex0, final int mapActorIndex1) {
    final Actor70 r5 = getMapActor(mapActorIndex0);

    if(r5 != null) {
      r5.parent_68.set(getMapActor_(mapActorIndex1));
      FUN_8093a6c(r5, 0x809ff40);
    }

    //LAB_80920de
  }

  @Method(0x80920e8)
  public static void FUN_80920e8(final int actorIndex) {
    final Actor70 r0_0 = getMapActor(actorIndex);
    if(r0_0 != null) {
      FUN_8009148(r0_0);
    }

    //LAB_80920f6
  }

  @Method(0x80920fc)
  public static void FUN_80920fc(final int mapActorIndex, final int spriteScript) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      actor._5a.or(0x1);
      FUN_8093a6c(actor, spriteScript);
      FUN_8009148(actor);
    }

    //LAB_8092122
  }

  @Method(0x8092128)
  public static void FUN_8092128(final int mapActorIndex, final int x, final int z) {
    final Actor70 r5 = getMapActor(mapActorIndex);
    if(r5 != null) {
      r5._5b.set(0);
      FUN_8009140(r5);
      moveActorTo_(r5, x << 16, r5.pos_08.getY(), z << 16);
    }

    //LAB_8092150
  }

  @Method(0x8092158)
  public static void FUN_8092158(final int mapActorIndex, final int x, final int z) {
    final Actor70 r5 = getMapActor(mapActorIndex);
    if(r5 != null) {
      r5._5b.set(0);
      FUN_8009140(r5);
      moveActorTo_(r5, x << 16, r5.pos_08.getY(), z << 16);
      FUN_8009158(r5);
    }

    //LAB_8092186
  }

  @Method(0x809218c)
  public static void FUN_809218c(final int mapActorIndex, final int x, final int z) {
    final Actor70 r5 = getMapActor(mapActorIndex);
    if(r5 != null) {
      r5._5b.set(0);
      FUN_8009140(r5);
      setActorAnimation_(r5, 0x2);
      moveActorTo_(r5, x << 16, r5.pos_08.getY(), z << 16);
    }

    //LAB_80921bc
  }

  @Method(0x80921c4)
  public static void FUN_80921c4(final int mapActorIndex, final int x, final int z) {
    final Actor70 r5 = getMapActor(mapActorIndex);
    if(r5 != null) {
      r5._5b.set(0);
      FUN_8009140(r5);
      setActorAnimation_(r5, 0x2);
      moveActorTo_(r5, x << 16, r5.pos_08.getY(), z << 16);
      FUN_8009158(r5);
      setActorAnimation_(r5, 0x1);
    }

    //LAB_8092202
  }

  @Method(0x8092208)
  public static void FUN_8092208(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809228c)
  public static void FUN_809228c(final int mapActorIndex, final int x, final int z) {
    final Actor70 r5 = getMapActor(mapActorIndex);
    if(r5 != null) {
      r5._5b.set(0);
      FUN_8009140(r5);
      moveActorTo_(r5, r5.pos_08.getX() + (x << 16), r5.pos_08.getY(), r5.pos_08.getZ() + (z << 16));
    }
  }

  @Method(0x80923c4)
  public static void FUN_80923c4(final int mapActorIndex) {
    final Actor70 r5 = getMapActor(mapActorIndex);
    if(r5 != null) {
      FUN_8009158(r5);
      setActorAnimation_(r5, 1);
    }

    //LAB_80923dc
  }

  @Method(0x80923e4)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    final Actor70 r5 = getMapActor(mapActorIndex);
    if(r5 != null) {
      FUN_8009140(r5);
      r5.pos_08.setX(x);
      r5.pos_08.setZ(z);
      r5.velocity_24.zero();
      r5.dest_38.setX(0x80000000);
      r5.dest_38.setY(0x80000000);

      if((r5._55.get() & 0x1) != 0) {
        final int r0 = getHeight_(r5.layer_22.get(), x / 0x10000, z / 0x10000) << 16;
        r5.pos_08.y_04.sub(r5._14.get()).add(r0);
        r5._14.set(r0);
      }
    }

    //LAB_809244a
  }

  @Method(0x80924d4)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      setActorAnimation_(actor, animationIndex);
    }

    //LAB_80924e6
  }

  @Method(0x8092504)
  public static void waitForActorAnimationToChange(final int actorIndex) {
    final Actor70 actor = getMapActor(actorIndex);
    if(actor != null) {
      if(actor.spriteType_54.get() == 1) {
        final Sprite38 sprite = actor.sprite_50.deref();
        final int currentAnim = sprite.anim_24.get();

        int r5 = 0;
        sleep(0x1);

        //LAB_809252a
        while(currentAnim == sprite.anim_24.get()) {
          r5++;

          //LAB_809252c
          if(r5 >= 90) {
            break;
          }
          sleep(0x1);
        }
      }
    }

    //LAB_809253e
  }

  @Method(0x8092548)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    setActorAnimationIfLoaded(mapActorIndex, animationIndex);
    waitForActorAnimationToChange(mapActorIndex);
  }

  @Method(0x8092560)
  public static void FUN_8092560(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      actor._55.or(0x2);
      actor.velocity_24.setY(velocityY << 16);

      if(velocityY > 5) {
        playSound_(0x99);
      } else {
        //LAB_809258a
        playSound_(0x98);
      }

      //LAB_8092590
      FUN_809163c(sleepFrames);
    }

    //LAB_8092596
  }

  @Method(0x809259c)
  public static void FUN_809259c(final int mapActorIndex, final int r1) {
    final Actor70 r0_0 = getMapActor(mapActorIndex);
    if(r0_0 != null && r1 > 0) {
      //LAB_80925b2
      setActorSpriteScript_(r0_0, 0x809ebfc + (3 - Math.min(r1, 3)) * 0x80);
    }

    //LAB_80925c0
  }

  @Method(0x80925cc)
  public static void FUN_80925cc(final int mapActorIndex, final int r1) {
    FUN_809259c(mapActorIndex, r1);
    FUN_80920e8(mapActorIndex);
  }

  @Method(0x8092624)
  public static void FUN_8092624(final Actor70 r0, final int r1) {
    final Actor70 r6 = loadActor_(0xde, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());

    if(r6 != null) {
      if((rand() & 0x1) == 0x1) {
        setActorAnimation_(r6, 2);
        setActorSpriteScript_(r6, 0x809fbec);
      } else {
        //LAB_8092664
        setActorAnimation_(r6, 1);
        setActorSpriteScript_(r6, 0x809fc04);
      }

      //LAB_8092674
      if(r1 != 0) {
        FUN_80929d8(r6, r1);
      }

      //LAB_8092680
      final Sprite38 r5 = r6.sprite_50.deref();
      final Sprite38 r3 = r0.sprite_50.deref();
      r6._55.set(0);
      r6.acceleration_34.set(-(modU(rand(), 10) + 5 * 0x1999));
      r6.velocityScalar_30.set((modU(rand(), 15) - 7) * 2 * 0x1999);
      r6._64.set(0);
      r6._6c.set(getConsumer(GoldenSun_809.class, "FUN_80925e0", Actor70.class));
      r5._26.set(0);
      r5.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r3.packet_00.attribs_04.attrib2_04.get() & 0xc00);
    }

    //LAB_80926fc
  }

  @Method(0x8092708)
  public static void FUN_8092708(final int r0, final int r1, final int r2) {
    final Actor70 r6 = getMapActor_(r0);
    if(r6 != null) {
      playSound_(0x121);
      setActorAnimation_(r6, r1);
      sleep(10);
      setActorAnimation_(r6, 1);
      r6._55.or(0x2);
      r6.velocity_24.setY(0x40000);
      moveActorTo_(r6, r6.pos_08.getX(), r6.pos_08.getY(), r6.pos_08.getZ() + 0xc0000);
      sleep(6);
      playSound_(0xd9);
      FUN_8092adc(r0, 0x5000, 0);
      r6._55.set(0);

      //LAB_8092780
      for(int r5 = 0; r5 < 14; r5++) {
        final int r3 = r6.pos_08.getY() - 0x20000;
        r6.pos_08.setY(r3);
        r6.dest_38.setY(r3);
        sleep(1);

        if(r2 != -1 && (r5 & 0x1) != 0x0) {
          FUN_8092624(r6, r2);
        }

        //LAB_80927a8
      }

      r6._55.set(0x3);
      r6.velocity_24.setY(0x30000);
      moveActorTo_(r6, r6.pos_08.getX(), r6.pos_08.getY(), r6.pos_08.getZ() + 0x100000);
      FUN_8009158(r6);

      //LAB_80927d8
      for(int r5 = 0; r5 < 180 && r6.pos_08.getY() > r6._14.get(); r5++) {
        sleep(1);
      }

      //LAB_80927ec
      sleep(2);
      FUN_809202c();
    }

    //LAB_80927f6
  }

  @Method(0x809280c)
  public static void FUN_809280c(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    final Actor70 actor1 = getMapActor(mapActorIndex1);
    final Actor70 actor2 = getMapActor(mapActorIndex2);
    if(actor1 != null && actor2 != null) {
      actor1.angle_06.set(atan2(actor2.pos_08.getZ() - actor1.pos_08.getZ(), actor2.pos_08.getX() - actor1.pos_08.getX()));
      FUN_809163c(sleepFrames);
    }
  }

  @Method(0x8092848)
  public static void FUN_8092848(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    final Actor70 actor1 = getMapActor(mapActorIndex1);
    final Actor70 actor2 = getMapActor(mapActorIndex2);
    if(actor1 != null && actor2 != null) {
      FUN_8092878(actor1, actor2);
      FUN_809163c(sleepFrames);
    }

    //LAB_8092870
  }

  @Method(0x8092878)
  public static void FUN_8092878(final Actor70 r0, final Actor70 r1) {
    if(r0 != null && r1 != null) {
      final int angle = atan2(r1.pos_08.getZ() - r0.pos_08.getZ(), r1.pos_08.getX() - r0.pos_08.getX());
      int r4 = 0;

      //LAB_80928aa
      do {
        int r3 = (short)(angle - r0.angle_06.get());

        int r1_0 = 2;
        if(r3 != 0) {
          //LAB_80928cc
          r0.angle_06.add(MathHelper.clamp(r3, -0x1000, 0x1000));
        } else {
          //LAB_80928d2
          r1_0--;
        }

        //LAB_80928d4
        r3 = (short)(angle + 0x8000 - r1.angle_06.get());
        if(r3 != 0) {
          //LAB_80928f6
          r1.angle_06.add(MathHelper.clamp(r3, -0x1000, 0x1000));
        } else {
          //LAB_80928fc
          r1_0--;
        }

        //LAB_80928fe
        if(r1_0 == 0) {
          break;
        }

        sleep(0x1);
        r4++;
      } while(r4 < 60);
    }

    //LAB_8092912
  }

  @Method(0x8092924)
  public static void FUN_8092924(final int mapActorIndex) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      clearActor_(actor);
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).actors_14.get(mapActorIndex).clear();
    }
  }

  /** Something to do with going through the portal in the Sol Sanctum */
  @Method(0x8092950)
  public static void FUN_8092950(final int mapActorIndex, final int r1) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      if((r1 & 0x100) != 0) {
        actor._6c.set(getConsumer(GoldenSun_809.class, "FUN_8092980", Actor70.class));
      } else {
        //LAB_809296c
        actor._6c.clear();
        FUN_80929d8(actor, r1);
      }
    }

    //LAB_8092974
  }

  @Method(0x8092980)
  public static void FUN_8092980(final Actor70 actor) {
    if((actor.spriteType_54.get() & 0xf) == 1) {
      final Sprite38 r0 = actor.sprite_50.deref();
      final int r4 = MEMORY.ref(1, 0x809ed80 + (_3001e40.get() >>> 1 & 0x3)).getUnsigned();

      //LAB_80929b0
      for(int i = 0; i < r0.layerCount_27.get(); i++) {
        final SpriteLayer18 r2 = r0.layers_28.get(i).derefNullable();
        if(r2 != null && r2.dataPtr_10.get() != 0) {
          r2._05.set(r4);
        }

        //LAB_80929be
      }

      //LAB_80929c4
      r0._25.set(1);
    }
  }

  @Method(0x80929d8)
  public static void FUN_80929d8(final Actor70 r0, final int r1) {
    if((r0.spriteType_54.get() & 0xf) == 1) {
      final Sprite38 r12 = r0.sprite_50.deref();

      //LAB_80929fc
      for(int i = 0; i < r12.layerCount_27.get(); i++) {
        final SpriteLayer18 r2 = r12.layers_28.get(i).derefNullable();

        if(r2 != null && r2.dataPtr_10.get() != 0) {
          r2._05.set(r1);
        }

        //LAB_8092a0a
      }

      //LAB_8092a10
      r12._25.set(0x1);
    }

    //LAB_8092a18
  }

  @Method(0x8092a1c)
  public static void FUN_8092a1c(final int mapActorIndex1, final int mapActorIndex2AndFlags, final int r2) {
    final Actor70 actor1 = getMapActor(mapActorIndex1);
    final Actor70 actor2 = getMapActor(mapActorIndex2AndFlags & 0xff);
    if(actor1 != null && actor2 != null) {
      actor1.parent_68.set(actor2);

      if((mapActorIndex2AndFlags & 0x10000) == 0) {
        actor1._64.set(0x28);
        actor1.velocityScalar_30.set(actor2.velocityScalar_30.get());
        actor1.acceleration_34.set(actor2.acceleration_34.get() * 2);
        actor1._59.set(0);
      }

      //LAB_8092a5e
      setActorSpriteScript_(actor1, r2);
    }
  }

  @Method(0x8092a74)
  public static int FUN_8092a74(final Actor70 r0) {
    if(r0 == null) {
      return 0;
    }

    int r0_0 = (short)(r0._64.get() - r0.angle_06.get());

    if(r0_0 == 0) {
      return 0;
    }

    if(r0_0 > 0x1000) {
      r0_0 = 0x800;
    }

    //LAB_8092a9c
    if(r0_0 < -0x1000) {
      r0_0 = -0x800;
    }

    //LAB_8092aa4
    r0.angle_06.add(r0_0);

    //LAB_8092aa8
    return r0_0;
  }

  @Method(0x8092adc)
  public static void FUN_8092adc(final int mapActorIndex, final int r1, final int sleepFrames) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      actor._64.set(r1);
      setActorSpriteScript_(actor, 0x809fc1c);
      FUN_809163c(sleepFrames);
    }

    //LAB_8092afc
  }

  @Method(0x8092b08)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      if((actor.spriteType_54.get() & 0xf) == 1) {
        final int r5 = priority & 0x3;
        final Sprite38 r1_0 = actor.sprite_50.deref();
        r1_0.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r5 << 10);
        r1_0.shadowPacket_0c.attribs_04.attrib2_04.and(~0xc00).or(r5 << 10);
        actor.flags_23.and(0xfe);
      }
    }

    //LAB_8092b4e
  }

  @Method(0x8092b94)
  public static void FUN_8092b94(final int r0) {
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.set(r0);
  }

  @Method(0x8092ba8)
  public static int getMapActorSpriteDataIndex(final int mapActorIndex) {
    final Actor70 r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).actors_14.get(mapActorIndex & 0xfff).derefNullable();

    if(r2 == null || r2.spriteType_54.get() != 1) {
      return -1;
    }

    //LAB_8092bd2
    return r2.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get();
  }

  @Method(0x8092c40)
  public static Panel24 FUN_8092c40(final int mapActorIndex) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    final int r11;

    CPU.sp().value -= 0x40;

    final Struct12fc sp20 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r6 = mapActorIndex;
    final Structccc sp1c = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    Panel24 r10 = null;
    Panel24 r9 = null;
    int sp14 = 0;
    int sp10 = 0;
    int sp0c = 0x4;
    int sp18 = getMapActorSpriteDataIndex(r6);
    r11 = r6 & 0xf000;
    r6 = r6 & 0xfff;
    r8 = sp1c._1d8.get();
    Actor70 actor = getMapActor(r6);
    sp1c.actorIndex_1f4.set(r6);
    r5 = 0;
    r7 = 0;
    r4 = 0;
    if(sp1c._1cc.get() == 0) {
      //LAB_8092cb6
      if(actor != null) {
        if(sp1c._19e.get() == 3) {
          final Vec3 sp0x34 = new Vec3();
          FUN_8005268(actor.pos_08, sp0x34);
          r4 = sp0x34.getX() / 8;
          r5 = sp0x34.getY() / 8 - 2;
          r7 = 0x1;
        } else {
          //LAB_8092cde
          r5 = CPU.sp().value + 0x34;
          r7 = ~FUN_8094154(r6, r5) != 0 ? 1 : 0;
          r4 = MEMORY.ref(4, r5).get() / 8;
          r5 = MEMORY.ref(4, r5 + 0x4).get() / 8;
        }
        //LAB_8092ce6
      } else if(r6 < 8) {
        sp18 = r6;
        actor = getMapActor(playerMapActorIndex_2000434.get());
        if(sp1c._19e.get() == 3) {
          final Vec3 sp0x34 = new Vec3();
          FUN_8005268(actor.pos_08, sp0x34);
          r4 = sp0x34.getX() / 8;
          r3 = sp0x34.getY();
          r7 = 0x1;
        } else {
          //LAB_8092d1e
          r5 = CPU.sp().value + 0x34;

          //LAB_8092d24
          r7 = ~FUN_8094154(playerMapActorIndex_2000434.get(), r5) != 0 ? 1 : 0;
          r4 = MEMORY.ref(4, r5).get() / 8;
          r3 = MEMORY.ref(4, r5 + 0x4).get();
        }

        //LAB_8092d36
        r5 = r3 / 8;
      }

      //LAB_8092d38
      if(r7 == 0) {
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(0xf);
        r3 = 0xa;
      } else {
        //LAB_8092d44
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(0);
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(0);
        FUN_8015110(r8, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24);
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r4 - MEMORY.ref(4, CPU.sp().value + 0x28).get() / 2);

        if((r11 & 0x4000) != 0) {
          r3 = r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() - 0x1;
        } else {
          //LAB_8092d7e
          r3 = r11 >>> 15;
          if(r3 == 0 && r5 <= 8) {
            r3 = r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() - 0x1;
          } else {
            //LAB_8092d92
            r3 = r5 + 0x4;
          }
        }
      }

      //LAB_8092d94
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);

      if(sp20._ea4.get() != 0) {
        sp0c = 0x5;
      }

      //LAB_8092da6
      r6 = r4;
      if((r11 & 0x1000) != 0) {
        r6 = r6 - sp0c - 2;
        if(r6 < 0) {
          r6 = 0;
        }
      } else {
        //LAB_8092dc2
        if((r11 & 0x2000) != 0) {
          r6 = r6 - 2;
          if(r6 + sp0c > 0x1d) {
            r6 = 0x1d - sp0c;
          }
        } else {
          //LAB_8092dde
          if(r6 < 0x10) {
            r6 = r6 - sp0c - 2;
            if(r6 < 0) {
              r6 = r6 + 2;
            }
          } else {
            //LAB_8092df0
            r6 = r6 + 2;
            if(r6 + sp0c > 0x1d) {
              r6 = r6 - sp0c - 2;
            }
          }
        }
      }

      //LAB_8092dfe
      r7 = FUN_80151e0(sp18);
      if(r7 != -1) {
        r7 = CPU.sp().value + 0x24;
        FUN_8015110(r8, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r8 = -1;
        sp10 = r2 - 0x5;
        if(r2 <= r5) {
          sp10 = r2 + MEMORY.ref(4, CPU.sp().value + 0x24).get();
        }

        //LAB_8092e3e
        if(sp10 < 0) {
          sp10 = r2 + MEMORY.ref(4, CPU.sp().value + 0x24).get();
          //LAB_8092e4c
        } else if(sp10 + 0x5 > 0x13) {
          sp10 = r2 - 0x5;
        }

        //LAB_8092e58
        if(r2 < sp10) {
          r5 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          FUN_8015108(-1, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, r7);
          sp14 = r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() + 1;
        }
        //LAB_8092e80
      } else if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() < r5) {
        r5 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
        FUN_8015108(r8, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24);
        sp14 = r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() + 1;
        r8 = r7;
      }

      //LAB_8092ea2
      if(r6 < 0) {
        r6 = 0;
        //LAB_8092eaa
      } else if(r6 + sp0c > 0x1d) {
        r6 = 0x1d - sp0c;
      }

      //LAB_8092eb6
      if(sp20._ea4.get() != 0) {
        sleep(0x8);

        if(sp14 != 0) {
          r2 = sp14 + MEMORY.ref(4, CPU.sp().value + 0x2c).get() - 1;
          r3 = 0x12;
        } else {
          //LAB_8092edc
          r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = 0x2;
        }
      } else {
        //LAB_8092ee6
        final int r0_0 = FUN_80915ac(sp18);

        if(sp14 != 0) {
          r3 = r0_0 << 16 | 0x11;
          r2 = sp14 + MEMORY.ref(4, CPU.sp().value + 0x2c).get() - 1;
        } else {
          //LAB_8092f04
          r3 = r0_0 << 16 | 0x1;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        }

        //LAB_8092f0e
      }

      //LAB_8092f10
      r10 = FUN_8015038(r8, MEMORY.ref(4, CPU.sp().value + 0x30).get(), r2, r3);
      r9 = FUN_80150f8(sp18, 0, r6, sp10);

      //LAB_8092f34
      //LAB_8092f2e
      while(FUN_8015048() == 0) {
        sleep(1);
      }
    }

    //LAB_8092f3c
    sp1c._1f8.setNullable(r10);
    sp1c._1fc.setNullable(r9);
    sp1c._1d8.incr();

    CPU.sp().value += 0x40;

    return r10;
  }

  @Method(0x8092f84)
  public static void FUN_8092f84(final int mapActorIndex, final int r1) {
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Panel24 r10 = FUN_8092c40(mapActorIndex);
    sleep(0x1);
    int r8 = getMapActorSpriteDataIndex(mapActorIndex);
    if(mapActorIndex < 8) {
      final int r6 = mapActorIndex & 0xfff;
      if(FUN_808d394(r6) == 0) {
        r8 = r6;
      }
    }

    //LAB_8092fc0
    FUN_8015100(r8);

    if(r3._1cc.get() == 0) {
      //LAB_8092fd4
      int r5 = 0;
      while(FUN_8015050(r10) == 0) {
        sleep(0x1);
        r5++;
        if(r5 > 600) {
          FUN_8015140();
        } else if((heldButtonsLastFrame_3001ae8.get() & 0x4) != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x100) != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x200) != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x1) != 0) {
          //LAB_8093010
          FUN_8015140();
        }
      }
    }

    //LAB_809301e
    sleep(0x1);
  }

  @Method(0x8093040)
  public static void FUN_8093040(final int mapActorIndex, final int r1, final int sleepFrames) {
    FUN_8092f84(mapActorIndex, r1);
    FUN_809163c(sleepFrames);
  }

  @Method(0x8093054)
  public static int FUN_8093054(final int mapActorIndex, final int r1) {
    FUN_8092c40(mapActorIndex);

    final int r7 = FUN_8091c7c(playerMapActorIndex_2000434.get(), 0);
    if(r7 == 0) {
      FUN_8092f84(mapActorIndex, r1);
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
    } else {
      //LAB_809308e
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
      FUN_8092f84(mapActorIndex, r1);
    }

    //LAB_80930a6
    return r7;
  }

  @Method(0x80931ec)
  public static void FUN_80931ec(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5, final int a6, final int a7, final int a8, final int a9) {
    final Structccc r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final int r11 = getMapActorSpriteDataIndex(r0);
    final int r7 = getMapActorSpriteDataIndex(a5);

    final Panel24 r10 = FUN_8015038(r5._1d8.get(), r1, r2, FUN_80915ac(r11) << 16);
    r5._1d8.incr();
    FUN_80150f8(r11, 0, r3, a4);

    final Panel24 r8 = FUN_8015038(r5._1d8.get(), a6, a7, FUN_80915ac(r7) << 16);
    r5._1d8.incr();
    FUN_80150f8(r7, 0, a8, a9);

    //LAB_8093270
    //LAB_8093276
    while(FUN_8015048() == 0) {
      sleep(1);
    }

    //LAB_8093294
    do {
      sleep(1);
    } while((pressedButtons_3001c94.get() & 0x303) == 0);

    //LAB_80932a2
    sleep(1);
    FUN_8015100(r11);
    FUN_8015100(r7);
    FUN_8015140();

    //LAB_80932c0
    //LAB_80932c6
    do {
      sleep(1);
    } while(FUN_8015050(r10) == 0);

    //LAB_80932d2
    //LAB_80932d8
    while(FUN_8015050(r8) == 0) {
      sleep(1);
    }

    sleep(1);
  }

  @Method(0x8093304)
  public static void FUN_8093304(final int r0) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(r0 == 0x80000000) {
      r5._12f4.set(0);
      r5._12f6.set(0);
    } else {
      //LAB_809331e
      r5._12f4.set(FUN_80915ac(getMapActorSpriteDataIndex(r0)));
      r5._12f6.set(MEMORY.ref(1, 0x809fc28 + _200044c.get()).getUnsigned());
    }
  }

  @Method(0x809335c)
  public static void FUN_809335c(final int actorIndex, final int r1) {
    final Actor70 r6 = getMapActor(actorIndex);
    final Structccc r8 = MEMORY.ref(4, mallocSlotBoard(27, 0xccc), Structccc::new);

    if(r6 != null) {
      final Actor70 r5 = r8.actor_1e0.deref(); // This would be an NPE if slot 27 wasn't already allocated
      final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

      map._00.set(r5.pos_08);
      FUN_80090e0(r5, r6);

      if(r1 == 0) {
        r5.pos_08.set(r6.pos_08);
        sleep(1);

        if(r8._19e.get() != 0x3) {
          FUN_8009128();
        }
      }
    }

    //LAB_80933be
  }

  @Method(0x80933d4)
  public static void FUN_80933d4(final int velocityScalar, final int acceleration) {
    final Structccc addr = MEMORY.ref(4, mallocSlotBoard(27, 0xccc), Structccc::new);
    final Actor70 r3 = addr.actor_1e0.deref();
    r3.velocityScalar_30.set(velocityScalar);
    r3.acceleration_34.set(acceleration);
  }

  @Method(0x80933f8)
  public static void FUN_80933f8(final int x, final int y, final int z, final int r3) {
    int r6;
    int r7;
    final int r9;
    int r10;
    final int r11;

    r6 = x;
    r10 = y;
    r7 = z;
    final Structccc sp08 = MEMORY.ref(4, mallocSlotBoard(27, 0xccc), Structccc::new);
    final Actor70 r5 = sp08.actor_1e0.deref();
    final Map194 r1_0 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int sp04 = r1_0._ec.get() + 0x780000;
    final int sp00 = r1_0._f0.get() + r5.pos_08.getY() + 0x600000;
    r11 = r1_0._f4.get() - 0x780000;
    r9 = r1_0._f8.get() + r5.pos_08.getY() - 0x400000;
    r1_0._00.set(r5.pos_08);
    FUN_8009140(r5);

    if(r6 == -1) {
      r6 = r5.pos_08.getX();
    }

    //LAB_809347a
    if(r10 == -1) {
      r10 = r5.pos_08.getY();
    }

    //LAB_8093482
    if(r7 == -1) {
      r7 = r5.pos_08.getZ();
    }

    //LAB_8093488
    if(r6 < sp04) {
      r6 = sp04;
    }

    //LAB_8093490
    if(r7 < sp00) {
      r7 = sp00;
    }

    //LAB_8093498
    if(r6 > r11) {
      r6 = r11;
    }

    //LAB_809349e
    if(r7 > r9) {
      r7 = r9;
    }

    //LAB_80934a4
    if(r3 == 0) {
      r5.pos_08.set(r6, r10, r7);
      sleep(0x1);

      if(sp08._19e.get() != 3) {
        FUN_8009128();
      }
    } else {
      //LAB_80934d0
      moveActorTo_(r5, r6, r10, r7);
    }

    //LAB_80934dc
  }

  @Method(0x8093500)
  public static void FUN_8093500(final int mapActorIndex, final int r1) {
    final Actor70 r5 = getMapActor(mapActorIndex);
    mallocSlotBoard(27, 0xccc);

    if(r5 != null) {
      FUN_80933f8(r5.pos_08.getX(), -1, r5.pos_08.getZ(), r1);
    }
  }

  @Method(0x8093530)
  public static void FUN_8093530() {
    FUN_8009158(MEMORY.ref(4, mallocSlotBoard(27, 0xccc), Structccc::new).actor_1e0.deref());
    FUN_809163c(2);
  }

  @Method(0x8093554)
  public static Actor70 FUN_8093554() {
    return MEMORY.ref(4, mallocSlotBoard(27, 0xccc), Structccc::new).actor_1e0.deref();
  }

  @Method(0x80935d4)
  public static int FUN_80935d4() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;
    final int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001e70;
    r1 = 0xccc;
    r0 = 0x1b;
    r7 = MEMORY.ref(4, r3).get();
    r0 = mallocSlotBoard(r0, r1);
    r1 = 0xf0;
    r1 = r1 << 1;
    r0 = r0 + r1;
    r3 = MEMORY.ref(4, r0).get();
    r3 = r3 + 0x5b;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.r10().value = r3;
    if(r3 == 0x0) {
      r2 = 0xd6;
      r2 = r2 << 2;
      r2 = r2 + r7;
      r0 = 0x0;
      r3 = MEMORY.ref(2, r2 + r0).get();
      CPU.r8().value = r2;
      if(r3 != 0x0) {
        r1 = 0xd4;
        r2 = 0xd5;
        r1 = r1 << 2;
        r2 = r2 << 2;
        r6 = r7 + r1;
        r3 = r7 + r2;
        r2 = MEMORY.ref(4, r3).get();
        r3 = MEMORY.ref(4, r6).get();
        r2 = r2 - r3;
        r3 = 0x35a;
        r5 = r7 + r3;
        r3 = MEMORY.ref(2, r5).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(2, r5).setu(r3);
        r3 = r3 << 16;
        r3 = r3 >> 16;
        r0 = r3;
        r0 = r0 * r2;
        r3 = CPU.r8().value;
        r2 = 0x0;
        r1 = MEMORY.ref(2, r3 + r2).get();
        r0 = divideS(r0, r1);
        r2 = r0;
        r0 = 0xd2;
        r1 = MEMORY.ref(4, r6).get();
        r0 = r0 << 2;
        r3 = r7 + r0;
        r4 = 0x3000118;
        r0 = MEMORY.ref(4, r3).get();
        r1 = r1 + r2;
        r0 = (int)MEMORY.call(r4, r0, r1);
        r1 = 0xd3;
        r1 = r1 << 2;
        r3 = r7 + r1;
        MEMORY.ref(4, r3).setu(r0);
        r0 = 0x8c;
        r0 = r0 << 1;
        r3 = r7 + r0;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r2 = 0x3001af4;
        r3 = r3 + 0x1;
        MEMORY.ref(4, r2).setu(r3);
        r1 = 0x0;
        r2 = MEMORY.ref(2, r5 + r1).get();
        r1 = CPU.r8().value;
        r0 = 0x0;
        r3 = MEMORY.ref(2, r1 + r0).get();
        if(r2 == r3) {
          r2 = CPU.r10().value;
          r3 = CPU.r8().value;
          MEMORY.ref(2, r3).setu(r2);
          r0 = clearTickCallback(getRunnable(GoldenSun_809.class, "FUN_80935d4"));
        }
      }
    }

    //LAB_809367c
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    return r0;
  }

  @Method(0x80936a0)
  public static void FUN_80936a0(final int r0, final int r1) {
    final int r5 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    final int r0_0 = mallocSlotBoard(27, 0xccc);
    if(MEMORY.ref(2, r0_0 + 0x19e).get() == 3) {
      final int r0_1 = FUN_300013c(r0, 0x10000);
      MEMORY.ref(4, r5 + 0x350).setu(MEMORY.ref(4, r5 + 0x354).get());
      MEMORY.ref(4, r5 + 0x354).setu(r0_1);
      MEMORY.ref(2, r5 + 0x358).setu(r1);
      MEMORY.ref(2, r5 + 0x35a).setu(0);
      setTickCallback(getRunnable(GoldenSun_809.class, "FUN_80935d4"), 0xc94);
    }
  }

  @Method(0x8093710)
  public static void FUN_8093710() {
    final int r6 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    final int r0 = mallocSlotBoard(27, 0xccc);
    if(MEMORY.ref(2, r0 + 0x19e).get() == 3) {
      //LAB_8093742
      for(int r5 = 0; r5 < 300 && MEMORY.ref(2, r6 + 0x358).get() != 0; r5++) {
        sleep(1);
      }
    }
  }

  @Method(0x809376c)
  public static int FUN_809376c(final Actor70 r0) {
    final Actor70 r6 = r0.parent_68.derefNullable();
    if(r6 != null) {
      r0._55.set(0);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.setY(r6.pos_08.getY() + MEMORY.ref(1, getSpriteData(MEMORY.ref(2, FUN_808d394(r0._66.get())).get()) + 0x8).get() * 0x10000 + 0x80000);
      r0.pos_08.setZ(r6.pos_08.getZ());
      r0._14.set(r6._14.get());
    }

    //LAB_80937b0
    return 0;
  }

  @Method(0x80937b8)
  public static void FUN_80937b8(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    if((animationAndFlags & 0xff) == 6) {
      playSound_(0x6e);
    }

    //LAB_80937d4
    final Actor70 r6 = getMapActor(mapActorIndex);
    if(r6 != null) {
      final Actor70 r5 = loadActor_(21, r6.pos_08.getX(), r6.pos_08.getY(), r6.pos_08.getZ());
      if(r5 != null) {
        setActorSpriteScript_(r5, 0x809fc2c);
        setActorAnimation_(r5, animationAndFlags & 0xf);
        r5._55.set(0);
        r5._64.set(0);
        r5._66.set(mapActorIndex);
        r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_809376c", Actor70.class));
        r5.parent_68.set(r6);

        final Sprite38 sprite = r5.sprite_50.deref();
        sprite._26.set(0);

        if((animationAndFlags & 0x100) != 0) {
          sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
        } else {
          //LAB_809384c
          sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r6.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
        }
      }

      //LAB_8093860
      FUN_809163c(sleepFrames);
    }

    //LAB_8093866
  }

  @Method(0x8093874)
  public static void FUN_8093874(final int mapActorIndex, final int r1) {
    final Actor70 r7 = getMapActor(mapActorIndex);
    Actor70 r5 = null;
    if(r7 != null) {
      if((r1 & 0x3) != 0) {
        if((r1 & 0x3) == 2 || r7.parent_68.isNull()) {
          //LAB_80938a2
          r5 = loadActor_(209, r7.pos_08.getX(), r7.pos_08.getY(), r7.pos_08.getZ());
        }

        //LAB_80938c2
        if(r5 != null) {
          if((r1 & 0x3) == 1) {
            //LAB_80938d6
            setActorAnimation_(r5, 0x1);
            r7.parent_68.set(r5);
            r5._64.set(0x1);
          } else if((r1 & 0x3) == 2) {
            //LAB_80938e8
            setActorAnimation_(r5, 0x2);
            setActorSpriteScript_(r5, 0x809fd38);
            r5._64.set(0x1);
          }

          //LAB_8093900
          r5._66.set(mapActorIndex);
          r5._55.set(0);
          r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_809376c", Actor70.class));
          r5.parent_68.set(r7);

          final Sprite38 r6 = r5.sprite_50.deref();
          r6._26.set(0);

          if((r1 & 0x100) != 0) {
            r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
          } else {
            //LAB_8093944
            r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r7.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
          }
        }
      } else {
        //LAB_80938b2
        r5 = r7.parent_68.derefNullable();
        if(r5 != null) {
          clearActor_(r5);
          r7.parent_68.clear();
        }
      }
    }

    //LAB_8093958
  }

  @Method(0x8093964)
  public static int FUN_8093964(final Actor70 r0) {
    FUN_80091e0(r0, 0);
    r0._59.set(0);
    return 0;
  }

  @Method(0x8093a6c)
  public static void FUN_8093a6c(final Actor70 actor, int spriteScript) {
    switch(spriteScript) {
      case 1 -> spriteScript = 0x809fe00;
      case 2 -> spriteScript = 0x809fd44;
      case 3 -> spriteScript = 0x809fe10;
      case 4 -> spriteScript = 0x809fecc;
      case 5 -> spriteScript = 0x809ff18;
      case 6 -> {
        actor.parent_68.set(getMapActor_(playerMapActorIndex_2000434.get()));
        spriteScript = 0x809ff2c;
      }
      case 7 -> spriteScript = 0x809fe04;
    }

    //LAB_8093ac6
    setActorSpriteScript_(actor, spriteScript);
  }

  /** triggers when jumping over gaps */
  @Method(0x8093af8)
  public static Actor70 FUN_8093af8(final Actor70 r0, final int r1) {
    final ArrayRef<Actor70> actors = boardWramMallocHead_3001e50.offset(5 * 0x4).deref(4).cast(ArrayRef.of(Actor70.class, 64, 0x70, Actor70::new));
    Actor70 r10 = null;

    //LAB_8093b1a
    int r9 = 40;
    for(int r8 = 0; r8 < 64; r8++) {
      final Actor70 r5 = actors.get(r8);
      if(r5.scriptPtr_00.get() != 0 && r5.getAddress() != r0.getAddress()) {
        if(r5.spriteType_54.get() == 1) {
          //LAB_8093b40
          if(Math.abs(r5.pos_08.getY() - r0.pos_08.getY()) <= 0x2fffff) {
            //LAB_8093b48
            final int dx = r5.pos_08.getX() - r0.pos_08.getX() / 0x10000;
            final int dz = r5.pos_08.getZ() - r0.pos_08.getZ() / 0x10000;
            final int r6 = sqrt(dx * dx + dz * dz);
            if(r6 < r9) {
              if(r6 <= 0x17) {
                r10 = r5;
                r9 = r6;
              } else {
                final int angle = atan2(r5.pos_08.getZ() - r0.pos_08.getZ(), r5.pos_08.getX() - r0.pos_08.getX()) - r0.angle_06.get();
                if(angle >= -0x2fff && angle <= 0x2fff) {
                  //LAB_8093bae
                  r10 = r5;
                  r9 = r6;
                }
              }
            }
          }
        }
      }

      //LAB_8093bb2
    }

    if(r10 == null || r10.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get() != r1) {
      return null;
    }

    //LAB_8093bd8
    return r10;
  }

  /** triggers when jumping over gaps */
  @Method(0x8093c00)
  public static int FUN_8093c00() {
    final Actor70 r6 = getMapActor_(playerMapActorIndex_2000434.get());
    final int r9 = (r6.angle_06.get() & 0xffff) + 0x2000 & 0xc000;
    final int sp00 = r6._55.get();
    final int r10 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    int r11 = 1;
    final Vec3 r7 = new Vec3();

    //LAB_8093c4c
    do {
      r7.setX((r6.pos_08.getX() & 0xfff00000) + 0x80000);
      r7.setY(r6.pos_08.getY());
      r7.setZ((r6.pos_08.getZ() & 0xfff00000) + 0x80000);
      rotVec3(0x100000, r9, r7);

      if(FUN_80091d8(r6, r7) == 0x1) {
        return -1;
      }

      //LAB_8093c84
      r7.setX((r6.pos_08.getX() & 0xfff00000) + 0x80000);
      r7.setY(r6.pos_08.getY());
      r7.setZ((r6.pos_08.getZ() & 0xfff00000) + 0x80000);
      rotVec3(0x200000, r9, r7);

      if(FUN_80091d8(r6, r7) != 0) {
        return -1;
      }

      //LAB_8093cb6
      if(r6.spriteType_54.get() == 1) {
        r11 = r6.sprite_50.deref()._26.get();
      }

      //LAB_8093cc8
      FUN_80916b0();
      setActorAnimation_(r6, 6);
      sleep(6);
      playSound_(0x98);
      setActorAnimation_(r6, 7);
      r6.velocityScalar_30.set(0x30000);
      r6.acceleration_34.set(0x20000);
      r6.velocity_24.setY(0x40000);
      r6._55.and(0x7e);
      FUN_80091e0(r6, r11 & 0xfe);
      FUN_8092158(playerMapActorIndex_2000434.get(), r7.getX() >> 16, r7.getZ() >> 16);
      setActorAnimation_(r6, 6);
      FUN_80091e0(r6, r11);

      Actor70 r0;
      if((r0 = FUN_8093af8(r6, 0xcf)) != null || (r0 = FUN_8093af8(r6, 0xcd)) != null) {
        //LAB_8093d50
        setActorAnimation_(r0, 7);
        r6.pos_08.y_04.sub(0x10000);
        r6._14.sub(0x10000);
        sleep(2);
        r6.pos_08.y_04.sub(0x10000);
        r6._14.sub(0x10000);
        sleep(10);
        r6.pos_08.y_04.add(0x10000);
        r6._14.add(0x10000);
        sleep(4);
        r6.pos_08.y_04.add(0x10000);
        r6._14.add(0x10000);
      } else {
        //LAB_8093da0
        sleep(6);
      }

      //LAB_8093da6
      r6._55.set(sp00);
      FUN_8091750();

      if(r10 != 0x0) {
        MEMORY.ref(4, r10 + 0x1b4).addu((int)MEMORY.call(0x3000118, MEMORY.ref(4, r10 + 0x1b0).get(), 0x200000));
      }

      //LAB_8093dd8
      if(getTileType_(r6.layer_22.get(), r7.getX(), r7.getZ()) != 0xf9) {
        break;
      }

      setActorAnimation_(r6, 1);
      sleep(6);
    } while(true);

    //LAB_8093dfa
    //LAB_8093dfe
    //LAB_8093e00
    return 0;
  }

  /** triggers when jumping over gaps */
  @Method(0x8093e28)
  public static int FUN_8093e28() {
    final int r2;
    int r3;
    final int r5;
    int r7;
    final int r9;
    final int r10;

    final Actor70 r6 = getMapActor_(playerMapActorIndex_2000434.get());
    r5 = r6.pos_08.getX() >> 16 & 0xfff0;
    r7 = r6.pos_08.getZ() >> 16 & 0xfff0;
    r10 = 0x8 + r5;
    r9 = 0x8 + r7;
    FUN_80916b0();
    r3 = _2000432.get();
    if(r3 == 0x0) {
      r3 = r10;
      if(r3 < 0x0) {
        r3 = r5 + 0x17;
      }

      //LAB_8093e82
      r2 = r3 >> 4;
      r3 = r9;
      if(r3 < 0x0) {
        r3 = r7 + 0x17;
      }

      //LAB_8093e8e
      r3 = r3 >> 4;
      r3 = r3 << 7;
      r3 = r2 + r3;
      if(tileAttribs_2010000.get(r3).getType() != tileAttribs_2010000.get(r3 + 0x80).getType()) {
        //LAB_8093f72
        FUN_8091750();
        return -1;
      }

      final Vec3 r0 = new Vec3();
      r0.setX(r6.pos_08.getX());
      r0.setY(r6.pos_08.getY() - 0x100000);
      r0.setZ(r6.pos_08.getZ());
      r7 = FUN_8009220(r0);
      if(r7 != 0x0) {
        //LAB_8093f72
        FUN_8091750();
        return -1;
      }
      FUN_8092158(playerMapActorIndex_2000434.get(), r10, r9);
      r6.velocityScalar_30.set(0x10000);
      FUN_8092adc(playerMapActorIndex_2000434.get(), 0xc000, 0);
      FUN_80920e8(playerMapActorIndex_2000434.get());
      r6._5a.set(0x1);
      r6._55.set(r7);
      FUN_80091e0(r6, 0);
      setActorAnimation_(r6, 13);
      moveActorTo_(r6, r10 << 16, r6.pos_08.getY() - 0x100000, (r9 << 16) + 0x100000);
      FUN_80923c4(playerMapActorIndex_2000434.get());
      _2000432.set(0x1);
    } else {
      //LAB_8093f2e
      setActorAnimation_(r6, 10);
      r6._55.set(0x3);
      r6.velocity_24.setY(0x40000);
      r6._14.set(r6.pos_08.getY());
      FUN_80091e0(r6, 1);
      FUN_809163c(6);
      r6._5a.set(0x1);
      r6.angle_06.set(0xc000);
      _2000432.set(0);
    }

    //LAB_8093f6a
    FUN_8091750();

    //LAB_8093f7a
    return 0;
  }

  /** triggers when jumping over gaps */
  @Method(0x8093fa0)
  public static int FUN_8093fa0() {
    final int r2;
    int r3;
    final int r5;
    final int r6;
    final int r8;
    final int r10;
    int r11;

    final Actor70 r7 = getMapActor_(playerMapActorIndex_2000434.get());
    r5 = r7.pos_08.getX() >> 16 & 0xfff0;
    r6 = r7.pos_08.getZ() >> 16 & 0xfff0;
    r11 = 0x1;
    r8 = 0x8 + r5;
    r10 = 0x8 + r6;
    FUN_80916b0();
    if(r7.spriteType_54.get() == 0x1) {
      r11 = r7.sprite_50.deref()._26.get();
    }

    //LAB_8093ff2
    if(_2000432.get() == 0x0) {
      r3 = r8;
      if(r3 < 0x0) {
        r3 = r5 + 0x17;
      }

      //LAB_809400a
      r2 = r3 >> 4;
      r3 = r10;
      if(r3 < 0x0) {
        r3 = r6 + 0x17;
      }

      //LAB_8094016
      r3 = r3 >> 4;
      r3 = r3 << 7;
      r3 = r2 + r3;
      if(tileAttribs_2010000.get(r3).getType() != tileAttribs_2010000.get(r3 - 0x80).getType()) {
        //LAB_8094138
        FUN_8091750();
        return -1;
      }

      //LAB_8094030
      final Vec3 r0 = new Vec3();
      r0.set(r7.pos_08);
      if(FUN_8009220(r0) != 0) {
        //LAB_8094138
        FUN_8091750();
        return -1;
      }

      r7._5a.set(0);
      FUN_8092158(playerMapActorIndex_2000434.get(), r8, r10);
      setActorAnimation_(r7, 6);
      sleep(4);
      setActorAnimation_(r7, 7);
      r7.velocity_24.setY(0x40000);
      sleep(4);
      r7._55.set(0);
      FUN_80091e0(r7, r11 & 0xfe);
      r7.velocityScalar_30.set(0x10000);
      r7.velocity_24.setY(0);
      setActorAnimation_(r7, 12);
      sleep(4);
      _2000432.set(0x1);
      r7._5a.set(0x1);
      sleep(8);
    } else {
      //LAB_80940b8
      r7._55.set(0);
      setActorAnimation_(r7, 11);
      moveActorTo_(r7, r8 << 16, r7.pos_08.getY() + 0x80000, (r10 << 16) - 0x100000);
      FUN_80923c4(playerMapActorIndex_2000434.get());
      r7._55.set(0x3);
      r7._14.set(r7.pos_08.getY());
      FUN_80091e0(r7, r11 | 0x1);
      FUN_809163c(0x4);
      _2000432.set(0);
      r7._5a.set(0x1);
    }

    //LAB_8094112
    FUN_8091750();

    //LAB_8094140
    return 0;
  }

  @Method(0x8094154)
  public static int FUN_8094154(final int actorIndex, final int r1) {
    final Actor70 r4 = getMapActor(actorIndex);
    if(r4 == null) {
      return -1;
    }

    //LAB_8094168
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int dx = r4.pos_08.getX() - (r3._e4.get() & 0xffff0000);
    final int dz = r4.pos_08.getZ() - (r3._e8.get() & 0xffff0000);
    final int r6 = dz - r4.pos_08.getY();
    MEMORY.ref(4, r1).setu(dx / 0x10000);
    MEMORY.ref(4, r1 + 0x4).setu(r6 / 0x10000);

    if((r4.spriteType_54.get() & 0xf) == 1) {
      final int spriteData = getSpriteData(r4.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get());
      MEMORY.ref(4, r1 + 0x4).subu(MEMORY.ref(1, spriteData + 0x8).get());
    }

    //LAB_80941c6
    //LAB_80941c8
    return 0;
  }

  @Method(0x80941e0)
  public static void FUN_80941e0() {
    int r5;

    final Structccc struct = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    playSound_(_200042e.get());
    playSound_(0x120);
    playSound_(0x93);

    if(struct._19e.get() == 3) {
      MEMORY.ref(2, 0x50001e6).setu(0x7fff);
      FUN_80901c0(0x401, 0x10);
      struct._1c6.set(0);
      sleep(16);
      int r7 = 0x7800;
      int r1 = 0x3c0;
      int r6 = 0x1e;

      //LAB_8094242
      for(r5 = 0; r5 < 0x10; r5++) {
        MEMORY.ref(2, 0x50001e6).setu(r7 | r1 | r6);
        sleep(1);
        r7 -= 0x800;
        r1 -= 0x40;
        r6 -= 0x2;
      }
    } else {
      //LAB_8094266
      MEMORY.ref(2, 0x5000000).setu(0x7fff);
      FUN_80901c0(0x207, 0x10);
      struct._1c6.set(0);
      sleep(16);
      int r7 = 0x7800;
      int r2 = 0x3c0;
      int r6 = 0x1e;

      //LAB_8094294
      for(r5 = 0; r5 < 0x10; r5++) {
        MEMORY.ref(2, 0x5000000).setu(r7 | r2 | r6);
        sleep(1);
        r7 -= 0x800;
        r2 -= 0x40;
        r6 -= 0x2;
      }
    }

    //LAB_80942b6
  }

  @Method(0x80942e0)
  public static void FUN_80942e0(final int r0) {
    final Actor70 r5 = getMapActor(playerMapActorIndex_2000434.get());
    final Sprite38 r6 = r5.sprite_50.deref();
    final SpriteLayer18 r0_0 = addLayerToSprite_(r6, 0x1b);
    r6._26.set(0);
    r0_0._05.set(0xf);
    r5.pos_08.x_00.and(0xfff00000).add(0x80000);
    r5.pos_08.z_08.and(0xfff00000).add(0x100000);
    r5.velocity_24.setX(0);
    r5.velocity_24.setZ(0);
    r5.dest_38.setX(0x80000000);
    r5.dest_38.setZ(0x80000000);
    setActorAnimation_(r5, r0);
    sleep(18);
  }

  @Method(0x8094354)
  public static void FUN_8094354() {
    FUN_80942e0(0x1a);
    setFlag_(0x120);
  }

  @Method(0x8094368)
  public static void FUN_8094368() {
    FUN_80942e0(0x19);
    setFlag_(0x121);
  }

  @Method(0x8094380)
  public static void FUN_8094380(int r0) {
    int r1;
    final int r2;
    int r3;
    int r6;

    r6 = r0;
    final Actor70 r5 = getMapActor(playerMapActorIndex_2000434.get());
    final Sprite38 r8 = r5.sprite_50.deref();
    addLayerToSprite(r8, 27)._05.set(0xf);
    r8._26.set(0);
    r5.pos_08.x_00.and(0xfff00000).add(0x80000);
    r3 = r5.pos_08.getZ();
    r3 = r3 & 0xfff00000;
    r1 = r6;
    r5.pos_08.setZ(r3);
    setActorAnimation_(r5, r1);
    r0 = 0x1e;
    sleep(r0);
    r6 = 0x1;
    r8.layerCount_27.set(r6);
    clearSpriteLayer(r8.layers_28.get(1).deref());
    r8.layers_28.get(1).clear();
    r8._26.set(r6);
    r3 = 0x80;
    r3 = r3 << 9;
    r5.acceleration_34.set(r3);
    r5.velocityScalar_30.set(r3);
    r1 = r5.pos_08.getX();
    r2 = r5.pos_08.getY();
    r3 = r5.pos_08.getZ();
    r3 = r3 + 0x80000;
    moveActorTo(r5, r1, r2, r3);
    FUN_800ca6c(r5);
  }

  /** Called in Crossbone Isle */
  @Method(0x8094428)
  public static int FUN_8094428() {
    int r0;
    int r6;

    r6 = 0x0;
    r0 = readFlag_(0x120);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_8094380(0x18);
      clearFlag_(0x120);
      r6 = 0x1;
    } else {
      //LAB_809444a
      r0 = readFlag_(0x121);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_8094380(0x17);
        clearFlag_(0x121);
        r6 = 0x2;
      } else {
        //LAB_8094466
        r0 = readFlag_(0x122);
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          clearFlag_(0x122);
          final Actor70 r5 = getMapActor(playerMapActorIndex_2000434.get());
          r5.pos_08.y_04.add(0xa00000);
          FUN_80933f8(-1, -1, -1, 0);

          //LAB_80944a6
          while(r5.pos_08.getY() + r5.velocity_24.getY() > r5._14.get()) {
            sleep(1);
          }

          playSound_(0x9f);
          r5.pos_08.setY(r5._14.get());
          setActorAnimation_(r5, 22);
          FUN_809163c(0xf);
          FUN_809335c(playerMapActorIndex_2000434.get(), 1);
          r6 = 0x3;
        }
      }
    }

    //LAB_80944da
    r0 = r6;
    return r0;
  }

  @Method(0x8094820)
  public static void FUN_8094820() {
    final Map194 r10 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int r8 = boardWramMallocHead_3001e50.offset(29 * 0x4).get();
    final int sp08 = r10._e4.get();
    final int sp04 = r10._e8.get();

    //LAB_8094852
    for(int r9 = 0; r9 < 32; r9++) {
      final int r7 = r8 + 0x8 + r9 * 0x20;
      MEMORY.ref(2, r7 + 0x1c).decr();

      if(MEMORY.ref(2, r7 + 0x1c).getUnsigned() != 0xffff) {
        //LAB_8094864
        if(readFlag_(0x166) != 0) {
          MEMORY.ref(2, r7 + 0x1c).incr();
        }

        //LAB_8094876
        int r4 = 0x0809ef84 + MEMORY.ref(2, r7 + 0x1c).getUnsigned() * 0xa;
        final int r1 = MEMORY.ref(2, r4).get() + (MEMORY.ref(4, r7 + 0xc).get() - sp08) / 0x10000;
        r4 = r4 + 0x2;
        final int r0 = MEMORY.ref(2, r4).get() + (MEMORY.ref(4, r7 + 0x14).get() - MEMORY.ref(4, r7 + 0x10).get() - sp04) / 0x10000;
        r4 = r4 + 0x2;
        CPU.cmpT(r1 + 0x10, 0xff);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          if(r0 >= -32 && r0 < 0xa0) {
            MEMORY.ref(1, r7 + 0x9).and(~0xc).oru(0x4);
            MEMORY.ref(2, r7 + 0x6).and(~0x1ff).oru(r1 & 0x1ff);
            MEMORY.ref(1, r7 + 0x4).setu(r0);
            MEMORY.ref(2, r7 + 0x8).and(~0x3ff).oru(MEMORY.ref(4, r8 + 0x4).get() + MEMORY.ref(2, r4).getUnsigned() & 0x3ff);
            MEMORY.ref(1, r7 + 0x5).and(0x3f).oru(MEMORY.ref(1, r4 + 0x2).getUnsigned() * 64);
            MEMORY.ref(1, r7 + 0x7).and(0x3f).oru(MEMORY.ref(1, r4 + 0x4).getUnsigned() * 64);
            insertIntoRenderQueue(MEMORY.ref(4, r7, RenderPacket0c::new), 0xf0);
          }
        }

        //LAB_8094946
        if(MEMORY.ref(2, r7 + 0x1c).getUnsigned() == 0) {
          final Vec3 r6 = r10._00.deref();
          MEMORY.ref(4, r7 + 0xc).setu(r6.getX() + rand() * 0x100 - 0x800000);
          MEMORY.ref(4, r7 + 0x14).setu(r6.getZ() + rand() * 0x100 - 0x800000);
          MEMORY.ref(4, r7 + 0x10).setu(getHeight_(0, MEMORY.ref(4, r7 + 0xc).get() >> 16, MEMORY.ref(4, r7 + 0x14).get() >> 16) << 16);
          MEMORY.ref(2, r7 + 0x1c).setu(0x10);
        }
      }

      //LAB_8094984
    }

    //LAB_8094992
  }

  @Method(0x80949a8)
  public static void tickLightning() {
    final LightningStruct1f88 r6 = boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).cast(LightningStruct1f88::new);
    final PaletteStruct2a04 r7 = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);

    if(r6.ticksRemaining_1f80.get() >= 0) {
      if(readFlag_(0x166) != 0) {
        r6.ticksRemaining_1f80.set(0x80);
      }

      //LAB_80949ce
      final int ticksRemaining = r6.ticksRemaining_1f80.get();
      r6.ticksRemaining_1f80.decr();

      switch(ticksRemaining) {
        case 0:
          if(r6.repeat_1f82.get()) {
            r6.ticksRemaining_1f80.set((rand() * 400 >>> 16) - (rand() * 100 >>> 16) + 150);
            if(r6.quiet_1f84.get()) {
              playSound_(0xac);
            } else {
              //LAB_8094a5c
              playSound_(0xab);
            }
          }

        case 5:
        case 10:
          //LAB_8094a62
          FUN_8091200(r6.dest_0000.getAddress(), 1);
          DMA.channels[3].SAD.setu(r6.step_1500.getAddress());
          DMA.channels[3].DAD.setu(r7.step_1880.getAddress());
          DMA.channels[3].CNT.setu(0x840002a0);

          r7.totalTicks_2a01.set(12);
          r7.currentTicks_2a02.set(0);
          break;

        case 1:
        case 6:
        case 11:
          // Brightens scene
          FUN_8091200(r6.current_0a80.getAddress(), 1);
          r7.totalTicks_2a01.set(1);
          r7.currentTicks_2a02.set(0);
          break;
      }
    }

    //LAB_8094aa2
  }

  @Method(0x8094ac8)
  public static void allocateRain() {
    CPU.sp().value -= 0x4;

    final int r5 = mallocSlotBoard(29, 0x410);
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Vec3 r8 = r3._00.deref();
    FUN_8091ff0(0xaa);
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x85000104);

    final int r6 = mallocSlotBoard(14, 0x400);
    FUN_80053e8(0x809ff58, r6);

    final int slot = getFreeVramSlot();
    MEMORY.ref(4, r5).setu(slot);
    MEMORY.ref(4, r5 + 0x4).setu(allocateSpriteSlot(slot, 0x300, r6));
    freeSlot(14);

    //LAB_8094b2c
    for(int i = 0; i < 32; i++) {
      final int r7 = r5 + 0x8 + i * 0x20;
      MEMORY.ref(4, r7).setu(0);
      MEMORY.ref(4, r7 + 0x4).setu(0x40000400);
      MEMORY.ref(4, r7 + 0x8).setu(0xd400);
      final int x = r8.getX();
      final int z = r8.getZ();
      MEMORY.ref(4, r7 + 0xc).setu(x);
      MEMORY.ref(4, r7 + 0x14).setu(z);
      MEMORY.ref(4, r7 + 0x10).setu(getHeight_(0, x >> 16, z >> 16) << 16);
      MEMORY.ref(2, r7 + 0x1c).setu((i & 0xf) + 1);
    }

    GPU.BLDCNT.setu(0x3f00);
    GPU.BLDALPHA.setu(0x1008);
    GPU.BLDY.setu(0);
    setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8094820"), 0xc80);

    CPU.sp().value += 0x4;
  }

  @Method(0x8094e7c)
  public static void FUN_8094e7c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);
    r7 = CPU.r8().value;
    CPU.push(r7);
    r3 = 0x3001ec4;
    r0 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x1c;
    r1 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
    r3 = r3 - 0x54;
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    r3 = r3 + 0xe4;
    r7 = r0;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
    r7 = r7 + 0x8;
    CPU.r9().value = r1;
    CPU.r11().value = r1;
    CPU.r8().value = r1;

    //LAB_8094eb0
    do {
      r3 = MEMORY.ref(2, r7 + 0x1c).getUnsigned();
      if(r3 != 0x0) {
        //LAB_8094eb8
        r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r2 = MEMORY.ref(4, r2).get();
        r3 = MEMORY.ref(4, r3 + 0x4).get();
        r0 = 0xb3;
        r0 = r0 << 1;
        CPU.r8().value = r2;
        CPU.r10().value = r3;
        r0 = readFlag_(r0);
        if(r0 != 0x0) {
          r3 = MEMORY.ref(2, r7 + 0x1c).getUnsigned();
          r3 = r3 + 0x1;
          MEMORY.ref(2, r7 + 0x1c).setu(r3);
        }

        //LAB_8094ed6
        r3 = MEMORY.ref(2, r7 + 0x1c).getUnsigned();
        r2 = 0x809f024;
        r3 = r3 >>> 1;
        r3 = r3 << 2;
        r6 = r3 + r2;
        r0 = rand();
        r5 = r0;
        r0 = rand();
        r3 = 0x1;
        r2 = MEMORY.ref(4, r7 + 0xc).get();
        r0 = r0 & r3;
        r1 = CPU.r8().value;
        r3 = r3 & r5;
        r2 = r2 - r1;
        r3 = r3 + r0;
        r2 = r2 >> 16;
        r3 = r3 >>> 1;
        r1 = r2 + r3;
        r2 = r1 - 0x1;
        CPU.r11().value = r2;
        r3 = MEMORY.ref(4, r7 + 0x14).get();
        r2 = MEMORY.ref(4, r7 + 0x10).get();
        r0 = CPU.r10().value;
        r3 = r3 - r2;
        r3 = r3 - r0;
        if(r3 < 0x0) {
          r2 = 0xffff;
          r3 = r3 + r2;
        }

        //LAB_8094f14
        r0 = 0x0;
        r2 = MEMORY.ref(2, r6 + r0).get();
        r3 = r3 >> 16;
        r3 = r3 + r2;
        CPU.r8().value = r3;
        r3 = r1;
        r3 = r3 + 0xf;
        r6 = r6 + 0x2;
        if((r3 & 0xffff_ffffL) <= (0xff & 0xffff_ffffL)) {
          r1 = 0x20;
          r1 = -r1;
          if(CPU.r8().value >= r1) {
            r2 = CPU.r8().value;
            if(r2 <= 0x9f) {
              r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r1 = MEMORY.ref(4, r3 + 0x4).get();
              r3 = MEMORY.ref(2, r6).getUnsigned();
              r1 = r1 + r3;
              r3 = 0x3ff;
              r2 = 0xfffffc00;
              r1 = r1 & r3;
              r3 = MEMORY.ref(2, r7 + 0x8).getUnsigned();
              r3 = r3 & r2;
              r3 = r3 | r1;
              MEMORY.ref(2, r7 + 0x8).setu(r3);
              r3 = 0x1ff;
              r1 = CPU.r11().value;
              r1 = r1 & r3;
              r2 = 0xfffffe00;
              r3 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
              r3 = r3 & r2;
              r3 = r3 | r1;
              r2 = MEMORY.ref(1, r7 + 0x5).getUnsigned();
              r1 = 0x3f;
              MEMORY.ref(2, r7 + 0x6).setu(r3);
              r3 = r1;
              r3 = r3 & r2;
              MEMORY.ref(1, r7 + 0x5).setu(r3);
              r3 = MEMORY.ref(1, r7 + 0x7).getUnsigned();
              r1 = r1 & r3;
              r3 = 0x40;
              r1 = r1 | r3;
              r3 = 0x3001e40;
              r0 = CPU.r8().value;
              r3 = MEMORY.ref(4, r3).get();
              r2 = 0x1;
              MEMORY.ref(1, r7 + 0x4).setu(r0);
              r0 = 0x3f;
              r0 = -r0;
              r3 = r3 >>> 1;
              r3 = r3 & r2;
              r2 = r0;
              r3 = r3 << 4;
              r1 = r1 & r2;
              r1 = r1 | r3;
              MEMORY.ref(1, r7 + 0x7).setu(r1);
              insertIntoRenderQueue(MEMORY.ref(4, r7, RenderPacket0c::new), 240);
            }
          }
        }

        //LAB_8094fb2
        r3 = MEMORY.ref(2, r7 + 0x1c).getUnsigned();
        r1 = 0xffff;
        r3 = r3 + r1;
        MEMORY.ref(2, r7 + 0x1c).setu(r3);
      }

      //LAB_8094fc8
      r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      if((r2 & 0xffff_ffffL) <= (0x3 & 0xffff_ffffL)) {
        r3 = MEMORY.ref(2, r7 + 0x1c).getUnsigned();
        if(r3 == 0x0) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r1 = 0x40c;
          r3 = r0 + r1;
          r5 = MEMORY.ref(4, r3).get();
          if(r5 == 0x0) {
            r2 = CPU.r9().value;
            if(r2 != 0x0) {
              r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              MEMORY.ref(4, r7 + 0xc).setu(r3);
              r0 = MEMORY.ref(4, CPU.sp().value).get();
              r3 = CPU.r8().value;
              r2 = CPU.r11().value;
              r1 = r2 >> 16;
              MEMORY.ref(4, r7 + 0x14).setu(r0);
              r2 = r3 >> 16;
              r0 = 0x0;
              r0 = getHeight_(r0, r1, r2);
              r3 = 0x3e;
              r0 = r0 << 16;
              MEMORY.ref(4, r7 + 0x10).setu(r0);
              r0 = CPU.r9().value;
              r3 = r3 - r0;
              MEMORY.ref(2, r7 + 0x1c).setu(r3);
              MEMORY.ref(4, r7 + 0x18).setu(r5);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r2 = 0x4;
              r1 = r1 + 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
              CPU.r9().value = CPU.r9().value + r2;
            } else {
              //LAB_8095020
              r0 = rand();
              r3 = 0xff;
              r0 = r0 & r3;
              if(r0 == 0x0) {
                r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r6 = MEMORY.ref(4, r3).get();
                r0 = rand();
                r3 = MEMORY.ref(4, r6).get();
                r0 = r0 << 8;
                r5 = 0xff800000;
                r3 = r3 + r0;
                r3 = r3 + r5;
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                r0 = rand();
                r3 = MEMORY.ref(4, r6 + 0x8).get();
                r0 = r0 << 8;
                r3 = r3 + r0;
                r3 = r3 + r5;
                r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                MEMORY.ref(4, CPU.sp().value).setu(r3);
                r2 = CPU.r11().value;
                MEMORY.ref(4, r7 + 0x14).setu(r3);
                r3 = CPU.r8().value;
                r1 = r2 >> 16;
                MEMORY.ref(4, r7 + 0xc).setu(r0);
                r2 = r3 >> 16;
                r0 = 0x0;
                r0 = getHeight_(r0, r1, r2);
                r0 = r0 << 16;
                MEMORY.ref(4, r7 + 0x10).setu(r0);
                r3 = 0x1e;
                r0 = CPU.r9().value;
                MEMORY.ref(2, r7 + 0x1c).setu(r3);
                MEMORY.ref(4, r7 + 0x18).setu(r0);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r1 = r1 + 0x1;
                r2 = 0x4;
                MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
                CPU.r9().value = r2;
              }
            }
          }
        }
      }

      //LAB_8095078
      r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      r3 = r3 + 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
      r7 = r7 + 0x20;
    } while((r3 & 0xffff_ffffL) <= (0x1f & 0xffff_ffffL));

    //LAB_8095086
    CPU.sp().value += 0x1c;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  /** Probably the falling dust "weather" effect when the Sol Sanctum starts erupting */
  @Method(0x809509c)
  public static void FUN_809509c() {
    CPU.sp().value -= 0x4;
    final int r5 = mallocSlotBoard(29, 0x410);
    int r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    int r7 = r5 + 0x8;
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x85000104);
    final int r6 = mallocSlotBoard(14, 0x400);
    FUN_80053e8(0x80a00b8, r6);
    r0 = getFreeVramSlot();
    MEMORY.ref(4, r5).setu(r0);
    MEMORY.ref(4, r5 + 0x4).setu(allocateSpriteSlot(r0, 0x200, r6));
    freeSlot(14);

    //LAB_80950f0
    for(int i = 0; i < 32; i++) {
      final int r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
      final int r2 = MEMORY.ref(4, r3).get();
      MEMORY.ref(4, r7).setu(0);
      MEMORY.ref(4, r7 + 0x4).setu(0x40000400);
      MEMORY.ref(4, r7 + 0x8).setu(0xd400);
      MEMORY.ref(4, r7 + 0xc).setu(0);
      MEMORY.ref(4, r7 + 0x14).setu(0);
      MEMORY.ref(4, r7 + 0x10).setu(getHeight_(0, MEMORY.ref(4, r2).get() >> 16, MEMORY.ref(4, r2 + 0x8).get() >> 16) << 16);
      MEMORY.ref(2, r7 + 0x1c).setu((i & 0xf) + 1);
      r7 = r7 + 0x20;
    }

    setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8094e7c"), 0xc80);
    CPU.sp().value += 0x4;
  }

  @Method(0x8095160)
  public static void allocateLightning() {
    final LightningStruct1f88 r5 = MEMORY.ref(4, mallocSlotBoard(30, 0x1f88), LightningStruct1f88::new);
    final PaletteStruct2a04 r3 = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);

    MEMORY.memfill(r5.getAddress(), 0x1f88, 0);
    FUN_8090a5c(0x10003, r3.backgroundPaletteBackup_0000.getAddress(), r5.dest_0000.getAddress(), 0x1);
    FUN_8090a5c(0x10005, r3.backgroundPaletteBackup_0000.getAddress(), r5.current_0a80.getAddress(), 0x1);
    calculatePaletteModificationSteps(r5.current_0a80, r5.dest_0000, r5.step_1500, 12);
    FUN_8090a5c(r5.dest_0000.getAddress(), 0, r3.dest_0e00.getAddress(), 0x1);

    r5.ticksRemaining_1f80.set(600);
    r5.dest_0000.get(0).set(1);

    setTickCallback(getRunnable(GoldenSun_809.class, "tickLightning"), 0xc80);
  }

  @Method(0x8095214)
  public static void FUN_8095214() {
    final LightningStruct1f88 lightning = MEMORY.ref(4, mallocSlotBoard(30, 0x1f88), LightningStruct1f88::new);
    lightning.ticksRemaining_1f80.set(0x7fff);
    lightning.repeat_1f82.set(false);
  }

  @Method(0x8095240)
  public static void FUN_8095240() {
    final LightningStruct1f88 lightning = MEMORY.ref(4, mallocSlotBoard(30, 0x1f88), LightningStruct1f88::new);
    lightning.ticksRemaining_1f80.set(0xc);
    lightning.repeat_1f82.set(false);
  }

  @Method(0x8095268)
  public static void FUN_8095268() {
    final LightningStruct1f88 lightning = MEMORY.ref(4, mallocSlotBoard(30, 0x1f88), LightningStruct1f88::new);
    lightning.ticksRemaining_1f80.set(0x80);
    lightning.repeat_1f82.set(true);
  }

  /** Lightning effect on map 10 */
  @Method(0x8095290)
  public static void FUN_8095290(final int r0, final int r1) {
    final LightningStruct1f88 r5 = MEMORY.ref(4, mallocSlotBoard(30, 0x1f88), LightningStruct1f88::new);
    final PaletteStruct2a04 r8 = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);
    MEMORY.memfill(r5.getAddress(), 0x1f88, 0);
    FUN_8090a5c(r0, r8.backgroundPaletteBackup_0000.getAddress(), r5.dest_0000.getAddress(), 1);
    FUN_8090a5c(r1, r8.backgroundPaletteBackup_0000.getAddress(), r5.current_0a80.getAddress(), 1);
    calculatePaletteModificationSteps(r5.current_0a80, r5.dest_0000, r5.step_1500, 12);
    FUN_8090a5c(r5.dest_0000.getAddress(), 0, r8.dest_0e00.getAddress(), 1);
    r5.ticksRemaining_1f80.set(120);
    r5.repeat_1f82.set(false);
    setTickCallback(getRunnable(GoldenSun_809.class, "tickLightning"), 0xc80);
  }

  @Method(0x8095348)
  public static void FUN_8095348(final Actor70 r0) {
    final Actor70 r4 = r0.parent_68.deref();
    r0.pos_08.x_00.add((r4.pos_08.getX() - r0.pos_08.getX()) / 2);
    r0.pos_08.y_04.add((r4.pos_08.getY() - r0.pos_08.getY()) / 2);
    r0.pos_08.z_08.add((r4.pos_08.getZ() - r0.pos_08.getZ()) / 2);
  }

  @Method(0x809537c)
  public static void FUN_809537c(final int r0) {
    int r7;
    final int r8;
    final int r11;

    final Actor70 r6 = getMapActor_(r0);
    r11 = (getMapActor_(playerMapActorIndex_2000434.get()).angle_06.get() & 0xffff) + 0x2000 & 0xc000;
    FUN_80916b0();
    sleep(10);
    playSound_(0xad);
    FUN_80925cc(r0, 1);
    playSound_(0xaf);
    FUN_80925cc(r0, 1);
    sleep(20);
    FUN_8092adc(r0, r11 + 0x8000, 0);
    sleep(10);
    r6.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
    r6.angle_06.set(r11 + 0x8000);
    getMapActor_(r0)._5a.and(~0x1);
    r6._55.set(2);
    FUN_8096bec(r6, 0x100000, r11);
    playSound_(0x98);
    FUN_8092560(r0, 4, 0);
    FUN_8009158(r6);
    FUN_8096bec(r6, 0x100000, r11);
    playSound_(0x98);
    FUN_8092560(r0, 4, 0);
    FUN_8009158(r6);
    FUN_8096bec(r6, 0x100000, r11);
    playSound_(0x98);
    FUN_8092560(r0, 4, 0);
    FUN_8009158(r6);
    sleep(20);
    r8 = r6.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get();
    int sp08 = 9;

    if(r8 == 0x5a) {
      sp08 = 2;
    }

    //LAB_809549c
    if(r8 == 0x5c) {
      sp08 = 10;
    }

    //LAB_80954a6
    if(r8 == 0x5b) {
      sp08 = 9;
    }

    //LAB_80954b0
    Sprite38 sp0c = null;
    Actor70 r9 = r6;

    //LAB_80954be
    for(r7 = 0; r7 < 8; r7++) {
      final Actor70 r5 = loadActor_(r8, r6.pos_08.getX(), r6.pos_08.getY(), r6.pos_08.getZ());
      if(r5 != null) {
        r5.scale_18.set(0xf000);
        r5._1c.set(0xf000);
        r5.flags_23.set(2);
        r5._55.set(0);
        r5._5a.or(0x1);
        r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_8095348", Actor70.class));
        r5.angle_06.set(r6.angle_06.get());
        r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
        FUN_8009240(r5, sp08);
        setActorAnimation_(r5, 0);
        FUN_80091e0(r5, 0);
        sp0c = FUN_8096c48(r5.sprite_50.deref(), sp0c);
        r5.parent_68.set(r9);
        r9 = r5;
      }

      //LAB_8095536
    }

    FUN_8096bec(r6, 0x400000, r11 + 0x8000);
    playSound_(136);
    FUN_8092560(r0, 12, 0);
    sleep(24);
    r6._55.set(0);
    r6.velocity_24.zero();
    r6.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    setActorAnimation_(r6, 0);
    r6.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
    FUN_8091750();
  }

  @Method(0x80955b0)
  public static void FUN_80955b0(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8095680)
  public static void FUN_8095680() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8095778)
  public static void FUN_8095778(int r0) {
    final int r2;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    r5 = _2000474.get() & 0xf000;
    r6 = _2000474.get() & 0xfff;
    if(CPU.r8().value == 0) {
      if(r5 == 0) {
        r6 = r6 & 0x7ff;
        if(r6 >= 300 && r6 <= 380) {
          r2 = _2000476.get();
          if(r2 <= 0 || r2 == 999) {
            //LAB_80957c0
            setFlag_(r6 - 0xac);
            _2000474.set(0);
          }
        }
      } else {
        //LAB_80957cc
        if(r5 == 0x1000) {
          if(_2000476.get() == 1) {
            setFlag_(r6);
          }

          //LAB_80957e6
          _2000474.set(CPU.r8().value);
        }
      }
    } else {
      //LAB_80957ec
      if(r5 == 0) {
        r6 = r6 & 0x7ff;
        if(r6 >= 300 && r6 <= 380) {
          if(_2000476.get() > 0) {
            r5 = r6 - 300;
            CPU.r8().value = divideS(r5, 20);
            r7 = modS(r5, 20);
            r5 = 0x7;

            //LAB_8095826
            jmp_8095854:
            {
              do {
                r5++;

                //LAB_8095828
                if(r5 > 0x41) {
                  break jmp_8095854;
                }
              } while((r0 = FUN_808d394(r5)) == 0 || MEMORY.ref(2, r0 + 0x2).get() - 0x30 != r6 - 300);

              sleep(40);
              FUN_80955b0(r5, CPU.r8().value, r7);
            }

            //LAB_8095854
          }
        }
      }

      //LAB_8095856
      _2000474.set(0);
    }

    //LAB_8095860
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80967e4)
  public static void FUN_80967e4(final int r0) {
    if(r0 == 0) {
      FUN_8096810();
      //LAB_80967f0
    } else if(r0 == 1) {
      FUN_8096960();
      //LAB_80967fa
    } else if(r0 == 2) {
      FUN_8096ab0();
      //LAB_8096804
    } else if(r0 == 3) {
      FUN_8096af0();
    }

    //LAB_809680c
  }

  @Method(0x8096810)
  public static void FUN_8096810() {
    final FieldPsynergy720 r5 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final int fieldPsynergyId = r5.fieldPsynergyId_1e.get();
    final int r7 = r5.targetMapActorIndex_1a.get();
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    //LAB_809682e
    switch(fieldPsynergyId) {
      case 1: // switch 8096838
        //LAB_8096878
        FUN_809802c();
        break;

      case 7: // switch 8096838
        //LAB_809687e
        FUN_8098954();
        break;

      case 11: // switch 8096838
        //LAB_8096884
        FUN_809a294();
        break;

      case 4: // switch 8096838
        //LAB_809688a
        FUN_8098cd8();
        break;

      case 5: // switch 8096838
        //LAB_8096890
        FUN_80999f0();
        break;

      case 14: // switch 8096838
        //LAB_8096896
        FUN_809a8c4();
        break;

      case 6: // switch 8096838
        //LAB_809689c
        FUN_8099160();
        break;

      case 3: // switch 8096838
        //LAB_80968a2
        FUN_80994d0();
        break;

      case 12: // switch 8096838
        //LAB_80968a8
        FUN_80985fc();
        break;

      case 13: // switch 8096838
        //LAB_80968ae
        FUN_809ae64();
        break;

      case 9: // switch 8096838
        //LAB_80968b4
        if(_200048a.get() != -1) {
          FUN_809ade8(_200048a.get());
          _200048a.set(-1);
        }

        //LAB_80968ce
        final int mapActorIndex = FUN_809ae3c(findFieldPsynergyTarget(playerMapActorIndex_2000434.get(), fieldPsynergyId));
        if(FUN_808d5a4(mapActorIndex) != null) {
          setFieldPsynergyTargetAndCaster(playerMapActorIndex_2000434.get(), mapActorIndex);
          FUN_809ab98(mapActorIndex);
          FUN_809ad90(mapActorIndex);
          _200048a.set(mapActorIndex);
        } else {
          //LAB_8096906
          FUN_809abb4();
        }
        break;

      case 2: // switch 8096838
        //LAB_809690c
        if(r1._cb8.get() != 0) {
          FUN_80984c0();
        }

        //LAB_809691c
        FUN_8097540(r5.casterMapActorIndex_18.get(), r7);
        break;

      case 8: // switch 8096838
        //LAB_8096928
        FUN_80983a0();
        break;

      case 10: // switch 8096838
        //LAB_809692e
        FUN_8099838();
        break;

      case 15: // switch 8096838
        //LAB_8096934
        FUN_809b208();
        break;

      case 16: // switch 8096838
        //LAB_809693a
        FUN_809b698();
        break;
    }

    //LAB_809693e
  }

  @Method(0x8096960)
  public static void FUN_8096960() {
    final FieldPsynergy720 r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final int fieldPsynergyId = r6.fieldPsynergyId_1e.get();
    final Structccc r0 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final int r5 = r6.targetMapActorIndex_1a.get();
    r6._20.set(0);

    //LAB_8096982
    switch(fieldPsynergyId) {
      case 2:
        if(r0._cb8.get() != 0) {
          FUN_80984c0();
        }

        //LAB_80969dc
        if(_200048a.get() != _20004a4.get()) {
          r6.target_14.deref()._5b.set(0x1);
        }

        //LAB_80969f6
        FUN_8097540(r6.casterMapActorIndex_18.get(), r5);
        break;

      case 1: // move
        useMoveInField(r5);
        break;

      case 7:
        FUN_8098848(r5);
        break;

      case 11:
        FUN_8099da4();
        break;

      case 4:
        FUN_8098ccc(r5);
        break;

      case 5:
        FUN_80999e4(r5);
        break;

      case 6:
        FUN_8099128(r5);
        break;

      case 12:
        FUN_80985a8(r5);
        break;

      case 9:
        if(_200048a.get() != -1) {
          FUN_809ade8(_200048a.get());
          _200048a.set(-1);
        }

        //LAB_8096a54
        FUN_809ad90(r5);
        _200048a.set(r5);
        FUN_809ab98(r5);
        break;

      case 3:
        FUN_80994c0(r5);
        break;

      case 14:
        FUN_809a8b8(r5);
        break;

      case 13:
        FUN_809ae58(r5);
        break;

      case 8:
        FUN_80983a0();
        break;

      case 10:
        FUN_8099838();
        break;

      case 15:
        FUN_809b208();
        break;

      case 16:
        FUN_809b698();
        break;
    }

    //LAB_8096a92
  }

  @Method(0x8096ab0)
  public static void FUN_8096ab0() {
    final FieldPsynergy720 r5 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    if(r5.fieldPsynergyId_1e.get() == 0x2) {
      FUN_8097608();

      if(_200048a.get() != r5.targetMapActorIndex_1a.get()) {
        r5.target_14.deref()._5b.set(0);
      }
    }
  }

  @Method(0x8096af0)
  public static void FUN_8096af0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8096b28)
  public static int FUN_8096b28(final EventStruct0c r0, final int r1, final int r2) {
    if(r0 != null) {
      final int r3 = r0.callback_08.get();
      if(r3 != 0) {
        if(r3 < 0x10000) {
          FUN_80916b0();
          FUN_8092b94(r3);
          FUN_8092f84(r2, 0);
          FUN_8091750();
        } else {
          //LAB_8096b5a
          LOGGER.info("Calling event %07x params %x %x", r3, r1, r2);
          MEMORY.call(r3, r1, r2);
        }
      }

      //LAB_8096b60
      if(readFlag_(0x142) != 0) {
        FUN_80916b0();
        FUN_8015040(0x927, 0x1);
        FUN_8091750();
      }
    }

    //LAB_8096b7c
    return 0;
  }

  @Method(0x8096b88)
  public static void FUN_8096b88(final Actor70 r0) {
    if(r0.spriteType_54.get() == 0x1) {
      final Sprite38 r8 = r0.sprite_50.derefNullable();
      if(r8 != null) {
        if((r8._1d.get() & 0x1) == 0x0) {
          final int r3 = r8.layerCount_27.get();
          if(r3 != 0) {
            //LAB_8096bbe
            for(int r6 = 0; r6 < r3; r6++) {
              r8.layers_28.get(r6).deref()._05.set(modU(_3001e40.get(), 6));
            }
          }

          //LAB_8096bd2
          r8._25.set(0x1);
        }
      }
    }

    //LAB_8096bda
  }

  @Method(0x8096bec)
  public static void FUN_8096bec(final Actor70 actor, final int distance, final int angle) {
    if(actor != null) {
      final Vec3 r5 = new Vec3();
      r5.set(actor.pos_08);
      rotVec3(distance, angle, r5);
      moveActorTo_(actor, r5.getX(), r5.getY(), r5.getZ());
    }

    //LAB_8096c1a
  }

  @Method(0x8096c24)
  public static int FUN_8096c24() {
    int r0 = 0;

    //LAB_8096c2e
    for(int i = 0; i < 0x200; i++) {
      if(_3001810.get(i).get() == 0xff) {
        r0++;
      }

      //LAB_8096c38
    }

    return r0;
  }

  @Method(0x8096c48)
  public static Sprite38 FUN_8096c48(final Sprite38 r0, final Sprite38 r1) {
    if(r0 == null) {
      return null;
    }

    if(r1 == null) {
      r0._1d.or(0x1);
      return r0;
    }

    //LAB_8096c62
    clearVramSlot(r0.slot_1c.get());
    r0.slot_1c.set(r1.slot_1c.get());
    r0._1d.or(0x1);
    return r1;
  }

  @Method(0x8096c80)
  public static Actor70 FUN_8096c80(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    final FieldPsynergy720 r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r5 = loadActor_(spriteTypeAndDataIndex, x, y, z);
    if(r5 != null) {
      if(r5.spriteType_54.get() == 0) {
        clearActor_(r5);
        return null;
      }

      //LAB_8096ca2
      //BUGFIX: uninitialized pointer
      if(r6 != null) {
        r5._14.set(r6.caster_10.deref()._14.get());
      }

      r5._55.set(0x4);
      r5.flags_23.set(0x4);
      r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
      FUN_80091e0(r5, 0);
      setActorAnimation_(r5, 1);
    }

    //LAB_8096cce
    //LAB_8096cd0
    return r5;
  }

  @Method(0x8096cdc)
  public static void FUN_8096cdc(final Actor70 caster, final int r1, final int r2) {
    //LAB_8096cf0
    for(int mapActorIndex = 0; mapActorIndex < 67; mapActorIndex++) {
      final Actor70 actor = getMapActor(mapActorIndex);
      if(mapActorIndex != _200048a.get() && actor != null && actor.getAddress() != caster.getAddress()) {
        actor._5b.set(r1);
        FUN_8009088(actor, r2);
      }

      //LAB_8096d14
    }
  }

  @Method(0x8096d2c)
  public static void FUN_8096d2c(final Actor70 r0) {
    r0._64.incr();
    final Actor70 r6 = r0.parent_68.deref();
    final int angle = r0._64.get();
    if(angle > 0x1f) {
      setActorSpriteScript_(r0, 0x809f0b0);
    } else {
      //LAB_8096d4e
      final int sin = sin(angle << 10);
      r0.scale_18.set(sin);
      r0._1c.set(sin);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.z_08.add((0x10000 - sin) * 5 + 0x90000);
    }

    //LAB_8096d78
  }

  @Method(0x8096d84)
  public static void FUN_8096d84(final Actor70 r0) {
    r0._64.incr();
    final Actor70 r6 = r0.parent_68.deref();
    final int r0_0 = r0._64.get();
    if(r0_0 > 0x1f) {
      setActorSpriteScript_(r0, 0x809f0b0);
    } else {
      //LAB_8096da6
      final int sin = sin(r0_0 << 10);
      r0.scale_18.set(sin);
      r0._1c.set(-sin);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.z_08.sub((0x10000 - sin) * 5).add(0x100000);
    }

    //LAB_8096dd2
  }

  @Method(0x8096ddc)
  public static void FUN_8096ddc(final Actor70 r0) {
    final FieldPsynergy720 r10 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 sp00 = r10.caster_10.deref();
    CPU.sp().value -= 0xc;

    final Actor70[] sp04 = new Actor70[2];

    //LAB_8096e04
    for(int r7 = 0; r7 < 2; r7++) {
      final Actor70 r0_0 = loadActor_(26, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      sp04[r7] = r0_0;
      if(r0_0 != null) {
        r0_0._14.set(r0._14.get());
        final Sprite38 r5 = r0_0.sprite_50.deref();
        r0_0._55.set(0);
        r0_0._64.set(0);
        r0_0.parent_68.set(r0);
        r0_0._1c.set(0x1999);
        r0_0.scale_18.set(0x1999);
        if(r5 != null) {
          setSpriteAnimation_(r5, 0);
          r5._26.set(0);
          clearVramSlot(r5.slot_1c.get());
          r5.slot_1c.set(r10.vramSlot_46.get());
          r5._1d.or(0x1);
          final int r1 = vramSlots_3001b10.get(r5.slot_1c.get()).vramAddr_02.get() << 17 >>> 22;
          r5.packet_00.attribs_04.attrib2_04.and(~0x3ff).or(r1);
          r5.packet_00.attribs_04.flags_01.and(0x3f).and(~0x20).or(0x40);
          r5.packet_00.attribs_04.attrib1_02.and(0x3fff).or(0x8000);
          r5.layers_28.get(0).deref()._16.set(0);
        }
      }

      //LAB_8096ebc
    }

    final Actor70 r2 = sp04[0];
    r2._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096d84", Actor70.class));
    r2.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
    final Actor70 r0_1 = sp04[1];
    r0_1._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096d2c", Actor70.class));
    final Sprite38 r3 = sp00.sprite_50.deref();
    r0_1.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r3.packet_00.attribs_04.attrib2_04.get() & 0xc00);
    r0_1.flags_23.set(0x2);

    CPU.sp().value += 0xc;
  }

  @Method(0x8096f14)
  public static void FUN_8096f14(final Actor70 r0) {
    if((_3001e40.get() & 0x2) != 0) {
      FUN_8009240(r0, 0x7);
    } else {
      //LAB_8096f2c
      FUN_8009240(r0, 0);
    }

    //LAB_8096f34
    if((_3001e40.get() & 0xf) == 0) {
      FUN_8096ddc(r0);
    }

    //LAB_8096f46
  }

  @Method(0x8096f50)
  public static void FUN_8096f50(final Actor70 r0) {
    if((_3001e40.get() & 0x1) != 0) {
      FUN_8009240(r0, modU(_3001e40.get() >>> 1, 6));
    }

    //LAB_8096f72
    if((_3001e40.get() & 0xf) == 0) {
      FUN_8096ddc(r0);
    }
  }

  @Method(0x8096f8c)
  public static void tickFieldPsynergy() {
    final FieldPsynergy720 r3 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);

    //LAB_8096f98
    for(int i = 0; i < 24; i++) {
      FUN_809b804(r3._58.get(i));
    }
  }

  @Method(0x8096fb0)
  public static void initFieldPsynergy(final int abilityId, final int r1) {
    final Structccc r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    final FieldPsynergy720 r5;
    if(r2.fieldPsynergyInUse_cc6.get() == 0) {
      r5 = MEMORY.ref(4, mallocSlotChip(56, 0x720), FieldPsynergy720::new);

      CPU.sp().value -= 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(0);
      DMA.channels[3].SAD.setu(CPU.sp().value);
      DMA.channels[3].DAD.setu(r5.getAddress());
      DMA.channels[3].CNT.setu(0x850001c8);
      CPU.sp().value += 0x4;
    } else {
      //LAB_8097004
      r5 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    }

    //LAB_8097006
    r5.abilityId_1c.set(abilityId);
    r5.fieldPsynergyId_1e.set(getAbility_(abilityId).fieldPsynergyId_0c.get());

    if(r2.fieldPsynergyInUse_cc6.get() == 0) {
      r5._4a.set(0x200 - FUN_8096c24());
      r5._20.set(0x1);
      r5._21.set(r1);
      r5._22.set(0x1);
      r5._23.set(0x1);
      r5._71c.set(0x1);
      r5._4c.set(r7._04.get());
      r5._50.set(r7._08.get());
      r5._54.set(r7._0c.get());

      if(_200041a.get() == 0x35) {
         r5._45.set(0x1);
      }

      //LAB_8097086
      if(_200041a.get() == 0x37) {
        r5._45.set(0x1);
      }

      //LAB_8097096
      setFieldPsynergyTargetAndCaster(playerMapActorIndex_2000434.get(), -1);

      if(r5.fieldPsynergyId_1e.get() != 8) {
        r2._cc0.set(0);
      }

      //LAB_80970b6
      r5.vramSlot_46.set(getFreeVramSlot());
      allocateSpriteSlot(r5.vramSlot_46.get(), 0x100, 0x809c410);
      setTickCallback(getRunnable(GoldenSun_809.class, "tickFieldPsynergy"), 0xc80);
    }

    //LAB_80970d8
  }

  @Method(0x80970f8)
  public static void setFieldPsynergyTargetAndCaster(final int casterMapActorIndex, final int targetMapActorIndex) {
    final FieldPsynergy720 r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 caster = getMapActor(casterMapActorIndex);
    final Actor70 target = getMapActor(targetMapActorIndex);
    r6.casterMapActorIndex_18.set(casterMapActorIndex);
    r6.targetMapActorIndex_1a.set(targetMapActorIndex);
    r6.caster_10.setNullable(caster);
    r6.target_14.setNullable(target);
    r6.angle_00.set(caster.angle_06.get() + 0x2000 & 0xc000);
    if(target != null) {
      r6._38.setPointer(target._6c.getPointer());
      r6.targetScriptPtr_3c.set(target.scriptPtr_00.get());
      final SpriteLayer18 sprite2 = target.sprite_50.deref().layers_28.get(0).deref();
      r6._44.set(sprite2._05.get());
      r6.pos_04.set(target.pos_08);
    } else {
      //LAB_8097152
      r6.pos_04.set(caster.pos_08);
      rotVec3(0x100000, r6.angle_00.get(), r6.pos_04);
    }

    //LAB_8097168
  }

  @Method(0x8097174)
  public static void FUN_8097174() {
    final FieldPsynergy720 r3 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 caster = r3.caster_10.deref();
    caster._6c.clear();
    FUN_8009240(caster, 0);
    sleep(0x1);
  }

  @Method(0x8097194)
  public static void FUN_8097194() {
    final FieldPsynergy720 r8 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Structccc r11 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Map194 r9 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    //LAB_80971c0
    for(int r5 = 0; r5 < 24; r5++) {
      if(r8._58.get(r5)._45.get() != 0) {
        clearFieldPsynergyInstance(r8._58.get(r5));
      }

      //LAB_80971d0
    }

    if(r11.fieldPsynergyInUse_cc6.get() == 0) {
      final int r7 = getConsumer(GoldenSun_809.class, "FUN_8096d2c", Actor70.class).getAddress();
      final int r10 = getConsumer(GoldenSun_809.class, "FUN_8096d84", Actor70.class).getAddress();

      //LAB_80971ee
      for(int r6 = 0; r6 < 0x1e; r6++) {
        final ArrayRef<Actor70> r3 = boardWramMallocHead_3001e50.offset(5 * 0x4).deref(4).cast(ArrayRef.of(Actor70.class, 64, 0x70, Actor70::new));
        int r1 = 0;
        int r5 = 0;

        //LAB_80971f6
        int r2;
        do {
          if(r5 > 0x3f) {
            break;
          }
          r2 = r3.get(r5)._6c.getPointer();
          if(r2 == r10) {
            //LAB_8097208
            r1 = 1;
            break;
          }
          r5++;
        } while(r2 != r7);

        //LAB_809720a
        if(r1 == 0) {
          break;
        }
        sleep(0x1);
      }

      //LAB_809721a
      r11._cc7.set(0);
      clearTickCallback(getRunnable(GoldenSun_809.class, "tickFieldPsynergy"));
      clearVramSlot(r8.vramSlot_46.get());

      r9._04.set(r8._4c.get());
      r9._08.set(r8._50.get());
      r9._0c.set(r8._54.get());

      if(r8.fieldPsynergyId_1e.get() != 8) {
        r11._cc0.set(0x1);
      }

      //LAB_8097256
      FUN_809202c();
      freeSlot(56);
    }

    //LAB_8097260
  }

  @Method(0x809728c)
  public static void FUN_809728c() {
    final FieldPsynergy720 r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    final Actor70 caster = r6.caster_10.deref();
    final int abilityId = r6.abilityId_1c.get();

    setActorAnimation_(caster, 0x14);
    caster.dest_38.set(caster.pos_08);
    caster.velocity_24.zero();

    if(r6._22.get() != 0) {
      playSound_(0xd4);
      caster._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096f14", Actor70.class));
    }

    //LAB_80972da
    if(r6._23.get() != 0) {
      FUN_8096cdc(caster, 1, 0);
      FUN_8015120(abilityId, 4);
      FUN_8015040(0x926, r6._71c.get());
      FUN_8096cdc(caster, 0, 0x10);
    }

    //LAB_8097330
    if(readFlag_(0x140) != 0) {
      if(r6._22.get() != 0) {
        caster._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096f50", Actor70.class));
      }

      //LAB_809734a
      setActorAnimation_(caster, 21);
    } else {
      //LAB_8097354
      FUN_8097174();
    }

    //LAB_8097358
    r3._cc7.set(0x1);
  }

  /** Psynergy flash effect */
  @Method(0x8097384)
  public static void FUN_8097384() {
    final PaletteStruct2a04 addr = boardWramMallocHead_3001e50.offset(32 * 0x4).deref(4).cast(PaletteStruct2a04::new);
    final Structccc r4 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    DMA.channels[3].SAD.setu(addr.dest_0e00.get(0x2a0).getAddress());
    DMA.channels[3].DAD.setu(r4._776.getAddress());
    DMA.channels[3].CNT.setu(0x84000150);

    if(r4._cb8.get() == 0) {
      DMA.channels[3].SAD.setu(addr.dest_0e00.getAddress());
      DMA.channels[3].DAD.setu(r4._236.getAddress());
      DMA.channels[3].CNT.setu(0x84000150);
    }

    //LAB_80973bc
    DMA.channels[3].SAD.setu(addr.dest_0e00.getAddress());
    DMA.channels[3].DAD.setu(addr.current_0380.getAddress());
    DMA.channels[3].CNT.setu(0x840002a0);

    int r5 = _3001e40.get() & 0x7;

    if(readFlag_(0x148) != 0) {
      r5 = 0;
    }

    //LAB_80973e6
    if(readFlag_(0x149) != 0) {
      r5 = 0x1;
    }

    //LAB_80973f2
    if(readFlag_(0x14a) != 0) {
      r5 = 0x2;
    }

    //LAB_8097400
    if(readFlag_(0x14b) != 0) {
      r5 = 0x3;
    }

    //LAB_809740c
    if(readFlag_(0x14c) != 0) {
      r5 = 0x4;
    }

    //LAB_809741a
    if(readFlag_(0x14d) != 0) {
      r5 = 0x5;
    }

    //LAB_8097426
    if(readFlag_(0x14e) != 0) {
      r5 = 0x6;
    }

    //LAB_8097434
    if(readFlag_(0x14f) != 0) {
      r5 = 0x7;
    }

    //LAB_8097440
    FUN_8091200(MEMORY.ref(4, 0x80a0108 + r5 * 0x4).get(), 1);
    calculatePaletteModificationSteps(8);
  }

  /** Related to psynergy flashes */
  @Method(0x809748c)
  public static void FUN_809748c() {
    final Structccc r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    FUN_8091200(r5._236.getAddress(), 2);

    if(r5._cb8.get() != 0) {
      FUN_8091200(0x10001, 1);
    } else {
      //LAB_80974b4
      FUN_8091200(r5._236.getAddress(), 1);
    }

    //LAB_80974bc
    calculatePaletteModificationSteps(8);
  }

  @Method(0x80974d8)
  public static void FUN_80974d8(final Vec3 r0) {
    if(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._19e.get() == 3) {
      final Vec3 r5 = new Vec3();
      FUN_8005268(r0, r5);
      r0.setX(r5.getX() << 16);
      r0.setZ(r5.getY() << 16);
    } else {
      //LAB_8097504
      final Map194 r2 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
      r0.x_00.sub(r2._e4.get() & 0xffff0000);
      r0.z_08.sub((r2._e8.get() & 0xffff0000) + r0.getY());
    }

    //LAB_8097528
    r0.setY(0);
  }

  @Method(0x8097540)
  public static void FUN_8097540(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8097608)
  public static void FUN_8097608() {
    final int r5 = boardWramMallocHead_3001e50.offset(22 * 0x4).get();
    FUN_8097adc();
    clearTickCallback(getRunnable(GoldenSun_809.class, "FUN_8097644"));
    FUN_808e0b0(getMapActor_(MEMORY.ref(2, r5 + 0x290).getUnsigned()), 1);
    FUN_809748c();
    freeSlot(22);
  }

  @Method(0x8097adc)
  public static void FUN_8097adc() {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    clearTickCallback(getRunnable(GoldenSun_809.class, "FUN_8097868"));
    MEMORY.ref(2, 0x50001e2).setu(0x7fff);
    MEMORY.ref(2, 0x50001e6).setu(0);
    MEMORY.ref(2, 0x50001f6).setu(0x294a);
    MEMORY.ref(2, 0x50001f8).setu(0x5294);
    FUN_8015360(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());
    r5._ea4.set(0);
  }

  @Method(0x8097b54)
  public static int getAngleForHeldDirectionalButtons() {
    return MEMORY.ref(2, 0x809f0f8 + (heldButtonsLastFrame_3001ae8.get() >>> 4 & 0xf) * 0x2).getUnsigned();
  }

  @Method(0x8097b70)
  public static void FUN_8097b70(final Actor70 hand) {
    final Actor70 r0_0 = hand.parent_68.derefNullable();
    if(r0_0 != null) {
      final int dx = r0_0.pos_08.getX() - hand.pos_08.getX();
      final int dz = r0_0.pos_08.getZ() - hand.pos_08.getZ();
      if(dx != 0 || dz != 0) {
        //LAB_8097b90
        final int r3 = hand.angle_06.get() & 0xffff;
        hand.angle_06.set(r3 + MathHelper.clamp((short)(atan2(dz, dx) - r3), -0x1000, 0x1000));
      }

      //LAB_8097bb2
      hand._5a.set(0);
    }

    //LAB_8097bba
    final Vec3 r6 = new Vec3();
    r6.setX(hand.pos_08.getX());
    r6.setY(hand.pos_08.getY() - rand() * 0x10 - 0x80000);
    r6.setZ(hand.pos_08.getZ());
    rotVec3(rand() * 48, rand(), r6);

    final Actor70 actor = FUN_8096c80(0x11d, r6.getX(), r6.getY(), r6.getZ());
    if(actor != null) {
      actor._55.set(2);
      actor._48.set(0x1999);
      setActorAnimation_(actor, 0);
      actor._5e.set(12);
      setActorSpriteScript_(actor, 0x809f0b0);
    }

    //LAB_8097c20
  }

  @Method(0x8097c3c)
  public static void useMoveInField(final int r0) {
    final FieldPsynergy720 sp18 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 caster = sp18.caster_10.deref();
    final Actor70 target = sp18.target_14.derefNullable();
    final int sp08 = sp18.angle_00.get() + 0x8000;
    int sp04 = 0;
    if(target != null) {
      //LAB_8097c6c
      FUN_8097384();
      caster.parent_68.set(target);
      setActorSpriteScript_(caster, 0x809f0bc);
      final Actor70 moveHand = allocateMoveHand(caster);
      if(moveHand == null) {
        FUN_809748c();
      } else {
        //LAB_8097c8e
        moveHand.parent_68.set(target);
        final Vec3 vec = new Vec3();
        vec.setX(target.pos_08.getX());
        vec.setY(target.pos_08.getY() + 0x100000);
        vec.setZ(target.pos_08.getZ());
        rotVec3(0x100000, sp08, vec);
        moveActorTo_(moveHand, vec.getX(), vec.getY(), vec.getZ());
        FUN_8098184(moveHand);
        moveHand.velocityScalar_30.set(0x40000);
        moveHand.acceleration_34.set(0x8000);
        moveHand._55.set(0x4);
        target._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096b88", Actor70.class));
        target.velocityScalar_30.set(0x6666);
        target.acceleration_34.set(0x3333);
        target._5a.set(sp04);
        target.layer_22.set(2);

        //LAB_8097ee4
        jmp_8097ef8:
        {
          final Vec3 r5 = new Vec3();
          int moveAngle;
          jmp_8097e36:
          {
            do {
              do {
                sleep(1);

                if((pressedButtons_3001c94.get() & 0x303) != 0x0) {
                  break jmp_8097ef8;
                }

                moveAngle = getAngleForHeldDirectionalButtons();
                if(moveAngle != 0xffff) {
                  break;
                }

                vec.setX(target.pos_08.getX());
                vec.setY(target.pos_08.getY() + 0x100000);
                vec.setZ(target.pos_08.getZ());
                rotVec3(0x100000, sp08, vec);
                moveActorTo_(moveHand, vec.getX(), vec.getY(), vec.getZ());
                setActorAnimation_(moveHand, 1);
                moveHand.velocity_24.zero();
              } while(true);

              //LAB_8097d4a
              vec.setX(target.pos_08.getX());
              vec.setY(target.pos_08.getY() + 0x100000);
              vec.setZ(target.pos_08.getZ());
              rotVec3(0x100000, sp08, vec);
              rotVec3(0x20000, moveAngle, vec);
              moveActorTo_(moveHand, vec.getX(), vec.getY(), vec.getZ());
              FUN_8009158(moveHand);
              vec.setX(target.pos_08.getX());
              vec.setY(target.pos_08.getY());
              vec.setZ(target.pos_08.getZ());
              rotVec3(0x100000, moveAngle, vec);
              r5.setX(target.pos_08.getX());
              r5.setY(target.pos_08.getY());
              r5.setZ(target.pos_08.getZ());
              rotVec3(0x200000, moveAngle, r5);

              if(FUN_80091d8(target, vec) <= 0) {
                final Actor70 actor = FUN_80092a0(target, vec);
                if(actor == null) {
                  break jmp_8097e36;
                }

                if(actor.getAddress() == caster.getAddress()) {
                  if((caster.pos_08.getX() & 0xfff00000) != (vec.getX() & 0xfff00000) || (caster.pos_08.getZ() & 0xfff00000) != (vec.getZ() & 0xfff00000)) {
                    //LAB_8097dee
                    if((caster.pos_08.getX() & 0xfff00000) != (r5.getX() & 0xfff00000) || (caster.pos_08.getZ() & 0xfff00000) != (r5.getZ() & 0xfff00000)) {
                      break jmp_8097e36;
                    }

                    if(FUN_80092a8(caster.layer_22.get(), r5.getX(), r5.getZ()) == 0) {
                      break;
                    }
                  }
                }
              }

              //LAB_8097e16
              setActorAnimation_(moveHand, 4);

              if((_3001e40.get() & 0xf) == 0x0) {
                playSound_(0x72);
              }
            } while(true);

            //LAB_8097e32
            sp04 = 0x1;
          }

          //LAB_8097e36
          playSound_(0xaf);
          final int sp10 = vec.getX();
          final int sp0c = vec.getZ();
          final int r3 = sp08 - moveAngle << 16 >>> 30;
          setActorAnimation_(moveHand, MEMORY.ref(1, 0x809f118 + r3).getUnsigned());
          sleep(15);
          target._5b.set(0);
          target.velocityScalar_30.set(0x3333);
          target.acceleration_34.set(0x3333);
          moveActorTo_(target, vec.getX(), vec.getY(), vec.getZ());
          moveHand._55.set(0);
          moveHand.velocityScalar_30.set(0x3333);
          moveHand.acceleration_34.set(0x3333);
          rotVec3(0x100000, moveAngle, vec);
          moveActorTo_(moveHand, vec.getX(), vec.getY() + 0x100000, vec.getZ());

          if(sp04 == 0x1) {
            getMapActor_(sp18.casterMapActorIndex_18.get())._5a.and(~0x1);
            caster.velocityScalar_30.set(0x3333);
            caster.acceleration_34.set(0x3333);
            moveActorTo_(caster, r5.getX(), r5.getY(), r5.getZ());
          }

          //LAB_8097ece
          FUN_8009158(target);
          target.pos_08.setX(sp10);
          target.pos_08.setZ(sp0c);
          target.velocity_24.setX(0);
          target.velocity_24.setZ(0);
        }

        //LAB_8097ef8
        FUN_8009240(target, sp18.angle_00.get() & 0xff);
        setActorSpriteScript_(target, sp18.targetScriptPtr_3c.get());
        target._6c.setPointer(sp18._38.getPointer());
        FUN_8097174();

        if(sp04 == 0x1) {
          getMapActor_(sp18.casterMapActorIndex_18.get())._5a.or(0x1);
        }

        //LAB_8097f32
        FUN_809748c();
        FUN_80981b0(moveHand);
      }
    }

    //LAB_8097f3c
  }

  @Method(0x809802c)
  public static void FUN_809802c() {
    final FieldPsynergy720 r3 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    FUN_8097384();
    final Actor70 r5 = allocateMoveHand(r3.caster_10.deref());
    FUN_8098184(r5);
    if(r5 != null) {
      setActorAnimation_(r5, 4);
      sleep(30);
    }

    //LAB_8098058
    FUN_809748c();
    FUN_80981b0(r5);
  }

  @Method(0x8098070)
  public static Actor70 allocateMoveHand(final Actor70 user) {
    final int r5 = (user.angle_06.get() & 0xffff) + 0x2000 & 0xc000;

    // Allocate hand
    final Actor70 hand = FUN_8096c80(0xd7, user.pos_08.getX(), user.pos_08.getY() + 0x100000, user.pos_08.getZ());
    if(hand == null) {
      return null;
    }

    //LAB_80980aa
    hand._1c.set(0x4000);
    hand.scale_18.set(0x4000);
    hand._6c.set(getConsumer(GoldenSun_809.class, "FUN_8097b70", Actor70.class));
    hand.velocityScalar_30.set(0x20000);
    hand.acceleration_34.set(0x20000);
    hand._55.set(0);
    setActorAnimation_(hand, 3);
    FUN_8096bec(hand, 0x100000, r5);

    // Allocate little burst of particles from hand
    //LAB_80980dc
    for(int i = 0; i < 8; i++) {
      final Actor70 r7 = FUN_8096c80(0x11d, user.pos_08.getX(), user.pos_08.getY() + 0x100000, user.pos_08.getZ());
      if(r7 != null) {
        setActorSpriteScript_(r7, 0x809f0d4);
        r7.acceleration_34.set(0x10000);
        r7.velocityScalar_30.set(rand() + 0x10000);
        r7._55.set(0x2);
        r7._48.set(0x51e);
        r7.velocity_24.setY(rand() - rand());
        FUN_8096bec(r7, rand() * 0x18 + 0x80000, (rand() - rand() >>> 3) + (user.angle_06.get() & 0xffff));
      }

      //LAB_8098152
    }

    playSound_(0x8a);
    return hand;
  }

  @Method(0x8098184)
  public static void FUN_8098184(final Actor70 r0) {
    if(r0 != null) {
      int r2 = r0.scale_18.get();
      if(r2 < 0x10000) {
        //LAB_8098198
        while(r2 < 0x10000) {
          r2 += 0x1000;
        }

        r0.scale_18.set(r2);
        r0._1c.set(r2);
      }

      //LAB_80981a4
      FUN_8009158(r0);
    }
  }

  @Method(0x80981b0)
  public static void FUN_80981b0(final Actor70 r0) {
    CPU.push(CPU.r8().value);
    playSound_(0x9a);
    CPU.r8().value = 0x1e;

    //LAB_80981c6
    do {
      r0.pos_08.y_04.add(0x10000);
      r0.angle_06.add(0x2000);
      r0.scale_18.sub(0x800);
      r0._1c.sub(0x800);
      sleep(1);
      CPU.r8().value--;
    } while(CPU.r8().value >= 0x0);

    CPU.r8().value = 7;

    //LAB_8098202
    do {
      final Actor70 r6 = FUN_8096c80(0x11d, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      if(r6 != null) {
        setActorSpriteScript_(r6, 0x809f0d4);
        r6.acceleration_34.set(0x10000);
        r6.velocityScalar_30.set(rand() + 0x10000);
        r6._55.set(0x2);
        r6._48.set(0xa3d);
        r6.velocity_24.setY(rand() - rand());
        FUN_8096bec(r6, rand() * 24 + 0x80000, rand());
      }

      //LAB_809825e
      CPU.r8().value--;
    } while(CPU.r8().value >= 0x0);

    playSound_(0x83);
    clearActor_(r0);
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80983a0)
  public static void FUN_80983a0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80984c0)
  public static void FUN_80984c0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80985a8)
  public static void FUN_80985a8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80985fc)
  public static void FUN_80985fc() {
    final FieldPsynergy720 r7 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    FUN_8098698();
    playSound_(0x86);
    final Vec3 r6 = new Vec3();

    //LAB_8098618
    for(int i = 0; i < 5; i++) {
      r6.setX(r7.pos_04.getX());
      r6.setZ(r7.pos_04.getZ());
      rotVec3(rand() * 6 + 0x40000, rand(), r6);
      r6.setY(r7.pos_04.getY());
      final Actor70 r5 = FUN_8096c80(0xd9, r6.getX(), r7.pos_04.getY(), r6.getZ());
      if(r5 != null) {
        setActorSpriteScript_(r5, 0x809f11c);
        r5._55.set(2);
      }

      //LAB_8098660
      sleep((rand() * 2 >>> 16) + 2);
    }

    sleep(30);
    FUN_809748c();
  }

  @Method(0x8098698)
  public static void FUN_8098698() {
    final FieldPsynergy720 r9 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r7 = r9.caster_10.deref();
    FUN_8097384();
    final Vec3 r8 = new Vec3();

    //LAB_80986bc
    for(int r11 = 0; r11 < 24; r11++) {
      final int r3 = r9.angle_00.get();
      if(r3 == 0x4000) {
        r8.set(r7.pos_08);
        //LAB_80986d6
      } else if(r3 == 0xc000) {
        r8.setX(r7.pos_08.getX());
        r8.setY(r7.pos_08.getY() + 0x180000);
        r8.setZ(r7.pos_08.getZ());
      } else {
        //LAB_80986f8
        r8.setX(r7.pos_08.getX());
        r8.setY(r7.pos_08.getY() + 0xa0000);
        r8.setZ(r7.pos_08.getZ());
        rotVec3(0xa0000, r9.angle_00.get(), r8);
      }

      //LAB_8098716
      final Actor70 r6 = FUN_8096c80(0x11c, r8.getX(), r8.getY(), r8.getZ());
      final Sprite38 r4 = r6.sprite_50.deref();
      r4.shadowPacket_0c.attribs_04.flags_01.and(~0x20).or(r4.packet_00.attribs_04.flags_01.get() & 0x20);
      r4.shadowPacket_0c.attribs_04.flags_01.and(0x3f).or(r4.packet_00.attribs_04.flags_01.get() & ~0x3f);
      r4.shadowPacket_0c.attribs_04.attrib1_02.and(0x3fff).or(r4.packet_00.attribs_04.attrib2_04.get() & ~0x3fff);
      r4.shadowPacket_0c.attribs_04.attrib2_04.and(~0x3ff).or(r4.packet_00.attribs_04.attrib2_04.get() & 0x3ff);
      r4.shadowPacket_0c.attribs_04.attrib2_04.and(0xfff).or(r4.packet_00.attribs_04.attrib2_04.get() & ~0xfff);

      if(r6 != null) {
        r6.scale_18.set(0xb333);
        r6._1c.set(0xb333);
        r6.velocityScalar_30.set(0x18000);
        r6.acceleration_34.set(0x18000);
        r6._55.set(0);
        FUN_8009240(r6, 11);
        setActorAnimation_(r6, 7);
        setActorSpriteScript_(r6, 0x809f0b4);
        FUN_80091e0(r6, 1);
        r8.set(r9.pos_04);

        if(r9.angle_00.get() == 0xc000) {
          rotVec3(0xe0000, 0xc000, r8);
        }

        //LAB_80987e4
        rotVec3(rand() * 6 + 0x40000, rand(), r8);
        moveActorTo_(r6, r8.getX(), r8.getY(), r8.getZ());
      }

      //LAB_8098812
      playSound_(0x83);
      sleep(2);
    }

    //LAB_809882c
    sleep(8);
  }

  @Method(0x8098848)
  public static void FUN_8098848(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8098954)
  public static void FUN_8098954() {
    final FieldPsynergy720 r10 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    FUN_8097384();
    final Vec3 r5 = new Vec3();
    r5.setX(r10.pos_04.getX());
    r5.setY(r10.pos_04.getY() + 0x100000);
    r5.setZ(r10.pos_04.getZ());
    final Actor70[] sp0x00 = {FUN_8098a84(r5.getX() + 0x200000, r5.getY(), r5.getZ(), 0x8000), FUN_8098a84(r5.getX() - 0x200000, r5.getY(), r5.getZ(), 0)};
    sleep(15);

    //LAB_80989b6
    for(int r8 = 0; r8 < 2; r8++) {
      final Actor70 r6 = sp0x00[r8];
      if(r6 != null) {
        FUN_8096bec(r6, 0x180000, r6.angle_06.get() & 0xffff);
      }

      //LAB_80989c8
    }

    FUN_8009158(sp0x00[0]);
    playSound_(0x86);

    //LAB_80989ec
    for(int r8 = 0; r8 < 24; r8++) {
      r5.setX(r10.pos_04.getX());
      r5.setY(r10.pos_04.getY() + 0x100000);
      r5.setZ(r10.pos_04.getZ());

      final Actor70 r6 = FUN_8096c80(0x11d, r5.getX(), r5.getY(), r5.getZ());
      if(r6 != null) {
        setActorSpriteScript_(r6, 0x809f0d4);
        r6.velocityScalar_30.set(0x20000 + rand());
        r6.acceleration_34.set(0x20000);
        r6._55.set(0);
        FUN_8096bec(r6, rand() * 0x18 + 0x80000, rand());
      }

      //LAB_8098a44
    }

    clearActor_(sp0x00[0]);
    clearActor_(sp0x00[1]);
    FUN_809748c();
  }

  @Method(0x8098a84)
  public static Actor70 FUN_8098a84(final int x, final int y, final int z, final int angle) {
    playSound_(0x8a);
    final Actor70 r5 = FUN_8096c80(0xd7, x, y, z);
    if(r5 != null) {
      r5.scale_18.set(0x4000);
      r5._1c.set(0x4000);
      r5.velocityScalar_30.set(0x30000);
      r5.acceleration_34.set(0x30000);
      r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
      setActorAnimation_(r5, 3);

      //LAB_8098ad8
      while(r5.scale_18.get() < 0x10000) {
        r5.scale_18.add(0x800);
        r5._1c.set(r5.scale_18.get());
        r5.angle_06.add(0x2000);
        sleep(1);
      }

      //LAB_8098b00
      r5.angle_06.set(angle);
    }

    //LAB_8098b02
    return r5;
  }

  @Method(0x8098ccc)
  public static void FUN_8098ccc(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8098cd8)
  public static void FUN_8098cd8() {
    final FieldPsynergy720 r9 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 sp08 = r9.target_14.deref();
    FUN_8097384();
    playSound_(0x82);
    final Vec3 r10 = new Vec3();
    int r8;

    //LAB_8098d0a
    for(r8 = 0; r8 < 12; r8++) {
      final Actor70 r2 = r9.caster_10.deref();
      final FieldPsynergy720.Sub48 r5 = r9._58.get(r8);
      r10.setX(r2.pos_08.getX());
      r10.setY(r2.pos_08.getY() + 0x100000);
      r10.setZ(r2.pos_08.getZ());
      FUN_80974d8(r10);
      FUN_809ba90(r5, 0x11c, r10.getX(), r10.getZ());
      FUN_809ba7c(r5, getConsumer(GoldenSun_809.class, "FUN_8098b10", FieldPsynergy720.Sub48.class));
      setFieldPsynergyInstanceSpriteIndex(r5, 7);
      FUN_800b684(r5.sprite_00.deref(), 9);
      r5._2c.set(0xb333);
      r5._28.set(0xb333);
      sleep(2);
    }

    final Actor70 r2 = r9.caster_10.deref();
    r10.setX(r2.pos_08.getX());
    r10.setY(r2.pos_08.getY() + 0x100000);
    r10.setZ(r2.pos_08.getZ());
    rotVec3(0x80000, r9.angle_00.get(), r10);
    final Actor70 r6 = FUN_8096c80(0xd7, r10.getX(), r10.getY(), r10.getZ());
    if(r6 == null) {
      FUN_809748c();
    } else {
      //LAB_8098db4
      r6.angle_06.set(r9.angle_00.get());
      r6.scale_18.set(0x4000);
      r6._1c.set(0x4000);
      r6.velocityScalar_30.set(0x40000);
      r6.acceleration_34.set(0x40000);
      r6._55.set(0);
      setActorAnimation_(r6, 5);
      FUN_8009240(r6, 3);

      //LAB_8098df4
      while(r6.scale_18.get() < 0x10000) {
        r6.scale_18.add(0x500);
        r6._1c.set(r6.scale_18.get());
        sleep(1);
      }

      //LAB_8098e0c
      sleep(3);
      final Actor70[] sp04 = new Actor70[3];
      Sprite38 r11 = null;

      //LAB_8098e22
      for(r8 = 2; r8 >= 0; r8--) {
        final Actor70 r5 = FUN_8096c80(0xd7, r6.pos_08.getX(), r6.pos_08.getY(), r6.pos_08.getZ());
        sp04[r8] = r5;

        if(r5 != null) {
          r5._1c.set(0xf000);
          r5.scale_18.set(0xf000);
          r5.angle_06.set(r9.angle_00.get());
          r5.velocityScalar_30.set(0x40000);
          r5.acceleration_34.set(0x40000);
          r5._55.set(0);
          setActorAnimation_(r5, 5);
          FUN_8009240(r5, 2);
          r11 = FUN_8096c48(r5.sprite_50.deref(), r11);
        }

        //LAB_8098e70
      }

      final int slot = r11.slot_1c.get();
      if(r9._20.get() != 0x0) {
        r10.setX(r2.pos_08.getX());
        r10.setY(r2.pos_08.getY() + 0x100000);
        r10.setZ(r2.pos_08.getZ());
        rotVec3(0x380000, r9.angle_00.get(), r10);
      } else {
        //LAB_8098eb8
        r10.setX(r9.pos_04.getX());
        r10.setY(r9.pos_04.getY() + 0x100000);
        r10.setZ(r9.pos_04.getZ());
      }

      //LAB_8098ece
      moveActorTo_(r6, r10.getX(), r10.getY(), r10.getZ());
      setActorSpriteScript_(r6, 0x809f12c);

      //LAB_8098eee
      for(r8 = 0; r8 < 3; r8++) {
        final Actor70 r5 = sp04[r8];
        if(r5 != null) {
          sleep(3);
          moveActorTo_(r5, r10.getX(), r10.getY(), r10.getZ());
          setActorSpriteScript_(r5, 0x809f0b4);
        }

        //LAB_8098f14
      }

      //LAB_8098f2a
      for(r8 = 0; r8 < 60 && r6.scriptPtr_00.get() != 0; r8++) {
        sleep(1);
      }

      //LAB_8098f40
      if(sp08 != null && r9._35.get() == 0) {
        if(r9._34.get() != 0) {
          sp08.velocity_24.setY(0x80000);
        }

        //LAB_8098f68
        r10.set(sp08.pos_08);
        rotVec3(0x100000, r9.angle_00.get(), r10);

        if(FUN_80091d8(sp08, r10) == 0 && FUN_800d924(sp08, r10) == 0) {
          sp08.velocityScalar_30.set(0x10000);
          sp08.acceleration_34.set(0x10000);
          moveActorTo_(sp08, r10.getX(), r10.getY(), r10.getZ());
        }
      }

      //LAB_8098fb8
      final IntRef sp0x0c = new IntRef();
      final EventStruct0c r0 = FUN_808e4b4(0x50000005, 4, sp0x0c);
      if(r0 != null) {
        FUN_8096b28(r0, playerMapActorIndex_2000434.get(), sp0x0c.get());
      }

      //LAB_8098fd6
      sleep(10);
      FUN_809748c();
      sleep(20);

      if(slot != 0x60) {
        clearVramSlot(slot);
      }
    }

    //LAB_8098ff2
  }

  @Method(0x8099128)
  public static void FUN_8099128(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8099160)
  public static void FUN_8099160() {
    final FieldPsynergy720 r8 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r9 = r8.target_14.deref();
    FUN_8097384();
    playSound_(0x73);
    final Vec3 r7 = new Vec3();

    //LAB_8099186
    for(int r10 = 0; r10 < 16; r10++) {
      final Actor70 r6 = FUN_8096c80(0xe8, 0, 0, 0);
      if(r6 != null) {
        final int r0 = (rand() >>> 1) + 0x8000;
        r6.scale_18.set(r0);
        r6._1c.set(r0);

        final ConsumerRef<Actor70> r3;
        if((rand() & 0x1) != 0x0) {
          r3 = getConsumer(GoldenSun_809.class, "FUN_8099070", Actor70.class);
        } else {
          //LAB_80991b8
          r3 = getConsumer(GoldenSun_809.class, "FUN_80990cc", Actor70.class);
        }

        //LAB_80991ba
        r6.angle_06.set(rand());
        r6._64.set(60);
        r6._66.set(rand());
        r6._6c.set(r3);
        FUN_8009240(r6, 9);
        r7.set(r8.pos_04);
        rotVec3(rand() * 0x4 + 0x20000, rand(), r7);
        r6.dest_38.set(r7);
      }

      //LAB_8099212
      sleep(3);
    }

    sleep(10);
    playSound_(0x73);
    sleep(50);

    if(r9 != null && r8._20.get() == 0) {
      playSound_(0xd4);

      //LAB_8099254
      for(int r10 = 0; r10 < 16; r10++) {
        FUN_8009240(r9, 7);
        sleep(1);
        FUN_8009240(r9, 0);
        sleep(4);
      }

      if(r8._34.get() == 0x0) {
        playSound_(0xdc);
        setActorAnimation_(r9, 2);
      }

      //LAB_8099298
      r9._6c.set(getConsumer(GoldenSun_809.class, "FUN_8099018", Actor70.class));

      final IntRef sp0x00 = new IntRef();
      final EventStruct0c r0 = FUN_808e4b4(0x50000005, 6, sp0x00);
      if(r0 != null) {
        FUN_8096b28(r0, playerMapActorIndex_2000434.get(), sp0x00.get());
      }

      //LAB_80992bc
      sleep(20);
    }

    //LAB_80992c2
    FUN_809748c();
  }

  @Method(0x80994c0)
  public static void FUN_80994c0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80994d0)
  public static void FUN_80994d0() {
    final FieldPsynergy720 r10 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r6 = r10.caster_10.deref();
    FUN_8097384();
    Sprite38 r8 = null;

    //LAB_80994ec
    int r7;
    for(r7 = 0; r7 < 8; r7++) {
      final Actor70 r5 = FUN_8096c80(0xe9, r6.pos_08.getX(), r6.pos_08.getY() + 0x200000, r6.pos_08.getZ());
      if(r5 != null) {
        r5._1c.set(0xb333);
        r5.scale_18.set(0xb333);
        r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_8099340", Actor70.class));
        r5._64.set(0x78);
        r5._66.set(r7 * 0x2000);
        r5._55.set(0x4);
        r8 = FUN_8096c48(r5.sprite_50.deref(), r8);
      }

      //LAB_809952c
      sleep(1);
    }

    playSound_(0x82);
    sleep(0x6e);
    final Actor70 actor = FUN_8096c80(0xe9, 0, 0, 0);
    if(actor != null) {
      actor._1c.set(0xb333);
      actor.scale_18.set(0xb333);
      actor.pos_08.setX(r10.pos_04.getX());
      actor.pos_08.setY(r10.pos_04.getY() + 0x100000);
      actor.pos_08.setZ(r10.pos_04.getZ());
      actor._55.set(0x4);
      FUN_8009240(actor, 7);
    }

    //LAB_8099588
    playSound_(0x83);
    sleep(0xc);

    if(actor != null) {
      //LAB_809959e
      for(r7 = 0; r7 < 30; r7++) {
        if((r7 & 0x3) != 0x0) {
          FUN_8009240(actor, 9);
        } else {
          //LAB_80995b2
          FUN_8009240(actor, 10);
        }

        //LAB_80995ba
        sleep(2);
      }
    }

    //LAB_80995c6
    FUN_8009240(actor, 0);
    playSound_(0x54);
    if(actor != null) {
      actor._6c.set(getConsumer(GoldenSun_809.class, "FUN_80993b0", Actor70.class));
      actor._64.set(0);
      if(r10._20.get() != 0x0) {
        sleep(128);
      } else {
        //LAB_80995fa
        sleep(192);
      }
    }

    //LAB_8099600
    if(actor != null) {
      actor._64.set(0xffff);
      actor.velocityScalar_30.set(0x50000);
      actor.acceleration_34.set(0x6666);
      actor._5a.set(0);
      FUN_8096bec(actor, 0xc00000, 0xe800);
      FUN_8009158(actor);
      clearActor_(actor);
    }

    //LAB_8099636
    if(r8.slot_1c.get() != 0x60) {
      clearVramSlot(r8.slot_1c.get());
    }

    //LAB_8099642
    if(!r10._24.isNull()) {
      r10._24.deref().run();
    }

    //LAB_809964e
    FUN_809748c();
  }

  @Method(0x8099810)
  public static void FUN_8099810() {
    if(_200048c.get() != 0) {
      setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8099678"), 0xc80);
    }

    //LAB_809982c
  }

  @Method(0x8099838)
  public static void FUN_8099838() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80999e4)
  public static void FUN_80999e4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80999f0)
  public static void FUN_80999f0() {
    final FieldPsynergy720 r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r10 = r6.caster_10.deref();

    final Actor70 r7 = FUN_8096c80(0xef, 0, 0, 0);
    if(r7 != null) {
      //LAB_8099a1e
      FUN_8097384();
      playSound_(0x8a);
      if(r6.target_14.isNull()) {
        r6.pos_04.setX(r10.pos_08.getX());
        r6.pos_04.setZ(r10.pos_08.getZ());
        rotVec3(0x100000, r6.angle_00.get(), r6.pos_04);
        r6.pos_04.setY(getHeight_(0, r6.pos_04.getX(), r6.pos_04.getZ()));
      }

      //LAB_8099a52
      final Vec3 sp04 = new Vec3();
      sp04.setX(r10.pos_08.getX());
      sp04.setY(r10.pos_08.getY() + 0x100000);
      sp04.setZ(r10.pos_08.getZ());
      final Vec3 r11 = new Vec3();
      r11.setX(r6.pos_04.getX());
      final int r2 = r6.pos_04.getY();
      r11.setY(r2 + 0x200000);
      r11.setZ(r6.pos_04.getZ());

      if(r6._34.get() != 0x0) {
        r11.setY(r2 + 0x500000);
      }

      //LAB_8099a9e

      //LAB_8099aa4
      for(int r8 = 0; r8 < 11; r8++) {
        r7.pos_08.setX(divideS(r8 * (r11.getX() - sp04.getX()), 10) + sp04.getX());
        r7.pos_08.setY(divideS(r8 * (r11.getY() - sp04.getY()), 10) + sp04.getY());
        r7.pos_08.setZ(divideS(r8 * (r11.getZ() - sp04.getZ()), 10) + sp04.getZ());
        final int r0 = divideS(r8 * 0xc000, 10) + 0x4000;
        r7.scale_18.set(r0);
        r7._1c.set(r0);
        sleep(1);
      }

      sleep(10);

      if(r6._45.get() == 0) {
        final int r9;
        if(r6._20.get() == 0x0) {
          r9 = 24;
        } else {
          r9 = 10;
        }

        //LAB_8099b3e
        final Vec3 sp0x20 = new Vec3();

        //LAB_8099b50
        for(int r8 = 0; r8 < r9; r8++) {
          sp0x20.set(r7.pos_08);
          rotVec3(rand() * 0x5 + 0x30000, rand(), sp0x20);
          if(r8 == r9 - 1) {
            sleep(25);
            sp0x20.set(r7.pos_08);
          }

          //LAB_8099b92
          final Actor70 r5 = FUN_8096c80(0xf0, sp0x20.getX(), sp0x20.getY(), sp0x20.getZ());
          if(r5 != null) {
            r5._14.set(sp0x20.getY() - 0x200000);
            r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_8099920", Actor70.class));
            r5._55.set(2);
          }

          //LAB_8099bb8
          playSound_(0x84);
          sleep(6);
        }

        //LAB_8099bcc
        sleep(10);
      } else {
        //LAB_8099bd4
        final int r9;
        if(r6._20.get() == 0) {
          r9 = 30;
        } else {
          r9 = 10;
        }

        //LAB_8099bea
        final Vec3 sp0x20 = new Vec3();

        //LAB_8099bf4
        for(int r8 = 0; r8 < r9; r8++) {
          sp0x20.set(r7.pos_08);
          rotVec3(rand() * 0x5 + 0x30000, rand(), sp0x20);
          final Actor70 r5 = FUN_8096c80(0x11c, sp0x20.getX(), sp0x20.getY(), sp0x20.getZ());
          if(r5 != null) {
            r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_80999a8", Actor70.class));
            r5._55.set(0);
            r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
            setActorAnimation_(r5, 8);
            FUN_8009240(r5, 7);
          }

          //LAB_8099c5e
          sleep(6);
        }

        //LAB_8099c70
        sleep(70);
      }

      //LAB_8099c76
      //LAB_8099c7e
      for(int r8 = 0; r8 < 11; r8++) {
        r7.pos_08.setX(divideS(r8 * (sp04.getX() - r11.getX()), 10) + r11.getX());
        r7.pos_08.setY(divideS(r8 * (sp04.getY() - r11.getY()), 10) + r11.getY());
        r7.pos_08.setZ(divideS(r8 * (sp04.getZ() - r11.getZ()), 10) + r11.getZ());
        final int r0 = divideS(r8 * -0xc000, 10) + 0x10000;
        r7.scale_18.set(r0);
        r7._1c.set(r0);
        sleep(1);
      }

      clearActor_(r7);
      FUN_809748c();
    }

    //LAB_8099cf0
  }

  @Method(0x8099d18)
  public static void FUN_8099d18() {
    final FieldPsynergy720 r3 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r5 = r3.target_14.deref();
    final Vec3 r6 = new Vec3();
    r6.setX(r5.pos_08.getX());
    r6.setY(r5.pos_08.getY() - rand() * 0x10 + 0x180000);
    r6.setZ(r5.pos_08.getZ());
    rotVec3(rand() * 0x30, rand(), r6);
    final Actor70 actor = FUN_8096c80(0x11d, r6.getX(), r6.getY(), r6.getZ());
    if(actor != null) {
      actor._55.set(2);
      actor._48.set(0x1999);
      setActorAnimation_(actor, 0);
      actor._5e.set(0xc);
      setActorSpriteScript_(actor, 0x809f0b0);
    }

    //LAB_8099d8a
  }

  /** Using carry */
  @Method(0x8099da4)
  public static void FUN_8099da4() {
    final FieldPsynergy720 r11 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 sp1c = r11.caster_10.deref();
    final Actor70 r7 = r11.target_14.deref();
    if(r7 != null) {
      //LAB_8099dc6
      FUN_8097384();
      sp1c.parent_68.set(r7);
      setActorSpriteScript_(sp1c, 0x809f0bc);
      final Vec3 r10 = new Vec3();
      r10.setX(r11.pos_04.getX());
      r10.setY(r11.pos_04.getY() + 0x100000);
      r10.setZ(r11.pos_04.getZ());
      final Actor70 sp14 = FUN_809a3c4(r10.getX() + 0x200000, r10.getY(), r10.getZ(), 0x8000);
      final Actor70 sp18 = FUN_809a3c4(r10.getX() - 0x200000, r10.getY(), r10.getZ(), 0);
      if(sp14 == null || sp18 == null) {
        //LAB_8099e28
        FUN_809748c();
      } else {
        //LAB_8099e2e
        sleep(15);
        r10.setX(r7.pos_08.getX());
        r10.setY(r7.pos_08.getY() + 0x100000);
        r10.setZ(r7.pos_08.getZ());
        moveActorTo_(sp14, r10.getX() + 0x100000, r10.getY(), r10.getZ());
        moveActorTo_(sp18, r10.getX() - 0x100000, r10.getY(), r10.getZ());
        FUN_8009158(sp14);
        FUN_8009158(sp18);
        sp14.pos_08.setX(r10.getX() + 0x100000);
        sp18.pos_08.setX(r10.getX() - 0x100000);
        sp14.velocity_24.setX(0);
        sp18.velocity_24.setX(0);
        r7._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096b88", Actor70.class));
        setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8099d18"), 0xc80);
        playSound_(0x82);
        r7._55.set(0x4);
        FUN_80091e0(r7, 0);

        if(sp14 != null && sp18 != null) {
          //LAB_8099ed4
          while(r7.pos_08.getY() - r7._14.get() <= 0x180000) {
            sp14.pos_08.y_04.add(0x6000);
            sp18.pos_08.y_04.add(0x6000);
            r7.pos_08.y_04.add(0x6000);
            sleep(1);
          }
        }

        //LAB_8099efe
        sp14.velocityScalar_30.set(0x40000);
        sp14.acceleration_34.set(0x8000);
        sp18.velocityScalar_30.set(0x40000);
        sp18.acceleration_34.set(0x8000);
        r7.velocityScalar_30.set(0x6666);
        r7.acceleration_34.set(0x3333);
        r7._5a.set(0);
        r7.layer_22.set(2);

        //LAB_809a0e8
        do {
          sleep(1);

          if((pressedButtons_3001c94.get() & 0x303) != 0x0) {
            break;
          }

          r10.setX(r7.pos_08.getX());
          r10.setY(r7.pos_08.getY() + 0x100000);
          r10.setZ(r7.pos_08.getZ());

          final int r6 = getAngleForHeldDirectionalButtons() & 0xffff;
          if(r6 == 0xffff) {
            moveActorTo_(sp14, r10.getX() + 0x100000, r10.getY(), r10.getZ());
            moveActorTo_(sp18, r10.getX() - 0x100000, r10.getY(), r10.getZ());
            setActorAnimation_(sp14, 1);
            setActorAnimation_(sp18, 1);
          } else {
            //LAB_8099f84
            rotVec3(0x20000, r6, r10);
            moveActorTo_(sp14, r10.getX() + 0x100000, r10.getY(), r10.getZ());
            moveActorTo_(sp18, r10.getX() - 0x100000, r10.getY(), r10.getZ());
            FUN_8009158(sp14);
            FUN_8009158(sp18);
            r10.setX(r7.pos_08.getX());
            r10.setY(r7._14.get());
            r10.setZ(r7.pos_08.getZ());
            rotVec3(0x100000, r6, r10);

            if(FUN_800d924(r7, r10) == 0) {
              r7._14.add(0x100000);
              final int ret = FUN_80091d8(r7, r10);
              r7._14.sub(0x100000);

              if(ret <= 0) {
                //LAB_809a02e
                playSound_(0xaf);
                setActorAnimation_(sp14, 4);
                setActorAnimation_(sp18, 4);
                sleep(15);
                r7._5b.set(0);
                r7.velocityScalar_30.set(0x3333);
                r7.acceleration_34.set(0x3333);
                moveActorTo_(r7, r10.getX(), r10.getY(), r10.getZ());
                sp14.velocityScalar_30.set(0x3333);
                sp14.acceleration_34.set(0x3333);
                sp18.velocityScalar_30.set(0x3333);
                sp18.acceleration_34.set(0x3333);
                moveActorTo_(sp14, r10.getX() + 0x100000, r10.getY(), r10.getZ());
                moveActorTo_(sp18, r10.getX() - 0x100000, r10.getY(), r10.getZ());
                FUN_8009158(r7);
                r7.pos_08.setX(r10.getX());
                r7.pos_08.setZ(r10.getZ());
                r7.velocity_24.setX(0);
                r7.velocity_24.setZ(0);
                sleep(10);
                break;
              }
            }

            //LAB_809a00a
            setActorAnimation_(sp14, 4);
            setActorAnimation_(sp18, 4);
            if((_3001e40.get() & 0xf) == 0x0) {
              playSound_(0x72);
            }
          }
        } while(true);

        //LAB_809a0fc
        setActorAnimation_(sp14, 4);
        setActorAnimation_(sp18, 4);
        clearTickCallback(getRunnable(GoldenSun_809.class, "FUN_8099d18"));
        playSound_(0x87);
        sleep(15);
        playSound_(0x87);
        sleep(15);
        r10.setX(r7.pos_08.getX());
        r10.setY(r7.pos_08.getY() + 0x100000);
        r10.setZ(r7.pos_08.getZ());

        //LAB_809a14e
        for(int r8 = 0; r8 < 20; r8++) {
          final Actor70 r6 = FUN_8096c80(0x11d, r10.getX(), r10.getY(), r10.getZ());

          if(r6 != null) {
            setActorSpriteScript_(r6, 0x809f0d4);
            r6.velocityScalar_30.set(0x20000 + rand());
            r6.acceleration_34.set(0x20000);
            r6._55.set(0);
            FUN_8096bec(r6, rand() * 0x18 + 0x80000, rand());
          }

          //LAB_809a1a2
        }

        playSound_(0x83);
        clearActor_(sp14);
        clearActor_(sp18);
        FUN_8009240(r7, r11._44.get());
        setActorSpriteScript_(r7, r11.targetScriptPtr_3c.get());
        r7._6c.setPointer(r11._38.getPointer());
        r7._55.set(0x3);
        r7.velocity_24.setY(0xa0000);
        r7._44.set(0x3333);
        r7.layer_22.set(0);
        sp1c._6c.clear();
        FUN_8009240(sp1c, 0);

        if(r11._34.get() != 0x0) {
          //LAB_809a216
          for(int r8 = 0; r8 < 0x5a && r7.velocity_24.getY() >= 0; r8++) {
            sleep(1);
          }

          //LAB_809a22c
          sleep(1);

          //LAB_809a23c
          for(int r8 = 0; r8 < 0x5a && r7.velocity_24.getY() < 0; r8++) {
            sleep(1);
          }

          //LAB_809a252
          FUN_809a6b8(r7);
          FUN_809748c();
          sleep(30);
        } else {
          //LAB_809a264
          FUN_809748c();
        }
      }
    }

    //LAB_809a268
  }

  @Method(0x809a294)
  public static void FUN_809a294() {
    final FieldPsynergy720 r10 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    FUN_8097384();
    final Vec3 r5 = new Vec3();
    r5.setX(r10.pos_04.getX());
    r5.setY(r10.pos_04.getY() + 0x100000);
    r5.setZ(r10.pos_04.getZ());
    final Actor70[] r11 = {FUN_809a3c4(r5.getX() + 0x200000, r5.getY(), r5.getZ(), 0x8000), FUN_809a3c4(r5.getX() - 0x200000, r5.getY(), r5.getZ(), 0)};
    sleep(15);

    //LAB_809a2f6
    for(int i = 0; i < 2; i++) {
      final Actor70 r6 = r11[i];
      if(r6 != null) {
        FUN_8096bec(r6, 0x180000, r6.angle_06.get() & 0xffff);
      }

      //LAB_809a308
    }

    FUN_8009158(r11[0]);
    playSound_(0x86);

    //LAB_809a32c
    for(int i = 0; i < 24; i++) {
      r5.setX(r10.pos_04.getX());
      r5.setY(r10.pos_04.getY() + 0x100000);
      r5.setZ(r10.pos_04.getZ());
      final Actor70 r6 = FUN_8096c80(0x11d, r5.getX() - 0x200000, r5.getY(), r5.getZ());
      if(r6 != null) {
        setActorSpriteScript_(r6, 0x809f0d4);
        r6.velocityScalar_30.set(0x20000 + rand());
        r6.acceleration_34.set(0x20000);
        r6._55.set(0);
        FUN_8096bec(r6, rand() * 0x18 + 0x80000, rand());
      }

      //LAB_809a384
    }

    clearActor_(r11[0]);
    clearActor_(r11[1]);
    FUN_809748c();
  }

  @Method(0x809a484)
  public static void FUN_809a484(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5, final int a6, final int a7) {
    final Actor70 r9 = getMapActor_(0);

    final int r0_0;
    if((a6 & 0x100000) != 0x0 && a7 != 0x0) {
      r0_0 = MEMORY.ref(2, a7 + 0x18).get();
    } else {
      //LAB_809a4c2
      r0_0 = 0xde;
    }

    //LAB_809a4c6
    final Actor70 r6 = loadActor_(r0_0, r0, r1, r2);
    if(r6 != null) {
      //LAB_809a4d6
      final Sprite38 r8 = r6.sprite_50.deref();
      setActorAnimation_(r6, a6 + 1 & 0xf);
      setActorSpriteScript_(r6, MEMORY.ref(4, 0x80a012c + (a6 & 0xf) * 0x4).get());
      r8._26.set(0);
      r6._55.set(0);
      r6._6c.set(getConsumer(GoldenSun_809.class, "FUN_809a44c", Actor70.class));
      r6._44.set(r3);
      r6._48.set(a4);
      r6._4c.set(a5);
      r8.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r9.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
      r6.velocityScalar_30.set(0);
      r6.acceleration_34.set(0);
      r6._64.set(0);

      if((a6 & 0xffff0000) != 0x0 && a7 != 0x0) {
        if((a6 & 0x10000) != 0x0) {
          FUN_80929d8(r6, MEMORY.ref(4, a7 + 0x4).get());
        }

        //LAB_809a564
        if((a6 & 0x20000) != 0x0) {
          r6.flags_23.and(~0x1);
          r8.packet_00.attribs_04.attrib2_04.and(~0xc00).or((MEMORY.ref(1, a7).getUnsigned() & 0x3) << 10);
        }

        //LAB_809a590
        if((a6 & 0x80000) != 0x0) {
          r6.scale_18.set(MEMORY.ref(4, a7 + 0x8).get());
          r6._1c.set(MEMORY.ref(4, a7 + 0xc).get());
        }

        //LAB_809a5a4
        if((a6 & 0x40000) != 0x0) {
          final int r5_0 = MEMORY.ref(4, 0x80a012c + (a6 & 0xf) * 0x4).get();
          if((a6 & 0x80000) != 0x0) {
            r6.velocityScalar_30.set(divideS(MEMORY.ref(4, a7 + 0x10).get() - r6.scale_18.get(), MEMORY.ref(4, r5_0 + 0xc).get()));
            r6.acceleration_34.set(divideS(MEMORY.ref(4, a7 + 0x14).get() - r6._1c.get(), MEMORY.ref(4, r5_0 + 0xc).get()));
          } else {
            //LAB_809a5d2
            r6.velocityScalar_30.set(divideS(MEMORY.ref(4, a7 + 0x10).get() - 0x10000, MEMORY.ref(4, r5_0 + 0xc).get()));
            r6.acceleration_34.set(divideS(MEMORY.ref(4, a7 + 0x14).get() - 0x10000, MEMORY.ref(4, r5_0 + 0xc).get()));
          }
        }

        //LAB_809a5ee
        if((a6 & 0x200000) != 0x0) {
          setActorAnimation_(r6, 1);
          setActorSpriteScript_(r6, MEMORY.ref(4, a7 + 0x1c).get());
        }

        //LAB_809a60a
        if((a6 & 0x400000) != 0x0) {
          r8.rotation_1e.set(MEMORY.ref(2, a7 + 0x20).get());
        }

        //LAB_809a61c
        if((a6 & 0x800000) != 0x0) {
          r6._64.set(MEMORY.ref(2, a7 + 0x22).getUnsigned());
        }

        //LAB_809a62e
        if((a6 & 0x1000000) != 0x0) {
          r6._6c.setPointer(MEMORY.ref(4, a7 + 0x24).get());
        }
      }
    }

    //LAB_809a63e
  }

  @Method(0x809a6b8)
  public static void FUN_809a6b8(final Actor70 r0) {
    CPU.sp().value -= 0x44;
    final int r8 = CPU.sp().value + 0x1c;
    MEMORY.ref(4, r8 + 0x4).setu(0);
    MEMORY.ref(4, r8 + 0x24).setu(0x809a65d);
    MEMORY.ref(4, r8 + 0x8).setu(0xcccc);
    MEMORY.ref(4, r8 + 0xc).setu(0xcccc);
    final Vec3 r6 = new Vec3();

    //LAB_809a6da
    for(int r7 = 0; r7 <= 0x10; r7++) {
      r6.setX(cos(r7 << 12) * 3 / 2);
      r6.setY(0);
      r6.setZ(sin(r7 << 12));
      FUN_809a484(r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ(), r6.getX(), r6.getY(), r6.getZ(), 0x1090001, r8);
    }

    CPU.sp().value += 0x44;
  }

  @Method(0x809abb4)
  public static void FUN_809abb4() {
    final FieldPsynergy720 r9 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r5 = r9.caster_10.deref();
    r9.pos_04.setY(r5.pos_08.getY());
    final Actor70 r6 = FUN_8096c80(0xfa, 0, 0, 0);
    setActorAnimation_(r6, 0);
    if(r6 != null) {
      //LAB_809abea
      FUN_8097384();
      final Vec3 r1 = new Vec3();
      r1.setX(r5.pos_08.getX());
      r1.setY(r5.pos_08.getY() + 0x100000);
      r1.setZ(r5.pos_08.getZ());
      final Vec3 r2 = new Vec3();
      r2.setX(r9.pos_04.getX());
      r2.setY(r9.pos_04.getY() + 0x80000);
      r2.setZ(r9.pos_04.getZ());

      //LAB_809ac1e
      for(int r7 = 0; r7 < 11; r7++) {
        r6.pos_08.setX(divideS(r7 * (r2.getX() - r1.getX()), 10) + r1.getX());
        r6.pos_08.setY(divideS(r7 * (r2.getY() - r1.getY()), 10) + r1.getY());
        r6.pos_08.setZ(divideS(r7 * (r2.getZ() - r1.getZ()), 10) + r1.getZ());
        final int r0 = divideS(r7 * 0xc000, 10) + 0x4000;
        r6.scale_18.set(r0);
        r6._1c.set(r0);
        sleep(1);
      }

      sleep(5);
      setActorAnimation_(r6, 1);
      playSound_(0x6c);
      sleep(10);
      playSound_(0x6c);
      sleep(10);
      playSound_(0x6c);
      sleep(10);
      playSound_(0x6d);
      final Vec3 r8 = new Vec3();

      //LAB_809acd0
      for(int r10 = 0; r10 < 16; r10++) {
        r8.setX(r6.pos_08.getX());
        r8.setY(r6.pos_08.getY() + 0x80000);
        r8.setZ(r6.pos_08.getZ());
        FUN_80974d8(r8);
        rotVec3(0x40000, rand(), r8);

        final FieldPsynergy720.Sub48 r5_0 = r9._58.get(r10);
        FUN_809ba90(r5_0, 0x11d, r8.getX(), r8.getZ());
        FUN_809ba7c(r5_0, getConsumer(GoldenSun_809.class, "FUN_809aa98", FieldPsynergy720.Sub48.class));
        FUN_800b684(r5_0.sprite_00.deref(), 7);
      }

      r8.setX(r6.pos_08.getX());
      r8.setY(r6.pos_08.getY() + 0x80000);
      r8.setZ(r6.pos_08.getZ());
      sleep(8);
      clearActor_(r6);
      sleep(4);
      sleep(30);
      FUN_809748c();
    }

    //LAB_809ad52
  }

  @Method(0x809a3c4)
  public static Actor70 FUN_809a3c4(final int x, final int y, final int z, final int angle) {
    playSound_(0x8a);

    final Actor70 r5 = FUN_8096c80(0xd7, x, y, z);
    if(r5 != null) {
      r5.scale_18.set(0x4000);
      r5._1c.set(0x4000);
      r5.velocityScalar_30.set(0x30000);
      r5.acceleration_34.set(0x30000);
      r5._5a.set(0);
      setActorAnimation_(r5, 1);

      //LAB_809a414
      while(r5.scale_18.get() < 0x10000) {
        r5.scale_18.add(0x800);
        r5._1c.set(r5.scale_18.get());
        r5.angle_06.add(0x2000);
        sleep(1);
      }

      //LAB_809a43c
      r5.angle_06.set(angle);
    }

    //LAB_809a43e
    return r5;
  }

  @Method(0x809a8b8)
  public static void FUN_809a8b8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809a8c4)
  public static void FUN_809a8c4() {
    final FieldPsynergy720 r10 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r2 = r10.caster_10.deref();
    final Actor70 r11 = r10.target_14.derefNullable();
    final Vec3 r5 = new Vec3();
    r5.set(r2.pos_08);
    final Vec3 r6 = new Vec3();
    r6.setX(r10.pos_04.getX());
    r6.setY(r10.pos_04.getY() - 0x40000);
    r6.setZ(r10.pos_04.getZ());
    final Actor70 r7 = FUN_8096c80(0xda, 0, 0, 0);
    if(r7 != null) {
      //LAB_809a91c
      FUN_8097384();
      setActorAnimation_(r7, 2);

      //LAB_809a92a
      for(int r8 = 0; r8 < 11; r8++) {
        r7.pos_08.setX(divideS(r8 * (r6.getX() - r5.getX()), 10) + r5.getX());
        r7.pos_08.setY(divideS(r8 * (r6.getY() - r5.getY()), 10) + r5.getY());
        r7.pos_08.setZ(divideS(r8 * (r6.getZ() - r5.getZ()), 10) + r5.getZ());
        final int r0 = divideS(r8 * 0x10ccc, 10) + 0x4000;
        r7.scale_18.set(r0);
        r7._1c.set(r0);
        sleep(1);
      }

      r7.scale_18.set(0x1b333);
      r7._1c.set(0x14ccc);
      playSound_(0xa3);
      sleep(20);
      if(r10._20.get() == 0) {
        if(r11 != null) {
          r11._6c.set(getConsumer(GoldenSun_809.class, "FUN_809a890", Actor70.class));
        }

        //LAB_809a9be
        final Vec3 sp0x18 = new Vec3();

        //LAB_809a9c4
        for(int r8 = 0; r8 < 16; r8++) {
          sp0x18.setX(r7.pos_08.getX());
          sp0x18.setY(r7.pos_08.getY() + r8 * 0xcccc + 0x40000);
          sp0x18.setZ(r7.pos_08.getZ());
          rotVec3(rand() * 0x5 + 0x30000, rand(), sp0x18);
          final Actor70 actor = FUN_8096c80(0xf9, sp0x18.getX(), sp0x18.getY(), sp0x18.getZ());
          if(actor != null) {
            actor._6c.set(getConsumer(GoldenSun_809.class, "FUN_809a7f4", Actor70.class));
            actor.parent_68.set(r7);
            actor._64.set(0);
            actor._66.set(0);
            actor.angle_06.set(rand());
          }

          //LAB_809aa24
          sleep(6);
        }

        sleep(20);
        sleep(120);
      }

      //LAB_809aa40
      setActorAnimation_(r7, 1);
      sleep(30);
      playSound_(0x88);
      sleep(20);
      clearActor_(r7);
      FUN_809748c();
    }

    //LAB_809aa64
  }

  @Method(0x809ab98)
  public static void FUN_809ab98(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809ad90)
  public static void FUN_809ad90(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809ade8)
  public static void FUN_809ade8(final int actorIndex) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809ae3c)
  public static int FUN_809ae3c(final int r0) {
    if(FUN_80915dc(r0) == 0xff) {
      return -1;
    }

    //LAB_809ae4e
    return r0;
  }

  @Method(0x809ae58)
  public static void FUN_809ae58(final int r0) {
    FUN_809ae64();
  }

  /** Using move psynergy in the first cutscene */
  @Method(0x809ae64)
  public static void FUN_809ae64() {
    final FieldPsynergy720 r5 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70 r7 = r5.caster_10.deref();
    final Actor70 sp00 = r5.target_14.derefNullable();
    final Vec3 r11 = new Vec3();
    r11.setX(r7.pos_08.getX());
    r11.setY(r7.pos_08.getY() + 0x100000);
    r11.setZ(r7.pos_08.getZ());

    final Vec3 r9 = new Vec3();
    if(r5._20.get() != 0) {
      r9.setX(r7.pos_08.getX());
      r9.setY(r7.pos_08.getY() + 0x200000);
      r9.setZ(r7.pos_08.getZ());
      rotVec3(0x200000, r5.angle_00.get(), r9);
    } else {
      //LAB_809aec4
      r9.setX(r5.pos_04.getX());
      r9.setY(r5.pos_04.getY() + 0x200000);
      r9.setZ(r5.pos_04.getZ());
    }

    //LAB_809aedc
    final Vec3 r0 = new Vec3();
    r0.setX(r5.pos_04.getX());
    r0.setY(r5.pos_04.getY() + 0x200000);
    r0.setZ(r5.pos_04.getZ());

    final Actor70 r6 = FUN_8096c80(215, r0.getX(), r0.getY(), r0.getZ());
    if(r6 != null) {
      //LAB_809aefe
      FUN_8097384();
      playSound_(0x8a);
      r6.angle_06.set(r7.angle_06.get());
      r6.velocityScalar_30.set(0x14ccc);
      r6._55.set(0);
      setActorAnimation_(r6, 0x5);
      FUN_8009240(r6, 0x1);

      //LAB_809af38
      for(int i = 0; i < 11; i++) {
        r6.pos_08.setX(r11.getX() + divideS(i * (r9.getX() - r11.getX()), 10));
        r6.pos_08.setY(r11.getY() + divideS(i * (r9.getY() - r11.getY()), 10));
        r6.pos_08.setZ(r11.getZ() + divideS(i * (r9.getZ() - r11.getZ()), 10));
        final int r0_0 = divideS(i * 0xc000, 10) + 0x4000;
        r6.scale_18.set(r0_0);
        r6._1c.set(r0_0);
        sleep(1);
      }

      sleep(10);
      setActorAnimation_(r6, 0x6);
      sleep(15);

      //LAB_809afba
      for(int i = 0; i < 10; i++) {
        r6.pos_08.y_04.sub(0x20000);
        sleep(0x1);
      }

      setActorAnimation_(r6, 0x5);
      playSound_(0x84);

      if(sp00 != null) {
        setActorPosition_(sp00, -0x90000, sp00.pos_08.getY(), -0x90000);
      }

      //LAB_809afee
      sleep(20);

      //LAB_809aff6
      for(int i = 0; i < 13; i++) {
        r6.pos_08.y_04.add(0x18000);
        sleep(1);
      }

      sleep(10);
      playSound_(0x72);

      //LAB_809b01e
      for(int i = 0; i < 11; i++) {
        r6.pos_08.setX(r9.getX() + divideS(i * (r11.getX() - r9.getX()), 10));
        r6.pos_08.setY(r9.getY() + divideS(i * (r11.getY() - r9.getY()), 10));
        r6.pos_08.setZ(r9.getZ() + divideS(i * (r11.getZ() - r9.getZ()), 10));
        final int r0_0 = divideS(i * -0xc000, 10) + 0x10000;
        r6.scale_18.set(r0_0);
        r6._1c.set(r0_0);
        sleep(1);
      }

      clearActor_(r6);
      FUN_809748c();
    }

    //LAB_809b092
  }

  @Method(0x809b208)
  public static void FUN_809b208() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809b698)
  public static void FUN_809b698() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809b804)
  public static void FUN_809b804(final FieldPsynergy720.Sub48 r0) {
    if(r0._45.get() != 0) {
      r0._38.incr();

      if(r0._3a.get() != 0) {
        r0._3a.decr();
        //LAB_809b82a
      } else if(!r0._34.isNull()) {
        r0._34.deref().run(r0);
      }

      //LAB_809b836
      if(r0._45.get() != 0) {
        if(r0._43.get() != 0) {
          FUN_809b8f4(r0);
        }

        //LAB_809b852
        if(r0._44.get() != 0) {
          FUN_809b86c(r0);
        }
      }
    }

    //LAB_809b866
  }

  @Method(0x809b86c)
  public static void FUN_809b86c(final FieldPsynergy720.Sub48 r0) {
    CPU.sp().value -= 0x18;

    final Sprite38 r5 = r0.sprite_00.deref();
    final int r6;
    if((r0._47.get() & 0x4) != 0) {
      r6 = 0x1fc0000 - r0._08.get();
    } else {
      r6 = 0;
    }

    //LAB_809b88c
    MEMORY.ref(4, CPU.sp().value).setu(mul16(r0._28.get(), r5.scale_18.get()));
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(mul16(r0._2c.get(), r5.scale_18.get()));
    final int r2 = r0._04.get();
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r6);
    final int r0_0 = r0._08.get();
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0_0 + r6);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    CPU.cmpT(r2 + 0x1fffff, 0x12ffffe);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      if(r0_0 > -0x200000 && r0_0 < 0xe00000) {
        drawSprite_(r5, CPU.sp().value + 0x8, CPU.sp().value, 0);
      }
    }

    //LAB_809b8dc
    CPU.sp().value += 0x18;
  }

  @Method(0x809b8f4)
  public static void FUN_809b8f4(final FieldPsynergy720.Sub48 r6) {
    int r0;
    final int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r7;

    if(r6._0c.get() != 0x80000000) {
      //LAB_809b906
      r7 = r6._0c.get() - r6._04.get();
      r5 = r6._10.get() - r6._08.get();
      if(r6._41.get() != 0x0) {
        r0 = r7 / 0x10000;
        r3 = r5 / 0x10000;
        r0 = sqrt(r0 * r0 + r3 * r3) << 16;
        if(r0 < 0x800000) {
          r0 = sqrt16(mul16(r7, r7) + mul16(r5, r5));
        }

        //LAB_809b974
        if(r0 <= 0x80000) {
          FUN_809ba5c(r6, r6._0c.get(), r6._10.get());
          return;
        }
      }

      //LAB_809b988
      r4 = (short)atan2(r5, r7);
      if(r6._42.get() != 0x0) {
        r5 = r6._30.get();
        r3 = r4 - r5;
        r3 = r3 << 16;
        r2 = r3 >> 16;
        r3 = r2;
        if(r2 < 0x0) {
          r3 = -r2;
        }

        //LAB_809b9b2
        r1 = r6._32.get();
        if(r3 >= r1) {
          if(r2 < 0x0) {
            if(-r2 > r1) {
              r2 = -r1;
            }
          } else {
            //LAB_809b9ce
            if(r2 > r1) {
              r2 = r1;
            }
          }

          //LAB_809b9d4
          r3 = r2 + r5;
          r3 = r3 << 16;
          r4 = r3 >> 16;
        }
      }

      //LAB_809b9da
      r3 = r4 << 16;
      r0 = r3 >>> 16;
      r6._30.set(r0);
      r7 = r6._1c.get() + r6._24.get();
      r3 = r6._20.get();
      if(r7 > r3) {
        r7 = r3;
      }

      //LAB_809b9ee
      r3 = r0 << 16;
      r4 = r3 >> 16;
      r6._1c.set(r7);
      r6._04.add(mul16(cos(r4), r7));
      r6._08.add(mul16(sin(r4), r7));
    }

    //LAB_809ba1e
  }

  @Method(0x809ba34)
  public static int FUN_809ba34(final FieldPsynergy720.Sub48 r0) {
    if(r0._41.get() == 0) {
      return 0;
    }

    //LAB_809ba48
    final int r3 = r0._0c.get() ^ 0x80000000;
    return (-r3 | r3) >>> 31;
  }

  @Method(0x809ba5c)
  public static void FUN_809ba5c(final FieldPsynergy720.Sub48 r0, final int r1, final int r2) {
    r0._04.set(r1);
    r0._08.set(r2);
    r0._0c.set(0x80000000);
    r0._10.set(0x80000000);
    r0._1c.set(0);
  }

  @Method(0x809ba70)
  public static void setFieldPsynergyInstanceSpriteIndex(final FieldPsynergy720.Sub48 inst, final int spriteAnimation) {
    setSpriteAnimation_(inst.sprite_00.deref(), spriteAnimation);
  }

  @Method(0x809ba7c)
  public static void FUN_809ba7c(final FieldPsynergy720.Sub48 r0, final ConsumerRef<FieldPsynergy720.Sub48> r1) {
    r0._34.set(r1);
    r0._38.set(0);
    r0._3a.set(0);
    r0._40.set(0);
  }

  @Method(0x809ba90)
  public static void FUN_809ba90(final FieldPsynergy720.Sub48 inst, final int r1, final int r2, final int r3) {
    MEMORY.memfill(inst.getAddress(), 0x48, 0);

    final Sprite38 sprite = loadSprite_(r1);
    inst.sprite_00.setNullable(sprite);

    if(sprite != null) {
      sprite.packet_00.attribs_04.attrib2_04.and(~0xc00);
    }

    //LAB_809bac8
    FUN_809ba5c(inst, r2, r3);
    inst._20.set(0x20000);
    inst._28.set(0x10000);
    inst._2c.set(0x10000);
    inst._24.set(0x10000);
    inst._14.set(r2);
    inst._18.set(r3);
    inst.sprite_00.deref()._26.set(0);
    inst._41.set(0x1);
    inst._42.set(0x1);
    inst._43.set(0x1);
    inst._44.set(0x1);
    inst._45.set(0x1);
    inst._46.set(rand());
    inst._47.set(0x4);
    setFieldPsynergyInstanceSpriteIndex(inst, 1);
  }

  @Method(0x809bb34)
  public static void clearFieldPsynergyInstance(final FieldPsynergy720.Sub48 r0) {
    CPU.sp().value -= 0x4;

    if(!r0.sprite_00.isNull()) {
      clearSprite_(r0.sprite_00.deref());
    }

    //LAB_809bb44
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r0.getAddress());
    DMA.channels[3].CNT.setu(0x85000012);

    CPU.sp().value += 0x4;
  }

  @Method(0x809c138)
  public static void FUN_809c138(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809c3a4)
  public static void FUN_809c3a4() {
    throw new RuntimeException("Not implemented");
  }
}
