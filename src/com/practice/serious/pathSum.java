/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/16/21, 11:44 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class pathSum {

  public static void main(String[] args) {
    pathSum me = new pathSum();
    System.out.println(me.pathSum(new int[] {113, 215, 221}));
  }

  private int ans = 0;

  private int pathSum(int[] nums) {
    Arrays.sort(nums);
    int level = getLevel(nums);
    int[] input = new int[(int) (Math.pow(2, level))];
    Arrays.fill(input, -1);
    createInputArray(nums, input);
    if (level == 1) return input[0];
    dfs(input, 1, 0, 0, level);
    return ans;
  }

  private void createInputArray(int[] nums, int[] input) {
    for (int num : nums) {
      int level = (num / 100) - 1;
      int pos = ((num / 10) % 10) - 1;
      input[2 * level + pos] = num % 10;
    }
  }

  private int getLevel(int[] nums) {
    int max = nums[nums.length - 1];
    return max / 100;
  }

  private void dfs(int[] input, int level, int index, int sum, int totalLevel) {
    if (level > totalLevel) {
      ans += sum;
      return;
    }
    int leftChild = 2 * index + 1;
    int rightChild = 2 * index + 2;
    if (input[leftChild] != -1 && input[rightChild] != -1) {
      ans += input[index];
    }
    dfs(input, level + 1, leftChild, sum + input[index], totalLevel);
    dfs(input, level + 1, rightChild, sum + input[index], totalLevel);
  }
}
