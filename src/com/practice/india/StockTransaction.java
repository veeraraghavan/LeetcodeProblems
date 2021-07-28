package com.practice.india;

public class StockTransaction {
  public static void main(String[] args) {
    StockTransaction me = new StockTransaction();
  }

  public int maxProfit(int[] prices, int fee) {
    // You need to make 2 decisions .
    // 1.On a given day whether you execute a sell order or not
    //    condition:- is selling today with the fees better off than yesterday's balance.
    // On a given day whether you need to buy a share or not.
    //    condition:- is the balance after buying better off than yesterday's balance
    // We need 2 variables. Net profit after transactions called profit.
    // Net balance after you sell the share .
    int profit = 0;
    int minimumPrice = 0;
    minimumPrice = -prices[0]; // On day 1 you have no cash , hence balance is negative
    for (int i = 1; i < prices.length; i++) {
      profit = Math.max(profit, minimumPrice + prices[i] - fee);
      minimumPrice = Math.max(minimumPrice, profit - prices[i]);
    }

    return profit;
  }
}
