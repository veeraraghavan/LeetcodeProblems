package com.practice.scribble;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AlienSorted {
    public static void main(String[] args) {
        AlienSorted me = new AlienSorted();
//        ["hello","leetcode"]
//        "hlabcdefgijkmnopqrstuvwxyz"
        System.out.println(me.isAlienSorted2(new String[]{"apple", "app","apple12"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alphabets = new HashMap<>();
        int index = 0;
        for (Character c : order.toCharArray()) {
            alphabets.put(c, index++);
        }
        index = 0;


        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                index = 0;
                int length = words[i].length() > words[j].length() ? words[j].length() : words[i].length();
                while (index < length) {
                    if (alphabets.get(words[i].charAt(index)) > alphabets.get(words[j].charAt(index))) {
                        return false;
                    } else if (alphabets.get(words[i].charAt(index)) < alphabets.get(words[j].charAt(index))) {
                        break;
                    }
                    index++;
                }
                if (index == length) {
                    if (words[i].length() > words[j].length()) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public boolean isAlienSorted2(String[] words, String order) {
        String[] newWords = words.clone();
        Map<Character, Integer> alphabets = new HashMap<>();
        int index = 0;
        for (Character c : order.toCharArray()) {
            alphabets.put(c, index++);
        }
        Arrays.sort(newWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int lenA = o1.length();
                int lenB = o2.length();
                for (int i = 0; i < lenA && i < lenB; i++) {
                    if (alphabets.get(o1.charAt(i)) < alphabets.get(o2.charAt(i))) {
                        return -1;
                    } else if (alphabets.get(o1.charAt(i)) > alphabets.get(o2.charAt(i))) {
                        return 1;
                    }
                }
                return lenA - lenB;
            }
        });
        for(int i=0;i<words.length;i++){
            if(!words[i].equals(newWords[i]))
                return false;
        }
        return true;
    }

}
