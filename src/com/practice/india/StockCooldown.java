package com.practice.india;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class StockCooldown {
  public static void main(String[] args) {
    StockCooldown me = new StockCooldown();
  }

  public int maxProfit(int[] prices) {
    int[] profit = new int[prices.length];
    int balance = -prices[0];
    profit[0] = 0;
    profit[1] = Math.max(profit[0], prices[1] - prices[0]);
    balance = Math.max(balance, -prices[1]);
    for (int i = 2; i < prices.length; i++) {
      profit[i] = Math.max(profit[i - 1], balance + prices[i]);
      balance = Math.max(balance, profit[i - 2] - prices[i]);
    }
    // At any point we need 2 things
    return profit[prices.length - 1];
  }
}
