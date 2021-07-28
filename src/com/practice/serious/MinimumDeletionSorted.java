/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/22/21, 10:59 PM
 * =========================================
 */

package com.practice.serious;

public class MinimumDeletionSorted {
  public static void main(String[] args) {
    MinimumDeletionSorted me = new MinimumDeletionSorted();
    int[] nums = {4, 2, 3, 6, 10, 1, 12};
    System.out.println(me.findMinimumDeletions(nums));
    nums = new int[] {-4, 10, 3, 7, 15};
    System.out.println(me.findMinimumDeletions(nums));
    nums = new int[] {3, 2, 1, 0};
    System.out.println(me.findMinimumDeletions(nums));
  }

  private int findMinimumDeletions(int[] nums) {
    int dp[] = new int[nums.length];
    dp[0] = 1;
    int max = 0;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] >= nums[i] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          max = Math.max(dp[i], max);
        }
      }
    }
    return nums.length - max;
  }
}
