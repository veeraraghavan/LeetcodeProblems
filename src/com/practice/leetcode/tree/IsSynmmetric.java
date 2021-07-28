package com.practice.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSynmmetric {
  public static void main(String[] args) {
    IsSynmmetric me = new IsSynmmetric();
  }
  /*
   Can implement using a queue or recursion.
   Underlying principle remains the same .
   Check for equality between
       1. Value of the current node.
       2. Perform the same between left child of left node and right child of right node



  */
  public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode t1 = queue.poll();
      TreeNode t2 = queue.poll();
      if (t1 == null && t2 == null) continue;
      if (t1 == null || t2 == null) return false;
      if (t1.val != t2.val) return false;
      queue.add(t1.left);
      queue.add(t2.right);
      queue.add(t1.right);
      queue.add(t2.left);
    }
    return queue.isEmpty();
  }
}
