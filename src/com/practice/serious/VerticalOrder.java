/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/23/21, 10:00 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrder {
  public static void main(String[] args) {
    VerticalOrder me = new VerticalOrder();
  }

  TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> result = new TreeMap();

  public List<List<Integer>> verticalOrder(TreeNode root) {
    recurse2(result, root, 0, 0);
    List<List<Integer>> res = new ArrayList();

    for (Integer col : result.keySet()) {
      ArrayList<Integer> temp = new ArrayList<>();
      for (Map.Entry<Integer, ArrayList<Integer>> entry : result.get(col).entrySet()) {
        temp.addAll(entry.getValue());
      }
      res.add(temp);
    }

    return res;
  }

  public void recurse2(
      TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> result,
      TreeNode root,
      int col,
      int row) {
    if (root == null) return;

    TreeMap<Integer, ArrayList<Integer>> colMap =
        result.getOrDefault(col, new TreeMap<Integer, ArrayList<Integer>>());
    ArrayList<Integer> values = colMap.getOrDefault(row, new ArrayList());
    values.add(root.val);
    // Collections.sort(values);
    colMap.put(row, values);
    result.put(col, colMap);
    recurse2(result, root.left, col - 1, row + 1);
    recurse2(result, root.right, col + 1, row + 1);
  }
}
