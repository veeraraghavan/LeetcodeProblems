/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 12:03 AM
 * =========================================
 */

package com.practice.serious;

public class PermutationInString {
  public static void main(String[] args) {
    PermutationInString me = new PermutationInString();
    System.out.println(me.checkInclusion("adc", "dcda"));
  }

  private boolean checkInclusion(String s1, String s2) {
    int length = s1.length();
    if (length > s2.length()) return false;
    for (int i = 0; i <= s2.length() - length; i++) {
      if (isEqual(s1, s2.substring(i, i + length)) == true) return true;
    }
    return false;
  }

  private boolean checkInclusionFaster(String s1, String s2) {
    int length = s1.length();
    if (length > s2.length()) return false;
    int[] s1Map = new int[26];
    for (char c : s1.toCharArray()) {
      s1Map[c - 'a']++;
    }
    int lengthS2 = s2.length();
    for (int i = 0, j = 0; j < s2.length(); j++) {
      s1Map[s2.charAt(j) - 'a']--;
      if (j - i + 1 == length) {
        if (isComplete(s1Map)) return true;
        s1Map[s2.charAt(i++) - 'a']++;
      }
    }

    return false;
  }

  private boolean isComplete(int[] arr) {
    for (int i : arr) {
      if (i != 0) return false;
    }
    return true;
  }

  private boolean isEqual(String s1, String s2) {
    int[] s1Freq = new int[26];
    int[] s2Freq = new int[26];
    for (char c : s1.toCharArray()) {
      s1Freq[c - 'a']++;
    }
    for (char c : s2.toCharArray()) {
      s2Freq[c - 'a']++;
    }
    for (int i = 0; i < s1.length(); i++) {
      if (s1Freq[s1.charAt(i) - 'a'] != s2Freq[s1.charAt(i) - 'a']) return false;
    }
    return true;
  }
}
