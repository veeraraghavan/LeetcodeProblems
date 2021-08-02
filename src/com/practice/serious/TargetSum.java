/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/1/21, 9:46 PM
 * =========================================
 */

package com.practice.serious;

public class TargetSum {
  private int count = 0;

  public static void main(String[] args) {
    TargetSum me = new TargetSum();
    System.out.println(me.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
  }

  private int findTargetSumWays(int[] nums, int S) {
    recurse(nums, S, 0, 0);
    return count;
  }

  private void recurse(int[] nums, int S, int sum, int index) {
    if (sum == S && index == nums.length) {
      count++;
    }
    if (index == nums.length) return;

    recurse(nums, S, sum + nums[index], index + 1);
    recurse(nums, S, sum - nums[index], index + 1);
  }
}
