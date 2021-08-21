/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/20/21, 3:20 PM
 * =========================================
 */

package com.practice.serious;

import java.util.PriorityQueue;

public class smallestFromLeaf {

  public static void main(String[] args) {
    smallestFromLeaf me = new smallestFromLeaf();
  }

  public String smallestFromLeaf(TreeNode root) {
    PriorityQueue<String> word = new PriorityQueue<>();
    dfs(root, word, "");
    return word.poll();
  }

  public void dfs(TreeNode root, PriorityQueue<String> word, String wordSoFar) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      word.add((char) (root.val + 'a') + wordSoFar);
    }
    dfs(root.left, word, (char) (root.val + 'a') + wordSoFar);
    dfs(root.right, word, (char) (root.val + 'a') + wordSoFar);
  }
}
