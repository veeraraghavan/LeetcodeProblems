/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   2/3/22, 5:07 PM
 * =========================================
 */
// https://leetcode.com/problems/two-sum/
package com.practice.revision;

import java.util.HashMap;

public class twosum {
  public static void main(String[] args) {
    twosum me = new twosum();
  }

  public int[] twoSum(int[] nums, int target) {
    int result[] = new int[2];
    HashMap<Integer, Integer> numberDict = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (numberDict.containsKey(target - nums[i])) {
        result[0] = i;
        result[1] = numberDict.get(target - nums[i]);
        return result;
      }
      numberDict.put(nums[i], i);
    }

    return result;
  }
}
