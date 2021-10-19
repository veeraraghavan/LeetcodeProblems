/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/17/21, 12:59 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class NextPermutation {
  public static void main(String[] args) {
    NextPermutation me = new NextPermutation();
    me.nextPermutation(new int[] {1, 3, 2});
  }

  public void nextPermutation(int[] nums) {
    int end = nums.length - 2;
    while (end >= 0 && nums[end] > nums[end + 1]) end--;
    if (end == -1) {
      Arrays.sort(nums);
    } else {
      Arrays.sort(nums, end + 1, nums.length);
      for (int i = end + 1; i < nums.length; i++) {
        if (nums[i] > nums[end]) {
          swap(nums, end, i);
          break;
        }
      }
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
