package com.practice.grokprog.dp;

public class Kanpsack_TD {
  private int[][] memo;

  public static void main(String[] args) {
    Kanpsack_TD me = new Kanpsack_TD();
    int[] weight = {2, 3, 1, 4};
    int[] profit = {4, 5, 3, 7};
    me.memo = new int[weight.length][6];

    System.out.println(me.getMaxValue(profit, weight, 5, 0));
  }

  private int getMaxValue(int[] values, int[] weight, int remainingCapa, int index) {
    int profit1 = 0;
    if (index >= values.length || remainingCapa < 0) return 0;
    if (memo[index][remainingCapa] != 0) return memo[index][remainingCapa];
    if (weight[index] <= remainingCapa) {
      profit1 =
          values[index] + getMaxValue(values, weight, remainingCapa - weight[index], index + 1);
    }
    int profit2 = getMaxValue(values, weight, remainingCapa, index + 1);
    memo[index][remainingCapa] = Math.max(profit1, profit2);
    return memo[index][remainingCapa];
  }
}
