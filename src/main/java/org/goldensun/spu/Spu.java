package org.goldensun.spu;

import org.goldensun.memory.IllegalAddressException;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;

public class Spu {
  private int sound1CntL;
  private int sound1CntH;
  private int sound1CntX;

  private int sound2CntL;

  private int sound2CntH;

  private int sound3CntL;

  private int sound4CntL;

  private int sound4CntH;

  private int soundCntL;
  private int soundCntH;
  private int soundCntX;

  private int soundBias;

  public Spu(final Memory memory) {
    memory.addSegment(new SpuSegment());
    memory.addSegment(new FifoSegment());
  }

  private int onSound1CntLRead() {
    return this.sound1CntL;
  }

  private void onSound1CntLWrite(final int val) {
    this.sound1CntL = val;
  }

  private int onSound1CntHRead() {
    return this.sound1CntH;
  }

  private void onSound1CntHWrite(final int val) {
    this.sound1CntH = val;
  }

  private int onSound1CntXRead() {
    return this.sound1CntX;
  }

  private void onSound1CntXWrite(final int val) {
    this.sound1CntX = val;
  }

  private int onSound2CntLRead() {
    return this.sound2CntL;
  }

  private void onSound2CntLWrite(final int val) {
    this.sound2CntL = val;
  }

  private int onSound2CntHRead() {
    return this.sound2CntH;
  }

  private void onSound2CntHWrite(final int val) {
    this.sound2CntH = val;
  }

  private int onSound3CntLRead() {
    return this.sound3CntL;
  }

  private void onSound3CntLWrite(final int val) {
    this.sound3CntL = val;
  }

  private int onSound4CntLRead() {
    return this.sound4CntL;
  }

  private void onSound4CntLWrite(final int val) {
    this.sound4CntL = val;
  }

  private int onSound4CntHRead() {
    return this.sound4CntH;
  }

  private void onSound4CntHWrite(final int val) {
    this.sound4CntH = val;
  }

  private int onSoundCntLRead() {
    return this.soundCntL;
  }

  private void onSoundCntLWrite(final int val) {
    this.soundCntL = val;
  }

  private int onSoundCntHRead() {
    return this.soundCntH;
  }

  private void onSoundCntHWrite(final int val) {
    this.soundCntH = val;
  }

  private int onSoundCntXRead() {
    return this.soundCntX;
  }

  private void onSoundCntXWrite(final int val) {
    this.soundCntX = val;
  }

  private int onSoundBiasRead() {
    return this.soundBias;
  }

  private void onSoundBiasWrite(final int val) {
    this.soundBias = val;
  }

  private void onFifoAWrite(final int val) {
    //TODO
  }

  private void onFifoBWrite(final int val) {
    //TODO
  }

  public class SpuSegment extends Segment {
    public SpuSegment() {
      super(0x400_0060, 0x30);
    }

    @Override
    public int get(final int offset, final int size) {
      final int shift = (offset & 0x3) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      return switch(offset & 0x7e) {
        case 0x0 -> ((Spu.this.onSound1CntHRead() << 16 | Spu.this.onSound1CntLRead()) & mask) >> shift;
        case 0x4 -> (Spu.this.onSound1CntXRead() & mask) >> shift;

        case 0x8 -> (Spu.this.onSound2CntLRead() & mask) >> shift;

        case 0xc -> (Spu.this.onSound2CntHRead() & mask) >> shift;

        case 0x10 -> (Spu.this.onSound3CntLRead() & mask) >> shift;

        case 0x18 -> (Spu.this.onSound4CntLRead() & mask) >> shift;

        case 0x1c -> (Spu.this.onSound4CntHRead() & mask) >> shift;

        case 0x20 -> ((Spu.this.onSoundCntHRead() << 16 | Spu.this.onSoundCntLRead()) & mask) >> shift;
        case 0x24 -> (Spu.this.onSoundCntXRead() & mask) >> shift;

        case 0x28 -> (Spu.this.onSoundBiasRead() & mask) >> shift;

        default -> throw new IllegalAddressException("There is no SPU port at " + Integer.toHexString(this.getAddress() + offset));
      };
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      final int shift = (offset & 0x3) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      switch(offset & 0x7e) {
        case 0x0 -> {
          final int current = Spu.this.onSound1CntHRead() << 16 | Spu.this.onSound1CntLRead();
          final int newValue = current & ~mask | value << shift & mask;
          Spu.this.onSound1CntLWrite(newValue & 0xffff);
          Spu.this.onSound1CntHWrite(newValue >>> 16);
        }

        case 0x4 -> Spu.this.onSound1CntXWrite(Spu.this.onSound1CntXRead() & ~mask | value << shift & mask);

        case 0x8 -> Spu.this.onSound2CntLWrite(Spu.this.onSound2CntLRead() & ~mask | value << shift & mask);

        case 0xc -> Spu.this.onSound2CntHWrite(Spu.this.onSound2CntHRead() & ~mask | value << shift & mask);

        case 0x10 -> Spu.this.onSound3CntLWrite(Spu.this.onSound3CntLRead() & ~mask | value << shift & mask);

        case 0x18 -> Spu.this.onSound4CntLWrite(Spu.this.onSound4CntLRead() & ~mask | value << shift & mask);

        case 0x1c -> Spu.this.onSound4CntHWrite(Spu.this.onSound4CntHRead() & ~mask | value << shift & mask);

        case 0x20 -> {
          final int current = Spu.this.onSoundCntHRead() << 16 | Spu.this.onSoundCntLRead();
          final int newValue = current & ~mask | value << shift & mask;
          Spu.this.onSoundCntLWrite(newValue & 0xffff);
          Spu.this.onSoundCntHWrite(newValue >>> 16);
        }
        case 0x24 -> Spu.this.onSoundCntXWrite(Spu.this.onSoundCntXRead() & ~mask | value << shift & mask);

        case 0x28 -> Spu.this.onSoundBiasWrite(Spu.this.onSoundBiasRead() & ~mask | value << shift & mask);

        default -> throw new IllegalAddressException("There is no SPU port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }

  public class FifoSegment extends Segment {
    public FifoSegment() {
      super(0x400_00a0, 0x8);
    }

    @Override
    public int get(final int offset, final int size) {
      throw new RuntimeException("Cannot read from SPU FIFO");
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      switch(offset) {
        case 0x0 -> Spu.this.onFifoAWrite(value);
        case 0x4 -> Spu.this.onFifoBWrite(value);

        default -> throw new IllegalAddressException("There is no SPU port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }
}
