/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/10/21, 11:45 PM
 * =========================================
 */

package com.practice.serious;

public class MaxConsecutiveOnes {
  public static void main(String[] args) {
    MaxConsecutiveOnes me = new MaxConsecutiveOnes();
  }

  public int longestOnes(int[] nums, int k) {
    int ws = 0;
    int max = 0;

    int[] freq = new int[2];
    for (int we = 0; we < nums.length; we++) {
      freq[we]++;
      while (freq[0] > k) {
        freq[ws]--;
        ws++;
      }
      max = Math.max(max, we - ws + 1);
    }
    return max;
  }

  public int longestOnesfaster(int[] arr, int k) {
    int windowStart = 0, maxLength = 0, maxOnesCount = 0;
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      if (arr[windowEnd] == 1) maxOnesCount++;

      // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
      // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
      // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
      // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
      // are not allowed to replace more than 'k' Os
      if (windowEnd - windowStart + 1 - maxOnesCount > k) {
        if (arr[windowStart] == 1) maxOnesCount--;
        windowStart++;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
}
