/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/2/22, 9:21 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.ArrayDeque;
import java.util.HashMap;

public class maxslidingwindow {
  public static void main(String[] args) {
    maxslidingwindow me = new maxslidingwindow();
    me.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }

  ArrayDeque<Integer> window = new ArrayDeque<>();

  public void adjustWindow(int index, int[] nums, int k) {

    if (!window.isEmpty() && window.getFirst() == index - k) window.removeFirst();
    while (!window.isEmpty() && nums[window.getLast()] <= nums[index]) {
      window.removeLast();
    }
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    // TreeMap<Integer, Integer> window = new TreeMap();
    HashMap<Integer, Integer> elements = new HashMap();
    int[] res = new int[nums.length - k + 1];

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < k; i++) {
      adjustWindow(i, nums, k);
      window.addLast(i);
      max = Math.max(max, nums[i]);
    }
    res[0] = max;
    for (int i = k; i < nums.length; i++) {
      adjustWindow(i, nums, k);
      window.addLast(i);
      res[i - k + 1] = nums[window.getFirst()];
    }

    return res;
  }

  public int getMax(HashMap<Integer, Integer> elements) {
    int start = Integer.MIN_VALUE;
    for (int key : elements.keySet()) {
      if (elements.get(key) > start) start = elements.get(key);
    }
    return start;
  }
}
