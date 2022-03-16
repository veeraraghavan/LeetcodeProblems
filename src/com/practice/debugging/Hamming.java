/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   3/7/22, 7:17 PM
 * =========================================
 */

package com.practice.debugging;

import java.util.HashMap;
import java.util.Map;

public class Hamming {
  public static void main(String[] args) {
    Hamming me = new Hamming();
    me.minimumHammingDistance(
        new int[] {5, 1, 2, 4, 3},
        new int[] {1, 5, 4, 2, 3},
        new int[][] {{0, 4}, {4, 2}, {1, 3}, {1, 4}});
  }

  public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    UnionFind uf = new UnionFind(source.length);
    for (int[] s : allowedSwaps) uf.union(s[0], s[1]);
    Map<Integer, Map<Integer, Integer>> circles = new HashMap<>();
    for (int i = 0; i < source.length; i++) {
      if (source[i] == target[i]) continue;
      int p = uf.find(i);
      circles.putIfAbsent(p, new HashMap<>());
      circles.get(p).put(source[i], circles.get(p).getOrDefault(source[i], 0) + 1);
    }
    int res = 0;
    for (int i = 0; i < source.length; i++) {
      if (source[i] == target[i]) continue;
      int pi = uf.find(i);
      if (circles.get(pi).getOrDefault(target[i], 0) == 0) res++;
      else circles.get(pi).put(target[i], circles.get(pi).get(target[i]) - 1);
    }
    return res;
  }

  private class UnionFind {
    int[] parents;

    UnionFind(int n) {
      parents = new int[n];
      for (int i = 0; i < n; i++) parents[i] = i;
    }

    int find(int i) {
      while (i != parents[i]) {
        parents[i] = parents[parents[i]];
        i = parents[i];
      }
      return i;
    }

    void union(int i, int j) {
      parents[find(j)] = find(i);
    }
  }
}
