/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   3/10/22, 1:54 PM
 * =========================================
 */

package com.practice.debugging;

public class StringDiff {
  public static void main(String[] args) {
    StringDiff me = new StringDiff();
  }

  private int getDiff(String s1, String s2) {
    int length = s1.length();
    for (int i = 0; i < length; i++) {
      if (s1.charAt(i) != s2.charAt(i)) return i;
    }
    return -1;
  }
}
