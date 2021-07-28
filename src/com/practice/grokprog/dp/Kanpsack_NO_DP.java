package com.practice.grokprog.dp;

public class Kanpsack_NO_DP {
  public static void main(String[] args) {
    Kanpsack_NO_DP me = new Kanpsack_NO_DP();
    int[] weight = {2, 3, 1, 4};
    int[] profit = {4, 5, 3, 7};
    System.out.println(new Kanpsack_NO_DP().getMaxValue(profit, weight, 5, 0));
  }

  private int getMaxValue(int[] values, int[] weight, int remainingCapa, int index) {
    int profit1 = 0;
    if (index >= values.length) return 0;
    if (weight[index] <= remainingCapa) {
      profit1 =
          values[index] + getMaxValue(values, weight, remainingCapa - weight[index], index + 1);
    }
    int profit2 = getMaxValue(values, weight, remainingCapa, index + 1);
    return Math.max(profit1, profit2);
  }
}
