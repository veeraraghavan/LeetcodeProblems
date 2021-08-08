/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/7/21, 2:35 PM
 * =========================================
 */

package com.practice.serious;

public class NumOfIslands {
  public static void main(String[] args) {
    NumOfIslands me = new NumOfIslands();
  }

  public int numIslands(char[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == '1') {
            dfs(grid, i, j);
            result++;
          }
        }
      }
    }
    return result;
  }

  private void dfs(char[][] grid, int row, int col) {
    if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == '0')
      return;

    if (grid[row][col] == '1') grid[row][col] = '0';
    dfs(grid, row, col + 1);
    dfs(grid, row, col - 1);
    dfs(grid, row + 1, col);
    dfs(grid, row - 1, col);

    return;
  }
}
