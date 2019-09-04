package com.practice.amzn;

import java.util.HashMap;

public class MostCommonWord {
    public static void main(String[] args) {
        MostCommonWord me = new MostCommonWord();
        System.out.println(me.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String fullParagraph = paragraph + ".";
        String ans = "";
        int ansFreq = 0;
        HashMap<String, Integer> wordMap = new HashMap<>();
        HashMap<String, Integer> bannedWordMap = new HashMap<>();
        for (String word : banned) {
            bannedWordMap.put(word, 1);
        }
        StringBuilder word = new StringBuilder();
        for (char c : fullParagraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalWord = word.toString();
                if (!bannedWordMap.containsKey(finalWord)) {
                    wordMap.put(finalWord, wordMap.getOrDefault(finalWord, 0) + 1);
                    if (wordMap.get(finalWord) > ansFreq) {
                        ans = finalWord;
                        ansFreq = wordMap.get(finalWord);
                    }
                }
                word = new StringBuilder();
            }

        }
        return ans;


    }
}
