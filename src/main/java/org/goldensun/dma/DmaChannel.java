package org.goldensun.dma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.memory.IllegalAddressException;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;
import org.goldensun.memory.Value;

public class DmaChannel {
  private static final Logger LOGGER = LogManager.getFormatterLogger(DmaChannel.class);

  private static final int DEST_ADDRESS_MASK = 0b110_0000;
  private static final int DEST_ADDRESS_SHIFT = 5;
  private static final int SOURCE_ADDRESS_MASK = 0b1_1000_0000;
  private static final int SOURCE_ADDRESS_SHIFT = 7;
  private static final int REPEAT_MASK = 0b10_0000_0000;
  private static final int REPEAT_SHIFT = 9;
  private static final int TRANSFER_TYPE_MASK = 0b100_0000_0000;
  private static final int TRANSFER_TYPE_SHIFT = 10;
  private static final int GAME_PAK_DRQ_MASK = 0b1000_0000_0000;
  private static final int GAME_PAK_DRQ_SHIFT = 11;
  private static final int START_TIMING_MASK = 0b11_0000_0000_0000;
  private static final int START_TIMING_SHIFT = 12;
  private static final int IRQ_MASK = 0b100_0000_0000_0000;
  private static final int IRQ_SHIFT = 14;
  private static final int ENABLE_MASK = 0b1000_0000_0000_0000;
  private static final int ENABLE_SHIFT = 15;

  private static final int DEST_ADDRESS_INCREMENT = 0;
  private static final int DEST_ADDRESS_DECREMENT = 1;
  private static final int DEST_ADDRESS_FIXED = 2;
  private static final int DEST_ADDRESS_INCREMENT_RELOAD = 3;

  private static final int SOURCE_ADDRESS_INCREMENT = 0;
  private static final int SOURCE_ADDRESS_DECREMENT = 1;
  private static final int SOURCE_ADDRESS_FIXED = 2;
  private static final int SOURCE_ADDRESS_PROHIBITED = 3;

  private static final int TRANSFER_TYPE_16BIT = 0;
  private static final int TRANSFER_TYPE_32BIT = 1;

  private static final int START_TIMING_IMMEDIATELY = 0;
  private static final int START_TIMING_VBLANK = 1;
  private static final int START_TIMING_HBLANK = 2;
  private static final int START_TIMING_SPECIAL = 3;

  public final Value SAD;
  public final Value DAD;
  public final Value CNT;

  public final int index;

  private final Memory memory;

  private int sourceAddress;
  private int destAddress;
  private int wordCount;
  private int control;

  /** Registers are not modified by transfer. Loaded when transfer starts. */
  private int sourceAddressCopy;
  /** Registers are not modified by transfer. Loaded when transfer starts and on reload if reload set on DEST_ADDRESS flag of control. */
  private int destAddressCopy;
  /** Registers are not modified by transfer. Loaded when transfer starts and on reload. */
  private int wordCountCopy;

  public DmaChannel(final int index, final Memory memory) {
    this.index = index;
    this.memory = memory;

    memory.addSegment(new DmaChannelSegment());

    this.SAD = memory.ref(4, 0x400_00b0 + index * 0xc);
    this.DAD = memory.ref(4, 0x400_00b0 + index * 0xc + 0x4);
    this.CNT = memory.ref(4, 0x400_00b0 + index * 0xc + 0x8);
  }

  private int onSourceAddressRead() {
    return this.sourceAddress;
  }

  private void onSourceAddressWrite(final int val) {
    this.sourceAddress = val;
  }

  private int onDestAddressRead() {
    return this.destAddress;
  }

  private void onDestAddressWrite(final int val) {
    this.destAddress = val;
  }

  private int onControlRead() {
    return this.control << 16 | this.wordCount;
  }

  private void onControlWrite(final int val) {
    this.wordCount = val & 0xffff;
    this.control = val >>> 16;

    if(this.wordCount == 0) {
      this.wordCount = this.index == 3 ? 0x1_0000 : 0x4000;
    }

    if((this.control & GAME_PAK_DRQ_MASK) != 0) {
      throw new RuntimeException("DMA game pak DRQ not implemented");
    }

    if((this.control & ENABLE_MASK) != 0) {
      this.startTransfer();
    }
  }

  private void startTransfer() {
    this.sourceAddressCopy = this.sourceAddress;
    this.destAddressCopy = this.destAddress;
    this.wordCountCopy = this.wordCount;

    switch((this.control & START_TIMING_MASK) >>> START_TIMING_SHIFT) {
      case START_TIMING_HBLANK, START_TIMING_VBLANK -> throw new RuntimeException("HBLANK/VBLANK timing not implemented");

      case START_TIMING_IMMEDIATELY -> {
        if((this.control & REPEAT_MASK) != 0) {
          throw new RuntimeException("Can't repeat immediate transfer (probably)");
        }

        final int wordSize = 2 << ((this.control & TRANSFER_TYPE_MASK) >>> TRANSFER_TYPE_SHIFT);
        final int destControl = (this.control & DEST_ADDRESS_MASK) >>> DEST_ADDRESS_SHIFT;
        final int sourceControl = (this.control & SOURCE_ADDRESS_MASK) >>> SOURCE_ADDRESS_SHIFT;

//        LOGGER.info("DMA %d transferring 0x%x bytes from 0x%x to 0x%x", this.index, this.wordCountCopy * wordSize, this.sourceAddressCopy, this.destAddressCopy);

        for(int i = 0; i < this.wordCountCopy; i++) {
          this.memory.set(this.destAddressCopy, wordSize, this.memory.get(this.sourceAddressCopy, wordSize));

          switch(destControl) {
            case DEST_ADDRESS_DECREMENT -> this.destAddressCopy -= wordSize;
            case DEST_ADDRESS_INCREMENT, DEST_ADDRESS_INCREMENT_RELOAD -> this.destAddressCopy += wordSize;
          }

          switch(sourceControl) {
            case SOURCE_ADDRESS_DECREMENT -> this.sourceAddressCopy -= wordSize;
            case SOURCE_ADDRESS_INCREMENT -> this.sourceAddressCopy += wordSize;
          }
        }

        if(destControl == DEST_ADDRESS_INCREMENT_RELOAD) {
          this.destAddressCopy = this.destAddress;
        }

        this.wordCountCopy = this.wordCount;
        this.control &= ~ENABLE_MASK;
      }

      case START_TIMING_SPECIAL -> {
        if(this.index == 1 || this.index == 2) {
          //TODO LOGGER.warn("Audio FIFO DMA not implemented");
          return;
        }

        throw new RuntimeException("DMA channel " + this.index + " special not implemented");
      }
    }
  }

  public void triggerHblank() {
    if((this.control & START_TIMING_MASK) >>> START_TIMING_SHIFT != START_TIMING_HBLANK) {
      return;
    }

    if((this.control & REPEAT_MASK) != 0) {
      throw new RuntimeException("DMA repeat not implemented");
    }

    throw new RuntimeException("Not implemented");
  }

  public void triggerVblank() {
    if((this.control & START_TIMING_MASK) >>> START_TIMING_SHIFT != START_TIMING_VBLANK) {
      return;
    }

    if((this.control & REPEAT_MASK) != 0) {
      throw new RuntimeException("DMA repeat not implemented");
    }

    throw new RuntimeException("Not implemented");
  }

  public class DmaChannelSegment extends Segment {
    public DmaChannelSegment() {
      super(0x400_00b0 + DmaChannel.this.index * 0xc, 0xc);
    }

    @Override
    public int get(final int offset, final int size) {
      final int shift = (offset & 0x3) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      return switch(offset & 0xc) {
        case 0x0 -> (DmaChannel.this.onSourceAddressRead() & mask) >> shift;
        case 0x4 -> (DmaChannel.this.onDestAddressRead() & mask) >> shift;
        case 0x8 -> (DmaChannel.this.onControlRead() & mask) >> shift;

        default -> throw new IllegalAddressException("There is no DMA channel port at " + Integer.toHexString(this.getAddress() + offset));
      };
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      final int shift = (offset & 0x3) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      switch(offset & 0xc) {
        case 0x0 -> DmaChannel.this.onSourceAddressWrite(DmaChannel.this.onSourceAddressRead() & ~mask | value << shift & mask);
        case 0x4 -> DmaChannel.this.onDestAddressWrite(DmaChannel.this.onDestAddressRead() & ~mask | value << shift & mask);
        case 0x8 -> DmaChannel.this.onControlWrite(DmaChannel.this.onControlRead() & ~mask | value << shift & mask);

        default -> throw new IllegalAddressException("There is no DMA channel port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }
}
