/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/25/20, 5:23 PM
 * =========================================
 */

package com.practice.leetcode.array;

import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/

public class MedianFinder {

  /** initialize your data structure here. */
  private PriorityQueue<Integer> maxHeap;

  private PriorityQueue<Integer> minHeap;

  private MedianFinder() {
    maxHeap = new PriorityQueue<>((a, b) -> b - a);
    minHeap = new PriorityQueue<>((a, b) -> a - b);
  }

  private void addNum(int num) {
    /*
    Logic : MaxHeap will be equal to length of minHeap or equal to minHeap+1.
            If condition is not satisfied re-balance.
            Where should you check the new element and why?
            5,9,1,3,10
            Element- 5
                MinHeap -
                MaxHeap - 5

            Element 9
                MinHeap -
                MaxHeap - 5,9 , re-balance

                MinHeap - 9
                MaxHeap - 5


            Element 1
                MinHeap - 9
                MaxHeap - 1,5

             Element 3
                MinHeap - 9
                MaxHeap - 1,3,5 , rebalance

                MinHeap - 5,9
                MaxHeap - 1,3

              Element 1
                MinHeap - 9
                MaxHeap - 1,5

    */
    if (minHeap.size() > 0 && minHeap.peek() < num) {
      minHeap.add(num);
    } else {
      maxHeap.add(num);
    }
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (minHeap.size() > maxHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  private double findMedian() {
    if (minHeap.size() == maxHeap.size()) {
      /*  System.out.println((double) maxHeap.peek() / 2);
      System.out.println((double) minHeap.peek() / 2);*/
      return ((double) minHeap.peek() / 2 + (double) maxHeap.peek() / 2);
    }
    return maxHeap.peek();
  }

  public static void main(String[] args) {
    MedianFinder me = new MedianFinder();
    me.addNum(1);
    me.addNum(2);
    System.out.println(me.findMedian());
    me.addNum(3);
    System.out.println(me.findMedian());
  }
}
