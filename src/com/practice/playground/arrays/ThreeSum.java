package com.practice.playground.arrays;

import javafx.collections.transformation.TransformationList;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum me = new ThreeSum();
        int[] input = {-1, 0, 1, 2, -1, -4};
        me.threeSum(input);
        input = new int[]{0, 0, 0};
        me.threeSum(input);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    results.add(temp);
                    j++;
                    while (j < k && nums[j-1] == nums[j]) j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }

        return results;
    }

}
