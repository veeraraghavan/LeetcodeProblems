/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/20/21, 11:30 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;
import java.util.Stack;

public class ConstructBinaryTreePostInorder {

  public static void main(String[] args) {

    ConstructBinaryTreePostInorder me = new ConstructBinaryTreePostInorder();
    me.buildTreeIterative(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
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

  public TreeNode buildTreeIterative(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0) return null;
    int ip = inorder.length - 1;
    int pp = postorder.length - 1;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null;
    TreeNode root = new TreeNode(postorder[pp]);
    stack.push(root);
    pp--;

    while (pp >= 0) {
      while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
        prev = stack.pop();
        ip--;
      }
      TreeNode newNode = new TreeNode(postorder[pp]);
      if (prev != null) {
        prev.left = newNode;
      } else if (!stack.isEmpty()) {
        TreeNode currTop = stack.peek();
        currTop.right = newNode;
      }
      stack.push(newNode);
      prev = null;
      pp--;
    }

    return root;
  }
}
