/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/21/22, 4:09 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.PriorityQueue;

public class MedianFinder {
  public static void main(String[] args) {
    MedianFinder me = new MedianFinder();
    me.addNum(-1);
    System.out.println(me.findMedian());
    me.addNum(-2);
    System.out.println(me.findMedian());
    me.addNum(-3);
    System.out.println(me.findMedian());
    me.addNum(-4);
    System.out.println(me.findMedian());
    me.addNum(-5);
    System.out.println(me.findMedian());
  }

  PriorityQueue<Integer> lower;
  PriorityQueue<Integer> higher;

  public MedianFinder() {
    lower = new PriorityQueue<Integer>((a, b) -> b - a);
    higher = new PriorityQueue<Integer>((a, b) -> a - b);
    // have decided to keep higher with having the extra element
  }

  public void addNum(int num) {

    if (lower.size() > 0 && lower.peek() > num) {
      lower.add(num);
    } else {
      higher.add(num);
    }
    balanceHeaps();
  }

  public double findMedian() {
    int sizeOfLower = lower.size();
    int sizeOfHigher = higher.size();
    int totalSize = sizeOfHigher + sizeOfLower;
    if (totalSize % 2 == 1) return (double) higher.peek();
    return (double) ((lower.peek() + higher.peek()) / 2.0);
  }

  public void balanceHeaps() {
    int sizeOfLower = lower.size();
    int sizeOfHigher = higher.size();

    if (sizeOfHigher > sizeOfLower + 1) {
      lower.add(higher.poll());
    }

    if (sizeOfLower > sizeOfHigher) {
      higher.add(lower.poll());
    }
  }
}
