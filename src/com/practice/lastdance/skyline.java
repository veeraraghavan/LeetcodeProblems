/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/15/22, 5:18 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class skyline {
  public static void main(String[] args) {
    skyline me = new skyline();
  }

  public List<List<Integer>> getSkyline(int[][] buildings) {
    int buildPoints[][] = new int[buildings.length * 2][2];
    int i = 0;
    for (int[] point : buildings) {

      buildPoints[i][0] = point[0];
      buildPoints[i][1] = -point[2];
      buildPoints[i + 1][0] = point[1];
      buildPoints[i + 1][1] = point[2];
      i += 2;
    }
    Arrays.sort(
        buildPoints,
        (a, b) -> {
          return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });

    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(0, 1);
    int prevMax = 0;
    List<List<Integer>> result = new ArrayList<>();
    for (int[] build : buildPoints) {
      if (build[1] < 0) { // start of building
        map.compute(
            -build[1],
            (key, value) -> {
              if (value != null) {
                return value + 1;
              }
              return 1;
            });

      } else { // end of building
        map.compute(
            build[1],
            (key, value) -> {
              if (value == 1) {
                return null;
              }
              return value - 1;
            });
      }
      int currentMax = map.lastKey();
      if (currentMax != prevMax) {
        result.add(Arrays.asList(build[0], currentMax));
        prevMax = currentMax;
      }
    }
    return result;
  }
}
