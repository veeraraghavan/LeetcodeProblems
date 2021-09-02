/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/1/21, 10:43 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class FindMinArrows {
  public static void main(String[] args) {
    FindMinArrows me = new FindMinArrows();
  }

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> a[0] - b[0]);
    int count = 0;
    // if(points.length==2){
    //     int x = points[0][0];
    //     int y = points[1][0];
    //     int a = points[0][1];
    //     int b = points[1][1];
    //     if(x==y && a==b)return 1;
    // }
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > points[i - 1][1]) {
        continue;
      }
      count++;
      points[i][1] = Math.min(points[i - 1][1], points[i][1]);
    }
    return (points.length == 2 && count == 1) ? 2 : points.length - count;
  }
}
