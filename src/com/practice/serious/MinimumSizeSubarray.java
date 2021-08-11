/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/10/21, 5:27 PM
 * =========================================
 */

package com.practice.serious;

public class MinimumSizeSubarray {
  public static void main(String[] args) {
    MinimumSizeSubarray me = new MinimumSizeSubarray();
  }

  public int minSubArrayLen(int target, int[] nums) {
    int count = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int loopSum = 0;
      for (int j = i; j < nums.length; j++) {
        loopSum += nums[j];
        if (loopSum >= target) {
          count = Math.min(count, j - i + 1);
          break;
        }
      }
    }
    return count == Integer.MAX_VALUE ? 0 : count;
  }

  public int minSubArrayLenWindow(int target, int[] nums) {
    int count = Integer.MAX_VALUE;
    int windowStart = 0;
    int windowSum = 0;
    for (int i = 0; i < nums.length; i++) {
      windowSum += nums[i];
      while (windowSum >= target) {
        count = Math.min(count, i - windowStart + 1);
        windowSum -= nums[windowStart++];
      }
    }
    return count == Integer.MAX_VALUE ? 0 : count;
  }
}
