/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/1/21, 8:57 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class EraseOverLapIntervals {
  public static void main(String[] args) {
    EraseOverLapIntervals me = new EraseOverLapIntervals();
  }

  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int prev = 0, count = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[prev][1] > intervals[i][0]) {
        if (intervals[prev][1] > intervals[i][1]) {
          prev = i;
        }
        count++;
      } else {
        prev = i;
      }
    }
    return count;
  }
}
