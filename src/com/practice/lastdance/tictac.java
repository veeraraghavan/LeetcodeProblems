/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/27/22, 9:06 PM
 * =========================================
 */

package com.practice.lastdance;

public class tictac {
  public static void main(String[] args) {
    tictac me = new tictac(2);
    // me.move(0, 0, 1);
    me.move(0, 0, 2);
    me.move(0, 1, 1);
    me.move(1, 1, 2);
    //    me.move(2, 0, 1);
    //    me.move(1, 0, 2);
    //    me.move(2, 1, 1);
  }

  char[][] board;
  char[] plays = new char[] {'X', 'O'};
  int n = 0;
  boolean over = false;

  public tictac(int n) {
    board = new char[n][n];
    this.n = n;
  }

  public int move(int row, int col, int player) {
    board[row][col] = plays[player - 1];
    return gameOver(player - 1);
  }

  public int gameOver(int player) {
    int occurrence = 0;
    for (int i = 0; i < n; i++) {
      occurrence = 0;
      for (int j = 0; j < n; j++) {
        if (board[i][j] == plays[player]) occurrence++;
      }
      if (occurrence == n) return player + 1;
    }

    for (int i = 0; i < n; i++) {
      occurrence = 0;
      for (int j = 0; j < n; j++) {
        if (board[j][i] == plays[player]) occurrence++;
      }
      if (occurrence == n) return player + 1;
    }
    occurrence = 0;
    for (int i = 0; i < n; i++) {

      if (board[i][i] == plays[player]) occurrence++;
      if (occurrence == n) return player + 1;
    }
    occurrence = 0;
    for (int i = 0; i < n; i++) {

      if (board[i][n - i - 1] == plays[player]) occurrence++;
      if (occurrence == n) return player + 1;
    }
    return 0;
  }
}
