/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/6/21, 12:01 AM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class checkSubarraySum {
  public static void main(String[] args) {
    checkSubarraySum me = new checkSubarraySum();
    me.checkSubarraySumLinear(new int[] {23, 2, 4, 6, 6}, 7);
  }

  private boolean checkSubarraySum(int[] nums, int k) {

    for (int i = 0; i < nums.length - 1; i++) {
      int sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        if (sum % k == 0) {
          return true;
        }
      }
    }
    return false;
  }
  // if there are points in array
  private boolean checkSubarraySumLinear(int[] nums, int k) {
    HashMap<Integer, Integer> countMap = new HashMap<>();
    countMap.put(0, -1);
    int sum = 0;
    int mod = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (k == 0) {
        mod = sum;
      } else {
        mod = sum % k;
      }
      if (countMap.containsKey(mod) && (i - countMap.get(mod) > 1)) return true;
      countMap.putIfAbsent(mod, i);
    }
    return false;
  }
}
