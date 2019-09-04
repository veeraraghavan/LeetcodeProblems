package com.practice.leetcode.array;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] input = {3, 4, 5, 1, 2};
        RotatedSortedArray me = new RotatedSortedArray();
        System.out.println(me.findMin(input));
    }
//Points to remember
//Find the mid element and check if next element is lesser-> if yes that is the inflection point
//Find the previous element for inflection point (why next element is compared before previous)
//Mid tends to become zero in smaller arrays.
//
//
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if (nums[i] > nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }

        }
        return -1;


    }
}
