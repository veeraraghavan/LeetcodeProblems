/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/31/21, 8:59 PM
 * =========================================
 */

package com.practice.serious;

public class TrappingRainWater2 {
  public static void main(String[] args) {
    TrappingRainWater2 me = new TrappingRainWater2();
    // me.trapRainWater(new int[][] {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}});
    me.trapRainWater(
        new int[][] {
          {12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}
        });
  }
  // TODO: Incomplete
  private int trapRainWater(int[][] heightMap) {
    int rowSize = heightMap.length;
    int colSize = heightMap[0].length;

    int[][] horizontalSectionLeft = new int[rowSize][colSize];
    int[][] horizontalSectionRight = new int[rowSize][colSize];
    int[][] verticalSectionLeft = new int[colSize][rowSize];
    int[][] verticalSectionRight = new int[colSize][rowSize];

    // the horizontal Section arrays
    for (int i = 0; i < rowSize; i++) {
      int[] array = new int[colSize];
      array = heightMap[i];
      horizontalSectionLeft[i][0] = array[0];
      horizontalSectionRight[i][colSize - 1] = array[colSize - 1];
      for (int j = 1; j < colSize; j++) {
        horizontalSectionLeft[i][j] = Math.max(horizontalSectionLeft[i][j - 1], array[j]);
      }
      for (int j = colSize - 2; j >= 0; j--) {
        horizontalSectionRight[i][j] = Math.max(horizontalSectionRight[i][j + 1], array[j]);
      }
    }

    // the vertical Section arrays
    for (int i = 0; i < colSize; i++) {
      for (int j = 0; j < rowSize; j++) {
        if (j == 0) {
          verticalSectionLeft[i][j] = heightMap[j][i];
        } else {
          verticalSectionLeft[i][j] = Math.max(verticalSectionLeft[i][j - 1], heightMap[j][i]);
        }
      }

      for (int j = rowSize - 1; j >= 0; j--) {
        if (j == rowSize - 1) {
          verticalSectionRight[i][j] = heightMap[j][i];
        } else {
          verticalSectionRight[i][j] = Math.max(verticalSectionRight[i][j + 1], heightMap[j][i]);
        }
      }
    }
    int volume = 0;
    int tempVolume = 0;
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        tempVolume = 0;
        if ((i == 0 && j == 0)
            || (i == rowSize - 1 && j == 0)
            || (i == 0 && j == colSize - 1)
            || (i == rowSize - 1 && j == colSize - 1)) continue;
        if (i == 0 || i == rowSize - 1) {
          //          tempVolume =
          //              Math.min(horizontalSectionLeft[i][j - 1], horizontalSectionRight[i][j +
          // 1])
          //                  - heightMap[i][j];
          //          if (tempVolume > 0) {
          //            volume += tempVolume;
          //          }
          continue;
        }

        if (j == 0 || j == colSize - 1) {
          //          tempVolume =
          //              Math.min(verticalSectionLeft[j][i - 1], verticalSectionRight[j][i + 1])
          //                  - heightMap[i][j];
          //          if (tempVolume > 0) {
          //            volume += tempVolume;
          //          }
          continue;
        }
        tempVolume =
            Math.min(
                    Math.min(horizontalSectionLeft[i][j - 1], horizontalSectionRight[i][j + 1]),
                    Math.min(verticalSectionLeft[j - 1][i], verticalSectionRight[j + 1][i]))
                - heightMap[i][j];
        if (tempVolume > 0) {
          volume += tempVolume;
        }
        continue;
      }
    }
    return volume;
  }
}
