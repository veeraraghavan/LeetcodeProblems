/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/20/21, 5:29 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {

  public static void main(String[] args) {
    InorderSuccessor me = new InorderSuccessor();
  }

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    List<TreeNode> nodeList = new ArrayList<>();
    inTraversal(root, nodeList);
    for (int i = 0; i < nodeList.size() - 1; i++) {
      if (nodeList.get(i).val == p.val) {
        return nodeList.get(i + 1);
      }
    }
    return null;
  }

  private void inTraversal(TreeNode root, List<TreeNode> nodeList) {
    if (root == null) return;
    inTraversal(root.left, nodeList);
    nodeList.add(root);
    inTraversal(root.right, nodeList);
  }

  private TreeNode inTraverse(TreeNode root, TreeNode p) {
    TreeNode successor = null;
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
