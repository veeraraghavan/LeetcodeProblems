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
    int[][] edges =
        new int[][] {
          {0, 1}, {2, 3}, {4, 5}, {6, 7}, {8, 9}, {9, 6}, {7, 5}, {0, 2}, {3, 4}, {7, 1}, {8, 9}
        };
    me.findRedundantConnection(edges, 10);
  }

  private int parent[];
  private int rank[];

  public void findRedundantConnection(int[][] edges, int length) {
    // Union & find . Create a union of each vertices. if the parent of both nodes are
    // same,then there is a cycle.
    parent = new int[length];
    rank = new int[length];

    for (int i = 0; i < length; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
    for (int i = 0; i < edges.length; i++) {
      int a = edges[i][0];
      int b = edges[i][1];
      //      if (union(a, b)) {
      //        return edges[i];
      //      }
      union(a, b);
      ;
    }
    System.out.println("Completed");
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
      rank[pb] += rank[pa];
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
