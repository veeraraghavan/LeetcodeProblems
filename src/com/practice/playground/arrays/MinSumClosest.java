package com.practice.playground.arrays;

import java.util.Arrays;

public class MinSumClosest {
  public static void main(String[] args) {
    int[] input = {1, 1, -1, -1, 3};
    MinSumClosest me = new MinSumClosest();
    System.out.println(me.threeSumClosest(input, -1));
  }

  /* Idea similar to 3 sum.2 core logic
  when sum of 3 elements equal to target=>code uses same technique as 3Sum.
  When sum greater than target decrement k else increment j
  store the combination of sum and difference of sum and target.
  In case we dont get a target==sum condition return the minSum;
   */
  private int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int diff = Integer.MAX_VALUE;
    int minSum = 0;
    int distance = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        int tempSum = (nums[i] + nums[j] + nums[k]);
        distance = tempSum - target;

        if (distance == 0) return tempSum;
        if (distance > 0) k--;
        else j++;
        if (diff > Math.abs(distance)) {
          diff = Math.abs(distance);
          minSum = tempSum;
        }
      }
    }
    return minSum;
  }
}
