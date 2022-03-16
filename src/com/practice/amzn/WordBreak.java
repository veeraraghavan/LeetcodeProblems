package com.practice.amzn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
  public static void main(String[] args) {
    List<String> dict = new ArrayList<>();
    dict.add("leet");
    dict.add("code");
    // dict.add("aaa");
    // dict.add("aaaa");
    WordBreak me = new WordBreak();
    System.out.println(me.wordBreak2("leetcode", dict));
  }

  private boolean wordBreak2(String s, List<String> wordDict) {
    int ws = 0, we = s.length() - 1;
    // (!Character.isAlphabetic(s.charAt(ws))
    while ((!Character.isAlphabetic(s.charAt(ws)) && (ws < we))) ws++;

    HashMap<String, Boolean> wordDictionary = new HashMap<>();
    for (int i = 0; i < wordDict.size(); i++) {
      wordDictionary.put(wordDict.get(i), true);
    }
    return isComplete(s, wordDictionary, 0, new Boolean[s.length()]);
  }

  private boolean isComplete(
      String s, HashMap<String, Boolean> wordDict, int start, Boolean[] memo) {
    if (start == s.length()) return true;
    if (memo[start] != null) return memo[start];

    for (int end = start + 1; end <= s.length(); end++) {
      if (wordDict.containsKey(s.substring(start, end)) && isComplete(s, wordDict, end, memo)) {

        return memo[start] = true;
      }
    }
    return memo[start] = false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    if (wordDict.size() == 0) return false;
    HashMap<String, Boolean> wordMap = new HashMap<>();
    for (int i = 0; i < wordDict.size(); i++) wordMap.put(wordDict.get(i), true);
    return wordBreakrecurse(s, wordMap, 0, new Boolean[s.length()]);
  }

  private boolean wordBreakrecurse(
      String s, HashMap<String, Boolean> wordMap, int index, Boolean[] exists) {
    if (index == s.length()) return true;
    if (exists[index] != null) return exists[index];
    String temp = "";
    for (int end = index + 1; end <= s.length(); end++) {
      temp = s.substring(index, end);
      if (wordMap.containsKey(temp) && wordBreakrecurse(s, wordMap, end, exists)) {
        exists[index] = true;
        return true;
      }
    }
    exists[index] = false;
    return false;
  }
}
