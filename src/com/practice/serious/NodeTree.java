/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 2:59 PM
 * =========================================
 */

package com.practice.serious;

class NodeTree {
  public int val;
  public NodeTree left;
  public NodeTree right;
  NodeTree parent;

  public NodeTree() {}

  public NodeTree(int _val) {
    val = _val;
  }

  public NodeTree(int _val, NodeTree _left, NodeTree _right, NodeTree _next) {
    val = _val;
    left = _left;
    right = _right;
    parent = _next;
  }
}
;
