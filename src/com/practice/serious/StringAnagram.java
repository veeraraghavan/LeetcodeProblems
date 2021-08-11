/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 12:32 AM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class StringAnagram {
  public static void main(String[] args) {
    StringAnagram me = new StringAnagram();
    me.findAnagrams("cbaebabacd", "abc");
  }

  private List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int[] pMap = new int[26];
    for (char c : p.toCharArray()) {
      pMap[c - 'a']++;
    }
    int pLength = p.length();
    int sLength = s.length();
    for (int i = 0, j = 0; j < sLength; j++) {
      pMap[s.charAt(j) - 'a']--;
      if (j - i + 1 == pLength) {
        if (isPresent(pMap)) {
          result.add(i);
        }
        pMap[s.charAt(i) - 'a']++;
        i++;
      }
    }
    return result;
  }

  private boolean isPresent(int[] arr) {
    for (int i : arr) {
      if (i != 0) return false;
    }
    return true;
  }
}
