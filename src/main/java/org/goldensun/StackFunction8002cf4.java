package org.goldensun;

import org.goldensun.types.VblankTransfer0c;
import org.goldensun.types.VblankTransferQueue184;

import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

public final class StackFunction8002cf4 {
  private StackFunction8002cf4() { }

  public static void performVblankTransfers_(final VblankTransferQueue184 r0, final int count) {
    //LAB_8002cfc
    for(int i = 0; i < count; i++) {
      final VblankTransfer0c transfer = r0.queue_04.get(i);
      int r2 = transfer.src_00.get();
      final int r3 = transfer.dst_04.get();
      final int r4 = transfer.cnt_08.get();

      final int r12 = r4 & 0x30000;
      if(r12 == 0) {
        //LAB_8002d4c
        DMA.channels[3].SAD.setu(r2);
        DMA.channels[3].DAD.setu(r3);
        DMA.channels[3].CNT.setu(r4);
      } else {
        if((r4 & 0xc0000) != 0) {
          final int r5;
          if(r12 < 0x20000) {
            r5 = MEMORY.ref(1, r3).getUnsigned();
          } else if(r12 == 0x20000) {
            r5 = MEMORY.ref(2, r3).getUnsigned();
          } else {
            r5 = MEMORY.ref(4, r3).getUnsigned();
          }

          if((r4 & 0x40000) != 0) {
            r2 = r5 | r2;
          } else {
            r2 = r5 & ~r2;
          }
        }

        //LAB_8002d2c
        if(r12 < 0x20000) {
          MEMORY.ref(1, r3).setu(r2);
        } else if(r12 == 0x20000) {
          MEMORY.ref(2, r3).setu(r2);
        } else {
          MEMORY.ref(4, r3).setu(r2);
        }
      }

      //LAB_8002d3c
    }
  }
}
