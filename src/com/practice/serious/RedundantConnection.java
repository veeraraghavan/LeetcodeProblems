/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/24/21, 4:37 PM
 * =========================================
 */

package com.practice.serious;

public class RedundantConnection {

  public static void main(String[] args) {
    RedundantConnection me = new RedundantConnection();
  }

  private int parent[];
  private int rank[];

  public int[] findRedundantConnection(int[][] edges) {
    // Union & find . Create a union of each vertices. if the parent of both nodes are
    // same,then there is a cycle.
    parent = new int[edges.length * 2];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
    for (int i = 0; i < edges.length; i++) {
      int a = edges[i][0];
      int b = edges[i][1];
      if (union(a, b)) {
        return edges[i];
      }
      ;
    }
    throw new AssertionError();
  }

  private boolean union(int a, int b) {
    int pa = find(a);
    int pb = find(b);
    if (pa == pb) return true;
    if (rank[pa] > rank[pb]) {
      parent[pb] = parent[pa];
      rank[pa] += rank[pb];
    } else {
      parent[pa] = parent[pb];
      parent[pb] += parent[pa];
    }
    return false;
  }

  public int find(int a) {
    if (parent[a] != a) {
      int pa = find(parent[a]);
      parent[a] = pa;
    }
    return parent[a];
  }
}
