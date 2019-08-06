package com.practice.playground.string;

import com.practice.leetcode.string.Permutation;

import java.util.Arrays;

public class PermutationStringMatch {
    public static void main(String[] args) {
        PermutationStringMatch me = new PermutationStringMatch();

        System.out.println(me.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        // Sliding window
        // S1 - ab, S2= bacdse
        // Create a lookup for S1[0....25] - with all characters and their count
        // Create a lookup for S2[0....25] but taking the substring of length S1
        // ba
        //  ac
        //   cd
        //    ds
        //      se
        // For example Create a map bc,ac,cd,ds,se and their count
        // Check S1 and S2(for each substring) for equality
        if (s1.length() > s2.length())
            return false;
        int[] s1Map = new int[26];

        for (char c : s1.toCharArray()) {
            s1Map[c - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2Map = new int[26];
            for (int j = i; (j-i)<s1.length(); j++) {
                s2Map[s2.charAt(j) - 'a']++;
            }
            if (checkEquality(s1Map, s2Map)) return true;
        }
        return false;
    }

    public boolean checkEquality(int[] s1, int[] s2) {
        boolean equal = true;
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i])
                return false;
        }
        return equal;
    }
}
