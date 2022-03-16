/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/16/22, 6:37 PM
 * =========================================
 */

package com.practice.lastdance;

public class NumMatrix {
  int[][] bit;
  int rows, columns;

  public static void main(String[] args) {
    //    NumMatrix me =
    //        new NumMatrix(
    //            new int[][] {
    //              {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0,
    // 5}
    //            });
    //
    //    System.out.println(me.sumRegion(2, 1, 4, 3));
    NumMatrix me = new NumMatrix(new int[][] {{1, 2}});

    System.out.println(me.sumRegion(0, 1, 0, 1));
  }

  public NumMatrix(int[][] matrix) {
    rows = matrix.length;
    columns = matrix[0].length;
    bit = new int[rows + 1][];
    for (int i = 1; i <= rows; i++) {
      bit[i] = new int[columns + 1];
    }
    buildBit(matrix);
  }

  private void buildBit(int[][] matrix) {
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= columns; j++) {
        int value = matrix[i - 1][j - 1];
        updateBit(i, j, value);
      }
    }
  }

  private int queryBit(int row, int col) {
    int sum = 0;
    for (int i = row; i > 0; i -= getLSB(i)) {
      for (int j = col; j > 0; j -= getLSB(j)) {
        sum += bit[i][j];
      }
    }
    return 0;
  }

  private void updateBit(int row, int col, int val) {
    for (int i = row; i <= rows; i += getLSB(i)) {
      for (int j = col; j <= rows; j += getLSB(j)) {
        bit[i][j] += val;
      }
    }
  }

  private int getLSB(int x) {
    return x & (-x);
  }

  public void update(int row, int col, int val) {
    int old_value = sumRegion(row, col, row, col);
    int diff = val - old_value;
    updateBit(row + 1, col + 1, diff);
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    row1++;
    col1++;
    row2++;
    col2++;
    int a = queryBit(row2, col2);
    int b = queryBit(row1 - 1, col1 - 1);
    int c = queryBit(row1 - 1, col2);
    int d = queryBit(row2, col1 - 1);
    return a + b - (c + d);
  }
}
