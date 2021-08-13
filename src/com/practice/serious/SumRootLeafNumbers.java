/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 5:13 PM
 * =========================================
 */

package com.practice.serious;

public class SumRootLeafNumbers {
  public static void main(String[] args) {
    SumRootLeafNumbers me = new SumRootLeafNumbers();
  }

  public int sumNumbers(TreeNode root) {
    return recurse(root, 0);
  }

  private int recurse(TreeNode root, int prev) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
      return (prev * 10) + root.val;
    }
    return recurse(root.left, prev * 10 + root.val) + recurse(root.right, prev * 10 + root.val);
  }
}
