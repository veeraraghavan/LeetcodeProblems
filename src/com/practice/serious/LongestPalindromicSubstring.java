/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/24/21, 11:06 AM
 * =========================================
 */

package com.practice.serious;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    LongestPalindromicSubstring me = new LongestPalindromicSubstring();
    System.out.println(me.longestPalindrome("babad"));
  }

  private String longestPalindrome(String s) {
    if (s == null || "".equals(s)) {
      return s;
    }
    int maxLength = 0;
    String encoded = transform(s);
    int center = 0, border = 0;
    int result = 0;
    int[] length = new int[encoded.length()];
    /* if i is outside inside the right border , to start with copy the index of the mirror
     */
    for (int i = 0; i < encoded.length(); i++) {
      int mirror = 2 * center - i;
      if (i < border) {
        length[i] = Math.min(border - i, length[mirror]);
      }
      int right = i + length[i] + 1, left = i - (length[i] + 1);
      while (right < encoded.length()
          && left >= 0
          && encoded.charAt(left) == encoded.charAt(right)) {
        length[i]++;
        left--;
        right++;
      }
      if (length[i] + i > border) {
        border = length[i] + i;
        center = i;
        if (maxLength <= length[i]) {
          maxLength = length[i];
          result = center;
        }
      }
    }

    return encoded.substring(result - maxLength, result + maxLength + 1).replaceAll("#", "");
  }

  private String transform(String s) {
    String result = "#";
    for (char c : s.toCharArray()) {
      result += c + "#";
    }
    return result;
  }
}
