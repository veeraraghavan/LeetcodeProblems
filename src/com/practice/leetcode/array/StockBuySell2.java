package com.practice.leetcode.array;

public class StockBuySell2 {
    public static void main(String[] args) {
        StockBuySell2 me = new StockBuySell2();
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println(me.maxProfit(input));
    }

    public int maxProfit(int[] prices) {
        // Simple Algorithm- Execute transaction on all days price is greater than yesterday.
        // Technically equivalent to buy low and sell high.
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
