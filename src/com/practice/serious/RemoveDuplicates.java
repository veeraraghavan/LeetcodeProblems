/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/31/21, 7:20 AM
 * =========================================
 */

package com.practice.serious;

public class RemoveDuplicates {
  public static void main(String[] args) {
    RemoveDuplicates me = new RemoveDuplicates();
  }

  public int removeDuplicates(int[] nums) {
    int index = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) continue;
      nums[index++] = nums[i];
    }
    return index;
  }
}
