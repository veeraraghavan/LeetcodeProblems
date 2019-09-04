package com.practice.playground.string;

class Solution {
    public static void main(String[] args) {
        Solution me = new Solution();
        int[] input = {10, 5, 2, 6};
        System.out.println(me.numSubarrayProductLessThanK(input, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int count = 0;
        int product=1;
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            product*=nums[i];
            while(product>=k && j<nums.length)
                product/=nums[j++];
            if(i-j>=0)
                count+=i-j+1;
        }

        return count;


    }
}