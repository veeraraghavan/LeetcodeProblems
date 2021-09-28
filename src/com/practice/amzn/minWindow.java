/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/18/21, 11:31 PM
 * =========================================
 */

package com.practice.amzn;

import java.util.HashMap;

public class minWindow {
  public static void main(String[] args) {
    minWindow me = new minWindow();
  }

  public String minWindow(String s, String t) {
    int ws = 0, subStart = 0, min = Integer.MAX_VALUE, matched = 0;
    int length = s.length();
    HashMap<Character, Integer> charMap = new HashMap<>();
    for (char c : t.toCharArray()) {
      charMap.put(c, charMap.getOrDefault(c, 0) + 1);
    }
    if (s.length() < t.length()) {
      return "";
    }
    for (int we = 0; we < length; we++) {
      char c = s.charAt(we);
      if (charMap.containsKey(c)) {
        charMap.put(c, charMap.getOrDefault(c, 0) - 1);
        if (charMap.get(c) >= 0) matched++;
      }
      while (t.length() == matched) {
        if (min > we - ws + 1) {
          min = we - ws + 1;
          subStart = ws;
        }
        if (charMap.containsKey(s.charAt(ws))) {
          if (charMap.get(s.charAt(ws)) == 0) matched--;
          charMap.put(s.charAt(ws), charMap.get(s.charAt(ws)) + 1);
        }
        ws++;
      }
    }
    return min > s.length() ? "" : s.substring(subStart, subStart + min);
  }
}
