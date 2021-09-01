/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/31/21, 11:23 PM
 * =========================================
 */

package com.practice.serious;

public class CountMatches {
  public static void main(String[] args) {
    CountMatches me = new CountMatches();
  }

  public int numberOfMatches(int n) {
    int res = 0;
    while (n > 1) {
      res += n / 2;
      if (n % 2 != 0) {
        n = n / 2 + 1;
      } else {
        n = n / 2;
      }
    }
    return res;
  }
}
