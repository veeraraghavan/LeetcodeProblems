/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/13/22, 9:45 PM
 * =========================================
 */

package com.practice.lastdance;

public class longestpathincreasing {
  public static void main(String[] args) {
    longestpathincreasing me = new longestpathincreasing();
    me.longestIncreasingPath(new int[][] {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
  }

  int rows = 0, cols = 0;
  int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int longestIncreasingPath(int[][] matrix) {
    rows = matrix.length;
    cols = matrix[0].length;
    int ans = 0;
    int[][] cache = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        ans = Math.max(ans, recurse(matrix, i, j, cache));
      }
    }
    return ans;
  }

  public int recurse(int[][] matrix, int row, int col, int[][] cache) {
    if (cache[row][col] != 0) return cache[row][col];
    for (int[] dir : dirs) {
      int x = row + dir[0], y = col + dir[1];
      if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[row][col] < matrix[x][y]) {
        cache[row][col] = Math.max(cache[row][col], recurse(matrix, x, y, cache));
      }
    }
    return ++cache[row][col];
  }
}
