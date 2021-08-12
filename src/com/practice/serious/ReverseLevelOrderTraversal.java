/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 1:09 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
  public static void main(String[] args) {
    ReverseLevelOrderTraversal me = new ReverseLevelOrderTraversal();
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    me.levelOrderBottom(root);
  }

  private List<List<Integer>> levelOrderBottom(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    while (!queue.isEmpty()) {
      int numOfNodes = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int i = 0; i < numOfNodes; i++) {
        TreeNode current = queue.poll();
        currentLevel.add(current.val);
        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
      }
      result.add(0, currentLevel);
    }
    return result;
  }
}
