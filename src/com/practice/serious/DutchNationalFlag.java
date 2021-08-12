/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 7:31 PM
 * =========================================
 */

package com.practice.serious;

public class DutchNationalFlag {
  public static void main(String[] args) {
    DutchNationalFlag me = new DutchNationalFlag();
  }

  public void sortColors(int[] nums) {
    int low = 0, high = nums.length - 1;
    //    while (low < high) {
    //      if (nums[low] == 0) {
    //        low++;
    //      } else if (nums[low] == 1) {
    //        low++;
    //      } else {
    //        swap(nums, low, high);
    //        high--;
    //      }
    //    }
    for (int i = 0; i <= high; ) {
      if (nums[i] == 0) {
        swap(nums, i, low);
        low++;
        i++;
      } else if (nums[i] == 1) {
        i++;
      } else {
        swap(nums, low, high);
        high--;
      }
    }
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
