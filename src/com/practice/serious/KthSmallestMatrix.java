/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 9:55 PM
 * =========================================
 */

package com.practice.serious;

import java.util.PriorityQueue;

public class KthSmallestMatrix {
  public static void main(String[] args) {
    KthSmallestMatrix me = new KthSmallestMatrix();
  }

  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        heap.add(matrix[i][j]);
      }
    }
    while (k - 1 > 0) {
      heap.poll();
      k--;
    }
    return heap.peek();
  }
}
