/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/30/21, 4:08 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/3sum/
public class Threesum {
  public static void main(String[] args) {
    Threesum me = new Threesum();
    me.threeSum(new int[] {0, 0, 0, 0});
  }

  private List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length - 1;
    for (int i = 0; i < nums.length - 2; i++) {
      while (i > 0 && nums[i - 1] == nums[i] && i < n) i++;
      int j = i + 1, k = n;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[i]);
          temp.add(nums[j]);
          temp.add(nums[k]);
          result.add(temp);
          j++;
          while (j < k && nums[j] == nums[j - 1] && j < n) j++;
        } else if (sum < 0) {
          j++;
        } else {
          k--;
        }
      }
    }
    return result;
  }
}
