/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/12/21, 8:15 PM
 * =========================================
 */

package com.practice.serious;

import java.util.function.IntConsumer;

public class FizzBuzz {
  private int n;
  int state = 0; // 1->fizz,2->buzz,3->FizzBuzz
  // int val = 0;

  public FizzBuzz(int n) {
    this.n = n;
  }

  public static void main(String[] args) throws InterruptedException {
    FizzBuzz me = new FizzBuzz(15);
    Thread t1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  me.fizz(
                      new Runnable() {
                        @Override
                        public void run() {
                          System.out.println("fizz");
                        }
                      });
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    Thread t2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  me.buzz(
                      new Runnable() {
                        @Override
                        public void run() {
                          System.out.println("buzz");
                        }
                      });
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    Thread t3 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  me.fizzbuzz(
                      new Runnable() {
                        @Override
                        public void run() {
                          System.out.println("fizzbuzz");
                        }
                      });
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    Thread t4 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  me.number(
                      new IntConsumer() {
                        @Override
                        public void accept(int value) {
                          System.out.println(value);
                        }
                      });
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t1.join();
    t2.join();
    t3.join();
    t4.join();
  }

  // printFizz.run() outputs "fizz".
  public synchronized void fizz(Runnable printFizz) throws InterruptedException {
    for (int i = 3; i <= n; i += 3) {
      if (i % 15 == 0) continue;
      while (state != 1) {
        wait();
      }
      printFizz.run();
      state = 0;
      notifyAll();
    }
  }

  // printBuzz.run() outputs "buzz".
  public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
    for (int i = 5; i <= n; i += 5) {
      if (i % 15 == 0) continue;
      while (state != 2) {
        wait();
      }
      printBuzz.run();
      state = 0;
      notifyAll();
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    for (int i = 15; i <= n; i += 15) {
      while (state != 3 && i <= n) {
        wait();
      }
      printFizzBuzz.run();
      state = 0;
      notifyAll();
    }
  }

  //   printNumber.accept(x) outputs "x", where x is an integer.
  public synchronized void number(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        state = 3;
        while (state != 0) {
          notifyAll();
          wait();
        }
      } else if (i % 5 == 0) {
        state = 2;
        while (state != 0) {
          notifyAll();
          wait();
        }
      } else if (i % 3 == 0) {
        state = 1;
        while (state != 0) {
          notifyAll();
          wait();
        }
      } else {
        printNumber.accept(i);
      }
    }
  }
}
