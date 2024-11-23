package org.goldensun.saves;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Sram {
  private static final Logger LOGGER = LogManager.getFormatterLogger(Sram.class);

  // SST
  public static final int MANUFACTURER = 0xbf;
  public static final int DEVICE = 0xd4;

  private final Path path = Path.of("save.dat");

  private final SramSegment segment;
  private final byte[] data = new byte[0x1_0000];
  private long lastWrite;

  public Sram(final Memory memory) {
    this.segment = memory.addSegment(new SramSegment());

    if(Files.exists(this.path)) {
      LOGGER.info("Loading save from disk");

      try {
        final byte[] saveData = Files.readAllBytes(this.path);
        System.arraycopy(saveData, 0, this.data, 0, Math.min(this.data.length, saveData.length));
      } catch(final IOException e) {
        LOGGER.info("Failed to load save", e);
      }
    }
  }

  public void tick() {
    if(this.lastWrite != 0) {
      if(System.nanoTime() - this.lastWrite > 1_000_000_000) {
        LOGGER.info("Writing save to disk");
        this.segment.reset();

        try {
          Files.write(this.path, this.data, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
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

      switch(this.mode) {
        case NONE, ID -> {
          if(this.commandStage == 0 && offset == 0x5555 && value == 0xaa) {
            this.commandStage++;
            return;
          }

          if(this.commandStage == 1 && offset == 0x2aaa && value == 0x55) {
            this.commandStage++;
            return;
          }

          if(this.commandStage == 2 && offset == 0x5555) {
            switch(value) {
              case 0x90 -> {
                LOGGER.info("Entering SRAM ID mode");
                this.mode = MODE.ID;
                this.commandStage = 0;
              }

              case 0xf0 -> {
                LOGGER.info("Exiting SRAM ID mode");
                this.mode = MODE.NONE;
                this.commandStage = 0;
              }

              case 0x80 -> {
                LOGGER.info("Entering erase mode");
                this.mode = MODE.ERASE;
                this.commandStage = 0;
              }

              case 0xa0 -> {
                this.mode = MODE.WRITE;
                this.commandStage = 0;
              }

              default -> throw new IllegalArgumentException("Unknown command 0x%x in mode %s".formatted(value, this.mode));
            }
          }

          return;
        }

        case ERASE -> {
          if(this.commandStage == 0 && offset == 0x5555 && value == 0xaa) {
            this.commandStage++;
            return;
          }

          if(this.commandStage == 1 && offset == 0x2aaa && value == 0x55) {
            this.commandStage++;
            return;
          }

          if(this.commandStage == 2 && (offset & 0xfff) == 0 && value == 0x30) {
            LOGGER.info("Erasing sector 0x%x", offset);
            Arrays.fill(Sram.this.data, offset, offset + 0x1000, (byte)0xff);
            this.mode = MODE.NONE;
            this.commandStage = 0;
            Sram.this.lastWrite = System.nanoTime();
            return;
          }
        }

        case WRITE -> {
          Sram.this.data[offset] = (byte)value;
          Sram.this.lastWrite = System.nanoTime();
          return;
        }
      }

      throw new IllegalArgumentException("Can't write in mode " + this.mode);
    }
  }

  public enum MODE {
    NONE,
    ID,
    ERASE,
    WRITE,
  }
}
