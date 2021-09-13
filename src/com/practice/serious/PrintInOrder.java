/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/12/21, 11:19 AM
 * =========================================
 */

package com.practice.serious;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintInOrder {
  public static void main(String[] args) {
    PrintInOrder me = new PrintInOrder();
  }

  AtomicInteger firstJobDone = new AtomicInteger(0);
  AtomicInteger secondJobDone = new AtomicInteger(0);

  public PrintInOrder() {}

  public synchronized void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    firstJobDone.incrementAndGet();
    notifyAll();
  }

  public synchronized void second(Runnable printSecond) throws InterruptedException {

    // printSecond.run() outputs "second". Do not change or remove this line.
    while (firstJobDone.get() != 1) {
      wait();
    }
    printSecond.run();
    secondJobDone.incrementAndGet();
    notifyAll();
  }

  public synchronized void third(Runnable printThird) throws InterruptedException {

    // printThird.run() outputs "third". Do not change or remove this line.
    while (secondJobDone.get() == 0) wait();
    printThird.run();
  }
}
