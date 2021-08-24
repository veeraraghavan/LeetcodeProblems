/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/23/21, 10:28 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class MaxNonOverlapping {

  public static void main(String[] args) {
    MaxNonOverlapping me = new MaxNonOverlapping();
  }

  public int maxNonOverlapping(int[] nums, int target) {
    HashMap<Integer, Integer> sumByIndex = new HashMap();
    sumByIndex.put(0, -1);
    int count = 0;
    int sum = 0;
    int lastIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sumByIndex.containsKey(sum - target) && sumByIndex.get(sum - target) >= lastIndex) {
        lastIndex = i;
        count++;
      }
      sumByIndex.put(sum, i);
    }
    return count;
  }
}
