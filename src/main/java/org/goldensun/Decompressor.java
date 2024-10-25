package org.goldensun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#decompress} from 8002544 */
public final class Decompressor {
  private Decompressor() { }

  private static final Logger LOGGER = LogManager.getFormatterLogger(Decompressor.class);

  /** NOTE: not always at this address (seen at 0x3002000, 0x3006000) */
  public static int decompress(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    LOGGER.info("Decompressing 0x%x to 0x%x", r0, r1);

    int address3002000 = CPU.sp().value - 0x14;
    CPU.sp().value = address3002000;
    address3002000 += 0x4;
    address3002000 += 0x4;
    address3002000 += 0x4;
    MEMORY.ref(4, address3002000).setu(CPU.r9().value);
    address3002000 += 0x4;
    MEMORY.ref(4, address3002000).setu(CPU.lr().value);

    r2 = MEMORY.ref(1, r0).getUnsigned();
    r0++;

    if(r2 != 0) {
      if(r2 != 1) {
        CPU.r9().value = r1 - 0x4;
        r0 = r1 - CPU.r9().value;
        int address300223c = CPU.sp().value;
        address300223c += 0x4;
        address300223c += 0x4;
        address300223c += 0x4;
        CPU.r9().value = MEMORY.ref(4, address300223c).getUnsigned();
        address300223c += 0x4;
        CPU.lr().value = MEMORY.ref(4, address300223c).getUnsigned();
        address300223c += 0x4;
        CPU.sp().value = address300223c;
        return r0;
      }

      //LAB_3002254
      CPU.r9().value = r1;

      boolean skip = false;

      //LAB_3002258
      int lr = 0;
      while(true) {
        do {
          if(!skip) {
            lr = MEMORY.ref(1, r0).getUnsigned();
            r0++;

            CPU.setCFlag((lr & 0x1 << 7) != 0);
            lr = 0x1000000 | lr << 25;
            if(CPU.cpsr().getCarry()) { // overflow
              break;
            }
          }

          //LAB_3002268
          do {
            if(!skip) {
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r0).getUnsigned());
              r0++;
              r1++;
            }

            skip = false;

            //LAB_3002270
            CPU.setCFlag((lr & 0x1 << 31) != 0);
            lr <<= 1;
          } while(!CPU.cpsr().getCarry()); // overflow
        } while(lr == 0);

        //LAB_300227c
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r0++;
        r4 = MEMORY.ref(1, r0).getUnsigned();
        r0++;
        r2 = r3 & 0xf0;
        r2 = r4 | r2 << 4;
        r3 = r3 & 0xf;
        if(r3 == 0) {
          //LAB_30022b0
          if(r2 == 0) {
            r0 = r1 - CPU.r9().value;
            int address300223c = CPU.sp().value;
            address300223c += 0x4;
            address300223c += 0x4;
            address300223c += 0x4;
            CPU.r9().value = MEMORY.ref(4, address300223c).getUnsigned();
            address300223c += 0x4;
            CPU.lr().value = MEMORY.ref(4, address300223c).getUnsigned();
            address300223c += 0x4;
            CPU.sp().value = address300223c;
            return r0;
          }

          r3 = MEMORY.ref(1, r0).getUnsigned() + 0x10;
          r0++;
        }

        //LAB_3002294
        do {
          MEMORY.ref(1, r1).setu(MEMORY.ref(1, r1 - r2).getUnsigned());
          r1++;
          r3--;
        } while(r3 != 0);

        MEMORY.ref(1, r1).setu(MEMORY.ref(1, r1 - r2).getUnsigned());
        r1++;

        // Hacky jump to LAB_3002270;
        skip = true;
      }
    }

    r1 = r1 - 0x1;
    CPU.r9().value = r1 + 0x21;
    r2 = CPU.andA(r0, 0x1);
    r4 = r2 << 3;
    if(!CPU.cpsr().getZero()) { // !=
      final int address3002020 = r0;
      r2 = MEMORY.ref(1, address3002020).getUnsigned();
      r0 = r0 + 0x1;
    }
    r4 = CPU.subA(r4, 0x10);
    if(CPU.cpsr().getNegative()) { // negative
      final int address3002224 = r0;
      r3 = MEMORY.ref(2, address3002224).getUnsigned();
      r0 = address3002224 + 0x2;
      r4 = r4 + 0x10;
      r2 = r2 | r3 << r4;
    }

    //LAB_3002048
    while(true) {
      boolean flag = (r2 & 0x1) != 0;
      r2 >>>= 1;

      //LAB_3002030
      while(flag) {
        final int address3002030 = r1 + 0x1;
        MEMORY.ref(1, address3002030).setu(r2);
        r1 = address3002030;
        r2 >>>= 8;
        r4 -= 0x9;
        if(r4 < 0) {
          final int address300203c = r0;
          r3 = MEMORY.ref(2, address300203c).getUnsigned();
          r0 = address300203c + 0x2;
          r4 += 0x10;
          r2 |= r3 << r4;
        }

        flag = (r2 & 0x1) != 0;
        r2 >>>= 1;
      }

      flag = (r2 & 0x1) != 0;
      r2 >>>= 1;
      if(!flag) { // unsigned <
        //LAB_3002104
        r4 -= 0x2;
        r5 = 0x2;
      } else {
        flag = (r2 & 0x1) != 0;
        r2 >>>= 1;
        if(!flag) {
          //LAB_30020c8
          r4 -= 0x3;
          r5 = 0x3;
        } else {
          flag = (r2 & 0x1) != 0;
          r2 >>>= 1;
          if(!flag) {
            //LAB_30020d4
            r4 -= 0x4;
            r5 = 0x4;
            if(r4 < 0) {
              final int address3002224 = r0;
              r3 = MEMORY.ref(2, address3002224).getUnsigned();
              r0 = address3002224 + 0x2;
              r4 += 0x10;
              r2 |= r3 << r4;
            }
          } else {
            flag = (r2 & 0x1) != 0;
            r2 >>>= 1;
            if(!flag) {
              //LAB_30020e4
              r4 -= 0x5;
              r5 = 0x5;
              if(r4 < 0) {
                r3 = MEMORY.ref(2, r0).getUnsigned();
                r0 += 0x2;
                r4 += 0x10;
                r2 |= r3 << r4;
              }
            } else {
              flag = (r2 & 0x1) != 0;
              r2 >>>= 1;
              if(!flag) {
                flag = (r2 & 0x1) != 0;
                r2 >>>= 1;
                if(!flag) {
                  //LAB_30020f4
                  r4 -= 0x7;
                  r5 = 0x6;
                } else {
                  r4 -= 0x7;
                  r5 = 0x7;
                }

                if(r4 < 0) {
                  r3 = MEMORY.ref(2, r0).getUnsigned();
                  r0 += 0x2;
                  r4 += 0x10;
                  r2 |= r3 << r4;
                }
              } else {
                //LAB_3002090
                r5 = r2 & 0x3;
                r2 >>>= 2;
                if(r5 != 0) {
                  r5 += 0x7;
                  r4 -= 0x8;
                } else {
                  //LAB_30020ac
                  r5 = r2 & 0x7f;
                  if(r5 == 0) {
                    CPU.r9().value = CPU.r9().value - 0x21;
                    r0 = r1 - CPU.r9().value;
                    int address300223c = CPU.sp().value;
                    address300223c += 0x4;
                    address300223c += 0x4;
                    address300223c += 0x4;
                    CPU.r9().value = MEMORY.ref(4, address300223c).getUnsigned();
                    address300223c += 0x4;
                    CPU.lr().value = MEMORY.ref(4, address300223c).getUnsigned();
                    address300223c += 0x4;
                    CPU.sp().value = address300223c;
                    return r0;
                  }

                  r5 += 0xa;
                  r2 >>>= 7;
                  r4 -= 0xf;
                }

                if(r4 < 0) {
                  r3 = MEMORY.ref(2, r0).getUnsigned();
                  r0 += 0x2;
                  r4 += 0x10;
                  r2 |= r3 << r4;
                }
              }
            }
          }
        }
      }

      //LAB_300210c
      flag = (r2 & 0x1) != 0;
      r2 >>>= 1;
      if(!flag) { // unsigned <
        //LAB_3002154
        r6 = r1 - CPU.r9().value;
        CPU.cmpA(r6, 0x800);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          r6 = Integer.rotateRight(r2, 12);
          r2 = r2 >>> 12;
          r6 = r6 >>> 20;
          r6 = r6 + 0x20;
          r4 = CPU.subA(r4, 0xd);
        } else {
          //LAB_3002178
          r7 = 0xb;
          CPU.setCFlag((r6 & 0x1 << 10) != 0);
          r6 = CPU.movA(0, r6 << 22);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            r7 = r7 - 0x1;
            CPU.setCFlag((r6 & 0x1 << 31) != 0);
            r6 = CPU.movA(0, r6 << 1);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r7 = r7 - 0x1;
              CPU.setCFlag((r6 & 0x1 << 31) != 0);
              r6 = CPU.movA(0, r6 << 1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = r7 - 0x1;
                CPU.setCFlag((r6 & 0x1 << 31) != 0);
                r6 = CPU.movA(0, r6 << 1);
                if(!CPU.cpsr().getCarry()) { // unsigned <
                  r7 = r7 - 0x1;
                  CPU.setCFlag((r6 & 0x1 << 31) != 0);
                  r6 = CPU.movA(0, r6 << 1);
                  if(!CPU.cpsr().getCarry()) { // unsigned <
                    r7 = r7 - 0x1;
                    CPU.setCFlag((r6 & 0x1 << 31) != 0);
                    r6 = CPU.movA(0, r6 << 1);
                    if(!CPU.cpsr().getCarry()) { // unsigned <
                      r7 = r7 - 0x1;
                      CPU.setCFlag((r6 & 0x1 << 31) != 0);
                      r6 = CPU.movA(0, r6 << 1);
                      if(!CPU.cpsr().getCarry()) { // unsigned <
                        r7 = r7 - 0x1;
                        CPU.setCFlag((r6 & 0x1 << 31) != 0);
                        r6 = CPU.movA(0, r6 << 1);
                        if(!CPU.cpsr().getCarry()) { // unsigned <
                          r7 = r7 - 0x1;
                          CPU.setCFlag((r6 & 0x1 << 31) != 0);
                          r6 = CPU.movA(0, r6 << 1);
                          if(!CPU.cpsr().getCarry()) { // unsigned <
                            r7 = r7 - 0x1;
                            CPU.setCFlag((r6 & 0x1 << 31) != 0);
                            r6 = CPU.movA(0, r6 << 1);
                            if(!CPU.cpsr().getCarry()) { // unsigned <
                              r7 = r7 - 0x1;
                              CPU.setCFlag((r6 & 0x1 << 31) != 0);
                              r6 = CPU.movA(0, r6 << 1);
                              if(!CPU.cpsr().getCarry()) { // unsigned <
                                r7 = r7 - 0x1;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }

          //LAB_3002200
          r6 = 0x1;
          r6 = (r6 << r7) - r6;
          r6 = r2 & r6;
          r6 = r6 + 0x20;
          r2 = r2 >>> r7;
          r4 = r4 - 0x1;
          r4 = CPU.subA(r4, r7);
        }
      } else {
        r6 = r2 & 0x1f;
        r4 = CPU.subA(r4, 0x6);
        r2 = r2 >>> 5;
      }

      //LAB_3002120
      if(r4 < 0) {
        r3 = MEMORY.ref(2, r0).getUnsigned();
        r0 += 0x2;
        r4 += 0x10;
        r2 |= r3 << r4;
      }
      CPU.setCFlag((r5 & 0x1) != 0);
      r5 = CPU.movA(r0, r5 >>> 1);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r7 = MEMORY.ref(1, r1 - r6).getUnsigned();
        final int address3002134 = r1 + 0x1;
        MEMORY.ref(1, address3002134).setu(r7);
        r1 = address3002134;
      }

      //LAB_3002138
      do {
        r7 = MEMORY.ref(1, r1 - r6).getUnsigned();
        final int address300213c = r1 + 0x1;
        MEMORY.ref(1, address300213c).setu(r7);
        r1 = address300213c;

        r7 = MEMORY.ref(1, r1 - r6).getUnsigned();
        final int address3002144 = r1 + 0x1;
        MEMORY.ref(1, address3002144).setu(r7);
        r1 = address3002144;

        r5--;
      } while(r5 != 0);
    }
  }
}
