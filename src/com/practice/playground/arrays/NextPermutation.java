package com.practice.playground.arrays;

import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        int[] input = {1,1};
        NextPermutation me = new NextPermutation();
        me.nextPermutation(input);
        System.out.println("me.nextPermutation(input)");
    }

    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0 && nums[i+1]<=nums[i]) i--;
        if(i>=0){
            int j=nums.length-1;
            while(j>=0 && nums[j]<=nums[i])j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    public void swap(int[] nums,int i,int j){
        nums[i]=nums[i]+nums[j];
        nums[j]=nums[i]-nums[j];
        nums[i]=nums[i]-nums[j];
    }
    public void reverse(int[] nums,int start){
        int i=start,j=nums.length-1;
        while(i<j){
            nums[i]=nums[i]+nums[j];
            nums[j]=nums[i]-nums[j];
            nums[i]=nums[i]-nums[j];
            i++;j--;
        }
    }

}
