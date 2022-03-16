/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/28/21, 11:08 PM
 * =========================================
 */

package com.practice.fb;

import java.util.HashSet;
import java.util.Set;

public class PassingYearBook {
  public static void main(String[] args) {
    PassingYearBook me = new PassingYearBook();
  }

  int[] findSignatureCounts(int[] arr) {
    Set<Integer> visited = new HashSet<>();
    int[] res = new int[arr.length];
    for (int num : arr) {
      if (!visited.contains(num)) {
        Set<Integer> loop = new HashSet<>();
        while (!visited.contains(num)) {
          num = arr[num - 1];
          loop.add(num);
          visited.add(num);
        }
        for (int i : loop) {
          res[i - 1] = loop.size();
        }
      }
    }
    return res;
  }
}
