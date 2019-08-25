package com.practice.playground.string;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        WordLadder me = new WordLadder();
        String[] input = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(me.ladderLength("hit", "cog", Arrays.asList(input)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // First form a dictionary of all possible words
        HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
        int L=beginWord.length();
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String temp = word.substring(0, i) + "*" + word.substring(i + 1, L);
                ArrayList<String> similarWords = dict.getOrDefault(temp, new ArrayList<String>());
                similarWords.add(word);
                dict.put(temp, similarWords);
            }
        });
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        HashMap<String, Boolean> visited = new HashMap<>();
        Q.add(new Pair(beginWord, 1));
        visited.put(beginWord,true);
        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String currentWord = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String tempWord = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, L);
                for (String word : dict.getOrDefault(tempWord, new ArrayList<>())) {
                    if (word.equals(endWord))
                        return level + 1;
                    if (!visited.containsKey(word)) {
                        Q.add(new Pair<>(word, level + 1));
                        visited.put(word,true);
                    }

                }
            }

        }
        return 0;

    }

}
