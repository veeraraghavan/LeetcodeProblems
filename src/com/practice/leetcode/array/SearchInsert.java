package com.practice.leetcode.array;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=4;
        SearchInsert me = new SearchInsert();
        me.searchInsert(nums,target);
    }
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;

    }
}
