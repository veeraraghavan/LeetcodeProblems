/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/31/21, 1:03 PM
 * =========================================
 */
// https://leetcode.com/problems/trapping-rain-water/
package com.practice.serious;

// Core logic: For each index count the volume it is adding to total trapped water.
// Water trapped in current index = Lowest(largest Elevation in left, Largest Elevation in
// Right)-currentHeight.
// Include if the volume is higher than 0.
public class Trap {
  public static void main(String[] args) {
    Trap me = new Trap();
  }

  public int trap(int[] height) {
    int volume = 0, volumeAtCurrent = 0;
    int length = height.length;
    int left[] = new int[length];
    int right[] = new int[length];
    if (length == 0) return 0;
    left[0] = height[0];
    right[length - 1] = height[length - 1];
    for (int i = 1; i < length; i++) {
      left[i] = Math.max(left[i - 1], height[i]);
    }
    for (int i = length - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], height[i]);
    }
    for (int i = 1; i < length - 1; i++) {
      volumeAtCurrent = Math.min(left[i - 1], right[i + 1]) - height[i];
      if (volumeAtCurrent > 0) volume += volumeAtCurrent;
    }
    return volume;
  }
}
