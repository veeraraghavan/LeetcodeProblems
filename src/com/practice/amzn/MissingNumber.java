package com.practice.amzn;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber me = new MissingNumber();
        System.out.println(me.missingNumber(new int[]{1, 0, 3}));
    }

    public int missingNumber(int[] nums) {
        //Using XOR
        int result = nums.length;
        int i=0;
        for(int num:nums){
            result ^= num^i;
            i++;
        }
        return result;
    }

}
