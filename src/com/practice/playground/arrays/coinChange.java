package com.practice.playground.arrays;

import java.util.Arrays;

public class coinChange {
    public static void main(String[] args) {
        int[] input = {1};
        coinChange me = new coinChange();
        System.out.println(me.coinChange(input, 0));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] min = new int[amount + 1];
        Arrays.fill(min, Integer.MAX_VALUE - 1);
        min[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount)
                min[coins[i]] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j :coins) {
                if ((i - j) > 0) {
                    min[i] = Math.min(min[i], 1 + min[i - j]);
                }
            }
        }

        if (min[amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return min[amount];

    }
}
