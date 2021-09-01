/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/31/21, 11:45 PM
 * =========================================
 */

package com.practice.serious;

public class LongestSubarrayDeleting {
  public static void main(String[] args) {
    LongestSubarrayDeleting me = new LongestSubarrayDeleting();
  }

  public int longestSubarray(int[] nums) {
    // 2pointer
    int[] dp = new int[nums.length];
    int max = 0;
    for (int i = 0, j = -1; i < nums.length; i++) {
      if (i == 0) {
        if (nums[i] == 0) j = 0;
        dp[i] = nums[i];
      } else {
        if (nums[i] == 0) {
          if (j == -1) {
            dp[i] = dp[i - 1];
          } else {
            dp[i] = Math.min(dp[i - 1], i - j - 1);
          }
          j = i;
        } else {
          dp[i] = dp[i - 1] + 1;
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max == nums.length ? max - 1 : max;
  }
}
