/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 2:58 PM
 * =========================================
 */

package com.practice.serious;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSiblings {
  public static void main(String[] args) {
    LevelOrderSiblings me = new LevelOrderSiblings();
    Node root = new Node(12);
    root.left = new Node(7);
    root.right = new Node(1);
    root.left.left = new Node(9);
    root.right.left = new Node(10);
    root.right.right = new Node(5);
    me.connectRecursive(root);
  }

  private Node connect(Node root) {

    if (root == null) return null;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int numOfNodes = queue.size();
      Node current = null;
      for (int i = 0; i < numOfNodes; i++) {
        current = queue.poll();
        if (queue.peek() != null) current.next = queue.peek();
        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
      }
      current.next = null;
    }
    // return result;
    return root;
  }

  private Node connectRecursive(Node root) {
    if (root == null) {
      return null;
    }
    if (root.left != null) {
      root.left.next = root.right;
    }
    if (root.next != null && root.right != null) {
      root.right.next = root.next.left;
    }
    connect(root.right);
    connect(root.left);
    return root;
  }
}
