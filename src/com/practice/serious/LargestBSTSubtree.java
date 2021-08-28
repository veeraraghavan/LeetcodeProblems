/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/27/21, 11:35 AM
 * =========================================
 */

package com.practice.serious;

public class LargestBSTSubtree {

  public static void main(String[] args) {
    LargestBSTSubtree me = new LargestBSTSubtree();
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(8);
    root.right = new TreeNode(15);
    root.right.right = new TreeNode(7);
    me.largestBSTSubtree(root);
  }

  private int largestBSTSubtree(TreeNode root) {
    int res[] = largestBST(root);
    return res[2];
  }

  private int[] largestBST(TreeNode root) {
    if (root == null) {
      return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
    }
    int[] left = largestBST(root.left);
    int[] right = largestBST(root.right);

    if (root.val > left[1] && root.val < right[0]) {
      return new int[] {
        Math.min(root.val, left[0]), Math.max(right[1], root.val), left[2] + right[2] + 1
      };
    } else {
      return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
    }
  }
}
