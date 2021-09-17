/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/15/21, 12:27 AM
 * =========================================
 */

package com.practice.serious;

public class TwoSumSorted {
  public static void main(String[] args) {
    TwoSumSorted me = new TwoSumSorted();
  }

  public int[] twoSum(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    while (low < high) {
      int sum = numbers[low] + numbers[high];
      if (target == sum) {
        return new int[] {1 + low, 1 + high};
      } else if (sum < target) {
        low = low + 1;
      } else {
        high = high - 1;
      }
    }
    return new int[] {-1, -1};
  }
}
