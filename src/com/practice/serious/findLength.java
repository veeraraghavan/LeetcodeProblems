/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/30/21, 10:31 PM
 * =========================================
 */

package com.practice.serious;

public class findLength {
  public static void main(String[] args) {
    findLength me = new findLength();
  }

  public int findLength(int[] nums1, int[] nums2) {
    int ans = 0;
    int[][] dp = new int[nums1.length + 1][nums2.length + 1];
    for (int i = nums1.length - 1; i >= 0; i--) {
      for (int j = nums2.length - 1; j >= 0; j--) {
        if (nums1[i] == nums2[j]) {
          dp[i][j] = 1 + dp[i + 1][j + 1];
        }
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans;
  }
}
