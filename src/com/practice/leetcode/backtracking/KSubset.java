package com.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class KSubset {
    public static void main(String[] args) {
        KSubset me = new KSubset();
        int[] input = {1, 2, 3};
        me.combine(4,2);
    }

    public List<List<Integer>> combine(int n,int k) {
        List<List<Integer>> result = new ArrayList<>();
        subset(1, n, new ArrayList<Integer>(), result, k);
        return result;

    }

    public void subset(int index, int n, ArrayList<Integer> currentString, List<List<Integer>> result,int k) {
        if(currentString.size()==k)
            result.add(new ArrayList<Integer>(currentString));
        for (int i = index; i <= n; i++) {
            currentString.add(i);
            subset(i + 1, n, currentString, result,k);
            currentString.remove(currentString.size() - 1);
        }

    }
}
