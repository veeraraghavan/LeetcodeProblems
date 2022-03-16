/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/19/22, 1:07 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingII {
  public static void main(String[] args) {
    meetingII me = new meetingII();
  }

  public int minMeetingRooms(int[][] intervals) {

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
    pq.add(intervals[0][1]);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= pq.peek()) {
        pq.poll();
      }
      pq.offer(intervals[i][1]);
    }
    return pq.size();
  }
}
