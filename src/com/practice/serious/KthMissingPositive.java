/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/29/21, 5:21 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KthMissingPositive {
  public static void main(String[] args) {
    KthMissingPositive me = new KthMissingPositive();
  }

  public int findKthPositive(int[] arr, int k) {

    List<Integer> list = new ArrayList<>();
    for (int num : arr) {
      list.add(num);
    }
    Set<Integer> nums = new HashSet<>(list);
    int count = 0;
    for (int i = 1; i <= arr.length + k; i++) {
      if (!nums.contains(i)) {
        count++;
        if (count == k) return i;
      }
    }
    return -1;
  }
}
