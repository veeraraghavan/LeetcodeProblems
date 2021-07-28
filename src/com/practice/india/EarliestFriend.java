package com.practice.india;

import java.util.Arrays;

public class EarliestFriend {

  public static void main(String[] args) {
    EarliestFriend me = new EarliestFriend();

    int[][] input = new int[8][3];
    input[0] = new int[] {20190101, 0, 1};
    input[1] = new int[] {20190104, 3, 4};
    input[2] = new int[] {20190107, 2, 3};
    input[3] = new int[] {20190211, 1, 5};
    input[4] = new int[] {20190224, 2, 4};
    input[5] = new int[] {20190301, 0, 3};
    input[6] = new int[] {20190312, 1, 2};
    input[7] = new int[] {20190322, 4, 5};
    input =
        new int[][] {
          {10, 3, 5},
          {6, 3, 5},
          {3, 0, 1},
          {4, 0, 3},
          {1, 2, 1},
          {8, 3, 1},
          {5, 0, 3},
          {7, 4, 1},
          {0, 3, 2},
          {12, 4, 3},
          {9, 0, 1},
          {2, 0, 5},
          {11, 2, 3},
          {13, 2, 3}
        };

    System.out.println(me.earliestAcq(input, 6));
  }

  private int[] parent;
  private int[] size;

  private int earliestAcq(int[][] logs, int N) {
    // We need to sort the logs in the ascending order of time.
    // Have a union algorithm and find algorithm

    parent = new int[N];
    size = new int[N];
    Arrays.sort(logs, (a, b) -> a[0] - b[0]);
    for (int i = 0; i < N; i++) {
      parent[i] = i;
      size[i] = 1;
    }
    for (int[] log : logs) {
      union(log[1], log[2]);
      int px = find(log[1]);
      int py = find(log[2]);
      if (size[px] == N || size[py] == N) {
        return log[0];
      }
    }
    return -1;
  }

  private void union(int x, int y) {
    int px = find(x);
    int py = find(y);
    if (px == py) {
      return;
    }
    if (size[px] > size[py]) {
      parent[py] = px;
      size[px] += size[py];
    } else {
      parent[px] = py;
      size[py] += size[px];
    }
    return;
  }

  public int find(int node) {
    if (parent[node] != node) {
      parent[node] = find(parent[node]);
    }
    return parent[node];
  }
}
