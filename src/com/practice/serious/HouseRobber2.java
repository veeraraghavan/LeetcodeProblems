/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/4/21, 2:30 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class HouseRobber2 {
  public static void main(String[] args) {
    HouseRobber2 me = new HouseRobber2();
    System.out.println(me.rob(new int[] {1, 2, 3, 1}));
  }

  public int rob(int[] nums) {
    return Math.max(
        houseRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
        houseRob(Arrays.copyOfRange(nums, 1, nums.length)));
  }

  public int houseRob(int[] nums) {
    int prev1 = 0, prev2 = 0, current = 0;
    if (nums.length == 1) return nums[0];
    if (nums.length == 0) return 0;
    prev2 = nums[0];
    prev1 = nums[0] > nums[1] ? nums[0] : nums[1];
    if (nums.length == 2) return prev2 > prev1 ? prev2 : prev1;
    for (int i = 2; i < nums.length; i++) {
      current = Math.max(prev2 + nums[i], prev1);
      prev2 = prev1;
      prev1 = current;
    }
    return current;
  }
}
