/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/20/21, 3:10 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class LeftTree {

  public static void main(String[] args) {
    LeftTree me = new LeftTree();
  }
  // https://leetcode.com/problems/leaf-similar-trees/
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leaves1 = new ArrayList<>();
    List<Integer> leaves2 = new ArrayList();
    getLeaf(root1, leaves1);
    getLeaf(root2, leaves2);
    if (leaves1.size() != leaves2.size()) return false;
    int size = leaves1.size();
    for (int i = 0; i < size; i++) {
      if (leaves1.get(i) != leaves2.get(i)) return false;
    }
    return true;
  }

  private void getLeaf(TreeNode root, List<Integer> leaves) {
    if (root == null) return;
    if (root.left == null && root.right == null) leaves.add(root.val);
    getLeaf(root.left, leaves);
    getLeaf(root.right, leaves);
  }
}
