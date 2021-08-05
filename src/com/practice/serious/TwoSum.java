/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/4/21, 10:06 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class TwoSum {
  public static void main(String[] args) {
    TwoSum me = new TwoSum();
  }

  public int[] twoSum(int[] nums, int target) {
    int result[] = new int[2];
    HashMap<Integer, Integer> numberDict = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      numberDict.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      if (numberDict.containsKey(target - nums[i]) && numberDict.get(target - nums[i]) != i) {
        result[0] = i;
        result[1] = numberDict.get(target - nums[i]);
      }
    }

    return result;
  }
}
