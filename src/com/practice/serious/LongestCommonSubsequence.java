/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/16/21, 1:33 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class LongestCommonSubsequence {
  private HashMap<String, Integer> lookup = new HashMap();

  public static void main(String[] args) {
    LongestCommonSubsequence me = new LongestCommonSubsequence();
    System.out.println(me.LCS("passport", "ppsspt"));
  }

  private int LCS(String s1, String s2) {
    // return LCSRecurse(s1, s2, 0, 0);
    return LCSRecurseBottomUp(s1, s2);
  }

  private int LCSRecurse(String s1, String s2, int i1, int i2) {
    if (i1 == s1.length() || i2 == s2.length()) return 0;
    if (!lookup.containsKey(i1 + "|" + i2)) {
      if (s1.charAt(i1) == s2.charAt(i2)) {
        lookup.put(i1 + "|" + i2, 1 + LCSRecurse(s1, s2, i1 + 1, i2 + 1));
      } else {
        int c2 = LCSRecurse(s1, s2, i1, i2 + 1);
        int c1 = LCSRecurse(s1, s2, i1 + 1, i2);
        lookup.put(i1 + "|" + i2, Math.max(c1, c2));
      }
    }
    return lookup.get(i1 + "|" + i2);
  }

  private int LCSRecurseBottomUp(String text1, String text2) {
    //    if (i1 == s1.length() || i2 == s2.length()) return 0;
    //    if (!lookup.containsKey(i1 + "|" + i2)) {
    //      if (s1.charAt(i1) == s2.charAt(i2)) {
    //        lookup.put(i1 + "|" + i2, 1 + LCSRecurse(s1, s2, i1 + 1, i2 + 1));
    //      } else {
    //        int c2 = LCSRecurse(s1, s2, i1, i2 + 1);
    //        int c1 = LCSRecurse(s1, s2, i1 + 1, i2);
    //        lookup.put(i1 + "|" + i2, Math.max(c1, c2));
    //      }
    //    }

    //    return lookup.get(i1 + "|" + i2);
    int[][] res = new int[2][text1.length() + 1];
    for (int i = 1; i <= text2.length(); i++) {
      for (int j = 1; j <= text1.length(); j++) {
        int temp = 0;
        if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
          temp = 1 + res[(i - 1) % 2][j - 1];
        }
        res[i % 2][j] = Math.max(temp, Math.max(res[i % 2][j - 1], res[(i - 1) % 2][j]));
      }
    }
    return res[text2.length() % 2][text1.length()];
  }
}
