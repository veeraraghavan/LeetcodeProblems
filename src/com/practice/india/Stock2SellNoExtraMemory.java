package com.practice.india;

public class Stock2SellNoExtraMemory {
  public static void main(String[] args) {
    Stock2SellNoExtraMemory me = new Stock2SellNoExtraMemory();
    // System.out.println(me.maxProfit(new int[] {3, 3, 5, 0, 0, 3, 1, 4}));
    System.out.println(me.maxProfit(new int[] {2, 4, 1, 3, 5, 7}));
  }

  private int maxProfit(int[] prices) {
    int firstBuy = Integer.MIN_VALUE,
        firstSell = Integer.MIN_VALUE,
        secondBuy = Integer.MIN_VALUE,
        secondSell = Integer.MIN_VALUE,
        thirdBuy = Integer.MIN_VALUE,
        thirdSell = Integer.MIN_VALUE;

    for (int price : prices) {
      firstBuy = Math.max(firstBuy, -price);
      firstSell = Math.max(firstSell, price + firstBuy);

      secondBuy = Math.max(secondBuy, firstSell - price);
      secondSell = Math.max(secondSell, secondBuy + price);

      thirdBuy = Math.max(thirdBuy, secondSell - price);
      thirdSell = Math.max(thirdSell, thirdBuy + price);
    }
    return secondSell;
  }
}
