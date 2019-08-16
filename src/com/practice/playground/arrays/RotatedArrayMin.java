package com.practice.playground.arrays;

public class RotatedArrayMin {
    public static void main(String[] args) {
        RotatedArrayMin me = new RotatedArrayMin();
        int nums[] = {6, 7, 1, 2, 3, 4, 5,};
        System.out.println(me.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums.length == 0) return 1;
        if (nums.length == 1) return nums[0];

        int low = 0, high = nums.length - 1, mid = 0;
        if (nums[low] < nums[high])
            return nums[low];
        int i=0;
        while (low < high) {
            System.out.println(++i);
            mid = (low + high) / 2;

            if(nums[mid]>nums[mid+1]) return nums[mid+1];
            if(nums[mid-1]>nums[mid]) return nums[mid];


            if (nums[low] > nums[mid]) {
//                if (nums[mid] > nums[mid + 1])
//                    return nums[mid];
                high = mid - 1;


            } else {
                low = mid + 1;

            }

        }
        return -1;
    }
}
