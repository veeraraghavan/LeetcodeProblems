/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/15/21, 11:08 AM
 * =========================================
 */

package com.practice.serious;

import java.util.HashSet;

public class MaxProduct {
  public static void main(String[] args) {
    MaxProduct me = new MaxProduct();
  }

  private int getIndex(char c) {
    return c - 'a';
  }

  public int maxProduct(String[] words) {
    // Scanning all words n^2
    int max = 0;
    int mask[] = new int[words.length];
    int lens[] = new int[words.length];
    int index = 0;
    for (String word : words) {
      for (char c : word.toCharArray()) {
        mask[index] |= (1 << getIndex(c));
      }
      lens[index] = word.length();
      index++;
    }
    for (int i = 0; i < words.length - 1; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if ((mask[i] & mask[j]) == 0) max = Math.max(max, lens[i] * lens[j]);
      }
    }
    return max;
  }

  public boolean shareLetters(String word1, String word2) {
    if (word1.length() < word2.length()) return shareLetters(word2, word1);
    HashSet<Integer> word1Dict = new HashSet();
    HashSet<Integer> word2Dict = new HashSet();
    generateArray(word1, word1Dict);
    generateArray(word2, word2Dict);
    for (Integer key : word1Dict) {
      if (word2Dict.contains(key)) return true;
    }
    return false;
  }

  public void generateArray(String word, HashSet<Integer> dictionary) {
    for (char c : word.toCharArray()) {
      dictionary.add(c - 'a');
    }
  }
}
