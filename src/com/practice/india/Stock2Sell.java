package com.practice.india;

public class Stock2Sell {
  public static void main(String[] args) {
    Stock2Sell me = new Stock2Sell();
    System.out.println(me.maxProfit(new int[] {6, 1, 3, 2, 4, 7}));
  }

  private int maxProfit(int[] prices) {
    int result = 0;
    int[] left = new int[prices.length];
    left[0] = 0;
    int[] right = new int[prices.length];
    int buy = prices[0];
    int buyRight = prices[prices.length - 1];
    for (int i = 1; i < prices.length; i++) {
      left[i] = Math.max(left[i - 1], prices[i] - buy);
      buy = Math.min(buy, prices[i]);

      int r = prices.length - 1 - i;
      right[r] = Math.max(right[r + 1], buyRight - prices[r]);
      buyRight = Math.max(buyRight, prices[r]);
    }

    for (int i = 0; i < prices.length - 1; i++) {
      result = Math.max(result, left[i] + right[i + 1]);
    }
    return Math.max(left[left.length - 1], result);
  }
}
