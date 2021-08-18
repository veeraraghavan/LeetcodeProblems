/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/17/21, 4:53 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class ScheduleCourse {

  public static void main(String[] args) {
    ScheduleCourse me = new ScheduleCourse();
  }

  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> a[1] - b[1]);
    Integer[][] dp = new Integer[courses.length][courses[courses.length - 1][1] + 1];
    return count(dp, courses, 0, 0);
  }

  public int count(Integer[][] dp, int[][] courses, int index, int time) {
    if (index == courses.length) return 0;
    if (dp[index][time] != null) return dp[index][time];
    int taken = 0;
    if (time + courses[index][0] <= courses[index][1])
      taken = 1 + count(dp, courses, index + 1, time + courses[index][0]);
    int not_taken = count(dp, courses, index + 1, time);
    dp[index][time] = Math.max(taken, not_taken);
    return dp[index][time];
  }

  public int scheduleCourseIterative(int[][] courses) {
    Arrays.sort(courses, (a, b) -> a[1] - b[1]);
    int time = 0, count = 0;
    for (int i = 0; i < courses.length; i++) {
      if (time + courses[i][0] <= courses[i][1]) {
        time += courses[i][0];
        count++;
      } else {
        int max_i = i;
        for (int j = 0; j < i; j++) {
          if (courses[j][0] > courses[max_i][0]) {
            max_i = j;
          }
        }
        time += courses[i][0] - courses[max_i][0];
        courses[max_i][0] = -1;
      }
    }
    return count;
  }
}
