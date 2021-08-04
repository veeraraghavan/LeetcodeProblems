/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/3/21, 11:08 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequent {
  public static void main(String[] args) {
    TopKFrequent me = new TopKFrequent();
    me.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2);
  }

  private List<String> topKFrequent(String[] words, int k) {
    List<String> result = new ArrayList<>();
    HashMap<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      int count = wordCount.getOrDefault(word, 0);
      wordCount.put(word, count + 1);
    }
    PriorityQueue<String> frequentList =
        new PriorityQueue<String>(
            (a, b) -> {
              int countA = wordCount.get(a);
              int countB = wordCount.get(b);
              if (countA == countB) {
                return a.compareTo(b);
              } else {
                return countB - countA;
              }
            });

    for (String word : wordCount.keySet()) {
      frequentList.add(word);
    }
    while (k > 0) {
      result.add(frequentList.poll());
      k--;
    }
    return result;
  }
}
