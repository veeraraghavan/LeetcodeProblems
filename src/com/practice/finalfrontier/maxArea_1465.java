/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   6/2/21, 10:24 PM
 * =========================================
 */

package com.practice.finalfrontier;

import java.util.Arrays;

public class maxArea_1465 {
  public static void main(String[] args) {
    maxArea_1465 me = new maxArea_1465();
    me.maxArea(5, 4, new int[] {3, 1}, new int[] {1});
  }

  private int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    int[] modifiedHorizontalCuts = new int[horizontalCuts.length + 2];
    int[] modifiedVerticalCuts = new int[verticalCuts.length + 2];
    for (int i = 0; i < modifiedHorizontalCuts.length; i++) {
      if (i == 0) {
        modifiedHorizontalCuts[i] = 0;
        continue;
      }
      if (i == modifiedHorizontalCuts.length - 1) {
        modifiedHorizontalCuts[i] = h;
        continue;
      }
      modifiedHorizontalCuts[i] = horizontalCuts[i - 1];
    }

    for (int i = 0; i < modifiedVerticalCuts.length; i++) {
      if (i == 0) {
        modifiedVerticalCuts[i] = 0;
        continue;
      }
      if (i == modifiedVerticalCuts.length - 1) {
        modifiedVerticalCuts[i] = w;
        continue;
      }
      modifiedVerticalCuts[i] = verticalCuts[i - 1];
    }

    int maxRow = 0;
    for (int i = 1; i < modifiedHorizontalCuts.length; i++) {
      maxRow = Math.max(maxRow, modifiedHorizontalCuts[i] - modifiedHorizontalCuts[i - 1]);
    }

    int maxColumn = 0;
    for (int i = 1; i < modifiedVerticalCuts.length; i++) {
      maxColumn = Math.max(maxColumn, modifiedVerticalCuts[i] - modifiedVerticalCuts[i - 1]);
    }
    return maxColumn * maxRow;
  }
}
