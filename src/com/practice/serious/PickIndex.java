/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/10/21, 11:30 PM
 * =========================================
 */

package com.practice.serious;

public class PickIndex {
  public static void main(String[] args) {
    PickIndex me = new PickIndex(new int[] {});
  }

  int[] prefixSum;
  int sum;

  public PickIndex(int[] w) {
    prefixSum = new int[w.length];
    for (int i = 0; i < w.length; i++) {
      sum += w[i];
      prefixSum[i] = sum;
    }
  }

  public int pickIndex() {
    double value = (Math.random() * sum);
    int low = 0, high = prefixSum.length;
    while (low <= high) {
      int mid = low + ((high - low) / 2);
      if (prefixSum[mid] < value) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
}
