/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/18/22, 1:28 PM
 * =========================================
 */

package com.practice.lastdance;

public class maxAbsoluteSum {
  public static void main(String[] args) {
    maxAbsoluteSum me = new maxAbsoluteSum();
  }

  public int maxAbsoluteSum(int[] nums) {
    int maxPos = 0, minNeg = 0, curPos = 0, curNeg = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] + curPos > 0) curPos = nums[i] + curPos;
      else curPos = 0;
      maxPos = Math.max(curPos, maxPos);

      if (nums[i] + curNeg < 0) curNeg = nums[i] + curNeg;
      else curNeg = 0;
      minNeg = Math.min(minNeg, curNeg);
    }
    return Math.max(maxPos, -minNeg);
  }
}
