/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/22/21, 10:34 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentNum {

  public static void main(String[] args) {
    TopKFrequentNum me = new TopKFrequentNum();
  }

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> numCount = new HashMap();
    for (int num : nums) {
      int count = numCount.getOrDefault(num, 0);
      numCount.put(num, count + 1);
    }

    PriorityQueue<Integer> frequentNum =
        new PriorityQueue((a, b) -> numCount.get(b) - numCount.get(a));
    frequentNum.addAll(numCount.keySet());
    int res[] = new int[k];
    int index = 0;
    while (index < k) {
      res[index] = frequentNum.poll();
      index++;
    }
    return res;
  }
}
