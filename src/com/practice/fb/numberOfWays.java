/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/28/21, 5:34 PM
 * =========================================
 */

package com.practice.fb;

import java.util.HashMap;

public class numberOfWays {
  public static void main(String[] args) {
    numberOfWays me = new numberOfWays();
    System.out.println(me.numberOfWays(new int[] {1, 2, 3, 4, 3}, 6));
  }

  int numberOfWays(int[] arr, int k) {
    // Write your code here
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {
      if (!map.containsKey(num)) map.put(num, 0);
      map.put(num, map.get(num) + 1);
    }
    int double_count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (map.get(k - arr[i]) != null) {
        double_count += map.get(k - arr[i]);
      }
      if (k - arr[i] == arr[i]) double_count--;
    }
    return double_count / 2;
  }
  //  int numberOfWays(int[] arr, int sum) {
  //    int n = arr.length;
  //    HashMap<Integer, Integer> hm = new HashMap<>();
  //
  //    // Store counts of all elements in map hm
  //    for (int i = 0; i < n; i++) {
  //
  //      // initializing value to 0, if key not found
  //      if (!hm.containsKey(arr[i])) hm.put(arr[i], 0);
  //
  //      hm.put(arr[i], hm.get(arr[i]) + 1);
  //    }
  //    int twice_count = 0;
  //
  //    // iterate through each element and increment the
  //    // count (Notice that every pair is counted twice)
  //    for (int i = 0; i < n; i++) {
  //      if (hm.get(sum - arr[i]) != null) twice_count += hm.get(sum - arr[i]);
  //
  //      // if (arr[i], arr[i]) pair satisfies the condition,
  //      // then we need to ensure that the count is
  //      // decreased by one such that the (arr[i], arr[i])
  //      // pair is not considered
  //      if (sum - arr[i] == arr[i]) twice_count--;
  //    }
  //
  //    // return the half of twice_count
  //    return twice_count / 2;
  //  }
}
