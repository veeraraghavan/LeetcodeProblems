/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/26/21, 11:20 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ModeBST {

  public static void main(String[] args) {
    ModeBST me = new ModeBST();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(2);
    me.findMode(root);
  }

  private int[] findMode(TreeNode root) {
    HashMap<Integer, Integer> map = new HashMap<>();
    recurse(root, map);
    PriorityQueue<Integer> ordered = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    ordered.addAll(map.keySet());
    ArrayList<Integer> result = new ArrayList<>();
    int max = -1;
    while (!ordered.isEmpty()) {
      int key = ordered.poll();

      if (max <= map.get(key)) {
        max = map.get(key);
        result.add(key);
      } else {
        break;
      }
    }

    int[] res = new int[result.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = result.get(i);
    }
    return res;
  }

  private void recurse(TreeNode root, HashMap<Integer, Integer> map) {
    if (root == null) return;
    int count = map.getOrDefault(root.val, 0);
    map.put(root.val, count + 1);
    recurse(root.left, map);
    recurse(root.right, map);
  }
}
