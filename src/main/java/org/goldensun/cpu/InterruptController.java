package org.goldensun.cpu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.memory.IllegalAddressException;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;
import org.goldensun.memory.Value;

public class InterruptController {
  private static final Logger LOGGER = LogManager.getFormatterLogger(InterruptController.class);

  /** 4000200 */
  public final Value INT_ENABLE;
  /** 4000202 */
  public final Value INT_FLAGS;
  /** 4000204 */
  public final Value WAITCNT;
  /** 4000208 */
  public final Value INT_MASTER_ENABLE;

  private boolean masterEnable;
  private int interrupts;
  private int interruptMask;

  public InterruptController(final Memory memory) {
    this.INT_ENABLE = memory.ref(2, 0x400_0200);
    this.INT_FLAGS = memory.ref(2, 0x400_0202);
    this.WAITCNT = memory.ref(2, 0x400_0204);
    this.INT_MASTER_ENABLE = memory.ref(2, 0x400_0208);

    memory.addSegment(new InterruptSegment());
  }

  public void set(final InterruptType interrupt) {
    this.interrupts |= interrupt.mask;
  }

  public boolean irqPending() {
    return this.masterEnable && (this.interrupts & this.interruptMask) != 0;
  }

  public boolean irqPendingForHalt() {
    return (this.interrupts & this.interruptMask) != 0;
  }

  public int getInterrupts() {
    return this.interrupts;
  }

  private int onIntEnableRead() {
    return this.interruptMask;
  }

  private void onIntEnableWrite(final int value) {
    this.interruptMask = value;
  }

  private int onIntFlagsRead() {
    return this.interrupts;
  }

  private void onIntFlagsWrite(final int value) {
    this.interrupts &= value;
  }

  private int onWaitCntRead() {
    return 0;
  }

  private void onWaitCntWrite(final int value) {

  }

  private int onIntMasterEnableRead() {
    return this.masterEnable ? 1 : 0;
  }

  private void onIntMasterEnableWrite(final int value) {
    this.masterEnable = (value & 0x1) != 0;
  }

  public class InterruptSegment extends Segment {
    public InterruptSegment() {
      super(0x400_0200, 0xa);
    }

    @Override
    public int get(final int offset, final int size) {
      final int shift = (offset & 0x3) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      return switch(offset & 0xc) {
        case 0x0 -> ((InterruptController.this.onIntFlagsRead() << 16 | InterruptController.this.onIntEnableRead()) & mask) >> shift;
        case 0x4 -> (InterruptController.this.onWaitCntRead() & mask) >> shift;
        case 0x8 -> (InterruptController.this.onIntMasterEnableRead() & mask) >> shift;

        default -> throw new IllegalAddressException("There is no interrupt port at " + Integer.toHexString(this.getAddress() + offset));
      };
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      final int shift = (offset & 0x3) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      switch(offset & 0xc) {
        case 0x0 -> {
          final int current = InterruptController.this.onIntFlagsRead() << 16 | InterruptController.this.onIntEnableRead();
          final int newValue = current & ~mask | value << shift & mask;
          InterruptController.this.onIntEnableWrite(newValue & 0xffff);
          InterruptController.this.onIntFlagsWrite(newValue >>> 16);
        }
        case 0x4 -> InterruptController.this.onWaitCntWrite(value << shift & mask);
        case 0x8 -> InterruptController.this.onIntMasterEnableWrite(value << shift & mask);

        default -> throw new IllegalAddressException("There is no interrupt port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }
}
