/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 6:19 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class ThreeSumSmaller {
  public static void main(String[] args) {
    ThreeSumSmaller me = new ThreeSumSmaller();
    System.out.println(
        me.threeSumSmaller(new int[] {3, 2, -2, 6, 2, -2, 6, -2, -4, 2, 3, 0, 4, 4, 1}, 3));
  }

  private int threeSumSmaller(int[] nums, int target) {
    int res = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {

      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < target) {
          res += k - j;
          j++;
        } else {
          k--;
        }
      }
    }
    return res;
  }
}
