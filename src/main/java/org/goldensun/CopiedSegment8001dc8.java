package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.types.ObjAttributes08;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.RotationScaling08;

import static org.goldensun.GoldenSunVars.packets_3001400;
import static org.goldensun.GoldenSunVars.rotationScalingCount_3001d00;
import static org.goldensun.GoldenSunVars.rotationScaling_3001d40;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#processRenderQueue} from 8001dc8 */
public final class CopiedSegment8001dc8 {
  private CopiedSegment8001dc8() { }

  //NOTE: this class is not added to the memory map, 0x3002400 is added manually and is not always at that address

  // Processes render queue

  @Method(0x3002400)
  public static void FUN_3002400(final ArrayRef<ObjAttributes08> attribs) {
    int current = 0;

    //LAB_3002414
    for(int i = 0; i < 0x100; i++) {
      final RenderPacket0c packet = packets_3001400.get(0xff - i).derefNullable();

      if(packet != null) {
        current = FUN_3002458(attribs, current, 0x80, packet);
        if(current == 0) {
          return;
        }
      }
    }

    // Clear remaining elements
    MEMORY.call(0x3000168, attribs.get(current).getAddress(), 0x400, 0xc0_00c0); // memfill32

    // lr is set to this address before the bx to memfill32
    copyRotationScaling(attribs);
  }

  /** This method modifies r0 and exits entirely if it calls {@link #copyRotationScaling}. I made it return the new r0 value, and 0 if the calling method should exit. */
  @Method(0x3002458)
  public static int FUN_3002458(final ArrayRef<ObjAttributes08> attribs, int current, final int maxEntries, RenderPacket0c packet) {
    //LAB_3002458
    for(int i = 0; i < maxEntries; i++) {
      MEMORY.memcpy(attribs.get(current).getAddress(), packet.attribs_04.getAddress(), 0x8);
      current++;

      packet = packet.next_00.derefNullable();

      if(packet == null) {
        return current;
      }
    }

    copyRotationScaling(attribs);
    return 0;
  }

  @Method(0x300248c)
  public static void copyRotationScaling(final ArrayRef<ObjAttributes08> attribs) {
    //LAB_30024a4
    for(int i = 0; i < rotationScalingCount_3001d00.get(); i++) {
      final RotationScaling08 r1 = rotationScaling_3001d40.get(i);
      attribs.get(i * 4).rotationScaling_06.set(r1.pa_00.get());
      attribs.get(i * 4 + 1).rotationScaling_06.set(r1.pb_02.get());
      attribs.get(i * 4 + 2).rotationScaling_06.set(r1.pc_04.get());
      attribs.get(i * 4 + 3).rotationScaling_06.set(r1.pd_06.get());
    }

    //LAB_30024c8
  }
}
