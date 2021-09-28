/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/27/21, 11:10 AM
 * =========================================
 */

package com.practice.serious;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTree {
  public static void main(String[] args) {
    CutOffTree me = new CutOffTree();
  }

  int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int cutOffTree(List<List<Integer>> forest) {
    List<int[]> trees = getAllTrees(forest);
    Collections.sort(trees, (a, b) -> a[2] - b[2]);
    int currentX = 0, currentY = 0;
    int minSteps = 0;
    while (!trees.isEmpty()) {
      int[] next = trees.remove(0);
      int nextX = next[0];
      int nextY = next[1];
      int steps = getMinSteps(forest, currentX, currentY, nextX, nextY);
      if (steps == -1) return -1;
      minSteps += steps;
      currentX = nextX;
      currentY = nextY;
      forest.get(currentX).set(currentY, 1);
    }
    return minSteps;
  }

  public int getMinSteps(List<List<Integer>> forest, int startX, int startY, int endX, int endY) {
    int minSteps = 0;
    int rows = forest.size(), cols = forest.get(0).size();
    boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
    Queue<int[]> queue = new LinkedList<>();
    // int currentVal = forest.get(startX).get(startY);
    queue.offer(new int[] {startX, startY});
    visited[startX][startY] = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] curCell = queue.poll();
        if (curCell[0] == endX && curCell[1] == endY) {
          return minSteps;
        }
        for (int[] direction : directions) {
          int nx = curCell[0] + direction[0];
          int ny = curCell[1] + direction[1];
          if (nx >= 0
              && nx < rows
              && ny >= 0
              && ny < cols
              && visited[nx][ny] != true
              && forest.get(nx).get(ny) != 0) {
            queue.add(new int[] {nx, ny});
            visited[nx][ny] = true;
          }
        }
      }
      minSteps++;
    }
    return -1;
  }

  public List<int[]> getAllTrees(List<List<Integer>> forest) {
    List<int[]> trees = new LinkedList<>();
    for (int i = 0; i < forest.size(); i++) {
      for (int j = 0; j < forest.get(0).size(); j++) {
        if (forest.get(i).get(j) > 1) {
          trees.add(new int[] {i, j, forest.get(i).get(j)});
        }
      }
    }
    return trees;
  }
}
