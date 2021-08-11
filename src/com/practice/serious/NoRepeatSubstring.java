/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/10/21, 10:48 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class NoRepeatSubstring {
  public static void main(String[] args) {
    NoRepeatSubstring me = new NoRepeatSubstring();
  }

  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> frequencyMap = new HashMap<>();
    int ws = 0;
    int max = 0;
    for (int we = 0; we < s.length(); we++) {
      frequencyMap.put(s.charAt(we), frequencyMap.getOrDefault(s.charAt(we), 0) + 1);
      while (frequencyMap.get(s.charAt(we)) > 1) {
        frequencyMap.put(s.charAt(ws), frequencyMap.get(s.charAt(ws)) - 1);
        ws++;
      }
      max = Math.max(max, we - ws + 1);
    }
    return max;
  }

  public int lengthOfLongestSubstringArray(String s) {
    int[] freqCount = new int[26];
    int ws = 0;
    int max = 0;
    for (int we = 0; we < s.length(); we++) {
      // frequencyMap.put(s.charAt(we),frequencyMap.getOrDefault(s.charAt(we),0)+1);
      char c = s.charAt(we);
      freqCount[c - 'a']++;
      while (freqCount[c - 'a'] > 1) {
        char start = s.charAt(ws);
        freqCount[start - 'a']--;
        ws++;
      }
      max = Math.max(max, we - ws + 1);
    }
    return max;
  }
}
