package com.practice.india;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class StockI {
  public static void main(String[] args) {
    StockI me = new StockI();
  }

  public int maxProfit(int[] prices) {
    int result = 0;
    if (prices.length == 0 || prices.length == 1) return 0;
    int buy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] - buy > result) {
        result = prices[i] - buy;
      }
      if (prices[i] < buy) {
        buy = prices[i];
      }
    }
    return result;
  }
}
