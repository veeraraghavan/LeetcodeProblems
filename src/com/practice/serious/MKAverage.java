/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/7/21, 11:39 PM
 * =========================================
 */

package com.practice.serious;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class MKAverage {
  public static void main(String[] args) {
    MKAverage me = new MKAverage(3, 1);
    me.addElement(17612);
    me.addElement(74607);
    System.out.println(me.calculateMKAverage());
    me.addElement(8272);
    me.addElement(33433);
    System.out.println(me.calculateMKAverage());
    me.addElement(15456);
    me.addElement(64938);
    System.out.println(me.calculateMKAverage());
    me.addElement(99741);
  }

  int m;
  int k;
  TreeMap<Integer, Integer> largest, smallest, middle;
  Queue<Integer> queue = new LinkedList<>();
  int largestCount = 0, smallestCount = 0, sum = 0;

  public MKAverage(int m, int k) {
    this.m = m;
    this.k = k;
    largest = new TreeMap<>();
    smallest = new TreeMap<>();
    middle = new TreeMap<>();
  }

  public void addElement(int num) {

    if (queue.size() >= m) {
      int pop = queue.poll();
      if (largest.containsKey(pop)) {
        remove(largest, pop);
        largestCount--;
      } else if (middle.containsKey(pop)) {
        remove(middle, pop);
        sum -= pop;
      } else {
        remove(smallest, pop);
        smallestCount--;
      }
    }
    sum += num;
    queue.add(num);
    add(middle, num);
    while (largestCount < this.k && !middle.isEmpty()) {
      sum -= middle.lastKey();
      add(largest, remove(middle, middle.lastKey()));
      largestCount++;
    }
    while ((!middle.isEmpty() && !largest.isEmpty()) && (largest.firstKey() < middle.lastKey())) {
      sum += largest.firstKey();
      add(middle, remove(largest, largest.firstKey()));
      sum -= middle.lastKey();
      add(largest, remove(middle, middle.lastKey()));
    }
    while (smallestCount < this.k && !middle.isEmpty()) {
      sum -= middle.firstKey();
      add(smallest, remove(middle, middle.firstKey()));
      smallestCount++;
    }
    while ((!middle.isEmpty() && !smallest.isEmpty()) && (middle.firstKey() < smallest.lastKey())) {
      sum -= middle.firstKey();
      add(smallest, remove(middle, middle.firstKey()));
      sum += smallest.lastKey();
      add(middle, remove(smallest, smallest.lastKey()));
    }
  }

  private void add(TreeMap<Integer, Integer> map, Integer num) {
    map.put(num, map.getOrDefault(num, 0) + 1);
  }

  private Integer remove(TreeMap<Integer, Integer> map, Integer num) {
    map.put(num, map.getOrDefault(num, 0) - 1);
    if (map.get(num) == 0) {
      map.remove(num);
    }
    return num;
  }

  public int calculateMKAverage() {
    if (queue.size() < this.m) {
      return -1;
    }
    return this.sum / (this.m - 2 * this.k);
  }
}
