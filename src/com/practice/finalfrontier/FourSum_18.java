/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/5/21, 10:28 PM
 * =========================================
 */

package com.practice.finalfrontier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
  public static void main(String[] args) {
    FourSum_18 me = new FourSum_18();
    me.fourSum(new int[] {2, 2, 2, 2, 2}, 8);
  }

  private void getSets(
      int[] nums,
      int target,
      int first,
      int second,
      int third,
      int fourth,
      List<List<Integer>> result) {
    if ((first >= second) || (second >= third) || (third >= fourth)) {
      return;
    }
    if (nums[first] + nums[second] + nums[third] + nums[fourth] == target) {
      List<Integer> temp = new ArrayList<>();
      temp.add(nums[first]);
      temp.add(nums[second]);
      temp.add(nums[third]);
      temp.add(nums[fourth]);
      result.add(new ArrayList(temp));
    }
    if (first + 1 < second) {
      getSets(nums, target, first + 1, second, third, fourth, result);
    }
    getSets(nums, target, first, second + 1, third, fourth, result);
    getSets(nums, target, first, second, third - 1, fourth, result);
    if (fourth - 1 > third) {
      getSets(nums, target, first, second, third, fourth - 1, result);
    }
  }

  private List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList();
    Arrays.sort(nums);
    // getSets(nums, target, 0, 1, nums.length - 2, nums.length - 1, result);
    result = getLists(nums, 4, 0, target);
    return result;
  }

  private List<List<Integer>> getLists(int[] nums, int k, int index, int target) {

    // solve a 2 sum
    List<Integer> temp = null;
    List<List<Integer>> result = new ArrayList<>();
    if (k == 2) {
      int low = index, high = nums.length - 1;
      while (low < high) {
        if (target == nums[low] + nums[high]) {
          temp = new ArrayList();
          temp.add(nums[low]);
          temp.add(nums[high]);
          result.add(temp);
          while (low < high && nums[low + 1] == nums[low]) low++;
          while (low < high && nums[high - 1] == nums[high]) high--;
          low++;
          high--;
        } else if (nums[low] + nums[high] < target) {
          low++;
        } else {
          high--;
        }
      }
    } else {
      for (int i = index; i < nums.length - (k - 1); i++) {
        if (i > index && nums[i] == nums[i - 1]) continue;
        List<List<Integer>> tempRes = getLists(nums, k - 1, i + 1, target - nums[i]);
        for (List<Integer> each : tempRes) {
          each.add(0, nums[i]);
        }
        result.addAll(tempRes);
      }
    }
    return result;
  }
}
