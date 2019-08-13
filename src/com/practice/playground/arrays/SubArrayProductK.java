package com.practice.playground.arrays;

public class SubArrayProductK {
    public static void main(String[] args) {
        SubArrayProductK me = new SubArrayProductK();
        int[] input = {1,1,1};
        System.out.println(me.numSubarrayproductLessThanK(input, 1));
    }

    public int numSubarrayproductLessThanK(int[] nums, int k) {
        if (k == 0)
            return k;
        int count = 0;
        int[] product = new int[nums.length];
        if (nums[0] < k) {
            product[0] = nums[0];
            count++;
        }
        int i = 1;
        while (i < nums.length) {
            if (i > 1) {
                if (nums[i] < k) {
                    count++;
                    product[i] = nums[i];
                }
                if (product[i - 1] * nums[i] < k) {
                    count++;
                    product[i] = product[i - 1] * nums[i];
                }
                if ((product[i-2]!=0)&&(((product[i - 1] / product[i - 2]) * nums[i])) < k) {
                    count++;
                    if (product[i] == nums[i])
                        product[i] = product[i - 1] / product[i - 1] * nums[i];
                }
            } else {
                if (nums[i] < k) {
                    count++;
                    product[i] = nums[i];
                }
                if (product[i - 1] * nums[i] < k) {
                    count++;
                    product[i] = product[i - 1] * nums[i];
                }
            }
            i++;
        }
        return count;

    }
}
