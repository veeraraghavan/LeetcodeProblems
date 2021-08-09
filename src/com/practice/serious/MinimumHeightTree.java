/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/9/21, 12:06 PM
 * =========================================
 */

package com.practice.serious;

import java.util.*;

public class MinimumHeightTree {
  public static void main(String[] args) {
    MinimumHeightTree me = new MinimumHeightTree();
  }

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {

    HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    HashMap<Integer, Integer> incomingEdge = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Queue<Integer> sourceNodes = new LinkedList<>();
    if (n == 1) {
      res.add(0);
      return res;
    }
    if (n <= 0) {
      return new ArrayList<>();
    }
    // initialize the list
    for (int i = 0; i < n; i++) {
      adjList.put(i, new ArrayList<>());
      incomingEdge.put(i, 0);
    }
    // fill the list
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];
      adjList.get(a).add(b);
      adjList.get(b).add(a);
      incomingEdge.put(a, incomingEdge.get(a) + 1);
      incomingEdge.put(b, incomingEdge.get(b) + 1);
    }
    // find the leaf nodes
    for (Map.Entry<Integer, Integer> entry : incomingEdge.entrySet()) {
      if (entry.getValue() == 1) {
        sourceNodes.add(entry.getKey());
      }
    }
    int totalNodes = n;
    while (totalNodes > 2) {
      int leavesSize = sourceNodes.size();
      totalNodes -= leavesSize;
      for (int i = 0; i < leavesSize; i++) {
        int node = sourceNodes.poll();
        List<Integer> children = adjList.get(node);
        for (Integer child : children) {
          incomingEdge.put(child, incomingEdge.get(child) - 1);
          if (incomingEdge.get(child) == 1) {
            sourceNodes.add(child);
          }
        }
      }
    }

    res.addAll(sourceNodes);
    return res;
  }
}
