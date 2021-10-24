/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/23/21, 1:07 PM
 * =========================================
 */

package com.practice.serious;

public class Flatten {
  public static void main(String[] args) {
    Flatten me = new Flatten();
    TreeNode input = new TreeNode(1);
    input.left = new TreeNode(2);
    input.right = new TreeNode(3);
    input.left.left = new TreeNode(4);
    input.left.right = new TreeNode(5);
    me.flatten(input);
    System.out.println("Come here");
  }

  public void flatten(TreeNode root) {
    if (root == null) return;
    if (root.left == null && root.right == null) return;
    if (root.left != null) {
      TreeNode temp = root.right;
      flatten(root.left);
      root.right = root.left;
      root.left = null;
      while (root.right != null) {
        root = root.right;
      }
      root.right = temp;
    }
    flatten(root.right);
  }

  public void flatten2(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode node = root;
    while (node != null) {
      if (node.left != null) {
        TreeNode rightmost = node.left;
        while (rightmost.right != null) {
          rightmost = rightmost.right;
        }
        rightmost.right = node.right;
        node.right = node.left;
        node.left = null;
      }
      node = node.right;
    }
  }
}
