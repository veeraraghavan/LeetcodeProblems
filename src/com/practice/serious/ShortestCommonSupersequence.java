/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/21/21, 10:32 PM
 * =========================================
 */

package com.practice.serious;

public class ShortestCommonSupersequence {
  public static void main(String[] args) {
    ShortestCommonSupersequence me = new ShortestCommonSupersequence();
    System.out.println(me.shortestCommonSupersequence("abcd", "efgh"));
  }

  public void calculateSCS(int[][] result, String s1, String s2) {}

  private String shortestCommonSupersequence(String str1, String str2) {
    int[][] result = new int[str1.length() + 1][str2.length() + 1];
    for (int i = 1; i <= str1.length(); i++) {
      result[i][0] = i;
    }
    for (int i = 1; i <= str2.length(); i++) {
      result[0][i] = i;
    }
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();
    for (int i = 1; i <= str1.length(); i++) {
      for (int j = 1; j <= str2.length(); j++) {
        if (s1[i - 1] == s2[j - 1]) {
          result[i][j] = 1 + result[i - 1][j - 1];
        } else {
          result[i][j] = 1 + Math.min(result[i][j - 1], result[i - 1][j]);
        }
      }
    }
    return getString(result, s1, s2);
  }

  private String getString(int[][] result, char[] s1, char[] s2) {
    StringBuilder res = new StringBuilder("");
    boolean incomplete = true;
    int row = result.length - 1;
    int col = result[0].length - 1;
    while (incomplete) {
      if (s1[row - 1] == s2[col - 1]) {
        res.append(s1[row - 1]);

        row--;
        col--;
      } else {
        boolean previousRow = result[row - 1][col] <= result[row][col - 1];
        if (previousRow) {
          res.append(s1[row - 1]);

          row--;
        } else {
          res.append(s2[col - 1]);
          col--;
        }
      }
      if (row < 1) {
        while (col > 0) {
          res.append(s2[col - 1]);
          col--;
        }
      }
      if (col < 1) {
        while (row > 0) {
          res.append(s1[row - 1]);
          row--;
        }
      }
      if (row < 1 && col < 1) {
        incomplete = false;
      }
    }
    return res.reverse().toString();
  }
}
