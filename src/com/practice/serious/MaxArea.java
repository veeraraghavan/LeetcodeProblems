/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/30/21, 12:53 PM
 * =========================================
 */

package com.practice.serious;

public class MaxArea {
  public static void main(String[] args) {
    MaxArea me = new MaxArea();
    System.out.println(me.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  private int maxArea(int[] height) {
    int low = 0, high = height.length - 1;
    int result = 0;
    while (low < high) {
      int lowest = Math.min(height[low], height[high]);
      result = Math.max(lowest * (high - low), result);
      if (lowest == height[low]) low++;
      else high--;
    }

    return result;
  }
}
