/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/10/21, 6:41 PM
 * =========================================
 */

package com.practice.serious;

public class SplitArrayLargestSum {
  public static void main(String[] args) {
    SplitArrayLargestSum me = new SplitArrayLargestSum();
    System.out.println(me.splitArray(new int[] {7, 2, 5, 10, 8}, 2));
  }

  public int splitArray(int[] nums, int m) {
    int left = 0, right = 0;
    for (int num : nums) {
      left = Math.max(left, num);
      right += num;
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (count(mid, nums) > m) left = mid + 1;
      else right = mid;
    }
    return left;
  }

  public int count(int target, int[] nums) {
    int ret = 0, cur = 0;
    for (int num : nums) {
      if (cur + num > target) {
        ret += 1;
        cur = num;
      } else {
        cur += num;
      }
    }
    return ret + 1;
  }
}
