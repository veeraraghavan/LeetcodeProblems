/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/18/21, 11:05 PM
 * =========================================
 */

package com.practice.amzn;

public class LongestSubstring {
  public static void main(String[] args) {
    LongestSubstring me = new LongestSubstring();
  }

  public int lengthOfLongestSubstring(String s) {
    int ws = 0, max = 0, length = s.length();
    int[] freq = new int[128];
    for (int we = 0; we < length; we++) {
      char c = s.charAt(we);
      freq[c]++;
      while (freq[c] > 1) {
        char start = s.charAt(ws);
        freq[start]--;
        ws++;
      }
      max = Math.max(max, we - ws + 1);
    }
    return max;
  }
}
