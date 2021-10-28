/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/26/21, 4:20 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;
import java.util.Stack;

public class Bipartite {
  public static void main(String[] args) {
    Bipartite me = new Bipartite();
  }

  public boolean isBipartite(int[][] graph) {

    int[] color = new int[graph.length];
    Arrays.fill(color, -1);
    for (int start = 0; start < graph.length; start++) {
      if (color[start] == -1) {
        Stack<Integer> stack = new Stack();
        stack.push(start);
        color[start] = 0;
        while (!stack.empty()) {
          int node = stack.pop();
          for (int n : graph[node]) {
            if (color[n] == -1) {
              stack.push(n);
              color[n] = color[start] ^ 1;
            } else if (color[n] == color[node]) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}
