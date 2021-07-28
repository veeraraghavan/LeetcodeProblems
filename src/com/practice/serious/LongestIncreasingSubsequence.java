/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/18/21, 11:43 PM
 * =========================================
 */

package com.practice.serious;

public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    LongestIncreasingSubsequence me = new LongestIncreasingSubsequence();
  }

  private int lis(int[] numbers) {
    // return lis_brute(numbers, 0, -1);
    return lis_dp(new int[] {10, 9, 2, 5, 3, 7, 101, 18});
  }

  private int lis_brute(int[] numbers, int index, int previousIndex) {
    if (index == numbers.length) return 0;
    int c1 = 0, c2 = 0;
    if (previousIndex == -1 || numbers[index] > numbers[previousIndex]) {
      c1 = 1 + lis_brute(numbers, index + 1, index);
    }
    c2 = lis_brute(numbers, index + 1, previousIndex);
    return Math.max(c1, c2);
  }

  private int lis_dp(int[] numbers) {
    int[] dp = new int[numbers.length];
    dp[0] = 1;
    int maxLength = 0;
    for (int i = 1; i < numbers.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {

        if (numbers[i] > numbers[j] && dp[i] <= dp[j]) {
          dp[i] = dp[j] + 1;
          maxLength = Math.max(maxLength, dp[i]);
        }
      }
    }
    return maxLength;
  }
}
