/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/16/21, 10:54 PM
 * =========================================
 */

package com.practice.serious;

public class MaxPathSum {

  public static void main(String[] args) {
    MaxPathSum me = new MaxPathSum();
    TreeNode input = new TreeNode(1);
    input.left = new TreeNode(2);
    input.right = new TreeNode(3);
    me.maxPathSum(input);
  }

  private int max = 0;

  private int maxPathSum(TreeNode root) {
    recurse(root);
    return max;
  }

  private int recurse(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = Math.max(recurse(root.left), 0);
    int right = Math.max(recurse(root.right), 0);
    int new_price = left + right + root.val;
    max = Math.max(max, new_price);
    return Math.max(left, right) + root.val;
  }
}
