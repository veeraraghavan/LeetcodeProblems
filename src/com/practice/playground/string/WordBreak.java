package com.practice.playground.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak me = new WordBreak();
        List<String> dict = new ArrayList<>();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");
        System.out.println(me.wordBreak("catsandog", dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> wordDictionary = new HashMap<>();
        for (int i = 0; i < wordDict.size(); i++) {
            wordDictionary.put(wordDict.get(i), true);
        }
        return isComplete(s, wordDictionary, 0, new Boolean[s.length()]);


    }

    public boolean isComplete(String s, HashMap<String, Boolean> wordDict, int start, Boolean[] memo) {
        if (start == s.length())
            return true;
        if (memo[start] != null)
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.containsKey(s.substring(start, end)) && isComplete(s, wordDict, end, memo)) {

                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}

