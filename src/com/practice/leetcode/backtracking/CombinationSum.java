package com.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] input = {2, 3, 6, 7};
        int n = 7;
        CombinationSum me = new CombinationSum();
        me.combinationSum(input, n);
        System.out.println(me);
    }

    //    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> intermediate = new ArrayList<>();
//        recursive(candidates, 0, target, intermediate, result, 0);
//        return result;
//
//    }
//
//    public void recursive(int[] candidates, int currentCount, int target, List<Integer> intermediate, List<List<Integer>> result, int start) {
////        if (currentCount == target) {
////            intermediate.add(value);
////            result.add(intermediate);
////            return;
////        } else if (currentCount > target) {
////            return;
////        } else {
////            for (int j = 0; j < candidates.length; j++) {
////                recursive(candidates, currentCount + candidates[j], target, intermediate, result, candidates[j]);
////            }
////        }
//        if (target > 0) {
//            for (int i = start; i < candidates.length && currentCount + candidates[i] < target; i++) {
//                intermediate.add(candidates[i]);
//                recursive(candidates, currentCount + candidates[i], target - candidates[i], intermediate, result, i);
//                intermediate.remove(intermediate.size() - 1);
//            }
//
//
//        } else if (target == 0) {
//            result.add(intermediate);
//            return;
//        }
//
//
//    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        }//if
        else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
        }//else if
    }

}

