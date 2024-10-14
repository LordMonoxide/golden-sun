package org.goldensun;

public final class DebugHelper {
  private DebugHelper() { }

  public static void sleep(final long millis) {
    try {
      Thread.sleep(millis);
    } catch(final InterruptedException ignored) { }
  }

  public static void pause() {
    final boolean running = true;
    while(running) {
      sleep(100);
    }
  }

  public static StackWalker.StackFrame getStackFrame(final int steps) {
    return StackWalker.getInstance().walk(frames -> frames
      .skip(steps + 1)
      .findFirst())
      .get();
  }

  public static StackWalker.StackFrame getCallerFrame() {
    return getStackFrame(2);
  }
}
