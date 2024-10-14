package org.goldensun.dma;

import org.goldensun.memory.Memory;

public class DmaController {
  public final DmaChannel[] channels = new DmaChannel[4];

  public DmaController(final Memory memory) {
    for(int i = 0; i < this.channels.length; i++) {
      this.channels[i] = new DmaChannel(i, memory);
    }
  }

  public void triggerHblank() {
    for(int i = 0; i < this.channels.length; i++) {
      this.channels[i].triggerHblank();
    }
  }

  public void triggerVblank() {
    for(int i = 0; i < this.channels.length; i++) {
      this.channels[i].triggerVblank();
    }
  }
}
