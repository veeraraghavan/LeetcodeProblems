/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/12/21, 9:30 PM
 * =========================================
 */

package com.practice.serious;

public class maxLengthPositiveProduct {
  public static void main(String[] args) {
    maxLengthPositiveProduct me = new maxLengthPositiveProduct();
  }

  public int getMaxLen(int[] nums) {
    int zeroPos = -1, cntNegative = 0, firstNegative = -1;
    int maxLength = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        cntNegative++;
        if (firstNegative == -1) firstNegative = i;
      } else if (nums[i] == 0) {
        firstNegative = -1;
        zeroPos = i;
        cntNegative = 0;
        continue;
      }
      if (cntNegative % 2 == 0) maxLength = Math.max(maxLength, i - zeroPos);
      else maxLength = Math.max(maxLength, i - firstNegative);
    }
    return maxLength;
  }
}
