/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/17/21, 2:47 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FindLeastNumOfUniqueInts {

  public static void main(String[] args) {
    FindLeastNumOfUniqueInts me = new FindLeastNumOfUniqueInts();
    System.out.println(me.findLeastNumOfUniqueInts(new int[] {5, 5, 4}, 1));
  }

  private int findLeastNumOfUniqueInts(int[] arr, int k) {
    HashMap<Integer, Integer> valueCount = new HashMap<>();
    PriorityQueue<Integer> heap =
        new PriorityQueue<>((a, b) -> valueCount.get(a) - valueCount.get(b));

    for (int num : arr) {
      int count = valueCount.getOrDefault(num, 0);
      valueCount.put(num, count + 1);
    }
    heap.addAll(valueCount.keySet());
    while (k > 0) {
      int top = heap.poll();
      int count = valueCount.get(top);
      if (count == 1) {
        valueCount.remove(top);
      } else {
        valueCount.put(top, count - 1);
        heap.add(top);
      }
      k--;
    }
    return heap.size();
  }
}
