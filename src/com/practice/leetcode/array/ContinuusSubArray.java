package com.practice.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ContinuusSubArray {
    public static void main(String[] args) {
        ContinuusSubArray me = new ContinuusSubArray();
        int[] nums = {5,0,0};
        System.out.println(me.checkSubarraySum(nums, 0));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
//        if (k == 0 && nums.length > 0)
//            return false;
        if (nums == null || nums.length < 2) {
            return false;
        }

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < preSum.length; i++) {

            int res = preSum[i];
            if (k != 0) {
                res = preSum[i] % k;
            }
            if (map.containsKey(res) && (i - map.get(res)) > 1) {
                return true;
            }

            if (!map.containsKey(res)) {
                map.put(res, i);
            }
        }

        return false;
    }
}
