package com.practice.playground.dp;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] input ={10,9,2,5,3,7,101,18};
        LIS me = new LIS();
        System.out.println(me.lengthOfLIS(input));
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] subSequence = new int[nums.length];
        Arrays.fill(subSequence,1);

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    subSequence[i] = Math.max(subSequence[j] + 1, subSequence[i]);
                if (count < subSequence[i])
                    count = subSequence[i];
            }
        }
        return count;

    }
}
