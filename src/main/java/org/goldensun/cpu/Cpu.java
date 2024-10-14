package org.goldensun.cpu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.DebugHelper;
import org.goldensun.memory.IllegalAddressException;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;
import org.goldensun.memory.Value;

import java.util.EnumMap;
import java.util.Map;

import static org.goldensun.Hardware.CODE;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;

/** ARMv4 */
public class Cpu implements Runnable {
  private static final Logger LOGGER = LogManager.getFormatterLogger();

  /** 4000300 */
  public static final Value POST_FLAG = MEMORY.ref(1, 0x400_0300);

  private final Memory memory;

  private final Map<CpuMode, CpuState> states = new EnumMap<>(CpuMode.class);

  private final Psr cpsr = new Psr() {
    @Override
    public void set(final int value) {
      final CpuMode oldMode = this.getMode();
      final CpuMode newMode = CpuMode.fromBits(value & 0x1f);

      if(newMode != oldMode) {
        Cpu.this.changeMode(newMode);
      }

      super.set(value);
    }

    @Override
    void set(final Psr other) {
      if(other.getMode() != this.getMode()) {
        Cpu.this.changeMode(other.getMode());
      }

      super.set(other);
    }
  };

  private int postFlag;

  private boolean running;

  public Cpu(final Memory memory) {
    this.memory = memory;
    this.memory.addSegment(new CpuSegment());

    final PlainRegister r8 = new PlainRegister();
    final PlainRegister r9 = new PlainRegister();
    final PlainRegister r10 = new PlainRegister();
    final PlainRegister r11 = new PlainRegister();
    final PlainRegister r12 = new PlainRegister();
    final PlainRegister sp = new PlainRegister();
    final PlainRegister lr = new PlainRegister();
    final PlainRegister pc = new PlainRegister();
    this.states.put(CpuMode.USER,       new CpuState(CpuMode.USER,       r8, r9, r10, r11, r12, sp, lr, pc, this.cpsr, null));
    this.states.put(CpuMode.SYSTEM,     new CpuState(CpuMode.SYSTEM,     r8, r9, r10, r11, r12, sp, lr, pc, this.cpsr, null));
    this.states.put(CpuMode.FIQ,        new CpuState(CpuMode.FIQ,        new PlainRegister(), new PlainRegister(), new PlainRegister(), new PlainRegister(), new PlainRegister(), new PlainRegister(), new PlainRegister(), pc, this.cpsr, new Psr()));
    this.states.put(CpuMode.SUPERVISOR, new CpuState(CpuMode.SUPERVISOR, r8, r9, r10, r11, r12, new PlainRegister(), new PlainRegister(), pc, this.cpsr, new Psr()));
    this.states.put(CpuMode.ABORT,      new CpuState(CpuMode.ABORT,      r8, r9, r10, r11, r12, new PlainRegister(), new PlainRegister(), pc, this.cpsr, new Psr()));
    this.states.put(CpuMode.IRQ,        new CpuState(CpuMode.IRQ,        r8, r9, r10, r11, r12, new PlainRegister(), new PlainRegister(), pc, this.cpsr, new Psr()));
    this.states.put(CpuMode.UNDEFINED,  new CpuState(CpuMode.UNDEFINED,  r8, r9, r10, r11, r12, new PlainRegister(), new PlainRegister(), pc, this.cpsr, new Psr()));
  }

  public CpuState state() {
    return this.states.get(this.cpsr.getMode());
  }

  public CpuState userState() {
    return this.states.get(CpuMode.USER);
  }

  public void stop() {
    this.running = false;
  }

  @Override
  public void run() {
    this.running = true;

    while(this.running) {
      this.dispatchIrq();
      DebugHelper.sleep(1);
    }
  }

  public void dispatchIrq() {
    while(INTERRUPTS.irqPending() && !this.cpsr.irqDisabled() && INTERRUPTS.INT_FLAGS.get() != 0) {
      this.memory.waitForLock(CODE::suspend);

      this.cpsr.set(CpuMode.IRQ.bits | 0b1100_0000); // ARM state, interrupts disabled
      this.memory.call(0x18); // IRQ handler

      CODE.resume();

      DebugHelper.sleep(0);
    }
  }

  public void SWI(final InstructionSet callingInstructionSet) {
    this.cpsr.setInstructionSet(callingInstructionSet);
    this.cpsr.set(CpuMode.SUPERVISOR.bits | 0b1100_0000); // ARM state, interrupts disabled
    this.memory.call(0x08); // SWI handler
  }

  private void changeMode(final CpuMode mode) {
    LOGGER.info("Entering %s mode", mode);
    final CpuState newState = this.states.get(mode);
    newState.lr.value = this.state().pc.value;

    if(newState.spsr != null) {
      newState.spsr.set(this.state().cpsr);
    }
  }

  public void restorePsr() {
    this.state().cpsr.set(this.state().spsr);
  }

  public PlainRegister r8() {
    return this.state().r8;
  }

  public PlainRegister r9() {
    return this.state().r9;
  }

  public PlainRegister r10() {
    return this.state().r10;
  }

  public PlainRegister r11() {
    return this.state().r11;
  }

  public PlainRegister r12() {
    return this.state().r12;
  }

  public PlainRegister sp() {
    return this.state().sp;
  }

  public PlainRegister lr() {
    return this.state().lr;
  }

  public PlainRegister pc() {
    return this.state().pc;
  }

  public Psr cpsr() {
    return this.state().cpsr;
  }

  public Psr spsr() {
    return this.state().spsr;
  }

  public int setZsFlags(final int value) {
    this.cpsr.setZero(value == 0);
    this.cpsr.setNegative(value < 0);
    return value;
  }

  public int setCFlag(final int value) {
    this.cpsr.setCarry(value != 0);
    return value;
  }

  public void setCFlag(final boolean value) {
    this.cpsr.setCarry(value);
  }

  public void setVcFlagsAdd(final int operand1, final int operand2, final int result) {
    final boolean op1 = operand1 < 0;
    final boolean op2 = operand2 < 0;
    final boolean res = result < 0;

    this.cpsr.setOverflow(op1 && op2 && !res || !op1 && !op2 && res);
    this.cpsr.setCarry(op1 && op2 || op1 && !res || op2 && !res);
  }

  public void setVcFlagsSub(final int operand1, final int operand2, final int result) {
    final boolean op1 = operand1 < 0;
    final boolean op2 = operand2 < 0;
    final boolean res = result < 0;

    this.cpsr.setOverflow(op1 && !op2 && !res || !op1 && op2 && res);
    this.cpsr.setCarry(op1 && !op2 || op1 && !res || !op2 && !res);
  }

  public void push(final int value) {
    this.sp().value -= 0x4;
    this.memory.ref(4, this.sp().value).setu(value);
  }

  public int pop() {
    final int value = this.memory.ref(4, this.sp().value).get();
    this.sp().value += 0x4;
    return value;
  }

  public int andT(final int left, final int right) {
    return this.andA(left, right);
  }

  public int andA(final int left, final int right) {
    return this.setZsFlags(left & right);
  }

  public int eorT(final int left, final int right) {
    return this.eorA(left, right);
  }

  public int eorA(final int left, final int right) {
    return this.setZsFlags(left ^ right);
  }

  public int lslT(final int left, final int right) {
    if(right != 0) {
      if(right < 32) {
        this.setCFlag(left & 0x1 << 32 - right);
        return this.setZsFlags(left << right);
      }

      if(right == 32) {
        this.setCFlag(left & 0x1);
        return this.setZsFlags(0);
      }

      this.setCFlag(0);
      return this.setZsFlags(0);
    }

    return this.setZsFlags(left);
  }

  public int lsrT(final int left, final int right) {
    if(right != 0) {
      if(right < 32) {
        this.setCFlag(left & 0x1 << right - 1);
        return this.setZsFlags(left >>> right);
      }

      if(right == 32) {
        this.setCFlag(left & 0x8000_0000);
        return this.setZsFlags(0);
      }

      this.setCFlag(0);
      return this.setZsFlags(0);
    }

    return this.setZsFlags(left);
  }

  public int asrT(final int left, final int right) {
    if(right != 0) {
      if(right < 32) {
        this.setCFlag(left & 0x1 << right - 1);
        return this.setZsFlags(left >> right);
      }

      this.setCFlag(left & 0x8000_0000);
      return this.setZsFlags(left >> 31);
    }

    return this.setZsFlags(left);
  }

  public int addT(final int left, final int right) {
    return this.addA(left, right);
  }

  public int addA(final int left, final int right) {
    final int newValue = left + right;
    this.setVcFlagsAdd(left, right, newValue);
    this.setZsFlags(newValue);
    return newValue;
  }

  public int subT(final int left, final int right) {
    return this.subA(left, right);
  }

  public int subA(final int left, final int right) {
    final int newValue = left - right;
    this.setVcFlagsSub(left, right, newValue);
    this.setZsFlags(newValue);
    return newValue;
  }

  public int rsbT(final int left, final int right) {
    return this.rsbA(left, right);
  }

  public int rsbA(final int left, final int right) {
    final int newValue = right - left;
    this.setVcFlagsSub(right, left, newValue);
    this.setZsFlags(newValue);
    return newValue;
  }

  public int adcT(final int left, final int right) {
    return this.adcA(left, right);
  }

  public int adcA(final int left, final int right) {
    final int newValue = left + right + (this.cpsr().getCarry() ? 1 : 0);
    this.setVcFlagsAdd(left, right, newValue);
    this.setZsFlags(newValue);
    return newValue;
  }

  public int sbcT(final int left, final int right) {
    final int newValue = left - right - (this.cpsr().getCarry() ? 0 : 1);
    this.setVcFlagsSub(left, right, newValue);
    return this.setZsFlags(newValue);
  }

  public int rorT(final int left, int right) {
    if(right != 0) {
      right &= 0x1f;

      if(right == 0) {
        this.setCFlag(left & 0x8000_0000);
      } else {
        this.setCFlag(left & 0x1 << right - 1);
        return this.setZsFlags(Integer.rotateRight(left, right));
      }
    }

    return this.setZsFlags(left);
  }

  /** and */
  public int tstT(final int left, final int right) {
    return this.tstA(left, right);
  }

  /** and */
  public int tstA(final int left, final int right) {
    this.setZsFlags(left & right);
    return left;
  }

  public int teqT(final int left, final int right) {
    return this.teqA(left, right);
  }

  public int teqA(final int left, final int right) {
    this.setZsFlags(left ^ right);
    return left;
  }

  public int negT(final int left, final int right) {
    return this.negA(left, right);
  }

  public int negA(final int left, final int right) {
    final int newValue = -right;
    this.setVcFlagsSub(0, right, newValue);
    this.setZsFlags(newValue);
    return newValue;
  }

  /** Calculate the difference between two numbers */
  public int cmpT(final int left, final int right) {
    return this.cmpA(left, right);
  }

  /** Calculate the difference between two numbers */
  public int cmpA(final int left, final int right) {
    final int newValue = left - right;
    this.setVcFlagsSub(left, right, newValue);
    this.setZsFlags(newValue);
    return left;
  }

  public int cmnT(final int left, final int right) {
    return this.cmnA(left, right);
  }

  public int cmnA(final int left, final int right) {
    final int newValue = left + right;
    this.setVcFlagsAdd(left, right, newValue);
    this.setZsFlags(newValue);
    return left;
  }

  public int orrT(final int left, final int right) {
    return this.orrA(left, right);
  }

  public int orrA(final int left, final int right) {
    final int result = left | right;
    this.setZsFlags(result);
    return result;
  }

  public int mulT(final int left, final int right) {
    return this.mulA(left, right);
  }

  public int mulA(final int left, final int right) {
    final int result = left * right;
    this.setZsFlags(result);
    return result;
  }

  public int movT(final int left, final int right) {
    this.setZsFlags(right);
    return right;
  }

  public int movA(final int left, final int right) {
    this.setZsFlags(right);
    return right;
  }

  /** nand */
  public int bicT(final int left, final int right) {
    return this.bicA(left, right);
  }

  /** nand */
  public int bicA(final int left, final int right) {
    final int result = left & ~right;
    this.setZsFlags(result);
    return result;
  }

  /** not */
  public int mvnT(final int left, final int right) {
    return this.mvnA(left, right);
  }

  /** not */
  public int mvnA(final int left, final int right) {
    final int result = ~right;
    this.setZsFlags(result);
    return result;
  }

  private int onPostFlagRead() {
    return this.postFlag;
  }

  private void onPostFlagWrite(final int val) {
    this.postFlag = val;
  }

  public class CpuSegment extends Segment {
    public CpuSegment() {
      super(0x400_0300, 0x1);
    }

    @Override
    public int get(final int offset, final int size) {
      final int shift = (offset & 0x1) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      return switch(offset & 0x1) {
        case 0x0 -> (Cpu.this.onPostFlagRead() & mask) >> shift;

        default -> throw new IllegalAddressException("There is no CPU port at " + Integer.toHexString(this.getAddress() + offset));
      };
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      final int shift = (offset & 0x1) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      switch(offset & 0x1) {
        case 0x0 -> Cpu.this.onPostFlagWrite(Cpu.this.onPostFlagRead() & ~mask | value << shift & mask);

        default -> throw new IllegalAddressException("There is no CPU port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }
}
