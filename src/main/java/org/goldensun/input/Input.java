package org.goldensun.input;

import org.goldensun.memory.IllegalAddressException;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;
import org.goldensun.memory.Value;
import org.goldensun.opengl.Window;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_BACKSPACE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Q;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;

public class Input {
  public static final int BUTTON_A = 0x1;
  public static final int BUTTON_B = 0x2;
  public static final int BUTTON_SELECT = 0x4;
  public static final int BUTTON_START = 0x8;
  public static final int BUTTON_RIGHT = 0x10;
  public static final int BUTTON_LEFT = 0x20;
  public static final int BUTTON_UP = 0x40;
  public static final int BUTTON_DOWN = 0x80;
  public static final int BUTTON_R = 0x100;
  public static final int BUTTON_L = 0x200;

  public static final int CONTROL_IRQ_ENABLE_MASK = 0b100_0000_0000_0000;
  public static final int CONTROL_IRQ_ENABLE_SHIFT = 14;
  public static final int CONTROL_IRQ_CONDITION_MASK = 0b100_0000_0000_0000;
  public static final int CONTROL_IRQ_CONDITION_SHIFT = 14;

  public static final int CONTROL_IRQ_CONDITION_OR = 0;
  public static final int CONTROL_IRQ_CONDITION_AND = 1;

  /** 4000130 */
  public final Value KEY_INPUT;
  /** 4000132 */
  public final Value KEY_CNT;

  private int input;
  private int control;

  public Input(final Memory memory, final Window.Events events) {
    this.KEY_INPUT = memory.ref(2, 0x400_0130);
    this.KEY_CNT = memory.ref(2, 0x400_0132);

    memory.addSegment(new InputSegment());

    events.onKeyPress(this::handleInputPressed);
    events.onKeyRelease(this::handleInputReleased);
  }

  private void handleInputPressed(final Window window, final int key, final int scancode, final int mods) {
    switch(key) {
      case GLFW_KEY_S -> this.input |= BUTTON_A;
      case GLFW_KEY_D -> this.input |= BUTTON_B;
      case GLFW_KEY_BACKSPACE -> this.input |= BUTTON_SELECT;
      case GLFW_KEY_ENTER -> this.input |= BUTTON_START;
      case GLFW_KEY_RIGHT -> this.input |= BUTTON_RIGHT;
      case GLFW_KEY_LEFT -> this.input |= BUTTON_LEFT;
      case GLFW_KEY_UP -> this.input |= BUTTON_UP;
      case GLFW_KEY_DOWN -> this.input |= BUTTON_DOWN;
      case GLFW_KEY_E -> this.input |= BUTTON_R;
      case GLFW_KEY_Q -> this.input |= BUTTON_L;
    }
  }

  private void handleInputReleased(final Window window, final int key, final int scancode, final int mods) {
    switch(key) {
      case GLFW_KEY_S -> this.input &= ~BUTTON_A;
      case GLFW_KEY_D -> this.input &= ~BUTTON_B;
      case GLFW_KEY_BACKSPACE -> this.input &= ~BUTTON_SELECT;
      case GLFW_KEY_ENTER -> this.input &= ~BUTTON_START;
      case GLFW_KEY_RIGHT -> this.input &= ~BUTTON_RIGHT;
      case GLFW_KEY_LEFT -> this.input &= ~BUTTON_LEFT;
      case GLFW_KEY_UP -> this.input &= ~BUTTON_UP;
      case GLFW_KEY_DOWN -> this.input &= ~BUTTON_DOWN;
      case GLFW_KEY_E -> this.input &= ~BUTTON_R;
      case GLFW_KEY_Q -> this.input &= ~BUTTON_L;
    }
  }

  private int onInputRead() {
    return this.input;
  }

  private int onControlRead() {
    return this.control;
  }

  private void onControlWrite(final int val) {
    this.control = val;
  }

  public class InputSegment extends Segment {
    public InputSegment() {
      super(0x400_0130, 0x4);
    }

    @Override
    public int get(final int offset, final int size) {
      final int shift = (offset & 0x1) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      return switch(offset & 0x2) {
        case 0x0 -> (Input.this.onInputRead() & mask) >> shift;
        case 0x2 -> (Input.this.onControlRead() & mask) >> shift;

        default -> throw new IllegalAddressException("There is no input port at " + Integer.toHexString(this.getAddress() + offset));
      };
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      final int shift = (offset & 0x1) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      switch(offset & 0x2) {
        case 0x2 -> Input.this.onControlWrite(value << shift & mask);

        default -> throw new IllegalAddressException("There is no input port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }
}
