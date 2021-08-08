/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/7/21, 10:47 PM
 * =========================================
 */

package com.practice.serious;

public class DeleteAndEarn {
  public static void main(String[] args) {
    DeleteAndEarn me = new DeleteAndEarn();
    me.deleteAndEarn(new int[] {2, 2, 2, 2, 3, 3});
  }

  private int deleteAndEarn(int[] nums) {
    int[] count = new int[1001];
    for (int num : nums) {
      count[num]++;
    }
    int prev = -1;
    int avoid = 0;
    int using = 0;
    for (int i = 0; i < 10001; i++) {
      if (count[i] > 0) {
        int untilNow = Math.max(avoid, using);
        if (i - 1 == prev) {
          using = avoid;
        } else {
          using = untilNow;
        }
        using += (count[i] * i);
        avoid = untilNow;
        prev = i;
      }
    }
    return Math.max(avoid, using);
  }
}
