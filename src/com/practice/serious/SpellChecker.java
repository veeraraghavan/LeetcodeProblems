/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/14/21, 9:27 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SpellChecker {
  public static void main(String[] args) {
    SpellChecker me = new SpellChecker();
  }

  private Set<String> words = new HashSet<>();
  private HashMap<String, String> capWords = new HashMap<>();
  private HashMap<String, String> encodedWords = new HashMap<>();

  public String[] spellchecker(String[] wordlist, String[] queries) {

    String[] result = new String[queries.length];

    for (String word : wordlist) {

      words.add(word);
      capWords.putIfAbsent(word.toLowerCase(), word);
      encodedWords.putIfAbsent(encode(word.toLowerCase()), word);
    }

    for (int i = 0; i < queries.length; i++) {
      result[i] = spellCheck(queries[i]);
    }
    return result;
  }

  private String spellCheck(String word) {
    if (words.contains(word)) return word;
    if (capWords.containsKey(word.toLowerCase())) {
      return capWords.get(word.toLowerCase());
    }
    if (encodedWords.containsKey(encode(word.toLowerCase())))
      return encodedWords.get(encode(word.toLowerCase()));
    return "";
  }

  private String encode(String word) {
    StringBuilder enc = new StringBuilder();
    for (char c : word.toCharArray()) {
      enc.append(isVowel(Character.toLowerCase(c)) ? "*" : c);
    }
    return enc.toString();
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
