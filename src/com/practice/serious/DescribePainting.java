/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/14/21, 11:52 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class DescribePainting {
  public static void main(String[] args) {
    DescribePainting me = new DescribePainting();
  }

  public List<List<Long>> splitPainting(int[][] segments) {
    List<List<Long>> result = new ArrayList<>();
    Arrays.sort(segments, (a, b) -> a[0] - b[0]);
    TreeMap<Integer, Long> map = new TreeMap<>();
    for (int[] segment : segments) {
      map.put(segment[0], map.getOrDefault(segment[0], 0L) + segment[2]);
      map.put(segment[1], map.getOrDefault(segment[1], 0L) - segment[2]);
    }
    long sum = 0;
    int prev = 0;
    for (Integer key : map.keySet()) {
      if (sum != 0) {
        List<Long> temp = new ArrayList<>();
        temp.add((long) prev);
        temp.add((long) key);
        temp.add(sum);
        result.add(temp);
      }

      prev = key;
      sum += map.get(key);
    }
    return result;
  }
}
