/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   2/17/22, 11:53 PM
 * =========================================
 */

package com.practice.debugging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetectSquares {
  public static void main(String[] args) {
    DetectSquares me = new DetectSquares();
    me.add(new int[] {5, 10});
    me.add(new int[] {10, 5});
    me.add(new int[] {10, 10});
    System.out.println(me.count(new int[] {5, 5}));
    me.add(new int[] {3, 0});
    me.add(new int[] {8, 0});
    me.add(new int[] {8, 5});
    System.out.println(me.count(new int[] {3, 5}));
    me.add(new int[] {9, 0});
    me.add(new int[] {9, 8});
    me.add(new int[] {1, 8});
    System.out.println(me.count(new int[] {1, 0}));
    me.add(new int[] {0, 0});
    me.add(new int[] {8, 0});
    me.add(new int[] {8, 8});
    System.out.println(me.count(new int[] {0, 8}));
  }

  HashMap<String, Integer> pointMap;
  List<int[]> points;

  public DetectSquares() {
    points = new ArrayList();
    pointMap = new HashMap();
  }

  public void add(int[] point) {
    points.add(point);
    String key = "" + point[0] + "_" + point[1];
    pointMap.put(key, pointMap.getOrDefault(key, 0) + 1);
  }

  public int count(int[] point) {
    int result = 0;
    for (int[] each : points) {
      int px = each[0];
      int py = each[1];
      if (point[0] == px || point[1] == py || (Math.abs(px - point[0]) != Math.abs(py - point[1])))
        continue;
      result +=
          pointMap.getOrDefault("" + point[0] + "_" + py, 0)
              * pointMap.getOrDefault("" + px + "_" + point[1], 0);
    }
    return result;
  }
}
