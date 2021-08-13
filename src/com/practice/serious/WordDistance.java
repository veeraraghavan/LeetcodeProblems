/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/13/21, 4:33 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {
  public static void main(String[] args) {
    WordDistance me = new WordDistance(new String[] {});
  }

  private HashMap<String, List<Integer>> countMap = new HashMap();
  ;

  private WordDistance(String[] wordsDict) {
    int index = 0;
    for (String word : wordsDict) {
      List<Integer> count = countMap.getOrDefault(word, new ArrayList<>());
      count.add(index);
      countMap.put(word, count);
      index++;
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> count1 = countMap.get(word1);
    List<Integer> count2 = countMap.get(word2);

    int min = Integer.MAX_VALUE;
    int occurenceOfWord1 = count1.size(), index1 = 0;
    int occurenceOfWord2 = count2.size(), index2 = 0;
    while (index1 < occurenceOfWord1 && index2 < occurenceOfWord2) {
      min = Math.min(Math.abs(count1.get(index1) - count2.get(index2)), min);
      if (count1.get(index1) > count2.get(index2)) {
        index2++;
      } else {
        index1++;
      }
    }
    return min;
  }
}
