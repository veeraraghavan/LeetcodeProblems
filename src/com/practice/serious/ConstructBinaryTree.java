/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/20/21, 10:21 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class ConstructBinaryTree {

  private int preOrderIndex = 0;
  private HashMap<Integer, Integer> inorderMap = new HashMap<>();

  public static void main(String[] args) {
    ConstructBinaryTree me = new ConstructBinaryTree();
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
    return construct(preorder, 0, inorder.length);
  }

  private TreeNode construct(int[] preorder, int low, int high) {
    if (low > high) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preOrderIndex++]);
    root.left = construct(preorder, low, inorderMap.get(root.val) - 1);
    root.right = construct(preorder, inorderMap.get(root.val) + 1, high);
    return root;
  }
}
