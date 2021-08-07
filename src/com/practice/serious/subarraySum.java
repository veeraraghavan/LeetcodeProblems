/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/5/21, 11:31 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class subarraySum {
  public static void main(String[] args) {
    subarraySum me = new subarraySum();
    System.out.println(me.subarraySum(new int[] {1, 2, 3, 1, 2}, 2));
  }
  /*

  */
  private int subarraySum(int[] nums, int k) {
    int count = 0;
    HashMap<Integer, Integer> countMap = new HashMap<>();
    int cumulativeSum = 0;
    for (int i = 0; i < nums.length; i++) {
      cumulativeSum += nums[i];
      if (cumulativeSum == k) count++;
      if (countMap.containsKey(cumulativeSum - k)) count += countMap.get(cumulativeSum - k);
      int temp = countMap.getOrDefault(cumulativeSum, 0);
      countMap.put(cumulativeSum, temp + 1);
    }

    return count;
  }
}
