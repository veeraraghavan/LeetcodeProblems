/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/7/22, 1:29 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.LinkedList;
import java.util.List;

public class surroundedregion {
  public static void main(String[] args) {
    surroundedregion me = new surroundedregion();
  }

  int rows = 0;
  int cols = 0;

  public void solve(char[][] board) {
    List<Pair> grids = new LinkedList<>();
    rows = board.length;
    cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      grids.add(new Pair(i, 0));
      grids.add(new Pair(i, cols - 1));
    }
    for (int i = 0; i < cols; i++) {
      grids.add(new Pair(0, i));
      grids.add(new Pair(rows - 1, i));
    }
    for (Pair grid : grids) {
      this.dfs(board, grid.first, grid.second);
    }

    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
        if (board[i][j] == 'E') board[i][j] = 'O';
      }
    }
  }

  public void dfs(char[][] board, int row, int col) {
    if (board[row][col] != 'O') return;
    board[row][col] = 'E';
    if (row > 0) this.dfs(board, row - 1, col);
    if (row < this.rows - 1) this.dfs(board, row + 1, col);
    if (col > 0) this.dfs(board, row, col - 1);
    if (col < this.cols - 1) this.dfs(board, row, col + 1);
    return;
  }
}

class Pair {
  public int first;
  public int second;

  public Pair(int a, int b) {
    this.first = a;
    this.second = b;
  }
}
