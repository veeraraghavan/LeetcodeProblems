/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 4:46 PM
 * =========================================
 */

package com.practice.serious;

public class HasPathSum {
  public static void main(String[] args) {
    HasPathSum me = new HasPathSum();
  }

  private boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    if (targetSum == root.val && root.left == null && root.right == null) return true;
    return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
  }
}
