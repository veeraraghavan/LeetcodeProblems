/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/31/21, 8:52 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
  public static void main(String[] args) {
    SubsetsII me = new SubsetsII();
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int subsetSize = 0;
    for (int i = 0; i < nums.length; i++) {
      int startingIndex = (i > 0 && nums[i] == nums[i - 1]) ? subsetSize : 0;
      subsetSize = result.size();
      for (int j = startingIndex; j < subsetSize; j++) {
        List<Integer> temp = new ArrayList<>(result.get(j));
        temp.add(nums[i]);
        result.add(temp);
      }
    }

    return result;
  }
}
