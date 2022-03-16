/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   2/18/22, 7:08 PM
 * =========================================
 */

package com.practice.debugging;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {

  public int shortestPath(int[][] grid, int k) {
    int rows = grid.length;
    int cols = grid[0].length;
    HashSet<State> visited = new HashSet<>();
    if (k >= rows + cols - 2) {
      return rows + cols - 2;
    }
    int[][] steps = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Deque<State> queue = new LinkedList<>();
    State start = new State(0, 0, k, 0);
    queue.addLast(start);
    visited.add(start);

    while (!queue.isEmpty()) {
      State current = queue.pollFirst();
      if (current.row == rows - 1 && current.col == cols - 1) return current.step;
      for (int[] step : steps) {
        int nr = current.row + step[0];
        int nc = current.col + step[1];
        int count = current.step;
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
        int nextElimination = current.elim - grid[nr][nc];
        State nextState = new State(nr, nc, nextElimination, count + 1);
        if (nextElimination >= 0 && !visited.contains(nextState)) {
          visited.add(nextState);
          queue.offer(nextState);
        }
      }
    }
    return -1;
  }
}

class State {
  int row;
  int col;
  int elim;
  int step;

  public State(int row, int col, int removal, int count) {
    this.row = row;
    this.col = col;
    this.elim = removal;
    this.step = count;
  }

  public int hashCode() {
    return (this.row + 1) * (this.col + 1) * (this.elim);
  }

  public boolean equals(Object other) {
    if (!(other instanceof State)) {
      return false;
    }
    State newState = (State) other;
    return (this.row == newState.row) && (this.col == newState.col) && (this.elim == newState.elim);
  }

  public String toString() {
    return String.format("%d %d %d", this.row, this.col, this.elim);
  }
}
