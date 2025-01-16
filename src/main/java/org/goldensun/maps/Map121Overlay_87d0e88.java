package org.goldensun.maps;

import org.goldensun.DebugHelper;
import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_801;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.FieldPsynergy720;
import org.goldensun.types.Map194;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Structccc;
import org.goldensun.types.TileAttributes04;
import org.goldensun.types.Vec3;

import static org.goldensun.GoldenSunVars._2000432;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.tileAttribs_2010000;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class Map121Overlay_87d0e88 {
  private Map121Overlay_87d0e88() { }

  private static final Vec3 _200b720 = MEMORY.ref(4, 0x200b720, Vec3::new);

  @Method(0x2008048)
  public static Actor70 FUN_2008048(final int r0, final int r1, final int r2, final int r3) {
    final Actor70 r5 = loadActor(r3, r0, r1, r2);
    if(r5 == null) {
      //LAB_2008096
      return null;
    }

    r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
    r5._55.set(0);
    r5._59.set(0x8);
    FUN_80091e0(r5, 0);
    FUN_808a160(r5, 0xe);
    FUN_80091e8(r5, 1);
    return r5;
  }

  @Method(0x20080a0)
  public static Actor70 FUN_20080a0(final int r0, final int r1, final int r2, final int r3) {
    final Actor70 r5 = loadActor(r3, r0, r1, r2);
    if(r5 == null) {
      //LAB_20080fa
      return null;
    }

    r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    r5._55.set(0);
    r5._59.set(0x8);
    FUN_80091e0(r5, 0);
    FUN_808a160(r5, 15);
    r5.flags_23.and(~0x1).or(0x2);
    return r5;
  }

  @Method(0x2008350)
  public static Actor70 FUN_2008350(final Vec3 r0) {
    final Structccc r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    //LAB_2008364
    for(int r5 = 8; r5 < 66; r5++) {
      final Actor70 actor = r2.actors_14.get(r5).derefNullable();
      if(actor != null && r0.getX() >> 20 == actor.pos_08.getX() >> 20 && r0.getY() / 0x10000 == actor.pos_08.getY() / 0x10000 && r0.getZ() >> 20 == actor.pos_08.getZ() >> 20) {
        return actor;
      }

      //LAB_2008392
    }

    //LAB_200839a
    return null;
  }

  @Method(0x20083a8)
  public static void FUN_20083a8() {
    final Actor70 r8 = getMapActor(0);
    final int r5 = ((r8.angle_06.get() & 0xffff) >>> 12) * 0x4;
    final int r1 = MEMORY.ref(4, 0x200aca0 + r5).get();
    final Vec3 r7 = new Vec3();
    r7.setX(r8.pos_08.getX() + (r1 & 0xffff0000));
    r7.setY(r8.pos_08.getY());
    r7.setZ(r8.pos_08.getZ() + (r1 << 16));
//    r1 = r8;
    final Actor70 r6 = FUN_2008350(r7);
    if(r6 != null) {
      //LAB_20083f8
      r7.setX(r6.pos_08.getX() + (r1 & 0xffff0000));
      r7.setY(r6.pos_08.getY());
      r7.setZ(r6.pos_08.getZ() + (r1 << 16));
//      r1 = r6;
      Actor70 r0 = FUN_2008350(r7);
      if(r0 == null || (r0._59.get() & 0x1) == 0x0) {
        //LAB_200842e
        r7.setX(r6.pos_08.getX());
        r7.setY(r6.pos_08.getY() + 0x100000);
        r7.setZ(r6.pos_08.getZ());
//        r1 = r6;
        r0 = FUN_2008350(r7);
        if(r0 == null || (r0._59.get() & 0x1) == 0x0) {
          //LAB_200845a
          r6.layer_22.set(2);
          r7.setX(r6.pos_08.getX() + (r1 & 0xffff0000));
          r7.setY(r6.pos_08.getY());
          r7.setZ(r6.pos_08.getZ() + (r1 << 16));
          if(FUN_80091d8(r6, r7) <= 0 && r6._62.get() == 0) {
            setActorAnimation(r8, 8);
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
            r8.pos_08.setX(r8.pos_08.getX() >> 16 << 16);
            r8.pos_08.setZ(r8.pos_08.getZ() >> 16 << 16);
            setActorAnimation(r8, 1);
          }
        }
      }
    }

    //LAB_200850a
  }

  @Method(0x2008528)
  public static int setMapTileTypes(final int mapLayer, final int x, final int y, final int w, final int h, final int tileType) {
    final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    if(map != null) {
      final UnboundedArrayRef<TileAttributes04> tiles;
      if(mapLayer < 3) {
        tiles = map.layers_104.get(mapLayer).tiles_2c.deref();
      } else {
        //LAB_2008552
        tiles = tileAttribs_2010000;
      }

      //LAB_2008554
      //LAB_2008562
      for(int y1 = 0; y1 < h; y1++) {
        //LAB_200856c
        for(int x1 = 0; x1 < w; x1++) {
          tiles.get((y + y1) * 0x80 + x + x1).setTile(tileType);
        }

        //LAB_2008576
      }
    }

    //LAB_200857c
    return 0;
  }

  @Method(0x2008630)
  public static Actor70 FUN_2008630(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r12;
    int lr;

    final int sp14 = r0;
    final int sp10 = r1;
    final int sp0c = r2;
    final ArrayRef<Pointer<Actor70>> actors = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).actors_14;
    MEMORY.ref(4, sp14).setu((getMapActor(0).angle_06.get() & 0xffff) >>> 12);
    final Actor70 r9 = getMapActor(0);

    //LAB_2008662
    for(int sp08 = 8; sp08 < 66; sp08++) {
      final Actor70 r10 = actors.get(sp08).deref();
      final int sp04 = r10.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get();

      //LAB_200867c
      for(r8 = 0; r8 < 6; r8++) {
        r0 = 0x200acf8 + r8 * 0x10;
        if(sp04 == MEMORY.ref(4, 0x200ace0 + r8 * 0x4).get()) {
          MEMORY.ref(4, sp0c).setu(r8);
          r2 = MEMORY.ref(4, 0x200aca0 + MEMORY.ref(4, sp14).get() * 0x4).get();
          r3 = r2 >> 16;
          lr = r9.pos_08.getX();
          r1 = lr >> 16;
          r1 = r1 + r3;
          r7 = r1 >> 4;
          r1 = r9.pos_08.getZ();
          r2 = r2 << 16;
          r2 = r2 >> 16;
          r3 = r1 >> 16;
          r3 = r3 + r2;
          r5 = r3 >> 4;
          r12 = r1;
          r1 = r10.pos_08.getX() >> 16;
          r2 = r10.pos_08.getZ() >> 16;
          r6 = r1 + MEMORY.ref(4, r0).get() >> 4;
          r4 = r2 + MEMORY.ref(4, r0 + 0x4).get() >> 4;
          r1 = r1 + MEMORY.ref(4, r0 + 0x8).get() >> 4;
          r2 = r2 + MEMORY.ref(4, r0 + 0xc).get() >> 4;
          if(r6 <= r7 && r7 < r1 && r4 <= r5 && r5 < r2) {
            if((r8 & 0x1) != 0x0 && r6 != lr >> 20) {
              MEMORY.ref(4, sp10).setu(sp08);
              return r10;
            }

            //LAB_2008708
            if(r4 != r12 >> 20) {
              MEMORY.ref(4, sp10).setu(sp08);
              return r10;
            }
          }
        }

        //LAB_200871a
      }
    }

    //LAB_2008736
    return null;
  }

  @Method(0x2008758)
  public static int FUN_2008758(final int r0) {
    CPU.sp().value -= 0x20;
    MEMORY.ref(4, r0 + 0x14).setu(0);
    final Actor70 r10 = FUN_2008630(CPU.sp().value + 0x10, r0 + 0x4, r0);
    if(r10 == null) {
      CPU.sp().value += 0x20;
      return 0;
    }

    //LAB_2008782
    r10.layer_22.set(2);
    final int r1 = MEMORY.ref(4, r0).get() << 4;
    final int sp08 = Math.abs(MEMORY.ref(4, 0x200acf8 + r1 + 0x4).get()) + Math.abs(MEMORY.ref(4, 0x200acf8 + r1 + 0xc).get()) >> 4;
    final int r9 = Math.abs(MEMORY.ref(4, 0x200acf8 + r1).get()) + Math.abs(MEMORY.ref(4, 0x200acf8 + r1 + 0x8).get()) >> 4;
    final int r8 = CPU.sp().value + 0x14;
    MEMORY.ref(4, r8).setu(r10.pos_08.getX() + (MEMORY.ref(4, 0x200aca0 + MEMORY.ref(4, CPU.sp().value + 0x10).get() * 0x4).get() & 0xffff0000));
    MEMORY.ref(4, r8 + 0x4).setu(r10.pos_08.getY());
    MEMORY.ref(4, r8 + 0x8).setu(r10.pos_08.getZ() + (MEMORY.ref(4, 0x200aca0 + MEMORY.ref(4, CPU.sp().value + 0x10).get() * 0x4).get() << 16));
    MEMORY.ref(4, r0 + 0xc).setu(r10.pos_08.getY());

    //LAB_2008804
    for(int sp0c = 0; ; sp0c++) {
      MEMORY.ref(4, r0 + 0x10).setu(MEMORY.ref(4, r8 + 0x8).get() + (MEMORY.ref(4, 0x200acf8 + MEMORY.ref(4, r0).get() * 0x10 + 0x4).get() << 16));

      //LAB_2008820
      for(int r7 = 0; r7 < sp08; r7++) {
        MEMORY.ref(4, r0 + 0x8).setu(MEMORY.ref(4, r8).get() + (MEMORY.ref(4, 0x200acf8 + MEMORY.ref(4, r0).get() * 0x10).get() << 16));

        //LAB_2008838
        for(int r5 = 0; r5 < r9; r5++) {
          if(FUN_80091d8(r10, MEMORY.ref(4, r0 + 0x8, Vec3::new)) == 0x2) {
            //LAB_2008894
            r10.layer_22.set(0);

            final int ret;
            if(sp0c != 0x0) {
              final int r2 = MEMORY.ref(4, 0x200aca0 + MEMORY.ref(4, CPU.sp().value + 0x10).get() * 0x4).get();
              MEMORY.ref(4, r0 + 0x8).setu(r10.pos_08.getX() + sp0c * (r2 & 0xffff0000));
              MEMORY.ref(4, r0 + 0xc).setu(r10.pos_08.getY());
              MEMORY.ref(4, r0 + 0x10).setu(r10.pos_08.getZ() + sp0c * (r2 << 16));
              ret = 1;
            } else {
              ret = 0;
            }

            //LAB_20088cc
            CPU.sp().value += 0x20;
            return ret;
          }

          MEMORY.ref(4, r0 + 0x8).addu(0x100000);
        }

        //LAB_2008858
        MEMORY.ref(4, r0 + 0x10).addu(0x100000);
      }

      //LAB_200886a
      MEMORY.ref(4, r8).addu(MEMORY.ref(4, 0x200aca0 + MEMORY.ref(4, CPU.sp().value + 0x10).get() * 0x4).get() & 0xffff0000);
      MEMORY.ref(4, r8 + 0x8).addu(MEMORY.ref(4, 0x200aca0 + MEMORY.ref(4, CPU.sp().value + 0x10).get() * 0x4).get() << 16);
    }
  }

  @Method(0x20088ec)
  public static int FUN_20088ec(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    final int r4;
    int r6;

    CPU.sp().value -= 0x10;
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x28;
    MEMORY.ref(4, CPU.sp().value + 0x48).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x50).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x54).setu(r3);
    final Map194 sp0c = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    CPU.r8().value = (getMapActor(0).angle_06.get() & 0xffff) >>> 12;
    final Actor70 r7 = getMapActor(a5);
    r4 = 0x200acf8;
    r1 = a4 << 4;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(Math.abs(MEMORY.ref(4, r4 + r1 + 0x4).get()) + Math.abs(MEMORY.ref(4, r4 + r1 + 0xc).get()) >> 4);
    CPU.r9().value = Math.abs(MEMORY.ref(4, r4 + r1).get()) + Math.abs(MEMORY.ref(4, r4 + r1 + 0x8).get()) >> 4;
    r0 = CPU.sp().value + 0x1c;
    r7.velocityScalar_30.set(0x8000);
    r7.acceleration_34.set(0x1999);
    MEMORY.ref(4, r0).setu(r7.pos_08.getX());
    MEMORY.ref(4, r0 + 0x8).setu(r7.pos_08.getZ());
    CPU.r11().value = r0;
    r1 = r7.pos_08.getX() + (MEMORY.ref(4, r4 + a4 * 0x10).get() << 16);
    r0 = CPU.sp().value + 0x10;
    MEMORY.ref(4, r0).setu(r1);
    r1 = r1 >> 20;
    MEMORY.ref(4, r0).setu(r1);
    r2 = r7.pos_08.getZ() + (MEMORY.ref(4, r4 + a4 * 0x10 + 0x4).get() << 16) >> 20;
    MEMORY.ref(4, r0 + 0x8).setu(r2);
    setMapTileTypes(0, r1, r2, CPU.r9().value, MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0);
    setActorVelocityScalerAndAcceleration(0, 0x8000, 0x1999);
    setActorAnimationIfLoaded(0, 8);
    FUN_808a010(15);
    FUN_808a0e0(0, MEMORY.ref(4, CPU.sp().value + 0x50).get() - MEMORY.ref(4, CPU.r11().value).get() / 0x20000, MEMORY.ref(4, CPU.sp().value + 0x58).get() - MEMORY.ref(4, CPU.r11().value + 0x8).get() / 0x20000);
    getMapActor(0)._6c.set(getConsumer(Map121Overlay_87d0e88.class, "FUN_200858c", Actor70.class));
    FUN_808a010(4);
    r3 = CPU.r8().value - 0x6;
    if((r3 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
      setActorAnimation(r7, 3);
    } else {
      //LAB_2008a08
      setActorAnimation(r7, 2);
    }

    //LAB_2008a10
    playSound(0xef);
    FUN_8009150(r7, MEMORY.ref(4, CPU.sp().value + 0x50).get(), MEMORY.ref(4, CPU.sp().value + 0x54).get(), MEMORY.ref(4, CPU.sp().value + 0x58).get());
    FUN_808a0e8(0);
    setActorAnimationIfLoaded(0, 2);
    setActorVelocityScalerAndAcceleration(0, 0x4ccc, 0x1999);
    r1 = CPU.r8().value;
    r3 = r1 << 2;
    r0 = MEMORY.ref(4, 0x200aca0 + r3).get();
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
    r3 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    if(r3 != 0x0) {
      MEMORY.call(r3, r0, r1, r2); //TODO unknown param count
    }

    //LAB_2008a68
    FUN_808a0e8(0);
    setActorAnimationIfLoaded(0, 1);
    getMapActor(0)._6c.clear();
    FUN_8009158(r7);
    playSound(0x120);
    playSound(0xd5);
    r7.pos_08.setX(MEMORY.ref(4, CPU.sp().value + 0x50).get());
    r7.pos_08.setZ(MEMORY.ref(4, CPU.sp().value + 0x58).get());
    r7.velocity_24.setX(0);
    r7.velocity_24.setZ(0);
    setActorAnimation(r7, 1);
    r2 = a4 << 4;
    r3 = MEMORY.ref(4, 0x200acf8 + r2).get();
    r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
    r3 = r3 << 16;
    r2 = r2 + 0x4;
    r0 = r0 + r3;
    r3 = MEMORY.ref(4, 0x200acf8 + r2).get();
    r1 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
    r3 = r3 << 16;
    r1 = r1 + r3;
    r0 = r0 >> 20;
    r1 = r1 >> 20;
    MEMORY.ref(4, CPU.sp().value + 0x50).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x58).setu(r1);
    CPU.r8().value = sp0c.layers_104.get(1)._08.get() >> 20;
    r6 = sp0c.layers_104.get(1)._0c.get() >> 20;
    FUN_80091c0(r0, r1, CPU.r9().value, MEMORY.ref(4, CPU.sp().value + 0x8).get(), CPU.r8().value + r0, r6 + r1);
    setMapTileTypes(0, MEMORY.ref(4, CPU.sp().value + 0x50).get(), MEMORY.ref(4, CPU.sp().value + 0x58).get(), CPU.r9().value, MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0xff);
    setMapTileTypes(2, MEMORY.ref(4, CPU.sp().value + 0x50).get(), MEMORY.ref(4, CPU.sp().value + 0x58).get(), CPU.r9().value, MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0xff);
    r2 = a4 << 4;
    r3 = MEMORY.ref(4, 0x200acf8 + r2).get();
    r0 = CPU.r11().value;
    r1 = MEMORY.ref(4, r0).get();
    r3 = r3 << 16;
    r2 = r2 + 0x4;
    r1 = r1 + r3;
    r3 = MEMORY.ref(4, 0x200acf8 + r2).get();
    r2 = MEMORY.ref(4, r0 + 0x8).get();
    r3 = r3 << 16;
    r2 = r2 + r3;
    r1 = r1 >> 20;
    r2 = r2 >> 20;
    MEMORY.ref(4, r0).setu(r1);
    MEMORY.ref(4, r0 + 0x8).setu(r2);
    CPU.r8().value = CPU.r8().value + r1;
    r6 = r6 + r2;
    FUN_80091c0(CPU.r8().value, r6, CPU.r9().value, MEMORY.ref(4, CPU.sp().value + 0x8).get(), r1, r2);
    r0 = setMapTileTypes(2, MEMORY.ref(4, CPU.r11().value).get(), MEMORY.ref(4, CPU.r11().value + 0x8).get(), CPU.r9().value, MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0);
    FUN_808a5e8();
    CPU.sp().value += 0x28;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    CPU.sp().value += 0x10;
    return r0;
  }

  @Method(0x2008ba4)
  public static int FUN_2008ba4(int r0) {
    final int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x20;
    final Map194 r10 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Actor70 actor = getMapActor(r0);
    final Sprite38 sprite = actor.sprite_50.deref();
    r2 = sprite.layers_28.get(0).deref().spriteDataIndex_00.get();
    r3 = MEMORY.ref(4, 0x200ace0).get();
    r5 = 0x0;
    r7 = CPU.sp().value + 0x8;

    jmp_2008bf2:
    {
      if(r2 != r3) {
        //LAB_2008bce
        CPU.r12().value = r7;
        r6 = 0x7;
        r4 = 0x200ace0;

        //LAB_2008bd6
        do {
          r5++;
          MEMORY.ref(4, CPU.r12().value).setu(r6);
          if(r5 > 5) {
            break jmp_2008bf2;
          }
          r4 = r4 + 0x4;
          r3 = MEMORY.ref(4, r4).get();
        } while(sprite.layers_28.get(0).deref().spriteDataIndex_00.get() != r3);
      }

      //LAB_2008bf0
      MEMORY.ref(4, r7).setu(r5);
    }

    //LAB_2008bf2
    r2 = MEMORY.ref(4, r7).get();
    if((r2 & 0xffff_ffffL) > (0x6 & 0xffff_ffffL)) {
      r0 = 0x0;
    } else {
      //LAB_2008bfc
      MEMORY.ref(4, r7 + 0x8).setu(actor.pos_08.getX());
      MEMORY.ref(4, r7 + 0xc).setu(actor.pos_08.getY());
      MEMORY.ref(4, r7 + 0x10).setu(actor.pos_08.getZ());
      CPU.r8().value = Math.abs(MEMORY.ref(4, 0x200acf8 + r2 * 0x10 + 0x4).get()) + Math.abs(MEMORY.ref(4, 0x200acf8 + r2 * 0x10 + 0xc).get()) >> 4;
      r0 = actor.pos_08.getX() + (Math.abs(MEMORY.ref(4, 0x200acf8 + r2 * 0x10).get()) << 16) >> 20;
      r1 = actor.pos_08.getZ() + (MEMORY.ref(4, 0x200acf8 + r2 * 0x10 + 0x4).get() << 16) >> 20;
      r6 = Math.abs(MEMORY.ref(4, 0x200acf8 + r2 * 0x10).get()) + Math.abs(MEMORY.ref(4, 0x200acf8 + r2 * 0x10 + 0x8).get()) >> 4;
      MEMORY.ref(4, r7 + 0x8).setu(r0);
      MEMORY.ref(4, r7 + 0x10).setu(r1);
      FUN_80091c0(r0, r1, r6, CPU.r8().value, (r10.layers_104.get(1)._08.get() >> 20) + r0, (r10.layers_104.get(1)._0c.get() >> 20) + r1);
      setMapTileTypes(0, MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0x10).get(), r6, CPU.r8().value, 0xff);
      setMapTileTypes(2, MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0x10).get(), r6, CPU.r8().value, 0xff);
      r0 = 0x1;
    }

    //LAB_2008ca6
    CPU.sp().value += 0x20;
    CPU.r8().value = CPU.pop();
    return r0;
  }

  @Method(0x2008cc0)
  public static void FUN_2008cc0(final int x1, final int y1, final int x2, final int y2, final int a4, final int x3, final int y3) {
    final UnboundedArrayRef<TileAttributes04> r5 = tileAttribs_2010000.slice(y1 * 0x80 + x1);

    //LAB_2008cf6
    int tileIndex = 0;
    for(int r4 = y3; r4 < y3 + y2; r4++) {
      final int sp00 = (a4 * 0x10 + (r4 & 0xf)) * 0x20;

      //LAB_2008d16
      for(int i = x3; i < x3 + x2; i++) {
        final int tile = r5.get(tileIndex).getTile();
        MEMORY.ref(4, 0x6002800 + (sp00 + (i & 0xf)) * 0x4).setu(MEMORY.ref(4, 0x2020000 + tile * 0x8).get());
        MEMORY.ref(4, 0x6002840 + (sp00 + (i & 0xf)) * 0x4).setu(MEMORY.ref(4, 0x2020004 + tile * 0x8).get());
        tileIndex++;
      }

      //LAB_2008d44
      tileIndex += 0x80 - x2;
    }

    //LAB_2008d4e
  }

  @Method(0x2008d78)
  public static void FUN_2008d78(final Actor70 r0) {
    //LAB_2008d82
    for(int r6 = 60; r6 > 0; r6--) {
      sleep(1);

      if(r0.pos_08.getY() == r0._14.get()) {
        break;
      }

      //LAB_2008d80
    }

    //LAB_2008d94
    r0.velocity_24.setY(0);
    r0.dest_38.setY(0x80000000);
    r0.pos_08.setY(r0._14.get());
  }

  @Method(0x2008da8)
  public static void FUN_2008da8(final Actor70 r0, final int r1) {
    //LAB_2008db4
    for(int r6 = 60; r6 > 0; r6--) {
      sleep(1);

      final int r2 = r0.pos_08.getY();
      if(r2 <= r0._14.get() || r2 <= r1) {
        break;
      }

      //LAB_2008db2
    }

    //LAB_2008dca
    r0.velocity_24.setY(0);
    r0.dest_38.setY(0x80000000);
  }

  @Method(0x2008ddc)
  public static int FUN_2008ddc(final int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    final int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r8().value);
    r5 = r3;
    CPU.r8().value = r1;
    r6 = r2;
    r7 = MEMORY.ref(4, 0x3001e70).get();
    final Actor70 actor = getMapActor(r0);
    r2 = actor.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get();
    r3 = 0x200ace0;
    r4 = 0x0;
    r3 = MEMORY.ref(4, r3 + r4).get();

    jmp_2008e20:
    {
      if(r2 != r3) {
        //LAB_2008e02
        do {
          r3 = 0x7;
          r4 = r4 + 0x1;
          MEMORY.ref(4, r5).setu(r3);
          CPU.cmpT(r4, 0x5);
          if((r4 & 0xffff_ffffL) > (0x5 & 0xffff_ffffL)) {
            break jmp_2008e20;
          }
          r1 = actor.sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get();
          r2 = 0x200ace0;
          r3 = r4 << 2;
          r3 = MEMORY.ref(4, r2 + r3).get();
        } while(r1 != r3);
      }

      //LAB_2008e1e
      MEMORY.ref(4, r5).setu(r4);
    }

    //LAB_2008e20
    r2 = MEMORY.ref(4, r5).get();
    CPU.cmpT(r2, 0x6);
    if((r2 & 0xffff_ffffL) > (0x6 & 0xffff_ffffL)) {
      CPU.r8().value = CPU.pop();
      return 0;
    }

    //LAB_2008e2a
    MEMORY.ref(4, r5 + 0x8).setu(actor.pos_08.getX());
    MEMORY.ref(4, r5 + 0xc).setu(actor.pos_08.getY());
    MEMORY.ref(4, r5 + 0x10).setu(actor.pos_08.getZ());
    r1 = r2 << 4;
    r3 = r1 + 0x4;
    r2 = MEMORY.ref(4, 0x200acf8 + r3).get();
    CPU.cmpT(r2, 0x0);
    if(r2 < 0x0) {
      r2 = -r2;
    }

    //LAB_2008e44
    r3 = r1;
    r3 = r3 + 0xc;
    r3 = MEMORY.ref(4, 0x200acf8 + r3).get();
    CPU.cmpT(r3, 0x0);
    if(r3 < 0x0) {
      r3 = -r3;
    }

    //LAB_2008e50
    r3 = r2 + r3;
    r3 = r3 >> 4;
    MEMORY.ref(4, r6).setu(r3);
    r3 = MEMORY.ref(4, r5).get();
    r3 = r3 << 4;
    r2 = MEMORY.ref(4, 0x200acf8 + r3).get();
    CPU.cmpT(r2, 0x0);
    if(r2 < 0x0) {
      r2 = -r2;
    }

    //LAB_2008e62
    r3 = r3 + 0x8;
    r3 = MEMORY.ref(4, 0x200acf8 + r3).get();
    if(r3 < 0x0) {
      r3 = -r3;
    }

    //LAB_2008e6c
    r3 = r2 + r3;
    r3 = r3 >> 4;
    r1 = CPU.r8().value;
    MEMORY.ref(4, r1).setu(r3);
    r2 = MEMORY.ref(4, r5).get();
    r2 = r2 << 4;
    r3 = MEMORY.ref(4, 0x200acf8 + r2).get();
    r1 = MEMORY.ref(4, r5 + 0x8).get();
    r3 = r3 << 16;
    r1 = r1 + r3;
    MEMORY.ref(4, r5 + 0x8).setu(r1);
    r2 = r2 + 0x4;
    r3 = MEMORY.ref(4, 0x200acf8 + r2).get();
    r2 = MEMORY.ref(4, r5 + 0x10).get();
    r3 = r3 << 16;
    r2 = r2 + r3;
    r2 = r2 >> 20;
    MEMORY.ref(4, r5 + 0x10).setu(r2);
    r1 = r1 >> 20;
    r2 = 0x9e;
    MEMORY.ref(4, r5 + 0x8).setu(r1);
    r2 = r2 << 1;
    r3 = r7 + r2;
    r3 = MEMORY.ref(4, r3).get();
    r3 = r3 >> 20;
    r1 = 0xa0;
    MEMORY.ref(4, a4).setu(r3);
    r1 = r1 << 1;
    r3 = r7 + r1;
    r3 = MEMORY.ref(4, r3).get();
    r3 = r3 >> 20;
    MEMORY.ref(4, a5).setu(r3);

    //LAB_2008eb2
    CPU.r8().value = CPU.pop();
    return 1;
  }

  @Method(0x2008ec8)
  public static int FUN_2008ec8(final int mapActorIndex) {
    CPU.sp().value -= 0x30;
    final Actor70 r7 = getMapActor(mapActorIndex);
    final int r6 = CPU.sp().value + 0x18;

    final int ret;
    if(FUN_2008ddc(mapActorIndex, CPU.sp().value + 0x14, CPU.sp().value + 0x10, r6, CPU.sp().value + 0xc, CPU.sp().value + 0x8) == 0) {
      ret = 0;
    } else {
      //LAB_2008ef2
      FUN_80091c0(2, 2, MEMORY.ref(4, CPU.sp().value + 0x14).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get(), MEMORY.ref(4, r6 + 0x8).get(), MEMORY.ref(4, r6 + 0x10).get());
      setActorAnimation(r7, 4);
      r7.flags_23.or(0x2);
      final int r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      final int r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      if((r1 & 0xffff_ffffL) > (r0 & 0xffff_ffffL)) {
        FUN_8009180(70, 40, MEMORY.ref(4, r6 + 0x8).get() + 0x20, MEMORY.ref(4, r6 + 0x10).get() + 0x2, r1, r0);
      } else {
        //LAB_2008f38
        FUN_8009180(68, 40, MEMORY.ref(4, r6 + 0x8).get() + 0x20, MEMORY.ref(4, r6 + 0x10).get() + 0x2, r1, r0);
      }

      //LAB_2008f4c
      ret = 1;
    }

    //LAB_2008f4e
    CPU.sp().value += 0x30;
    return ret;
  }

  @Method(0x2008f58)
  public static int FUN_2008f58(final int mapActorIndex) {
    CPU.sp().value -= 0x30;
    final Actor70 r7 = getMapActor(mapActorIndex);
    final int r6 = CPU.sp().value + 0x18;

    final int ret;
    if(FUN_2008ddc(mapActorIndex, CPU.sp().value + 0x14, CPU.sp().value + 0x10, r6, CPU.sp().value + 0xc, CPU.sp().value + 0x8) == 0) {
      ret = 0;
    } else {
      //LAB_2008f82
      final int r4 = MEMORY.ref(4, r6 + 0x10).get();
      final int r5 = MEMORY.ref(4, r6 + 0x8).get();
      FUN_80091c0(MEMORY.ref(4, CPU.sp().value + 0xc).get() + r5, MEMORY.ref(4, CPU.sp().value + 0x8).get() + r4, MEMORY.ref(4, CPU.sp().value + 0x14).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get(), r5, r4);
      setMapTileTypes(0, MEMORY.ref(4, r6 + 0x8).get(), MEMORY.ref(4, r6 + 0x10).get(), MEMORY.ref(4, CPU.sp().value + 0x14).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get(), 0xff);
      setActorAnimation(r7, 1);
      r7.flags_23.and(~0x2);
      ret = 1;
    }

    //LAB_2008fc4
    CPU.sp().value += 0x30;
    return ret;
  }

  @Method(0x2008fcc)
  public static void FUN_2008fcc(final int mapLayer, final int x, final int y, final int r3) {
    final Map194 map = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    if(map != null) {
      DMA.channels[3].SAD.setu(map.layers_104.get(mapLayer).tiles_2c.deref().get(y * 0x80 + x).getAddress());
      DMA.channels[3].DAD.setu(r3);
      DMA.channels[3].CNT.setu(0x84000001);

      //LAB_2009000
      while((DMA.channels[3].CNT.get() & 0x80000000) != 0) {
        DebugHelper.sleep(0);
      }
    }
  }

  @Method(0x200901c)
  public static void FUN_200901c(int r0, int r1, int r2, int r3) {
    final int r4;
    final int r5;

    r5 = r3;
    r3 = 0x3001e70;
    r4 = MEMORY.ref(4, r3).get();
    CPU.cmpT(r4, 0x0);
    if(r4 != 0x0) {
      r3 = r0 << 1;
      r3 = r3 + r0;
      r0 = 0x98;
      r0 = r0 << 1;
      r3 = r3 << 4;
      r3 = r3 + r0;
      r0 = MEMORY.ref(4, r4 + r3).get();
      r3 = r2 << 7;
      r3 = r1 + r3;
      r3 = r3 << 2;
      r0 = r0 + r3;
      r3 = MEMORY.ref(4, r5).get();
      r1 = MEMORY.ref(1, r0 + 0x1).getUnsigned();
      r3 = r3 << 18;
      r2 = 0x31;
      r3 = r3 >>> 30;
      r2 = -r2;
      r3 = r3 << 4;
      r2 = r2 & r1;
      r2 = r2 | r3;
      MEMORY.ref(1, r0 + 0x1).setu(r2);
      r3 = MEMORY.ref(1, r5 + 0x1).getUnsigned();
      r1 = 0x3f;
      r3 = r3 >>> 6;
      r3 = r3 << 6;
      r2 = r2 & r1;
      r2 = r2 | r3;
      MEMORY.ref(1, r0 + 0x1).setu(r2);
      r3 = MEMORY.ref(1, r5 + 0x2).getUnsigned();
      MEMORY.ref(1, r0 + 0x2).setu(r3);
      r3 = MEMORY.ref(1, r5 + 0x3).getUnsigned();
      MEMORY.ref(1, r0 + 0x3).setu(r3);
    }
  }

  @Method(0x2009074)
  public static int FUN_2009074(int r0, final int r1) {
    final int r2;
    int r3;
    int r4;
    int r5;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.sp().value -= 0x8;
    CPU.r11().value = r1;
    final Actor70 r6 = getMapActor(r0);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    Actor70 r9 = null;
    FUN_80091e0(r6, 0);
    r4 = getHeight(2, r6.pos_08.getX(), r6.pos_08.getZ());
    r3 = r4;
    if(r4 < 0x0) {
      r3 = r4 + 0xfffff;
    }

    //LAB_20090ac
    r5 = r3 >> 20;
    CPU.r10().value = r5;
    if(r5 < 0x0) {
      r5 = -r5;
    }

    //LAB_20090b6
    r5 = r5 + 0x1;
    r7 = 0x0;

    //LAB_20090c0
    do {
      r3 = getHeight(r6.layer_22.get(), r6.pos_08.getX(), r6.pos_08.getZ() + (r7 << 20));
      if(r3 < 0x0) {
        r3 = r3 + 0xfffff;
      }

      //LAB_20090de
      r0 = r3 >> 20;
      if(CPU.r10().value < r0) {
        r3 = r6.pos_08.getX() >> 20 << 20;
        r2 = r3 + 0x80000;
        if(CPU.r11().value == 0x0) {
          r7 = r7 + 0x2;
          r7 = (r7 + (r6.pos_08.getZ() >> 20) << 20) + 0x20000;
          r5 = r0 << 20;
          r3 = 0xdf;
        } else {
          //LAB_200910c
          r7 = r7 + 0x3;
          r7 = (r7 + (r6.pos_08.getZ() >> 20) << 20) - 0x20000;
          r5 = r0 << 20;
          r3 = 0xfd;
        }

        //LAB_200911e
        r9 = FUN_2008048(r2, r5, r7, r3);
        r4 = r6.pos_08.getZ() - r7 + r5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        break;
      }

      //LAB_2009136
      r7 = r7 + 0x1;
    } while((r7 & 0xffff_ffffL) <= (r5 & 0xffff_ffffL));

    //LAB_200913c
    FUN_2008da8(r6, r4);
    r6.pos_08.zero();
    if(r9 != null) {
      clearActor(r9);
    }

    //LAB_2009158
    r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    CPU.sp().value += 0x8;
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x2009174)
  public static void FUN_2009174(final int r0) {
    final Actor70 r5 = getMapActor(r0);
    r5._55.set(0);
    int r6 = 0;

    //LAB_2009188
    do {
      if((r6 & 0xffff_ffffL) > (0x1f & 0xffff_ffffL)) {
        return;
      }
      sleep(1);
      r5.pos_08.y_04.sub(0xcccc);
      r5._1c.sub(0x1999);
      r6++;
    } while(r5._1c.get() > 0x1998);

    r5._1c.set(0x1999);
  }

  @Method(0x2009268)
  public static int FUN_2009268() {
    final Actor70 r5 = getMapActor(0);
    final int r2 = r5._55.get();
    final int r7 = (r5.angle_06.get() & 0xffff) + 0x2000 & 0xc000;
    if(_2000432.get() == 0x0) {
      final Vec3 r6 = new Vec3();
      r6.setX((r5.pos_08.getX() & 0xfff00000) + 0x80000);
      r6.setY(r5.pos_08.getY());
      r6.setZ((r5.pos_08.getZ() & 0xfff00000) + 0x80000);
      retVec3(0x100000, r7, r6);

      if(FUN_80091d8(r5, r6) != 0x1 && FUN_2008350(r6) == null) {
        r6.x_00.set((r5.pos_08.getX() & 0xfff00000) + 0x80000);
        r6.setY(r5.pos_08.getY());
        r6.setZ((r5.pos_08.getZ() & 0xfff00000) + 0x80000);
        retVec3(0x200000, r7, r6);
        if(FUN_2008350(r6) == null && FUN_80091d8(r5, r6) == 0x0) {
          FUN_808a018();
          setActorAnimation(r5, 6);
          sleep(6);
          playSound(0x98);
          setActorAnimation(r5, 7);
          r5.velocityScalar_30.set(0x30000);
          r5.acceleration_34.set(0x20000);
          r5.velocity_24.setY(0x40000);
          r5._55.and(0x7e);
          FUN_80091e0(r5, 0);
          FUN_808a0c0(0, r6.x_00.get() >> 16, r6.z_08.get() >> 16);
          setActorAnimation(r5, 6);
          FUN_80091e0(r5, 1);
          r5._55.set(r2);
          FUN_808a020();
          return 1;
        }
      }
    }

    //LAB_2009396
    //LAB_2009398
    return 0;
  }

  @Method(0x2009440)
  public static int getRooms() {
    final int r2 = MEMORY.ref(2, 0x2000400).get();
    final int r0;
    if(r2 == 0x73) {
      r0 = 0x200aeac;
      //LAB_2009458
    } else if(r2 == 0x74) {
      r0 = 0x200aef4;
      //LAB_2009462
    } else if(r2 == 0x77) {
      r0 = 0x200af3c;
      //LAB_200946c
    } else if(r2 == 0x79) {
      r0 = 0x200af84;
      //LAB_2009476
    } else if(r2 == 0x7a) {
      r0 = 0x200afcc;
    } else {
      //LAB_2009480
      r0 = 0x200ae7c;
    }

    //LAB_2009482
    return r0;
  }

  @Method(0x20094b8)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  @Method(0x20094bc)
  public static int getTransitions() {
    final int r0;

    r0 = 0x200b014;
    return r0;
  }

  @Method(0x20094c4)
  public static int getActors() {
    final int r2 = MEMORY.ref(2, 0x2000400).get();
    final int r0;
    if(r2 == 0x73) {
      r0 = 0x200b06c;
      //LAB_20094dc
    } else if(r2 == 0x74) {
      r0 = 0x200b0e4;
      //LAB_20094e6
    } else if(r2 == 0x77) {
      r0 = 0x200b174;
      //LAB_20094f0
    } else if(r2 == 0x7a) {
      r0 = 0x200b2dc;
    } else {
      //LAB_20094fa
      r0 = 0x200b264;
    }

    //LAB_20094fc
    return r0;
  }

  /**
   * Event list 0x200b3a8 handler 2
   */
  @Method(0x2009528)
  public static void FUN_2009528() {
    FUN_808a018();

    if(FUN_2009268() == 0) {
      FUN_20083a8();
    }

    //LAB_200953a
    FUN_808a020();
  }

  /**
   * Event list 0x200b498 handler 2
   */
  @Method(0x2009544)
  public static void FUN_2009544() {
    CPU.sp().value -= 0x20;
    FUN_808a018();

    final int r5 = CPU.sp().value + 0x8;
    if(FUN_2008758(r5) != 0) {
      FUN_20088ec(MEMORY.ref(4, r5).get(), MEMORY.ref(4, r5 + 0x4).get(), MEMORY.ref(4, r5 + 0x8).get(), MEMORY.ref(4, r5 + 0xc).get(), MEMORY.ref(4, r5 + 0x10).get(), MEMORY.ref(4, r5 + 0x14).get());
    }

    //LAB_200956c
    FUN_808a020();
    CPU.sp().value += 0x20;
  }

  @Method(0x20095fc)
  public static void FUN_20095fc() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    r0 = 0x80;
    r0 = r0 << 2;
    CPU.sp().value -= 0xc;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      MEMORY.ref(4, CPU.sp().value).setu(r0);
      r6 = 0xa;
      r5 = 0x1f;
      r0 = 0xa;
      r1 = 0x13;
      r2 = 0x10;
      r3 = 0x5;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
      FUN_2008cc0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0xa;
      r1 = 0x33;
      r2 = 0x10;
      r3 = 0x5;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
      FUN_2008cc0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
      r3 = 0x2;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x2a;
      r1 = 0x33;
      r2 = 0x10;
      r3 = 0x5;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
      FUN_2008cc0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
    } else {
      //LAB_200964c
      r3 = 0x0;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r6 = 0xa;
      r5 = 0x1f;
      r0 = 0xa;
      r1 = 0x13;
      r2 = 0x10;
      r3 = 0x5;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
      FUN_2008cc0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0xa;
      r1 = 0x53;
      r2 = 0x10;
      r3 = 0x5;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
      FUN_2008cc0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
      r3 = 0x2;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x2a;
      r1 = 0x53;
      r2 = 0x10;
      r3 = 0x5;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
      FUN_2008cc0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
    }

    //LAB_200968c
    r5 = 0x200b738;
    MEMORY.ref(4, r5).setu(0);
    setTickCallback(getRunnable(Map121Overlay_87d0e88.class, "FUN_20095cc"), 0xc80);
    sleep(1);
    setInterruptHandler(1, 0, getRunnable(Map121Overlay_87d0e88.class, "FUN_2009578"));
    playSound(0xe7);
    MEMORY.ref(4, r5).setu(0);

    //LAB_20096b4
    do {
      sleep(1);
      MEMORY.ref(4, r5).incr();
    } while(MEMORY.ref(4, r5).get() <= 100);

    r0 = 0x121;
    playSound(r0);
    r0 = 0x80;
    r0 = r0 << 2;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r5 = 0x20;
      r0 = 0x0;
      r1 = 0x20;
      r2 = 0x20;
      r3 = 0x0;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x20;
      r1 = 0x20;
      r2 = 0x40;
      r3 = 0x0;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    } else {
      //LAB_20096fa
      r5 = 0x20;
      r0 = 0x0;
      r1 = 0x40;
      r2 = 0x20;
      r3 = 0x0;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x20;
      r1 = 0x40;
      r2 = 0x40;
      r3 = 0x0;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_200971c
    sleep(1);
    setInterruptHandler(1, 0, null);
    sleep(1);
    clearTickCallback(getRunnable(Map121Overlay_87d0e88.class, "FUN_20095cc"));
    FUN_8009128();
    sleep(30);
    CPU.sp().value += 0xc;
  }

  /**
   * Event list 0x200b498 handler 9
   */
  @Method(0x200975c)
  public static void FUN_200975c() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;

    CPU.sp().value -= 0x8;
    FUN_808a018();
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 9;
    r1 = r1 << 6;
    FUN_808a208(r0, r1);
    r1 = 0x1;
    r2 = 0xd8;
    r2 = r2 << 17;
    r3 = 0x1;
    r0 = 0x1190000;
    r1 = -r1;
    FUN_808a210(r0, r1, r2, r3);
    FUN_808a218();
    r0 = 0x1528;
    r1 = 0x1;
    FUN_8015040(r0, r1);
    r0 = 0x80;
    r0 = r0 << 2;
    r0 = readFlag(r0);
    r5 = r0;
    if(r5 == 0x0) {
      r0 = 0xe8;
      playSound(r0);
      r2 = 0x18;
      r1 = 0x54;
      r0 = 0x200ada8;
      FUN_8009178(r0, r1, r2);
      r0 = 0x1e;
      FUN_808a010(r0);
      r0 = 0xf0;
      playSound(r0);
      r1 = 0x1;
      r0 = 0x10;
      setActorPriority(r0, r1);
      getMapActor(16)._55.set(r5);
      r3 = 0xffe00000;
      r1 = 0x88;
      r2 = 0xd0;
      getMapActor(16).pos_08.setY(r3);
      r2 = r2 << 17;
      r0 = 0x10;
      r1 = r1 << 17;
      moveActorToPosition(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x200adfc;
      r1 = 0x50;
      r2 = 0x18;
      FUN_8009178(r0, r1, r2);
      r0 = 0x200ae50;
      r1 = 0x50;
      r2 = 0x1c;
      FUN_8009178(r0, r1, r2);
      r3 = 0x2;
      r2 = 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r1 = 0x28;
      r2 = 0x10;
      r3 = 0x1b;
      r0 = 0x41;
      FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      FUN_20095fc();
      r0 = 0x9;
      r0 = FUN_2008ec8(r0);
      r0 = 0xa;
      r0 = FUN_2008ec8(r0);
      r0 = 0xb;
      r0 = FUN_2008ec8(r0);
      r0 = 0xc;
      r0 = FUN_2008ec8(r0);
      r0 = 0xd;
      r0 = FUN_2008ec8(r0);
      r0 = 0xe;
      r0 = FUN_2008ec8(r0);
      r0 = 0xf;
      r0 = FUN_2008ec8(r0);
      r3 = 0x18;
      r2 = 0x8;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x18;
      r1 = 0x3;
      r2 = 0x1;
      r3 = 0x1;
      FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x80;
      r0 = r0 << 2;
      setFlag(r0);
    } else {
      //LAB_200985c
      r0 = 0xe8;
      playSound(r0);
      r1 = 0x54;
      r2 = 0x18;
      r0 = 0x200add2;
      FUN_8009178(r0, r1, r2);
      r0 = 0x1e;
      FUN_808a010(r0);
      r0 = 0xe6;
      playSound(r0);
      r3 = 0x0;
      getMapActor(16)._55.set(r3);
      r3 = 0xffe00000;
      r1 = 0x88;
      r2 = 0xda;
      getMapActor(16).pos_08.setY(r3);
      r2 = r2 << 17;
      r0 = 0x10;
      r1 = r1 << 17;
      moveActorToPosition(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x2;
      setActorAnimationIfLoaded(r0, r1);
      r3 = 0x2;
      r2 = 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r3 = 0x1b;
      r0 = 0x41;
      r1 = 0x2d;
      r2 = 0x10;
      FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r1 = 0x50;
      r2 = 0x18;
      r0 = 0x200ae26;
      FUN_8009178(r0, r1, r2);
      FUN_20095fc();
      r0 = 0x9;
      r0 = FUN_2008f58(r0);
      r0 = 0xa;
      r0 = FUN_2008f58(r0);
      r0 = 0xb;
      r0 = FUN_2008f58(r0);
      r0 = 0xc;
      r0 = FUN_2008f58(r0);
      r0 = 0xd;
      r0 = FUN_2008f58(r0);
      r0 = 0xe;
      r0 = FUN_2008f58(r0);
      r0 = 0xf;
      r0 = FUN_2008f58(r0);
      r3 = 0x18;
      r2 = 0x8;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x18;
      r1 = 0x4;
      r2 = 0x1;
      r3 = 0x1;
      FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x80;
      r0 = r0 << 2;
      clearFlag(r0);
    }

    //LAB_200990c
    FUN_808a020();
    CPU.sp().value += 0x8;
  }

  @Method(0x2009938)
  public static int FUN_2009938(final Actor70 r0, final Actor70 r1) {
    int r0_0 = 0x0;
    if(r1.pos_08.getX() != r0.pos_08.getX() || r1.pos_08.getY() != r0.pos_08.getY() || r1.pos_08.getZ() != r0.pos_08.getZ()) {
      //LAB_2009958
      if(r0.pos_08.getX() > r1.pos_08.getX() - 0x100000 && r0.pos_08.getX() < r1.pos_08.getX() + 0x100000) {
        if(r1.pos_08.getY() / 0x10000 == r0.pos_08.getY() / 0x10000) {
          if(r0.pos_08.getZ() > r1.pos_08.getZ() - 0x200000 && r0.pos_08.getZ() < r1.pos_08.getZ()) {
            final int r3 = r1.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() >>> 8 << 28 >>> 30;
            if(r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() >>> 8 << 28 >>> 30 < r3) {
              r0.flags_23.and(~0x1);
              r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r3 << 10);
              r0.sprite_50.deref().shadowPacket_0c.attribs_04.attrib2_04.and(~0xc00).or(r1.sprite_50.deref().shadowPacket_0c.attribs_04.attrib2_04.get() & 0xc00);
            }

            //LAB_20099dc
            r0_0 = 0x1;
          }
        }
      }
    }

    //LAB_20099de
    return r0_0;
  }

  @Method(0x20099f0)
  public static int FUN_20099f0(final Actor70 r0, final Actor70 r1) {
    int r0_0 = 0x0;
    if(r1.pos_08.getX() != r0.pos_08.getX() || r1.pos_08.getY() != r0.pos_08.getY() || r1.pos_08.getZ() != r0.pos_08.getZ()) {
      //LAB_2009a10
      if(r1.pos_08.getX() > r0.pos_08.getX() - 0x100000 && r1.pos_08.getX() < r0.pos_08.getX() + 0x100000) {
        if(r1.pos_08.getY() / 0x10000 == r0.pos_08.getY() / 0x10000) {
          if(r1.pos_08.getZ() > r0.pos_08.getZ() - 0x200000 && r1.pos_08.getZ() < r0.pos_08.getZ()) {
            final int r2 = r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() >>> 8 << 28 >>> 30;
            if(r2 > r1.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() >>> 8 << 28 >>> 30) {
              r1.flags_23.and(~0x1);
              r1.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r2 << 10);
              r1.sprite_50.deref().shadowPacket_0c.attribs_04.attrib2_04.and(~0xc00).or(r0.sprite_50.deref().shadowPacket_0c.attribs_04.attrib2_04.get() & 0xc00);
            }

            //LAB_2009a94
            r0_0 = 0x1;
          }
        }
      }
    }

    //LAB_2009a96
    return r0_0;
  }

  @Method(0x2009aa8)
  public static int FUN_2009aa8(final Actor70 r0) {
    int r5;
    int r7;

    final Actor70 r8 = getMapActor(0);
    if(MEMORY.ref(1, 0x3002b83).get() == 0x1) {
      r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r8.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
      r0._59.or(0x1);
    } else {
      //LAB_2009aee
      r7 = FUN_2009938(r0, r8);
      r5 = 0x8;

      //LAB_2009afa
      do {
        r7 += FUN_2009938(r0, getMapActor(r5));
        r5++;
      } while(r5 < 12);

      if(r7 != 0x0) {
        r5 = 0x8;

        //LAB_2009b16
        do {
          FUN_20099f0(r0, getMapActor(r5));
          r5++;
        } while(r5 < 12);
      }

      //LAB_2009b2a
      if(r0.pos_08.getY() < r8.pos_08.getY()) {
        r0.flags_23.or(0x2);
        r0._59.and(~0x1);

        if(r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() >>> 8 << 28 >>> 30 < r8.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() >>> 8 << 28 >>> 30) {
          r0.flags_23.and(~0x1);
          r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r8.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
          r0.sprite_50.deref().shadowPacket_0c.attribs_04.attrib2_04.and(~0xc00).or(r8.sprite_50.deref().shadowPacket_0c.attribs_04.attrib2_04.get() & 0xc00);
          r7 = 0x1;
        }
      } else {
        //LAB_2009ba6
        r0.flags_23.and(~0x2);
        r0._59.or(0x1);
      }

      //LAB_2009bc2
      if(r7 == 0x0) {
        r0.flags_23.or(0x1);
      }
    }

    //LAB_2009bd2
    return 0;
  }

  @Method(0x2009be8)
  public static void FUN_2009be8() {
    CPU.sp().value -= 0x84;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    MEMORY.ref(4, CPU.sp().value).setu(0);
    int r11 = 0;
    int r9 = 0x10;

    //LAB_2009c04
    do {
      final Actor70 r10 = getMapActor(r11 + 0x8);
      int r8 = r11;
      if((r11 & 0xffff_ffffL) < 4) {
        //LAB_2009c18
        int r6 = MEMORY.ref(4, CPU.sp().value).get() + 0x10;
        int r7 = 0x200b6d0 + MEMORY.ref(4, CPU.sp().value).get();

        //LAB_2009c22
        do {
          final Actor70 r4 = getMapActor(r8 + 0x8);
          if(r10.pos_08.getY() > r4.pos_08.getY() || r10.pos_08.getZ() >= r4.pos_08.getZ()) {
            //LAB_2009c42
            DMA.channels[3].SAD.setu(r4.getAddress());
            DMA.channels[3].DAD.setu(CPU.sp().value + 0x14);
            DMA.channels[3].CNT.setu(0x8400001c);

            //LAB_2009c54
            while((DMA.channels[3].CNT.get() & 0x80000000) != 0x0) {
              DebugHelper.sleep(0);
            }

            DMA.channels[3].SAD.setu(r10.getAddress());
            DMA.channels[3].DAD.setu(r4.getAddress());
            DMA.channels[3].CNT.setu(0x8400001c);

            //LAB_2009c6e
            while((DMA.channels[3].CNT.get() & 0x80000000) != 0x0) {
              DebugHelper.sleep(0);
            }

            DMA.channels[3].SAD.setu(CPU.sp().value + 0x14);
            DMA.channels[3].DAD.setu(r10.getAddress());
            DMA.channels[3].CNT.setu(0x8400001c);

            //LAB_2009c88
            while((DMA.channels[3].CNT.get() & 0x80000000) != 0x0) {
              DebugHelper.sleep(0);
            }

            DMA.channels[3].SAD.setu(r7);
            DMA.channels[3].DAD.setu(CPU.sp().value + 0x8);
            DMA.channels[3].CNT.setu(0x84000004);

            //LAB_2009ca2
            while((DMA.channels[3].CNT.get() & 0x80000000) != 0x0) {
              DebugHelper.sleep(0);
            }

            DMA.channels[3].SAD.setu(0x200b6d0 + MEMORY.ref(4, CPU.sp().value + 0x4).get());
            DMA.channels[3].DAD.setu(r7);
            DMA.channels[3].CNT.setu(0x84000004);

            //LAB_2009cc0
            while((DMA.channels[3].CNT.get() & 0x80000000) != 0x0) {
              DebugHelper.sleep(0);
            }

            DMA.channels[3].SAD.setu(CPU.sp().value + 0x8);
            DMA.channels[3].DAD.setu(0x200b6d0 + MEMORY.ref(4, CPU.sp().value + 0x4).get());
            DMA.channels[3].CNT.setu(0x84000004);

            //LAB_2009cde
            while((DMA.channels[3].CNT.get() & 0x80000000) != 0x0) {
              DebugHelper.sleep(0);
            }

            final int r5 = 0x200b6d0;
            if(readFlag(MEMORY.ref(4, r5 + r9).get()) != 0 && readFlag(MEMORY.ref(4, r5 + r6).get()) == 0) {
              clearFlag(MEMORY.ref(4, r5 + r9).get());
              setFlag(MEMORY.ref(4, r5 + r6).get());
            } else {
              //LAB_2009d0e
              if(readFlag(MEMORY.ref(4, r5 + r9).get()) == 0x0) {
                if(readFlag(MEMORY.ref(4, r5 + r6).get()) != 0x0) {
                  setFlag(MEMORY.ref(4, r5 + r9).get());
                  clearFlag(MEMORY.ref(4, r5 + r6).get());
                }
              }
            }
          }

          //LAB_2009d34
          r6 += 0x14;
          r7 += 0x14;
          r8++;
        } while((r8 & 0xffff_ffffL) < 4);
      }

      //LAB_2009d44
      r9 += 0x14;
      MEMORY.ref(4, CPU.sp().value + 0x4).addu(0x14);
      MEMORY.ref(4, CPU.sp().value).addu(0x14);
      r11++;
    } while((r11 & 0xffff_ffffL) < 3);

    //LAB_2009d60
    CPU.sp().value += 0x84;
  }

  /**
   * Event list 0x200b51c handler 19
   */
  @Method(0x2009d84)
  public static void FUN_2009d84(final int a0, final int a1) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x14;
    CPU.r8().value = 0x200b6d0;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(0x8);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0x8);
    CPU.r9().value = CPU.sp().value + 0x10;
    CPU.r10().value = 0;
    CPU.r11().value = CPU.r8().value;

    //LAB_2009daa
    do {
      final Actor70 r6 = getMapActor(MEMORY.ref(4, CPU.sp().value + 0xc).get());
      r6.layer_22.set(2);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(MEMORY.ref(4, CPU.sp().value + 0xc).get() - 0x8);
      if(r6.pos_08.getX() >> 20 != MEMORY.ref(4, CPU.r10().value + CPU.r8().value).get() || r6.pos_08.getZ() >> 20 != MEMORY.ref(4, MEMORY.ref(4, CPU.sp().value + 0x4).get() + CPU.r8().value).get() || r6.velocity_24.getY() != 0x0) {
        //LAB_2009de2
        DMA.channels[3].SAD.setu(r6.pos_08.getAddress());
        DMA.channels[3].DAD.setu(0x200b720);
        DMA.channels[3].CNT.setu(0x84000003);

        //LAB_2009df6
        while((DMA.channels[3].CNT.get() & 0x80000000) != 0x0) {
          DebugHelper.sleep(0);
        }

        //LAB_2009e18
        if(FUN_80091d8(r6, _200b720) == -1) {
          r6._55.set(0x3);
        }

        //LAB_2009e1c
        r5 = CPU.r8().value;
        r1 = MEMORY.ref(4, CPU.r10().value + CPU.r8().value).get();
        r5 = r5 + 0xc;
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r5 = r5 + CPU.r10().value;
        r2 = MEMORY.ref(4, r3 + CPU.r8().value).get();
        FUN_200901c(0, r1, r2, r5);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        FUN_200901c(2, MEMORY.ref(4, CPU.r11().value).get(), MEMORY.ref(4, r3 + CPU.r8().value).get(), r5);

        if((r6._55.get() & 0x1) != 0x0) {
          if(getTileType(2, r6.pos_08.getX(), r6.pos_08.getZ()) == 0x32) {
            playSound(0xbd);
            r6.flags_23.and(~0x1);
            FUN_2009074(MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x1);
            r6.flags_23.or(0x1);
            //LAB_2009e82
          } else if(getTileType(2, r6.pos_08.getX(), r6.pos_08.getZ()) == 0x33) {
            FUN_2008da8(r6, 0);
            playSound(0xbd);
            r6.pos_08.setY(0);
            r6.flags_23.and(~0x1);
            FUN_2009174(MEMORY.ref(4, CPU.sp().value + 0xc).get());
            r6.pos_08.zero();
            r6.flags_23.or(0x1);
          } else {
            //LAB_2009ec6
            FUN_2008d78(r6);
          }

          //LAB_2009ecc
          r6._55.set(0);
        }

        //LAB_2009ed0
        FUN_2008fcc(0, r6.pos_08.getX() >> 20, r6.pos_08.getZ() >> 20, 0x200b6dc + CPU.r10().value);
        r2 = r6.pos_08.getY();
        if(r2 >= 0x0) {
          r2 = r2 >> 20;
          r2 = r2 + 0x6;
          FUN_2008fcc(0, 0x1b, r2, CPU.r9().value);
          FUN_200901c(0, r6.pos_08.getX() >> 20, r6.pos_08.getZ() >> 20, CPU.r9().value);
          r2 = MEMORY.ref(1, CPU.r11().value + 0xd).getUnsigned();
          r1 = MEMORY.ref(1, CPU.r9().value + 0x1).getUnsigned();
          r2 = r2 >>> 6;
          r2 = r2 << 6;
          r3 = r1 & 0x3f | r2;
          MEMORY.ref(1, CPU.r9().value + 0x1).setu(r3);
          FUN_200901c(2, r6.pos_08.getX() >> 20, r6.pos_08.getZ() >> 20, CPU.r9().value);
        }

        //LAB_2009f2a
        r1 = CPU.r8().value;
        r2 = CPU.r10().value;
        MEMORY.ref(4, r1 + r2).setu(r6.pos_08.getX() >> 20);
        r2 = r2 + 0x4;
        MEMORY.ref(4, r1 + r2).setu(r6.pos_08.getY() >> 20);
        r2 = r2 + 0x4;
        MEMORY.ref(4, r1 + r2).setu(r6.pos_08.getZ() >> 20);
        r5 = 0x0;
        r7 = 0x10;

        //LAB_2009f48
        do {
          if(r5 != MEMORY.ref(4, CPU.sp().value + 0x8).get()) {
            clearFlag(MEMORY.ref(4, 0x200b6d0 + r7).get());
            final Actor70 r0 = getMapActor(r5 + 0x8);
            if(r6.pos_08.getX() >> 20 == r0.pos_08.getX() >> 20) {
              if(r6.pos_08.getZ() >> 20 == r0.pos_08.getZ() >> 20) {
                if(r6.pos_08.getY() > r0.pos_08.getY()) {
                  setFlag(MEMORY.ref(4, 0x200b6d0 + r7).get());
                }
              }
            }
          }

          //LAB_2009f88
          r7 += 0x14;
          r5++;
        } while((r5 & 0xffff_ffffL) < 4);
      }

      //LAB_2009f90
      CPU.r10().value += 0x14;
      CPU.r11().value += 0x14;
      MEMORY.ref(4, CPU.sp().value + 0x4).addu(0x14);
      MEMORY.ref(4, CPU.sp().value + 0xc).incr();
    } while((MEMORY.ref(4, CPU.sp().value + 0xc).get() & 0xffff_ffffL) <= (0xb & 0xffff_ffffL));

    //LAB_2009fa8
    FUN_2009be8();
    CPU.sp().value += 0x14;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  /**
   * Event list 0x200b51c handler 5
   */
  @Method(0x2009fd4)
  public static void FUN_2009fd4(final int a0) {
    FUN_808a018();

    if(FUN_2009268() == 0) {
      getMapActor(0)._55.and(~0x1);
      getMapActor(0).flags_23.and(~0x1);
      FUN_20083a8();
      FUN_2009d84(0, 0);
      getMapActor(0)._55.or(0x1);
      getMapActor(0).flags_23.or(0x1);
    }

    //LAB_200a028
    FUN_808a020();
  }

  /**
   * Event list 0x200b51c handler 3
   */
  @Method(0x200a034)
  public static void FUN_200a034(final int a0) {
    final int r0;

    r0 = FUN_808a2b0();
  }

  /**
   * Event list 0x200b51c handler 4
   */
  @Method(0x200a040)
  public static void FUN_200a040(final int a0) {
    CPU.sp().value -= 0xc;
    final Actor70 r1 = getMapActor(0);
    final Vec3 r0 = new Vec3();
    r0.setX(r1.pos_08.getX());
    r0.setY(r1.pos_08.getY());
    r0.setZ(r1.pos_08.getZ() + 0x100000);

    if(FUN_2008350(r0) != null) {
      FUN_2009fd4(0);
      //LAB_200a06e
    } else if(FUN_2009268() == 0x0) {
      FUN_808a2a8();
    }

    //LAB_200a07a
    CPU.sp().value += 0xc;
  }

  /**
   * Event list 0x200b51c handler 6
   */
  @Method(0x200a080)
  public static void FUN_200a080(final int a0) {
    final Actor70 r0 = getMapActor(0);
    final int r3 = boardWramMallocHead_3001e50.offset(36 * 0x4).get();
    MEMORY.ref(4, r3 + 0x18).setu(r0.getAddress());
    r0._62.set(1);
  }

  /**
   * Event list 0x200b51c handler 7
   */
  @Method(0x200a09c)
  public static void FUN_200a09c(final int a0) {
    final int r3 = boardWramMallocHead_3001e50.offset(36 * 0x4).get();
    MEMORY.ref(4, r3 + 0x18).setu(0);
    getMapActor(0)._62.set(0);
  }

  @Method(0x200a0f0)
  public static void FUN_200a0f0(int r0) {
    int r1;
    int r2;
    int r3;
    final int r6;

    CPU.sp().value -= 0x8;
    r6 = r0;
    final Actor70 r5 = getMapActor(r6);
    FUN_808a018();
    r5._6c.set(getConsumer(Map121Overlay_87d0e88.class, "FUN_200a0b8", Actor70.class));
    r2 = r5.pos_08.getX() >> 20;
    r3 = r5.pos_08.getZ() >> 20;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r2 = 0x1;
    r1 = 0xe;
    r0 = 0x14;
    r3 = 0x1;
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x1f5;
    r0 = r6 + r3;
    setFlag(r0);
    r1 = 0x200ad64;
    r0 = r6;
    FUN_808a098(r0, r1);
    FUN_808a020();
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200b618 handler 9
   */
  @Method(0x200a144)
  public static void FUN_200a144() {
    final int r0;

    r0 = 0xb;
    FUN_200a0f0(r0);
  }

  /**
   * Event list 0x200b618 handler 10
   */
  @Method(0x200a150)
  public static void FUN_200a150() {
    final int r0;

    r0 = 0xc;
    FUN_200a0f0(r0);
  }

  /**
   * Event list 0x200b618 handler 11
   */
  @Method(0x200a15c)
  public static void FUN_200a15c() {
    final Actor70 r5 = getMapActor(0);
    final Actor70 r0 = getMapActor(13);
    final FieldPsynergy720 r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    if(r0.pos_08.getX() >> 20 != r5.pos_08.getX() >> 20) {
      clearFlag(0x203);
    } else if(r0.pos_08.getZ() >> 20 != r5.pos_08.getZ() >> 20) {
      //LAB_200a198
      clearFlag(0x203);
    } else {
      setFlag(0x203);
      r6._35.set(0x1);
    }
  }

  /**
   * Event list 0x200b618 handler 12
   */
  @Method(0x200a1ac)
  public static void FUN_200a1ac() {
    getMapActor(13).scale_18.set(0x10000);
    getMapActor(13)._1c.set(0x10000);
    getMapActor(13).sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
    final Actor70 r6 = getMapActor(14);
    final Sprite38 r1 = r6.sprite_50.deref();
    r1.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
    r6.velocityScalar_30.set(0xcccc);
    r6.acceleration_34.set(0x6666);
    FUN_8009150(r6, r6.pos_08.getX(), 0x200000, r6.pos_08.getZ());
    FUN_808a0e8(14);
    FUN_80091c0(20, 14, 1, 1, 0x16, 0x10);
  }

  /**
   * Event list 0x200b618 handler 13
   */
  @Method(0x200a384)
  public static void FUN_200a384() {
    if(readFlag(0x203) == 0) {
      setFlag(0x202);
      FUN_808a018();
      FUN_808a208(0x9999, 0x1333);
      FUN_808a210(0x1380000, -1, 0xb80000, 1);
      FUN_808a218();
      FUN_808a010(20);
      FUN_8009180(73, 10, 60, 10, 1, 2);
      FUN_808a010(20);
      setTickCallback(getRunnable(Map121Overlay_87d0e88.class, "FUN_200a230"), 0xc80);
      FUN_808a010(40);
      if(readFlag(0x201) != 0x0) {
        getMapActor(12)._6c.set(getConsumer(Map121Overlay_87d0e88.class, "FUN_200a2d8", Actor70.class));
        setActorAnimationIfLoaded(12, 6);
        waitForActorAnimationToChange(12);
        getMapActor(12)._6c.clear();
        FUN_80091c0(17, 13, 1, 1, 0x12, 0xd);
        clearFlag(0x201);
        FUN_808a158(12, 0);
        FUN_808a098(12, 1);
      } else {
        //LAB_200a442
        FUN_808a010(60);
      }

      //LAB_200a448
      clearTickCallback(getRunnable(Map121Overlay_87d0e88.class, "FUN_200a230"));
      FUN_808a010(20);
      FUN_8009180(0x48, 0xa, 0x3c, 0xa, 1, 2);
      FUN_808a010(20);
      FUN_808a020();
    }

    //LAB_200a472
  }

  /**
   * Event list 0x200b618 handler 7
   */
  @Method(0x200a498)
  public static void FUN_200a498() {
    final Actor70 r5 = getMapActor(10);
    FUN_808a018();
    setMapTileTypes(2, r5.pos_08.getX() >> 20, r5.pos_08.getZ() >> 20, 1, 1, 0);
    FUN_808a020();
  }

  /**
   * Event list 0x200b618 handler 8
   */
  @Method(0x200a4cc)
  public static void FUN_200a4cc() {
    final Actor70 r5 = getMapActor(10);
    FUN_808a018();
    setMapTileTypes(2, r5.pos_08.getX() >> 20, r5.pos_08.getZ() >> 20, 1, 0x1, 0xff);
    if(r5.pos_08.getX() >> 20 == 0x10) {
      if(readFlag(0x204) == 0) {
        FUN_808a010(10);
        playSound(0x9f);
        r5._55.set(0);
        r5._14.set(-0x20000);
        r5.pos_08.setY(-0x20000);
        setFlag(0x204);
      }
    }

    //LAB_200a52a
    FUN_808a020();
  }

  /**
   * Event list 0x200b618 handler 2
   */
  @Method(0x200a53c)
  public static void FUN_200a53c() {
    CPU.sp().value -= 0x20;
    FUN_808a018();
    final int r5 = CPU.sp().value + 0x8;
    if(FUN_2008758(r5) != 0) {
      FUN_20088ec(MEMORY.ref(4, r5).get(), MEMORY.ref(4, r5 + 0x4).get(), MEMORY.ref(4, r5 + 0x8).get(), MEMORY.ref(4, r5 + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x18).get(), MEMORY.ref(4, CPU.sp().value + 0x1c).get());
    } else {
      //LAB_200a566
      FUN_200a498();
      FUN_20083a8();
      FUN_200a4cc();
    }

    //LAB_200a572
    FUN_808a020();
    CPU.sp().value += 0x20;
  }

  @Method(0x200a580)
  public static int getEvents() {
    final int r2 = GoldenSunVars.mapId_2000400.get();
    final int r0;
    if(r2 == 0x73) {
      r0 = 0x200b3a8;
      //LAB_200a598
    } else if(r2 == 0x74) {
      r0 = 0x200b438;
      //LAB_200a5a2
    } else if(r2 == 0x77) {
      r0 = 0x200b498;
      //LAB_200a5ac
    } else if(r2 == 0x79) {
      r0 = 0x200b51c;
      //LAB_200a5b6
    } else if(r2 == 0x7a) {
      r0 = 0x200b618;
    } else {
      //LAB_200a5c0
      r0 = 0x200b39c;
    }

    return r0;
  }

  @Method(0x200a5f8)
  public static void FUN_200a5f8(final int r0) {
    final Actor70 r5 = getMapActor(r0);
    r5.flags_23.or(0x2);
    r5._59.and(0xfe);
    r5._55.set(0);
    FUN_80091e0(r5, 0);
    r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
  }

  @Method(0x200a63c)
  public static void FUN_200a63c(final int r0) {
    final Actor70 r5 = getMapActor(r0);
    if(readFlag(r0 + 0x1f5) != 0x0) {
      setActorAnimation(r5, 5);
      r5._6c.set(getConsumer(Map121Overlay_87d0e88.class, "FUN_200a0b8", Actor70.class));
      FUN_80091c0(20, 14, 1, 1, r5.pos_08.getX() >> 20, r5.pos_08.getZ() >> 20);
      FUN_808a098(r0, 0x200ad64);
    }

    //LAB_200a680
  }

  @Method(0x200a694)
  public static void FUN_200a694(final int mapActorIndex) {
    final Actor70 actor = getMapActor(mapActorIndex);
    actor.layer_22.set(2);
    actor._55.set(0);
    actor._6c.set(getConsumer(Map121Overlay_87d0e88.class, "FUN_2009aa8", Actor70.class));
  }

  @Method(0x200a6b8)
  public static void FUN_200a6b8() {
    final Actor70 r5 = getMapActor(0);
    int r6 = 8;

    //LAB_200a6c4
    do {
      final Actor70 r0 = getMapActor(r6);
      if(r5.pos_08.getY() / 0x10000 != r0.pos_08.getY() / 0x10000 || r5.pos_08.getZ() > r0.pos_08.getZ() - 0x80000 || r5.pos_08.getZ() <= r0.pos_08.getZ() - 0x180000) {
        //LAB_200a720
        getMapActor(0).flags_23.or(0x1);
      } else if(r0.pos_08.getX() >= r5.pos_08.getX() - 0x100000 && r0.pos_08.getX() < r5.pos_08.getX() + 0x100000) {
        setActorPriority(0, r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() >>> 8 << 28 >>> 30);
        break;
      }

      //LAB_200a730
      r6++;
    } while(r6 < 12);
  }

  @Method(0x200a74c)
  public static int init() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;

    r3 = 0x3001ebc;
    r2 = 0xe0;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0x81;
    r3 = r3 << 2;
    r2 = r2 << 1;
    MEMORY.ref(4, r1 + r2).setu(r3);
    r1 = 0x2000240;
    r2 = MEMORY.ref(2, r1 + r2).get();
    r3 = 0x74;
    CPU.sp().value -= 0x8;
    CPU.cmpT(r2, r3);
    if(r2 == r3) {
      r0 = 0x8;
      r0 = FUN_2008ba4(r0);
      r0 = 0x9;
      r0 = FUN_2008ba4(r0);
      r0 = 0xa;
      r0 = FUN_2008ba4(r0);
      r0 = 0xb;
      r0 = FUN_2008ba4(r0);
      r0 = 0xc;
      r0 = FUN_2008ba4(r0);
    } else {
      //LAB_200a788
      r3 = 0x77;
      CPU.cmpT(r2, r3);
      if(r2 == r3) {
        r3 = 0x0;
        r2 = 0x40;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r1 = 0x0;
        r3 = 0x20;
        r0 = 0x20;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        FUN_80091b8(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x8;
        r0 = FUN_2008ba4(r0);
        r0 = 0x9;
        r0 = FUN_2008ba4(r0);
        r0 = 0xa;
        r0 = FUN_2008ba4(r0);
        r0 = 0xb;
        r0 = FUN_2008ba4(r0);
        r0 = 0xc;
        r0 = FUN_2008ba4(r0);
        r0 = 0xd;
        r0 = FUN_2008ba4(r0);
        r0 = 0xe;
        r0 = FUN_2008ba4(r0);
        r0 = 0xf;
        r0 = FUN_2008ba4(r0);
        r0 = 0x109;
        r0 = readFlag(r0);
        CPU.cmpT(r0, 0x0);
        if(r0 != 0x0) {
          //LAB_200a7dc
          r0 = 0x80;
          r0 = r0 << 2;
          r0 = readFlag(r0);
          CPU.cmpT(r0, 0x0);
          if(r0 != 0x0) {
            //LAB_200a7ea
            r3 = 0x1;
            r2 = 0x2;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
            r0 = 0x4f;
            r1 = 0x22;
            r2 = 0x54;
            r3 = 0x18;
            FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r5 = 0x20;
            r0 = 0x0;
            r1 = 0x20;
            r2 = 0x20;
            r3 = 0x0;
            MEMORY.ref(4, CPU.sp().value).setu(r5);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r1 = 0x20;
            r2 = 0x40;
            r3 = 0x0;
            r0 = 0x20;
            MEMORY.ref(4, CPU.sp().value).setu(r5);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r0 = 0x9;
            r0 = FUN_2008ec8(r0);
            r0 = 0xa;
            r0 = FUN_2008ec8(r0);
            r0 = 0xb;
            r0 = FUN_2008ec8(r0);
            r0 = 0xc;
            r0 = FUN_2008ec8(r0);
            r0 = 0xd;
            r0 = FUN_2008ec8(r0);
            r0 = 0xe;
            r0 = FUN_2008ec8(r0);
            r0 = 0xf;
            r0 = FUN_2008ec8(r0);
            r3 = 0x18;
            r2 = 0x8;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
            r0 = 0x18;
            r1 = 0x3;
            r2 = 0x1;
            r3 = 0x1;
            FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }
        }
      } else {
        //LAB_200a858
        r3 = 0x79;
        CPU.cmpT(r2, r3);
        if(r2 == r3) {
          r0 = 0x92;
          r2 = 0xc8;
          r0 = r0 << 18;
          r2 = r2 << 16;
          r1 = 0x0;
          r3 = 0xdf;
          FUN_20080a0(r0, r1, r2, r3);
          r0 = 0x109;
          r0 = readFlag(r0);
          CPU.cmpT(r0, 0x0);
          if(r0 == 0x0) {
            getMapActor(0)._62.set(1);
          }

          //LAB_200a884
          FUN_808a408(null);
          if(getMapActor(0)._62.get() == 0x0) {
            FUN_200a09c(0);
          }

          //LAB_200a89c
          FUN_200a694(8);
          FUN_200a694(9);
          FUN_200a694(10);
          FUN_200a694(11);
          r4 = 0x80;
          r2 = 0x200b6d0;
          r1 = 0x0;
          r0 = 0x0;
          r4 = r4 << 2;

          //LAB_200a8be
          do {
            r3 = r1 + r4;
            r1 = r1 + 0x1;
            MEMORY.ref(4, r2).setu(r0);
            MEMORY.ref(4, r2 + 0x4).setu(r0);
            MEMORY.ref(4, r2 + 0x8).setu(r0);
            MEMORY.ref(4, r2 + 0x10).setu(r3);
            r2 = r2 + 0x14;
            CPU.cmpT(r1, 0x3);
          } while((r1 & 0xffff_ffffL) <= (0x3 & 0xffff_ffffL));

          FUN_2009d84(0, 0);
          r0 = 0x1;
          FUN_808a010(r0);
          setTickCallback(getRunnable(Map121Overlay_87d0e88.class, "FUN_200a6b8"), 0xc80);

          if(readFlag(0x109) != 0x0) {
            //LAB_200a8f0
            for(r5 = 8; r5 < 12; r5++) {
              final Actor70 actor = getMapActor(r5);
              if(actor.pos_08.getX() >> 20 == 0x25 && actor.pos_08.getZ() >> 20 == 0x9) {
                FUN_80091c0(27, 8, 1, 1, 37, 9);
                break;
              }

              //LAB_200a8f4
              r5++;
            }
          }
        } else {
          //LAB_200a922
          r2 = 0xe0;
          r2 = r2 << 1;
          r3 = r1 + r2;
          r1 = 0x0;
          r2 = MEMORY.ref(2, r3 + r1).get();
          r3 = 0x7a;
          CPU.cmpT(r2, r3);
          if(r2 == r3) {
            r0 = 0xa;
            r1 = 0x2;
            setActorAnimationIfLoaded(r0, r1);
            r1 = 0x6;
            r0 = 0xa;
            FUN_808a158(r0, r1);
            r0 = 0x8;
            r0 = FUN_2008ba4(r0);
            r0 = 0x9;
            r0 = FUN_2008ba4(r0);
            r5 = 0x0;
            getMapActor(8)._55.set(r5);
            getMapActor(9)._55.set(r5);
            FUN_200a4cc();
            r0 = 0xb;
            FUN_200a5f8(r0);
            r0 = 0xc;
            FUN_200a5f8(r0);
            r0 = 0xd;
            FUN_200a5f8(r0);
            r0 = 0xb;
            FUN_200a63c(r0);
            r0 = 0xc;
            FUN_200a63c(r0);
            r0 = 0xd;
            FUN_200a63c(r0);
            getMapActor(13)._6c.clear();
            r0 = 0xe;
            FUN_200a5f8(r0);
            getMapActor(14)._59.or(0x8);
            r0 = 0x202;
            r0 = readFlag(r0);
            CPU.cmpT(r0, 0x0);
            if(r0 == 0x0) {
              getMapActor(13).scale_18.set(0x18000);
              getMapActor(13)._1c.set(0x18000);
              getMapActor(13).sprite_50.deref().packet_00.attribs_04.attrib2_04.or(0xc00);
              getMapActor(14).sprite_50.deref().packet_00.attribs_04.attrib2_04.or(0xc00);
              r3 = 0x16;
              r2 = 0x10;
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
              r0 = 0x1a;
              r1 = 0xc;
              r2 = 0x1;
              r3 = 0x1;
              FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }
          }
        }
      }
    }

    //LAB_200a9fa
    r0 = 0x0;
    CPU.sp().value += 0x8;
    return r0;
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200aa34)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200aa3c)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200aa44)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#retVec3} */
  @Method(0x200aa54)
  public static void retVec3(final int distance, final int angle, final Vec3 vec) {
    MEMORY.call(0x8000128, distance, angle, vec);
  }

  /** {@link GoldenSun#setInterruptHandler_} */
  @Method(0x200aa5c)
  public static void setInterruptHandler(final int interruptType, final int vcountSetting, final RunnableRef callback) {
    MEMORY.call(0x8000130, interruptType, vcountSetting, callback);
  }

  /** {@link GoldenSun#setActorAnimation_} */
  @Method(0x200aa64)
  public static void setActorAnimation(final Actor70 actor, final int animationIndex) {
    MEMORY.call(0x8009080, actor, animationIndex);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200aa74)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#clearActor_} */
  @Method(0x200aa7c)
  public static void clearActor(final Actor70 r0) {
    MEMORY.call(0x80090d0, r0);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200aa84)
  public static void FUN_8009128() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009150} */
  @Method(0x200aa8c)
  public static void FUN_8009150(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x8009150, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009158} */
  @Method(0x200aa94)
  public static void FUN_8009158(final Actor70 r0) {
    MEMORY.call(0x8009158, r0);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x200aa9c)
  public static void FUN_8009178(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200aaa4)
  public static void FUN_8009180(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#getHeight_} */
  @Method(0x200aaac)
  public static int getHeight(final int mapLayer, final int x, final int z) {
    return (int)MEMORY.call(0x80091a8, mapLayer, x, z);
  }

  /** {@link GoldenSun#getTileType_} */
  @Method(0x200aab4)
  public static int getTileType(final int mapLayer, final int x, final int z) {
    return (int)MEMORY.call(0x80091b0, mapLayer, x, z);
  }

  /** {@link GoldenSun#FUN_80091b8} */
  @Method(0x200aabc)
  public static void FUN_80091b8(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091b8, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200aac4)
  public static void FUN_80091c0(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091d8} */
  @Method(0x200aacc)
  public static int FUN_80091d8(final Actor70 r0, final Vec3 r1) {
    return (int)MEMORY.call(0x80091d8, r0, r1);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200aad4)
  public static void FUN_80091e0(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091e8} */
  @Method(0x200aadc)
  public static void FUN_80091e8(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e8, actor, r1);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200aae4)
  public static void FUN_8015040(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200aaec)
  public static int readFlag(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200aaf4)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200aafc)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200ab04)
  public static void FUN_808a010(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200ab0c)
  public static void FUN_808a018() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200ab14)
  public static void FUN_808a020() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200ab1c)
  public static Actor70 getMapActor(final int actorIndex) {
    return (Actor70)MEMORY.call(0x808a080, actorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200ab24)
  public static void setActorVelocityScalerAndAcceleration(final int actorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, actorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x200ab2c)
  public static void FUN_808a098(final int actorIndex, final int r1) {
    MEMORY.call(0x808a098, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200ab34)
  public static void FUN_808a0c0(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0c0, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0e0} */
  @Method(0x200ab3c)
  public static void FUN_808a0e0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a0e0, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200ab44)
  public static void FUN_808a0e8(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x200ab4c)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200ab54)
  public static void setActorAnimationIfLoaded(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#waitForActorAnimationToChange_} */
  @Method(0x200ab5c)
  public static void waitForActorAnimationToChange(final int actorIndex) {
    MEMORY.call(0x808a118, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200ab64)
  public static void FUN_808a158(final int actorIndex, final int r1) {
    MEMORY.call(0x808a158, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a160} */
  @Method(0x200ab6c)
  public static void FUN_808a160(final Actor70 r0, final int r1) {
    MEMORY.call(0x808a160, r0, r1);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200ab74)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200ab7c)
  public static void FUN_808a208(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200ab84)
  public static void FUN_808a210(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200ab8c)
  public static void FUN_808a218() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a2a8} */
  @Method(0x200ab94)
  public static int FUN_808a2a8() {
    return (int)MEMORY.call(0x808a2a8);
  }

  /** {@link GoldenSun_808#FUN_808a2b0} */
  @Method(0x200ab9c)
  public static int FUN_808a2b0() {
    return (int)MEMORY.call(0x808a2b0);
  }

  /** {@link GoldenSun_808#FUN_808a408} */
  @Method(0x200aba4)
  public static void FUN_808a408(final Actor70 r0) {
    MEMORY.call(0x808a408, r0);
  }

  /** {@link GoldenSun_808#FUN_808a5e8} */
  @Method(0x200abac)
  public static void FUN_808a5e8() {
    MEMORY.call(0x808a5e8);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200abb4)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
