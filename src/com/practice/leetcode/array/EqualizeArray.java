package com.practice.leetcode.array;

import java.util.Arrays;

public class EqualizeArray {
    public static void main(String[] args) {
        EqualizeArray me = new EqualizeArray();
        int[] nums={1,2,3,4};
        System.out.println(me.getCount(nums));
    }
    public int getCount(int[] nums){
        Arrays.sort(nums);
        int count=0;
        int mid = nums.length/2;
        for(int i=0;i<nums.length;i++){
            count += Math.abs(nums[i]-nums[mid]);
        }
        return count;
    }
}
