/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/10/21, 9:03 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class LongestSubstring {
  public static void main(String[] args) {
    LongestSubstring me = new LongestSubstring();
    System.out.println(me.lengthOfLongestSubstringKDistinct("eceba", 2));
  }

  private int lengthOfLongestSubstringKDistinct(String s, int k) {
    // int count[] = new int[26];
    int windowStart = 0;
    int res = Integer.MIN_VALUE;
    HashMap<Character, Integer> map = new HashMap<>();
    int windowEnd = 0;
    for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
      char endChar = s.charAt(windowEnd);
      map.put(s.charAt(windowEnd), map.getOrDefault(s.charAt(windowEnd), 0) + 1);
      while (map.size() > k) {
        char leftChar = s.charAt(windowStart);
        map.put(leftChar, map.get(leftChar) - 1);
        if (map.get(leftChar) == 0) {
          map.remove(leftChar);
        }
        windowStart++;
      }
      res = Math.max(windowEnd - windowStart + 1, res);
    }
    return res;
  }
}
