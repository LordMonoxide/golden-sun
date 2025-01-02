package org.goldensun.maps;

import org.goldensun.CopiedSegment8000770;
import org.goldensun.GoldenSun;
import org.goldensun.GoldenSun_801;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Map194;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;
import org.goldensun.types.Structccc;
import org.goldensun.types.TileAttributes04;
import org.goldensun.types.Vec3;

import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.playerMapActorIndex_2000434;
import static org.goldensun.GoldenSunVars.tileAttribs_2010000;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;

public final class Map132Overlay_87ced6c {
  private Map132Overlay_87ced6c() { }

  @Method(0x200806c)
  public static Actor70 FUN_200806c(final Vec3 r0) {
    final Structccc r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    //LAB_2008080
    for(int r5 = 8; r5 < 66; r5++) {
      final Actor70 actor = r2.actors_14.get(r5).deref();
      if(r0.getX() >> 20 == actor.pos_08.getX() >> 20) {
        if(r0.getY() / 0x10000 == actor.pos_08.getY() / 0x10000) {
          if(r0.getZ() >> 20 == actor.pos_08.getZ() >> 20) {
            return actor;
          }
        }
      }

      //LAB_20080ae
    }

    return null;
  }

  @Method(0x20080c4)
  public static void FUN_20080c4() {
    final Actor70 r8 = getMapActor(0);
    final int r3 = (r8.angle_06.get() & 0xffff) >>> 12;
    final int r1 = MEMORY.ref(4, 0x200b15c + r3 * 0x4).get();
    final Vec3 r7 = new Vec3();
    r7.setX(r8.pos_08.getX() + (r1 & 0xffff0000));
    r7.setY(r8.pos_08.getY());
    r7.setZ(r8.pos_08.getZ() + (r1 << 16));
    final Actor70 r6 = FUN_200806c(r7);
    if(r6 != null) {
      //LAB_2008114
      r7.setX(r6.pos_08.getX() + (r1 & 0xffff0000));
      r7.setY(r6.pos_08.getY());
      r7.setZ(r6.pos_08.getZ() + (r1 << 16));
      Actor70 r0 = FUN_200806c(r7);
      if(r0 == null || (r0._59.get() & 0x1) == 0) {
        //LAB_200814a
        r7.setX(r6.pos_08.getX());
        r7.setY(r6.pos_08.getY() + 0x100000);
        r7.setZ(r6.pos_08.getZ());
        r0 = FUN_200806c(r7);
        if(r0 == null || (r0._59.get() & 0x1) == 0) {
          //LAB_2008176
          r6.layer_22.set(0x2);
          r7.setX(r6.pos_08.getX() + (r1 & 0xffff0000));
          r7.setY(r6.pos_08.getY());
          r7.setZ(r6.pos_08.getZ() + (r1 << 16));

          if(FUN_80091d8(r6, r7) <= 0 && r6._62.get() == 0) {
            setActorAnimation(r8, 0x8);
            sleep(15);
            playSound(0xb9);
            r6.velocityScalar_30.set(0x3333);
            r6.acceleration_34.set(0x3333);
            FUN_8009150(r6, r7.getX(), r7.getY(), r7.getZ());
            r8.velocityScalar_30.set(0x3333);
            r8.acceleration_34.set(0x3333);
            FUN_8009150(r8, r7.getX(), r7.getY(), r7.getZ());
            FUN_8009158(r6);
            FUN_808a5e8();
            r6.pos_08.setX(r7.getX());
            r6.pos_08.setZ(r7.getZ());
            r6.velocity_24.setX(0);
            r6.velocity_24.setZ(0);
            r8.dest_38.setX(0x80000000);
            r8.dest_38.setZ(0x80000000);
            r8.velocity_24.setX(0);
            r8.velocity_24.setZ(0);
            r8.pos_08.x_00.and(~0xffff);
            r8.pos_08.z_08.and(~0xffff);
            setActorAnimation(r8, 0x1);
          }
        }
      }
    }

    //LAB_2008226
  }

  @Method(0x2008244)
  public static int fillTileTypes(final int layer, final int startX, final int startY, final int w, final int h, final int type) {
    final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    if(map != null) {
      final UnboundedArrayRef<TileAttributes04> tiles;
      if(layer < 3) {
        tiles = map.layers_104.get(layer).tiles_2c.deref().slice(startY * 0x80 + startX);
      } else {
        //LAB_200826e
        tiles = tileAttribs_2010000.slice(startY * 0x80 + startX);
      }

      //LAB_2008270
      //LAB_200827e
      for(int y = 0; y < h; y++) {
        //LAB_2008288
        for(int x = 0; x < w; x++) {
          tiles.get(y * 0x80 + x).setType(type);
        }

        //LAB_2008292
      }
    }

    //LAB_2008298
    return 0;
  }

  @Method(0x200834c)
  public static Actor70 FUN_200834c(final int r0, final int r1, final int r2) {
    final Actor70 r9 = getMapActor(0);
    MEMORY.ref(4, r0).setu((r9.angle_06.get() & 0xffff) >>> 12);
    final Structccc r11 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    //LAB_200837e
    for(int sp08 = 8; sp08 < 66; sp08++) {
      final Actor70 r10 = r11.actors_14.get(sp08).deref();
      final SpriteLayer18 r3 = r10.sprite_50.deref().layers_28.get(0).deref();
      final int sp04 = r3.spriteDataIndex_00.get();

      //LAB_2008398
      for(int r8 = 0; r8 < 6; r8++) {
        if(sp04 == MEMORY.ref(4, 0x200b19c + r8 * 0x4).get()) {
          final int r0_0 = 0x200b1b4 + r8 * 0x10;
          MEMORY.ref(4, r2).setu(r8);
          final int r2_0 = MEMORY.ref(4, 0x200b15c + MEMORY.ref(4, r0).get() * 0x4).get();
          final int r7 = (r9.pos_08.getX() >> 16) + (r2_0 >> 16) >> 4;
          final int r5 = (r9.pos_08.getZ() >> 16) + (short)r2_0 >> 4;
          final int r6 = (r10.pos_08.getX() >> 16) + MEMORY.ref(4, r0_0).get() >> 4;
          final int r4 = (r10.pos_08.getZ() >> 16) + MEMORY.ref(4, r0_0 + 0x4).get() >> 4;
          if(r7 >= r6 && r7 < (r10.pos_08.getX() >> 16) + MEMORY.ref(4, r0_0 + 0x8).get() >> 4) {
            if(r5 >= r4 && r5 < (r10.pos_08.getZ() >> 16) + MEMORY.ref(4, r0_0 + 0xc).get() >> 4) {
              if((r8 & 0x1) == 0) {
                //LAB_2008424
                if(r4 != (r9.pos_08.getZ() >> 20)) {
                  MEMORY.ref(4, r1).setu(sp08);
                  return r10;
                }
              } else {
                if(r6 != (r9.pos_08.getX() >> 20)) {
                  MEMORY.ref(4, r1).setu(sp08);
                  return r10;
                }
              }
            }
          }
        }

        //LAB_2008436
      }
    }

    //LAB_2008452
    return null;
  }

  @Method(0x2008474)
  public static int FUN_2008474(final int r0) {
    CPU.sp().value -= 0x20;
    MEMORY.ref(4, r0 + 0x14).setu(0);

    final int r0_0;
    final Actor70 r10 = FUN_200834c(CPU.sp().value + 0x10, r0 + 0x4, r0);
    if(r10 == null) {
      r0_0 = 0;
    } else {
      //LAB_200849e
      r10.layer_22.set(0x2);
      final int r1 = MEMORY.ref(4, r0).get() * 0x10;
      final int r9 = Math.abs(MEMORY.ref(4, 0x200b1b4 + r1).get()) + Math.abs(MEMORY.ref(4, 0x200b1b4 + r1 + 0x8).get()) >> 4;
      final int sp08 = Math.abs(MEMORY.ref(4, 0x200b1b4 + r1 + 0x4).get()) + Math.abs(MEMORY.ref(4, 0x200b1b4 + r1 + 0xc).get()) >> 4;
      final int r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      final int r8 = CPU.sp().value + 0x14;
      MEMORY.ref(4, r8).setu(r10.pos_08.getX() + (MEMORY.ref(4, 0x200b15c + r3 * 0x4).get() & 0xffff0000));
      MEMORY.ref(4, r8 + 0x4).setu(r10.pos_08.getY());
      MEMORY.ref(4, r8 + 0x8).setu(r10.pos_08.getZ() + (MEMORY.ref(4, 0x200b15c + r3 * 0x4).get() << 16));
      MEMORY.ref(4, r0 + 0xc).setu(MEMORY.ref(4, r8 + 0x4).get());
      int sp0c = 0;

      //LAB_2008520
      jmp_20085b0:
      do {
        MEMORY.ref(4, r0 + 0x10).setu(MEMORY.ref(4, r8 + 0x8).get() + (MEMORY.ref(4, 0x200b1b4 + MEMORY.ref(4, r0).get() * 0x10 + 0x4).get() << 16));

        //LAB_200853c
        for(int r7 = 0; r7 < sp08; r7++) {
          MEMORY.ref(4, r0 + 0x8).setu(MEMORY.ref(4, r8).get() + (MEMORY.ref(4, 0x200b1b4 + MEMORY.ref(4, r0).get() * 0x10).get() << 16));

          //LAB_2008554
          for(int r5 = 0; r5 < r9; r5++) {
            if(FUN_80091d8(r10, MEMORY.ref(4, r0 + 0x8, Vec3::new)) == 2) {
              break jmp_20085b0;
            }
            MEMORY.ref(4, r0 + 0x8).addu(0x100000);
          }

          //LAB_2008574
          MEMORY.ref(4, r0 + 0x10).addu(0x100000);
        }

        //LAB_2008586
        sp0c++;
        MEMORY.ref(4, r8).addu(MEMORY.ref(4, 0x200b15c + r3 * 0x4).get() & 0xffff0000);
        MEMORY.ref(4, r8 + 0x8).addu(MEMORY.ref(4, 0x200b15c + r3 * 0x4).get() << 16);
      } while(true);

      //LAB_20085b0
      r10.layer_22.set(0);
      if(sp0c != 0) {
        final int r2 = MEMORY.ref(4, 0x200b15c + r3 * 0x4).get();
        MEMORY.ref(4, r0 + 0x8).setu(r10.pos_08.getX() + sp0c * (r2 & 0xffff0000));
        MEMORY.ref(4, r0 + 0xc).setu(r10.pos_08.getY());
        MEMORY.ref(4, r0 + 0x10).setu(r10.pos_08.getZ() + sp0c * (r2 << 16));
        r0_0 = 1;
      } else {
        r0_0 = 0;
      }
    }

    //LAB_20085e8
    CPU.sp().value += 0x20;
    return r0_0;
  }

  @Method(0x2008608)
  public static int FUN_2008608(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    int r5;
    int r6;

    CPU.sp().value -= 0x10;
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x28;
    MEMORY.ref(4, CPU.sp().value + 0x48).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x50).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x54).setu(r3);
    r3 = 0x3001e70;
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    r3 = getMapActor(0).angle_06.get() & 0xffff;
    r3 = r3 >>> 12;
    CPU.r8().value = r3;
    final Actor70 r7 = getMapActor(MEMORY.ref(4, CPU.sp().value + 0x4c).get());
    r3 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
    r4 = 0x200b1b4;
    r1 = r3 << 4;
    r3 = r1 + 0x4;
    r2 = MEMORY.ref(4, r4 + r3).get();
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r2 = -r2;
    }

    //LAB_200864c
    r3 = r1;
    r3 = r3 + 0xc;
    r3 = MEMORY.ref(4, r4 + r3).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = -r3;
    }

    //LAB_2008658
    r3 = r2 + r3;
    r3 = r3 >> 4;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    r2 = MEMORY.ref(4, r4 + r1).get();
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r2 = -r2;
    }

    //LAB_2008666
    r3 = r1;
    r3 = r3 + 0x8;
    r3 = MEMORY.ref(4, r4 + r3).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = -r3;
    }

    //LAB_2008672
    r3 = r2 + r3;
    r3 = r3 >> 4;
    CPU.r9().value = r3;
    r5 = 0x1999;
    r3 = r7.pos_08.getX();
    r6 = 0x80;
    r0 = CPU.sp().value + 0x1c;
    r6 = r6 << 8;
    r7.velocityScalar_30.set(r6);
    r7.acceleration_34.set(r5);
    MEMORY.ref(4, r0).setu(r3);
    r3 = r7.pos_08.getZ();
    MEMORY.ref(4, r0 + 0x8).setu(r3);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
    r2 = r2 << 4;
    r3 = MEMORY.ref(4, r4 + r2).get();
    r1 = r7.pos_08.getX();
    r3 = r3 << 16;
    r1 = r1 + r3;
    CPU.r11().value = r0;
    r0 = CPU.sp().value + 0x10;
    MEMORY.ref(4, r0).setu(r1);
    r2 = r2 + 0x4;
    r3 = MEMORY.ref(4, r4 + r2).get();
    r2 = r7.pos_08.getZ();
    r3 = r3 << 16;
    r2 = r2 + r3;
    r1 = r1 >> 20;
    r2 = r2 >> 20;
    MEMORY.ref(4, r0).setu(r1);
    MEMORY.ref(4, r0 + 0x8).setu(r2);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r3 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0x0;
    r3 = CPU.r9().value;
    r0 = fillTileTypes(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r2 = r5;
    r0 = 0x0;
    r1 = r6;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x8;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xf;
    FUN_808a010(r0);
    r4 = CPU.r11().value;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
    r3 = MEMORY.ref(4, r4).get();
    r1 = r2 - r3;
    CPU.cmpT(r1, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r0 = 0x1ffff;
      r1 = r1 + r0;
    }

    //LAB_20086e8
    r4 = CPU.r11().value;
    r3 = MEMORY.ref(4, r4 + 0x8).get();
    r2 = a4 - r3;
    r1 = r1 >> 17;
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r0 = 0x1ffff;
      r2 = r2 + r0;
    }

    //LAB_20086fa
    r2 = r2 >> 17;
    FUN_808a0e0(0, r1, r2);
    getMapActor(0)._6c.set(getConsumer(Map132Overlay_87ced6c.class, "FUN_20082a8", Actor70.class));
    FUN_808a010(0x4);
    r3 = CPU.r8().value;
    r3 = r3 - 0x6;
    CPU.cmpT(r3, 0x7);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r1 = 0x3;
      setActorAnimation(r7, r1);
    } else {
      //LAB_2008724
      r1 = 0x2;
      setActorAnimation(r7, r1);
    }

    //LAB_200872c
    r0 = 0xef;
    playSound(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
    r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
    FUN_8009150(r7, r1, r2, a4);
    r0 = 0x0;
    FUN_808a0e8(r0);
    r0 = 0x0;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x0;
    r1 = 0x4ccc;
    r2 = 0x1999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x200b15c;
    r1 = CPU.r8().value;
    r3 = r1 << 2;
    r0 = MEMORY.ref(4, r2 + r3).get();
    r3 = r0 >> 16;
    r3 = r3 << 16;
    r0 = r0 << 16;
    r1 = r3 >> 16;
    r2 = r0 >> 16;
    r3 = r3 >>> 31;
    r0 = r0 >>> 31;
    r1 = r1 + r3;
    r2 = r2 + r0;
    r1 = r1 >> 1;
    r2 = r2 >> 1;
    r0 = 0x0;
    FUN_808a0e0(r0, r1, r2);
    CPU.cmpT(a5, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_200b12c(r0, r1, r2, a5);
    }

    //LAB_2008784
    r0 = 0x0;
    FUN_808a0e8(r0);
    r1 = 0x1;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    getMapActor(0)._6c.clear();
    FUN_8009158(r7);
    r0 = 0x90;
    r0 = r0 << 1;
    playSound(r0);
    r0 = 0xd5;
    playSound(r0);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
    r7.pos_08.setX(r3);
    r7.pos_08.setZ(a4);
    r3 = 0x0;
    r7.velocity_24.setX(r3);
    r7.velocity_24.setZ(r3);
    r1 = 0x1;
    setActorAnimation(r7, r1);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
    r4 = 0x200b1b4;
    r2 = r2 << 4;
    r3 = MEMORY.ref(4, r4 + r2).get();
    r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
    r3 = r3 << 16;
    r2 = r2 + 0x4;
    r0 = r0 + r3;
    r3 = MEMORY.ref(4, r4 + r2).get();
    r3 = r3 << 16;
    r1 = a4 + r3;
    r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    r0 = r0 >> 20;
    r1 = r1 >> 20;
    CPU.r10().value = r4;
    r4 = 0x9e;
    MEMORY.ref(4, CPU.sp().value + 0x50).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x58).setu(r1);
    r4 = r4 << 1;
    r3 = r2 + r4;
    r3 = MEMORY.ref(4, r3).get();
    CPU.r8().value = r3;
    r2 = CPU.r8().value;
    r2 = r2 >> 20;
    r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    CPU.r8().value = r2;
    r2 = 0xa0;
    r2 = r2 << 1;
    r3 = r4 + r2;
    r6 = MEMORY.ref(4, r3).get();
    r4 = CPU.r8().value;
    r6 = r6 >> 20;
    r3 = r4 + r0;
    r2 = r6 + r1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r2 = CPU.r9().value;
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r1 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
    r2 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
    MEMORY.ref(4, CPU.sp().value).setu(r0);
    r5 = 0xff;
    r3 = CPU.r9().value;
    r0 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    r0 = fillTileTypes(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r1 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
    r2 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0x2;
    r3 = CPU.r9().value;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    r0 = fillTileTypes(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r2 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
    r4 = CPU.r10().value;
    r2 = r2 << 4;
    r3 = MEMORY.ref(4, r4 + r2).get();
    r0 = CPU.r11().value;
    r1 = MEMORY.ref(4, r0).get();
    r3 = r3 << 16;
    r2 = r2 + 0x4;
    r1 = r1 + r3;
    r3 = MEMORY.ref(4, r4 + r2).get();
    r2 = MEMORY.ref(4, r0 + 0x8).get();
    r3 = r3 << 16;
    r2 = r2 + r3;
    r1 = r1 >> 20;
    r2 = r2 >> 20;
    MEMORY.ref(4, r0).setu(r1);
    MEMORY.ref(4, r0 + 0x8).setu(r2);
    CPU.r8().value = CPU.r8().value + r1;
    r6 = r6 + r2;
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r0 = CPU.r8().value;
    r1 = r6;
    r2 = CPU.r9().value;
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r2 = CPU.r11().value;
    r1 = MEMORY.ref(4, r2).get();
    r4 = 0x0;
    r2 = MEMORY.ref(4, r2 + 0x8).get();
    r0 = 0x2;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r3 = CPU.r9().value;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
    r0 = fillTileTypes(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    FUN_808a5e8();
    CPU.sp().value += 0x28;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    CPU.sp().value += 0x10;
    return r0;
  }

  @Method(0x20088c0)
  public static int FUN_20088c0(int r0) {
    final int r1;
    final int r2;
    final int r4;
    final int r6;

    CPU.sp().value -= 0x20;
    final Map194 r10 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Actor70 actor = getMapActor(r0);
    final int r7 = CPU.sp().value + 0x8;

    for(MEMORY.ref(4, r7).setu(0); MEMORY.ref(4, r7).get() < 6; MEMORY.ref(4, r7).incr()) {
      if(actor.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get() != MEMORY.ref(4, 0x200b19c + MEMORY.ref(4, r7).get() * 0x4).get()) {
        break;
      }
    }

    //LAB_200890e
    r2 = MEMORY.ref(4, r7).get();
    if(r2 > 6) {
      r0 = 0;
    } else {
      //LAB_2008918
      MEMORY.ref(4, r7 + 0x8).setu(actor.pos_08.getX());
      MEMORY.ref(4, r7 + 0xc).setu(actor.pos_08.getY());
      MEMORY.ref(4, r7 + 0x10).setu(actor.pos_08.getZ());
      r1 = r2 << 4;
      r4 = 0x200b1b4;
      final int r8 = Math.abs(MEMORY.ref(4, r4 + r1 + 0x4).get()) + Math.abs(MEMORY.ref(4, r4 + r1 + 0xc).get()) >> 4;
      MEMORY.ref(4, r7 + 0x8).setu((MEMORY.ref(4, r4 + r1).get() << 16) + actor.pos_08.getX() >> 20);
      MEMORY.ref(4, r7 + 0x10).setu((MEMORY.ref(4, r4 + r1 + 0x4).get() << 16) + actor.pos_08.getZ() >> 20);
      r6 = Math.abs(MEMORY.ref(4, r4 + r1).get()) + Math.abs(MEMORY.ref(4, r4 + r1 + 0x8).get()) >> 4;
      FUN_80091c0(MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0x10).get(), r6, r8, (r10.layers_104.get(1)._08.get() >> 20) + MEMORY.ref(4, r7 + 0x8).get(), (r10.layers_104.get(1)._0c.get() >> 20) + MEMORY.ref(4, r7 + 0x10).get());
      fillTileTypes(0, MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0x10).get(), r6, r8, 0xff);
      fillTileTypes(2, MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0x10).get(), r6, r8, 0xff);
      r0 = 0x1;
    }

    //LAB_20089c2
    CPU.sp().value += 0x20;
    return r0;
  }

  @Method(0x2008ae8)
  public static void FUN_2008ae8(final int x, final int y, final int z, final int r3, final int a4, final int a5, final int a6, final int a7) {
    final Actor70 r9 = getMapActor(0);

    final int spriteTypeAndDataIndex;
    if((a6 & 0x100000) != 0 && a7 != 0) {
      spriteTypeAndDataIndex = MEMORY.ref(2, a7 + 0x18).get();
    } else {
      //LAB_2008b26
      spriteTypeAndDataIndex = 0xde;
    }

    //LAB_2008b2a
    final Actor70 r6 = loadActor(spriteTypeAndDataIndex, x, y, z);
    if(r6 != null) {
      //LAB_2008b3a
      final Sprite38 r8 = r6.sprite_50.deref();
      setActorAnimation(r6, a6 + 1 & 0xf);
      final int r11 = (a6 & 0xf) * 0x4;
      FUN_8009098(r6, MEMORY.ref(4, 0x200b2d4 + r11).get());
      r6._55.set(0);
      r8._26.set(0);
      r6._6c.set(getConsumer(Map132Overlay_87ced6c.class, "FUN_2008ab0", Actor70.class));
      r6._44.set(r3);
      r6._48.set(a4);
      r6._4c.set(a5);
      r8.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r9.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
      r6.velocityScalar_30.set(0);
      r6.acceleration_34.set(0);
      r6._64.set(0);

      if((a6 & 0xffff0000) != 0) {
        if(a7 != 0) {
          if((a6 & 0x10000) != 0) {
            FUN_808a160(r6, MEMORY.ref(4, a7 + 0x4).get());
          }

          //LAB_2008bc8
          if((a6 & 0x20000) != 0) {
            r6.flags_23.and(0xfe);
            r8.packet_00.attribs_04.attrib2_04.and(~0xc00).or((MEMORY.ref(1, a7).getUnsigned() & 0x3) << 10);
          }

          //LAB_2008bf4
          if((a6 & 0x80000) != 0) {
            r6.scale_18.set(MEMORY.ref(4, a7 + 0x8).get());
            r6._1c.set(MEMORY.ref(4, a7 + 0xc).get());
          }

          //LAB_2008c08
          if((a6 & 0x40000) != 0) {
            final int r5 = MEMORY.ref(4, 0x200b2d4 + r11).get();
            if((a6 & 0x80000) != 0) {
              r6.velocityScalar_30.set(FUN_200afb0(MEMORY.ref(4, a7 + 0x10).get() - r6.scale_18.get(), MEMORY.ref(4, r5 + 0xc).get()));
              r6.acceleration_34.set(FUN_200afb0(MEMORY.ref(4, a7 + 0x14).get() - r6._1c.get(), MEMORY.ref(4, r5 + 0xc).get()));
            } else {
              //LAB_2008c36
              r6.velocityScalar_30.set(FUN_200afb0(MEMORY.ref(4, a7 + 0x10).get() - 0x10000, MEMORY.ref(4, r5 + 0xc).get()));
              r6.acceleration_34.set(FUN_200afb0(MEMORY.ref(4, a7 + 0x14).get() - 0x10000, MEMORY.ref(4, r5 + 0xc).get()));
            }
          }

          //LAB_2008c52
          if((a6 & 0x200000) != 0) {
            setActorAnimation(r6, 1);
            FUN_8009098(r6, MEMORY.ref(4, a7 + 0x1c).get());
          }

          //LAB_2008c6e
          if((a6 & 0x400000) != 0) {
            r8.rotation_1e.set(MEMORY.ref(2, a7 + 0x20).get());
          }

          //LAB_2008c80
          if((a6 & 0x800000) != 0) {
            r6._64.set(MEMORY.ref(2, a7 + 0x22).get());
          }

          //LAB_2008c92
          if((a6 & 0x1000000) != 0) {
            r6._6c.setPointer(MEMORY.ref(4, a7 + 0x24).get());
          }
        }
      }
    }

    //LAB_2008ca2
  }

  @Method(0x2008cc4)
  public static int getRooms() {
    final int r0;
    int r1;
    final int r2;
    int r3;

    r2 = MEMORY.ref(2, 0x2000400).get();
    r3 = 0x71;
    CPU.cmpT(r2, r3);
    if(CPU.cpsr().getZero()) { // ==
      r0 = 0x200b310;
    } else {
      //LAB_2008cdc
      r3 = 0x72;
      CPU.cmpT(r2, r3);
      if(CPU.cpsr().getZero()) { // ==
        r0 = 0x200b358;
      } else {
        //LAB_2008ce6
        r3 = 0x7b;
        CPU.cmpT(r2, r3);
        if(CPU.cpsr().getZero()) { // ==
          r0 = 0x200b3a0;
        } else {
          //LAB_2008cf0
          r3 = 0x7c;
          CPU.cmpT(r2, r3);
          if(CPU.cpsr().getZero()) { // ==
            r0 = 0x200b400;
          } else {
            //LAB_2008cfa
            r3 = 0x7d;
            CPU.cmpT(r2, r3);
            if(CPU.cpsr().getZero()) { // ==
              r0 = 0x200b448;
            } else {
              //LAB_2008d04
              r0 = 0x200b478;
            }
          }
        }
      }
    }

    return r0;
  }

  @Method(0x2008d3c)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  @Method(0x2008d40)
  public static int getTransitions() {
    final int r0;

    r0 = 0x200b508;
    return r0;
  }

  @Method(0x2008d48)
  public static int getActors() {
    final int r0;
    int r1;
    final int r2;
    int r3;

    r2 = MEMORY.ref(2, 0x2000400).get();
    r3 = 0x71;
    CPU.cmpT(r2, r3);
    if(CPU.cpsr().getZero()) { // ==
      r0 = 0x200b610;
    } else {
      //LAB_2008d60
      r3 = 0x7b;
      CPU.cmpT(r2, r3);
      if(CPU.cpsr().getZero()) { // ==
        r0 = 0x200b718;
      } else {
        //LAB_2008d6a
        if(r2 <= 0x86 && r2 >= 0x7e) {
          r0 = 0x200b850;
        } else {
          //LAB_2008d7a
          r0 = 0x200b5f8;
        }
      }
    }

    return r0;
  }

  @Method(0x2008e00)
  public static void FUN_2008e00(final int r0) {
    CPU.sp().value -= 0x44;

    final Actor70 r10 = getMapActor(r0);
    final int r2 = CPU.sp().value + 0x10;
    MEMORY.ref(4, r2 + 0x24).setu(0x2008da5);
    final int r7 = CPU.sp().value + 0x38;

    //LAB_2008e20
    for(int r8 = 0; r8 <= 0x10; r8 += 0x2) {
      MEMORY.ref(4, r7).setu(cos(r8 << 12));
      MEMORY.ref(4, r7 + 0x4).setu(0);
      MEMORY.ref(4, r7 + 0x8).setu(sin(r8 << 12));
      MEMORY.ref(4, r7).addu(FUN_200afb0(MEMORY.ref(4, r7).get(), 0x3));
      FUN_2008ae8(r10.pos_08.getX(), r10.pos_08.getY(), r10.pos_08.getZ(), MEMORY.ref(4, r7).get(), MEMORY.ref(4, r7 + 0x4).get(), MEMORY.ref(4, r7 + 0x8).get(), 0x1000001, r2);
    }

    CPU.sp().value += 0x44;
  }

  /**
   * Event list 0x200bd6c handler 1
   */
  @Method(0x2008e88)
  public static void FUN_2008e88() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    FUN_808a018();
    r5 = 0x2000240;
    r2 = 0xe0;
    r2 = r2 << 1;
    r3 = r5 + r2;
    r2 = 0x0;
    r0 = MEMORY.ref(2, r3 + r2).get();
    r1 = 0x5;
    FUN_808a260(r0, r1);
    r3 = 0x22b;
    r5 = r5 + r3;
    r3 = 0x3;
    MEMORY.ref(1, r5).setu(r3);
    r0 = 0x54;
    r1 = 0x5;
    FUN_808a250(r0, r1);
    FUN_808a020();
  }

  @Method(0x2008ec4)
  public static int getEvents() {
    final int r0;
    final int r2;
    int r3;

    r2 = MEMORY.ref(2, 0x2000400).get();
    r3 = 0x71;
    CPU.cmpT(r2, r3);
    if(CPU.cpsr().getZero()) { // ==
      r0 = 0x200b904;
    } else {
      //LAB_2008edc
      r3 = 0x72;
      CPU.cmpT(r2, r3);
      if(CPU.cpsr().getZero()) { // ==
        r0 = 0x200b8e0;
      } else {
        //LAB_2008ee6
        r3 = 0x7b;
        CPU.cmpT(r2, r3);
        if(CPU.cpsr().getZero()) { // ==
          r0 = 0x200b9f4;
        } else {
          //LAB_2008ef0
          r3 = 0x7c;
          CPU.cmpT(r2, r3);
          if(CPU.cpsr().getZero()) { // ==
            r0 = 0x200bd48;
          } else {
            //LAB_2008efa
            r3 = 0x7d;
            CPU.cmpT(r2, r3);
            if(CPU.cpsr().getZero()) { // ==
              r0 = 0x200bd6c;
            } else {
              //LAB_2008f04
              r0 = 0x200b880;
            }
          }
        }
      }
    }

    //LAB_2008f06
    return r0;
  }

  /**
   * Event list 0x200b904 handler 0
   */
  @Method(0x2008f3c)
  public static void FUN_2008f3c() {
    int r0;
    int r1;
    final int r2;

    FUN_808a018();
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x8;
    FUN_808a0f0(r0, r1, r2);
    r0 = 0xfd7;
    setFlag(r0);
    r0 = 0xb5;
    r1 = 0x3;
    FUN_808a398(r0, r1);
    r1 = 0x0;
    r0 = 0xb5;
    r0 = FUN_808a060(r0, r1);
    FUN_808a020();
  }

  @Method(0x2008f70)
  public static void init() {
    int r2;
    final int r7;

    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x204);
    r7 = MEMORY.ref(2, 0x2000400).get();
    if(r7 == 0x7b) {
      FUN_200991c();
      return;
    }

    //LAB_2008f9c
    if(r7 == 0x7d) {
      if(readFlag(0xef7) == 0) {
        FUN_80091c0(0, 3, 1, 1, 0xd, 0x28);
        FUN_80091c0(0, 2, 1, 1, 0xf, 0x28);
        FUN_808a3c0(0x65, 0xd80000, 0x2880000);
      }

      //LAB_2008fe0
      if(MEMORY.ref(2, 0x2000400).get() == r7) {
        if(MEMORY.ref(2, 0x2000402).get() == 5 || readFlag(0x8d1) != 0) {
          //LAB_2009004
          setFlag(0x8d1);
          FUN_80091c0(0, 0x1, 0x1, 0x1, 0xd, 0x1e);
          FUN_808a3c0(0x64, 0xd80000, 0x1e80000);
        }

        return;
      }
    }

    //LAB_200902e
    r2 = MEMORY.ref(2, 0x2000400).get();
    if(r2 == 0x71) {
      //LAB_2009040
      FUN_200967c();
      getMapActor(8).dest_38.setX(0x810000);
      FUN_20088c0(9);
      FUN_20088c0(10);
      if(readFlag(0x240) != 0) {
        final Actor70 r5 = getMapActor(11);
        if(r5 != null) {
          r5._59.set(0);
          setActorAnimation(r5, 4);
          FUN_80091e0(r5, 0);
        }

        //LAB_200908a
        FUN_8009278(0, 0x1300000, 0x1700000, 0xfd);
      }

      //LAB_200909a
      if(readFlag(0x241) != 0) {
        final Actor70 r5 = getMapActor(12);
        if(r5 != null) {
          r5._59.set(0);
          setActorAnimation(r5, 4);
          FUN_80091e0(r5, 0);
        }

        //LAB_20090c6
        FUN_8009278(0, 0x500000, 0x1700000, 0xfd);
      }

      //LAB_20090d6
      if(readFlag(0x242) != 0) {
        final Actor70 r5 = getMapActor(13);
        if(r5 != null) {
          r5._59.set(0);
          setActorAnimation(r5, 4);
          FUN_80091e0(r5, 0);
        }

        //LAB_2009102
        FUN_8009278(0, 0x600000, 0x1500000, 0xfd);
      }

      //LAB_2009112
      if(readFlag(0x243) != 0) {
        final Actor70 r5 = getMapActor(14);
        if(r5 != null) {
          r5._59.set(0);
          setActorAnimation(r5, 4);
          FUN_80091e0(r5, 0);
        }

        //LAB_200913e
        FUN_8009278(0, 0x900000, 0x1400000, 0xfd);
        FUN_8009278(0, 0x2f00000, 0x1400000, 0xfd);
      }

      //LAB_200915e
      if(readFlag(0xfd7) == 0) {
        FUN_200aed8(0x8);
      }
    } else {
      //LAB_2009170
      if(r2 == 0x7e && readFlag(0xef4) == 0) {
        FUN_80091c0(0, 0, 1, 1, 0x25, 0xa);
        FUN_808a3c0(0x64, 0x2580000, 0xa80000);
      }

      //LAB_20091a2
      r2 = MEMORY.ref(2, 0x2000400).get();
      if(r2 >= 0x7e && r2 <= 0x86) {
        FUN_2009214();

        if(MEMORY.ref(2, 0x2000402).get() == 5) {
          FUN_2009494();
        }
      }
    }

    //LAB_20091cc
  }

  @Method(0x2009214)
  public static void FUN_2009214() {
    final Actor70 r6 = getMapActor(8);
    final int r5 = readFlag(0x8d2 + MEMORY.ref(2, 0x2000400).get() - 0x7e);
    if(r5 != 0) {
      FUN_808a0f0(8, 0x28a0000, 0xa80000);
      r6.pos_08.setY(0xffe00000);
      FUN_80091e0(getMapActor(8), 0);
      setActorPriority(8, 3);
      r6._55.set(0);
      r6.flags_23.or(0x2);
      FUN_80091c0(42, 10, 1, 1, 0x28, 0xa);
    } else {
      //LAB_200928c
      getMapActor(8)._55.set(r5);
    }

    //LAB_2009296
  }

  /**
   * Event list 0x200b880 handler 5
   */
  @Method(0x20092b4)
  public static void FUN_20092b4(final int r0, final int r1) {
    final Actor70 r5 = getMapActor(8);
    if(r5.pos_08.getX() >> 20 == 0x28) {
      final int r7 = readFlag(MEMORY.ref(2, 0x2000400).get() + 0x8d2 - 0x7e);
      if(r7 == 0) {
        r5._55.set(0x3);
        FUN_808a010(8);
        FUN_2008e00(8);
        playSound(0x88);
        FUN_808a010(0x28);
        FUN_80091e0(getMapActor(8), 0);
        setActorPriority(8, 3);
        r5._55.set(0);
        r5.flags_23.or(0x2);
        FUN_80091c0(42, 10, 1, 1, 0x28, 0xa);
        setFlag(MEMORY.ref(2, 0x2000400).get() + 0x8d2 - 0x7e);
      }
    }

    //LAB_2009356
  }

  /**
   * Event list 0x200b880 handler 4
   */
  @Method(0x2009374)
  public static void FUN_2009374(final int r0, final int r1) {
    FUN_808a018();
    FUN_20080c4();
    FUN_808a020();
    FUN_20092b4(r0, r1);
  }

  /**
   * Event list 0x200b880 handler 3
   */
  @Method(0x200938c)
  public static void FUN_200938c(int r0, final int r1) {
    final int r2;

    r2 = 0x7;
    r0 = 0x200b2bc;
    FUN_8009178(r0, 0x25, r2);
    r0 = 0xb7;
    playSound(r0);
    r0 = 0x4;
    FUN_808a248(r0);
  }

  /**
   * Event list 0x200b880 handler 2
   */
  @Method(0x20093ac)
  public static void FUN_20093ac(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r6 = 0x2000240;
    r2 = 0xe0;
    r2 = r2 << 1;
    r5 = r6 + r2;
    r3 = 0x0;
    r0 = MEMORY.ref(2, r5 + r3).get();
    r7 = 0x7e;
    r3 = 0x8c8;
    r3 = r3 - r7;
    r0 = r0 + r3;
    r0 = readFlag(r0);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      FUN_808a018();
      r2 = 0x0;
      r0 = MEMORY.ref(2, r5 + r2).get();
      r1 = 0x5;
      FUN_808a260(r0, r1);
      r3 = 0x22b;
      r2 = r6 + r3;
      r3 = 0x3;
      MEMORY.ref(1, r2).setu(r3);
      r2 = 0x0;
      r3 = MEMORY.ref(2, r5 + r2).get();
      r3 = r3 - r7;

      switch(r3) {
        case 0:
          //LAB_2009418
          r0 = 0x3f;
          r1 = 0x0;
          FUN_808a250(r0, r1);
          break;

        case 1:
          //LAB_200941c
          r0 = 0x3f;
          r1 = 0x1;
          FUN_808a250(r0, r1);
          break;

        case 2:
          //LAB_2009420
          r0 = 0x3f;
          r1 = 0x2;
          FUN_808a250(r0, r1);
          break;

        case 3:
          //LAB_2009424
          r0 = 0x3f;
          r1 = 0x3;
          FUN_808a250(r0, r1);
          break;

        case 4:
          //LAB_2009428
          r0 = 0x54;
          r1 = 0x0;
          FUN_808a250(r0, r1);
          break;

        case 5:
          //LAB_2009432
          r0 = 0x54;
          r1 = 0x1;
          FUN_808a250(r0, r1);
          break;

        case 6:
          //LAB_200943c
          r0 = 0x54;
          r1 = 0x2;
          FUN_808a250(r0, r1);
          break;

        case 7:
          //LAB_2009446
          r0 = 0x54;
          r1 = 0x3;
          FUN_808a250(r0, r1);
          break;

        case 8:
          //LAB_2009450
          r0 = 0x54;
          r1 = 0x4;
          FUN_808a250(r0, r1);
          break;
      }

      //LAB_2009458
      FUN_808a020();
    } else {
      //LAB_200945e
      r0 = 0x200b2bc;
      r1 = 0x2c;
      r2 = 0x7;
      FUN_8009178(r0, r1, r2);
      r0 = 0xb7;
      playSound(r0);
      r0 = 0x3;
      FUN_808a248(r0);
    }
  }

  @Method(0x2009494)
  public static void FUN_2009494() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_808a018();
    r1 = 0x6666;
    r0 = 0x0;
    r2 = 0x3333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    FUN_808a360();
    FUN_808a370();
    r3 = 0x2000240;
    r2 = 0xe0;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r0 = MEMORY.ref(2, r3 + r2).get();
    r2 = 0x7e;
    r3 = 0x8c8;
    r3 = r3 - r2;
    r0 = r0 + r3;
    setFlag(r0);
    r0 = 0x1e;
    FUN_808a010(r0);
    r0 = 0x200b2bc;
    r1 = 0x2c;
    r2 = 0x7;
    FUN_8009178(r0, r1, r2);
    r2 = 0x10;
    r1 = 0x3;
    r2 = -r2;
    r0 = 0x0;
    FUN_808a0d8(r0, r1, r2);
    r0 = 0x3;
    FUN_808a248(r0);
    FUN_808a020();
  }

  /**
   * Event list 0x200b904 handler 1
   */
  @Method(0x2009508)
  public static void FUN_2009508(final int r0) {
    final Actor70 r2 = getMapActor(11);
    if(r2 != null) {
      r2._59.set(0);
    }

    //LAB_200951e
    FUN_80091e0(getMapActor(r0), 0);
    FUN_8009278(0, 0x1300000, 0x1700000, 0xfd);
    setFlag(0x240);
  }

  /**
   * Event list 0x200b904 handler 2
   */
  @Method(0x2009548)
  public static void FUN_2009548(final int r0) {
    final Actor70 r2 = getMapActor(12);
    if(r2 != null) {
      r2._59.set(0);
    }

    //LAB_200955e
    FUN_80091e0(getMapActor(r0), 0);
    FUN_8009278(0, 0x500000, 0x1700000, 0xfd);
    setFlag(0x241);
  }

  /**
   * Event list 0x200b904 handler 3
   */
  @Method(0x200958c)
  public static void FUN_200958c(final int r0) {
    final Actor70 actor = getMapActor(13);
    if(actor != null) {
      actor._59.set(0);
    }

    //LAB_20095a2
    FUN_80091e0(getMapActor(r0), 0);
    FUN_8009278(0, 0x600000, 0x1500000, 0xfd);
    setFlag(0x242);
  }

  /**
   * Event list 0x200b904 handler 4
   */
  @Method(0x20095d0)
  public static void FUN_20095d0(final int r0) {
    final Actor70 actor = getMapActor(14);
    if(actor != null) {
      actor._59.set(0);
    }

    //LAB_20095e6
    FUN_80091e0(getMapActor(r0), 0);
    FUN_8009278(0, 0x900000, 0x1400000, 0xfd);
    FUN_8009278(0, 0x2f00000, 0x1400000, 0xfd);
    setFlag(0x243);
  }

  /**
   * Event list 0x200b904 handler 5
   */
  @Method(0x2009624)
  public static void FUN_2009624() {
    int r0;
    final int r1;
    int r2;
    int r3;

    r0 = 0x8c4;
    CPU.sp().value -= 0x8;
    setFlag(r0);
    r3 = 0x8;
    r2 = 0x15;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x1;
    r3 = 0x1;
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200b904 handler 6
   */
  @Method(0x200964c)
  public static void FUN_200964c() {
    final int r0;

    r0 = 0x8c5;
    setFlag(r0);
  }

  /**
   * Event list 0x200b904 handler 7
   */
  @Method(0x200965c)
  public static void FUN_200965c() {
    final int r0;

    r0 = 0x8c6;
    setFlag(r0);
  }

  /**
   * Event list 0x200b904 handler 8
   */
  @Method(0x200966c)
  public static void FUN_200966c() {
    final int r0;

    r0 = 0x8c7;
    setFlag(r0);
  }

  @Method(0x200967c)
  public static void FUN_200967c() {
    int r0;
    int r1;
    int r2;
    int r3;

    CPU.sp().value -= 0x8;
    if(readFlag(0x8c4) != 0) {
      FUN_80091c0(0, 0, 1, 1, 0x8, 0x15);
      r1 = 0xf2;
      r2 = 0xf2;
      r0 = 0xf;
      r1 = r1 << 18;
      r2 = r2 << 18;
      FUN_808a0f0(r0, r1, r2);
    } else {
      //LAB_20096ae
      getMapActor(15)._1c.set(0x19999);
    }

    //LAB_20096b8
    r0 = 0x8c5;
    r0 = readFlag(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = 0xf2;
      r2 = 0xf2;
      r0 = 0x10;
      r1 = r1 << 18;
      r2 = r2 << 18;
      FUN_808a0f0(r0, r1, r2);
    } else {
      //LAB_20096d2
      getMapActor(16)._1c.set(0x19999);
    }

    //LAB_20096dc
    r0 = 0x8c6;
    r0 = readFlag(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = 0xf2;
      r2 = 0xf2;
      r0 = 0x11;
      r1 = r1 << 18;
      r2 = r2 << 18;
      FUN_808a0f0(r0, r1, r2);
    } else {
      //LAB_20096f6
      getMapActor(17)._1c.set(0x19999);
    }

    //LAB_2009700
    r0 = 0x8c7;
    r0 = readFlag(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = 0xf2;
      r2 = 0xf2;
      r0 = 0x12;
      r1 = r1 << 18;
      r2 = r2 << 18;
      FUN_808a0f0(r0, r1, r2);
    } else {
      //LAB_200971a
      getMapActor(18)._1c.set(0x19999);
    }

    //LAB_2009724
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200b904 handler 12
   */
  @Method(0x2009740)
  public static void FUN_2009740() {
    CPU.sp().value -= 0x20;
    FUN_808a018();

    final int r5 = CPU.sp().value + 0x8;
    if(FUN_2008474(r5) != 0) {
      FUN_2008608(MEMORY.ref(4, r5).get(), MEMORY.ref(4, r5 + 0x4).get(), MEMORY.ref(4, r5 + 0x8).get(), MEMORY.ref(4, r5 + 0xc).get(), MEMORY.ref(4, r5 + 0x10).get(), MEMORY.ref(4, r5 + 0x14).get());
    }

    //LAB_2009768
    FUN_808a020();
    CPU.sp().value += 0x20;
  }

  @Method(0x2009774)
  public static void FUN_2009774(final int mapActorIndex, final int x, final int z) {
    final Actor70 r6 = getMapActor(playerMapActorIndex_2000434.get());
    final Actor70 r7 = getMapActor(mapActorIndex);
    FUN_808a018();
    r6.velocityScalar_30.set(0x10000);
    r6.acceleration_34.set(0x8000);
    FUN_8009150(r6, (r6.pos_08.getX() + (x << 16) & 0xfff00000) + 0x80000, r6.pos_08.getY(), (r6.pos_08.getZ() + (z << 16) & 0xfff00000) + 0x80000);
    setActorAnimation(r6, 27);
    r7.velocityScalar_30.set(0x10000);
    r7.acceleration_34.set(0x8000);
    FUN_8009150(r7, (r7.pos_08.getX() + (x << 16) & 0xfff00000) + 0x80000, r7.pos_08.getY(), (r7.pos_08.getZ() + (z << 16) & 0xfff00000) + 0x80000);

    if(x < 0 || z < 0) {
      //LAB_2009818
      setActorAnimation(r7, 4);
    } else {
      //LAB_2009822
      setActorAnimation(r7, 3);
    }

    //LAB_200982a
    playSound(0xe2);
    FUN_8009158(r6);
    playSound(0x120);
    FUN_808a020();
  }

  @Method(0x200985c)
  public static void FUN_200985c(final int r0, final int r1, final int r2) {
    final Actor70 r5 = getMapActor(r0);
    if(r5 != null) {
      setActorPriority(r0, 3);
      r5.flags_23.or(0x2);
      FUN_80091c0(r1, r2, 3, 1, (r5.pos_08.getX() >> 20) - 1, r5.pos_08.getZ() >> 20);
    }

    //LAB_20098a2
  }

  @Method(0x20098b0)
  public static void FUN_20098b0(final int r0, final int r1, final int r2) {
    final Actor70 r5 = getMapActor(r0);
    if(r5 != null) {
      setActorPriority(r0, 3);
      r5.flags_23.or(0x2);
      FUN_80091c0(r1, r2, 1, 3, r5.pos_08.getX() >> 20, (r5.pos_08.getZ() >> 20) - 1);
    }

    //LAB_20098f6
  }

  @Method(0x2009904)
  public static void FUN_2009904(final int r0) {
    setActorAnimationIfLoaded(r0, 1);
    setActorAnimationIfLoaded(r0, 2);
  }

  @Method(0x200991c)
  public static void FUN_200991c() {
    int r0;
    int r1;
    int r2;
    int r3;

    r0 = 0x8;
    r1 = 0x11;
    r2 = 0x1e;
    r3 = 0x15;
    FUN_200985c(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x11;
    r2 = 0x1f;
    r3 = 0x16;
    FUN_200985c(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x14;
    r2 = 0x1e;
    r3 = 0x17;
    FUN_20098b0(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x15;
    r2 = 0x1e;
    r3 = 0x18;
    FUN_20098b0(r0, r1, r2);
    r0 = 0xd;
    r1 = 0x16;
    r2 = 0x1e;
    r3 = 0x19;
    FUN_20098b0(r0, r1, r2);
    r0 = 0xf;
    r1 = 0x17;
    r2 = 0x1e;
    r3 = 0x1a;
    FUN_20098b0(r0, r1, r2);
    r0 = 0x11;
    r1 = 0x0;
    r2 = 0x1e;
    r3 = 0x1f;
    FUN_200985c(r0, r1, r2);
    r0 = 0x12;
    r1 = 0x0;
    r2 = 0x1f;
    r3 = 0x20;
    FUN_200985c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x20;
    r3 = 0x21;
    FUN_200985c(r0, r1, r2);
    r0 = 0x13;
    r1 = 0x4;
    r2 = 0x1e;
    r3 = 0x22;
    FUN_20098b0(r0, r1, r2);
    r0 = 0xe;
    r1 = 0x5;
    r2 = 0x1e;
    r3 = 0x23;
    FUN_20098b0(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x6;
    r2 = 0x1e;
    r3 = 0x24;
    FUN_20098b0(r0, r1, r2);
  }

  /**
   * Event list 0x200b9f4 handler 54
   */
  @Method(0x20099b4)
  public static void FUN_20099b4() {
    final int r0;

    r0 = 0x8;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 55
   */
  @Method(0x20099c0)
  public static void FUN_20099c0() {
    final int r0;

    r0 = 0xa;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 56
   */
  @Method(0x20099cc)
  public static void FUN_20099cc() {
    final int r0;

    r0 = 0xb;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 57
   */
  @Method(0x20099d8)
  public static void FUN_20099d8() {
    final int r0;

    r0 = 0xc;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 58
   */
  @Method(0x20099e4)
  public static void FUN_20099e4() {
    final int r0;

    r0 = 0xd;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 59
   */
  @Method(0x20099f0)
  public static void FUN_20099f0() {
    final int r0;

    r0 = 0xf;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 60
   */
  @Method(0x20099fc)
  public static void FUN_20099fc() {
    final int r0;

    r0 = 0x11;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 61
   */
  @Method(0x2009a08)
  public static void FUN_2009a08() {
    final int r0;

    r0 = 0x12;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 62
   */
  @Method(0x2009a14)
  public static void FUN_2009a14() {
    final int r0;

    r0 = 0x9;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 63
   */
  @Method(0x2009a20)
  public static void FUN_2009a20() {
    final int r0;

    r0 = 0x13;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 64
   */
  @Method(0x2009a2c)
  public static void FUN_2009a2c() {
    final int r0;

    r0 = 0xe;
    FUN_2009904(r0);
  }

  /**
   * Event list 0x200b9f4 handler 65
   */
  @Method(0x2009a38)
  public static void FUN_2009a38() {
    final int r0;

    r0 = 0x10;
    FUN_2009904(r0);
  }

  @Method(0x2009a44)
  public static int FUN_2009a44(final Actor70 r0) {
    final int r8 = r0._55.get();
    final Vec3 r6 = new Vec3();
    r6.setX((r0.pos_08.getX() & 0xfff00000) + 0x80000);
    r6.setY(r0.pos_08.getY());
    r6.setZ((r0.pos_08.getZ() & 0xfff00000) + 0x80000);
    retVec3(0x200000, r0.angle_06.get() + 0x2000 & 0xc000, r6);

    if(FUN_80091d8(r0, r6) != 0) {
      //LAB_2009b02
      return 0;
    }

    FUN_808a018();
    setActorAnimation(r0, 6);
    sleep(6);
    playSound(0x98);
    setActorAnimation(r0, 7);
    r0.velocityScalar_30.set(0x30000);
    r0.acceleration_34.set(0x20000);
    r0.velocity_24.setY(0x40000);
    r0._55.and(0x7e);
    FUN_80091e0(r0, 0);
    FUN_808a0c0(0, r6.x_00.get() >> 16, r6.getZ() >> 16);
    setActorAnimation(r0, 6);
    FUN_80091e0(r0, 1);
    r0._55.set(r8);
    FUN_808a020();

    //LAB_2009b04
    return 1;
  }

  /**
   * Event list 0x200b9f4 handler 52
   */
  @Method(0x2009b14)
  public static int FUN_2009b14() {
    final Actor70 r0 = getMapActor(0);

    //TODO unused?
    CPU.sp().value -= 0xc;
    final int r1 = CPU.sp().value;
    MEMORY.ref(4, r1).setu(r0.pos_08.getX());
    MEMORY.ref(4, r1 + 0x4).setu(r0.pos_08.getY());
    MEMORY.ref(4, r1 + 0x8).setu(r0.pos_08.getZ() - 0x200000);
    CPU.sp().value += 0xc;

    return FUN_2009a44(r0);
  }

  /**
   * Event list 0x200b9f4 handler 53
   */
  @Method(0x2009b40)
  public static int FUN_2009b40() {
    final Actor70 r0 = getMapActor(0);

    //TODO unused?
    CPU.sp().value -= 0xc;
    final int r1 = CPU.sp().value;
    MEMORY.ref(4, r1).setu(r0.pos_08.getX());
    MEMORY.ref(4, r1 + 0x4).setu(r0.pos_08.getY());
    MEMORY.ref(4, r1 + 0x8).setu(r0.pos_08.getZ() + 0x200000);
    CPU.sp().value += 0xc;

    return FUN_2009a44(r0);
  }

  /**
   * Event list 0x200b9f4 handler 41
   */
  @Method(0x2009b68)
  public static int FUN_2009b68() {
    final Actor70 r0 = getMapActor(0);

    //TODO unused?
    CPU.sp().value -= 0xc;
    final int r1 = CPU.sp().value;
    MEMORY.ref(4, r1).setu(r0.pos_08.getX() - 0x200000);
    MEMORY.ref(4, r1 + 0x4).setu(r0.pos_08.getY());
    MEMORY.ref(4, r1 + 0x8).setu(r0.pos_08.getZ());
    CPU.sp().value += 0xc;

    return FUN_2009a44(r0);
  }

  /**
   * Event list 0x200b9f4 handler 40
   */
  @Method(0x2009b94)
  public static int FUN_2009b94() {
    final Actor70 r0 = getMapActor(0);

    //TODO unused?
    CPU.sp().value -= 0xc;
    final int r1 = CPU.sp().value;
    MEMORY.ref(4, r1).setu(r0.pos_08.getX() + 0x200000);
    MEMORY.ref(4, r1 + 0x4).setu(r0.pos_08.getY());
    MEMORY.ref(4, r1 + 0x8).setu(r0.pos_08.getZ());
    CPU.sp().value += 0xc;

    return FUN_2009a44(r0);
  }

  /**
   * Event list 0x200b9f4 handler 6
   */
  @Method(0x2009bbc)
  public static void FUN_2009bbc() {
    final int r7 = getMapActor(8).pos_08.getX() >> 20;
    final int r6 = getMapActor(8).pos_08.getZ() >> 20;
    final int r5 = getMapActor(12).pos_08.getX() >> 20;
    final int r3 = getMapActor(15).pos_08.getX() >> 20;
    if(r6 == 0x13) {
      if(r5 == 0x18) {
        FUN_2009774(8, 0, -80);
        //LAB_2009bf4
      } else if(r3 == 0x18) {
        FUN_2009774(8, 0, -112);
        FUN_2009774(8, 0, -32);
      } else {
        //LAB_2009c08
        FUN_2009774(8, 0, -80);
        FUN_2009774(8, 0, -112);
      }
    } else {
      //LAB_2009c18
      if(r6 == 0xe) {
        if(r5 == 0x18) {
          return;
        }
        if(r3 == 0x18) {
          FUN_2009774(8, 0, -64);
        } else {
          //LAB_2009c28
          FUN_2009774(8, 0, -112);
        }
      } else {
        //LAB_2009c2c
        if(r6 != 0xa) {
          //LAB_2009c42
          FUN_2009b14();
          return;
        }
        if(r3 == 0x18) {
          return;
        }
        FUN_2009774(8, 0, -48);
      }
    }

    //LAB_2009c48
    sleep(2);
    FUN_80091c0(r7 - 1, r6, 3, 1, r7 - 1, r6);
    FUN_80091c0(0, 0, 3, 1, r7 - 1, r6);

    //LAB_2009c7a
  }

  /**
   * Event list 0x200b9f4 handler 7
   */
  @Method(0x2009c84)
  public static void FUN_2009c84() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    r5 = getMapActor(8).pos_08.getX() >> 20;
    r6 = getMapActor(8).pos_08.getZ() >> 20;
    r3 = getMapActor(12).pos_08.getX() >> 20;
    CPU.cmpT(r6, 0x7);
    if(CPU.cpsr().getZero()) { // ==
      CPU.cmpT(r3, 0x18);
      if(CPU.cpsr().getZero()) { // ==
        r0 = 0x8;
        r1 = 0x0;
        r2 = 0x30;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_2009cba
        r0 = 0x8;
        r1 = 0x0;
        r2 = 0x50;
        FUN_2009774(r0, r1, r2);
        r0 = 0x8;
        r1 = 0x0;
        r2 = 0x70;
        FUN_2009774(r0, r1, r2);
      }
    } else {
      //LAB_2009cd0
      CPU.cmpT(r6, 0xa);
      if(CPU.cpsr().getZero()) { // ==
        CPU.cmpT(r3, 0x18);
        if(CPU.cpsr().getZero()) { // ==
          return;
        }
        r0 = 0x8;
        r1 = 0x0;
        r2 = 0x90;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_2009ce4
        CPU.cmpT(r6, 0xe);
        if(!CPU.cpsr().getZero()) { // !=
          return;
        }
        r0 = 0x8;
        r1 = 0x0;
        r2 = 0x50;
        FUN_2009774(r0, r1, r2);
      }
    }

    //LAB_2009cf2
    sleep(2);
    r5 = r5 - 0x1;
    r0 = r5;
    r1 = r6;
    r2 = 0x3;
    r3 = 0x1;
    FUN_80091c0(r0, r1, r2, r3, r5, r6);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x3;
    r3 = 0x1;
    FUN_80091c0(r0, r1, r2, r3, r5, r6);

    //LAB_2009d24
  }

  /**
   * Event list 0x200b9f4 handler 10
   */
  @Method(0x2009d2c)
  public static void FUN_2009d2c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;
    final int r7;

    r7 = getMapActor(10).pos_08.getX() >> 20;
    r6 = getMapActor(10).pos_08.getZ() >> 20;
    r5 = getMapActor(13).pos_08.getX() >> 20;
    r3 = getMapActor(15).pos_08.getX() >> 20;
    CPU.cmpT(r6, 0x12);
    if(CPU.cpsr().getZero()) { // ==
      r3 = r3 - 0x1f;
      CPU.cmpT(r3, 0x2);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r2 = 0x80;
        r2 = -r2;
        r0 = 0xa;
        r1 = 0x0;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_2009d66
        r3 = r5;
        r3 = r3 - 0x1f;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r2 = 0x80;
          r2 = -r2;
          r0 = 0xa;
          r1 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_2009d72
          r2 = 0x70;
          r2 = -r2;
          r0 = 0xa;
          r1 = 0x0;
          FUN_2009774(r0, r1, r2);
          r2 = 0x40;
          r2 = -r2;
          r0 = 0xa;
          r1 = 0x0;
          FUN_2009774(r0, r1, r2);
        }
      }
    } else {
      //LAB_2009d82
      CPU.cmpT(r6, 0xa);
      if(CPU.cpsr().getZero()) { // ==
        r3 = r3 - 0x1f;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          return;
        }
        r3 = r5;
        r3 = r3 - 0x1f;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          return;
        }
        r2 = 0x30;
        r2 = -r2;
        r0 = 0xa;
        r1 = 0x0;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_2009da2
        CPU.cmpT(r6, 0x7);
        if(CPU.cpsr().getZero()) { // ==
          return;
        }
      }
    }

    //LAB_2009da6
    sleep(2);
    r5 = r7 - 1;
    FUN_80091c0(r5, r6, 3, 1, r5, r6);
    FUN_80091c0(0, 0, 3, 1, r5, r6);

    //LAB_2009dd8
  }

  /**
   * Event list 0x200b9f4 handler 11
   */
  @Method(0x2009de0)
  public static void FUN_2009de0() {
    final int r5 = getMapActor(10).pos_08.getX() >> 20;
    final int r6 = getMapActor(10).pos_08.getZ() >> 20;
    if(r6 != 18) {
      if(r6 == 10) {
        FUN_2009774(10, 0, 128);
      } else {
        //LAB_2009e0c
        FUN_2009774(10, 0, 112);
        FUN_2009774(10, 0, 64);
      }

      //LAB_2009e20
      sleep(2);
      FUN_80091c0(r5 - 1, r6, 3, 1, r5 - 1, r6);
      FUN_80091c0(0, 0, 3, 1, r5 - 1, r6);
    }

    //LAB_2009e52
  }

  /**
   * Event list 0x200b9f4 handler 14
   */
  @Method(0x2009e5c)
  public static void FUN_2009e5c() {
    final int r6 = getMapActor(11).pos_08.getX() >> 20;
    final int r5 = getMapActor(11).pos_08.getZ() >> 20;

    if(r6 != 0x1e) {
      if(r6 == 0x22) {
        if(getMapActor(10).pos_08.getZ() >> 20 == 0x12) {
          return;
        }

        FUN_2009774(11, -64, 0);
        //LAB_2009e8e
      } else if(r6 == 0x24) {
        if(getMapActor(10).pos_08.getZ() >> 20 == 0x12) {
          FUN_2009774(11, -32, 0);
        } else {
          //LAB_2009eae
          FUN_2009774(11, -96, 0);
        }
      }

      //LAB_2009eba
      sleep(2);
      FUN_80091c0(r6, r5 - 1, 1, 3, r6, r5 - 1);
      FUN_80091c0(0, 0, 1, 3, r6, r5 - 1);
    }

    //LAB_2009eec
  }

  /**
   * Event list 0x200b9f4 handler 15
   */
  @Method(0x2009ef4)
  public static void FUN_2009ef4() {
    final int r6 = getMapActor(11).pos_08.getX() >> 20;
    final int r5 = getMapActor(11).pos_08.getZ() >> 20;
    if(r6 != 0x24) {
      if(r6 == 0x1e) {
        if(getMapActor(10).pos_08.getZ() >> 20 == 0x12) {
          return;
        }
        FUN_2009774(11, 96, 0);
      } else {
        //LAB_2009f2e
        if(r6 == 0x22) {
          FUN_2009774(11, 32, 0);
        }
      }

      //LAB_2009f3c
      sleep(2);
      FUN_80091c0(r6, r5 - 1, 1, 3, r6, r5 - 1);
      FUN_80091c0(0, 0, 1, 3, r6, r5 - 1);
    }

    //LAB_2009f6e
  }

  /**
   * Event list 0x200b9f4 handler 18
   */
  @Method(0x2009f78)
  public static void FUN_2009f78() {
    final int r6 = getMapActor(12).pos_08.getX() >> 20;
    final int r7 = getMapActor(12).pos_08.getZ() >> 20;
    if(r6 == 0x24) {
      FUN_2009774(12, -96, 0);
      FUN_2009774(12, -96, 0);
      //LAB_2009fa8
    } else if(r6 == 0x22) {
      FUN_2009774(12, -96, 0);
      FUN_2009774(12, -64, 0);
      //LAB_2009fc6
    } else if(r6 == 0x18) {
      return;
    }

    //LAB_2009fca
    sleep(2);
    FUN_80091c0(r6, r7 - 1, 1, 3, r6, r7 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r7 - 1);

    //LAB_2009ffc
  }

  /**
   * Event list 0x200b9f4 handler 19
   */
  @Method(0x200a004)
  public static void FUN_200a004() {
    final int r6 = getMapActor(12).pos_08.getX() >> 20;
    final int r5 = getMapActor(12).pos_08.getZ() >> 20;
    if(r6 == 0x18) {
      FUN_2009774(12, 96, 0);
      FUN_2009774(12, 96, 0);
      //LAB_200a030
    } else if(r6 == 0x22) {
      FUN_2009774(12, 32, 0);
      //LAB_200a040
    } else if(r6 == 0x24) {
      return;
    }

    //LAB_200a044
    sleep(2);
    FUN_80091c0(r6, r5 - 1, 1, 3, r6, r5 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r5 - 1);

    //LAB_200a076
  }

  /**
   * Event list 0x200b9f4 handler 22
   */
  @Method(0x200a080)
  public static void FUN_200a080() {
    final int r6 = getMapActor(13).pos_08.getX() >> 20;
    final int r7 = getMapActor(13).pos_08.getZ() >> 20;
    final int r5 = getMapActor(10).pos_08.getZ() >> 20;
    final int r3 = getMapActor(15).pos_08.getX() >> 20;
    if(r6 == 0x24) {
      if(r3 == 0x22) {
        FUN_2009774(13, -16, 0);
        //LAB_200a0b8
      } else if(r5 == 0x7) {
        FUN_2009774(13, -32, 0);
        //LAB_200a0c0
      } else if(r3 == 0x1e) {
        FUN_2009774(13, -80, 0);
      } else {
        //LAB_200a0c8
        FUN_2009774(13, -96, 0);
        FUN_2009774(13, -80, 0);
      }
      //LAB_200a0d8
    } else if(r6 == 0x23) {
      if(r3 == 0x22) {
        return;
      }
      if(r5 == 0x7) {
        FUN_2009774(13, -16, 0);
        //LAB_200a0e8
      } else if(r3 == 0x1e) {
        FUN_2009774(13, -64, 0);
      } else {
        //LAB_200a0f0
        FUN_2009774(13, -80, 0);
        FUN_2009774(13, -80, 0);
      }
      //LAB_200a104
    } else if(r6 == 0x22) {
      if(r5 == 0x7) {
        return;
      }
      FUN_2009774(13, r3 == 0x1e ? -48 : -144, 0);
      //LAB_200a118
    } else if(r6 == 0x1f) {
      if(r3 == 0x1e) {
        return;
      }
      FUN_2009774(13, -96, 0);
      //LAB_200a12e
    } else if(r6 == 0x19) {
      return;
    }

    //LAB_200a132
    sleep(2);
    FUN_80091c0(r6, r7 - 1, 1, 3, r6, r7 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r7 - 1);

    //LAB_200a164
  }

  /**
   * Event list 0x200b9f4 handler 23
   */
  @Method(0x200a16c)
  public static void FUN_200a16c() {
    final int r6 = getMapActor(13).pos_08.getX() >> 20;
    final int r5 = getMapActor(13).pos_08.getZ() >> 20;
    if(r6 == 0x19) {
      FUN_2009774(13, 96, 0);
      FUN_2009774(13, 80, 0);
      //LAB_200a19e
    } else if(r6 == 0x1f) {
      FUN_2009774(13, 80, 0);
      //LAB_200a1a8
    } else if(r6 == 0x22) {
      FUN_2009774(13, 32, 0);
      //LAB_200a1b2
    } else if(r6 == 0x23) {
      FUN_2009774(13, 16, 0);
      //LAB_200a1c2
    } else if(r6 == 0x24) {
      return;
    }

    //LAB_200a1c6
    sleep(2);
    FUN_80091c0(r6, r5 - 1, 1, 3, r6, r5 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r5 - 1);

    //LAB_200a1f8
  }

  /**
   * Event list 0x200b9f4 handler 26
   */
  @Method(0x200a200)
  public static void FUN_200a200() {
    final int r6 = getMapActor(15).pos_08.getX() >> 20;
    final int r7 = getMapActor(15).pos_08.getZ() >> 20;
    final int r5 = getMapActor(8).pos_08.getZ() >> 20;
    final int r3 = getMapActor(10).pos_08.getZ() >> 20;
    if(r6 == 0x23) {
      if(r3 == 0x7) {
        FUN_2009774(15, -16, 0);
        //LAB_200a238
      } else if(r5 == 0x7) {
        FUN_2009774(15, -112, 0);
      } else {
        //LAB_200a240
        FUN_2009774(15, -96, 0);
        FUN_2009774(15, -80, 0);
      }
    } else {
      //LAB_200a250
      if(r6 == 0x22) {
        if(r3 == 0x7) {
          return;
        }
        FUN_2009774(15, -96, 0);
        FUN_2009774(15, -64, 0);
        //LAB_200a268
      } else if(r6 == 0x21) {
        FUN_2009774(15, -144, 0);
        //LAB_200a270
      } else if(r6 == 0x1f) {
        FUN_2009774(15, -80, 0);
        //LAB_200a278
      } else if(r6 == 0x1e) {
        FUN_2009774(15, -96, 0);
        //LAB_200a28a
      } else if(r6 == 0x18) {
        return;
      }
    }

    //LAB_200a28e
    sleep(2);
    FUN_80091c0(r6, r7 - 1, 1, 3, r6, r7 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r7 - 1);

    //LAB_200a2c0
  }

  /**
   * Event list 0x200b9f4 handler 27
   */
  @Method(0x200a2c8)
  public static void FUN_200a2c8() {
    final int r6 = getMapActor(15).pos_08.getX() >> 20;
    final int r7 = getMapActor(15).pos_08.getZ() >> 20;
    final int r5 = getMapActor(10).pos_08.getZ() >> 20;
    final int r3 = getMapActor(13).pos_08.getX() >> 20;
    if(r6 == 0x18) {
      if(r5 == 0x7 || r3 == 0x1f) {
        //LAB_200a300
        FUN_2009774(15, 96, 0);
        //LAB_200a306
      } else if(r3 == 0x22) {
        FUN_2009774(15, 64, 0);
        FUN_2009774(15, 80, 0);
        //LAB_200a31a
      } else if(r3 == 0x23) {
        FUN_2009774(15, 80, 0);
        FUN_2009774(15, 80, 0);
      } else {
        //LAB_200a32e
        FUN_2009774(15, 80, 0);
        FUN_2009774(15, 96, 0);
      }
      //LAB_200a33e
    } else if(r6 == 0x1e || r3 == 0x1f) {
      //LAB_200a346
      if(r5 == 0x7) {
        return;
      }
      if(r3 == 0x22) {
        FUN_2009774(15, 48, 0);
        //LAB_200a354
      } else if(r3 == 0x23) {
        FUN_2009774(15, 64, 0);
      } else {
        //LAB_200a35e
        FUN_2009774(15, 80, 0);
      }
      //LAB_200a364
    } else if(r6 == 0x21) {
      if(r3 == 0x22) {
        return;
      }
      if(r3 == 0x23) {
        FUN_2009774(15, 16, 0);
      } else {
        FUN_2009774(15, 32, 0);
      }
      //LAB_200a376
    } else if(r6 == 0x22) {
      //LAB_200a37a
      FUN_2009774(15, 16, 0);
      //LAB_200a386
    } else if(r6 == 0x23) {
      return;
    }

    //LAB_200a38a
    sleep(2);
    FUN_80091c0(r6, r7 - 1, 1, 3, r6, r7 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r7 - 1);

    //LAB_200a3bc
  }

  /**
   * Event list 0x200b9f4 handler 30
   */
  @Method(0x200a3c4)
  public static void FUN_200a3c4() {
    final int r5 = getMapActor(17).pos_08.getX() >> 20;
    final int r6 = getMapActor(17).pos_08.getZ() >> 20;
    final int r3 = getMapActor(19).pos_08.getX() >> 20;
    if(r6 == 0x13) {
      if(r5 >= 3 && r5 <= 5) {
        FUN_2009774(17, 0, -16);
      } else {
        //LAB_200a3f4
        FUN_2009774(17, 0, -64);
      }
    } else {
      //LAB_200a3f8
      if(r6 == 0x12) {
        if(r3 >= 3 && r5 <= 5) {
          return;
        }
        FUN_2009774(17, 0, -48);
      } else {
        //LAB_200a410
        if(r6 == 0xf) {
          return;
        }
      }
    }

    //LAB_200a414
    sleep(2);
    FUN_80091c0(r5 - 1, r6, 3, 1, r5 - 1, r6);
    FUN_80091c0(0, 0, 3, 1, r5 - 1, r6);

    //LAB_200a446
  }

  /**
   * Event list 0x200b9f4 handler 31
   */
  @Method(0x200a450)
  public static void FUN_200a450() {
    final int r5 = getMapActor(17).pos_08.getX() >> 20;
    final int r6 = getMapActor(17).pos_08.getZ() >> 20;
    if(r6 == 0xf) {
      FUN_2009774(17, 0, 64);
      //LAB_200a478
    } else if(r6 == 0x12) {
      FUN_2009774(17, 0, 16);
      //LAB_200a488
    } else if(r6 == 0x13) {
      return;
    }

    //LAB_200a48c
    sleep(2);
    FUN_80091c0(r5 - 1, r6, 3, 1, r5 - 1, r6);
    FUN_80091c0(0, 0, 3, 1, r5 - 1, r6);

    //LAB_200a4be
  }

  /**
   * Event list 0x200b9f4 handler 34
   */
  @Method(0x200a4c8)
  public static void FUN_200a4c8() {
    final int r8 = getMapActor(18).pos_08.getX() >> 20;
    final int r6 = getMapActor(18).pos_08.getZ() >> 20;
    final int r7 = getMapActor(19).pos_08.getX() >> 20;
    final int r5 = getMapActor(14).pos_08.getX() >> 20;
    final int r2 = getMapActor(16).pos_08.getX() >> 20;
    if(r6 == 0x13) {
      if(r7 >= 6 && r7 <= 8) {
        FUN_2009774(18, 0, -16);
        //LAB_200a512
      } else if(r5 >= 6 && r5 <= 8) {
        FUN_2009774(18, 0, -64);
        //LAB_200a51c
      } else if(r2 >= 6 && r2 <= 8) {
        FUN_2009774(18, 0, -112);
      } else {
        //LAB_200a526
        FUN_2009774(18, 0, -64);
        FUN_2009774(18, 0, -96);
      }
      //LAB_200a536
    } else if(r6 == 0x12) {
      if(r7 >= 6 && r7 <= 8) {
        return;
      }
      if(r5 >= 6 && r5 <= 8) {
        FUN_2009774(18, 0, -48);
        //LAB_200a54a
      } else if(r2 >= 6 && r2 <= 8) {
        FUN_2009774(18, 0, -96);
      } else {
        //LAB_200a554
        FUN_2009774(18, 0, -144);
      }
      //LAB_200a558
    } else if(r6 == 0xf) {
      if(r5 >= 6 && r5 <= 8) {
        return;
      }
      if(r2 >= 6 && r2 <= 8) {
        FUN_2009774(18, 0, -48);
      } else {
        //LAB_200a56c
        FUN_2009774(18, 0, -96);
      }
      //LAB_200a570
    } else if(r6 == 0xe) {
      if(r5 >= 6 && r5 <= 8) {
        return;
      }
      if(r2 >= 6 && r2 <= 8) {
        FUN_2009774(18, 0, -32);
      } else {
        FUN_2009774(18, 0, -80);
      }
      //LAB_200a584
    } else if(r6 == 0xc) {
      if(r2 >= 6 && r2 <= 8) {
        return;
      }
      FUN_2009774(18, 0, -48);
      //LAB_200a592
    } else if(r6 == 0xb) {
      if(r2 >= 6 && r2 <= 8) {
        return;
      }

      //LAB_200a59c
      FUN_2009774(18, 0, -32);
      //LAB_200a5aa
    } else if(r6 == 0x9) {
      return;
    }

    //LAB_200a5ae
    sleep(2);
    FUN_80091c0(r8 - 1, r6, 3, 1, r8 - 1, r6);
    FUN_80091c0(0, 0, 3, 1, r8 - 1, r6);

    //LAB_200a5e2
  }

  /**
   * Event list 0x200b9f4 handler 35
   */
  @Method(0x200a5f0)
  public static void FUN_200a5f0() {
    final int r7 = getMapActor(18).pos_08.getX() >> 20;
    final int r6 = getMapActor(18).pos_08.getZ() >> 20;
    final int r5 = getMapActor(19).pos_08.getX() >> 20;
    final int r3 = getMapActor(14).pos_08.getX() >> 20;
    if(r6 == 0x9) {
      if(r3 >= 6 && r3 <= 8) {
        FUN_2009774(18, 0, 32);
      } else if(r5 >= 6 && r5 <= 8) {
        FUN_2009774(18, 0, 80);
      } else {
        FUN_2009774(18, 0, 64);
        FUN_2009774(18, 0, 96);
      }
      //LAB_200a642
    } else if(r6 == 0xb) {
      if(r3 >= 6 && r3 <= 8) {
        return;
      }
      if(r5 >= 6 && r5 <= 8) {
        FUN_2009774(18, 0, 48);
      } else {
        //LAB_200a65e
        FUN_2009774(18, 0, 128);
      }
      //LAB_200a66a
    } else if(r6 == 0xc) {
      if(r5 >= 6 && r5 <= 8) {
        //LAB_200a674
        FUN_2009774(18, 0, 32);
      } else {
        //LAB_200a680
        FUN_2009774(18, 0, 112);
      }
      //LAB_200a68c
    } else if(r6 == 0xe) {
      if(r5 >= 6 && r5 <= 8) {
        return;
      }

      //LAB_200a696
      FUN_2009774(18, 0, 80);
      //LAB_200a6a2
    } else if(r6 == 0xf) {
      FUN_2009774(18, 0, 64);
      //LAB_200a6b2
    } else if(r6 == 0x12) {
      FUN_2009774(18, 0, 16);
      //LAB_200a6c2
    } else if(r6 == 0x13) {
      return;
    }

    //LAB_200a6c6
    sleep(2);
    FUN_80091c0(r7 - 1, r6, 3, 1, r7 - 1, r6);
    FUN_80091c0(0, 0, 3, 1, r7 - 1, r6);

    //LAB_200a6f8
  }

  /**
   * Event list 0x200b9f4 handler 38
   */
  @Method(0x200a700)
  public static void FUN_200a700() {
    final int r8 = getMapActor(9).pos_08.getX() >> 20;
    final int r7 = getMapActor(9).pos_08.getZ() >> 20;
    final int r6 = getMapActor(19).pos_08.getX() >> 20;
    final int r5 = getMapActor(14).pos_08.getX() >> 20;
    final int r2 = getMapActor(16).pos_08.getX() >> 20;
    if(r7 == 0x13) {
      if(r6 >= 9 && r6 <= 11) {
        FUN_2009774(9, 0, -16);
        //LAB_200a74c
      } else if(r5 >= 9 && r5 <= 11) {
        FUN_2009774(9, 0, -64);
        //LAB_200a758
      } else if(r2 >= 9 && r2 <= 11) {
        FUN_2009774(9, 0, -112);
      } else {
        //LAB_200a764
        FUN_2009774(9, 0, -80);
        FUN_2009774(9, 0, -96);
      }
      //LAB_200a774
    } else if(r7 == 0x12) {
      if(r6 >= 9 && r6 <= 11) {
        return;
      }
      if(r5 >= 9 && r5 <= 11) {
        FUN_2009774(9, 0, -48);
      } else if(r2 >= 9 && r2 <= 11) {
        FUN_2009774(9, 0, -96);
      } else {
        //LAB_200a794
        FUN_2009774(9, 0, -96);
        FUN_2009774(9, 0, -64);
      }
      //LAB_200a7a4
    } else if(r7 == 0xf) {
      if(r5 >= 9 && r5 <= 11) {
        return;
      }
      if(r2 >= 9 && r2 <= 11) {
        FUN_2009774(9, 0, -48);
      } else {
        FUN_2009774(9, 0, -112);
      }
      //LAB_200a7bc
    } else if(r7 == 0xe) {
      if(r5 >= 9 && r5 <= 11) {
        return;
      }
      if(r2 >= 9 && r2 <= 11) {
        FUN_2009774(9, 0, -32);
      } else {
        //LAB_200a7d4
        FUN_2009774(9, 0, -96);
      }
      //LAB_200a7d8
    } else if(r7 == 0xc) {
      if(r2 >= 9 && r2 <= 11) {
        return;
      }
      FUN_2009774(9, 0, -64);
      //LAB_200a7e8
    } else if(r7 == 0xb) {
      if(r2 >= 9 && r2 <= 11) {
        return;
      }

      //LAB_200a7f4
      FUN_2009774(9, 0, -48);
      //LAB_200a802
    } else if(r7 >= 0 && r7 <= 9) {
      return;
    }

    //LAB_200a806
    sleep(2);
    FUN_80091c0(r8 - 1, r7, 3, 1, r8 - 1, r7);
    FUN_80091c0(0, 0, 3, 1, r8 - 1, r7);

    //LAB_200a83a
  }

  /**
   * Event list 0x200b9f4 handler 39
   */
  @Method(0x200a848)
  public static void FUN_200a848() {
    final int r8 = getMapActor(9).pos_08.getX() >> 20;
    final int r7 = getMapActor(9).pos_08.getZ() >> 20;
    final int r6 = getMapActor(19).pos_08.getX() >> 20;
    final int r5 = getMapActor(14).pos_08.getX() >> 20;
    final int r3 = getMapActor(16).pos_08.getX() >> 20;
    if(r7 == 0x8) {
      if(r3 >= 9 && r3 <= 11) {
        return;
      }
      if(r5 >= 9 && r5 <= 11) {
        FUN_2009774(9, 0, 48);
      } else if(r6 >= 9 && r6 <= 11) {
        //LAB_200a8a8
        FUN_2009774(9, 0, 96);
      } else {
        FUN_2009774(9, 0, 80);
      }
      //LAB_200a8b4
    } else if(r7 == 0xb) {
      if(r5 >= 9 && r5 <= 11) {
        return;
      }
      if(r6 >= 9 && r6 <= 11) {
        //LAB_200a8c8
        FUN_2009774(9, 0, 48);
      } else {
        //LAB_200a8d4
        FUN_2009774(9, 0, 128);
      }
      //LAB_200a8e0
    } else if(r7 == 0xc) {
      if(r5 >= 9 && r5 <= 11) {
        return;
      }
      if(r6 >= 9 && r6 <= 11) {
        FUN_2009774(9, 0, 32);
      } else {
        //LAB_200a900
        FUN_2009774(9, 0, 112);
      }
      //LAB_200a90c
    } else if(r7 == 0xe) {
      if(r6 >= 9 && r6 <= 11) {
        return;
      }
      FUN_2009774(9, 0, 80);
      //LAB_200a924
    } else if(r7 == 0xf) {
      FUN_2009774(9, 0, 64);
      //LAB_200a934
    } else if(r7 == 0x12) {
      FUN_2009774(9, 0, 16);
    }

    //LAB_200a942
    sleep(2);
    FUN_80091c0(r8 - 1, r7, 3, 1, r8 - 1, r7);
    FUN_80091c0(0, 0, 3, 1, r8 - 1, r7);

    //LAB_200a976
  }

  /**
   * Event list 0x200b9f4 handler 42
   */
  @Method(0x200a984)
  public static void FUN_200a984() {
    final int r7 = getMapActor(19).pos_08.getX() >> 20;
    final int r8 = getMapActor(19).pos_08.getZ() >> 20;
    final int r6 = getMapActor(17).pos_08.getZ() >> 20;
    final int r5 = getMapActor(18).pos_08.getZ() >> 20;
    final int r3 = getMapActor(9).pos_08.getZ() >> 20;
    if(r7 != 3) {
      if(r7 == 0xd) {
        if(r3 == 0xf) {
          FUN_2009774(19, -16, 0);
          //LAB_200a9d0
        } else if(r5 == 0xf) {
          FUN_2009774(19, -64, 0);
          //LAB_200a9d8
        } else if(r6 == 0xf) {
          FUN_2009774(19, -112, 0);
        } else {
          //LAB_200a9e0
          FUN_2009774(19, -112, 0);
          FUN_2009774(19, -48, 0);
        }
        //LAB_200a9f0
      } else if(r7 == 0x6) {
        if(r6 == 0xf) {
          return;
        }
        FUN_2009774(19, -48, 0);
        //LAB_200a9fc
      } else if(r7 == 0x5) {
        FUN_2009774(19, -32, 0);
        //LAB_200aa04
      } else if(r7 == 0x8) {
        if(r5 == 0xf) {
          return;
        }
        if(r6 == 0xf) {
          FUN_2009774(19, -32, 0);
        } else {
          //LAB_200aa14
          FUN_2009774(19, -80, 0);
        }
        //LAB_200aa18
      } else if(r7 == 0x9) {
        if(r5 == 0xf) {
          return;
        }
        if(r6 == 0xf) {
          FUN_2009774(19, -48, 0);
        } else {
          FUN_2009774(19, -96, 0);
        }
        //LAB_200aa28
      } else if(r7 == 0xc) {
        if(r3 == 0xf) {
          return;
        }
        if(r5 == 0xf) {
          FUN_2009774(19, -48, 0);
          //LAB_200aa38
        } else if(r6 == 0xf) {
          //LAB_200aa3c
          FUN_2009774(19, -96, 0);
        } else {
          //LAB_200aa4a
          FUN_2009774(19, -144, 0);
        }
      }

      //LAB_200aa56
      sleep(2);
      FUN_80091c0(r7, r8 - 1, 1, 3, r7, r8 - 1);
      FUN_80091c0(0, 0, 1, 3, r7, r8 - 1);
    }

    //LAB_200aa8a
  }

  /**
   * Event list 0x200b9f4 handler 43
   */
  @Method(0x200aa98)
  public static void FUN_200aa98() {
    final int r6 = getMapActor(19).pos_08.getX() >> 20;
    final int r7 = getMapActor(19).pos_08.getZ() >> 20;
    final int r5 = getMapActor(18).pos_08.getZ() >> 20;
    final int r3 = getMapActor(9).pos_08.getZ() >> 20;
    if(r6 == 0x3) {
      if(r5 == 0xf) {
        FUN_2009774(19, 32, 0);
        //LAB_200aad2
      } else if(r3 == 0xf) {
        FUN_2009774(19, 80, 0);
      } else {
        //LAB_200aadc
        FUN_2009774(19, 112, 0);
        FUN_2009774(19, 48, 0);
      }
      //LAB_200aaec
    } else if(r6 == 0x5) {
      if(r5 == 0xf) {
        return;
      }
      if(r3 == 0xf) {
        FUN_2009774(19, 48, 0);
      } else {
        //LAB_200aafe
        FUN_2009774(19, 128, 0);
      }
      //LAB_200ab04
    } else if(r6 == 0x6) {
      if(r3 == 0xf) {
        FUN_2009774(19, 32, 0);
      } else {
        //LAB_200ab12
        FUN_2009774(19, 112, 0);
      }
      //LAB_200ab18
    } else if(r6 == 0x8) {
      if(r3 == 0xf) {
        return;
      }
      FUN_2009774(19, 80, 0);
      //LAB_200ab26
    } else if(r6 == 0x9) {
      FUN_2009774(19, 64, 0);
      //LAB_200ab36
    } else if(r6 == 0xc) {
      FUN_2009774(19, 16, 0);
    }

    //LAB_200ab44
    sleep(2);
    FUN_80091c0(r6, r7 - 1, 1, 3, r6, r7 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r7 - 1);

    //LAB_200ab76
  }

  /**
   * Event list 0x200b9f4 handler 46
   */
  @Method(0x200ab80)
  public static void FUN_200ab80() {
    final int r0;
    int r1;
    final int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r6 = getMapActor(14).pos_08.getX() >> 20;
    r7 = getMapActor(14).pos_08.getZ() >> 20;
    r5 = getMapActor(18).pos_08.getZ() >> 20;
    r3 = getMapActor(9).pos_08.getZ() >> 20;
    CPU.cmpT(r6, 0xd);
    if(CPU.cpsr().getZero()) { // ==
      r3 = r3 - 0xc;
      CPU.cmpT(r3, 0x2);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r1 = 0x10;
        r1 = -r1;
        r0 = 0xe;
        r2 = 0x0;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_200abba
        r3 = r5;
        r3 = r3 - 0xc;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r1 = 0x40;
          r1 = -r1;
          r0 = 0xe;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200abc6
          r1 = 0x70;
          r1 = -r1;
          r0 = 0xe;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        }
      }
    } else {
      //LAB_200abca
      CPU.cmpT(r6, 0xc);
      if(CPU.cpsr().getZero()) { // ==
        r3 = r3 - 0xc;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          return;
        }
        r3 = r5;
        r3 = r3 - 0xc;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r1 = 0x30;
          r1 = -r1;
          r0 = 0xe;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200abe0
          r1 = 0x60;
          r1 = -r1;
          r0 = 0xe;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        }
      } else {
        //LAB_200abe4
        CPU.cmpT(r6, 0x9);
        if(CPU.cpsr().getZero()) { // ==
          r3 = r5;
          r3 = r3 - 0xc;
          CPU.cmpT(r3, 0x2);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            return;
          }
          r1 = 0x30;
          r1 = -r1;
          r0 = 0xe;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200abf4
          CPU.cmpT(r6, 0x8);
          if(CPU.cpsr().getZero()) { // ==
            r3 = r5;
            r3 = r3 - 0xc;
            CPU.cmpT(r3, 0x2);
            if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
              return;
            }
            r1 = 0x20;
            r1 = -r1;
            r0 = 0xe;
            r2 = 0x0;
            FUN_2009774(r0, r1, r2);
          } else {
            //LAB_200ac0e
            CPU.cmpT(r6, 0x6);
            if(CPU.cpsr().getZero()) { // ==
              return;
            }
          }
        }
      }
    }

    //LAB_200ac12
    sleep(2);
    FUN_80091c0(r6, r7 - 1, 1, 3, r6, r7 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r7 - 1);

    //LAB_200ac44
  }

  /**
   * Event list 0x200b9f4 handler 47
   */
  @Method(0x200ac4c)
  public static void FUN_200ac4c() {
    final int r0;
    final int r1;
    final int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r6 = getMapActor(14).pos_08.getX() >> 20;
    r7 = getMapActor(14).pos_08.getZ() >> 20;
    r5 = getMapActor(18).pos_08.getZ() >> 20;
    r3 = getMapActor(9).pos_08.getZ() >> 20;
    CPU.cmpT(r6, 0x6);
    if(CPU.cpsr().getZero()) { // ==
      r3 = r3 - 0xc;
      CPU.cmpT(r3, 0x2);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r0 = 0xe;
        r1 = 0x20;
        r2 = 0x0;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_200ac88
        r3 = r5;
        r3 = r3 - 0xc;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = 0xe;
          r1 = 0x40;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200ac96
          r0 = 0xe;
          r1 = 0x70;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        }
      }
    } else {
      //LAB_200ac9c
      CPU.cmpT(r6, 0x8);
      if(CPU.cpsr().getZero()) { // ==
        r3 = r3 - 0xc;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          return;
        }
        r0 = 0xe;
        r1 = 0x50;
        r2 = 0x0;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_200acac
        CPU.cmpT(r6, 0x9);
        if(CPU.cpsr().getZero()) { // ==
          r3 = r3 - 0xc;
          CPU.cmpT(r3, 0x2);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            return;
          }
          r0 = 0xe;
          r1 = 0x40;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200acbc
          CPU.cmpT(r6, 0xc);
          if(CPU.cpsr().getZero()) { // ==
            r0 = 0xe;
            r1 = 0x10;
            r2 = 0x0;
            FUN_2009774(r0, r1, r2);
          } else {
            //LAB_200accc
            CPU.cmpT(r6, 0xd);
            if(CPU.cpsr().getZero()) { // ==
              return;
            }
          }
        }
      }
    }

    //LAB_200acd0
    sleep(2);
    FUN_80091c0(r6, r7 - 1, 1, 3, r6, r7 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r7 - 1);

    //LAB_200ad02
  }

  /**
   * Event list 0x200b9f4 handler 50
   */
  @Method(0x200ad0c)
  public static void FUN_200ad0c() {
    final int r0;
    int r1;
    final int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r6 = getMapActor(16).pos_08.getX() >> 20;
    r7 = getMapActor(16).pos_08.getZ() >> 20;
    r5 = getMapActor(18).pos_08.getZ() >> 20;
    r3 = getMapActor(9).pos_08.getZ() >> 20;
    CPU.cmpT(r6, 0xd);
    if(CPU.cpsr().getZero()) { // ==
      r3 = r3 - 0x9;
      CPU.cmpT(r3, 0x2);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r1 = 0x10;
        r1 = -r1;
        r0 = 0x10;
        r2 = 0x0;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_200ad46
        r3 = r5;
        r3 = r3 - 0x9;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r1 = 0x40;
          r1 = -r1;
          r0 = 0x10;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200ad52
          r1 = 0x70;
          r1 = -r1;
          r0 = 0x10;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        }
      }
    } else {
      //LAB_200ad56
      CPU.cmpT(r6, 0xc);
      if(CPU.cpsr().getZero()) { // ==
        r3 = r3 - 0x9;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          return;
        }
        r3 = r5;
        r3 = r3 - 0x9;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r1 = 0x30;
          r1 = -r1;
          r0 = 0x10;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200ad6c
          r1 = 0x60;
          r1 = -r1;
          r0 = 0x10;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        }
      } else {
        //LAB_200ad70
        CPU.cmpT(r6, 0x9);
        if(CPU.cpsr().getZero()) { // ==
          r3 = r5;
          r3 = r3 - 0x9;
          CPU.cmpT(r3, 0x2);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            return;
          }
          r1 = 0x30;
          r1 = -r1;
          r0 = 0x10;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200ad80
          CPU.cmpT(r6, 0x8);
          if(CPU.cpsr().getZero()) { // ==
            r1 = 0x20;
            r1 = -r1;
            r0 = 0x10;
            r2 = 0x0;
            FUN_2009774(r0, r1, r2);
          } else {
            //LAB_200ad92
            CPU.cmpT(r6, 0x6);
            if(CPU.cpsr().getZero()) { // ==
              return;
            }
          }
        }
      }
    }

    //LAB_200ad96
    sleep(2);
    FUN_80091c0(r6, r7 - 1, 1, 3, r6, r7 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r7 - 1);

    //LAB_200adc8
  }

  /**
   * Event list 0x200b9f4 handler 51
   */
  @Method(0x200add0)
  public static void FUN_200add0() {
    final int r0;
    final int r1;
    final int r2;
    int r3;
    final int r5;
    final int r6;

    r6 = getMapActor(16).pos_08.getX() >> 20;
    r5 = getMapActor(16).pos_08.getZ() >> 20;
    r3 = getMapActor(9).pos_08.getZ() >> 20;
    CPU.cmpT(r6, 0x6);
    if(CPU.cpsr().getZero()) { // ==
      r3 = r3 - 0x9;
      CPU.cmpT(r3, 0x2);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r0 = 0x10;
        r1 = 0x20;
        r2 = 0x0;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_200ae02
        r0 = 0x10;
        r1 = 0x70;
        r2 = 0x0;
        FUN_2009774(r0, r1, r2);
      }
    } else {
      //LAB_200ae08
      CPU.cmpT(r6, 0x8);
      if(CPU.cpsr().getZero()) { // ==
        r3 = r3 - 0x9;
        CPU.cmpT(r3, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          return;
        }
        r0 = 0x10;
        r1 = 0x50;
        r2 = 0x0;
        FUN_2009774(r0, r1, r2);
      } else {
        //LAB_200ae18
        CPU.cmpT(r6, 0x9);
        if(CPU.cpsr().getZero()) { // ==
          r0 = 0x10;
          r1 = 0x40;
          r2 = 0x0;
          FUN_2009774(r0, r1, r2);
        } else {
          //LAB_200ae22
          CPU.cmpT(r6, 0xc);
          if(CPU.cpsr().getZero()) { // ==
            r0 = 0x10;
            r1 = 0x10;
            r2 = 0x0;
            FUN_2009774(r0, r1, r2);
          } else {
            //LAB_200ae32
            CPU.cmpT(r6, 0xd);
            if(CPU.cpsr().getZero()) { // ==
              return;
            }
          }
        }
      }
    }

    //LAB_200ae36
    sleep(2);
    FUN_80091c0(r6, r5 - 1, 1, 3, r6, r5 - 1);
    FUN_80091c0(0, 0, 1, 3, r6, r5 - 1);

    //LAB_200ae68
  }

  @Method(0x200aed8)
  public static void FUN_200aed8(final int r0) {
    final Actor70 r7 = getMapActor(r0);
    final Sprite38 r6 = r7.sprite_50.deref();
    r6.packet_00.attribs_04.flags_01.and(~0x20);
    r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400).and(0xf00);
    r6.layerCount_27.set(0);
    FUN_80091e0(r7, 0);
    r7._5c.set(0);
    r7._55.set(0);

    if(readFlag(0x109) == 0) {
      r7.pos_08.y_04.add(0x200000);
    }

    //LAB_200af3c
    r7.flags_23.and(~0x1);
    r7._61.set(0x1);
    final int r5 = mallocSlotChip(17, 0x608);
    FUN_8015250(0xb5);
    allocateSpriteSlot(r6.slot_1c.get(), 0x80, r5 + 0x400);
    freeSlot(17);
    r7.dest_38.setX(r7.pos_08.getX());
    r7.dest_38.setY(r7.pos_08.getY());
    r7.velocityScalar_30.set(0);
    r7._5c.set(0x1);
    r7._6c.set(getConsumer(Map132Overlay_87ced6c.class, "FUN_200ae70", Actor70.class));
    r7._56.set(0);
  }

  /** {@link CopiedSegment8000770#FUN_3000380} */
  @Method(0x200afb0)
  public static int FUN_200afb0(final int r0, final int r1) {
    return (int)MEMORY.call(0x3000380, r0, r1);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200afb8)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#sin_} */
  @Method(0x200afc8)
  public static int sin(final int angle) {
    return (int)MEMORY.call(0x8000118, angle);
  }

  /** {@link GoldenSun#cos_} */
  @Method(0x200afd0)
  public static int cos(final int angle) {
    return (int)MEMORY.call(0x8000120, angle);
  }

  /** {@link GoldenSun#retVec3} */
  @Method(0x200afd8)
  public static void retVec3(final int distance, final int angle, final Vec3 vec) {
    MEMORY.call(0x8000128, distance, angle, vec);
  }

  /** {@link GoldenSun#mallocSlotChip_} */
  @Method(0x200afe0)
  public static int mallocSlotChip(final int slot, final int size) {
    return (int)MEMORY.call(0x8000140, slot, size);
  }

  /** {@link GoldenSun#freeSlot_} */
  @Method(0x200afe8)
  public static void freeSlot(final int slot) {
    MEMORY.call(0x8000150, slot);
  }

  /** {@link GoldenSun#allocateSpriteSlot_} */
  @Method(0x200aff0)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x80001c8, slot, size, newDataPtr);
  }

  /** {@link GoldenSun#setActorAnimation_} */
  @Method(0x200aff8)
  public static void setActorAnimation(final Actor70 actor, final int animationIndex) {
    MEMORY.call(0x8009080, actor, animationIndex);
  }

  /** {@link GoldenSun#setActorSpriteScript_} */
  @Method(0x200b000)
  public static void FUN_8009098(final Actor70 r0, final int r1) {
    MEMORY.call(0x8009098, r0, r1);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200b008)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009150} */
  @Method(0x200b010)
  public static void FUN_8009150(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x8009150, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009158} */
  @Method(0x200b018)
  public static void FUN_8009158(final Actor70 r0) {
    MEMORY.call(0x8009158, r0);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x200b020)
  public static void FUN_8009178(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200b028)
  public static void FUN_80091c0(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091d8} */
  @Method(0x200b030)
  public static int FUN_80091d8(final Actor70 r0, final Vec3 r1) {
    return (int)MEMORY.call(0x80091d8, r0, r1);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200b038)
  public static void FUN_80091e0(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_8009278} */
  @Method(0x200b048)
  public static void FUN_8009278(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8009278, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_801#FUN_8015250} */
  @Method(0x200b050)
  public static void FUN_8015250(final int r0) {
    MEMORY.call(0x8015250, r0);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200b058)
  public static int readFlag(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200b060)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200b068)
  public static void FUN_808a010(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200b070)
  public static void FUN_808a018() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200b078)
  public static void FUN_808a020() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a060} */
  @Method(0x200b080)
  public static int FUN_808a060(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a060, r0, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200b088)
  public static Actor70 getMapActor(final int actorIndex) {
    return (Actor70)MEMORY.call(0x808a080, actorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200b090)
  public static void setActorVelocityScalerAndAcceleration(final int actorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, actorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200b098)
  public static void FUN_808a0c0(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0c0, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0d8} */
  @Method(0x200b0a0)
  public static void FUN_808a0d8(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a0d8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0e0} */
  @Method(0x200b0a8)
  public static void FUN_808a0e0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a0e0, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200b0b0)
  public static void FUN_808a0e8(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x200b0b8)
  public static void FUN_808a0f0(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200b0c0)
  public static void setActorAnimationIfLoaded(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a160} */
  @Method(0x200b0c8)
  public static void FUN_808a160(final Actor70 r0, final int r1) {
    MEMORY.call(0x808a160, r0, r1);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200b0d0)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200b0d8)
  public static void FUN_808a248(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a250} */
  @Method(0x200b0e0)
  public static void FUN_808a250(final int r0, final int r1) {
    MEMORY.call(0x808a250, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a260} */
  @Method(0x200b0e8)
  public static void FUN_808a260(final int r0, final int r1) {
    MEMORY.call(0x808a260, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200b0f0)
  public static void FUN_808a360() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200b0f8)
  public static void FUN_808a370() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a398} */
  @Method(0x200b100)
  public static void FUN_808a398(final int r0, final int r1) {
    MEMORY.call(0x808a398, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a3c0} */
  @Method(0x200b108)
  public static void FUN_808a3c0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a3c0, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a5e8} */
  @Method(0x200b110)
  public static void FUN_808a5e8() {
    MEMORY.call(0x808a5e8);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200b118)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }

  /** TODO dunno how many params */
  @Method(0x200b12c)
  public static void FUN_200b12c(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(r3, r0, r1, r2);
  }
}
