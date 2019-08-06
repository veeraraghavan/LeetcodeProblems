package com.practice.leetcode.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation {
    public static void main(String[] args) {
        Permutation me = new Permutation();
//        System.out.println(me.checkInclusion("ab", "bac"));
//        System.out.println(me.checkInclusion("ab", "abc"));
//        System.out.println(me.checkInclusion("abcdxabcde", "abcdeabcdx"));
        System.out.println(me.checkInclusion("hello", "ooolleoooleh"));


    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();

        return permuteGenerate("", s2, s1.toCharArray(), indexMap);

    }

    public boolean permuteGenerate(String result, String s2, char[] input, Map<Integer, Integer> indexMap) {
        boolean found = false;
        if (result.length() == input.length) {
            if (s2.contains(result)) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < input.length; i++) {
            if (!indexMap.containsKey(i)) {
                Map<Integer, Integer> temp = new HashMap<>(indexMap);
                temp.put(i, 1);
                found = permuteGenerate(result + input[i], s2, input, temp);
                if (found) {
                    return true;
                }

            }
        }
        return false;


    }

}
