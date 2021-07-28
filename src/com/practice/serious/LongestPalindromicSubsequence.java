/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/23/21, 8:51 PM
 * =========================================
 */

package com.practice.serious;

public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    LongestPalindromicSubsequence me = new LongestPalindromicSubsequence();
    System.out.println(me.longestSequence("bbbab"));
    System.out.println(me.longestPalindromeSubseq("bcbb"));
  }

  private int longestSequence(String word) {
    int dp[][] = new int[word.length()][word.length()];
    /*
     Understand the algorithm we fill the M of order m*m matrix . Significance of the matrix
     M[i,j] mean trying to identify the substring of i..j in the input string. Note we fill
     only in the increasing order i.e. i<=j . We don't consider the other case as strings are
     commutative and for all practical purposes it is marked 0.
     E.g. M[1,2] is possible.
          M[2,1] will always be 0.
          The result will lie at M[0,n] n=length of string.
          this is the full possible string lengths.
          We start with substrings of length 1, 2,3,....n
          All diagonals are initials with 1.
    */
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp.length; j++) {
        if (i == j) dp[i][j] = 1;
      }
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp.length - i; j++) {
        int k = i + j;
        if (i == 0) continue;
        if (word.charAt(j) == word.charAt(k)) {
          dp[j][k] = 2 + dp[j + 1][k - 1];
        } else {
          dp[j][k] = Math.max(dp[j + 1][k], dp[j][k - 1]);
        }
      }
    }

    return dp[0][dp.length - 1];
  }

  private int longestPalindromeSubseq(String s) {
    char[] sa = s.toCharArray();
    int[] dp = new int[sa.length];
    int max = 0;
    for (int i = 0; i < dp.length; i++) {
      dp[i] = 1;
      int maxSoFar = 0;
      for (int j = i - 1; j >= 0; j--) {
        int prev = dp[j];
        if (sa[i] == sa[j]) {
          dp[j] = maxSoFar + 2;
        }
        maxSoFar = Math.max(prev, maxSoFar);
      }
    }
    for (int i : dp) max = Math.max(max, i);
    return max;
  }
}
