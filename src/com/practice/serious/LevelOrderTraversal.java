/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 12:44 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
  public static void main(String[] args) {
    LevelOrderTraversal me = new LevelOrderTraversal();
  }

  // We need to have a list where index of list is the level
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    printLevel(root, 0, result);
    return result;
  }

  private void printLevel(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) return;
    if (result.size() - 1 < level) {
      List<Integer> temp = new ArrayList<>();
      temp.add(root.val);
      result.add(temp);
    } else {
      result.get(level).add(root.val);
    }
    printLevel(root.left, level + 1, result);
    printLevel(root.right, level + 1, result);
  }
}
