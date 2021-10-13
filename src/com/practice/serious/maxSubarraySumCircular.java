/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/12/21, 11:32 AM
 * =========================================
 */

package com.practice.serious;

public class maxSubarraySumCircular {
  public static void main(String[] args) {
    maxSubarraySumCircular me = new maxSubarraySumCircular();
  }

  public int maxSubarraySumCircular(int[] nums) {
    int[] curMax = new int[nums.length];
    int[] curMin = new int[nums.length];
    curMax[0] = nums[0];
    curMin[0] = nums[0];
    int max = nums[0], sum = nums[0], min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      curMax[i] = Math.max(curMax[i - 1] + nums[i], nums[i]);
      max = Math.max(curMax[i], max);
      curMin[i] = Math.min(curMin[i - 1] + nums[i], nums[i]);
      min = Math.min(min, curMin[i]);
      sum += nums[i];
    }
    return max > 0 ? Math.max(max, sum - min) : max;
  }
}
