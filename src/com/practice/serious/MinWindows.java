/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 9:37 AM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class MinWindows {
  public static void main(String[] args) {
    MinWindows me = new MinWindows();
    System.out.println(me.minWindow("A", "B"));
  }

  private String minWindow(String s, String t) {
    HashMap<Character, Integer> patternMap = new HashMap<>();
    for (char c : t.toCharArray()) {
      patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
    }
    if (t.length() > s.length()) return "";
    int ws = 0;
    int minLength = Integer.MAX_VALUE;
    int subStart = 0;
    int matched = 0;
    for (int we = 0; we < s.length(); we++) {
      if (patternMap.containsKey(s.charAt(we))) {
        patternMap.put(s.charAt(we), patternMap.getOrDefault(s.charAt(we), 0) - 1);
        if (patternMap.get(s.charAt(we)) >= 0) matched++;
      }
      while (matched == t.length()) {
        if (minLength > we - ws + 1) {
          minLength = we - ws + 1;
          subStart = ws;
        }

        if (patternMap.containsKey(s.charAt(ws))) {
          if (patternMap.get(s.charAt(ws)) == 0) matched--;
          patternMap.put(s.charAt(ws), patternMap.get(s.charAt(ws)) + 1);
        }
        ws++;
      }
    }
    return minLength > s.length() ? "" : s.substring(subStart, subStart + minLength);
  }
}
