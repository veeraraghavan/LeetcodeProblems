/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/17/21, 12:05 AM
 * =========================================
 */

package com.practice.serious;

public class MinimunDeletionInsertion {
  public static void main(String[] args) {
    MinimunDeletionInsertion me = new MinimunDeletionInsertion();
    me.getMinimumDeletionInsertion("passport", "ppsspt");
  }

  private void getMinimumDeletionInsertion(String s1, String s2) {
    int length1 = s1.length();
    int length2 = s2.length();
    int lcs = getLCSBottomUp(s1, s2);
    System.out.println(length1 - lcs + " deletions and " + (length2 - lcs) + " insetion");
    // return (length1 - lcs) + length2 - lcs;
  }

  private int getLCSBottomUp(String s1, String s2) {
    char[] s1Array = s1.toCharArray();
    char[] s2Array = s2.toCharArray();
    int[][] res = new int[2][s1.length() + 1];
    for (int i = 1; i <= s2.length(); i++) {
      for (int j = 1; j <= s1.length(); j++) {
        int temp = 0;
        if (s1Array[j - 1] == s2Array[i - 1]) {
          temp = 1 + res[(i - 1) % 2][j - 1];
        } else {
          temp = Math.max(res[(i - 1) % 2][j], res[i % 2][j - 1]);
        }
        res[i % 2][j] = temp;
      }
    }
    return res[s2.length() % 2][s1.length()];
  }
}
