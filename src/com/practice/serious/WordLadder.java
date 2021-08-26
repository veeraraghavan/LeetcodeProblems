/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/25/21, 5:25 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {

  public static void main(String[] args) {
    WordLadder me = new WordLadder();

    System.out.println(
        me.ladderLength(
            "hit", "cog", Arrays.asList(new String[] {"hot", "dot", "dog", "lot", "log", "cog"})));
  }

  private Map<String, List<String>> wordMap = new HashMap<>();

  private void createWordMap(List<String> wordList) {
    for (String word : wordList) {
      for (int i = 0; i < word.length(); i++) {
        String key = word.substring(0, i) + "*" + word.substring(i + 1);
        List<String> words = wordMap.getOrDefault(key, new ArrayList<>());
        words.add(word);
        wordMap.put(key, words);
      }
    }
  }

  private int ladderLength(String beginWord, String endWord, List<String> wordList) {
    createWordMap(wordList);
    int minLength = Integer.MAX_VALUE;
    Queue<Pair> nextWord = new LinkedList<>();
    HashMap<String, Integer> transformation = new HashMap<>();
    nextWord.add(new Pair(beginWord, 1));
    HashMap<String, Boolean> visited = new HashMap<>();
    while (!nextWord.isEmpty()) {
      Pair nextNode = nextWord.poll();
      String next = nextNode.word;
      int level = nextNode.count;
      //      if (next == endWord) {
      //        minLength = Math.min(minLength, transformation.get(next));
      //        break;
      //      }
      for (int i = 0; i < next.length(); i++) {
        String key = next.substring(0, i) + "*" + next.substring(i + 1);
        List<String> matchWords = wordMap.getOrDefault(key, new ArrayList<>());
        for (String matchWord : matchWords) {
          if (matchWord.equals(endWord)) return level + 1;
          if (!visited.containsKey(matchWord)) {
            visited.put(matchWord, true);
            nextWord.offer(new Pair(matchWord, level + 1));
          }
        }
      }
    }
    return 0;
  }
}

class Pair {
  public String word;
  public int count;

  Pair(String w, int c) {
    word = w;
    count = c;
  }
}
