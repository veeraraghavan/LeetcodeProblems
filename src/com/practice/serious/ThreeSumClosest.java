/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/30/21, 4:39 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class ThreeSumClosest {
  public static void main(String[] args) {
    ThreeSumClosest me = new ThreeSumClosest();
  }

  public int threeSumClosest(int[] nums, int target) {

    Arrays.sort(nums);
    int result = 0;
    int n = nums.length - 1;
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 2; i++) {
      while (i > 0 && nums[i - 1] == nums[i] && i < n) i++;
      int j = i + 1, k = n;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == target) return target;
        int distance = sum - target;
        if (distance > 0) {
          k--;
        } else {
          j++;
        }
        if (Math.abs(distance) < diff) {
          diff = Math.abs(distance);
          result = sum;
        }
      }
    }
    return result;
  }
}
