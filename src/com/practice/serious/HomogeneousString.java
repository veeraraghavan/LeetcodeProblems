/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/28/21, 10:20 PM
 * =========================================
 */

package com.practice.serious;
// https://leetcode.com/problems/count-number-of-homogenous-substrings/
public class HomogeneousString {
  public static void main(String[] args) {
    HomogeneousString me = new HomogeneousString();
  }

  public int countHomogenous(String s) {
    int length = s.length();
    int res = 0;
    char[] cs = s.toCharArray();
    char prev = '1';
    int temp = 0;
    for (int i = 0; i < length; i++) {
      if (prev != cs[i]) {
        temp = 0;
      }
      temp++;
      prev = cs[i];
      res += temp;
      res %= 1000000007;
    }
    return res;
  }
}
