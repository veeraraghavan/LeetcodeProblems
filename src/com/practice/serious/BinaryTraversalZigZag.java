/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 2:06 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTraversalZigZag {
  public static void main(String[] args) {
    BinaryTraversalZigZag me = new BinaryTraversalZigZag();
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    queue.offer(root);
    int level = 0;
    while (!(queue.isEmpty())) {
      int numNodes = queue.size();
      level++;
      List<Integer> current = new ArrayList<>();
      for (int i = 0; i < numNodes; i++) {
        TreeNode top = queue.poll();
        if (level % 2 == 0) {
          current.add(0, top.val);
        } else {
          current.add(top.val);
        }
        if (top.left != null) queue.offer(top.left);
        if (top.right != null) queue.offer(top.right);
      }
      result.add(current);
    }
    return result;
  }
}
