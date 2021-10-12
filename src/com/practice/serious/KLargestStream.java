/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/12/21, 12:05 AM
 * =========================================
 */

package com.practice.serious;

import java.util.PriorityQueue;

public class KLargestStream {
  public static void main(String[] args) {
    // KLargestStream me = new KLargestStream();
  }

  PriorityQueue<Integer> maxHeap, minHeap;
  int k;

  public KLargestStream(int k, int[] nums) {
    this.k = k;
    maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
    for (int num : nums) {
      balanceHeap(num);
    }
  }

  private void balanceHeap(int val) {
    minHeap.add(val);
    if (minHeap.size() > this.k - 1) {
      maxHeap.add(minHeap.poll());
    }
  }

  public int add(int val) {
    balanceHeap(val);
    return maxHeap.peek();
  }
}
