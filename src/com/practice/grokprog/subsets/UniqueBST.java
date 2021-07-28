/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   11/2/20, 3:48 PM
 * =========================================
 */

package com.practice.grokprog.subsets;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  private int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
;

public class UniqueBST {
  public static void main(String[] args) {
    UniqueBST me = new UniqueBST();
  }

  public List<TreeNode> findUniqueTrees(int n) {

    return getSubTrees(1, n);
  }

  private List<TreeNode> getSubTrees(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftSubtree = getSubTrees(0, i - 1);
      List<TreeNode> rightSubtree = getSubTrees(i + 1, end);
      for (TreeNode left : leftSubtree) {
        for (TreeNode right : rightSubtree) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          result.add(root);
        }
      }
    }
    return result;
  }
}
