/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 3:40 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubStrConcatenation {
  public static void main(String[] args) {
    SubStrConcatenation me = new SubStrConcatenation();
    me.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"});
  }

  private List<Integer> findSubstring(String s, String[] words) {
    int length = words.length;
    List<Integer> res = new ArrayList<>();
    HashMap<String, Integer> wordMap = new HashMap<>();
    for (String word : words) {
      wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
    }
    int wordLength = words[0].length();

    // We check for next "N" character at a time. "N" = sum of all letters in
    // the dictionary.
    for (int ws = 0; ws < s.length() - (length * wordLength); ws++) {
      HashMap<String, Integer> seenWords = new HashMap<>();
      for (int i = 0; i < length; i++) {
        int wordIndex = ws + (i * wordLength);
        String nextWord = s.substring(wordIndex, wordIndex + wordLength);
        if (!wordMap.containsKey(nextWord)) {
          break;
        }
        seenWords.put(nextWord, seenWords.getOrDefault(nextWord, 0) + 1);
        if ((seenWords.get(nextWord) > wordMap.get(nextWord))) break;
        if (i + 1 == length) {
          res.add(ws);
        }
      }
    }
    return res;
  }
}
