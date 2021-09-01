/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/30/21, 11:55 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IntersectIntervals {
  public static void main(String[] args) {
    IntersectIntervals me = new IntersectIntervals();
  }

  public int[][] intervalIntersection(int[][] A, int[][] B) {
    int i = 0, j = 0;
    List<int[]> res = new ArrayList<>();
    while (i < A.length && j < B.length) {

      int low = Math.max(A[i][0], B[j][0]);
      int high = Math.min(A[i][1], B[j][1]);
      if (low <= high) res.add(new int[] {low, high});

      if (A[i][1] > B[j][1]) {
        j++;
      } else {
        i++;
      }
    }
    return res.toArray(new int[res.size()][]);
  }

  private Boolean isIntersecting(int[] a, int[] b) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((d, c) -> d - c);
    return (a[0] <= b[0] && a[1] >= b[0]) || (b[0] <= a[0] && b[1] >= a[0]);
  }
}
