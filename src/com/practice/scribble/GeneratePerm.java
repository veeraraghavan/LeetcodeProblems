package com.practice.scribble;

import java.util.*;

public class GeneratePerm {
  public static void main(String[] args) {
    //    GeneratePerm me = new GeneratePerm();
    //    System.out.println(me.permute2(new int[] {1, 2, 3}));
    List<List<Integer>> result = GeneratePerm.findPermutations(new int[] {1, 3, 5});
    System.out.print("Here are all the permutations: " + result);
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    generatePerm(nums, 0, new ArrayList(), result, "");
    return result;
  }

  public void generatePerm(
      int[] nums, int index, List<Integer> list, List<List<Integer>> result, String text) {
    if (index == nums.length) {
      result.add(list);
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!contains(list, nums[i])) continue;
      List<Integer> temp = new ArrayList(list);
      temp.add(nums[i]);
      text += nums[i];
      generatePerm(nums, index + 1, temp, result, text);
    }
  }

  public boolean contains(List<Integer> list, int value) {
    for (int a : list) {
      if (a == value) return false;
    }
    return true;
  }

  public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
    // if all integers are used up
    if (first == n) output.add(new ArrayList<Integer>(nums));
    for (int i = first; i < n; i++) {
      // place i-th integer first
      // in the current permutation
      Collections.swap(nums, first, i);
      // use next integers to complete the permutations
      backtrack(n, nums, output, first + 1);
      // backtrack
      Collections.swap(nums, first, i);
    }
  }

  public List<List<Integer>> permute2(int[] nums) {
    // init output list
    List<List<Integer>> output = new LinkedList<>();

    // convert nums into list since the output is a list of lists
    ArrayList<Integer> nums_lst = new ArrayList<Integer>();
    for (int num : nums) nums_lst.add(num);

    int n = nums.length;
    backtrack(n, nums_lst, output, 0);
    return output;
  }

  public static List<List<Integer>> findPermutations(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<List<Integer>> permutations = new LinkedList<>();
    permutations.add(new ArrayList<>());
    for (int currentNumber : nums) {
      // we will take all existing permutations and add the current number to create new
      // permutations
      int n = permutations.size();
      for (int i = 0; i < n; i++) {
        List<Integer> oldPermutation = permutations.poll();
        // create a new permutation by adding the current number at every position
        for (int j = 0; j <= oldPermutation.size(); j++) {
          List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
          newPermutation.add(j, currentNumber);
          if (newPermutation.size() == nums.length) result.add(newPermutation);
          else permutations.add(newPermutation);
        }
      }
    }
    return result;
  }
}
