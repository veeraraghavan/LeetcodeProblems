/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/19/21, 10:06 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;

public class NonOverlapping {

  public static void main(String[] args) {
    NonOverlapping me = new NonOverlapping();
    System.out.println(me.minSumOfLengths(new int[] {3, 2, 2, 4, 3}, 3));
  }

  private int minSumOfLengths(int[] arr, int target) {
    /* Conditions to consider
       What if no target sum is present in the entire array . Return -1;
       So have a answer variable a large value. If at the end, the answer
       variable has that large value return -1;
       E.g: return ans == Integer.MAX_VALUE?-1: ans
       Run a for loop. Within the 3 possibilities
       a. If the sumSoFar is greater than target
          keep dropping the array members
       b. If sum == target
          check if is not first element ,then i-start+1
          else
       c. if sum lower than target - do nothing

    */
    int[] best = new int[arr.length];
    int bestSoFar = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    int sum = 0;
    int start = 0;

    Arrays.fill(best, Integer.MAX_VALUE);
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum > target) {
        while (sum > target) {
          sum -= arr[start++];
        }
      }
      if (sum == target) {
        if (start > 0 && best[start - 1] != Integer.MAX_VALUE) {
          ans = Math.min(ans, best[start - 1] + i - start + 1);
        }
        bestSoFar = Math.min(bestSoFar, i - start + 1);
      }
      best[i] = bestSoFar;
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
