/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/20/21, 11:01 PM
 * =========================================
 */

package com.practice.serious;

public class MaximumSumIncreasingSubsequence {
  public static void main(String[] args) {
    MaximumSumIncreasingSubsequence me = new MaximumSumIncreasingSubsequence();
    System.out.println(me.findMSIS(new int[] {-4, 10, 3, 7, 15}));
  }

  private int findMSIS(int[] nums) {
    int[] res = new int[nums.length];
    res[0] = nums[0];
    int result = 0;
    for (int i = 1; i < nums.length; i++) {
      res[i] = nums[i];
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && res[i] < (res[j] + nums[i])) {
          res[i] = res[j] + nums[i];
        }
      }
      result = Math.max(res[i], result);
    }
    return result;
  }
}
