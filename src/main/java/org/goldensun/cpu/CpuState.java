package org.goldensun.cpu;

public class CpuState {
  public final CpuMode mode;

  public final PlainRegister r8;
  public final PlainRegister r9;
  public final PlainRegister r10;
  public final PlainRegister r11;
  public final PlainRegister r12;
  public final PlainRegister sp;
  public final PlainRegister lr;
  public final PlainRegister pc;
  public final Psr cpsr;
  public final Psr spsr;

  public CpuState(final CpuMode mode, final PlainRegister r8, final PlainRegister r9, final PlainRegister r10, final PlainRegister r11, final PlainRegister r12, final PlainRegister sp, final PlainRegister lr, final PlainRegister pc, final Psr cpsr, final Psr spsr) {
    this.mode = mode;
    this.r8 = r8;
    this.r9 = r9;
    this.r10 = r10;
    this.r11 = r11;
    this.r12 = r12;
    this.sp = sp;
    this.lr = lr;
    this.pc = pc;
    this.cpsr = cpsr;
    this.spsr = spsr;
  }

  @Override
  public String toString() {
    return "CpuState " + this.mode;
  }
}
