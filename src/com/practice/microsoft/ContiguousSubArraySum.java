/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/30/21, 11:45 PM
 * =========================================
 */

package com.practice.microsoft;

public class ContiguousSubArraySum {
  public static void main(String[] args) {
    ContiguousSubArraySum me = new ContiguousSubArraySum();
  }

  public int maxSubArray(int[] nums) {
    int max = 0;
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    max = Math.max(max, nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if (dp[i - 1] + nums[i] > nums[i]) {
        dp[i] = nums[i] + dp[i - 1];
      } else {
        dp[i] = nums[i];
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
