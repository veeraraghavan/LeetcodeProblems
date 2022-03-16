/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/19/22, 10:03 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.*;

public class WordLadder {
  public static void main(String[] args) {
    WordLadder me = new WordLadder();
    me.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashMap<String, HashSet<String>> transformations = new HashMap<>();
    HashSet<String> visited = new HashSet();
    Queue<String> queue = new LinkedList<>();

    for (String word : wordList) {
      String curWord = "";
      for (int i = 0; i < word.length(); i++) {
        if (i == 0) {
          curWord = "*" + word.substring(i + 1);
        } else {
          curWord =
              word.substring(0, i) + "*" + (i == word.length() - 1 ? "" : word.substring(i + 1));
        }
        HashSet<String> words = transformations.getOrDefault(curWord, new HashSet<String>());
        words.add(word);
        transformations.put(curWord, words);
      }
    }
    int count = 0;
    queue.offer(beginWord);
    visited.add(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int index = 0;
      count++;
      while (index < size) {

        String nextWord = queue.poll();
        String curWord = "";
        for (int i = 0; i < nextWord.length(); i++) {
          if (i == 0) {
            curWord = "*" + nextWord.substring(i + 1);
          } else {
            curWord =
                nextWord.substring(0, i)
                    + "*"
                    + (i == nextWord.length() - 1 ? "" : nextWord.substring(i + 1));
          }
          HashSet<String> nextSet = transformations.getOrDefault(curWord, new HashSet<>());
          for (String next : nextSet) {
            if (next.equals(endWord)) return count;
            if (!visited.contains(next)) {
              visited.add(next);
              queue.offer(next);
            }
          }
        }
        index++;
      }
    }
    return 0;
  }
}
