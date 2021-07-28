package com.practice.india;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class StockII {
  public static void main(String[] args) {
    StockII me = new StockII();
  }

  public int maxProfit(int[] prices) {
    int result = 0;
    int buy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] - buy > 0) {
        result += prices[i] - buy;
        buy = prices[i];
      }
      buy = Math.min(buy, prices[i]);
    }
    return result;
  }
}
