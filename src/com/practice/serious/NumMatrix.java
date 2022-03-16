/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/18/21, 10:50 PM
 * =========================================
 */

package com.practice.serious;

public class NumMatrix {

  public static void main(String[] args) {
    NumMatrix me =
        new NumMatrix(
            new int[][] {
              {3, 0, 1, 4, 2},
              {5, 6, 3, 2, 1},
              {1, 2, 0, 1, 5},
              {4, 1, 0, 1, 7},
              {1, 0, 3, 0, 5}
            });
    System.out.println(me.sumRegion(2, 1, 4, 3));
  }
  //  ["NumMatrix","sumRegion","sumRegion","sumRegion"]
  //              {2, 1, 4, 3},
  //              {1, 1, 2, 2},
  //              {1, 2, 2, 4}
  // [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]

  private int[][] dp;

  public NumMatrix(int[][] matrix) {
    dp = new int[matrix.length][matrix[0].length + 1];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        dp[i][j + 1] = dp[i][j] + matrix[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = row1; i <= row2; i++) {
      sum += dp[i][col2 + 1] - dp[i][col1];
    }
    return sum;
  }
}
