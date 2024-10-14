package org.goldensun.timers;

import org.goldensun.cpu.InterruptController;
import org.goldensun.cpu.InterruptType;
import org.goldensun.memory.IllegalAddressException;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;
import org.goldensun.memory.Value;

public class Timer {
  private static final int CPU_SPEED = 16_777_216; // 16.7mHz

  private static final int CONTROL_PRESCALER_MASK = 0b11;
  private static final int CONTROL_PRESCALER_SHIFT = 0;
  private static final int CONTROL_COUNT_UP_TIMING_MASK = 0b100;
  private static final int CONTROL_COUNT_UP_TIMING_SHIFT = 2;
  private static final int CONTROL_IRQ_ENABLE_MASK = 0b100_0000;
  private static final int CONTROL_IRQ_ENABLE_SHIFT = 6;
  private static final int CONTROL_START_MASK = 0b1000_0000;
  private static final int CONTROL_START_SHIFT = 7;

  private static final int PRESCALER_1 = 0;
  private static final int PRESCALER_64 = 1;
  private static final int PRESCALER_256 = 2;
  private static final int PRESCALER_1024 = 3;

  public final Value CNT_L;
  public final Value CNT_H;

  private final InterruptController interrupts;
  private final InterruptType interruptType;

  public final int index;

  /** Copied to the counter when timer is started or overflows */
  private int reload;
  private int control;

  private int counter;

  private int nsPerTick;
  private long lastTick;

  public Timer(final int index, final Memory memory, final InterruptController interrupts) {
    this.index = index;
    this.interruptType = InterruptType.values()[InterruptType.TIMER_0_OVERFLOW.ordinal() + index];

    memory.addSegment(new TimerSegment());
    this.interrupts = interrupts;

    this.CNT_L = memory.ref(2, 0x400_0100 + index * 0x4);
    this.CNT_H = memory.ref(2, 0x400_0102 + index * 0x4);
  }

  private int onCounterRead() {
    return this.counter;
  }

  private void onReloadWrite(final int val) {
    this.reload = val;
  }

  private int onControlRead() {
    return this.control;
  }

  private void onControlWrite(final int val) {
    this.control = val;

    final int prescaler = switch((val & CONTROL_PRESCALER_MASK) >>> CONTROL_PRESCALER_SHIFT) {
      case PRESCALER_1 -> 1;
      case PRESCALER_64 -> 64;
      case PRESCALER_256 -> 256;
      case PRESCALER_1024 -> 1024;
      default -> throw new RuntimeException("Impossible state");
    };

    this.nsPerTick = (int)(1_000_000_000.0f / CPU_SPEED * prescaler);

    if((val & CONTROL_COUNT_UP_TIMING_MASK) != 0) {
      throw new RuntimeException("Timer count up not supported");
    }

    if((val & CONTROL_START_MASK) != 0) {
      this.counter = this.reload;
    }
  }

  public void tick() {
    if((this.control & CONTROL_START_MASK) != 0) {
      final long current = System.nanoTime();

      if(this.lastTick == 0) {
        this.lastTick = current;
      }

      long delta = current - this.lastTick;

      while(delta >= this.nsPerTick) {
        delta -= this.nsPerTick;
        this.counter++;

        if(this.counter > 0xffff) {
          this.counter = this.reload;

          if((this.control & CONTROL_IRQ_ENABLE_MASK) != 0) {
            this.interrupts.set(this.interruptType);
          }
        }

        this.lastTick = current;
      }
    }
  }

  public class TimerSegment extends Segment {
    public TimerSegment() {
      super(0x400_0100 + Timer.this.index * 0x4, 0x4);
    }

    @Override
    public int get(final int offset, final int size) {
      final int shift = (offset & 0x1) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      return switch(offset & 0x2) {
        case 0x0 -> (Timer.this.onCounterRead() & mask) >> shift;
        case 0x2 -> (Timer.this.onControlRead() & mask) >> shift;

        default -> throw new IllegalAddressException("There is no timer port at " + Integer.toHexString(this.getAddress() + offset));
      };
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      final int shift = (offset & 0x1) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      switch(offset & 0x2) {
        case 0x0 -> Timer.this.onReloadWrite(Timer.this.onCounterRead() & ~mask | value << shift & mask);
        case 0x2 -> Timer.this.onControlWrite(Timer.this.onControlRead() & ~mask | value << shift & mask);

        default -> throw new IllegalAddressException("There is no timer port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }
}
