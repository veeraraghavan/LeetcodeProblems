package com.practice.leetcode.array;

public class StockBuySell {
    public static void main(String[] args) {
        StockBuySell me = new StockBuySell();
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(me.maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        if(prices.length==0 || prices.length==1){
            return 0;
        }
        int result=0;
        int buy=prices[0];
        for (int i = 1; i < prices.length; i++) {
            result= Math.max(result,prices[i]-buy);
            buy = Math.min(buy,prices[i]);

        }
        return result;


    }
}
