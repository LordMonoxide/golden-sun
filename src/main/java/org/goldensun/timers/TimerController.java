package org.goldensun.timers;

import org.goldensun.DebugHelper;
import org.goldensun.cpu.InterruptController;
import org.goldensun.memory.Memory;

public class TimerController implements Runnable {
  public final Timer[] timers = new Timer[4];

  private boolean running;

  public TimerController(final Memory memory, final InterruptController interrupts) {
    for(int i = 0; i < this.timers.length; i++) {
      this.timers[i] = new Timer(i, memory, interrupts);
    }
  }

  public void stop() {
    this.running = false;
  }

  @Override
  public void run() {
    this.running = true;

    while(this.running) {
      for(final Timer timer : this.timers) {
        timer.tick();
      }

      DebugHelper.sleep(0);
    }
  }
}
