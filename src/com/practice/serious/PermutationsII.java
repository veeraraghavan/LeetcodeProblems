/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/14/21, 12:33 AM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
  public static void main(String[] args) {
    PermutationsII me = new PermutationsII();
    me.permuteUnique(new int[] {1, 1, 2});
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    dfs(result, nums, new boolean[nums.length], new ArrayList<>());
    return result;
  }

  public void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> list) {
    if (list.size() == nums.length) {
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
      list.add(nums[i]);
      used[i] = true;
      dfs(res, nums, used, list);
      used[i] = false;
      list.remove(list.size() - 1);
    }
  }
}
