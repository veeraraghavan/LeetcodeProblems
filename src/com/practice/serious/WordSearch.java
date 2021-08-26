/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/25/21, 2:45 PM
 * =========================================
 */

package com.practice.serious;

public class WordSearch {

  public static void main(String[] args) {
    WordSearch me = new WordSearch();
    System.out.println(
        me.exist(
            new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
            "SEE"));
  }

  private boolean exist(char[][] board, String word) {

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (dfs(board, word, "", i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean dfs(char[][] board, String word, String wordFormed, int row, int col, int index) {
    if (wordFormed.length() == word.length() && wordFormed.equals(word)) {
      return true;
    }

    if (wordFormed.length() == word.length()) return false;
    if (row < 0
        || row == board.length
        || col < 0
        || col == board[row].length
        || board[row][col] != word.charAt(index)) {
      return false;
    }
    char c = board[row][col];
    board[row][col] = '#';
    boolean result =
        dfs(board, word, wordFormed + c, row, col + 1, index + 1)
            || dfs(board, word, wordFormed + c, row, col - 1, index + 1)
            || dfs(board, word, wordFormed + c, row + 1, col, index + 1)
            || dfs(board, word, wordFormed + c, row - 1, col, index + 1);
    board[row][col] = c;
    return result;
  }
}
