/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/6/21, 10:16 PM
 * =========================================
 */

package com.practice.finalfrontier;

import java.util.Arrays;

public class Mean_1619 {
  public static void main(String[] args) {
    Mean_1619 me = new Mean_1619();
    me.trimMean(new int[] {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0});
  }

  private double trimMean(int[] arr) {
    Arrays.sort(arr);
    double sum = 0;
    int count = (5 * arr.length) / 100;
    for (int i = count; i < arr.length - count; i++) {
      sum += arr[i];
    }
    System.out.println(sum);
    return sum / (float) ((arr.length - (2 * count)));
  }
}
