/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/31/21, 5:51 AM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public static void main(String[] args) {
    FourSum me = new FourSum();
    me.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);
  }

  private List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return getList(nums, 4, 0, target);
  }

  // The inputs are array, the Kth sum we need, the index of the array we need to start from
  // the target we need to achieve our sum from
  private List<List<Integer>> getList(int[] nums, int k, int index, int target) {
    List<List<Integer>> result = new ArrayList<>();
    // Calculate 2 sum if k==2
    if (k == 2) {
      int low = index;
      int high = nums.length - 1;
      while (low < high) {
        int sum = nums[low] + nums[high];
        if (sum == target) {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[low]);
          temp.add(nums[high]);
          result.add(temp);
          while (low < high && nums[low + 1] == nums[low]) low++;
          while (low < high && nums[high - 1] == nums[high]) high--;
          low++;
          high--;
        } else if (sum < target) {
          low++;
        } else {
          high--;
        }
      }

    } else {
      // The last index where we can get K sum is length-(k-1)
      // Eg nums = [0,1,3,4,56,2,45,2]  length = 8
      // k = 4 we need 4 sum, hence the last element for outer most
      // for loop is 56 (index=4 start from 0 index )
      for (int i = index; i < nums.length - (k - 1); i++) {
        // Suppose two elements are same , keep increment i to avoid duplicates
        if (i > index && nums[i] == nums[i - 1]) continue;
        List<List<Integer>> temp = getList(nums, k - 1, i + 1, target - nums[i]);
        for (List<Integer> list : temp) {
          list.add(0, nums[i]);
        }
        result.addAll(temp);
      }
    }
    return result;
  }
}
