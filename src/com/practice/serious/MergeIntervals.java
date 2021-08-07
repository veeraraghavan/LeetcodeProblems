/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/7/21, 1:04 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public static void main(String[] args) {
    MergeIntervals me = new MergeIntervals();
    me.merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}});
  }

  private int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> result = new ArrayList<>();
    int n = intervals.length;
    int position = 0;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        result.add(position, intervals[i]);
        position++;
        continue;
      } else {
        int[] prev = result.get(position - 1);
        if (prev[1] >= intervals[i][0]) {
          prev[1] = Math.max(prev[1], intervals[i][1]);
          result.remove(position - 1);
          result.add(position - 1, prev);
        } else {
          result.add(intervals[i]);
          position++;
        }
      }
    }

    int[][] res = new int[result.size()][2];
    int index = 0;
    for (int[] resList : result) {
      res[index++] = resList;
    }
    return res;
  }
}
