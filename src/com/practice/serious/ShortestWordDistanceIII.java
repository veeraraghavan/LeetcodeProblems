/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/13/21, 1:31 PM
 * =========================================
 */

package com.practice.serious;

public class ShortestWordDistanceIII {
  public static void main(String[] args) {
    ShortestWordDistanceIII me = new ShortestWordDistanceIII();
    System.out.println(me.shortestWordDistance(new String[] {"a", "a", "c", "b"}, "a", "b"));
  }
  // Logic we need to look for the words (word1, word2) in the wordDict.
  // When the first word is found keep the index .
  // When the second word is found check for the difference between current index
  // and the previous index. Only condition to check is to check is if word at previous index
  // and current index are not the same. ( To avoid cases when same word is twice in the list
  // however if word1=word2 then we need to check the difference
  private int shortestWordDistance(String[] wordsDict, String word1, String word2) {
    int min = wordsDict.length, index = -1;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
        if (index != -1 && (word1.equals(word2) || !wordsDict[i].equals(wordsDict[index]))) {
          min = Math.min(i - index, min);
        }
        index = i;
      }
    }
    return min;
  }
}
