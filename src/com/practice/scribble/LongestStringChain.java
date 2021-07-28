package com.practice.scribble;

import com.practice.amzn.WordBreak;

import java.util.*;

public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain me = new LongestStringChain();
        //System.out.println(me.longestStrChain(new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"}));
        //System.out.println(me.longestStrChain(new String[]{"sgtnz", "sgtz", "sgz", "ikrcyoglz", "ajelpkpx", "ajelpkpxm", "srqgtnz", "srqgotnz", "srgtnz", "ijkrcyoglz"}));
        System.out.println(me.longestStrChain(new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"}));

    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        List<List<String>> wordsList = new ArrayList<>();
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        HashMap<String, Integer> word2Length = new HashMap<>();
//  Sort the words in the descending order of length;
//  Run the dfs traversal on each word
//  In dfs traversal => remove one character at a time and check the word is present in the list
//  if yes continue the traversal
//  As memoization you can store results on the intermediate words.
//
//
        int length = 0;
        for (String word : words) {
            int temp = dfs(wordsSet, word2Length, word);
            if (temp > length)
                length = temp;

        }
        return length;

    }

    public int dfs(Set<String> words, HashMap<String, Integer> map, String word) {
        if (map.containsKey(word))
            return map.get(word);
        StringBuilder sb = new StringBuilder(word);
        int max = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            if (words.contains(sb.toString())) {
                max = Math.max(max, dfs(words, map, sb.toString()));
            }
            sb.insert(i, c);
        }
        map.put(word, max);
        return max + 1;
    }
}
