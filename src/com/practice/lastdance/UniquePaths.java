/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/27/22, 12:48 AM
 * =========================================
 */

package com.practice.lastdance;

public class UniquePaths {
  public static void main(String[] args) {
    UniquePaths me = new UniquePaths();
    me.uniquePaths(3, 7);
  }

  public int uniquePaths(int m, int n) {
    Integer[][] cache = new Integer[m][n];
    return getUniquePaths(m - 1, n - 1, 0, 0, cache);
  }

  public int getUniquePaths(int m, int n, int row, int col, Integer[][] cache) {
    if (row < 0 || row > m || col < 0 || col > n) return 0;
    if (cache[row][col] != null) return cache[m][n];
    if (row == m && col == n) {
      cache[m][n] = 1;
      return 1;
    }
    int down = getUniquePaths(m, n, row + 1, col, cache);
    int right = getUniquePaths(m, n, row, col + 1, cache);
    cache[row][col] = down + right;

    return cache[row][col];
  }
}
