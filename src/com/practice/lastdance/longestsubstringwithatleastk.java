/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/5/22, 3:19 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.Arrays;

public class longestsubstringwithatleastk {
  public static void main(String[] args) {
    longestsubstringwithatleastk me = new longestsubstringwithatleastk();
  }

  public int longestSubstring(String s, int k) {
    int totalUnique = getUniqueCharacters(s);
    int result = 0;
    int countMap[] = new int[26];
    for (int currentUnique = 1; currentUnique <= totalUnique; currentUnique++) {
      int windowStart = 0, windowEnd = 0;
      Arrays.fill(countMap, 0);
      int unique = 0, countK = 0, idx = 0;
      while (windowEnd < s.length()) {
        if (unique <= currentUnique) {
          idx = s.charAt(windowEnd) - 'a';
          if (countMap[idx] == 0) unique++;
          countMap[idx]++;
          if (countMap[idx] == k) countK++;
          windowEnd++;
        } else {
          idx = s.charAt(windowStart) - 'a';
          if (countMap[windowStart] == k) countK--;
          countMap[windowStart]--;
          if (countMap[idx] == 0) unique--;
          windowStart++;
        }
        if (unique == currentUnique && unique == countK) {
          result = Math.max(result, windowEnd - windowStart);
        }
      }
    }
    return result;
  }

  public int getUniqueCharacters(String s) {
    int[] countMap = new int[26];
    int count = 0;
    for (char c : s.toCharArray()) {
      if (countMap[c - 'a'] == 0) count++;
      countMap[c - 'a']++;
    }
    return count;
  }
}
