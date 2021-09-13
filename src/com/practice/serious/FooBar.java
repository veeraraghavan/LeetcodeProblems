/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/12/21, 11:39 AM
 * =========================================
 */

package com.practice.serious;

public class FooBar {
  private int n;
  boolean fooRun = true;

  public FooBar(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    synchronized (this) {
      for (int i = 0; i < n; i++) {
        while (!fooRun) {
          wait();
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
        printFoo.run();
        fooRun = false;
        notifyAll();
      }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    synchronized (this) {
      for (int i = 0; i < n; i++) {
        while (fooRun) {
          wait();
        }
        // printBar.run() outputs "bar". Do not change or remove this line.
        printBar.run();
        fooRun = true;
        notifyAll();
      }
    }
  }
}
