package com.practice.leetcode.dp;

public class stepsCount {
    public static void main(String[] args) {

        stepsCount me = new stepsCount();
        int n = 5;

        System.out.println(me.climbStairs(n));
    }

    public int climbStairs(int n) {
        int[] memory = new int[n];
        return stepsCount(n, memory);
    }

    public int stepsCount(int n, int[] memory) {

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n <= 0) return 0;
        if (memory[n - 1] == 0) {
            memory[n - 1] = stepsCount(n - 1, memory) + stepsCount(n - 2, memory);
        }
        return memory[n - 1];
    }

}
