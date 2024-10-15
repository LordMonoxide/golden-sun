package org.goldensun.cpu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Psr implements Register {
  private static final Logger LOGGER = LogManager.getFormatterLogger();

  /**
   * Bits 0-4
   */
  private CpuMode mode = CpuMode.USER;
  /**
   * Bit 5
   */
  private InstructionSet state = InstructionSet.ARM;
  /**
   * Bit 6
   */
  private boolean disableFiq;
  /**
   * Bit 7
   */
  private boolean disableIrq;

  /**
   * Bit 28
   */
  private boolean overflow;
  /**
   * Bit 29
   */
  private boolean carry;
  /**
   * Bit 30
   */
  private boolean zero;
  /**
   * Bit 31
   */
  private boolean negative;

  void set(final Psr other) {
    this.mode = other.mode;
    this.state = other.state;
    this.disableFiq = other.disableFiq;
    this.disableIrq = other.disableIrq;

    this.overflow = other.overflow;
    this.carry = other.carry;
    this.zero = other.zero;
    this.negative = other.negative;
  }

  void setInstructionSet(final InstructionSet instructionSet) {
    this.state = instructionSet;
  }

  private void setAll(final int value) {
    this.set(value);
    this.overflow = (value >>> 28 & 0x1) != 0;
    this.carry = (value >>> 29 & 0x1) != 0;
    this.zero = (value >>> 30 & 0x1) != 0;
    this.negative = (value >>> 31 & 0x1) != 0;
  }

  @Override
  public void set(final int value) {
    this.mode = CpuMode.fromBits(value & 0x1f);
    this.state = (value & 0x20) == 0 ? InstructionSet.ARM : InstructionSet.THUMB;
    this.disableFiq = (value & 0x40) != 0;
    this.disableIrq = (value & 0x80) != 0;

//    if(this.disableFiq) {
//      LOGGER.info("Fast interrupts disabled");
//    } else {
//      LOGGER.info("Fast interrupts enabled");
//    }
//
//    if(this.disableFiq) {
//      LOGGER.info("Interrupts disabled");
//    } else {
//      LOGGER.info("Interrupts enabled");
//    }
  }

  @Override
  public int get() {
    return this.mode.bits |
      this.state.ordinal() << 5 |
      (this.disableFiq ? 0x40 : 0) |
      (this.disableIrq ? 0x80 : 0) |
      (this.overflow ? 1 : 0) << 28 |
      (this.carry ? 1 : 0) << 29 |
      (this.zero ? 1 : 0) << 30 |
      (this.negative ? 1 : 0) << 31
      ;
  }

  public boolean irqDisabled() {
    return this.disableIrq;
  }

  public boolean fiqDisabled() {
    return this.disableFiq;
  }

  public void msr(int value, final boolean maskFlags, final boolean maskStatus, final boolean maskExtension, final boolean maskControl) {
    if(!maskFlags) {
      value &= ~0xff00_0000;
    }

    if(!maskStatus) {
      value &= ~0xff_0000;
    }

    if(!maskExtension) {
      value &= ~0xff00;
    }

    if(!maskControl) {
      value &= ~0xff;
    }

    LOGGER.info("PSR set to 0x%x", value);
    this.setAll(value);
  }

  public CpuMode getMode() {
    return this.mode;
  }

  void setOverflow(final boolean value) {
    this.overflow = value;
  }

  public boolean getOverflow() {
    return this.overflow;
  }

  void setCarry(final boolean value) {
    this.carry = value;
  }

  public boolean getCarry() {
    return this.carry;
  }

  void setZero(final boolean value) {
    this.zero = value;
  }

  public boolean getZero() {
    return this.zero;
  }

  void setNegative(final boolean value) {
    this.negative = value;
  }

  public boolean getNegative() {
    return this.negative;
  }
}
