/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/5/21, 2:28 PM
 * =========================================
 */

package com.practice.serious;

public class CanReachZero {
  public static void main(String[] args) {
    CanReachZero me = new CanReachZero();
    System.out.println(me.canReach(new int[] {4, 2, 3, 0, 3, 1, 2}, 5));
  }

  public boolean canReach(int[] arr, int start) {
    boolean[] visited = new boolean[arr.length];
    visited[start] = true;
    return reachedZero(start, arr, visited);
  }
  // {4, 2, 3, 0, 3, 1, 2}, 5)
  public boolean reachedZero(int index, int[] arr, boolean[] visited) {
    if (arr[index] == 0) {
      return true;
    }

    int steps = arr[index];
    int forward = index + steps;
    int backward = index - steps;
    if (forward > arr.length && !visited[forward]) {
      visited[forward] = true;
      if (reachedZero(forward, arr, visited)) {
        return true;
      }
    }
    if (backward >= 0 && !visited[backward]) {
      visited[backward] = true;
      if (reachedZero(backward, arr, visited)) {
        return true;
      }
    }
    return false;
  }
}
