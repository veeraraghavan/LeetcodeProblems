/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/14/22, 10:47 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.*;

public class criticalConnection {
  public static void main(String[] args) {
    criticalConnection me = new criticalConnection();
  }

  HashSet<Pair> connDict = new HashSet<>();
  Map<Integer, Integer> rank = new HashMap<>();
  Map<Integer, List<Integer>> adjList = new HashMap<>();

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    this.formGraph(connections, n);
    dfs(0, 0);
    List<List<Integer>> result = new ArrayList<>();
    for (Pair pair : this.connDict) {
      result.add(new ArrayList<>(Arrays.asList(pair.first, pair.second)));
    }
    return result;
  }

  public int dfs(int node, int rank) {

    if (this.rank.get(node) != null) {
      return this.rank.get(node);
    }
    this.rank.put(node, rank);
    int minRank = rank + 1;
    for (Integer neighbor : this.adjList.get(node)) {
      Integer neighRank = this.rank.get(neighbor);
      if (neighRank != null && neighRank == rank - 1) {
        continue;
      }
      int recursiveRank = this.dfs(neighbor, rank + 1);
      if (recursiveRank <= rank) {
        int sortedU = Math.min(node, neighbor);
        int sortedV = Math.max(node, neighbor);
        this.connDict.remove(new Pair(sortedU, sortedV));
      }
      minRank = Math.min(minRank, recursiveRank);
    }
    return minRank;
  }

  public void formGraph(List<List<Integer>> connections, int n) {
    for (int i = 0; i < n; i++) {
      adjList.put(i, new ArrayList<>());
      rank.put(i, null);
    }
    for (List<Integer> conn : connections) {
      int u = conn.get(0), v = conn.get(1);
      adjList.get(u).add(v);
      adjList.get(v).add(u);
      connDict.add(new Pair(Math.min(u, v), Math.max(u, v)));
    }
  }
}

// class Pair {
//  int start;
//  int end;
//
//  public Pair(int start, int end) {
//    this.start = start;
//    this.end = end;
//  }
// }
