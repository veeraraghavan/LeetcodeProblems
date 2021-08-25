/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/24/21, 11:26 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {

  public static void main(String[] args) {
    WordBreakII me = new WordBreakII();
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    HashSet<String> dict = new HashSet<>(wordDict);
    return recurse(s, 0, dict);
  }

  private List<String> recurse(String s, int start, HashSet<String> wordDict) {

    // base condition
    if (start == s.length()) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    for (int end = start + 1; end <= s.length(); end++) {
      String word = s.substring(start, end);
      if (wordDict.contains(word)) {
        if (end == s.length()) {
          result.add(word);
        } else {
          // should you send rest of string of with start index
          for (String w : recurse(s, end, wordDict)) {
            result.add(word + " " + w);
          }
        }
      }
    }
    return result;
  }
}
