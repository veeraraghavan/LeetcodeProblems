/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/10/21, 11:18 PM
 * =========================================
 */

package com.practice.serious;

public class LongestRepeatReplace {
  public static void main(String[] args) {
    LongestRepeatReplace me = new LongestRepeatReplace();
    System.out.println(me.characterReplacement("AABABBA", 1));
  }

  private int characterReplacement(String s, int k) {
    int ws = 0;
    int max = 0;
    int maxRepCharCount = 0;
    int[] charFreq = new int[128];
    for (int we = 0; we < s.length(); we++) {
      int end = s.charAt(we);
      charFreq[end]++;
      maxRepCharCount = Math.max(maxRepCharCount, charFreq[end]);
      while ((we - ws + 1) - maxRepCharCount > k) {
        char start = s.charAt(ws);
        charFreq[start]--;
        ws++;
      }
      max = Math.max(max, we - ws + 1);
    }
    return max;
  }
}
