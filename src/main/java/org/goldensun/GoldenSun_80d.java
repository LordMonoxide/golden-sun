package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;

import static org.goldensun.GoldenSun.FUN_80049ac;
import static org.goldensun.GoldenSun.FUN_80051d8;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_80b.FUN_80b5010;
import static org.goldensun.GoldenSun_80b.FUN_80b5040;
import static org.goldensun.GoldenSun_80b.FUN_80b5088;
import static org.goldensun.GoldenSun_80b.FUN_80b5098;
import static org.goldensun.GoldenSun_80b.FUN_80b50d8;
import static org.goldensun.GoldenSun_80b.FUN_80b50e8;
import static org.goldensun.GoldenSun_80b.FUN_80b5100;
import static org.goldensun.GoldenSun_80c.FUN_80cd52c;
import static org.goldensun.GoldenSun_80c.FUN_80cd594;
import static org.goldensun.GoldenSun_80c.FUN_80cdbc0;
import static org.goldensun.GoldenSun_80c.FUN_80cef64;
import static org.goldensun.GoldenSun_80e.FUN_80e0524;
import static org.goldensun.GoldenSun_80e.FUN_80e155c;
import static org.goldensun.GoldenSun_80e.FUN_80e15e8;
import static org.goldensun.GoldenSun_80e.FUN_80e3908;
import static org.goldensun.GoldenSun_80e.FUN_80e3944;
import static org.goldensun.GoldenSun_80e.FUN_80e6d3c;
import static org.goldensun.GoldenSun_80e.FUN_80e6eac;
import static org.goldensun.GoldenSun_80e.FUN_80e7320;
import static org.goldensun.GoldenSun_80e.FUN_80e823c;
import static org.goldensun.GoldenSun_80e.FUN_80ea0d8;
import static org.goldensun.GoldenSun_80e.FUN_80eb754;
import static org.goldensun.GoldenSun_80e.FUN_80ec100;
import static org.goldensun.GoldenSun_80e.FUN_80ed408;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80d {
  private GoldenSun_80d() { }

  @Method(0x80d1714)
  public static void FUN_80d1714(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80d2458)
  public static void FUN_80d2458(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80d2d98)
  public static void FUN_80d2d98(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
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
    r3 = 0x3001ef0;
    r1 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x3c;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
    r2 = r3 - 0x4;
    r2 = MEMORY.ref(4, r2).get();
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r2);
    r7 = 0x7828;
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r3);
    r3 = r2 + r7;
    MEMORY.ref(4, r3).setu(r0);
    r0 = 0x0;
    FUN_80cd594(r0);
    r2 = 0x4000052;
    r0 = CPU.sp().value;
    r3 = 0x1010;
    r0 = r0 + 0x34;
    MEMORY.ref(2, r2).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
    r0 = 0x0;
    FUN_80cef64(r0, r1);
    r0 = 0x6e;
    r0 = getPointerTableEntry(r0);
    r5 = r0;
    r0 = 0xa0;
    r3 = 0x3001388;
    r2 = 0x80;
    r1 = r5;
    r0 = r0 << 19;
    MEMORY.call(r3, r0, r1, r2);
    r5 = r5 + 0x80;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r0 = r5;
    decompress(r0, r1);
    r0 = 0x85;
    r0 = getPointerTableEntry(r0);
    r3 = 0x6e4;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r5 = r0;
    r5 = r5 + 0x80;
    r1 = r2 + r3;
    r0 = r5;
    decompress(r0, r1);
    r0 = 0x73;
    r0 = getPointerTableEntry(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
    decompress(r0, r1);
    r0 = 0xef;
    r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r0 = r0 << 7;
    r1 = 0x7784;
    r2 = r7 + r0;
    r3 = 0x2;
    MEMORY.ref(4, r2).setu(r3);
    r2 = r7 + r1;
    r3 = 0x4b;
    MEMORY.ref(4, r2).setu(r3);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    r7 = 0xb0;
    r0 = 0xfff00000;
    r7 = r7 << 15;
    r1 = 0xfffc0000;
    r3 = 0x80;
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r7);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
    r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r0 = 0x7098;
    r2 = 0x0;
    r3 = r3 << 17;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r3);
    CPU.r8().value = r2;
    r3 = r7 + r0;
    r2 = r2 - 0x1;

    //LAB_80d2e7e
    do {
      r1 = 0x1;
      CPU.r8().value = CPU.r8().value + r1;
      r7 = CPU.r8().value;
      MEMORY.ref(4, r3).setu(r2);
      r3 = r3 + 0x1c;
    } while(r7 != 0x40);

    r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r2 = 0x7320;
    r0 = 0x0;
    CPU.r8().value = r0;
    r5 = r1 + r2;

    //LAB_80d2e96
    do {
      r0 = rand();
      r3 = 0x7f;
      r3 = r3 & r0;
      MEMORY.ref(4, r5).setu(r3);
      r0 = rand();
      r3 = 0x7;
      r3 = r3 & r0;
      r3 = r3 + 0x38;
      MEMORY.ref(4, r5 + 0x4).setu(r3);
      r0 = rand();
      r3 = 0xf;
      r3 = r3 & r0;
      r3 = -r3;
      MEMORY.ref(4, r5 + 0x18).setu(r3);
      r3 = 0x1;
      CPU.r8().value = CPU.r8().value + r3;
      r7 = CPU.r8().value;
      r5 = r5 + 0x1c;
    } while(r7 != 0x10);

    r0 = 0x0;
    r1 = 0x1;
    r2 = 0x80;
    r3 = 0x2010018;
    CPU.r8().value = r0;
    r1 = -r1;
    r2 = r2 << 3;

    //LAB_80d2ed2
    do {
      r7 = 0x1;
      CPU.r8().value = CPU.r8().value + r7;
      MEMORY.ref(4, r3).setu(r1);
      r3 = r3 + 0x1c;
    } while(CPU.r8().value != r2);

    r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r1 = 0x7828;
    r3 = r0 + r1;
    r0 = MEMORY.ref(4, r3).get();
    FUN_80d6750(r0);
    r0 = 0x1;
    sleep(r0);
    r1 = 0xbe;
    r2 = 0x2;
    r1 = r1 << 1;
    r0 = 0xc;
    FUN_80dbb24(r0, r1, r2);
    r2 = 0x0;
    CPU.r9().value = r2;

    //LAB_80d2f00
    do {
      r3 = 0x3001b04;
      r3 = MEMORY.ref(4, r3).get();
      r2 = 0x3;
      r3 = r3 & r2;
      if(r3 != 0) {
        r3 = CPU.r9().value;
        if(r3 > 0x20) {
          if(r3 <= 0x61) {
            r7 = 0x62;
            CPU.r9().value = r7;
          }
        }
      }

      //LAB_80d2f1a
      r0 = CPU.r9().value;
      if(r0 == 0x78) {
        r0 = 0x86;
        FUN_80b50e8(r0);
      }

      //LAB_80d2f26
      r1 = CPU.r9().value;
      if(r1 <= 0xf) {
        r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        r2 = r2 + 0x2;
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
      }

      //LAB_80d2f32
      r3 = CPU.r9().value;
      if(r3 <= 0x63) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r7 = r7 + r0;
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r7);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r3 = 0x3a;
        r3 = r3 * r7;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r1 = r1 + r2;
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
        if(r3 < 0x0) {
          r3 = r3 + 0x3f;
        }

        //LAB_80d2f54
        r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r3 = r3 >> 6;
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
        r3 = r0 << 3;
        r3 = r3 - r0;
        r3 = r3 << 3;
        if(r3 < 0x0) {
          r3 = r3 + 0x3f;
        }

        //LAB_80d2f66
        r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r2 = 0x77ffff;
        r3 = r3 >> 6;
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
        if(r1 <= r2) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r7 = 0x80;
          r7 = r7 << 8;
          r7 = r3 + r7;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r7);
        }
      }

      //LAB_80d2f7c
      r0 = 0x1;
      r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r2 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      FUN_80e6d3c(r0, r1, r2);
      r0 = CPU.r9().value;
      if(r0 == 0x1c) {
        r1 = 0x0;
        r2 = 0x3f;
        r7 = 0x2010000;
        CPU.r8().value = r1;
        CPU.r10().value = r2;

        //LAB_80d2f96
        do {
          r0 = 0x1;
          r3 = MEMORY.ref(4, r7 + 0x18).get();
          r0 = -r0;
          if(r3 == r0) {
            r0 = rand();
            r1 = CPU.r10().value;
            r6 = r0;
            r6 = r6 & r1;
            r0 = rand();
            r3 = 0xffff;
            r5 = r0;
            r5 = r5 & r3;
            r0 = r5;
            r0 = sin(r0);
            r3 = r6;
            r3 = r3 * r0;
            r2 = 0x80;
            r2 = r2 << 14;
            r3 = r3 >> 3;
            r3 = r3 + r2;
            MEMORY.ref(4, r7).setu(r3);
            r0 = r5;
            r0 = cos(r0);
            r3 = r6;
            r3 = r3 * r0;
            r0 = 0xc0;
            r0 = r0 << 15;
            r3 = r3 >> 2;
            r3 = r3 + r0;
            MEMORY.ref(4, r7 + 0x4).setu(r3);
            r0 = rand();
            r1 = CPU.r10().value;
            r0 = r0 & r1;
            r0 = r0 - 0x20;
            r0 = r0 << 14;
            MEMORY.ref(4, r7 + 0xc).setu(r0);
            r0 = rand();
            r2 = CPU.r10().value;
            r0 = r0 & r2;
            r0 = -r0;
            r0 = r0 - 0x8;
            r0 = r0 << 13;
            r3 = 0x0;
            MEMORY.ref(4, r7 + 0x10).setu(r0);
            MEMORY.ref(4, r7 + 0x18).setu(r3);
          }

          //LAB_80d2ffe
          r3 = 0x1;
          r0 = 0x80;
          CPU.r8().value = CPU.r8().value + r3;
          r0 = r0 << 1;
          r7 = r7 + 0x1c;
        } while(CPU.r8().value != r0);
      }

      //LAB_80d300c
      r1 = CPU.r9().value;
      r1 = r1 - 0x20;
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
      if((r1 & 0xffff_ffffL) <= (0x2f & 0xffff_ffffL)) {
        r2 = 0x0;
        r3 = 0x3f;
        r7 = 0x2010000;
        CPU.r11().value = r2;
        CPU.r8().value = r2;
        CPU.r10().value = r3;

        //LAB_80d3022
        do {
          r0 = 0x1;
          r3 = MEMORY.ref(4, r7 + 0x18).get();
          r0 = -r0;
          if(r3 == r0) {
            r0 = rand();
            r1 = CPU.r10().value;
            r6 = r0;
            r6 = r6 & r1;
            r0 = rand();
            r3 = 0xffff;
            r5 = r0;
            r5 = r5 & r3;
            r0 = r5;
            r0 = sin(r0);
            r3 = r6;
            r3 = r3 * r0;
            r2 = 0x80;
            r2 = r2 << 14;
            r3 = r3 >> 3;
            r3 = r3 + r2;
            MEMORY.ref(4, r7).setu(r3);
            r0 = r5;
            r0 = cos(r0);
            r3 = r6;
            r3 = r3 * r0;
            r0 = 0xc0;
            r0 = r0 << 15;
            r3 = r3 >> 2;
            r3 = r3 + r0;
            MEMORY.ref(4, r7 + 0x4).setu(r3);
            r0 = rand();
            r1 = CPU.r10().value;
            r0 = r0 & r1;
            r0 = r0 - 0x20;
            r0 = r0 << 14;
            MEMORY.ref(4, r7 + 0xc).setu(r0);
            r0 = rand();
            r2 = CPU.r10().value;
            r0 = r0 & r2;
            r3 = 0x0;
            r0 = -r0;
            r0 = r0 - 0x8;
            MEMORY.ref(4, r7 + 0x18).setu(r3);
            r3 = 0x1;
            r0 = r0 << 13;
            CPU.r11().value = CPU.r11().value + r3;
            MEMORY.ref(4, r7 + 0x10).setu(r0);
            r0 = CPU.r11().value;
            if(r0 == 0x10) {
              break;
            }
          }

          //LAB_80d3094
          r1 = 0x1;
          r2 = 0x80;
          CPU.r8().value = CPU.r8().value + r1;
          r2 = r2 << 3;
          r7 = r7 + 0x1c;
        } while(CPU.r8().value != r2);
      }

      //LAB_80d30a2
      r3 = CPU.r9().value;
      if(r3 == 0) {
        r0 = 0xa4;
        playSound_(r0);
      }

      //LAB_80d30ae
      r7 = CPU.r9().value;
      if(r7 == 0x20) {
        r0 = 0x91;
        playSound_(r0);
      }

      //LAB_80d30ba
      r0 = CPU.r9().value;
      if(r0 == 0x50) {
        r0 = 0x90;
        playSound_(r0);
      }

      //LAB_80d30c6
      r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      if((r1 & 0xffff_ffffL) <= (0x2f & 0xffff_ffffL)) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r1 = 0x6e4;
        r0 = r0 + r1;
        r2 = 0x0;
        r7 = CPU.r9().value;
        CPU.r10().value = r0;
        r0 = 0xffffff00;
        CPU.r8().value = r2;
        r3 = r7 << 4;
        r2 = 0x22;
        r6 = 0x80ee1ac;
        CPU.r11().value = r2;
        r7 = r3 + r0;

        //LAB_80d30e6
        do {
          r0 = r7;
          r1 = 0x68;
          r0 = modS(r0, r1);
          r3 = MEMORY.ref(1, r6 + 0x1).getUnsigned();
          r2 = MEMORY.ref(1, r6).getUnsigned();
          r5 = r0;
          r1 = CPU.r11().value;
          r0 = 0x68;
          r3 = r3 - r5;
          MEMORY.ref(4, CPU.sp().value).setu(r1);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
          r2 = r2 - 0x11;
          r3 = r3 - 0x68;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r1 = CPU.r10().value;
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r2 = MEMORY.ref(1, r6).getUnsigned();
          r3 = MEMORY.ref(1, r6 + 0x1).getUnsigned();
          r1 = CPU.r11().value;
          r2 = r2 - 0x11;
          r3 = r3 - r5;
          MEMORY.ref(4, CPU.sp().value).setu(r1);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r1 = CPU.r10().value;
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r2 = 0x1;
          CPU.r8().value = CPU.r8().value + r2;
          r3 = CPU.r8().value;
          r6 = r6 + 0x2;
          r7 = r7 + 0x19;
        } while(r3 != 0x3);
      }

      //LAB_80d3132
      r7 = CPU.r9().value;
      if(r7 <= 0x5f) {
        r0 = 0x0;
        CPU.r8().value = r0;
        r5 = 0x20;
        r6 = 0x78;

        //LAB_80d3140
        do {
          r2 = CPU.r8().value;
          r1 = r2 << 5;
          r2 = CPU.r9().value;
          if(r2 < 0) {
            r2 = r2 + 0x3;
          }

          //LAB_80d314c
          r3 = 0x1f;
          r2 = r2 >> 2;
          r2 = r2 & r3;
          r7 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r2 = r1 + r2;
          r2 = r2 - 0x20;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r3 = r6 - r7;
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x1;
          CPU.r8().value = CPU.r8().value + r0;
          r1 = CPU.r8().value;
        } while(r1 != 0x5);
      }

      //LAB_80d3172
      r2 = 0x0;
      r5 = 0x2010000;
      CPU.r8().value = r2;

      //LAB_80d3178
      do {
        r3 = MEMORY.ref(4, r5 + 0x18).get();
        if(r3 >= 0) {
          //LAB_80d3180
          r0 = CPU.r8().value;
          r1 = 0x3;
          r0 = modS(r0, r1);
          r3 = MEMORY.ref(4, r5 + 0x10).get();
          r4 = r0 + 0x2;
          if(r3 > 0) {
            r4 = r4 + 0x2;
          }

          //LAB_80d3192
          r7 = CPU.r9().value;
          if(r7 > 0x44) {
            if(r4 <= 0x5) {
              r4 = 0x6;
            }
          }

          //LAB_80d319e
          r0 = CPU.r9().value;
          if(r0 > 0x46) {
            if(r4 <= 0x6) {
              r4 = 0x7;
            }
          }

          //LAB_80d31ec
          r1 = CPU.r9().value;
          if(r1 > 0x48) {
            if(r4 <= 0x7) {
              r4 = 0x8;
            }
          }

          //LAB_80d31f8
          r2 = CPU.r9().value;
          if(r2 > 0x4a) {
            if(r4 <= 0x8) {
              r4 = 0x9;
            }
          }

          //LAB_80d3204
          r7 = CPU.r9().value;
          if(r7 > 0x4c) {
            r4 = 0xa;
          }

          //LAB_80d320c
          r6 = 0x4;
          if(r3 <= 0) {
            r6 = 0x0;
          }

          //LAB_80d3214
          r0 = r4 << 1;
          r2 = 0x80ede48;
          r3 = r0 - 0x2;
          r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r1 = r2 + r1;
          r3 = 0x2;
          r2 = MEMORY.ref(2, r5 + r3).get();
          r3 = r4 >>> 31;
          r3 = r4 + r3;
          r3 = r3 >> 1;
          r2 = r2 - r3;
          r7 = 0x6;
          r3 = MEMORY.ref(2, r5 + r7).get();
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r3 = r3 - r4;
          r4 = MEMORY.ref(4, r6 + r0).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = MEMORY.ref(4, r5).get();
          r2 = MEMORY.ref(4, r5 + 0xc).get();
          r3 = r3 + r2;
          MEMORY.ref(4, r5).setu(r3);
          r1 = MEMORY.ref(4, r5 + 0x10).get();
          r3 = MEMORY.ref(4, r5 + 0x4).get();
          r2 = CPU.r9().value;
          r3 = r3 + r1;
          MEMORY.ref(4, r5 + 0x4).setu(r3);
          if(r2 > 0x50) {
            r7 = 0xffff8000;
            r3 = r1 + r7;
          } else {
            //LAB_80d325c
            r2 = 0x3;
            r0 = CPU.r8().value;
            r3 = 0x80ee1b4;
            r2 = r2 & r0;
            r2 = r2 << 2;
            r3 = MEMORY.ref(4, r3 + r2).get();
            r3 = r1 + r3;
          }

          //LAB_80d326a
          MEMORY.ref(4, r5 + 0x10).setu(r3);
          r2 = MEMORY.ref(4, r5 + 0xc).get();
          r3 = r2 << 5;
          r3 = r3 - r2;
          r3 = r3 << 1;
          if(r3 < 0) {
            r3 = r3 + 0x3f;
          }

          //LAB_80d327a
          r2 = MEMORY.ref(4, r5 + 0x10).get();
          r3 = r3 >> 6;
          MEMORY.ref(4, r5 + 0xc).setu(r3);
          r3 = r2 << 5;
          r3 = r3 - r2;
          r2 = r3 << 1;
          if(r2 < 0) {
            r2 = r2 + 0x3f;
          }

          //LAB_80d328c
          r3 = MEMORY.ref(4, r5 + 0x18).get();
          r2 = r2 >> 6;
          r3 = r3 + 0x1;
          MEMORY.ref(4, r5 + 0x10).setu(r2);
          MEMORY.ref(4, r5 + 0x18).setu(r3);
          if(r2 > 0) {
            r1 = 0x6;
            r3 = MEMORY.ref(2, r5 + r1).get();
            if(r3 > 0x68) {
              r3 = 0x1;
              r3 = -r3;
              MEMORY.ref(4, r5 + 0x18).setu(r3);
            }
          }
        }

        //LAB_80d32a8
        r2 = 0x1;
        r3 = 0x80;
        CPU.r8().value = CPU.r8().value + r2;
        r3 = r3 << 3;
        r5 = r5 + 0x1c;
        CPU.cmpT(CPU.r8().value, r3);
      } while(CPU.r8().value != r3);

      //LAB_80d32b8
      r7 = CPU.r9().value;
      if(r7 <= 0x4f) {
        r3 = 0x7828;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r2 = r1 + r3;
        r3 = MEMORY.ref(4, r2).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        r0 = 0x0;
        CPU.r8().value = r0;
        if(r3 != 0) {
          r7 = r2;
          r4 = 0x24;

          //LAB_80d32d4
          do {
            r0 = CPU.r9().value;
            if(r0 > 0x1d) {
              r1 = 0xc;
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              r0 = modS(r0, r1);
              r6 = r0;
              r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
              if(r6 == 0) {
                r3 = MEMORY.ref(4, r7).get();
                r0 = MEMORY.ref(2, r3 + r4).get();
                r0 = FUN_80b5098(r0);
                r3 = MEMORY.ref(4, r7).get();
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                r5 = MEMORY.ref(4, r0).get();
                r0 = MEMORY.ref(2, r3 + r4).get();
                r3 = 0x1;
                r3 = -r3;
                r1 = 0x7;
                r2 = 0x5;
                MEMORY.ref(4, CPU.sp().value).setu(r6);
                FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                r3 = 0x90;
                r3 = r3 << 11;
                MEMORY.ref(4, r5 + 0x28).setu(r3);
                r3 = 0xab85;
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                MEMORY.ref(4, r5 + 0x48).setu(r3);
              }

              //LAB_80d3314
              if(r6 == 0x6) {
                r3 = MEMORY.ref(4, r7).get();
                r0 = MEMORY.ref(2, r3 + r4).get();
                r3 = 0x0;
                MEMORY.ref(4, CPU.sp().value).setu(r3);
                r1 = 0x0;
                r2 = 0x5;
                r3 = r3 - 0x1;
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
              }
            }

            //LAB_80d332e
            r3 = MEMORY.ref(4, r7).get();
            r2 = 0x1;
            r3 = MEMORY.ref(4, r3 + 0x14).get();
            CPU.r8().value = CPU.r8().value + r2;
            r4 = r4 + 0x2;
          } while(CPU.r8().value != r3);
        }
      }

      //LAB_80d333c
      r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      r7 = 0x7824;
      r2 = r3 + r7;
      r3 = 0x1;
      r0 = 0x1;
      MEMORY.ref(4, r2).setu(r3);
      sleep(r0);
      r0 = 0x1;
      CPU.r9().value = CPU.r9().value + r0;
      r1 = CPU.r9().value;
    } while(r1 != 0x7c);

    //LAB_80d3358
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    r0 = 0x2f;
    freeSlot(r0);
    r0 = 0x2e;
    freeSlot(r0);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
    r0 = 0x1;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    FUN_80e6eac(r0, r1, r2);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r7 = r7 - 0x4c;
    r5 = r3 + r7;
    CPU.r8().value = 0;

    //LAB_80d337e
    do {
      clearSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new));
      r5 += 0x4;
      CPU.r8().value++;
    } while(CPU.r8().value < 12);

    FUN_80cdbc0();
    CPU.sp().value += 0x3c;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80d6578)
  public static void FUN_80d6578(int r0) {
    int r1;
    final int r3;
    final int r5;

    r5 = r0;
    r1 = 0x302;
    r0 = 0x29;
    mallocSlotChip(r0, r1);
    r1 = 0x782c;
    r0 = 0x27;
    mallocSlotChip(r0, r1);
    r1 = 0x80;
    r1 = r1 << 7;
    r0 = 0x28;
    mallocSlotChip(r0, r1);
    r3 = MEMORY.ref(4, r5).get();

    switch(r3) {
      case 1:
        //LAB_80d65dc
        r0 = r5;
        FUN_80e823c(r0);
        break;

      case 2:
        //LAB_80d65e4
        r0 = r5;
        FUN_80d2d98(r0);
        break;

      case 3:
        //LAB_80d65ec
        r0 = r5;
        FUN_80eb754(r0);
        break;

      case 4:
        //LAB_80d65f4
        r0 = r5;
        FUN_80dc968(r0);
        break;

      case 5:
        //LAB_80d65fc
        r0 = r5;
        FUN_80d6970(r0);
        break;

      case 6:
        //LAB_80d6604
        r0 = r5;
        FUN_80ec100(r0);
        break;

      case 7:
        //LAB_80d660c
        r0 = r5;
        FUN_80d2458(r0);
        break;

      case 8:
        //LAB_80d6614
        r0 = r5;
        FUN_80d1714(r0);
        break;

      case 9:
        //LAB_80d661c
        r0 = r5;
        FUN_80ea0d8(r0);
        break;

      case 10:
        //LAB_80d6624
        r0 = r5;
        FUN_80d765c(r0);
        break;

      case 0:
      case 11:
        //LAB_80d662c
        r0 = r5;
        FUN_80e7320(r0);
        break;

      case 12:
        //LAB_80d6634
        r0 = r5;
        FUN_80e15e8(r0);
        break;
    }

    //LAB_80d663a
    r0 = 0x28;
    freeSlot(r0);
    r0 = 0x27;
    freeSlot(r0);
    r0 = 0x29;
    freeSlot(r0);
  }

  @Method(0x80d6750)
  public static void FUN_80d6750(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);
    r1 = 0x24;
    r3 = MEMORY.ref(2, r0 + r1).get();
    CPU.sp().value -= 0x20;
    r2 = 0x0;
    if(r3 > 0x7f) {
      r3 = CPU.sp().value + 0x4;
      CPU.r8().value = r3;
      r6 = 0x0;
      r7 = CPU.r8().value;

      //LAB_80d676a
      do {
        r5 = r6 + 0x80;
        MEMORY.ref(4, CPU.sp().value).setu(r2);
        r3 = getCharOrMonsterData_(r5).hp_38.get();
        r2 = MEMORY.ref(4, CPU.sp().value).get();
        if(r3 > 0) {
          MEMORY.ref(2, r7).setu(r5);
          r2 = r2 + 0x1;
          r7 = r7 + 0x2;
        }

        //LAB_80d6786
        r6 = r6 + 0x1;
      } while(r6 != 0x6);
    } else {
      //LAB_80d678e
      r3 = CPU.sp().value + 0x4;
      CPU.r8().value = r3;
      r1 = CPU.r8().value;
      r3 = r2 << 1;
      r6 = 0x0;
      r5 = r3 + r1;

      //LAB_80d679a
      do {
        MEMORY.ref(4, CPU.sp().value).setu(r2);
        r3 = getCharOrMonsterData_(r6).hp_38.get();
        r2 = MEMORY.ref(4, CPU.sp().value).get();
        if(r3 > 0) {
          MEMORY.ref(2, r5).setu(r6);
          r2 = r2 + 0x1;
          r5 = r5 + 0x2;
        }

        //LAB_80d67b2
        r6 = r6 + 0x1;
      } while(r6 != 0x8);
    }

    //LAB_80d67b8
    r3 = 0xff;
    r2 = r2 << 1;
    r1 = CPU.r8().value;
    MEMORY.ref(2, r1 + r2).setu(r3);
    r0 = CPU.r8().value;
    r1 = 0x0;
    FUN_80b5010(r0, r1);
    CPU.sp().value += 0x20;
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80d67dc)
  public static void FUN_80d67dc() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;
    final int r5;
    int r6;

    r6 = CPU.r8().value;
    CPU.push(r6);
    r3 = 0x3001e74;
    r1 = 0x80;
    r6 = MEMORY.ref(4, r3 + 0x7c).get();
    r2 = MEMORY.ref(4, r3).get();
    r3 = 0x1;
    r1 = r1 << 19;
    MEMORY.ref(2, r1).setu(r3);
    CPU.r8().value = r1;
    r1 = 0x3001ad0;
    r3 = 0x20;
    MEMORY.ref(2, r1 + 0x6).setu(r3);
    r3 = 0xc9;
    r3 = r3 << 3;
    r2 = r2 + r3;
    r1 = MEMORY.ref(2, r2).getUnsigned();
    r0 = 0x1;
    r2 = 0x18;
    CPU.sp().value -= 0x4;
    FUN_80b5040(r0, r1, r2);
    r5 = 0x0;
    r4 = CPU.sp().value;
    MEMORY.ref(4, r4).setu(r5);
    r3 = 0x40000d4;
    r0 = r4;
    r1 = r6;
    r2 = 0x85001000;
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = r3 - 0xc;
    MEMORY.ref(4, r4).setu(r5);
    r0 = r4;
    r1 = 0x6004000;
    r2 = 0x85001000;
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = r3 - 0xc;
    r0 = 0x1;
    sleep(r0);
    r2 = 0x4000052;
    r3 = 0x100e;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x3f46;
    r2 = r2 - 0x2;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x7741;
    r1 = CPU.r8().value;
    r2 = 0x3001ce0;
    MEMORY.ref(2, r1).setu(r3);
    r3 = 0x78;
    MEMORY.ref(4, r2 + 0x10).setu(r3);
    CPU.sp().value += 0x4;
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  @Method(0x80d6888)
  public static void FUN_80d6888(final int r0, final int r1, int r2, int r3, final int a4) {
    final int r11 = r3;
    final int sp0c = r2;
    final int r8 = FUN_80b5098(r0);
    r3 = 0x3001eec;
    r3 = MEMORY.ref(4, r3).get();
    final int sp08 = r3;
    int sp04 = 0;

    //LAB_80d6936
    Sprite38 r7;
    while((r7 = FUN_80b50d8(MEMORY.ref(4, r8).get(), sp04)) != null) {
      //LAB_80d68b2
      if(r11 != -1) {
        MEMORY.ref(1, sp08 + r11 + 0x7818).setu(a4);
      }

      //LAB_80d68c6
      if(MEMORY.ref(2, r8 + 0x2a).get() == 0) {
        if(r1 != -1) {
          //LAB_80d68e6
          for(r2 = 0; r2 < r7.layerCount_27.get(); r2++) {
            final SpriteLayer18 r5 = r7.layers_28.get(r2).derefNullable();
            if(r5 != null && r5.getAddress() != MEMORY.ref(4, r8 + 0x24).get() && r5.getAddress() != MEMORY.ref(4, r8 + 0x20).get()) {
              if(r1 == 0) {
                r5._05.set(FUN_80b5100(r0));
              } else {
                //LAB_80d690e
                r5._05.set(r1);
              }

              //LAB_80d6912
              r5._16.set(0xff);
            }

            //LAB_80d6916
          }
        }

        //LAB_80d6920
        if(sp0c != -1) {
          setSpriteAnimation_(r7, sp0c);
        }
      }

      //LAB_80d6930
      sp04++;
    }
  }

  @Method(0x80d6970)
  public static void FUN_80d6970(int r0) {
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
    r3 = 0x3001eec;
    r1 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x64;
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r3);
    r3 = 0x7828;
    CPU.r9().value = r1;
    r3 = r3 + CPU.r9().value;
    MEMORY.ref(4, r3).setu(r0);
    r1 = 0x177;
    r0 = 0x8;
    r2 = 0x1;
    FUN_80dbb24(r0, r1, r2);
    r2 = 0x0;
    CPU.r10().value = r2;
    r1 = 0x80;
    r2 = 0x2010000;
    r0 = 0x7f;
    r1 = r1 << 3;

    //LAB_80d69a6
    do {
      r3 = CPU.r10().value;
      r3 = r3 & r0;
      MEMORY.ref(1, r2).setu(r3);
      r3 = 0x1;
      CPU.r10().value = CPU.r10().value + r3;
      r2 = r2 + 0x1;
    } while(CPU.r10().value != r1);

    r4 = 0x0;
    r0 = 0x7f;
    CPU.r10().value = r4;
    CPU.r8().value = r0;
    CPU.r11().value = r4;

    //LAB_80d69c0
    do {
      r7 = 0x0;
      r6 = CPU.r11().value;

      //LAB_80d69c4
      do {
        r0 = rand();
        r1 = CPU.r8().value;
        r5 = r0;
        r5 = r5 & r1;
        r0 = rand();
        r2 = CPU.r8().value;
        r3 = 0x2010000;
        r0 = r0 & r2;
        r0 = r6 + r0;
        r5 = r6 + r5;
        r0 = r0 + r3;
        r5 = r5 + r3;
        r2 = MEMORY.ref(1, r0).getUnsigned();
        r3 = MEMORY.ref(1, r5).getUnsigned();
        r7 = r7 + 0x1;
        MEMORY.ref(1, r0).setu(r3);
        MEMORY.ref(1, r5).setu(r2);
      } while(r7 != 0x80);

      r0 = 0x1;
      CPU.r10().value = CPU.r10().value + r0;
      r4 = 0x80;
      r1 = CPU.r10().value;
      CPU.r11().value = CPU.r11().value + r4;
    } while(r1 != 0x8);

    FUN_80cd594(0);
    MEMORY.ref(2, 0x4000020).setu(0x100);
    MEMORY.ref(2, 0x4000050).setu(0);
    FUN_80e0524(178, CPU.r9().value, 1, 1);
    FUN_80ed408(46, 7, 7, 3, 1);
    r3 = boardWramMallocHead_3001e50.offset(46 * 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
    FUN_80ed408(47, 7, 7, 7, 1);
    r2 = CPU.sp().value + 0x44;
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r2);
    MEMORY.ref(4, r2 + 0x4).setu(boardWramMallocHead_3001e50.offset(47 * 0x4).get());
    MEMORY.ref(4, CPU.r9().value + 0x7780).setu(1);
    MEMORY.ref(4, CPU.r9().value + 0x7784).setu(0);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN80cd260"), 0x480);
    MEMORY.ref(4, 0x4000028).setu(-0x2000);
    CPU.r10().value = 0;
    r7 = 0x7;
    CPU.r8().value = -90;
    r6 = 0x0;
    r5 = CPU.r9().value + 0x7080;

    //LAB_80d6aa8
    do {
      r0 = CPU.r10().value;
      if(r0 <= 0x4) {
        MEMORY.ref(4, r5).setu(r6);
        r0 = rand();
        r0 = r0 & r7;
        r0 = r0 + 0x68;
      } else {
        //LAB_80d6aba
        r1 = CPU.r8().value;
        MEMORY.ref(4, r5).setu(r1);
        r0 = rand();
        r0 = r0 & r7;
        r0 = r0 + 0x6c;
      }

      //LAB_80d6ac6
      MEMORY.ref(4, r5 + 0x4).setu(r0);
      r0 = rand();
      r0 = r0 & r7;
      r0 = r0 + 0x4;
      MEMORY.ref(4, r5 + 0x10).setu(r0);
      r0 = rand();
      r3 = 0xf;
      r3 = r3 & r0;
      r3 = r3 + 0x10;
      MEMORY.ref(4, r5 + 0x18).setu(r3);
      r3 = 0x1;
      CPU.r10().value = CPU.r10().value + r3;
      r2 = 0x14;
      r4 = CPU.r10().value;
      CPU.r8().value = CPU.r8().value + r2;
      r6 = r6 + 0x14;
      r5 = r5 + 0x1c;
    } while(r4 != 0x10);

    r5 = 0x7240;
    r0 = 0x0;
    CPU.r10().value = r0;
    r5 = r5 + CPU.r9().value;

    //LAB_80d6af8
    do {
      r0 = rand();
      r3 = 0x3f;
      r3 = r3 & r0;
      r3 = r3 + 0x20;
      MEMORY.ref(4, r5).setu(r3);
      r0 = rand();
      r3 = 0x1f;
      r3 = r3 & r0;
      r3 = r3 + 0x40;
      MEMORY.ref(4, r5 + 0x4).setu(r3);
      r0 = rand();
      r3 = 0x7;
      r3 = r3 & r0;
      r1 = 0x1;
      r3 = -r3;
      CPU.r10().value = CPU.r10().value + r1;
      r3 = r3 - 0x8;
      r2 = CPU.r10().value;
      MEMORY.ref(4, r5 + 0x18).setu(r3);
      r5 = r5 + 0x1c;
    } while(r2 != 0x10);

    r5 = 0xe8;
    r3 = 0x0;
    r5 = r5 << 7;
    CPU.r10().value = r3;
    r6 = 0x0;
    r5 = r5 + CPU.r9().value;

    //LAB_80d6b36
    do {
      r3 = 0x80;
      r3 = r3 << 16;
      MEMORY.ref(4, r5).setu(r3);
      r3 = 0x80;
      r3 = r3 << 15;
      MEMORY.ref(4, r5 + 0x4).setu(r3);
      r0 = rand();
      r3 = 0xff;
      r3 = r3 & r0;
      r3 = r3 + 0xc8;
      r4 = 0x1;
      r3 = -r3;
      CPU.r10().value = CPU.r10().value + r4;
      r3 = r3 << 9;
      r0 = CPU.r10().value;
      MEMORY.ref(4, r5 + 0xc).setu(r3);
      MEMORY.ref(4, r5 + 0x10).setu(r6);
      MEMORY.ref(4, r5 + 0x18).setu(r6);
      r5 = r5 + 0x1c;
    } while(r0 != 0x10);

    r5 = 0x7828;
    r1 = CPU.r9().value;
    r0 = MEMORY.ref(4, r1 + r5).get();
    FUN_80d6750(r0);
    r2 = 0xffc00000;
    r3 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
    r3 = 0x3001e80;
    r5 = MEMORY.ref(4, r3).get();
    r3 = 0x3001b04;
    r3 = MEMORY.ref(4, r3).get();
    r2 = 0x3;
    r3 = r3 & r2;
    if(r3 != 0) {
      r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      if(r4 > 0xbe) {
        r0 = 0x11d;
        if(r4 <= r0) {
          r1 = 0x80;
          r1 = r1 << 7;
          r3 = 0x3000164;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          MEMORY.call(r3, r0, r1);
          r1 = 0x8f;
          r1 = r1 << 1;
          MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r1);
        }
      }
    }

    //LAB_80d6ba4
    r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r2 == 0xe0) {
      r2 = 0xef;
      r2 = r2 << 7;
      r2 = r2 + CPU.r9().value;
      r3 = 0x0;
      MEMORY.ref(4, r2).setu(r3);
    }

    //LAB_80d6bb4
    FUN_80049ac();
    r1 = r5;
    r1 = r1 + 0xc;
    r0 = r5;
    FUN_80051d8(r0, r1);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r3 == 0x1f) {
      r2 = 0x77a8;
      r3 = 0x8;
      r2 = r2 + CPU.r9().value;
      MEMORY.ref(4, r2).setu(r3);
      r0 = 0x9d;
      playSound_(r0);
      r1 = 0x7828;
      r0 = CPU.r9().value;
      r3 = MEMORY.ref(4, r0 + r1).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r4 = 0x0;
      CPU.r10().value = r4;
      if(r3 != 0) {
        r5 = 0x7828;
        r6 = 0x24;
        r5 = r5 + CPU.r9().value;

        //LAB_80d6bec
        do {
          r3 = MEMORY.ref(4, r5).get();
          r1 = 0x6;
          r0 = MEMORY.ref(2, r3 + r6).get();
          FUN_80b5088(r0, r1);
          r3 = 0x1;
          CPU.r10().value = CPU.r10().value + r3;
          r3 = MEMORY.ref(4, r5).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r6 = r6 + 0x2;
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d6c04
    r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r4 == 0x48) {
      r0 = 0x88;
      playSound_(r0);
    }

    //LAB_80d6c10
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r0 == 0x8c) {
      r0 = 0x9c;
      playSound_(r0);
    }

    //LAB_80d6c1c
    r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
    r2 = 0x80;
    r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
    r2 = r2 << 7;
    r1 = r1 + r2;
    r4 = 0x80;
    r3 = r3 + r1;
    r4 = r4 << 15;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(r3);
    if(r3 > r4) {
      MEMORY.ref(4, CPU.sp().value + 0x38).setu(r4);
    }

    //LAB_80d6c36
    r1 = 0x80;
    r0 = 0x2;
    r1 = r1 << 16;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
    FUN_80e6d3c(r0, r1, r2);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r0 = r0 - 0x30;
    if((r0 & 0xffff_ffffL) <= (0x30 & 0xffff_ffffL)) {
      r1 = 0x18;
      r0 = divideS(r0, r1);
      r1 = 0x3;
      r0 = modS(r0, r1);
      r6 = 0x80ee910;
      r5 = r0;
      r5 = r5 << 1;
      r1 = MEMORY.ref(1, r6 + r5).getUnsigned();
      setSpriteAnimation_(MEMORY.ref(4, CPU.r9().value + 0x77e4).deref(4).cast(Sprite38::new), r1);
      r5 = r5 + 0x1;
      r1 = MEMORY.ref(1, r6 + r5).getUnsigned();
      setSpriteAnimation_(MEMORY.ref(4, CPU.r9().value + 0x77e8).deref(4).cast(Sprite38::new), r1);
    }

    //LAB_80d6c76
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0x48;
    if((r3 & 0xffff_ffffL) <= (0x37 & 0xffff_ffffL)) {
      r6 = 0xe8;
      r0 = 0x0;
      r6 = r6 << 7;
      CPU.r10().value = r0;
      r6 = r6 + CPU.r9().value;

      //LAB_80d6c88
      do {
        r3 = CPU.r10().value;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r3 = r3 + 0x48;
        if(r1 >= r3) {
          r5 = MEMORY.ref(4, r6 + 0x4).get();
          r2 = 0x67ffff;
          if(r5 <= r2) {
            r0 = r1;
            r0 = r0 + CPU.r10().value;
            if(r0 < 0x0) {
              r0 = r0 + 0x3;
            }

            //LAB_80d6ca4
            r1 = 0x5;
            r0 = r0 >> 2;
            r0 = modS(r0, r1);
            r4 = 0x80ee916;
            r1 = r0 << 1;
            r1 = MEMORY.ref(2, r4 + r1).getUnsigned();
            r4 = 0x80ee920;
            r3 = 0x2;
            r2 = MEMORY.ref(2, r6 + r3).get();
            r3 = r5 >> 16;
            r5 = MEMORY.ref(1, r4 + r0).getUnsigned();
            r4 = r5 >>> 1;
            r2 = r2 - r4;
            r4 = 0x80ee925;
            r4 = MEMORY.ref(1, r4 + r0).getUnsigned();
            r0 = r4 >>> 1;
            r1 = r1 + CPU.r9().value;
            r3 = r3 - r0;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
            MEMORY.ref(4, CPU.sp().value).setu(r5);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r2 = 0x80;
            r0 = r6;
            r1 = 0x40;
            r2 = r2 << 5;
            FUN_80e3908(r0, r1, r2);
          }
        }

        //LAB_80d6ce2
        r4 = 0x1;
        CPU.r10().value = CPU.r10().value + r4;
        r0 = CPU.r10().value;
        r6 = r6 + 0x1c;
      } while(r0 != 0x10);
    }

    //LAB_80d6cee
    r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r1 == 0x80) {
      r5 = 0x7240;
      r2 = 0x0;
      CPU.r10().value = r2;
      r6 = 0xff;
      r5 = r5 + CPU.r9().value;

      //LAB_80d6cfe
      do {
        r0 = rand();
        r1 = 0x60;
        r0 = modU(r0, r1);
        r0 = r0 << 16;
        MEMORY.ref(4, r5).setu(r0);
        r0 = rand();
        r3 = 0x7;
        r3 = r3 & r0;
        r3 = r3 + 0x58;
        r3 = r3 << 16;
        MEMORY.ref(4, r5 + 0x4).setu(r3);
        r0 = rand();
        r0 = r0 & r6;
        r0 = r0 - 0x80;
        r0 = r0 << 11;
        MEMORY.ref(4, r5 + 0xc).setu(r0);
        r0 = rand();
        r0 = r0 & r6;
        r0 = -r0;
        r0 = r0 << 11;
        MEMORY.ref(4, r5 + 0x10).setu(r0);
        r0 = rand();
        r3 = 0xf;
        r3 = r3 & r0;
        r3 = -r3;
        r3 = r3 - 0x10;
        MEMORY.ref(4, r5 + 0x18).setu(r3);
        r3 = 0x1;
        CPU.r10().value = CPU.r10().value + r3;
        r4 = CPU.r10().value;
        r5 = r5 + 0x1c;
      } while(r4 != 0x30);

      r2 = 0x4000028;
      r3 = 0x0;
      MEMORY.ref(4, r2).setu(r3);
    }

    //LAB_80d6d52
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r0 = r0 - 0x80;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
    if((r0 & 0xffff_ffffL) <= (0x60 & 0xffff_ffffL)) {
      //LAB_80d6d5e
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0);
      if(r0 > 0x50) {
        r1 = 0x50;
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r1);
      } else {
        //LAB_80d6db8
        r2 = 0x77a8;
        r3 = 0x2;
        r2 = r2 + CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_80d6dc0
      r7 = 0xe1;
      r2 = 0x0;
      r7 = r7 << 7;
      CPU.r10().value = r2;
      r7 = r7 + CPU.r9().value;

      //LAB_80d6dca
      do {
        r3 = MEMORY.ref(4, r7 + 0x18).get();
        r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        if(r4 > r3) {
          //LAB_80d6dd4
          r0 = CPU.r10().value;
          CPU.r11().value = CPU.r9().value;
          if(r0 > 0x5) {
            r1 = 0xd8;
            r1 = r1 << 3;
            r1 = r1 + CPU.r9().value;
            CPU.r11().value = r1;
          }

          //LAB_80d6de4
          r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r2 = r4 - r3;
          r3 = MEMORY.ref(4, r7 + 0x10).get();
          r0 = r3;
          r0 = r0 * r2;
          MEMORY.ref(4, CPU.sp().value + 0x28).setu(r0);
          r6 = r0;
          if(r0 > 0xb8) {
            //LAB_80d6df6
            do {
              r6 = r6 - 0x40;
            } while(r6 > 0xb8);
          }

          //LAB_80d6dfc
          if(r6 <= 0x77) {
            r1 = 0x1;
            r0 = CPU.r10().value;
            r0 = r0 & r1;
            r1 = 0x18;
            r3 = MEMORY.ref(4, r7 + 0x4).get();
            r2 = MEMORY.ref(4, r7).get();
            MEMORY.ref(4, CPU.sp().value).setu(r1);
            r1 = 0x8;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r0 = r0 << 2;
            r3 = r3 - r6;
            r4 = MEMORY.ref(4, r0 + r1).get();
            r3 = r3 - 0x8;
            r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r1 = CPU.r11().value;
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }

          //LAB_80d6e24
          r3 = CPU.r10().value;
          r4 = 0x1;
          r3 = r3 & r4;
          r3 = r3 << 2;
          r2 = 0x0;
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
          CPU.r8().value = r2;

          //LAB_80d6e32
          do {
            r1 = MEMORY.ref(4, r7 + 0x4).get();
            r0 = CPU.r8().value;
            r3 = r0 << 6;
            r2 = r1 - r6;
            r5 = r2 + r3;
            r3 = 0x40;
            r3 = -r3;
            r2 = 0x0;
            r0 = 0x40;
            if(r5 >= r3) {
              if(r5 < 0) {
                r2 = -r5;
                r3 = r2 << 1;
                r0 = r5;
                r3 = r3 + r2;
                r2 = r3 << 3;
                r0 = r0 + 0x40;
                r5 = 0x0;
              }

              //LAB_80d6e5a
              r3 = r5 + r0;
              if(r3 > r1) {
                r3 = r3 - r1;
                r0 = r0 - r3;
              }

              //LAB_80d6e64
              r4 = CPU.r11().value;
              r3 = 0x18;
              r1 = r4 + r2;
              r2 = MEMORY.ref(4, r7).get();
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
              r1 = r1 + 0xc0;
              r4 = MEMORY.ref(4, r0 + r3).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              r3 = r5;
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }

            //LAB_80d6e80
            r4 = 0x1;
            CPU.r8().value = CPU.r8().value + r4;
            r0 = CPU.r8().value;
          } while(r0 != 0x3);

          r6 = CPU.r10().value;
          r6 = r6 & r4;
          if(r6 != 0) {
            r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r5 = MEMORY.ref(4, r7 + 0x4).get();
            r2 = 0x7f;
            r3 = r5 - r1;
            r3 = r3 & r2;
            r3 = r3 - 0x10;
            r1 = 0x3;
            r0 = CPU.r10().value;
            CPU.r8().value = r3;
            r0 = modS(r0, r1);
            r3 = 0x80ee930;
            r1 = r0;
            r4 = MEMORY.ref(1, r3 + r1).getUnsigned();
            r2 = CPU.r8().value;
            r3 = r2 + r4;
            CPU.r12().value = r4;
            if(r3 > r5) {
              r3 = r3 - r5;
              r4 = r4 - r3;
            }

            //LAB_80d6ebc
            if(r4 > 0) {
              r2 = 0x80ee92a;
              r3 = r1 << 1;
              r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
              r3 = CPU.r12().value;
              r2 = MEMORY.ref(4, r7).get();
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
              r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r0 = r6 << 2;
              r4 = MEMORY.ref(4, r0 + r3).get();
              r1 = r1 + CPU.r9().value;
              r2 = r2 + 0x8;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              r3 = CPU.r8().value;
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }
          }
        }

        //LAB_80d6ee0
        r4 = 0x1;
        CPU.r10().value = CPU.r10().value + r4;
        r0 = CPU.r10().value;
        r7 = r7 + 0x1c;
      } while(r0 != 0xa);
    }

    //LAB_80d6eee
    r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    if((r1 & 0xffff_ffffL) <= (0x5f & 0xffff_ffffL)) {
      r5 = 0xe8;
      r2 = 0x0;
      r5 = r5 << 7;
      CPU.r10().value = r2;
      r6 = 0xff;
      r5 = r5 + CPU.r9().value;

      //LAB_80d6f00
      do {
        r3 = MEMORY.ref(4, r5 + 0x18).get();
        if(r3 >= 0) {
          r1 = 0x5;
          r0 = CPU.r10().value;
          r0 = modS(r0, r1);
          r2 = 0x80ee934;
          r3 = r0 << 1;
          r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
          r3 = 0x2;
          r2 = MEMORY.ref(2, r5 + r3).get();
          r4 = 0x6;
          r3 = MEMORY.ref(2, r5 + r4).get();
          r4 = 0x80ee93e;
          r4 = MEMORY.ref(1, r4 + r0).getUnsigned();
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r4 = 0x80ee943;
          r0 = MEMORY.ref(1, r4 + r0).getUnsigned();
          r1 = r1 + CPU.r9().value;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = MEMORY.ref(4, r5).get();
          r2 = MEMORY.ref(4, r5 + 0xc).get();
          r3 = r3 + r2;
          MEMORY.ref(4, r5).setu(r3);
          r2 = MEMORY.ref(4, r5 + 0x4).get();
          r3 = MEMORY.ref(4, r5 + 0x10).get();
          r0 = 0x80;
          r0 = r0 << 7;
          r1 = 0xf0;
          r2 = r2 + r3;
          r1 = r1 << 15;
          r3 = r3 + r0;
          MEMORY.ref(4, r5 + 0x4).setu(r2);
          MEMORY.ref(4, r5 + 0x10).setu(r3);
          if((r2 & 0xffff_ffffL) > (r1 & 0xffff_ffffL)) {
            r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            if(r2 <= 0x9f) {
              r0 = rand();
              r1 = 0x60;
              r0 = modU(r0, r1);
              r0 = r0 << 16;
              MEMORY.ref(4, r5).setu(r0);
              r0 = rand();
              r3 = 0x7;
              r3 = r3 & r0;
              r3 = r3 + 0x58;
              r3 = r3 << 16;
              MEMORY.ref(4, r5 + 0x4).setu(r3);
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 - 0x80;
              r0 = r0 << 11;
              MEMORY.ref(4, r5 + 0xc).setu(r0);
              r0 = rand();
              r0 = r0 & r6;
              r0 = -r0;
              r0 = r0 << 11;
              MEMORY.ref(4, r5 + 0x10).setu(r0);
            }
          }

          //LAB_80d6f8c
          r3 = MEMORY.ref(4, r5 + 0x18).get();
        }

        //LAB_80d6f8e
        r3 = r3 + 0x1;
        MEMORY.ref(4, r5 + 0x18).setu(r3);
        r3 = 0x1;
        CPU.r10().value = CPU.r10().value + r3;
        r4 = CPU.r10().value;
        r5 = r5 + 0x1c;
      } while(r4 != 0x20);
    }

    //LAB_80d6f9e
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0xe0;
    if((r3 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
      r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      r3 = 0x3;
      r3 = r3 & r0;
      if(r3 == 0) {
        r2 = 0x1f;
        r4 = 0xa0;
        r1 = 0x0;
        r4 = r4 << 19;
        CPU.r10().value = r1;
        CPU.r8().value = r2;

        //LAB_80d6fbc
        do {
          r3 = MEMORY.ref(2, r4).getUnsigned();
          r7 = 0x1f;
          r7 = r7 & r3;
          r3 = r3 << 16;
          r0 = CPU.r8().value;
          r6 = r3 >>> 21;
          r5 = r3 >>> 26;
          r6 = r6 & r0;
          r5 = r5 & r0;
          r0 = r7 + r6;
          r0 = r0 + r5;
          r1 = 0x3;
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
          r0 = divideS(r0, r1);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          if(r7 > r0) {
            r7 = r7 - 0x1;
          }

          //LAB_80d7000
          if(r7 < r0) {
            r7 = r7 + 0x1;
          }

          //LAB_80d7006
          if(r6 > r0) {
            r6 = r6 - 0x1;
          }

          //LAB_80d700c
          if(r6 < r0) {
            r6 = r6 + 0x1;
          }

          //LAB_80d7012
          if(r5 > r0) {
            r5 = r5 - 0x1;
          }

          //LAB_80d7018
          if(r5 < r0) {
            r5 = r5 + 0x1;
          }

          //LAB_80d701e
          r2 = r6 << 5;
          r3 = r5 << 10;
          r1 = 0x1;
          r3 = r3 | r2;
          CPU.r10().value = CPU.r10().value + r1;
          r3 = r3 | r7;
          r2 = CPU.r10().value;
          MEMORY.ref(2, r4).setu(r3);
          r4 = r4 + 0x2;
        } while(r2 != 0x40);
      }
    }

    //LAB_80d7034
    r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    if((r3 & 0xffff_ffffL) <= (0xac & 0xffff_ffffL)) {
      r2 = 0x7828;
      r0 = CPU.r9().value;
      r3 = MEMORY.ref(4, r0 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r4 = 0x0;
      CPU.r10().value = r4;
      if(r3 != 0) {
        r1 = CPU.sp().value + 0x4c;
        CPU.r8().value = r1;
        r6 = CPU.sp().value + 0x58;
        CPU.r11().value = r4;

        //LAB_80d7052
        do {
          r4 = CPU.r10().value;
          r3 = CPU.r9().value;
          r2 = MEMORY.ref(4, r3 + r2).get();
          r3 = r4 << 1;
          r3 = r3 + 0x24;
          r0 = MEMORY.ref(2, r2 + r3).get();
          r0 = FUN_80b5098(r0);
          r2 = MEMORY.ref(4, r0).get();
          r3 = MEMORY.ref(4, r2 + 0x8).get();
          MEMORY.ref(4, r6).setu(r3);
          r3 = MEMORY.ref(4, r2 + 0xc).get();
          MEMORY.ref(4, r6 + 0x4).setu(r3);
          r3 = MEMORY.ref(4, r2 + 0x10).get();
          r0 = r6;
          MEMORY.ref(4, r6 + 0x8).setu(r3);
          r1 = CPU.r8().value;
          r0 = FUN_80e3944(r0, r1);
          r2 = CPU.r11().value;
          r3 = r2 << 3;
          r3 = r3 - r2;
          r3 = r3 << 2;
          r4 = 0x7240;
          r3 = r3 + CPU.r9().value;
          r7 = 0x0;
          r5 = r3 + r4;

          //LAB_80d7088
          do {
            r0 = MEMORY.ref(4, r5 + 0x18).get();
            if(r0 == 0) {
              r0 = rand();
              r1 = 0xf;
              r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
              r0 = r0 & r1;
              r3 = r3 + r0;
              r3 = r3 - 0x8;
              MEMORY.ref(4, r5).setu(r3);
              r0 = rand();
              r2 = 0xf;
              r3 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
              r0 = r0 & r2;
              r3 = r3 + r0;
              r3 = r3 - 0x28;
              MEMORY.ref(4, r5 + 0x4).setu(r3);
              r0 = MEMORY.ref(4, r5 + 0x18).get();
            }

            //LAB_80d70b0
            if((r0 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL)) {
              r2 = 0x80ee948;
              r3 = r0 << 1;
              r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
              r3 = 0x80ee952;
              r0 = MEMORY.ref(1, r3 + r0).getUnsigned();
              r2 = MEMORY.ref(4, r5).get();
              r3 = MEMORY.ref(4, r5 + 0x4).get();
              r4 = r0 >>> 1;
              r2 = r2 - r4;
              r3 = r3 - r4;
              MEMORY.ref(4, CPU.sp().value).setu(r0);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r1 = r1 + CPU.r9().value;
              r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r0 = MEMORY.ref(4, r5 + 0x18).get();
            }

            //LAB_80d70d8
            r3 = r0 + 0x1;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            if(r4 <= 0xc7) {
              if(r3 == 0x5) {
                r0 = rand();
                r3 = 0x7;
                r3 = r3 & r0;
                r3 = -r3;
                MEMORY.ref(4, r5 + 0x18).setu(r3);
              }
            }

            //LAB_80d70f2
            r7 = r7 + 0x1;
            r5 = r5 + 0x1c;
          } while(r7 != 0x6);

          r2 = 0x7828;
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r1 = 0x1;
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r0 = 0x6;
          CPU.r10().value = CPU.r10().value + r1;
          CPU.r11().value = CPU.r11().value + r0;
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d710e
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r0 > 0xe8) {
      r1 = 0xfffffe10;
      r3 = r0 << 1;
      r6 = r3 + r1;
      r2 = 0x0;
      r3 = 0x0;
      CPU.r10().value = r2;
      CPU.r12().value = r3;
      r4 = r6;

      //LAB_80d7124
      do {
        r7 = 0x0;

        //LAB_80d7126
        do {
          if((r4 & 0xffff_ffffL) <= (0x7f & 0xffff_ffffL)) {
            r5 = 0x7;
            r0 = r4;
            r0 = r0 & r5;
            r3 = r0 << 5;
            r3 = r3 + CPU.r10().value;
            r1 = 0x2010000;
            r3 = r3 << 2;
            r3 = r3 + r7;
            r3 = r3 + r1;
            r1 = MEMORY.ref(1, r3).getUnsigned();
            r3 = r4;
            if(r4 < 0) {
              r3 = r4 + 0x7;
            }

            //LAB_80d7146
            r3 = r3 >> 3;
            r2 = r1;
            if(r1 < 0) {
              r2 = r1 + 0x7;
            }

            //LAB_80d7150
            r2 = r2 >> 3;
            r3 = r3 << 4;
            r3 = r3 + r2;
            r3 = r3 << 3;
            r3 = r3 + r0;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r1 = r1 & r5;
            r3 = r3 << 3;
            r3 = r3 + r1;
            r3 = r2 + r3;
            r0 = CPU.r12().value;
            MEMORY.ref(1, r3).setu(r0);
          }

          //LAB_80d7168
          r7 = r7 + 0x1;
        } while(r7 != 0x4);

        r1 = 0x1;
        CPU.r10().value = CPU.r10().value + r1;
        r2 = CPU.r10().value;
        r4 = r4 + 0x1;
      } while(r2 != 0x20);

      r4 = 0x0;
      r3 = 0x0;
      CPU.lr().value = r4;
      CPU.r10().value = r3;
      r4 = r6 + 0x1;

      //LAB_80d7184
      do {
        r7 = 0x0;
        CPU.r12().value = r4;

        //LAB_80d7188
        do {
          if((r4 & 0xffff_ffffL) <= (0x7f & 0xffff_ffffL)) {
            r5 = 0x7;
            r0 = CPU.r12().value;
            r0 = r0 & r5;
            r3 = r0 << 5;
            r3 = r3 + CPU.r10().value;
            r1 = 0x2010000;
            r3 = r3 << 2;
            r3 = r3 + r7;
            r3 = r3 + r1;
            r1 = MEMORY.ref(1, r3).getUnsigned();
            r3 = CPU.r12().value;
            if(r3 < 0) {
              r3 = r3 + 0x7;
            }

            //LAB_80d71a8
            r3 = r3 >> 3;
            r2 = r1;
            if(r1 < 0) {
              r2 = r1 + 0x7;
            }

            //LAB_80d71b2
            r2 = r2 >> 3;
            r3 = r3 << 4;
            r3 = r3 + r2;
            r3 = r3 << 3;
            r3 = r3 + r0;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r1 = r1 & r5;
            r3 = r3 << 3;
            r3 = r3 + r1;
            r3 = r2 + r3;
            r0 = CPU.lr().value;
            MEMORY.ref(1, r3).setu(r0);
          }

          //LAB_80d71ca
          r7 = r7 + 0x1;
        } while(r7 != 0x4);

        r1 = 0x1;
        CPU.r10().value = CPU.r10().value + r1;
        r2 = CPU.r10().value;
        r4 = r4 + 0x1;
      } while(r2 != 0x20);
    }

    //LAB_80d71dc
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0xa1;
    if((r3 & 0xffff_ffffL) <= (0x3e & 0xffff_ffffL)) {
      r2 = 0x7828;
      r3 = 0x0;
      r4 = CPU.r9().value;
      CPU.r10().value = r3;
      r3 = MEMORY.ref(4, r4 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0) {
        //LAB_80d71f4
        do {
          r0 = CPU.r10().value;
          r3 = r0 << 3;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r3 = r3 + 0xa0;
          if(r1 > r3) {
            r3 = CPU.r9().value;
            r2 = MEMORY.ref(4, r3 + r2).get();
            r3 = r0 << 1;
            r3 = r3 + 0x24;
            r0 = MEMORY.ref(2, r2 + r3).get();
            r0 = FUN_80b5098(r0);
            r6 = r0;
            r2 = MEMORY.ref(4, r6).get();
            r0 = 0x80;
            r3 = MEMORY.ref(4, r2 + 0xc).get();
            r0 = r0 << 12;
            r1 = 0x80;
            r3 = r3 + r0;
            r1 = r1 << 16;
            MEMORY.ref(4, r2 + 0xc).setu(r3);
            if(r3 > r1) {
              MEMORY.ref(4, r2 + 0xc).setu(r1);
            }

            //LAB_80d7226
            r3 = 0x0;
            r5 = 0x0;
            MEMORY.ref(4, r2 + 0x48).setu(r3);

            //LAB_80d7250
            do {
              final Sprite38 sprite = FUN_80b50d8(MEMORY.ref(4, r6).get(), r5);
              if(sprite == null) {
                break;
              }

              //LAB_80d7248
              setSpriteAnimation_(sprite, 5);
              r5 = r5 + 0x1;
            } while(true);
          }

          //LAB_80d725c
          r2 = 0x7828;
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r1 = 0x1;
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          CPU.r10().value = CPU.r10().value + r1;
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d726c
    r2 = 0x7828;
    r1 = CPU.r9().value;
    r3 = MEMORY.ref(4, r1 + r2).get();
    r3 = MEMORY.ref(4, r3 + 0x14).get();
    r0 = 0x0;
    CPU.r10().value = r0;
    if(r3 != 0) {
      r5 = 0x8f;
      r7 = 0x8;
      r6 = 0x24;
      r5 = r5 << 1;

      //LAB_80d7284
      do {
        r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        if(r3 == r5) {
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r0 = MEMORY.ref(2, r3 + r6).get();
          r0 = FUN_80b5098(r0);
          r3 = 0xc0;
          r2 = MEMORY.ref(4, r0).get();
          r3 = r3 << 15;
          MEMORY.ref(4, r2 + 0xc).setu(r3);
          r3 = 0xab85;
          MEMORY.ref(4, r2 + 0x48).setu(r3);
        }

        //LAB_80d72a0
        r3 = r5;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r3 = r3 + 0x10;
        if(r2 == r3) {
          r3 = 0x7828;
          r3 = r3 + CPU.r9().value;
          r3 = MEMORY.ref(4, r3).get();
          r2 = 0x1;
          r0 = MEMORY.ref(2, r3 + r6).get();
          r1 = 0x7;
          r3 = CPU.r10().value;
          r2 = -r2;
          MEMORY.ref(4, CPU.sp().value).setu(r7);
          FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
          r0 = 0x86;
          playSound_(r0);
          r3 = 0x77a8;
          r3 = r3 + CPU.r9().value;
          MEMORY.ref(4, r3).setu(r7);
        }

        //LAB_80d72cc
        r2 = 0x7828;
        r1 = CPU.r9().value;
        r3 = MEMORY.ref(4, r1 + r2).get();
        r0 = 0x1;
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        CPU.r10().value = CPU.r10().value + r0;
        r6 = r6 + 0x2;
        r5 = r5 + 0x5;
      } while(CPU.r10().value != r3);
    }

    //LAB_80d72e0
    r3 = 0x97;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 << 1;
    if(r2 == r3) {
      //LAB_80d72ec
      r0 = 0x2f;
      freeSlot(r0);
      r0 = 0x2e;
      freeSlot(r0);
      r0 = 0x98;
      r1 = CPU.r9().value;
      r2 = 0x1;
      r3 = 0x0;
      FUN_80e0524(r0, r1, r2, r3);
      r1 = 0xb4;
      r1 = r1 << 5;
      r0 = 0xc0;
      r1 = r1 + CPU.r9().value;
      r2 = 0x1;
      r3 = 0x1;
      FUN_80e0524(r0, r1, r2, r3);
      r6 = 0x2;
      r1 = 0x7;
      r2 = 0x7;
      r3 = 0x3;
      r0 = 0x2e;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r5 = 0x3001e50;
      r3 = r5;
      r3 = r3 + 0xb8;
      r3 = MEMORY.ref(4, r3).get();
      r1 = 0x7;
      MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
      r2 = 0x7;
      r3 = 0x7;
      r0 = 0x2f;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r5 = r5 + 0xbc;
      r4 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      r3 = MEMORY.ref(4, r5).get();
      r2 = 0x4000050;
      MEMORY.ref(4, r4 + 0x4).setu(r3);
      r3 = 0x3f46;
      MEMORY.ref(2, r2).setu(r3);
      r3 = 0x80;
      r2 = r2 - 0x30;
      MEMORY.ref(2, r2).setu(r3);
      r2 = r2 + 0x8;
      r3 = 0x0;
      MEMORY.ref(4, r2).setu(r3);
      r3 = 0xef;
      r3 = r3 << 7;
      r2 = 0x7784;
      r3 = r3 + CPU.r9().value;
      MEMORY.ref(4, r3).setu(r6);
      r2 = r2 + CPU.r9().value;
      r3 = 0x4b;
      r1 = 0x90;
      MEMORY.ref(4, r2).setu(r3);
      r1 = r1 << 3;
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), r1);
      r2 = 0x7828;
      r1 = CPU.r9().value;
      r3 = MEMORY.ref(4, r1 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r0 = 0x0;
      CPU.r10().value = r0;

      if(r3 != 0) {
        //LAB_80d73b0
        do {
          r4 = CPU.r10().value;
          r3 = CPU.r9().value;
          r2 = MEMORY.ref(4, r3 + r2).get();
          r3 = r4 << 1;
          r3 = r3 + 0x24;
          r0 = MEMORY.ref(2, r2 + r3).get();
          r0 = FUN_80b5098(r0);
          r3 = CPU.r10().value;
          r2 = r3 << 2;
          r2 = r2 + CPU.r10().value;
          r3 = r2 << 3;
          r3 = r3 - r2;
          r0 = MEMORY.ref(4, r0).get();
          r3 = r3 << 3;
          r4 = 0xe1;
          r3 = r3 + CPU.r9().value;
          r4 = r4 << 7;
          CPU.r8().value = r0;
          r7 = 0x0;
          r6 = r3 + r4;

          //LAB_80d73da
          do {
            r0 = CPU.r8().value;
            r3 = MEMORY.ref(4, r0 + 0x8).get();
            MEMORY.ref(4, r6).setu(r3);
            r3 = 0xa0;
            r3 = r3 << 13;
            MEMORY.ref(4, r6 + 0x4).setu(r3);
            r3 = MEMORY.ref(4, r0 + 0x10).get();
            MEMORY.ref(4, r6 + 0x8).setu(r3);
            r3 = 0x3334;
            r5 = r7;
            r5 = r5 * r3;
            r0 = r5;
            r0 = sin(r0);
            r0 = r0 << 2;
            MEMORY.ref(4, r6 + 0xc).setu(r0);
            r0 = rand();
            r3 = 0x7fff;
            r1 = 0x80;
            r3 = r3 & r0;
            r1 = r1 << 9;
            r3 = r3 + r1;
            MEMORY.ref(4, r6 + 0x10).setu(r3);
            r0 = r5;
            r0 = cos(r0);
            r7 = r7 + 0x1;
            r0 = r0 << 2;
            r3 = 0x0;
            MEMORY.ref(4, r6 + 0x14).setu(r0);
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r6 = r6 + 0x1c;
          } while(r7 != 0xa);

          r2 = 0x1;
          CPU.r10().value = CPU.r10().value + r2;
          r2 = 0x7828;
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d7430
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r1 = 0x12d;
    if(r0 > r1) {
      //LAB_80d743a
      r2 = 0x0;
      CPU.r10().value = r2;
      r2 = 0x7828;
      r4 = CPU.r9().value;
      r3 = MEMORY.ref(4, r4 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0) {
        //LAB_80d744c
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r3 = 0xfffffed2;
        r0 = CPU.sp().value;
        r0 = r0 + 0x4c;
        r3 = r1 + r3;
        r4 = 0x97;
        r1 = CPU.sp().value;
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
        r4 = r4 << 1;
        r0 = 0x0;
        r1 = r1 + 0x58;
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);

        //LAB_80d746a
        do {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          if(r3 >= r4) {
            r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r1 = 0x9d;
            r1 = r1 << 1;
            r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            r3 = r0 + r1;
            if(r4 < r3) {
              r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r1 = CPU.r9().value;
              r4 = CPU.r10().value;
              r2 = MEMORY.ref(4, r1 + r2).get();
              r3 = r4 << 1;
              r3 = r3 + 0x24;
              r6 = r0 >>> 31;
              r6 = r0 + r6;
              r0 = MEMORY.ref(2, r2 + r3).get();
              r0 = FUN_80b5098(r0);
              r2 = MEMORY.ref(4, r0).get();
              r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r3 = MEMORY.ref(4, r2 + 0x8).get();
              MEMORY.ref(4, r4).setu(r3);
              r3 = 0x0;
              MEMORY.ref(4, r4 + 0x4).setu(r3);
              r3 = MEMORY.ref(4, r2 + 0x10).get();
              MEMORY.ref(4, r4 + 0x8).setu(r3);
              r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              CPU.r8().value = r0;
              r1 = CPU.r8().value;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r0 = FUN_80e3944(r0, r1);
              r6 = r6 >> 1;
              r1 = CPU.r8().value;
              r2 = MEMORY.ref(4, r1).get();
              r5 = r6 << 4;
              r5 = r5 - r6;
              r3 = MEMORY.ref(4, r1 + 0x4).get();
              r2 = r2 >> 1;
              r5 = r5 << 5;
              MEMORY.ref(4, r1).setu(r2);
              r5 = r5 + CPU.r9().value;
              r4 = 0x14;
              r0 = 0x18;
              r2 = r2 - 0x14;
              r3 = r3 - 0x18;
              MEMORY.ref(4, CPU.sp().value).setu(r4);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
              r1 = r5;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r1 = CPU.r8().value;
              r4 = 0x14;
              r0 = 0x18;
              r3 = MEMORY.ref(4, r1 + 0x4).get();
              r2 = MEMORY.ref(4, r1).get();
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              MEMORY.ref(4, CPU.sp().value).setu(r4);
              r3 = r3 - 0x18;
              r4 = MEMORY.ref(4, r1 + 0x4).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              r1 = r5;
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }
          }

          //LAB_80d74f8
          r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r3 = r3 + 0x6;
          if(r2 >= r3) {
            r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r3 = CPU.sp().value + 0x4c;
            r2 = r2 + CPU.r10().value;
            CPU.r8().value = r3;
            r3 = r2 << 3;
            r3 = r3 - r2;
            r3 = r3 << 3;
            r4 = 0xe1;
            r3 = r3 + CPU.r9().value;
            r4 = r4 << 7;
            r0 = 0xc;
            r7 = 0x0;
            r6 = CPU.r8().value;
            r5 = r3 + r4;
            CPU.r11().value = r0;

            //LAB_80d7520
            do {
              r0 = r5;
              r1 = r6;
              r0 = FUN_80e3944(r0, r1);
              r3 = MEMORY.ref(4, r6).get();
              r2 = r3 >> 1;
              MEMORY.ref(4, r6).setu(r2);
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              CPU.cmpT(r3, 0x1a);
              if((r3 & 0xffff_ffffL) <= (0x1a & 0xffff_ffffL)) {
                r3 = 0x80ee958;
                r4 = CPU.r11().value;
                r1 = MEMORY.ref(2, r3 + r4).getUnsigned();
                r3 = 0x80ee966;
                r4 = MEMORY.ref(2, r3 + r4).getUnsigned();
                r3 = CPU.r8().value;
                r3 = MEMORY.ref(4, r3 + 0x4).get();
                r0 = r4 >>> 1;
                r2 = r2 - r0;
                r3 = r3 - r0;
                MEMORY.ref(4, CPU.sp().value).setu(r4);
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
                r1 = r1 + CPU.r9().value;
                r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
                MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              }

              //LAB_80d7556
              r2 = 0x80;
              r0 = r5;
              r1 = 0x3c;
              r2 = r2 << 5;
              FUN_80e3908(r0, r1, r2);
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              r7 = r7 + 0x1;
              r3 = r3 + 0x1;
              MEMORY.ref(4, r5 + 0x18).setu(r3);
              r5 = r5 + 0x1c;
            } while(r7 != 0x5);
          }

          //LAB_80d7570
          r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r4 = r4 - 0x4;
          r2 = 0x1;
          r0 = r0 + 0x4;
          r1 = r1 + 0x4;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r4);
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
          CPU.r10().value = CPU.r10().value + r2;
          r2 = 0x7828;
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d7594
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r0 <= 0x7f) {
      r0 = 0x4;
      r1 = 0x10;
      FUN_80e155c(r0, r1);
    } else {
      //LAB_80d75a4
      r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      r2 = 0x12d;
      if(r1 <= r2) {
        r0 = 0x2;
        r1 = 0x2;
        FUN_80e155c(r0, r1);
      } else {
        //LAB_80d75b6
        r0 = 0x4;
        r1 = 0x8;
        FUN_80e155c(r0, r1);
      }
    }

    //LAB_80d75be
    FUN_80cd52c();
    r2 = 0x7824;
    r3 = 0x1;
    r2 = r2 + CPU.r9().value;
    MEMORY.ref(4, r2).setu(r3);
    r0 = 0x1;
    sleep(r0);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r4 = 0xb7;
    r3 = r3 + 0x1;
    r4 = r4 << 1;
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
    if(r3 != r4) {
      FUN_80d6b76();
    }

    //LAB_80d75e2
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    r0 = 0x2f;
    freeSlot(r0);
    r0 = 0x2e;
    freeSlot(r0);
    r0 = 0x86;
    FUN_80b50e8(r0);
    r1 = 0x80;
    r0 = 0x2;
    r1 = r1 << 16;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
    r5 = 0x77d8;
    FUN_80e6eac(r0, r1, r2);
    r0 = 0x0;
    CPU.r10().value = r0;
    r5 = r5 + CPU.r9().value;

    //LAB_80d760e
    do {
      clearSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new));
      r5 += 0x4;
      CPU.r10().value++;
    } while(CPU.r10().value < 8);

    FUN_80cdbc0();
    CPU.sp().value += 0x64;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80d6b76)
  public static void FUN_80d6b76() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80d765c)
  public static void FUN_80d765c(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80dc968)
  public static void FUN_80dc968(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80dbb24)
  public static void FUN_80dbb24(final int r0, final int r1, int r2) {
    final int r3;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001eec;
    CPU.r8().value = r0;
    CPU.r9().value = r1;
    r7 = MEMORY.ref(4, r3).get();
    r6 = 0x0;
    if(r0 != 0) {
      r2 = r2 & 0x3;
      r2 = r2 << 2;
      r5 = 0x77d8;
      CPU.r10().value = r2;

      //LAB_80dbb50
      do {
        final Sprite38 sprite = loadSprite_(CPU.r9().value);
        MEMORY.ref(4, r5 + r7).setu(sprite != null ? sprite.getAddress() : 0);
        if(sprite != null) {
          sprite._26.set(0);
          setSpriteAnimation_(sprite, r6);
          r2 = MEMORY.ref(4, r5 + r7).get();
          MEMORY.ref(1, r2 + 0x9).and(~0xc).or(CPU.r10().value);
        }

        //LAB_80dbb78
        r6 = r6 + 0x1;
        r5 = r5 + 0x4;
      } while(r6 != CPU.r8().value);
    }

    //LAB_80dbb80
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }
}