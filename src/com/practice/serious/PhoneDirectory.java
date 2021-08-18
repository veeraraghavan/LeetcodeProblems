/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/17/21, 9:55 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PhoneDirectory {

  public static void main(String[] args) {
    PhoneDirectory me = new PhoneDirectory(3);
    me.get();
    me.get();
    me.check(2);
    me.get();
    me.check(2);
    me.release(2);
    me.check(2);
  }

  // private PriorityQueue<Integer> directory = new PriorityQueue();
  private HashSet<Integer> directory = new HashSet<>();
  private List<Integer> numberList = new ArrayList<>();

  private PhoneDirectory(int maxNumbers) {

    for (int i = 0; i < maxNumbers; i++) {
      numberList.add(i);
      directory.add(i);
    }
  }

  /**
   * Provide a number which is not assigned to anyone.
   *
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get() {
    if (directory.size() == 0) return -1;
    int number = numberList.get(0);
    numberList.remove(0);
    directory.remove(number);
    return number;
  }

  /** Check if a number is available or not. */
  public boolean check(int number) {
    return directory.contains(number);
  }

  /** Recycle or release a number. */
  private void release(int number) {
    if (directory.contains(number)) return;
    numberList.add(number);
    directory.add(number);
  }
}
