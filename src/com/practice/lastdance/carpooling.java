/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/19/22, 1:41 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.Arrays;
import java.util.PriorityQueue;

public class carpooling {
  public static void main(String[] args) {
    carpooling me = new carpooling();
    me.carPooling(new int[][] {{2, 1, 5}, {3, 3, 7}}, 4);
  }

  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, (a, b) -> a[2] - b[2]);
    int max = trips[trips.length - 1][2];
    int[] cap = new int[max];
    for (int i = 0; i < trips.length; i++) {
      for (int j = trips[i][1]; j < trips[i][2]; j++) {
        cap[j] += trips[i][0];
      }
    }
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
    for (int c : cap) {
      pq.offer(c);
    }
    return pq.poll() > capacity;
  }
}
