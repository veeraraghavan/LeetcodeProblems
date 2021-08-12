/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 6:55 PM
 * =========================================
 */

package com.practice.serious;

public class SubArrayProductLessK {
  public static void main(String[] args) {
    SubArrayProductLessK me = new SubArrayProductLessK();
    System.out.println(
        me.numSubarrayProductLessThanK(
            new int[] {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
  }

  private int numSubarrayProductLessThanK(int[] nums, int k) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res += getCount(nums, i, nums.length, k);
    }
    return res;
  }

  private int getCount(int[] nums, int start, int end, int target) {
    int product = 1;
    int count = 0;
    for (int i = start; i < end; i++) {
      product *= nums[i];
      if (product < target) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }
}
