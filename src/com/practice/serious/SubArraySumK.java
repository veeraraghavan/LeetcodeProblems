/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/10/21, 5:14 PM
 * =========================================
 */

package com.practice.serious;

public class SubArraySumK {
  public static void main(String[] args) {
    SubArraySumK me = new SubArraySumK();
    System.out.println(me.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
  }

  private int findMaxSumSubArray(int k, int[] arr) {
    int max = 0;
    for (int i = 0; i < arr.length - k; i++) {
      int sum = 0;
      for (int j = i; j < i + k; i++) {
        sum += arr[i];
      }
      max = Math.max(sum, max);
    }
    return max;
  }

  private int findMaxSumSubArrayWindow(int k, int[] arr) {
    int max = 0;
    int windowStart = 0;
    int sum = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      sum += arr[windowEnd];
      if (windowEnd >= k - 1) {
        max = Math.max(max, sum);
        sum -= arr[windowStart++];
      }
    }
    return max;
  }
}
