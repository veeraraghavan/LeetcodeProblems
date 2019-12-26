package com.practice.playground.string;

public class SubSequence {
    public static void main(String[] args) {
        SubSequence me = new SubSequence();
        System.out.println(me.longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || "".equals(s) || s.length() == 0) {
            return 0;
        }
        int[][] subSequence = new int[s.length()][s.length()];
        char[] characters = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j + i < characters.length; j++) {
                int k = i + j;
                if (i == 0) {
                    subSequence[j][k] = 1;
                } else {
                    if (characters[j] == characters[k]) {
                        subSequence[j][k] = 2 + subSequence[j + 1][k - 1];
                    } else {
                        subSequence[j][k] = Math.max(subSequence[j + 1][k], subSequence[j][k - 1]);
                    }
                }
                //ans = ans > subSequence[j][k] ? ans : subSequence[j][k];
            }
        }
        return subSequence[0][characters.length-1];

    }
}
