package com.practice.ctci.string;

import com.practice.amzn.MinStack;

public class minDistance {
    public static void main(String[] args) {
        minDistance me = new minDistance();
        System.out.println(me.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m * n == 0)
            return m + n;
        int[][] distVector = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= m; i++)
            distVector[i][0] = i;
        for (int j = 0; j <= n; j++)
            distVector[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int previous = distVector[i][j - 1];
                int previousRow = distVector[i - 1][j];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    distVector[i][j] = 1 + Math.min(previous, Math.min(previousRow, distVector[i - 1][j - 1]));
                } else {
                    distVector[i][j] = distVector[i - 1][j - 1];
                }
            }
        }
        return distVector[m][n];
    }
}
