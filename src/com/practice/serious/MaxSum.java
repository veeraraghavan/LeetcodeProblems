/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/1/21, 9:53 AM
 * =========================================
 */

package com.practice.serious;

public class MaxSum {
  public static void main(String[] args) {
    MaxSum me = new MaxSum();
    System.out.println(me.maxSumDivThreeDP(new int[] {4, 1, 5, 3, 1}));
  }

  private int maxSumDivThree(int[] nums) {
    // int[][] dp = new int[nums.length][]
    return getMax(nums, 0, 0);
  }

  private int getMax(int[] nums, int index, int sum) {
    if (index == nums.length) {
      if (sum % 3 == 0) return sum;
      return 0;
    }

    int sum1 = getMax(nums, index + 1, sum + nums[index]);
    int sum2 = getMax(nums, index + 1, sum);
    return Math.max(sum1, sum2);
  }

  private int getMaxDP(int[] nums, int index, int sum) {
    if (index == nums.length) {
      if (sum % 3 == 0) return sum;
      return 0;
    }

    int sum1 = getMax(nums, index + 1, sum + nums[index]);
    int sum2 = getMax(nums, index + 1, sum);
    return Math.max(sum1, sum2);
  }

  private int maxSumDivThreeDP(int[] nums) {
    /*    Bottom up DP. Let us say you are try to calculate sum .
          You start with 0 and each index element . When you add element
          There are 3 possible states.
          (sum+nums[i])%3 = 0/1/2 ( there are 3 possible remainders ) we store each as a state

          Eg: nums = {4,1,5,3,1}. 2-D array will look like this
          *************************************************
                      *     0     *     1     *     2     *
          *************************************************
            0         *     0     *   -INF    *   -INF    *
          *************************************************
            4         *     0     *     4     *   -INF    *
          *************************************************
            5         *     9     *     4     *    5      *
          *************************************************
            1         *     9     *     10    *    5      *
          *************************************************
            3         *     12    *     13    *    8      *
          *************************************************
            1         *     12    *     13    *    14     *
          *************************************************
          dp[i][j] =  means the maximum sum possible including all elements upto index i with remainder j
          dp[3][0] = 9 ( index of DP starts from 0 ). Means the maximum sum possible with (4,5,1) with remainder 0

    */
    int[][] dp = new int[nums.length + 1][3];
    dp[0][0] = 0;
    dp[0][1] = Integer.MIN_VALUE;
    dp[0][2] = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int remainder = nums[i] % 3;
      // remainder of current number.
      /*     Suppose remainder of current number is r . In order to calculate the sum at current index
       with remainder k , we need sum at previous index with reminder k-r.
       Hence the formula
       dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-remainder]+num[i]);
      */
      for (int j = 0; j < 3; j++) {
        dp[i + 1][j] = Math.max(dp[i][j], dp[i][(j + 3 - remainder) % 3] + nums[i]);
      }
    }
    return dp[nums.length][0];
  }
}
