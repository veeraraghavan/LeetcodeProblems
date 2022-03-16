/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/12/22, 8:37 AM
 * =========================================
 */

package com.practice.lastdance;

public class maximalrectangle {
  public static void main(String[] args) {
    maximalrectangle me = new maximalrectangle();
  }

  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int maxArea = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
        int width = Integer.MAX_VALUE;
        for (int k = i; k >= 0; k--) {
          width = Math.min(width, dp[k][j]);
          maxArea = Math.max(maxArea, (i - k + 1) * width);
        }
      }
    }
    return maxArea;
  }
}
