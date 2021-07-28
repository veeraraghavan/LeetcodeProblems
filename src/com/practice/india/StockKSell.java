package com.practice.india;

public class StockKSell {
  public static void main(String[] args) {
    StockKSell me = new StockKSell();
  }

  public int maxProfit(int k, int[] prices) {
    int result = 0;
    if (k > prices.length / 2) {
      return 0;
    }
    int transactions = Math.min(k, prices.length / 2);
    int[] buy = new int[transactions];
    int[] sell = new int[transactions];
    for (int i = 0; i < transactions; i++) buy[i] = Integer.MIN_VALUE;

    for (int price : prices) {
      for (int i = transactions - 1; i >= 0; i--) {
        sell[i] = Math.max(sell[i], buy[i] + price);
        buy[i] = Math.max(buy[i], sell[i - 1] - price);
      }
    }
    return sell[transactions - 1];
  }
}
