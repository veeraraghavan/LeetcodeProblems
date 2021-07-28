/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/29/20, 5:10 PM
 * =========================================
 */

package com.practice.grokprog.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
  public static void main(String[] args) {
    Permutation me = new Permutation();
    List<List<Integer>> result = me.findPermutations(new int[] {1, 3, 5});
    System.out.print("Here are all the permutations: " + result);
  }

  private void generatePerm(List<Integer> list, int[] nums, List<List<Integer>> result) {
    if (list.size() == nums.length) {
      result.add(list);
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (list.contains(nums[i])) {
        continue;
      }
      ArrayList<Integer> temp = new ArrayList<>(list);
      temp.add(nums[i]);
      generatePerm(temp, nums, result);
      // Character.isLetter()
      // temp.remove(nums[i]);
    }
  }

  private List<List<Integer>> findPermutations(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    generatePerm(new ArrayList<>(), nums, result);
    return result;
  }
}
