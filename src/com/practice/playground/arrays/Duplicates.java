package com.practice.playground.arrays;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public static void main(String[] args) {
        Duplicates me = new Duplicates();
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(me.findDuplicates(input));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add(i + 1);
        }
        return result;

    }
}
