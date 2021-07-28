/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/25/20, 6:16 PM
 * =========================================
 */

// https://leetcode.com/problems/sliding-window-median/
package com.practice.leetcode.array;

import java.util.PriorityQueue;

public class SlidingWindowMean {
  public static void main(String[] args) {
    SlidingWindowMean me = new SlidingWindowMean();
    double[] res =
        me.medianSlidingWindow(
            new int[] {
              -2147483648,
              -2147483648,
              2147483647,
              -2147483648,
              -2147483648,
              -2147483648,
              2147483647,
              2147483647,
              2147483647,
              2147483647,
              -2147483648,
              2147483647,
              -2147483648
            },
            3);
    System.out.println("Result");
  }

  private PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a.compareTo(b));
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

  private void rebalanceHeaps() {
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (minHeap.size() > maxHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  private double[] medianSlidingWindow(int[] nums, int k) {
    double[] results = new double[nums.length - k + 1];
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (minHeap.size() > 0 && minHeap.peek() <= nums[i]) {
        minHeap.add(nums[i]);
      } else {
        maxHeap.add(nums[i]);
      }
      rebalanceHeaps();
      if (i - k + 1 >= 0) {
        if (maxHeap.size() == minHeap.size()) {
          results[index++] = (((double) minHeap.peek()) + ((double) maxHeap.peek())) / 2;
        } else {
          results[index++] = (double) (maxHeap.peek());
        }
        if (maxHeap.peek() >= nums[i - k + 1]) {
          maxHeap.remove(nums[i - k + 1]);
        } else if (minHeap.peek() <= nums[i - k + 1]) {
          minHeap.remove(nums[i - k + 1]);
        }
        rebalanceHeaps();
      }
    }
    return results;
  }
}
