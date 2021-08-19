/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/18/21, 2:20 PM
 * =========================================
 */

package com.practice.serious;

public class maxSubArraySum {

  public static void main(String[] args) {
    maxSubArraySum me = new maxSubArraySum();
  }

  public int maxSubarraySumCircular(int[] nums) {
    int[] newArray = new int[nums.length * 2];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = nums[i % nums.length];
    }
    int dp[] = new int[newArray.length];
    int max = Integer.MIN_VALUE;
    dp[0] = nums[0];
    max = dp[0];
    for (int i = 1; i < newArray.length; i++) {
      dp[i] = Math.max(newArray[i], dp[i - 1] + newArray[i]);
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public int max(int nums[]) {
    int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
    for (int a : nums) {
      curMax = Math.max(curMax + a, a);
      maxSum = Math.max(maxSum, curMax);
      curMin = Math.min(curMin + a, a);
      minSum = Math.min(minSum, curMin);
      total += a;
    }
    return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
  }
}
