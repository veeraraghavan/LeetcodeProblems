/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/19/21, 5:46 PM
 * =========================================
 */

package com.practice.serious;

public class climbStairs {

  public static void main(String[] args) {
    climbStairs me = new climbStairs();
  }

  public int climbStairs(int n) {
    if (n == 1 || n == 2) return n;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}
