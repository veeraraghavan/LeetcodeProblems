/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/24/21, 9:35 PM
 * =========================================
 */

package com.practice.serious;

public class LongestValidParanthesis {
  public static void main(String[] args) {
    LongestValidParanthesis me = new LongestValidParanthesis();
  }

  public int longestValidParentheses(String s) {
    // dp solution
    int[] dp = new int[s.length()];
    int maxLength = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = 2 + (i - 2 > 0 ? dp[i - 2] : 0);
        } else {
          int prev = dp[i - 1];
          int prevIndex = i - dp[i - 1] - 1;
          if (prevIndex >= 0 && s.charAt(prevIndex) == '(') {
            dp[i] = 2 + (prevIndex - 1 > 0 ? dp[prevIndex - 1] : 0) + prev;
          }
        }
        maxLength = Math.max(maxLength, dp[i]);
      }
    }
    return maxLength;
  }
}
