/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/29/22, 12:19 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.Arrays;
import java.util.List;

public class subsetDivision {
  public static void main(String[] args) {
    subsetDivision me = new subsetDivision();
    me.nonDivisibleSubset(3, Arrays.asList(new Integer[] {1, 7, 2, 4}));
  }

  private int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
    int[] count = new int[k];
    for (int num : s) {
      count[num % k]++;
    }
    int ans = 0;
    ans = Math.min(count[0], 1);
    if (k % 2 == 0) ans += Math.min(count[k / 2], 1);
    for (int i = 1; i <= (k - 1) / 2; i++) {
      ans += Math.max(count[i], count[k - i]);
    }
    return ans;
  }
}
