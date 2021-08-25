/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/24/21, 11:56 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {

  public static void main(String[] args) {
    ConcatenatedWords me = new ConcatenatedWords();
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    HashSet<String> prefix = new HashSet<>();
    List<String> result = new ArrayList<>();
    int i = 0;
    for (String word : words) {
      Boolean[] memo = new Boolean[words[i++].length()];
      if (recurse(word, prefix, 0, memo) && !word.equals("")) {
        result.add(word);
      }
      prefix.add(word);
    }
    return result;
  }

  private boolean recurse(String input, HashSet<String> prefix, int start, Boolean[] memo) {
    if (prefix.isEmpty()) return false;
    if (start == input.length()) {
      return true;
    }
    if (memo[start] != null) {
      return memo[start];
    }
    for (int end = start + 1; end <= input.length(); end++) {
      String word = input.substring(start, end);
      if (prefix.contains(word) && recurse(input, prefix, end, memo)) {
        memo[start] = true;
        return true;
      }
    }
    memo[start] = false;
    return false;
  }
}
