/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/2/22, 11:59 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.Arrays;

public class numSquares {
  public static void main(String[] args) {
    numSquares me = new numSquares();
  }

  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    int max_index = (int) Math.sqrt(n) + 1;
    int[] sq = new int[max_index];
    for (int i = 1; i < max_index; i++) {
      sq[i] = i * i;
    }
    for (int i = 1; i <= n; i++) {
      for (int s = 1; s < max_index; s++) {
        if (i < sq[s]) break;
        dp[i] = Math.min(dp[i], dp[i - sq[s]] + 1);
      }
    }
    return dp[n];
  }
}
