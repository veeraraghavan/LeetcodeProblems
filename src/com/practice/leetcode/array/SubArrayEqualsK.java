package com.practice.leetcode.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArrayEqualsK {
    public static void main(String[] args) {
        SubArrayEqualsK me = new SubArrayEqualsK();
        int[] nums = {1, 1, 1,1};
        System.out.println(me.SubArrayEqualsK(nums, 2));
    }

    public int SubArrayEqualsK(int[] arr, int sum) {
        int n = arr.length;
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;

        // Sum of elements so far.
        int currsum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currsum += arr[i];

            // If currsum is equal to desired sum,
            // then a new subarray is found. So
            // increase count of subarrays.
            if (currsum == sum)
                res++;

            // currsum exceeds given sum by currsum
            //  - sum. Find number of subarrays having
            // this sum and exclude those subarrays
            // from currsum by increasing count by
            // same amount.
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);


            // Add currsum value to count of
            // different values of sum.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }

        return res;
    }
}
