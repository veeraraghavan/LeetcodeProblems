/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/5/22, 11:47 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.ArrayList;
import java.util.List;

public class missingranges {
  public static void main(String[] args) {
    missingranges me = new missingranges();
  }

  private String concatenate(int a, int b) {
    return "" + (a + 1) + "->" + (b - 1);
  }

  private String concatenate(int a) {
    return "" + (a + 1);
  }

  private void getString(int first, int second, List<String> result) {
    if (second - first == 2) result.add(concatenate(first));
    else if (second - first > 2) result.add(concatenate(first, second));
  }

  private String formatRange(int lower, int upper) {
    if (lower == upper) return String.valueOf(lower);
    return lower + "->" + upper;
  }

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();
    int prev = lower - 1;
    for (int i = 0; i <= nums.length; i++) {
      int curr = (i < nums.length) ? nums[i] : upper + 1;
      if (prev + 1 <= curr - 1) {
        result.add(formatRange(prev + 1, curr - 1));
      }
      prev = curr;
    }
    return result;
  }
}
