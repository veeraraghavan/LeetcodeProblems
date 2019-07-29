package com.practice.leetcode.array;

//https://leetcode.com/problems/maximum-subarray/
public class maxSubArray {
    public static void main(String[] args) {
        maxSubArray me = new maxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(me.maxSubArray2(nums));
    }

    public int maxSubArray(int[] nums) {
        int[][] result = new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            result[i][i] = nums[i];
            if (nums[i] > max) {
                max = nums[i];

            }

            for (int j = i + 1; j < nums.length; j++) {
                int temp = result[i][j - 1] + nums[j];
                result[i][j] = temp;
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;


    }

    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];

        int max = Integer.MIN_VALUE;
        if (max < result[0])
            max = result[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(result[i - 1] + nums[i], nums[i]);
            if (max < result[i]) {
                max = result[i];
            }
        }
        return max;

    }

    public int maxSubRecurse(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        return 0;
    }
}
