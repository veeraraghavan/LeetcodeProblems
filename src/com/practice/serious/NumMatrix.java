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

  private int[][] input;

  private NumMatrix(int[][] matrix) {
    input = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[0].length; j++) {
        input[i][j] = matrix[i][j];
      }
    }
  }

  private int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[0].length; j++) {
        if (i >= row1 && j >= col1 && i <= row2 && j <= col2) {
          sum += input[i][j];
        }
      }
    }
    return sum;
  }
}
