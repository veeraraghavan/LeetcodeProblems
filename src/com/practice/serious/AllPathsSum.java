/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 5:00 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSum {
  public static void main(String[] args) {
    AllPathsSum me = new AllPathsSum();
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    CalculatePathSum(root, targetSum, result, temp);
    return result;
  }

  private void CalculatePathSum(
      TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> temp) {
    if (root == null) return;
    if (root.val == targetSum && root.left == null && root.right == null) {
      temp.add(root.val);
      result.add(temp);
      return;
    }
    List<Integer> tempLeft = new ArrayList<>(temp);
    tempLeft.add(root.val);
    CalculatePathSum(root.left, targetSum - root.val, result, tempLeft);
    List<Integer> tempRight = new ArrayList<>(temp);
    tempRight.add(root.val);
    CalculatePathSum(root.right, targetSum - root.val, result, tempRight);
  }
}
