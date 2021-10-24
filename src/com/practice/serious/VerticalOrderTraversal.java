/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/23/21, 9:48 PM
 * =========================================
 */

package com.practice.serious;

import java.util.*;

public class VerticalOrderTraversal {
  public static void main(String[] args) {
    VerticalOrderTraversal me = new VerticalOrderTraversal();
  }

  TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> result = new TreeMap();

  public List<List<Integer>> verticalTraversal(TreeNode root) {
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
  //    public void recurse(TreeMap<Integer,ArrayList<Integer>> result, TreeNode root, int col , int
  // row){
  //        if(root==null)
  //            return;
  //
  //        ArrayList<Integer> values = result.getOrDefault(col,new ArrayList<Integer>());
  //        values.add(root.val);
  //        Collections.sort(values);
  //        result.put(col,values);
  //        recurse(result,root.left,col-1,row+1);
  //        recurse(result,root.right,col+1,row+1);
  //    }

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
    Collections.sort(values);
    colMap.put(row, values);
    result.put(col, colMap);
    recurse2(result, root.left, col - 1, row + 1);
    recurse2(result, root.right, col + 1, row + 1);
  }
}
