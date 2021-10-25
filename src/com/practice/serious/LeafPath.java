/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/24/21, 5:17 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class LeafPath {
  public static void main(String[] args) {
    LeafPath me = new LeafPath();
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList();
    recurse(result, root, new StringBuilder());
    return result;
  }

  public void recurse(List<String> result, TreeNode root, StringBuilder path) {
    if (root == null) {
      // result.add(path);
      return;
    }
    int length = path.length();
    path.append(root.val);
    if (root.left == null && root.right == null) {

      result.add(path.toString());

    } else {
      path.append("->");
      recurse(result, root.left, path);
      recurse(result, root.right, path);
    }
    path.setLength(length);
  }
}
