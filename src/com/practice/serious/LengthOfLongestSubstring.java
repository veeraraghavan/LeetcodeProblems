/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/24/21, 6:03 PM
 * =========================================
 */

package com.practice.serious;

public class LengthOfLongestSubstring {

  public static void main(String[] args) {
    LengthOfLongestSubstring me = new LengthOfLongestSubstring();
  }

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int maxLength = 0;
    int counter = 0;
    int windowStart = 0;
    int[] count = new int[256];
    char[] cs = s.toCharArray();
    for (int windowEnd = 0; windowEnd < cs.length; windowEnd++) {
      count[cs[windowEnd]]++;
      if (count[cs[windowEnd]] == 1) counter++;
      while (counter > 2) {
        count[cs[windowStart]]--;
        if (count[cs[windowStart]] == 0) counter--;
        windowStart++;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }
}
