/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/15/21, 12:00 AM
 * =========================================
 */

package com.practice.serious;

import java.util.Map;

public class LongestCommonSubstring {
  private Map<String, Integer> lookup;
  private int totalCount = 0, memCount = 0;

  public static void main(String[] args) {
    LongestCommonSubstring me = new LongestCommonSubstring();
    //    me.lookup = new HashMap<>();
    //    // System.out.println(me.longestSubstringDP("abdca", "cbda"));
    //    System.out.println(me.findLCSLength("abdca", "cbda"));
    //    System.out.println("The total count is " + me.totalCount + " and memCount is " +
    // me.memCount);
    //    me.totalCount = me.memCount = 0;
    //    me.lookup = new HashMap<>();
    //    // System.out.println(me.longestSubstringDP("passport", "ppsspt"));
    //    System.out.println(me.findLCSLength("passport", "ppsspt"));
    //    System.out.println("The total count is " + me.totalCount + " and memCount is " +
    // me.memCount);
    System.out.println(me.findLCSBottomUp("passport", "ppsspt"));
  }

  // ******************************************Brute Force****************************************
  private int longestSubstring(String s1, String s2) {
    return longestSubstringRecursive(s1, s2, 0, 0, 0);
  }

  private int longestSubstringRecursive(String s1, String s2, int i1, int i2, int count) {

    if (i1 == s1.length() || i2 == s2.length()) {
      return count;
    }

    if (s1.charAt(i1) == s2.charAt(i2)) {
      count = longestSubstringRecursive(s1, s2, i1 + 1, i2 + 1, count + 1);
    }
    int c1 = longestSubstringRecursive(s1, s2, i1, i2 + 1, 0),
        c2 = longestSubstringRecursive(s1, s2, i1 + 1, i2, 0);
    return Math.max(count, Math.max(c1, c2));
  }
  // ******************************************Brute Force****************************************
  // Now cache the sub problems

  private int longestSubstringDP(String s1, String s2) {
    return longestSubstringRecursiveDP(s1, s2, 0, 0, 0);
  }

  private int longestSubstringRecursiveDP(String s1, String s2, int i1, int i2, int count) {
    totalCount++;

    if (i1 == s1.length() || i2 == s2.length()) {
      return count;
    }

    if (!lookup.containsKey("" + i1 + i2 + count)) {
      memCount++;
      int c1 = count;
      if (s1.charAt(i1) == s2.charAt(i2)) {
        c1 = longestSubstringRecursiveDP(s1, s2, i1 + 1, i2 + 1, count + 1);
      }
      int c2 = longestSubstringRecursiveDP(s1, s2, i1, i2 + 1, 0),
          c3 = longestSubstringRecursiveDP(s1, s2, i1 + 1, i2, 0);
      lookup.put("" + i1 + i2 + count, Math.max(c1, Math.max(c2, c3)));
    }
    return lookup.get("" + i1 + i2 + count);
  }

  private int findLCSLength(String s1, String s2) {
    int maxLength = Math.min(s1.length(), s2.length());
    Integer[][][] dp = new Integer[s1.length()][s2.length()][maxLength];
    return findLCSLengthRecursive(dp, s1, s2, 0, 0, 0);
  }

  private int findLCSLengthRecursive(
      Integer[][][] dp, String s1, String s2, int i1, int i2, int count) {
    totalCount++;
    if (i1 == s1.length() || i2 == s2.length()) return count;

    if (dp[i1][i2][count] == null) {
      memCount++;
      int c1 = count;
      if (s1.charAt(i1) == s2.charAt(i2))
        c1 = findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2 + 1, count + 1);
      int c2 = findLCSLengthRecursive(dp, s1, s2, i1, i2 + 1, 0);
      int c3 = findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2, 0);
      dp[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
    }

    return dp[i1][i2][count];
  }

  private int findLCSBottomUp(String s1, String s2) {
    int maxLength = 0;
    int[][] result = new int[2][s2.length() + 1];
    //    for (int i = 0; i <= s1.length(); i++) {
    //      result[i][0] = 0;
    //    }
    //    for (int j = 0; j <= s2.length(); j++) {
    //      result[0][j] = 0;
    //    }

    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        result[i % 2][j] = 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          result[i % 2][j] = 1 + result[i - 1 % 2][j - 1];
          maxLength = Math.max(maxLength, result[i % 2][j]);
        }
      }
    }
    return maxLength;
  }
}
