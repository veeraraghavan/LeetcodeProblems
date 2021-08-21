/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/20/21, 11:30 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class ConstructBinaryTreePostInorder {

  public static void main(String[] args) {
    ConstructBinaryTreePostInorder me = new ConstructBinaryTreePostInorder();
  }

  private int postOrderIdx = 0;
  int[] inorder;
  private int[] postOrder;
  private HashMap<Integer, Integer> inOrderMap = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    inorder = inorder;
    postOrderIdx = postorder.length - 1;
    // postorder = postOrder;
    for (int i = 0; i < inorder.length; i++) inOrderMap.put(inorder[i], i);
    return construct(0, inorder.length - 1, postorder);
  }

  private TreeNode construct(int left, int right, int[] postorder) {
    if (left > right) return null;
    TreeNode root = new TreeNode(postorder[postOrderIdx--]);
    root.right = construct(inOrderMap.get(root.val) + 1, right, postorder);
    root.left = construct(left, inOrderMap.get(root.val) - 1, postorder);
    return root;
  }
}
