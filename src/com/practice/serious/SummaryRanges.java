/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/2/21, 10:50 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
  public static void main(String[] args) {
    SummaryRanges me = new SummaryRanges();
  }

  public List<String> summaryRanges(int[] nums) {
    int start = 0;
    int length = 0;
    List<String> result = new ArrayList<>();
    if (nums.length == 0) {
      // result.add("" + nums[0]);
      return result;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        start = i;
        length++;
        continue;
      }
      if (Math.abs(nums[i] - nums[i - 1]) > 1) {
        StringBuilder temp = new StringBuilder("");
        if (length == 1) {
          temp.append(nums[start]);
        } else {
          temp.append(nums[start]).append("->").append(nums[i - 1]);
        }
        result.add(temp.toString());
        start = i;
        length = 0;
      }
      length++;
    }
    StringBuilder temp = new StringBuilder("");
    if (length == 1) {
      temp.append(nums[nums.length - 1]);
    } else {
      temp.append(nums[start]).append("->").append(nums[nums.length - 1]);
    }
    result.add(temp.toString());
    return result;
  }
}
