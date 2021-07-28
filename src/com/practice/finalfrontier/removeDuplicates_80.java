/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   5/27/21, 10:59 PM
 * =========================================
 */

package com.practice.finalfrontier;

public class removeDuplicates_80 {
  public static void main(String[] args) {
    removeDuplicates_80 me = new removeDuplicates_80();
  }

  public int removeDuplicates(int[] nums) {
    // Use 2 pointer approach
    int i = 1, j = 1, count = 1;
    while (i < nums.length) {
      if (nums[i] == nums[i - 1]) {
        count++;
      } else {
        count = 1;
      }
      if (count <= 2) {
        nums[j++] = nums[i];
      }
      i++;
    }
    return j;
  }
}
