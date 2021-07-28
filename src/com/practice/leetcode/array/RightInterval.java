/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/26/20, 8:45 AM
 * =========================================
 */

package com.practice.leetcode.array;

import java.util.PriorityQueue;

public class RightInterval {

  public static void main(String[] args) {
    RightInterval me = new RightInterval();
    me.findRightInterval(new int[][] {{4, 5}, {4, 6}, {3, 4}, {2, 3}, {1, 2}});
  }
  /*
      Basic Logic : Have two max Heap sorted by start time and end time startHeap, EndHeap.
      We know the next interval of the element having maximum end time is -1.
      What we know no two intervals can have same start time . They can have same end time=> How to resolve the tie?
      Consume one by one from End Heap.
      First element from endHeap -> next interval is -1.
      Next element from endHeap -> Find all elements from startHeap whose start is greater than end of selected element
      Now in case of two elements having start greater than end of current choose the lower high of the two and can
      ignore the rest.







  */
  private int[] findRightInterval(int[][] intervals) {
    PriorityQueue<Integer> maxStartHeap =
        new PriorityQueue<>((a, b) -> intervals[b][0] - intervals[a][0]);
    PriorityQueue<Integer> maxEndHeap =
        new PriorityQueue<>((a, b) -> intervals[b][1] - intervals[a][1]);
    int[] result = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      maxStartHeap.offer(i);
      maxEndHeap.offer(i);
    }
    // int topEnd = -1, topStart = -1;
    //    for (int i = 0; i < intervals.length; i++) {
    //      topEnd = maxEndHeap.poll();
    //      result[topEnd] = -1;
    //      if (intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]) {
    //        while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()][0] >= topEnd) {
    //          topStart = maxStartHeap.poll();
    //          // while(max)
    //        }
    //        result[topEnd] = topStart;
    //        maxStartHeap.offer(topStart);
    //      }
    //    }
    for (int i = 0; i < intervals.length; i++) {
      int topEnd =
          maxEndHeap
              .poll(); // let's find the next interval of the interval which has the highest 'end'
      result[topEnd] = -1; // defaults to -1
      if (intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]) {
        int topStart = maxStartHeap.poll();
        // find the the interval that has the closest 'start'
        while (!maxStartHeap.isEmpty()
            && intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]) {
          topStart = maxStartHeap.poll();
        }
        result[topEnd] = topStart;
        maxStartHeap.add(
            topStart); // put the interval back as it could be the next interval of other intervals
      }
    }

    return result;
  }
}
