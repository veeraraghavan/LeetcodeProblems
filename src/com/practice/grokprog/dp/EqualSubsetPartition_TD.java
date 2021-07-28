package com.practice.grokprog.dp;

public class EqualSubsetPartition_TD {
  public static void main(String[] args) {
    EqualSubsetPartition_TD me = new EqualSubsetPartition_TD();
    int[] nums = new int[] {1, 2, 3, 4};
    System.out.println(me.subsetPartition(nums));
  }

  private boolean subsetPartition(int[] nums) {

    int totalSum = 0;
    for (int i : nums) {
      totalSum += i;
    }
    if (totalSum % 2 != 0) {
      return false;
    }
    Boolean[][] dp = new Boolean[nums.length][totalSum / 2 + 1];
    return canPartition(totalSum / 2, nums, 0, dp);
  }

  private Boolean canPartition(int sum, int[] num, int index, Boolean[][] dp) {
    if (sum == 0) return true;
    if (num.length == 0 || index >= num.length) return false;
    if (dp[index][sum] == null) {
      if (num[index] <= sum) {
        if (canPartition(sum - num[index], num, index + 1, dp)) {
          dp[index][sum] = true;
          return dp[index][sum];
        }
      }
      dp[index][sum] = canPartition(sum, num, index + 1, dp);
    }

    return dp[index][sum];
  }
}
