package com.practice.leetcode.array;
//https://leetcode.com/problems/find-pivot-index/submissions/
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums={-1,-1,-1,0,1,1};
        PivotIndex me = new PivotIndex();
        System.out.println(me.pivotIndex(nums));
    }
    public int pivotIndex(int[] nums){
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        for(int i=0;i<nums.length;i++){
            int leftSum = 0;
            if(i==0)
                leftSum=0;
            else
                leftSum = nums[i-1];
            if(leftSum==nums[nums.length-1]-nums[i])
                return i;
        }
        return -1;
//        for(int i=0;i<nums.length;i++){
//            int leftSum =0,rightSum=0;
//            for(int j=0;j<i;j++){
//                leftSum+=nums[j];
//            }
//            for(int k=i+1;k<nums.length;k++){
//                rightSum+=nums[k];
//            }
//            if(leftSum==rightSum)
//                return i;
//        }
        //return -1;

    }
}
