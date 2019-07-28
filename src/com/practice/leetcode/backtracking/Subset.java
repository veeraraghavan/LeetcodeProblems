package com.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        Subset me = new Subset();
        int[] input = {1, 2, 3};
        me.subsets(input);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subset(0, nums, new ArrayList<Integer>(), result);
        return result;

    }

    public void subset(int index, int[] nums, ArrayList<Integer> currentString, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(currentString));
        for (int i = index; i < nums.length; i++) {
            currentString.add(nums[i]);
            subset(i + 1, nums, currentString, result);
            currentString.remove(currentString.size() - 1);
        }

    }
}
