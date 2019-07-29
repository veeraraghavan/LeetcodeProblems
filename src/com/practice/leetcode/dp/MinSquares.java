package com.practice.leetcode.dp;
//https://leetcode.com/problems/perfect-squares/submissions/
public class MinSquares {
    public static void main(String[] args) {
        MinSquares me = new MinSquares();
        System.out.println(me.numSquares(9));
    }

    public int numSquares(int n) {

        int[] minSq = new int[n + 1];
        minSq[0] = 0;
        minSq[1] = 1;

        for (int i = 2; i <= n; i++) {
            minSq[i] = i; // 1 squares

            for (int j = 1; j * j <= i; j++) {
                minSq[i] = Math.min(minSq[i], 1 + minSq[i - j * j]);
            }

        }
        return minSq[n];
    }
}
