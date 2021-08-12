/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/4/21, 10:06 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;
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

  public int[] twoSum2P(int[] nums, int target) {
    Arrays.sort(nums);
    int result[] = new int[] {-1, -1};
    int ws = 0, we = nums.length - 1;
    while (ws <= we) {
      int sum = 0;
      for (int i = ws; i <= we; i++) {
        sum += nums[i];
        if (sum > target) break;
      }
      if (sum > target) {
        we--;
      } else if (sum < target) {
        ws++;
      } else {
        result[0] = ws;
        result[1] = we;
        return result;
      }
    }
    return result;
  }

  private boolean isEqual(int[] nums, int start, int end, int target) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += nums[i];
      if (sum > target) return false;
    }
    return sum == target;
  }
}
