/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/29/21, 11:34 PM
 * =========================================
 */

package com.practice.serious;

public class FindMinimum {
  public static void main(String[] args) {
    FindMinimum me = new FindMinimum();
  }

  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > nums[high]) {
        low = mid + 1;
      } else if (nums[mid] < nums[high]) {
        high = mid;
      } else {
        high = high - 1;
      }
    }
    return nums[low];
  }
}
