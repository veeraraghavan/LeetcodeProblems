/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/7/21, 6:31 PM
 * =========================================
 */

package com.practice.serious;
// https://leetcode.com/problems/running-sum-of-1d-array/
public class RunningSum {
  public static void main(String[] args) {
    RunningSum me = new RunningSum();
  }

  public int[] runningSum(int[] nums) {
    int res[] = new int[nums.length];
    res[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      res[i] = nums[i] + res[i - 1];
    }
    return res;
  }
}
