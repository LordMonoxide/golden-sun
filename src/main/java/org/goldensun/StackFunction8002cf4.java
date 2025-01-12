package org.goldensun;

import org.goldensun.types.VblankTransfer0c;
import org.goldensun.types.VblankTransferQueue184;

import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

public final class StackFunction8002cf4 {
  private StackFunction8002cf4() { }

  public static void performVblankTransfers_(final VblankTransferQueue184 queue, final int count) {
    //LAB_8002cfc
    for(int i = 0; i < count; i++) {
      final VblankTransfer0c transfer = queue.queue_04.get(i);
      int src = transfer.src_00.get();
      final int dst = transfer.dst_04.get();
      final int cnt = transfer.cnt_08.get();

      final int size = cnt & 0x30000;
      if(size == 0) {
        //LAB_8002d4c
        DMA.channels[3].SAD.setu(src);
        DMA.channels[3].DAD.setu(dst);
        DMA.channels[3].CNT.setu(cnt);
      } else {
        if((cnt & 0xc0000) != 0) {
          final int dstVal;
          if(size < 0x20000) {
            dstVal = MEMORY.ref(1, dst).getUnsigned();
          } else if(size == 0x20000) {
            dstVal = MEMORY.ref(2, dst).getUnsigned();
          } else {
            dstVal = MEMORY.ref(4, dst).getUnsigned();
          }

          if((cnt & 0x40000) != 0) {
            src = dstVal | src;
          } else {
            src = dstVal & ~src;
          }
        }

        //LAB_8002d2c
        if(size < 0x20000) {
          MEMORY.ref(1, dst).setu(src);
        } else if(size == 0x20000) {
          MEMORY.ref(2, dst).setu(src);
        } else {
          MEMORY.ref(4, dst).setu(src);
        }
      }

      //LAB_8002d3c
    }
  }
}
