/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   5/26/21, 10:33 PM
 * =========================================
 */

package com.practice.finalfrontier;

public class FirstLast_34 {
  // Logic make the first move to find the first occurrence.Generally keep moving towards one side
  // As soon as not found
  public static void main(String[] args) {
    FirstLast_34 me = new FirstLast_34();
    me.searchRange(new int[] {5, 7, 7, 8, 9, 10}, 8);
  }

  private int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = getIndex(nums, target, true);
    if (res[0] == -1) {
      res[1] = -1;
      return res;
    }
    res[1] = getIndex(nums, target, false);
    return res;
  }

  private int getIndex(int[] nums, int target, boolean first) {
    int low = 0, high = nums.length - 1, mid = 0;
    boolean notHit = true;
    while (low <= high) {
      mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        notHit = false;
        if (first) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return notHit ? -1 : first ? low : high;
  }
}
