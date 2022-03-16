/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   12/31/21, 7:45 AM
 * =========================================
 */

package com.practice.lastdance;

public class houserobber {
  public static void main(String[] args) {
    houserobber me = new houserobber();
  }

  public int rob(int[] nums) {
    return dp(nums.length - 1, new Integer[nums.length], nums);
  }

  public int dp(int n, Integer[] res, int[] nums) {

    if (res[n] != null) return res[n];
    if (n == 0) {
      res[n] = nums[0];
      return nums[0];
    }
    if (n == 1) {
      res[1] = Math.max(nums[0], nums[1]);
      return res[1];
    }
    res[n] = Math.max(nums[n] + dp(n - 2, res, nums), dp(n - 1, res, nums));
    return res[n];
  }
}
