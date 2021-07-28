/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/27/21, 10:48 PM
 * =========================================
 */

package com.practice.serious;

public class EqualSumSubset {
  public static void main(String[] args) {
    EqualSumSubset me = new EqualSumSubset();
    System.out.println(me.willPartitionWorkBottomUp(new int[] {2, 2}));
  }

  private boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 == 1) return false;
    // return willPartitionWork(nums, 0, 0, sum / 2);
    return willPartitionWorkTopDown(new Boolean[nums.length][sum / 2], nums, 0, 0, sum / 2);
  }

  private boolean willPartitionWork(int[] nums, int currentIndex, int sum, int target) {
    if (sum == target) return true;
    if (currentIndex == nums.length) return false;
    boolean branch1 = false, branch2 = false;
    if (nums[currentIndex] + sum <= target)
      branch1 = willPartitionWork(nums, currentIndex + 1, sum + nums[currentIndex], target);
    branch2 = willPartitionWork(nums, currentIndex + 1, sum, target);
    return branch1 || branch2;
  }

  private boolean willPartitionWorkTopDown(
      Boolean[][] dp, int[] nums, int currentIndex, int sum, int target) {
    if (sum == target) return true;
    if (currentIndex == nums.length) return false;
    if (dp[currentIndex][sum] != null) return dp[currentIndex][sum];
    boolean branch1 = false, branch2 = false;
    if (nums[currentIndex] + sum <= target)
      branch1 =
          willPartitionWorkTopDown(dp, nums, currentIndex + 1, sum + nums[currentIndex], target);
    branch2 = willPartitionWorkTopDown(dp, nums, currentIndex + 1, sum, target);
    dp[currentIndex][sum] = branch1 || branch2;
    return branch1 || branch2;
  }

  private boolean willPartitionWorkBottomUp(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    if (sum % 2 == 1) return false;
    sum = sum / 2;
    boolean dp[][] = new boolean[nums.length][sum + 1];
    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = true;
    }
    for (int i = 1; i <= sum; i++) {
      dp[0][i] = nums[0] == i ? true : false;
    }
    for (int i = 1; i < nums.length; i++) {
      for (int j = 1; j <= sum; j++) {
        if (dp[i - 1][j]) {
          dp[i][j] = true;
        } else if (nums[i] < j) {
          dp[i][j] = dp[i - 1][j - nums[i]];
        }
      }
    }

    return dp[nums.length - 1][sum];
  }

  // recursive call
}
