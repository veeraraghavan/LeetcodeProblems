package com.practice.leetcode.array;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateNumber {
    public static void main(String[] args) {
        DuplicateNumber me = new DuplicateNumber();
        int[] nums = {1, 3,4,2, 2};
        System.out.println(me.findDuplicate(nums));
    }

    public int findDuplicate(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return -1;

        // initialize fast and slow
        int slow = arr[0];
        int fast = arr[arr[0]];

        // loop to enter in the cycle
        while (fast != slow) {

            // move one step for slow
            slow = arr[slow];

            // move two step for fast
            fast = arr[arr[fast]];
        }

        // loop to find entry
        // point of the cycle
        slow = 0;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;

    }
}
