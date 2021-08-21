/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/19/21, 11:59 PM
 * =========================================
 */

package com.practice.serious;

public class LongestRepeatingSubstring {

  public static void main(String[] args) {
    LongestRepeatingSubstring me = new LongestRepeatingSubstring();
  }
  // TODO : Not understood the problem
  public int longestRepeatingSubstring(String S) {
    int max = 0;
    // n^ 2 solution
    for (int i = 0; i < S.length(); i++) {
      char prev = S.charAt(i - 1);
      int count = 1;
      while (S.charAt(i) == prev && i < S.length()) {
        count++;
        i++;
      }
      max = Math.max(max, count);
    }
    return max == 1 ? 0 : max;
  }
}
