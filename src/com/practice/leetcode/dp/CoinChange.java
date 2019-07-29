package com.practice.leetcode.dp;

import java.util.Arrays;
//https://leetcode.com/problems/coin-change/submissions/

public class CoinChange {
    public static void main(String[] args) {
        CoinChange me = new CoinChange();
        int[] coins = {1};
        int amount = 1;
        System.out.println(me.coinChange(coins, amount));
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

            for (int j = 0; j < coins.length; j++) {
                if ((i - coins[j]) > 0) {
                    min[i] = Math.min(min[i], 1 + min[i - coins[j]]);
                }
            }
        }

        if (min[amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }

        return min[amount];

    }

}
