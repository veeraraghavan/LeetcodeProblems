package com.practice.grokprog.dp;

import java.util.ArrayList;
import java.util.List;

public class Kanpsack_BU {
  private int[][] memo;

  public static void main(String[] args) {
    Kanpsack_BU me = new Kanpsack_BU();
    int[] weight = {1, 2, 3, 5};
    int[] profit = {1, 6, 10, 16};
    int capacity = 7;
    /*                       0       1         2         3         4           5            6          7
    Value  Weight  Idx   ***********************************************************************************|
      1      1      0     *  0   |    1    |    1    |   1     |    1      |    1      |    1      |   1    |
                          ------ |--------------------------------------------------------------------------|
      6      2      1     *  0   |    1    |    6    |   7     |    7      |    7      |    7      |   7    |
                          ------ |-------  -----------------------------------------------------------------|
      10     3      2     *  0   |    1    |    6    |   10    |   11      |    16     |    17     |   17   |
                          ------ |-------  -----------------------------------------------------------------|
      16     5      3     *  0   |    1    |    6    |   10    |   11      |    16     |    17     |   22   |
                          ----------------------------------------------------------------------------------|
     */

    int resultArray[][] = new int[profit.length][capacity + 1];
    // All combinations whose target weight is 0 will be zero
    for (int i = 0; i < profit.length; i++) {
      resultArray[i][0] = 0;
    }
    for (int i = 0; i <= capacity; i++) {
      if (i >= weight[0]) resultArray[0][i] = profit[0];
    }

    for (int i = 1; i < profit.length; i++) {
      for (int j = 1; j <= capacity; j++) {
        int profit1 = 0, profit2 = 0;
        if (j - weight[i] >= 0) profit1 = resultArray[i - 1][j - weight[i]] + profit[i];
        profit2 = resultArray[i - 1][j];
        resultArray[i][j] = Math.max(profit1, profit2);
      }
    }
    System.out.println(resultArray[profit.length - 1][capacity]);
    System.out.println(me.getElements(resultArray, capacity, weight, profit));
  }

  private List<Integer> getElements(int[][] result, int weight, int[] weights, int[] value) {
    ArrayList<Integer> res = new ArrayList<>();
    int totalValue = result[result.length - 1][weight];
    int capacity = weight;
    for (int i = result.length; i > 0; i--) {
      if (totalValue != result[i - 1][capacity]) {
        res.add(i);
        totalValue -= value[i];
        capacity -= weights[i];
      }
    }

    return res;
  }
}
