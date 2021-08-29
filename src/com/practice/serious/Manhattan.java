/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/28/21, 12:12 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Manhattan {
  PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

  public static void main(String[] args) {
    Manhattan me = new Manhattan();
    me.minCostConnectPoints(new int[][] {{2, -3}, {-17, -8}, {13, 8}, {-17, -15}});
  }

  HashSet<Integer> visited;

  public int minCostConnectPoints(int[][] points) {
    visited = new HashSet<>();
    visited.add(0);
    addPoints(points, 0);
    int count = 0;
    int cost = 0;
    while (count < points.length - 1) {
      Point next = pq.poll();
      int nextVertex = next.vertices[1];
      if (visited.contains(nextVertex)) {
        continue;
      }

      cost += next.distance;
      visited.add(nextVertex);
      addPoints(points, nextVertex);
    }
    return cost;
  }

  public void addPoints(int[][] points, int index) {
    for (int i = 0; i < points.length; i++) {
      if (i != index && !visited.contains(i)) {
        int[] v = new int[] {index, i};
        int dist =
            Math.abs(points[index][1] - points[i][1]) + Math.abs(points[index][0] - points[i][0]);
        Point p = new Point(v, dist);
        pq.add(p);
      }
    }
  }
}
//  TreeMap<Integer, List<Point>> distance = new TreeMap<>();
//  HashSet<Integer> visited = new HashSet<>();
//    for (int i = 0; i < points.length; i++) {
//        for (int j = i + 1; j < points.length; j++) {
//        int xDistance = Math.abs(points[i][0] - points[j][0]);
//        int yDistance = Math.abs(points[i][1] - points[j][1]);
//        Point p = new Point(i, j, xDistance + yDistance);
//        List<Point> pointList = distance.getOrDefault(xDistance + yDistance, new ArrayList<>());
//        pointList.add(p);
//        distance.put(xDistance + yDistance, pointList);
//        }
//        }
//        //    PriorityQueue<Integer> pq =
//        //        new PriorityQueue<>(
//        //            (a, b) -> {
//        //              return a - b;
//        //            });
//        //    pq.addAll(distance.keySet());
//        List<Integer> dist = new ArrayList<>(distance.keySet());
//        int count = points.length - 1;
//        int result = 0;
//        while (count != 0) {
//        int length = dist.get(0);
//        dist.remove(0);
//        List<Point> pointList = distance.get(length);
//        for (Point p : pointList) {
//        boolean required = false;
//        if (visited.add(p.x)) {
//        required = true;
//        }
//
//        if (visited.add(p.y)) {
//        required = true;
//        }
//        if (required) {
//        count--;
//        result += p.distance;
//        }
//        }
//        }
//        return result;
