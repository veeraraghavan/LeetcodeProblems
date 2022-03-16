/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/12/22, 5:00 PM
 * =========================================
 */

package com.practice.lastdance;

public class stringmatch {
  public static void main(String[] args) {
    stringmatch me = new stringmatch();
    System.out.println(me.isMatch("abcd", "abc*"));
  }

  public boolean isMatch(String s, String p) {
    boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 1; i <= p.length(); i++) {
      if (p.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 2];
      }
    }
    //    for (int i = 1; i <= p.length(); i++) {
    //      dp[i][0] = false;
    //    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (p.charAt(j) == '*') {
          dp[i + 1][j + 1] = dp[i + 1][j - 1];
          if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
            dp[i + 1][j + 1] = dp[i + 1][j + 1] | dp[i][j + 1];
          }
        } else {
          dp[i + 1][j + 1] = false;
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }
}
