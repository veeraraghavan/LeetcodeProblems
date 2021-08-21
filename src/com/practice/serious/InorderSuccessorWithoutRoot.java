/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/20/21, 7:55 PM
 * =========================================
 */

package com.practice.serious;

public class InorderSuccessorWithoutRoot {

  public static void main(String[] args) {
    InorderSuccessorWithoutRoot me = new InorderSuccessorWithoutRoot();
  }

  public NodeTree inorderSuccessor(NodeTree node) {
    NodeTree root = null;
    NodeTree temp = node;
    while (temp.parent != null) {
      temp = temp.parent;
    }
    return inTraverse(temp, node);
  }

  private NodeTree inTraverse(NodeTree root, NodeTree p) {
    NodeTree successor = null;
    while (root != null) {
      if (p.val >= root.val) {
        root = root.right;
      } else {
        successor = root;
        root = root.left;
      }
    }

    return successor;
  }
}
