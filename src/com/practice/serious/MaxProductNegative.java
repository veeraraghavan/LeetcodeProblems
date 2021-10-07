/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/3/21, 10:05 PM
 * =========================================
 */

package com.practice.serious;

public class MaxProductNegative {
  public static void main(String[] args) {
    MaxProductNegative me = new MaxProductNegative();
    System.out.println(me.maxProduct(new int[] {2, 3, -2, -8}));
  }

  public int maxProduct(int[] nums) {
    int[] maxPositive = new int[nums.length];
    int[] maxNegative = new int[nums.length];
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        maxPositive[i] = Math.max(0, nums[i]);
        maxNegative[i] = Math.min(0, nums[i]);
        continue;
      }
      maxPositive[i] =
          Math.max(maxPositive[i - 1] * nums[i], Math.max(maxNegative[i - 1] * nums[i], nums[i]));
      maxNegative[i] =
          Math.min(maxPositive[i - 1] * nums[i], Math.min(maxNegative[i - 1] * nums[i], nums[i]));
      result = Math.max(maxPositive[i], result);
    }
    return result;
  }
}
