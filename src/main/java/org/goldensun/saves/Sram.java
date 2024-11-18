package org.goldensun.saves;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Sram {
  private static final Logger LOGGER = LogManager.getFormatterLogger(Sram.class);

  public static final int MANUFACTURER = 0xbf;
  public static final int DEVICE = 0xd4;

  private final SramSegment segment;
  private final byte[] data = new byte[0x1_0000];
  private long lastWrite;

  public Sram(final Memory memory) {
    this.segment = memory.addSegment(new SramSegment());
  }

  public void tick() {
    if(this.lastWrite != 0) {
      if(System.nanoTime() - this.lastWrite > 1_000_000_000) {
        LOGGER.info("Writing save to disk");
        this.segment.reset();

        try {
          Files.write(Path.of("save.dat"), this.data, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch(final IOException e) {
          LOGGER.error("Failed to write save data", e);
        }

        this.lastWrite = 0;
      }
    }
  }

  public class SramSegment extends Segment {
    private int commandStage;
    private MODE mode = MODE.NONE;
    private final int[] buffer = new int[2];

    public SramSegment() {
      super(0xe00_0000, 0x1_0000);
    }

    private void reset() {
      this.commandStage = 0;
      this.mode = MODE.NONE;
    }

    @Override
    public int get(final int offset, final int size) {
      if(size != 1) {
        throw new IllegalArgumentException("Size must be 1");
      }

      if(this.mode == MODE.ID) {
        if(offset == 0) {
          return MANUFACTURER;
        }

        if(offset == 1) {
          return DEVICE;
        }
      }

      return Sram.this.data[offset] & 0xff;
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      if(size != 1) {
        throw new IllegalArgumentException("Size must be 1");
      }

      if(this.commandStage == 0 && offset == 0x5555) {
        this.buffer[0] = value;
        this.commandStage++;
        return;
      }

      if(this.commandStage == 1 && offset == 0x2aaa) {
        this.buffer[1] = value;
        this.commandStage++;
        return;
      }

      if(this.commandStage == 2 && offset == 0x5555) {
        if(value == 0x90 && this.buffer[0] == 0xaa && this.buffer[1] == 0x55 && this.mode == MODE.NONE) {
          LOGGER.info("Entering SRAM ID mode");
          this.mode = MODE.ID;
          this.commandStage = 0;
          return;
        }

        if(value == 0xf0 && this.buffer[0] == 0xaa && this.buffer[1] == 0x55 && this.mode == MODE.ID) {
          LOGGER.info("Exiting SRAM ID mode");
          this.mode = MODE.NONE;
          this.commandStage = 0;
          return;
        }

        // It wasn't a command so write the deferred bytes
        Sram.this.data[0x5555] = (byte)this.buffer[0];
        Sram.this.data[0x2aaa] = (byte)this.buffer[1];
      }

      Sram.this.data[offset] = (byte)value;
      Sram.this.lastWrite = System.nanoTime();
    }
  }

  public enum MODE {
    NONE,
    ID,
  }
}
