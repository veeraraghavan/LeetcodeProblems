/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/12/21, 7:43 PM
 * =========================================
 */

package com.practice.serious;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
  private int n;
  private int state = 0;
  private int lastState = 0;

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      while (state != 0) {
        wait();
      }
      printNumber.accept(0);
      state = lastState == 1 ? 2 : 1;
      notifyAll();
    }
  }

  public synchronized void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      while (state != 2) {
        wait();
      }

      printNumber.accept(i);
      state = 0;
      lastState = 2;
      notifyAll();
    }
  }

  public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      while (state != 1) {
        wait();
      }

      printNumber.accept(i);
      state = 0;
      lastState = 1;
      notifyAll();
    }
  }
}
