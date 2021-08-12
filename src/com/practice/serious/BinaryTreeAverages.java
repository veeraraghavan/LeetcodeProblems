/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 12:44 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeAverages {
  public static void main(String[] args) {
    BinaryTreeAverages me = new BinaryTreeAverages();
  }

  // We need to have a list where index of list is the level
  public List<Double> averageOfLevels(TreeNode root) {

    List<Double> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int numOfNodes = queue.size();
      double levelSum = 0;
      for (int i = 0; i < numOfNodes; i++) {
        TreeNode current = queue.poll();
        levelSum += current.val;
        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
      }
      result.add(levelSum / numOfNodes);
    }
    return result;
  }
}
