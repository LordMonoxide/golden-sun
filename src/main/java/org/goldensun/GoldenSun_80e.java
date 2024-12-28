package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.Sprite38;

import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.drawSprite_;
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
import static org.goldensun.GoldenSun_80b.FUN_80b5040;
import static org.goldensun.GoldenSun_80b.FUN_80b5088;
import static org.goldensun.GoldenSun_80b.FUN_80b50a8;
import static org.goldensun.GoldenSun_80b.FUN_80b50e8;
import static org.goldensun.GoldenSun_80c.FUN_80c9048;
import static org.goldensun.GoldenSun_80c.FUN_80cd104;
import static org.goldensun.GoldenSun_80c.FUN_80cd52c;
import static org.goldensun.GoldenSun_80c.FUN_80cd594;
import static org.goldensun.GoldenSun_80c.FUN_80cdbc0;
import static org.goldensun.GoldenSun_80d.FUN_80d6750;
import static org.goldensun.GoldenSun_80d.FUN_80d67dc;
import static org.goldensun.GoldenSun_80d.FUN_80d6888;
import static org.goldensun.GoldenSun_80d.FUN_80dbb24;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80e {
  private GoldenSun_80e() { }

  @Method(0x80e0524)
  public static void FUN_80e0524(final int pointerTableIndex, final int dst, final int r2, final int r3) {
    int r6 = getPointerTableEntry(pointerTableIndex);
    if(r3 != 0) {
      MEMORY.call(0x3001388, 0x5000000, r6, 0x80); // memcpy
    }

    //LAB_80e0548
    if(r2 != 0) {
      r6 += 0x80;
    }

    //LAB_80e054e
    decompress(r6, dst);
  }

  @Method(0x80e155c)
  public static void FUN_80e155c(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);
    r3 = 0x3001eec;
    r6 = r0;
    r7 = r1;
    r0 = 0x77a8;
    r1 = MEMORY.ref(4, r3).get();
    r0 = r0 + r1;
    r3 = MEMORY.ref(4, r0).get();
    CPU.r8().value = r0;
    if(r3 > 0) {
      r0 = rand();
      r6 = r6 - 0x1;
      r6 = r6 & r0;
      r0 = rand();
      r5 = r7 >>> 31;
      r5 = r7 + r5;
      r2 = r7 - 0x1;
      r5 = r5 >> 1;
      r2 = r2 & r0;
      r2 = r2 - r5;
      r1 = 0x3001ad0;
      r3 = r2;
      r6 = r6 - r5;
      r3 = r3 + 0x20;
      MEMORY.ref(2, r1 + 0x4).setu(r6);
      MEMORY.ref(2, r1 + 0x6).setu(r3);
      r1 = 0x3001ce0;
      r3 = 0x78;
      r6 = r3 - r6;
      r3 = r3 - r2;
      MEMORY.ref(4, r1 + 0xc).setu(r6);
      MEMORY.ref(4, r1 + 0x10).setu(r3);
      r2 = CPU.r8().value;
      r3 = MEMORY.ref(4, r2).get();
      r3 = r3 - 0x1;
      MEMORY.ref(4, r2).setu(r3);
    } else {
      //LAB_80e15b0
      r0 = 0x77a0;
      r3 = r1 + r0;
      r3 = MEMORY.ref(4, r3).get();
      r2 = 0x3001ad0;
      r0 = r0 + 0x4;
      MEMORY.ref(2, r2 + 0x4).setu(r3);
      r3 = r1 + r0;
      r3 = MEMORY.ref(4, r3).get();
      MEMORY.ref(2, r2 + 0x6).setu(r3);
      r2 = 0x3001ce0;
      r3 = 0x78;
      MEMORY.ref(4, r2 + 0xc).setu(r3);
      MEMORY.ref(4, r2 + 0x10).setu(r3);
    }

    //LAB_80e15ca
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  @Method(0x80e15e8)
  public static void FUN_80e15e8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80e3908)
  public static void FUN_80e3908(int r0, int r1, final int r2) {
    int r3;
    final int r4;
    final int r5;

    r4 = r0;
    r3 = MEMORY.ref(4, r4).get();
    r0 = MEMORY.ref(4, r4 + 0xc).get();
    r3 = r3 + r0;
    r5 = r1;
    MEMORY.ref(4, r4).setu(r3);
    r1 = MEMORY.ref(4, r4 + 0x10).get();
    r3 = MEMORY.ref(4, r4 + 0x4).get();
    r3 = r3 + r1;
    MEMORY.ref(4, r4 + 0x4).setu(r3);
    r3 = r5;
    r3 = r3 * r0;
    r1 = r1 + r2;
    MEMORY.ref(4, r4 + 0x10).setu(r1);
    if(r3 < 0) {
      r3 = r3 + 0x3f;
    }

    //LAB_80e392c
    r1 = r1 * r5;
    r3 = r3 >> 6;
    MEMORY.ref(4, r4 + 0xc).setu(r3);
    if(r1 < 0) {
      r1 = r1 + 0x3f;
    }

    //LAB_80e3938
    r3 = r1 >> 6;
    MEMORY.ref(4, r4 + 0x10).setu(r3);
  }

  @Method(0x80e3944)
  public static int FUN_80e3944(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80e3980)
  public static void FUN_80e3980(final int r0, final int r1) {
    FUN_80b50a8(r0, r1);
    MEMORY.ref(4, r1 + 0x4).subu(0x10);
  }

  @Method(0x80e6d3c)
  public static void FUN_80e6d3c(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001eec;
    CPU.r10().value = r2;
    r2 = MEMORY.ref(4, r3).get();
    r3 = 0x80edab8;
    r4 = MEMORY.ref(4, r3 + 0x4).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x20;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
    r3 = 0x80edac0;
    r4 = MEMORY.ref(4, r3 + 0x4).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.r9().value = r1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
    r1 = CPU.sp().value + 0x10;
    r3 = 0x0;
    MEMORY.ref(4, r1 + 0xc).setu(r3);
    r3 = 0xff;
    r3 = r3 << 16;
    MEMORY.ref(4, r1 + 0x4).setu(r3);
    if(r0 == 0) {
      //LAB_80e6d88
      r3 = CPU.sp().value + 0x8;
      CPU.r8().value = r3;
      r3 = 0x77d8;
      r5 = 0x0;
      r7 = r1;
      r6 = r2 + r3;

      //LAB_80e6d94
      do {
        r0 = r5;
        r1 = 0x3;
        r0 = modS(r0, r1);
        r0 = r0 << 21;
        r0 = r0 + CPU.r9().value;
        MEMORY.ref(4, r7).setu(r0);
        r0 = divideS(r5, 3);
        r0 = r0 << 21;
        r0 = r0 + CPU.r10().value;
        MEMORY.ref(4, r7 + 0x8).setu(r0);
        drawSprite_(MEMORY.ref(4, r6).deref(4).cast(Sprite38::new), r7, CPU.r8().value, 0);
        r6 += 0x4;
        r5++;
      } while(r5 < 9);
    } else if(r0 == 0x1) {
      //LAB_80e6dc4
      r3 = CPU.sp().value + 0x8;
      CPU.r8().value = r3;
      r3 = 0x77d8;
      r5 = 0x0;
      r6 = r1;
      r7 = r2 + r3;

      //LAB_80e6dd0
      do {
        r3 = 0x80eee1e;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r9().value;
        r3 = r3 - 0x100000;
        MEMORY.ref(4, r6).setu(r3);
        r3 = 0x80eee2a;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r10().value;
        r3 = r3 - 0x200000;
        MEMORY.ref(4, r6 + 0x8).setu(r3);
        drawSprite_(MEMORY.ref(4, r7).deref(4).cast(Sprite38::new), r6, CPU.r8().value, 0);
        r7 += 0x4;
        r5++;
      } while(r5 < 12);
    } else if(r0 == 0x2) {
      //LAB_80e6e00
      r3 = CPU.sp().value + 0x8;
      CPU.r8().value = r3;
      r3 = 0x77d8;
      r5 = 0x0;
      r6 = r1;
      r7 = r2 + r3;

      //LAB_80e6e0c
      do {
        r3 = 0x80eee36;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r9().value;
        r3 = r3 + 0x100000;
        MEMORY.ref(4, r6).setu(r3);
        r3 = 0x80eee3e;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r10().value;
        MEMORY.ref(4, r6 + 0x8).setu(r3);
        drawSprite_(MEMORY.ref(4, r7).deref(4).cast(Sprite38::new), r6, CPU.r8().value, 0);
        r7 += 0x4;
        r5++;
      } while(r5 < 8);
    } else if(r0 == 0x3) {
      //LAB_80e6e3a
      r3 = 0x77d8;
      r5 = 0x0;
      CPU.r8().value = CPU.sp().value;
      r6 = r1;
      r7 = r2 + r3;

      //LAB_80e6e44
      do {
        r3 = 0x80eee46;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r9().value;
        MEMORY.ref(4, r6).setu(r3);
        r3 = 0x80eee4e;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r10().value;
        MEMORY.ref(4, r6 + 0x8).setu(r3);
        drawSprite_(MEMORY.ref(4, r7).deref(4).cast(Sprite38::new), r6, CPU.r8().value, 0);
        r7 += 0x4;
        r5++;
      } while(r5 < 8);
    }

    //LAB_80e6e6a
    CPU.sp().value += 0x20;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x80ed408)
  public static int FUN_80ed408(int r0, int r1, int r2, int r3, final int a4) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x10;
    CPU.r9().value = r1;
    CPU.r10().value = a4;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
    r2 = CPU.r10().value;
    CPU.r8().value = r3;
    r1 = 0x3;
    if(r2 == 0x3) {
      r1 = 0x6;
    }

    //LAB_80ed42c
    r3 = 0xc;
    r2 = CPU.r8().value;
    r3 = r3 & r2;
    if(r3 == 0x4) {
      r1 = r1 + 0x3;
    }

    //LAB_80ed438
    if(r3 == 0x8) {
      r1 = r1 + 0x4;
    }

    //LAB_80ed43e
    if(r3 == 0xc) {
      r1 = r1 + 0x3;
    }

    //LAB_80ed444
    if(r3 == 0) {
      r1 = r1 + 0x1;
    }

    //LAB_80ed44a
    r3 = 0x2;
    r2 = CPU.r8().value;
    r3 = r3 & r2;
    if(r3 != 0) {
      r1 = r1 + 0x7;
    }

    //LAB_80ed456
    r3 = 0x1;
    r2 = CPU.r8().value;
    r3 = r3 & r2;
    r1 = r1 + 0x2;
    if(r3 == 0) {
      r1 = r1 + 0x1;
    }

    //LAB_80ed464
    if(r3 != 0) {
      r1 = r1 + 0x2;
      r1 = r1 + 0x2;
      r1 = r1 + 0x5;
    }

    //LAB_80ed46e
    r3 = 0x1;
    r2 = CPU.r8().value;
    r3 = r3 & r2;
    r1 = r1 + 0x9;
    if(r3 == 0) {
      r1 = r1 + 0x1;
    }

    //LAB_80ed47c
    r1 = r1 + 0x9;
    if(r3 == 0) {
      r1 = r1 + 0x1;
    }

    //LAB_80ed484
    r3 = CPU.r10().value;
    r1 = r1 + 0x3;
    if(r3 == 0x1) {
      //LAB_80ed49c
      r1 = r1 + 0x4;
    } else if(r3 == 0x2) {
      //LAB_80ed49c
      r1 = r1 + 0x4;
    } else if(r3 == 0x3) {
      //LAB_80ed4a0
      r1 = r1 + 0x6;
    } else {
      //LAB_80ed498
      r1 = r1 + 0x2;
    }

    //LAB_80ed4a2
    r3 = 0x1;
    r2 = CPU.r8().value;
    r3 = r3 & r2;
    r1 = r1 + 0x3;
    if(r3 == 0) {
      r1 = r1 + 0x2;
    }

    //LAB_80ed4b0
    r3 = CPU.r10().value;
    r1 = r1 + 0x2;
    if(r3 == 0x1) {
      //LAB_80ed4d0
      r1 = r1 + 0x19;
    } else if(r3 == 0x2) {
      //LAB_80ed4d4
      r1 = r1 + 0x20;
    } else if(r3 == 0x3) {
      //LAB_80ed4d8
      r1 = r1 + 0x1c;
    } else {
      //LAB_80ed4c4
      r3 = 0x0;

      //LAB_80ed4c6
      do {
        r3 = r3 + 0x1;
        r1 = r1 + 0x2;
      } while(r3 <= 0x7);
    }

    //LAB_80ed4da
    r3 = 0x1;
    r2 = CPU.r8().value;
    r3 = r3 & r2;
    r1 = r1 + 0x1;
    if(r3 == 0) {
      r1 = r1 + 0x2;
    }

    //LAB_80ed4e8
    r3 = CPU.r10().value;
    r1 = r1 + 0x5;
    if(r3 == 0x1) {
      //LAB_80ed500
      r1 = r1 + 0x4;
    } else if(r3 == 0x2) {
      //LAB_80ed500
      r1 = r1 + 0x4;
    } else if(r3 == 0x3) {
      //LAB_80ed504
      r1 = r1 + 0x6;
    } else {
      //LAB_80ed4fc
      r1 = r1 + 0x2;
    }

    //LAB_80ed506
    r1 = r1 + 0x8;
    r1 = r1 << 2;
    r0 = mallocSlotChip(r0, r1);
    r6 = 0x80edcc4;
    r5 = r0;
    r3 = 0x40000d4;
    r2 = 0x84000003;
    r0 = r6;
    r1 = r5;
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = r3 - 0xc;
    r5 = r5 + 0xc;
    r6 = r6 + 0xc;
    r1 = CPU.r10().value;
    if(r1 == 0x3) {
      r0 = 0x80edcb8;
      r1 = r5;
      r2 = 0x84000003;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0xc;
    }

    //LAB_80ed534
    r4 = 0xc;
    r2 = CPU.r8().value;
    r4 = r4 & r2;
    if(r4 == 0x4) {
      r3 = 0x40000d4;
      r0 = r6;
      r1 = r5;
      r2 = 0x84000003;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0xc;
    }

    //LAB_80ed54c
    r6 = r6 + 0xc;
    if(r4 == 0x8) {
      r3 = 0x40000d4;
      r0 = r6;
      r1 = r5;
      r2 = 0x84000004;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x10;
    }

    //LAB_80ed560
    r6 = r6 + 0x10;
    if(r4 == 0xc) {
      r3 = 0x40000d4;
      r0 = r6;
      r1 = r5;
      r2 = 0x84000003;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0xc;
    }

    //LAB_80ed574
    r6 = r6 + 0xc;
    if(r4 == 0) {
      r3 = MEMORY.ref(4, r6).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
    }

    //LAB_80ed57e
    r3 = 0x2;
    r1 = CPU.r8().value;
    r3 = r3 & r1;
    r6 = r6 + 0x4;
    if(r3 != 0) {
      r3 = MEMORY.ref(4, r6).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = 0x8;
      r3 = r3 & r1;
      if(r3 != 0) {
        r3 = MEMORY.ref(4, r6 + 0x8).get();
      } else {
        //LAB_80ed59e
        r3 = MEMORY.ref(4, r6 + 0xc).get();
      }

      //LAB_80ed5a0
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x10).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x14).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r2 = 0x1;
      r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r2 = r2 << r3;
      r3 = MEMORY.ref(4, r6 + 0x18).get();
      r3 = r3 + r2;
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x1c).get();
      r3 = r3 + r2;
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
    }

    //LAB_80ed5bc
    r6 = r6 + 0x20;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r2 = 0x1;
    r1 = CPU.r8().value;
    r1 = r1 & r2;
    if(r1 == 0) {
      r3 = CPU.r9().value;
      r2 = r2 << r3;
      r3 = MEMORY.ref(4, r6).get();
      r3 = r3 + r2;
      r3 = r3 - 0x1;
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
    }

    //LAB_80ed5de
    r6 = r6 + 0x4;
    if(r1 != 0) {
      r3 = MEMORY.ref(4, r6).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = 0x4;
      r1 = CPU.r8().value;
      r3 = r3 & r1;
      if(r3 != 0) {
        r3 = MEMORY.ref(4, r6 + 0x8).get();
        MEMORY.ref(4, r5).setu(r3);
        r5 += 0x4;
        r3 = MEMORY.ref(4, r6 + 0xc).get();
      } else {
        //LAB_80ed5fe
        r3 = MEMORY.ref(4, r6 + 0x10).get();
        MEMORY.ref(4, r5).setu(r3);
        r5 += 0x4;
        r3 = MEMORY.ref(4, r6 + 0x14).get();
      }

      //LAB_80ed604
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x18).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x1c).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = 0x80ef034;
      r2 = CPU.r9().value;
      r1 = r2 << 1;
      r2 = MEMORY.ref(2, r3 + r1).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x20).get();
      r3 = r3 + r2;
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = 0x4;
      r2 = CPU.r8().value;
      r3 = r3 & r2;
      if(r3 != 0) {
        r3 = MEMORY.ref(4, r6 + 0x24).get();
      } else {
        //LAB_80ed62a
        r3 = MEMORY.ref(4, r6 + 0x28).get();
      }

      //LAB_80ed62c
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = 0x80ef034;
      r2 = MEMORY.ref(2, r3 + r1).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x2c).get();
      r3 = r3 + r2;
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
    }

    //LAB_80ed638
    r6 = r6 + 0x30;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    CPU.r11().value = r5;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = 0x40000d4;
    r2 = 0x84000006;
    r0 = r6;
    r1 = r5;
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = r3 - 0xc;
    r5 = r5 + 0x18;
    r6 = r6 + 0x18;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r7 = 0x1;
    r4 = CPU.r8().value;
    r4 = r4 & r7;
    if(r4 == 0) {
      r3 = MEMORY.ref(4, r6).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
    }

    //LAB_80ed666
    r6 = r6 + 0x4;
    r3 = 0x40000d4;
    r2 = 0x84000005;
    r0 = r6;
    r1 = r5;
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = r3 - 0xc;
    r5 = r5 + 0x14;
    r6 = r6 + 0x14;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    r3 = MEMORY.ref(4, r6).get();
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    r3 = r3 - 0x3;
    r2 = r7;
    r2 = r2 << r3;
    r3 = MEMORY.ref(4, r6 + 0x4).get();
    r3 = r3 + r2;
    r3 = r3 - 0x1;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r2 = CPU.r9().value;
    r3 = MEMORY.ref(4, r6 + 0x8).get();
    r2 = r2 - 0x3;
    r2 = r2 << 7;
    r3 = r3 + r2;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = MEMORY.ref(4, r6 + 0xc).get();
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r6 = r6 + 0x10;
    if(r4 == 0) {
      r3 = MEMORY.ref(4, r6).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
    }

    //LAB_80ed6a8
    r6 = r6 + 0x4;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    CPU.r12().value = r5;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = 0x4;
    r1 = CPU.r8().value;
    r3 = r3 & r1;
    if(r3 != 0) {
      r3 = MEMORY.ref(4, r6).get();
    } else {
      //LAB_80ed6c2
      r3 = MEMORY.ref(4, r6 + 0x4).get();
    }

    //LAB_80ed6c4
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r2 = CPU.r10().value;
    r6 = r6 + 0x8;
    r4 = r5;
    if(r2 == 0x1) {
      //LAB_80ed6fc
      r3 = 0x4;
      r2 = CPU.r8().value;
      r3 = r3 & r2;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edb10;
      } else {
        //LAB_80ed70c
        r3 = 0x40000d4;
        r0 = 0x80edb00;
      }

      r1 = r5;
      r2 = 0x84000004;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x10;
    } else if(r2 == 0x2) {
      //LAB_80ed712
      r3 = 0x4;
      r1 = CPU.r8().value;
      r3 = r3 & r1;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edbf8;
      } else {
        //LAB_80ed722
        r3 = 0x40000d4;
        r0 = 0x80edbe8;
      }

      //LAB_80ed726
      r1 = r5;
      r2 = 0x84000004;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x10;
    } else if(r2 == 0x3) {
      //LAB_80ed732
      r3 = 0x4;
      r2 = CPU.r8().value;
      r3 = r3 & r2;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edca0;
      } else {
        //LAB_80ed742
        r3 = 0x40000d4;
        r0 = 0x80edc88;
      }

      //LAB_80ed746
      r1 = r5;
      r2 = 0x84000006;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x18;
    } else {
      //LAB_80ed6dc
      r3 = 0x4;
      r1 = CPU.r8().value;
      r3 = r3 & r1;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edaf0;
      } else {
        //LAB_80ed6ec
        r3 = 0x40000d4;
        r0 = 0x80edaf8;
      }

      //LAB_80ed6f0
      r1 = r5;
      r2 = 0x84000002;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x8;
    }

    //LAB_80ed750
    r6 = r6 + 0x10;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = r4 - r5;
    r3 = r3 - 0x8;
    r1 = 0xffffff;
    r2 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    r3 = r3 >>> 2;
    r3 = r3 & r1;
    r2 = r2 + r3;
    MEMORY.ref(4, r5).setu(r2);
    r5 += 0x4;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = 0x1;
    r2 = CPU.r8().value;
    r3 = r3 & r2;
    if(r3 == 0) {
      r3 = MEMORY.ref(4, r6).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
    }

    //LAB_80ed77c
    r6 = r6 + 0x8;
    r2 = CPU.r12().value;
    r3 = r5 - r2;
    r3 = r3 - 0x8;
    r2 = MEMORY.ref(4, r2).get();
    r3 = r3 >>> 2;
    r3 = r3 & r1;
    r2 = r2 | r3;
    r3 = CPU.r12().value;
    MEMORY.ref(4, r3).setu(r2);
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    CPU.r12().value = r5;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    r1 = CPU.r10().value;
    if(r1 == 0x1) {
      //LAB_80ed7de
      r3 = 0x4;
      r2 = CPU.r8().value;
      r3 = r3 & r2;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edb84;
      } else {
        //LAB_80ed7ee
        r3 = 0x40000d4;
        r0 = 0x80edb20;
      }

      //LAB_80ed7f2
      r1 = r5;
      r2 = 0x84000019;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x64;
    } else if(r1 == 0x2) {
      //LAB_80ed7fe
      r3 = 0x4;
      r1 = CPU.r8().value;
      r3 = r3 & r1;
      if(r3 != 0) {
        r4 = 0x80edc48;
      } else {
        //LAB_80ed80c
        r4 = 0x80edc08;
      }

      //LAB_80ed80e
      r3 = 0x40000d4;
      r0 = r4;
      r1 = r5;
      r2 = 0x84000010;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x40;
      r0 = r4;
      r1 = r5;
      r2 = 0x84000010;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x40;
    } else if(r1 == 0x3) {
      //LAB_80ed88c
      r3 = 0x4;
      r2 = CPU.r8().value;
      r3 = r3 & r2;
      if(r3 != 0) {
        r4 = 0x80eefdc;
      } else {
        //LAB_80ed89a
        r4 = 0x80eefa4;
      }

      //LAB_80ed89c
      r3 = 0x40000d4;
      r0 = r4;
      r1 = r5;
      r2 = 0x8400000e;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x38;
      r0 = r4;
      r1 = r5;
      r2 = 0x8400000e;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x38;
    } else {
      //LAB_80ed7ae
      r3 = 0x80edaf0;
      r1 = 0x80edaf8;
      r7 = 0x4;
      r2 = CPU.r8().value;
      r4 = 0x0;
      r7 = r7 & r2;
      CPU.r9().value = r3;
      CPU.lr().value = r1;

      //LAB_80ed7be
      do {
        if(r7 != 0) {
          r3 = 0x40000d4;
          r0 = CPU.r9().value;
        } else {
          //LAB_80ed7c8
          r3 = 0x40000d4;
          r0 = CPU.lr().value;
        }

        //LAB_80ed7cc
        r1 = r5;
        r2 = 0x84000002;
        MEMORY.ref(4, r3).setu(r0);
        r3 += 0x4;
        MEMORY.ref(4, r3).setu(r1);
        r3 += 0x4;
        MEMORY.ref(4, r3).setu(r2);
        r3 += 0x4;
        r3 = r3 - 0xc;
        r5 = r5 + 0x8;
        r4 = r4 + 0x1;
      } while(r4 <= 0x7);
    }

    //LAB_80ed8b6
    r6 = r6 + 0x10;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = 0x1;
    r1 = CPU.r8().value;
    r3 = r3 & r1;
    if(r3 == 0) {
      r3 = MEMORY.ref(4, r6).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      MEMORY.ref(4, r5).setu(r3);
      r5 += 0x4;
    }

    //LAB_80ed8ce
    r6 = r6 + 0x8;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r2 = MEMORY.ref(4, CPU.sp().value).get();
    r3 = r2 - r5;
    r1 = 0xffffff;
    r3 = r3 - 0x8;
    r2 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    r3 = r3 >>> 2;
    r3 = r3 & r1;
    r2 = r2 + r3;
    MEMORY.ref(4, r5).setu(r2);
    r5 += 0x4;
    r2 = CPU.r12().value;
    r3 = r5 - r2;
    r3 = r3 - 0x8;
    r2 = MEMORY.ref(4, r2).get();
    r3 = r3 >>> 2;
    r3 = r3 & r1;
    r2 = r2 | r3;
    r3 = CPU.r12().value;
    MEMORY.ref(4, r3).setu(r2);
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    CPU.r12().value = r5;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = 0x4;
    r1 = CPU.r8().value;
    r3 = r3 & r1;
    if(r3 != 0) {
      r3 = MEMORY.ref(4, r6).get();
    } else {
      //LAB_80ed910
      r3 = MEMORY.ref(4, r6 + 0x4).get();
    }

    //LAB_80ed912
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r2 = CPU.r10().value;
    r6 = r6 + 0x8;
    r4 = r5;
    if(r2 == 0x1) {
      //LAB_80ed94a
      r3 = 0x4;
      r2 = CPU.r8().value;
      r3 = r3 & r2;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edb10;
      } else {
        //LAB_80ed95a
        r3 = 0x40000d4;
        r0 = 0x80edb00;
      }

      //LAB_80ed974
      r1 = r5;
      r2 = 0x84000004;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x10;
    } else if((r2 & 0xffff_ffffL) < (0x1 & 0xffff_ffffL)) {
      //LAB_80ed92a
      r3 = 0x4;
      r1 = CPU.r8().value;
      r3 = r3 & r1;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edaf0;
      } else {
        //LAB_80ed93a
        r3 = 0x40000d4;
        r0 = 0x80edaf8;
      }

      //LAB_80ed93e
      r1 = r5;
      r2 = 0x84000002;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x8;
    } else if(r2 == 0x2) {
      //LAB_80ed960
      r3 = 0x4;
      r1 = CPU.r8().value;
      r3 = r3 & r1;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edbf8;
      } else {
        //LAB_80ed970
        r3 = 0x40000d4;
        r0 = 0x80edbe8;
      }

      //LAB_80ed974
      r1 = r5;
      r2 = 0x84000004;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x10;
    } else if(r2 == 0x3) {
      //LAB_80ed980
      r3 = 0x4;
      r2 = CPU.r8().value;
      r3 = r3 & r2;
      if(r3 != 0) {
        r3 = 0x40000d4;
        r0 = 0x80edca0;
      } else {
        //LAB_80ed990
        r3 = 0x40000d4;
        r0 = 0x80edc88;
      }

      //LAB_80ed994
      r1 = r5;
      r2 = 0x84000006;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r5 = r5 + 0x18;
    }

    //LAB_80ed99e
    r6 = r6 + 0x10;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = r4 - r5;
    r3 = r3 - 0x8;
    r4 = 0xffffff;
    r2 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    r3 = r3 >>> 2;
    r3 = r3 & r4;
    r2 = r2 + r3;
    MEMORY.ref(4, r5).setu(r2);
    r5 += 0x4;
    r1 = CPU.r12().value;
    r3 = r5 - r1;
    r3 = r3 - 0x8;
    r2 = MEMORY.ref(4, r1).get();
    r3 = r3 >>> 2;
    r3 = r3 & r4;
    r2 = r2 | r3;
    MEMORY.ref(4, r1).setu(r2);
    r3 = 0x40000d4;
    r2 = 0x84000003;
    r0 = r6;
    r1 = r5;
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = r3 - 0xc;
    r5 = r5 + 0xc;
    r6 = r6 + 0xc;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r3 = r2 - r5;
    r3 = r3 - 0x8;
    r2 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    r3 = r3 >>> 2;
    r3 = r3 & r4;
    r2 = r2 + r3;
    MEMORY.ref(4, r5).setu(r2);
    r5 += 0x4;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r3 = r5 - r1;
    r3 = r3 - 0x8;
    r2 = MEMORY.ref(4, r1).get();
    r3 = r3 >>> 2;
    r3 = r3 & r4;
    r2 = r2 | r3;
    MEMORY.ref(4, r1).setu(r2);
    r2 = CPU.r11().value;
    r3 = r5 - r2;
    r3 = r3 - 0x8;
    r2 = MEMORY.ref(4, r2).get();
    r3 = r3 >>> 2;
    r3 = r3 & r4;
    r2 = r2 | r3;
    r3 = CPU.r11().value;
    MEMORY.ref(4, r3).setu(r2);
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r5 += 0x4;
    r3 = MEMORY.ref(4, r6).get();
    r6 += 0x4;
    MEMORY.ref(4, r5).setu(r3);
    r3 = 0x80ede48;
    r3 = r3 ^ r6;
    r2 = -r3;
    r2 = r2 | r3;
    r2 = r2 >>> 31;
    r0 = 0x1;
    r0 = r0 - r2;
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80e6eac)
  public static void FUN_80e6eac(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x24;
    r5 = 0x3001eec;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
    r3 = r5;
    r0 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    CPU.r11().value = r1;
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.r11().value;
    r4 = 0xa0;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
    r4 = r4 << 14;
    r3 = r2;
    r3 = r3 + r4;
    CPU.r11().value = r3;
    r3 = r3 >>> 31;
    r3 = r3 + CPU.r11().value;
    r3 = r3 >> 1;
    r1 = MEMORY.ref(4, r5 + 0x8).get();
    CPU.r11().value = r3;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    r3 = 0x80;
    r2 = 0x4000020;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    MEMORY.ref(2, r2).setu(r3);
    r2 = r2 + 0x8;
    r3 = 0x0;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0x3f46;
    r2 = r2 + 0x28;
    CPU.r10().value = r0;
    MEMORY.ref(2, r2).setu(r3);
    r6 = 0x2;
    r1 = 0x7;
    r2 = 0x7;
    r3 = 0x3;
    r0 = 0x2e;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r0 = MEMORY.ref(4, r5 + 0x1c).get();
    r3 = 0x3;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
    r1 = 0x7;
    r2 = 0x7;
    r0 = 0x2f;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r5 = MEMORY.ref(4, r5 + 0x20).get();
    r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    r0 = 0x73;
    r2 = 0x0;
    r3 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r5);
    FUN_80e0524(r0, r1, r2, r3);
    FUN_80e0524(94, CPU.r10().value, 1, 0);
    FUN_80e0524(95, CPU.r10().value + 0x59d8, 0, 0);
    MEMORY.ref(4, CPU.r10().value + 0x7780).setu(r6);
    MEMORY.ref(4, CPU.r10().value + 0x7784).setu(50);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    CPU.r8().value = 0;
    r7 = CPU.r10().value + 0x7080;

    //LAB_80e6f7c
    do {
      r0 = rand();
      r6 = 0xff;
      r2 = 0x80;
      r2 = r2 << 1;
      r6 = r6 & r0;
      r6 = r6 + r2;
      r0 = rand();
      r3 = 0xffff;
      r5 = r0;
      r5 = r5 & r3;
      r3 = CPU.r11().value;
      MEMORY.ref(4, r7).setu(r3);
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r0 = r5;
      MEMORY.ref(4, r7 + 0x4).setu(r4);
      r0 = sin(r0);
      r3 = r6;
      r3 = r3 * r0;
      r3 = r3 >> 7;
      MEMORY.ref(4, r7 + 0xc).setu(r3);
      r0 = r5;
      r0 = cos(r0);
      r3 = r6;
      r3 = r3 * r0;
      r3 = r3 >> 6;
      r3 = -r3;
      MEMORY.ref(4, r7 + 0x10).setu(r3);
      r0 = rand();
      r3 = 0xf;
      r3 = r3 & r0;
      r0 = 0x1;
      CPU.r8().value = CPU.r8().value + r0;
      r3 = r3 + 0x10;
      r1 = CPU.r8().value;
      MEMORY.ref(4, r7 + 0x18).setu(r3);
      r7 = r7 + 0x1c;
    } while(r1 != 0x40);

    r5 = 0x772c;
    r2 = 0x0;
    CPU.r8().value = r2;
    r6 = 0x0;
    r5 = r5 + CPU.r10().value;

    //LAB_80e6fdc
    do {
      r3 = CPU.r11().value;
      MEMORY.ref(4, r5).setu(r3);
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r0 = r6;
      MEMORY.ref(4, r5 + 0x4).setu(r4);
      r0 = sin(r0);
      r0 = r0 << 5;
      r0 = r0 >> 6;
      MEMORY.ref(4, r5 + 0xc).setu(r0);
      r0 = r6;
      r0 = cos(r0);
      r0 = r0 << 5;
      r0 = r0 >> 5;
      r0 = -r0;
      r1 = 0x1;
      MEMORY.ref(4, r5 + 0x10).setu(r0);
      CPU.r8().value = CPU.r8().value + r1;
      r0 = 0x5555;
      r2 = CPU.r8().value;
      r6 = r6 + r0;
      r5 = r5 + 0x1c;
    } while(r2 != 0x3);

    r3 = 0x0;
    r7 = 0x2010000;
    CPU.r8().value = r3;

    //LAB_80e7014
    do {
      r0 = rand();
      r6 = 0xff;
      r6 = r6 & r0;
      r0 = rand();
      r4 = CPU.r11().value;
      MEMORY.ref(4, r7).setu(r4);
      r3 = 0xffff;
      r5 = r0;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r5 = r5 & r3;
      MEMORY.ref(4, r7 + 0x4).setu(r0);
      r0 = r5;
      r0 = sin(r0);
      r6 = r6 + 0x20;
      r3 = r6;
      r3 = r3 * r0;
      r3 = r3 >> 6;
      MEMORY.ref(4, r7 + 0xc).setu(r3);
      r0 = r5;
      r0 = cos(r0);
      r3 = r6;
      r3 = r3 * r0;
      r3 = r3 >> 5;
      r3 = -r3;
      MEMORY.ref(4, r7 + 0x10).setu(r3);
      r0 = rand();
      r3 = 0xf;
      r1 = 0x1;
      r3 = r3 & r0;
      CPU.r8().value = CPU.r8().value + r1;
      r3 = r3 + 0x14;
      r2 = CPU.r8().value;
      MEMORY.ref(4, r7 + 0x18).setu(r3);
      r7 = r7 + 0x1c;
    } while(r2 != 0x40);

    r7 = 0x0;

    //LAB_80e7068
    do {
      if(r7 == 0x4) {
        r0 = 0x9a;
        playSound_(r0);
      }

      //LAB_80e7072
      if(r7 == 0x20) {
        r0 = 0xd4;
        playSound_(r0);
      }

      //LAB_80e707c
      if(r7 <= 0x2f) {
        r0 = r7;
        r0 = r0 - 0x8;
        r1 = 0x5;
        r0 = divideS(r0, r1);
        r4 = r0;
        if(r4 < 0) {
          r4 = 0x0;
        }

        //LAB_80e7092
        r2 = 0x80eee66;
        r3 = r4 << 1;
        r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
        r3 = CPU.r11().value;
        r2 = r3 >> 16;
        r3 = 0x80eee56;
        r5 = MEMORY.ref(1, r3 + r4).getUnsigned();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r3 = r5 >>> 1;
        r2 = r2 - r3;
        r3 = r0 >> 16;
        r0 = 0x80eee5e;
        r4 = MEMORY.ref(1, r0 + r4).getUnsigned();
        r0 = r4 >>> 1;
        r3 = r3 - r0;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
        r1 = r1 + CPU.r10().value;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r4 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }

      //LAB_80e70be
      r6 = 0xe1;
      r0 = 0x0;
      r6 = r6 << 7;
      CPU.r8().value = r0;
      r6 = r6 + CPU.r10().value;

      //LAB_80e70c8
      do {
        r1 = CPU.r8().value;
        r3 = r1 >>> 31;
        r3 = r3 + CPU.r8().value;
        r3 = r3 >> 1;
        if(r7 > r3) {
          r3 = MEMORY.ref(4, r6 + 0x18).get();
          if(r3 > 0) {
            r3 = r3 - 0x1;
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r0 = r6;
            r1 = 0x3c;
            r2 = 0x0;
            FUN_80e3908(r0, r1, r2);
            r4 = MEMORY.ref(4, r6 + 0x18).get();
            if(r4 < 0) {
              r4 = r4 + 0xf;
            }

            //LAB_80e70f0
            r4 = r4 >> 4;
            r4 = r4 + 0x3;
            r3 = 0x2;
            r2 = MEMORY.ref(2, r6 + r3).get();
            r5 = r4 << 1;
            r0 = 0x6;
            r3 = MEMORY.ref(2, r6 + r0).get();
            r0 = 0x80ede48;
            r1 = r5 - 0x2;
            r1 = MEMORY.ref(2, r0 + r1).getUnsigned();
            r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r1 = r0 + r1;
            r0 = r4 >>> 31;
            r0 = r4 + r0;
            r0 = r0 >> 1;
            r2 = r2 - r0;
            r3 = r3 - r4;
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }
        }

        //LAB_80e711e
        r0 = 0x1;
        CPU.r8().value = CPU.r8().value + r0;
        r1 = CPU.r8().value;
        r6 = r6 + 0x1c;
      } while(r1 != 0x1e);

      r3 = 0x80ede48;
      r2 = 0x0;
      r6 = 0x2010000;
      CPU.r8().value = r2;
      CPU.r9().value = r3;

      //LAB_80e7134
      do {
        if(r7 > 0x23) {
          r3 = MEMORY.ref(4, r6 + 0x18).get();
          if(r3 > 0) {
            r3 = r3 - 0x1;
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r0 = r6;
            r1 = 0x3c;
            r2 = 0x0;
            FUN_80e3908(r0, r1, r2);
            r4 = MEMORY.ref(4, r6 + 0x18).get();
            if(r4 < 0) {
              r4 = r4 + 0xf;
            }

            //LAB_80e7154
            r4 = r4 >> 4;
            r4 = r4 + 0x1;
            r5 = r4 << 1;
            r0 = 0x2;
            r2 = MEMORY.ref(2, r6 + r0).get();
            r1 = 0x6;
            r3 = MEMORY.ref(2, r6 + r1).get();
            r0 = CPU.r9().value;
            r1 = r5 - 0x2;
            r1 = MEMORY.ref(2, r0 + r1).getUnsigned();
            r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r1 = r0 + r1;
            r0 = r4 >>> 31;
            r0 = r4 + r0;
            r0 = r0 >> 1;
            r2 = r2 - r0;
            r3 = r3 - r4;
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }
        }

        //LAB_80e7182
        r0 = 0x1;
        CPU.r8().value = CPU.r8().value + r0;
        r1 = CPU.r8().value;
        r6 = r6 + 0x1c;
      } while(r1 != 0x3c);

      r5 = 0x772c;
      r2 = 0x0;
      r6 = r7;
      CPU.r8().value = r2;
      r6 = r6 - 0x24;
      r5 = r5 + CPU.r10().value;

      //LAB_80e719a
      do {
        if((r6 & 0xffff_ffffL) <= (0x1b & 0xffff_ffffL)) {
          r2 = 0x0;
          r0 = r5;
          r1 = 0x40;
          FUN_80e3908(r0, r1, r2);
          r1 = 0x7;
          r0 = r6;
          r0 = divideS(r0, r1);
          r1 = r0 << 3;
          r1 = r1 + r0;
          r1 = r1 << 5;
          r0 = 0x59d8;
          r1 = r1 + CPU.r10().value;
          r3 = 0x2;
          r2 = MEMORY.ref(2, r5 + r3).get();
          r1 = r1 + r0;
          r4 = 0x6;
          r3 = MEMORY.ref(2, r5 + r4).get();
          r0 = 0xc;
          MEMORY.ref(4, CPU.sp().value).setu(r0);
          r0 = 0x18;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          r2 = r2 - 0x6;
          r3 = r3 - 0xc;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_80e71d8
        r0 = 0x1;
        CPU.r8().value = CPU.r8().value + r0;
        r1 = CPU.r8().value;
        r5 = r5 + 0x1c;
      } while(r1 != 0x3);

      if(r7 <= 0x23) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        FUN_80e6d3c(r0, r1, r2);
      }

      //LAB_80e71f2
      r2 = 0x7824;
      r3 = 0x1;
      r2 = r2 + CPU.r10().value;
      MEMORY.ref(4, r2).setu(r3);
      r0 = 0x1;
      r7 = r7 + 0x1;
      sleep(r0);
    } while(r7 != 0x48);

    //LAB_80e7208
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    r1 = 0x80;
    r3 = 0x3000164;
    r1 = r1 << 7;
    r0 = 0x6004000;
    MEMORY.call(r3, r0, r1);
    r0 = 0x2f;
    freeSlot(r0);
    r0 = 0x2e;
    freeSlot(r0);
    CPU.sp().value += 0x24;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80e7320)
  public static void FUN_80e7320(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80e823c)
  public static void FUN_80e823c(int r0) {
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
    r3 = 0x3001ef0;
    r1 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x54;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
    r2 = r3 - 0x4;
    r2 = MEMORY.ref(4, r2).get();
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r2);
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
    r3 = 0x7828;
    r5 = r2 + r3;
    MEMORY.ref(4, r5).setu(r0);
    r0 = 0x0;
    FUN_80cd594(r0);
    FUN_80c9048();
    r2 = 0x0;
    r3 = 0xa0;
    r3 = r3 << 19;
    MEMORY.ref(2, r3).setu(r2);
    r3 = r3 + 0x2;
    MEMORY.ref(2, r3).setu(r2);
    r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r7 = 0xef;
    r7 = r7 << 7;
    r2 = r6 + r7;
    r3 = 0x0;
    r1 = 0x90;
    MEMORY.ref(4, r2).setu(r3);
    r1 = r1 << 3;
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), r1);
    r1 = 0x0;
    r0 = 0x1;
    FUN_80cd104(r0, r1);
    r0 = MEMORY.ref(4, r5).get();
    FUN_80d6750(r0);
    r1 = 0x17b;
    r0 = 0x9;
    r2 = 0x2;
    FUN_80dbb24(r0, r1, r2);
    r1 = 0xd;
    r0 = 0x0;
    r1 = -r1;
    r6 = 0x77fc;
    CPU.r8().value = r0;
    r7 = r1;

    //LAB_80e82ca
    do {
      final Sprite38 sprite = loadSprite_(390);
      r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      MEMORY.ref(4, r6 + r2).setu(sprite != null ? sprite.getAddress() : 0);
      if(sprite != null) {
        sprite._26.set(0);
        setSpriteAnimation_(sprite, modS(CPU.r8().value, 3));
        r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r1 = MEMORY.ref(4, r6 + r3).get();
        r3 = MEMORY.ref(1, r1 + 0x9).getUnsigned();
        r2 = 0x4;
        r3 = r3 & r7;
        r3 = r3 | r2;
        MEMORY.ref(1, r1 + 0x9).setu(r3);
      }

      //LAB_80e8302
      r0 = 0x1;
      CPU.r8().value = CPU.r8().value + r0;
      r1 = CPU.r8().value;
      r6 = r6 + 0x4;
    } while(r1 != 0x6);

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
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
    r2 = 0x7;
    r3 = 0x3;
    r0 = 0x2f;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r5 = r5 + 0xbc;
    r2 = CPU.sp().value;
    r3 = MEMORY.ref(4, r5).get();
    r2 = r2 + 0x3c;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    MEMORY.ref(4, r2 + 0x4).setu(r3);
    r2 = 0x4000048;
    r3 = 0x2737;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0xf0;
    r2 = r2 - 0x8;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x1088;
    r2 = r2 + 0x6;
    MEMORY.ref(2, r2).setu(r3);
    r0 = 0x1;
    sleep(r0);
    r2 = 0x0;
    r1 = 0x3c;
    r0 = 0x1;
    FUN_80b5040(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    FUN_80cd104(r0, r1);
    r0 = 0x73;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
    r2 = 0x0;
    r3 = 0x0;
    FUN_80e0524(r0, r1, r2, r3);
    r0 = 0xc0;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r2 = 0x1;
    r3 = 0x1;
    FUN_80e0524(r0, r1, r2, r3);
    r3 = 0x7741;
    r2 = 0x80;
    r2 = r2 << 19;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x80;
    r2 = r2 + 0x20;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x1010;
    r2 = r2 + 0x32;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x3f44;
    r2 = r2 - 0x2;
    MEMORY.ref(2, r2).setu(r3);
    r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r0 = 0xef;
    r0 = r0 << 7;
    r1 = 0x7784;
    r3 = r7 + r0;
    MEMORY.ref(4, r3).setu(r6);
    r2 = r7 + r1;
    r3 = 0x32;
    MEMORY.ref(4, r2).setu(r3);
    r2 = 0xbc;
    r3 = 0xb8;
    r3 = r3 << 15;
    r2 = r2 << 16;
    r6 = 0xa0;
    r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r1 = 0xe1;
    r6 = r6 << 16;
    r7 = 0x0;
    r1 = r1 << 7;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r6);
    CPU.r8().value = r7;
    r6 = 0x0;
    r5 = r0 + r1;

    //LAB_80e8410
    do {
      r0 = rand();
      r3 = 0x7f;
      r3 = r3 & r0;
      r3 = r3 << 16;
      MEMORY.ref(4, r5).setu(r3);
      r3 = 0x1;
      r2 = 0xfff00000;
      CPU.r8().value = CPU.r8().value + r3;
      r0 = CPU.r8().value;
      MEMORY.ref(4, r5 + 0x4).setu(r7);
      MEMORY.ref(4, r5 + 0xc).setu(r6);
      MEMORY.ref(4, r5 + 0x10).setu(r6);
      MEMORY.ref(4, r5 + 0x18).setu(r6);
      r7 = r7 + r2;
      r5 = r5 + 0x1c;
    } while(r0 != 0x6);

    r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r7 = 0x7140;
    r1 = 0x0;
    CPU.r8().value = r1;
    r2 = 0x18;
    r3 = r6 + r7;

    //LAB_80e8440
    do {
      r0 = 0x1;
      CPU.r8().value = CPU.r8().value + r0;
      r1 = CPU.r8().value;
      MEMORY.ref(4, r3).setu(r2);
      r3 = r3 + 0x1c;
    } while(r1 != 0x3a);

    r2 = 0x0;
    CPU.r8().value = r2;
    r1 = 0x1;
    r2 = 0x80;
    r3 = 0x2010018;
    r1 = -r1;
    r2 = r2 << 3;

    //LAB_80e845c
    do {
      r6 = 0x1;
      CPU.r8().value = CPU.r8().value + r6;
      MEMORY.ref(4, r3).setu(r1);
      r3 = r3 + 0x1c;
    } while(CPU.r8().value != r2);

    r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r0 = 0x77b4;
    r1 = 0x77b8;
    r2 = r7 + r0;
    r3 = 0x18;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0x0;
    r2 = r7 + r1;
    MEMORY.ref(4, r2).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r3);
    r3 = 0x3001b04;
    r3 = MEMORY.ref(4, r3).get();
    r2 = 0x3;
    r3 = r3 & r2;
    if(r3 == 0) {
      //LAB_80e848a
      r2 = CPU.sp().value;
      r3 = CPU.sp().value;
      r2 = r2 + 0x44;
      r3 = r3 + 0x34;
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);

      //LAB_80e8496
      do {
        r6 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r6 == 0x5e) {
          r0 = 0x9c;
          playSound_(r0);
        }

        //LAB_80e84a2
        r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r7 == 0x88) {
          r0 = 0x9c;
          playSound_(r0);
        }

        //LAB_80e84ae
        r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r0 == 0xb2) {
          r0 = 0x9c;
          playSound_(r0);
        }

        //LAB_80e84ba
        r2 = 0x82;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r2 = r2 << 1;
        if(r1 == r2) {
          r0 = 0x91;
          playSound_(r0);
        }

        //LAB_80e84ca
        r3 = 0x80edac8;
        r4 = MEMORY.ref(4, r3 + 0x4).get();
        r3 = MEMORY.ref(4, r3).get();
        MEMORY.ref(4, CPU.sp().value + 0x34).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x38).setu(r4);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r3 = r3 - 0x60;
        if((r3 & 0xffff_ffffL) <= (0x9b & 0xffff_ffffL)) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r6 = 0x77a8;
          r2 = r3 + r6;
          r3 = 0x1;
          MEMORY.ref(4, r2).setu(r3);
        } else {
          //LAB_80e84e4
          r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r0 = 0xfffffefc;
          r3 = r7 + r0;
          if((r3 & 0xffff_ffffL) <= (0x3 & 0xffff_ffffL)) {
            r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r3 = 0x77a8;
            r2 = r1 + r3;
            r3 = 0x1;
            MEMORY.ref(4, r2).setu(r3);
          }
        }

        //LAB_80e84f8
        r3 = 0x0;
        r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r1 = 0x77d8;
        MEMORY.ref(4, CPU.sp().value + 0x50).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x48).setu(r3);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r7 = 0xffe00000;
        CPU.r8().value = r3;
        r6 = r0 + r1;

        //LAB_80e850a
        do {
          r3 = 0x80eeed8;
          r2 = CPU.r8().value;
          r3 = MEMORY.ref(1, r3 + r2).getUnsigned();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r3 = r3 << 16;
          r3 = r3 + r0;
          r3 = r3 + r7;
          MEMORY.ref(4, r5).setu(r3);
          r3 = 0x80eeee1;
          r3 = MEMORY.ref(1, r3 + r2).getUnsigned();
          r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
          r3 = r3 << 16;
          r3 = r3 + r1;
          r3 = r3 + r7;
          MEMORY.ref(4, r5 + 0x8).setu(r3);
          r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          drawSprite_(MEMORY.ref(4, r6).deref(4).cast(Sprite38::new), r5, r2, 0);
          r6 += 0x4;
          CPU.r8().value++;
        } while(CPU.r8().value < 7);

        r6 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r6 <= 0x5a) {
          r5 = r6 << 9;
          r0 = r5;
          r0 = sin(r0);
          r7 = 0x9c;
          r0 = r0 << 4;
          r7 = r7 << 16;
          r7 = r0 + r7;
          r0 = r5;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r7);
          r0 = cos(r0);
          r1 = 0xb8;
          r0 = r0 << 4;
          r1 = r1 << 15;
          r1 = r0 + r1;
          MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
        }

        //LAB_80e8566
        r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r2 <= 0xc4) {
          r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = 0x0;
          CPU.r8().value = r3;
          r6 = 0x5b;
          CPU.r10().value = r7;

          //LAB_80e8576
          do {
            r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            if(r0 >= r6) {
              r3 = r6 + 0x4;
              if(r0 < r3) {
                r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r2 = 0x80;
                r2 = r2 << 12;
                r2 = r1 + r2;
                MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);
              }
            }

            //LAB_80e858c
            r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = r6 + 0x3;
            if(r7 == r3) {
              r5 = 0x7128;
              r0 = 0xff;
              r7 = 0x0;
              CPU.r9().value = r0;
              r5 = r5 + CPU.r10().value;

              //LAB_80e859e
              do {
                r3 = 0x80;
                r3 = r3 << 15;
                MEMORY.ref(4, r5).setu(r3);
                r3 = 0xc0;
                r3 = r3 << 15;
                MEMORY.ref(4, r5 + 0x4).setu(r3);
                r0 = rand();
                r1 = CPU.r9().value;
                r0 = r0 & r1;
                r0 = r0 - 0x7f;
                r0 = r0 << 10;
                MEMORY.ref(4, r5 + 0xc).setu(r0);
                r0 = rand();
                r2 = CPU.r9().value;
                r0 = r0 & r2;
                r0 = r0 - 0x7f;
                r0 = r0 << 10;
                MEMORY.ref(4, r5 + 0x10).setu(r0);
                r0 = rand();
                r3 = 0xf;
                r3 = r3 & r0;
                r7 = r7 + 0x1;
                MEMORY.ref(4, r5 + 0x18).setu(r3);
                r5 = r5 + 0x1c;
              } while(r7 != 0x4);
            }

            //LAB_80e85d8
            r3 = r6;
            r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = r3 + 0x14;
            if(r7 >= r3) {
              r3 = r3 + 0x10;
              if(r7 < r3) {
                r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r1 = 0xfffe0000;
                r1 = r0 + r1;
                MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
              }
            }

            //LAB_80e85f0
            r3 = 0x1;
            CPU.r8().value = CPU.r8().value + r3;
            r2 = 0xe0;
            r7 = CPU.r8().value;
            r6 = r6 + 0x28;
            CPU.r10().value = CPU.r10().value + r2;
          } while(r7 != 0x3);
        }

        //LAB_80e8600
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r3 = r3 - 0xf4;
        if((r3 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r1 = 0xffff0000;
          r1 = r0 + r1;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
        }

        //LAB_80e8610
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r3 = r3 - 0xfc;
        if((r3 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r3 = r3 - 0xfa;
          r3 = r3 << 16;
          r3 = r2 - r3;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
        }

        //LAB_80e8624
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r6 = 0x103;
        if(r3 <= r6) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r3 = 0xff;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = r3 << 24;
          r2 = 0x77f4;
          MEMORY.ref(4, CPU.sp().value + 0x48).setu(r3);
          r3 = r0 + r3;
          MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r3);
          r3 = r1 + r2;
          r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r7);
          drawSprite_(MEMORY.ref(4, r3).deref(4).cast(Sprite38::new), CPU.sp().value + 0x44, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0);
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(MEMORY.ref(4, CPU.sp().value + 0x14).get() + 0x200000);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get() + 0x77f8;
          drawSprite_(MEMORY.ref(4, r3).deref(4).cast(Sprite38::new), CPU.sp().value + 0x44, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0);
        }

        //LAB_80e866e
        r6 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = 0x0;
        MEMORY.ref(4, r6 + 0x4).setu(r3);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r0 = 0xe1;
        r0 = r0 << 7;
        CPU.r8().value = r3;
        CPU.r11().value = r6;
        r5 = r7 + r0;
        CPU.r9().value = r7;

        //LAB_80e8682
        do {
          r3 = MEMORY.ref(4, r5 + 0x18).get();
          if(r3 != 0x2) {
            //LAB_80e868a
            r3 = MEMORY.ref(4, r5).get();
            r1 = CPU.r11().value;
            MEMORY.ref(4, r1).setu(r3);
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r2 = CPU.r8().value;
            MEMORY.ref(4, r1 + 0x8).setu(r3);
            r3 = r2 << 2;
            r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r3 = r3 + 0x77fc;
            drawSprite_(MEMORY.ref(4, r7 + r3).deref(4).cast(Sprite38::new), r1, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0);
            r3 = MEMORY.ref(4, r5).get();
            r2 = MEMORY.ref(4, r5 + 0xc).get();
            r3 = r3 + r2;
            MEMORY.ref(4, r5).setu(r3);
            r2 = MEMORY.ref(4, r5 + 0x10).get();
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r3 = r3 + r2;
            MEMORY.ref(4, r5 + 0x4).setu(r3);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            if(r0 > 0x60) {
              r1 = 0x80;
              r1 = r1 << 7;
              r3 = r2 + r1;
              MEMORY.ref(4, r5 + 0x10).setu(r3);
            }

            //LAB_80e86c6
            r2 = 0xf0;
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r2 = r2 << 15;
            if(r3 > r2) {
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              r3 = r3 + 0x1;
              MEMORY.ref(4, r5 + 0x18).setu(r3);
              if(r3 == 0x1) {
                r3 = MEMORY.ref(4, r5 + 0x10).get();
                r3 = -r3;
                r2 = r3 >>> 31;
                r3 = r3 + r2;
                r3 = r3 >> 1;
                r6 = 0x73c8;
                MEMORY.ref(4, r5 + 0x10).setu(r3);
                r3 = 0xff;
                r7 = 0x0;
                CPU.r10().value = r3;
                r6 = r6 + CPU.r9().value;

                //LAB_80e86f0
                do {
                  r3 = MEMORY.ref(4, r5).get();
                  r2 = r3 >>> 31;
                  r3 = r3 + r2;
                  r3 = r3 >> 1;
                  MEMORY.ref(4, r6).setu(r3);
                  r0 = 0xffe00000;
                  r3 = MEMORY.ref(4, r5 + 0x4).get();
                  r3 = r3 + r0;
                  MEMORY.ref(4, r6 + 0x4).setu(r3);
                  r0 = rand();
                  r1 = CPU.r10().value;
                  r0 = r0 & r1;
                  r0 = r0 - 0x7f;
                  r0 = r0 << 10;
                  MEMORY.ref(4, r6 + 0xc).setu(r0);
                  r0 = rand();
                  r2 = CPU.r10().value;
                  r0 = r0 & r2;
                  r0 = r0 - 0x7f;
                  r0 = r0 << 10;
                  MEMORY.ref(4, r6 + 0x10).setu(r0);
                  r0 = rand();
                  r3 = 0xf;
                  r3 = r3 & r0;
                  r7 = r7 + 0x1;
                  MEMORY.ref(4, r6 + 0x18).setu(r3);
                  r6 = r6 + 0x1c;
                } while(r7 != 0x2);
              } else {
                //LAB_80e8788
                r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                if(r3 <= 0xc7) {
                  r3 = 0x0;
                  MEMORY.ref(4, r5 + 0x4).setu(r3);
                  MEMORY.ref(4, r5 + 0x10).setu(r3);
                  MEMORY.ref(4, r5 + 0x18).setu(r3);
                }
              }
            }
          }

          //LAB_80e8796
          r7 = 0x1;
          CPU.r8().value = CPU.r8().value + r7;
          r6 = 0x38;
          r0 = CPU.r8().value;
          r5 = r5 + 0x1c;
          CPU.r9().value = CPU.r9().value + r6;
        } while(r0 != 0x6);

        //LAB_80e87a8
        r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r3 = 0x7128;
        r1 = 0x0;
        CPU.r8().value = r1;
        r5 = r2 + r3;

        //LAB_80e87b2
        do {
          r0 = MEMORY.ref(4, r5 + 0x18).get();
          if(r0 >= 0) {
            if((r0 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
              r1 = 0x6;
              r0 = divideS(r0, r1);
              r3 = 0x80eeeea;
              r0 = r0 + 0x3;
              r0 = r0 << 1;
              r1 = MEMORY.ref(2, r3 + r0).getUnsigned();
              r3 = 0x80eeef8;
              r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
              r4 = MEMORY.ref(2, r3 + r0).getUnsigned();
              r7 = 0x2;
              r2 = MEMORY.ref(2, r5 + r7).get();
              r1 = r6 + r1;
              r6 = 0x6;
              r3 = MEMORY.ref(2, r5 + r6).get();
              r0 = r4 >>> 1;
              r2 = r2 - r0;
              r3 = r3 - r0;
              MEMORY.ref(4, CPU.sp().value).setu(r4);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
              r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }

            //LAB_80e87ec
            r0 = r5;
            r1 = 0x3c;
            r2 = 0xffffc000;
            FUN_80e3908(r0, r1, r2);
            r3 = MEMORY.ref(4, r5 + 0x18).get();
            r3 = r3 + 0x1;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
          }

          //LAB_80e87fc
          r7 = 0x1;
          CPU.r8().value = CPU.r8().value + r7;
          r0 = CPU.r8().value;
          r5 = r5 + 0x1c;
        } while(r0 != 0x38);

        r2 = 0x82;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r2 = r2 << 1;
        if(r1 == r2) {
          r3 = 0x0;
          CPU.r8().value = r3;
          r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = 0x7828;
          r3 = MEMORY.ref(4, r6 + r3).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          if(r3 != 0) {
            r7 = 0x7828;
            r5 = r6 + r7;
            r6 = 0x24;

            //LAB_80e8828
            do {
              r3 = MEMORY.ref(4, r5).get();
              r0 = MEMORY.ref(2, r3 + r6).get();
              r1 = 0x4;
              FUN_80b5088(r0, r1);
              r3 = MEMORY.ref(4, r5).get();
              r0 = MEMORY.ref(2, r3 + r6).get();
              r3 = 0x8;
              r2 = 0x1;
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              r1 = 0x7;
              r3 = CPU.r8().value;
              r2 = -r2;
              FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
              r3 = 0x1;
              CPU.r8().value = CPU.r8().value + r3;
              r3 = MEMORY.ref(4, r5).get();
              r3 = MEMORY.ref(4, r3 + 0x14).get();
              r6 = r6 + 0x2;
            } while(CPU.r8().value != r3);
          }

          //LAB_80e8854
          r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r7 = 0x77a8;
          r3 = 0x8;
          r2 = r6 + r7;
          MEMORY.ref(4, r2).setu(r3);
          r1 = 0x82;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r1 = r1 << 1;
          if(r0 == r1) {
            r2 = 0x0;
            r7 = 0x2010000;
            CPU.r8().value = r2;

            //LAB_80e886e
            do {
              r0 = rand();
              r5 = 0x3ff;
              r5 = r5 & r0;
              r0 = rand();
              r3 = 0xffff;
              r6 = r0;
              r6 = r6 & r3;
              r3 = 0x80;
              r3 = r3 << 14;
              MEMORY.ref(4, r7).setu(r3);
              r3 = 0xb8;
              r3 = r3 << 15;
              MEMORY.ref(4, r7 + 0x4).setu(r3);
              r0 = r6;
              r0 = sin(r0);
              r5 = r5 + 0x20;
              r3 = r5;
              r3 = r3 * r0;
              r3 = r3 >> 7;
              MEMORY.ref(4, r7 + 0xc).setu(r3);
              r0 = r6;
              r0 = cos(r0);
              r3 = r5;
              r3 = r3 * r0;
              r3 = r3 << 1;
              r3 = -r3;
              r3 = r3 >> 7;
              MEMORY.ref(4, r7 + 0x10).setu(r3);
              r0 = rand();
              r3 = 0xf;
              r3 = r3 & r0;
              r3 = r3 + 0x20;
              MEMORY.ref(4, r7 + 0x18).setu(r3);
              r6 = 0x80;
              r3 = 0x1;
              CPU.r8().value = CPU.r8().value + r3;
              r6 = r6 << 2;
              r7 = r7 + 0x1c;
            } while(CPU.r8().value != r6);
          }
        }

        //LAB_80e88c8
        r0 = 0x80ede48;
        r7 = 0x0;
        r6 = 0x2010000;
        CPU.r8().value = r7;
        CPU.r10().value = r0;

        //LAB_80e88d2
        do {
          r0 = MEMORY.ref(4, r6 + 0x18).get();
          if(r0 >= 0) {
            r0 = r0 >> 3;
            r0 = r0 + 0x1;
            r5 = r0 << 1;
            r1 = CPU.r8().value;
            r3 = r5 - 0x2;
            r2 = CPU.r10().value;
            r4 = 0x1;
            r4 = r4 & r1;
            r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r1 = r3 + r1;
            r3 = r0 >>> 31;
            r7 = 0x2;
            r2 = MEMORY.ref(2, r6 + r7).get();
            r3 = r0 + r3;
            r3 = r3 >> 1;
            r2 = r2 - r3;
            r7 = 0x6;
            r3 = MEMORY.ref(2, r6 + r7).get();
            MEMORY.ref(4, CPU.sp().value).setu(r0);
            r3 = r3 - r0;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r4 = r4 << 2;
            r4 = MEMORY.ref(4, r4 + r0).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r2 = 0x80;
            r0 = r6;
            r1 = 0x3e;
            r2 = r2 << 5;
            FUN_80e3908(r0, r1, r2);
            r3 = MEMORY.ref(4, r6 + 0x18).get();
            r3 = r3 - 0x1;
            MEMORY.ref(4, r6 + 0x18).setu(r3);
          }

          //LAB_80e8922
          r1 = 0x1;
          r2 = 0x80;
          CPU.r8().value = CPU.r8().value + r1;
          r2 = r2 << 2;
          r6 = r6 + 0x1c;
        } while(CPU.r8().value != r2);

        r0 = 0x8;
        r1 = 0x8;
        FUN_80e155c(r0, r1);
        FUN_80cd52c();
        r6 = 0x7824;
        r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r2 = r3 + r6;
        r3 = 0x1;
        r0 = 0x1;
        MEMORY.ref(4, r2).setu(r3);
        sleep(r0);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r0 = 0xa0;
        r7 = r7 + 0x1;
        r0 = r0 << 1;
        MEMORY.ref(4, CPU.sp().value + 0x28).setu(r7);
        if(r7 == r0) {
          break;
        }
        r3 = 0x3001b04;
        r3 = MEMORY.ref(4, r3).get();
        r2 = 0x3;
        r3 = r3 & r2;
        if(r3 != 0) {
          break;
        }
      } while(true);
    }

    //LAB_80e8968
    r0 = 0x86;
    FUN_80b50e8(r0);
    FUN_80d67dc();
    r3 = 0x77d8;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r1 = 0x0;
    CPU.r8().value = r1;
    r5 = r2 + r3;

    //LAB_80e897c
    do {
      clearSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new));
      r5 += 0x4;
      CPU.r8().value++;
    } while(CPU.r8().value < 15);

    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    r0 = 0x2f;
    freeSlot(r0);
    r0 = 0x2e;
    freeSlot(r0);
    FUN_80cdbc0();
    CPU.sp().value += 0x54;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80ea0d8)
  public static void FUN_80ea0d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80eb754)
  public static void FUN_80eb754(int r0) {
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
    r5 = 0x3001ef0;
    r1 = MEMORY.ref(4, r5).get();
    CPU.sp().value -= 0xb0;
    MEMORY.ref(4, CPU.sp().value + 0x50).setu(r1);
    r3 = r5 - 0x4;
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r3);
    r4 = 0x7828;
    r2 = MEMORY.ref(4, r5 + 0x4).get();
    r6 = r3 + r4;
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(r2);
    MEMORY.ref(4, r6).setu(r0);
    r0 = 0x0;
    FUN_80cd594(r0);
    FUN_80c9048();
    r2 = 0x400000c;
    r3 = 0x784;
    MEMORY.ref(2, r2).setu(r3);
    r2 = 0x0;
    r3 = 0xa0;
    r3 = r3 << 19;
    MEMORY.ref(2, r3).setu(r2);
    r3 = r3 + 0x2;
    MEMORY.ref(2, r3).setu(r2);
    r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r0 = 0xef;
    r0 = r0 << 7;
    r3 = 0x0;
    r7 = r7 + r0;
    MEMORY.ref(4, r7).setu(r3);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    r0 = 0x1;
    r1 = 0x0;
    FUN_80cd104(r0, r1);
    r1 = 0x175;
    r0 = 0x9;
    r2 = 0x1;
    FUN_80dbb24(r0, r1, r2);
    r2 = 0x3001ce0;
    r3 = 0xf0;
    MEMORY.ref(4, r2 + 0x10).setu(r3);
    r0 = MEMORY.ref(4, r6).get();
    FUN_80d6750(r0);
    r2 = 0x4000048;
    r3 = 0x2737;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0xca;
    r2 = r2 - 0x8;
    MEMORY.ref(2, r2).setu(r3);
    r0 = 0x1;
    sleep(r0);
    r2 = 0x0;
    r1 = 0x3a;
    r0 = 0x1;
    FUN_80b5040(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    FUN_80cd104(r0, r1);
    r0 = 0x73;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
    r2 = 0x0;
    r3 = 0x0;
    FUN_80e0524(r0, r1, r2, r3);
    r0 = 0x95;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r2 = 0x1;
    r3 = 0x1;
    FUN_80e0524(r0, r1, r2, r3);
    r3 = 0x7741;
    r2 = 0x80;
    r2 = r2 << 19;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x80;
    r2 = r2 + 0x20;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x100e;
    r2 = r2 + 0x32;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x3f44;
    r1 = 0x0;
    r2 = r2 - 0x2;
    MEMORY.ref(2, r2).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r1);
    r3 = 0x3001ad0;
    r3 = MEMORY.ref(2, r3 + 0x4).getUnsigned();
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(r3);
    r5 = MEMORY.ref(4, r5 + 0x10).get();
    r2 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
    MEMORY.ref(4, r7).setu(r2);
    r4 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r7 = 0x7784;
    r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
    r3 = r4 + r7;
    MEMORY.ref(4, r3).setu(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
    r3 = 0xe1;
    MEMORY.ref(4, r1 + 0x10).setu(r2);
    r3 = r3 << 7;
    r2 = 0x0;
    CPU.r8().value = r2;
    r6 = 0x1f;
    r5 = r4 + r3;

    //LAB_80eb8a6
    do {
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 + 0x10;
      MEMORY.ref(4, r5).setu(r0);
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 + 0x30;
      r0 = r0 << 16;
      MEMORY.ref(4, r5 + 0x4).setu(r0);
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 - 0x10;
      r0 = r0 << 16;
      MEMORY.ref(4, r5 + 0x10).setu(r0);
      r0 = rand();
      r1 = 0x30;
      r0 = modU(r0, r1);
      r4 = 0x1;
      CPU.r8().value = CPU.r8().value + r4;
      r0 = r0 + 0x2;
      r7 = CPU.r8().value;
      MEMORY.ref(4, r5 + 0x18).setu(r0);
      r5 = r5 + 0x1c;
    } while(r7 != 0x40);

    r3 = 0x3;
    r2 = 0x7;
    r0 = 0x2e;
    r1 = 0x7;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r3 = 0x3001e50;
    r3 = r3 + 0xb8;
    r3 = MEMORY.ref(4, r3).get();
    r2 = 0x400000c;
    MEMORY.ref(4, CPU.sp().value + 0x48).setu(r3);
    r0 = 0x0;
    r3 = 0x786;
    CPU.r11().value = r0;
    MEMORY.ref(2, r2).setu(r3);

    //LAB_80ebc56
    do {
      r7 = CPU.r11().value;
      if(r7 == 0x78) {
        break;
      }
      r0 = 0x0;
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0);
      if(r7 == 0) {
        r0 = 0x88;
        playSound_(r0);
      }

      //LAB_80ebc6a
      r1 = CPU.r11().value;
      if(r1 == 0x1a) {
        r0 = 0x8d;
        playSound_(r0);
      }

      //LAB_80ebc76
      r2 = CPU.r11().value;
      if(r2 == 0x28) {
        r0 = 0x9a;
        playSound_(r0);
      }

      //LAB_80ebc82
      r3 = CPU.r11().value;
      if(r3 == 0x48) {
        r0 = 0x9a;
        playSound_(r0);
      }

      //LAB_80ebc8e
      r4 = CPU.r11().value;
      if(r4 == 0x68) {
        r0 = 0x9a;
        playSound_(r0);
      }

      //LAB_80ebc9a
      r3 = 0x3001b04;
      r3 = MEMORY.ref(4, r3).get();
      r2 = 0x3;
      r3 = r3 & r2;
      if(r3 != 0) {
        //LAB_80ebca8
        r7 = CPU.r11().value;
        if(r7 > 0x10) {
          break;
        }
      }

      //LAB_80eb914
      r3 = CPU.r11().value;
      r3 = r3 - 0x18;
      if((r3 & 0xffff_ffffL) <= (0x1f & 0xffff_ffffL)) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r1 = r1 + 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
      }

      //LAB_80eb922
      r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      if(r2 > 0x18) {
        r3 = 0x18;
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
      }

      //LAB_80eb92c
      r4 = CPU.r11().value;
      if(r4 <= 0x87) {
        r7 = 0x3001ad0;
        r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r3 = MEMORY.ref(2, r7 + 0x4).getUnsigned();
        r1 = r7;
        r3 = r3 - r0;
        MEMORY.ref(2, r1 + 0x4).setu(r3);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r2 = r2 + r0;
        MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r2);
      }

      //LAB_80eb944
      r3 = CPU.r11().value;
      if(r3 <= 0x95) {
        r3 = 0x80edad8;
        r4 = MEMORY.ref(4, r3 + 0x4).get();
        r3 = MEMORY.ref(4, r3).get();
        r7 = CPU.r11().value;
        MEMORY.ref(4, CPU.sp().value + 0x5c).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x60).setu(r4);
        r4 = 0x0;
        CPU.r10().value = r4;
        if(r7 > 0x67) {
          r0 = 0xfffff980;
          r3 = r7 << 4;
          r0 = r0 + r3;
          CPU.r10().value = r0;
        }

        //LAB_80eb966
        r3 = CPU.r11().value;
        r3 = r3 - 0x8;
        if((r3 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r3 = r1 + r2;
          r3 = r3 - 0x8;
          MEMORY.ref(4, CPU.sp().value + 0x40).setu(r3);
        }

        //LAB_80eb978
        r3 = CPU.r11().value;
        if(r3 > 0x7) {
          r5 = 0x60;
          if(r3 <= 0x68) {
            r5 = 0x20;
          }

          //LAB_80eb986
          r4 = CPU.r11().value;
          r7 = 0xffffe000;
          r3 = r4 << 10;
          r0 = r3 + r7;
          r3 = 0xffff;
          r1 = 0x80;
          r0 = r0 & r3;
          r1 = r1 << 8;
          if(r0 > r1) {
            r2 = 0xffff8000;
            r0 = r0 + r2;
          }

          //LAB_80eb99e
          r0 = sin(r0);
          r3 = r5;
          r3 = r3 * r0;
          r3 = r3 >> 16;
          MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
          r4 = CPU.r11().value;
          r3 = 0x1f;
          r3 = r3 & r4;
          if(r3 == 0x8) {
            r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
            r0 = 0x77a8;
            r3 = 0x4;
            r2 = r7 + r0;
            MEMORY.ref(4, r2).setu(r3);
          }
        }

        //LAB_80eb9be
        r3 = CPU.sp().value + 0xa0;
        r2 = 0x0;
        MEMORY.ref(4, r3 + 0xc).setu(r2);
        r2 = 0xff;
        r2 = r2 << 16;
        MEMORY.ref(4, r3 + 0x4).setu(r2);
        r6 = r3;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r3 = 0x77d8;
        r1 = 0x0;
        CPU.r8().value = r1;
        r7 = CPU.sp().value + 0x5c;
        r5 = r2 + r3;

        //LAB_80eb9d8
        do {
          r3 = 0x80eef56;
          r4 = CPU.r8().value;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          r3 = MEMORY.ref(1, r3 + r4).getUnsigned();
          r1 = CPU.r10().value;
          r3 = r0 + r3;
          r3 = r3 - r1;
          r3 = r3 << 16;
          r3 = r3 + 0xe00000;
          MEMORY.ref(4, r6).setu(r3);
          r3 = 0x80eef5f;
          r3 = MEMORY.ref(1, r3 + r4).getUnsigned();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = r3 - r4;
          r3 = r3 << 16;
          r3 = r3 + 0x480000;
          MEMORY.ref(4, r6 + 0x8).setu(r3);
          drawSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new), r6, r7, 0);
          r5 += 0x4;
          CPU.r8().value++;
        } while(CPU.r8().value < 9);
      }

      //LAB_80eba18
      r3 = CPU.r11().value;
      if(r3 <= 0x1a) {
        r7 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r3 = r3 << 3;
        r7 = r7 + 0x4;
        CPU.r10().value = r3;
        if(r7 > 0xa) {
          r7 = 0xa;
        }

        //LAB_80eba2c
        r4 = CPU.r10().value;
        if(r4 > 0x40) {
          r0 = 0x40;
          CPU.r10().value = r0;
        }

        //LAB_80eba36
        r1 = 0x0;
        r2 = CPU.r10().value;
        CPU.r8().value = r1;
        if(r2 != 0x0) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r3 = r3 << 1;
          MEMORY.ref(4, CPU.sp().value + 0x28).setu(r3);
          r3 = r3 + r4;
          r3 = r3 << 2;
          r3 = r3 + 0x30;
          MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
          r3 = r7 >>> 31;
          r3 = r7 + r3;
          r3 = r3 >> 1;
          r0 = r7 << 1;
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
          CPU.r9().value = r0;

          //LAB_80eba5c
          do {
            r1 = CPU.r8().value;
            r6 = r1 << 10;
            r0 = r6;
            r0 = sin(r0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = r3 + 0x8;
            r5 = r3;
            r5 = r5 * r0;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            r5 = r5 >> 16;
            r0 = r6;
            r5 = r5 + r2;
            r0 = cos(r0);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r3 = r4;
            r3 = r3 * r0;
            r2 = CPU.r9().value;
            r0 = 0x80ede48;
            r4 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
            r2 = r2 - 0x2;
            r1 = MEMORY.ref(2, r0 + r2).getUnsigned();
            r5 = r5 + 0x60;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            r3 = r3 >> 16;
            r5 = r5 - r4;
            r0 = CPU.r9().value;
            r3 = r3 + 0x40;
            r1 = r2 + r1;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            r3 = r3 - r7;
            MEMORY.ref(4, CPU.sp().value).setu(r7);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
            r2 = r5;
            r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r0 = 0x1;
            CPU.r8().value = CPU.r8().value + r0;
            CPU.cmpT(CPU.r8().value, CPU.r10().value);
          } while(CPU.r8().value != CPU.r10().value);
        }
      }

      //LAB_80ebab0
      r1 = CPU.r11().value;
      if(r1 == 0x18) {
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r4 = 0xef;
        r4 = r4 << 7;
        r2 = r3 + r4;
        r3 = 0x2;
        MEMORY.ref(4, r2).setu(r3);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r0 = 0x7784;
        r3 = 0x32;
        r2 = r7 + r0;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_80ebacc
      r1 = CPU.r11().value;
      if(r1 == 0x1c) {
        r2 = 0x400000c;
        r3 = 0x784;
        MEMORY.ref(2, r2).setu(r3);
      }

      //LAB_80ebad8
      r2 = CPU.r11().value;
      if(r2 > 0x11) {
        r4 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r7 = 0xe1;
        r3 = 0x0;
        r7 = r7 << 7;
        CPU.r8().value = r3;
        r6 = 0x1f;
        r5 = r4 + r7;

        //LAB_80ebaec
        do {
          r3 = MEMORY.ref(4, r5 + 0x18).get();
          if(r3 == 0) {
            r1 = 0x3;
            r0 = CPU.r8().value;
            r0 = modS(r0, r1);
            r0 = r0 + 0x1;
            r4 = r0 << 1;
            r2 = 0x80ede48;
            r3 = r4 - 0x2;
            r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
            r7 = 0x6;
            r3 = MEMORY.ref(2, r5 + r7).get();
            r2 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            r3 = r3 - r0;
            r1 = r2 + r1;
            r2 = MEMORY.ref(4, r5).get();
            MEMORY.ref(4, CPU.sp().value).setu(r0);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r3 = MEMORY.ref(4, r5).get();
            r3 = r3 + 0x2;
            r2 = MEMORY.ref(4, r5 + 0x10).get();
            MEMORY.ref(4, r5).setu(r3);
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r3 = r3 + r2;
            MEMORY.ref(4, r5 + 0x4).setu(r3);
            r3 = r2 << 1;
            r3 = r3 + r2;
            r3 = r3 << 4;
            if(r3 < 0) {
              r3 = r3 + 0x3f;
            }

            //LAB_80ebb72
            r3 = r3 >> 6;
            MEMORY.ref(4, r5 + 0x10).setu(r3);
          } else {
            //LAB_80ebb78
            r3 = r3 - 0x1;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
          }

          //LAB_80ebb7c
          r3 = MEMORY.ref(4, r5).get();
          if(r3 > 0x80 || MEMORY.ref(4, r5 + 0x18).get() == 0x1) {
            //LAB_80ebb88
            r0 = rand();
            r7 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r0 = r0 & r6;
            r0 = r0 + r7;
            r0 = r0 + 0xac;
            MEMORY.ref(4, r5).setu(r0);
            r0 = rand();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r0 = r0 & r6;
            r0 = r0 - r1;
            r0 = r0 + 0x38;
            r0 = r0 << 16;
            MEMORY.ref(4, r5 + 0x4).setu(r0);
            r0 = rand();
            r0 = r0 & r6;
            r0 = r0 - 0x10;
            r0 = r0 << 15;
            MEMORY.ref(4, r5 + 0x10).setu(r0);
          }

          //LAB_80ebbb2
          r2 = 0x1;
          CPU.r8().value = CPU.r8().value + r2;
          r3 = CPU.r8().value;
          r5 = r5 + 0x1c;
        } while(r3 != 0x30);
      }

      //LAB_80ebbbe
      r4 = CPU.r11().value;
      if(r4 > 0x1f) {
        r3 = CPU.r11().value;
        r3 = r3 - 0x20;
        r2 = r3 >>> 31;
        r3 = r3 + r2;
        r5 = r3 >> 1;
        if(r5 > 0x28) {
          r5 = 0x28;
        }

        //LAB_80ebbd4
        r7 = 0x0;
        CPU.r8().value = r7;
        r6 = 0x0;
        r7 = 0x78;

        //LAB_80ebbdc
        do {
          r0 = rand();
          r3 = 0x3;
          r0 = r0 & r3;
          r1 = r0 << 1;
          r1 = r1 + r0;
          r3 = 0x30;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r1 = r1 << 9;
          r3 = 0x20;
          r1 = r0 + r1;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
          r3 = r6;
          r2 = r7 - r5;
          r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x1;
          CPU.r8().value = CPU.r8().value + r0;
          r1 = CPU.r8().value;
          r6 = r6 + 0x12;
        } while(r1 != 0x6);
      }

      //LAB_80ebc0e
      r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
      r4 = 0x77a8;
      r2 = r3 + r4;
      r3 = MEMORY.ref(4, r2).get();
      if(r3 > 0) {
        r3 = r3 - 0x1;
        MEMORY.ref(4, r2).setu(r3);
        r0 = rand();
        r3 = 0x7;
        r7 = 0x3001ad0;
        r0 = r0 & r3;
        r0 = r0 + 0x1c;
        MEMORY.ref(2, r7 + 0x6).setu(r0);
      } else {
        //LAB_80ebc3c
        r0 = 0x3001ad0;
        r3 = 0x20;
        MEMORY.ref(2, r0 + 0x6).setu(r3);
      }

      //LAB_80ebc42
      r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
      r3 = 0x7824;
      r2 = r1 + r3;
      r3 = 0x1;
      MEMORY.ref(4, r2).setu(r3);
      r0 = 0x1;
      sleep(r0);
      r4 = 0x1;
      CPU.r11().value = CPU.r11().value + r4;
    } while(true);

    //LAB_80ebcb0
    r0 = CPU.sp().value + 0x38;
    r3 = 0x3001ad0;
    r0 = MEMORY.ref(2, r0).getUnsigned();
    MEMORY.ref(2, r3 + 0x4).setu(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
    r2 = 0x0;
    MEMORY.ref(4, r1 + 0x10).setu(r2);
    FUN_80d67dc();
    r2 = 0x4000040;
    r3 = 0xf0;
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r4 = 0x77d8;
    r2 = 0x0;
    CPU.r8().value = r2;
    r0 = 0xc;
    r1 = r3 + r4;

    //LAB_80ebcd4
    do {
      r2 = MEMORY.ref(4, r1).get();
      r1 += 0x4;
      r3 = MEMORY.ref(1, r2 + 0x9).getUnsigned();
      r7 = 0x1;
      r3 = r3 | r0;
      CPU.r8().value = CPU.r8().value + r7;
      MEMORY.ref(1, r2 + 0x9).setu(r3);
      r2 = CPU.r8().value;
    } while(r2 != 0x9);

    r4 = CPU.sp().value;
    r4 = r4 + 0x74;
    r3 = 0xe0;
    r2 = CPU.sp().value;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r4);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r3);
    r1 = 0x0;
    r3 = r4;
    r2 = r2 + 0x82;

    //LAB_80ebd14
    do {
      MEMORY.ref(1, r3).setu(r1);
      r3 = r3 + 0x1;
    } while(r3 != r2);

    r7 = CPU.sp().value;
    r7 = r7 + 0x84;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r7);
    r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r7 = 0x1f;
    r6 = CPU.sp().value + 0x94;

    //LAB_80ebd28
    do {
      r0 = rand();
      r0 = r0 & r7;
      MEMORY.ref(1, r5).setu(r0);
      r5 = r5 + 0x1;
    } while(r5 != r6);

    r0 = 0x0;
    r2 = 0xa0;
    r3 = 0x2010018;
    CPU.r8().value = r0;
    r1 = 0x0;
    r2 = r2 << 1;

    //LAB_80ebd42
    do {
      r4 = 0x1;
      CPU.r8().value = CPU.r8().value + r4;
      MEMORY.ref(4, r3).setu(r1);
      r3 = r3 + 0x1c;
    } while(CPU.r8().value != r2);

    r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r0 = 0xef;
    r0 = r0 << 7;
    r1 = 0x7784;
    r2 = r7 + r0;
    r3 = 0x2;
    MEMORY.ref(4, r2).setu(r3);
    r2 = r7 + r1;
    r3 = 0x4b;
    MEMORY.ref(4, r2).setu(r3);
    r2 = 0x400000c;
    r3 = 0x784;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x1010;
    r2 = r2 + 0x46;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0xfffffe20;
    r2 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
    CPU.r11().value = r2;

    //LAB_80ebd76
    do {
      r4 = CPU.r11().value;
      if(r4 <= 0x17) {
        r3 = 0x80edae0;
        r7 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r4 = MEMORY.ref(4, r3 + 0x4).get();
        r3 = MEMORY.ref(4, r3).get();
        r7 = r7 - 0x10;
        r0 = CPU.r11().value;
        MEMORY.ref(4, CPU.sp().value + 0x54).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x58).setu(r4);
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r7);
        if(r0 <= 0x8) {
          r1 = 0x80;
          r3 = r0 << 11;
          r1 = r1 << 7;
          r2 = 0x80;
          r0 = r3 + r1;
          r2 = r2 << 8;
          if(r0 > r2) {
            r4 = 0xffffc000;
            r0 = r3 + r4;
          }

          //LAB_80ebdc4
          r0 = sin(r0);
          r0 = r0 << 6;
        } else {
          //LAB_80ebdcc
          r7 = CPU.r11().value;
          r1 = 0x80;
          r3 = r7 << 11;
          r1 = r1 << 7;
          r2 = 0x80;
          r0 = r3 + r1;
          r2 = r2 << 8;
          if(r0 > r2) {
            r4 = 0xffffc000;
            r0 = r3 + r4;
          }

          //LAB_80ebde2
          r0 = sin(r0);
          r0 = r0 << 5;
        }

        //LAB_80ebde8
        r4 = r0 >> 16;
        r3 = CPU.sp().value + 0x64;
        r2 = 0x0;
        MEMORY.ref(4, r3 + 0xc).setu(r2);
        r2 = 0xff;
        r2 = r2 << 16;
        MEMORY.ref(4, r3 + 0x4).setu(r2);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r1 = 0x77d8;
        r7 = 0x0;
        CPU.r8().value = r7;
        r6 = r3;
        r7 = CPU.sp().value + 0x54;
        r5 = r0 + r1;

        //LAB_80ebe04
        do {
          r3 = 0x80eef56;
          r2 = CPU.r8().value;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r3 = MEMORY.ref(1, r3 + r2).getUnsigned();
          r3 = r0 + r3;
          r3 = r3 << 16;
          MEMORY.ref(4, r6).setu(r3);
          r3 = 0x80eef5f;
          r3 = MEMORY.ref(1, r3 + r2).getUnsigned();
          r3 = r3 - r4;
          r3 = r3 << 16;
          r3 = r3 + 0x480000;
          MEMORY.ref(4, r6 + 0x8).setu(r3);
          drawSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new), r6, r7, 0);
          r5 += 0x4;
          CPU.r8().value++;
        } while(CPU.r8().value < 9);
      }

      //LAB_80ebe3c
      r4 = CPU.r11().value;
      if(r4 == 0x8) {
        r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(4, r7 + 0x77a8).setu(r4);
        playSound_(0x91);
      }

      //LAB_80ebe50
      if(CPU.r11().value == 0xb) {
        playSound_(0x91);
      }

      //LAB_80ebe5c
      if(CPU.r11().value == 0x2e) {
        playSound_(0x89);
      }

      //LAB_80ebe68
      r2 = 0x7828;
      r4 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
      r3 = 0x0;
      CPU.r8().value = r3;
      r3 = MEMORY.ref(4, r4 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0) {
        r0 = 0x0;
        r7 = 0x24;
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
        CPU.r9().value = r7;

        //LAB_80ebe80
        do {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r4 = CPU.r8().value;
          r3 = MEMORY.ref(1, r1 + r4).getUnsigned();
          if(r3 == 0x0) {
            r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
            r3 = MEMORY.ref(4, r7 + r2).get();
            r5 = CPU.sp().value + 0x94;
            r1 = CPU.r9().value;
            r0 = MEMORY.ref(2, r3 + r1).get();
            r1 = r5;
            FUN_80e3980(r0, r1);
            r3 = MEMORY.ref(4, r5).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            if(r3 > r4) {
              r7 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r3 = 0x1;
              r0 = CPU.r8().value;
              MEMORY.ref(1, r7 + r0).setu(r3);
              r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              r2 = 0x2010000;
              CPU.r10().value = r5;
              r6 = 0x0;
              r7 = 0xff;
              r5 = r1 + r2;

              //LAB_80ebeb6
              do {
                r4 = CPU.r10().value;
                r3 = MEMORY.ref(4, r4).get();
                r3 = r3 << 15;
                MEMORY.ref(4, r5).setu(r3);
                r3 = MEMORY.ref(4, r4 + 0x4).get();
                r3 = r3 - 0x10;
                r3 = r3 << 16;
                MEMORY.ref(4, r5 + 0x4).setu(r3);
                r0 = rand();
                r0 = r0 & r7;
                r0 = r0 - 0x80;
                r0 = r0 << 10;
                MEMORY.ref(4, r5 + 0xc).setu(r0);
                r0 = rand();
                r0 = r0 & r7;
                r0 = r0 - 0xc0;
                r3 = r0 << 11;
                r2 = MEMORY.ref(4, r5 + 0xc).get();
                MEMORY.ref(4, r5 + 0x10).setu(r3);
                r3 = MEMORY.ref(4, r5).get();
                r2 = r2 << 2;
                r3 = r3 + r2;
                MEMORY.ref(4, r5).setu(r3);
                r3 = MEMORY.ref(4, r5 + 0x4).get();
                r0 = r0 << 13;
                r3 = r3 + r0;
                MEMORY.ref(4, r5 + 0x4).setu(r3);
                r0 = rand();
                r3 = 0xf;
                r3 = r3 & r0;
                r3 = r3 + 0x8;
                r6 = r6 + 0x1;
                MEMORY.ref(4, r5 + 0x18).setu(r3);
                r5 = r5 + 0x1c;
              } while(r6 != 0x20);

              r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
              r0 = 0x7828;
              r3 = r7 + r0;
              r3 = MEMORY.ref(4, r3).get();
              r1 = CPU.r9().value;
              r0 = MEMORY.ref(2, r3 + r1).get();
              r1 = 0x1;
              FUN_80b5088(r0, r1);
              r0 = 0x86;
              playSound_(r0);
            }
          }

          //LAB_80ebf1c
          r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r7 = 0xe0;
          r7 = r7 << 2;
          r4 = r4 + r7;
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
          r2 = 0x7828;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
          r3 = 0x2;
          CPU.r9().value = CPU.r9().value + r3;
          r3 = MEMORY.ref(4, r1 + r2).get();
          r0 = 0x1;
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          CPU.r8().value = CPU.r8().value + r0;
        } while(CPU.r8().value != r3);
      }

      //LAB_80ebf3a
      r2 = 0x0;
      r5 = 0x2010000;
      CPU.r8().value = r2;
      r7 = 0x3;
      r6 = 0x6;

      //LAB_80ebf44
      do {
        r3 = MEMORY.ref(4, r5 + 0x18).get();
        if(r3 > 0) {
          r3 = 0x80ede48;
          r1 = MEMORY.ref(2, r3 + 0x4).getUnsigned();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          r4 = 0x2;
          r2 = MEMORY.ref(2, r5 + r4).get();
          r1 = r3 + r1;
          r0 = 0x6;
          r3 = MEMORY.ref(2, r5 + r0).get();
          r2 = r2 - 0x1;
          r3 = r3 - 0x3;
          MEMORY.ref(4, CPU.sp().value).setu(r7);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = MEMORY.ref(4, r5).get();
          r2 = MEMORY.ref(4, r5 + 0xc).get();
          r3 = r3 + r2;
          MEMORY.ref(4, r5).setu(r3);
          r2 = MEMORY.ref(4, r5 + 0x10).get();
          r3 = MEMORY.ref(4, r5 + 0x4).get();
          r3 = r3 + r2;
          MEMORY.ref(4, r5 + 0x4).setu(r3);
          r3 = MEMORY.ref(4, r5 + 0x18).get();
          r3 = r3 - 0x1;
          MEMORY.ref(4, r5 + 0x18).setu(r3);
        }

        //LAB_80ebf80
        r0 = 0x1;
        CPU.r8().value = CPU.r8().value + r0;
        r1 = CPU.r8().value;
        r5 = r5 + 0x1c;
      } while(r1 != 0xc0);

      r2 = CPU.r11().value;
      if(r2 == 0x30) {
        r0 = 0x88;
        playSound_(r0);
      }

      //LAB_80ebf98
      r3 = CPU.r11().value;
      if(r3 > 0x28) {
        r4 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r7 = 0xef;
        r7 = r7 << 7;
        r0 = 0x7784;
        r2 = r4 + r7;
        r3 = 0x0;
        r6 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        MEMORY.ref(4, r2).setu(r3);
        r2 = r4 + r0;
        r3 = 0x4b;
        r1 = 0x0;
        r5 = 0x8;
        MEMORY.ref(4, r2).setu(r3);
        CPU.r8().value = r1;
        r5 = -r5;

        //LAB_80ebfbc
        do {
          r0 = rand();
          r3 = 0x3;
          r0 = r0 & r3;
          r1 = r0 << 1;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r1 = r1 + r0;
          r4 = CPU.r8().value;
          r1 = r1 << 9;
          r1 = r2 + r1;
          r2 = MEMORY.ref(1, r3 + r4).getUnsigned();
          r3 = 0x30;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r2 = r2 - r6;
          r3 = 0x20;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r2 = r2 + 0x78;
          r3 = r5;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
          r7 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
          MEMORY.call(r7, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x1;
          CPU.r8().value = CPU.r8().value + r0;
          r1 = CPU.r8().value;
          r5 = r5 + 0x8;
        } while(r1 != 0x10);
      }

      //LAB_80ebff6
      r2 = CPU.r11().value;
      if(r2 > 0x40) {
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r4 = 0xef;
        r4 = r4 << 7;
        r2 = r3 + r4;
        r3 = 0x2;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_80ec008
      r7 = CPU.r11().value;
      if(r7 == 0x3a) {
        r3 = 0x7828;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r3 = MEMORY.ref(4, r1 + r3).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        r0 = 0x0;
        CPU.r8().value = r0;
        if(r3 != 0) {
          r2 = 0x7828;
          r6 = 0x24;
          r5 = r1 + r2;

          //LAB_80ec024
          do {
            r3 = MEMORY.ref(4, r5).get();
            r0 = MEMORY.ref(2, r3 + r6).get();
            r3 = 0x0;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            r1 = 0xe;
            r3 = r3 - 0x1;
            r2 = 0x5;
            FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
            r3 = MEMORY.ref(4, r5).get();
            r7 = 0x1;
            r3 = MEMORY.ref(4, r3 + 0x14).get();
            CPU.r8().value = CPU.r8().value + r7;
            r6 = r6 + 0x2;
          } while(CPU.r8().value != r3);
        }
      }

      //LAB_80ec044
      r0 = 0x8;
      r1 = 0x8;
      FUN_80e155c(r0, r1);
      FUN_80cd52c();
      r1 = 0x7824;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
      r3 = 0x1;
      r2 = r0 + r1;
      MEMORY.ref(4, r2).setu(r3);
      r0 = 0x1;
      sleep(r0);
      r3 = 0x1;
      r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      CPU.r11().value = CPU.r11().value + r3;
      r2 = r2 + 0xc;
      r4 = CPU.r11().value;
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    } while(r4 != 0x60);

    //LAB_80ec072
    FUN_80b50e8(0x86);
    CPU.r8().value = 0;
    r6 = MEMORY.ref(4, CPU.sp().value + 0x4c).get() + 0x77d8;

    //LAB_80ec082
    do {
      clearSprite_(MEMORY.ref(4, r6).deref(4).cast(Sprite38::new));
      r6 += 0x4;
      CPU.r8().value++;
    } while(CPU.r8().value < 9);

    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(46);
    FUN_80cdbc0();
    CPU.sp().value += 0xb0;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80ec100)
  public static void FUN_80ec100(final int r0) {
    throw new RuntimeException("Not implemented");
  }
}
