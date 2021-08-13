/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 8:57 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaxPoints {
  public static void main(String[] args) {
    MaxPoints me = new MaxPoints();
    System.out.println(me.maxPoints(new int[][] {{3, 3}, {1, 4}, {1, 1}, {2, 1}, {2, 2}}));
  }

  private int maxPoints(int[][] points) {
    HashMap<Double, HashSet<Integer>> map = new HashMap();

    for (int i = 0; i < points.length; i++) {
      double slope = 0.0;
      for (int j = i + 1; j < points.length; j++) {
        int denominator = points[j][0] - points[i][0];
        if (denominator == 0x0) {
          slope = Double.MAX_VALUE;
        } else {
          slope = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
        }
        HashSet<Integer> set = map.getOrDefault(slope, new HashSet());
        set.add(j);
        set.add(i);
        map.put(slope, set);
      }
    }
    int maxCount = 0;
    for (Map.Entry<Double, HashSet<Integer>> entry : map.entrySet()) {
      maxCount = Math.max(entry.getValue().size(), maxCount);
    }
    return maxCount;
  }
}
