package com.practice.leetcode.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArrayEqualsK {
    public static void main(String[] args) {
        SubArrayEqualsK me = new SubArrayEqualsK();
        int[] nums = {1, 1, 1,1};
        System.out.println(me.SubArrayEqualsK(nums, 2));
        nums = new int[]{1};
        System.out.println(me.SubArrayEqualsK(nums, 0));
        nums = new int[]{-1,-1,1};
        System.out.println(me.SubArrayEqualsK(nums, 0));
    }

    public int SubArrayEqualsK(int[] arr, int sum) {

        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum == sum)
                result++;
            if (countMap.containsKey(currSum - sum)) {
                result += countMap.get((currSum - sum));
            }
            if (!countMap.containsKey(currSum))
                countMap.put(currSum, 1);
            else
                countMap.put(currSum, countMap.get(currSum) + 1);

        }
        return result;
    }
}
