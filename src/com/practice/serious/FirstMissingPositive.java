/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/30/21, 12:07 AM
 * =========================================
 */

package com.practice.serious;

public class FirstMissingPositive {
  public static void main(String[] args) {
    FirstMissingPositive me = new FirstMissingPositive();
    me.firstMissingPositive(new int[] {1, 3, -2, 4});
  }

  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) return 1;
    int lastPositiveindex = partition(nums) + 1;

    for (int i = 0; i < lastPositiveindex; i++) {
      int k = Math.abs(nums[i]);
      if (k <= lastPositiveindex) {
        nums[k - 1] = (nums[k - 1] < 0) ? nums[k - 1] : -nums[k - 1];
      }
    }
    for (int i = 0; i < lastPositiveindex; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return lastPositiveindex + 1;
  }

  public int partition(int[] nums) {
    int j = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        j++;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
    return j;
  }
}
