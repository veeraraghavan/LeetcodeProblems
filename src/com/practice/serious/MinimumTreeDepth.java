/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 2:52 PM
 * =========================================
 */

package com.practice.serious;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumTreeDepth {
  public static void main(String[] args) {
    MinimumTreeDepth me = new MinimumTreeDepth();
  }

  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int minimumTreeDepth = 0;
    while (!queue.isEmpty()) {
      minimumTreeDepth++;
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();

        // check if this is a leaf node
        if (currentNode.left == null && currentNode.right == null) return minimumTreeDepth;

        // insert the children of current node in the queue
        if (currentNode.left != null) queue.add(currentNode.left);
        if (currentNode.right != null) queue.add(currentNode.right);
      }
    }
    return minimumTreeDepth;
  }
}
