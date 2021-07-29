/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/28/21, 8:26 PM
 * =========================================
 */

package com.practice.serious;
// https://leetcode.com/problems/number-of-substrings-with-only-1s/submissions/
public class numSub {
  public static void main(String[] args) {
    numSub me = new numSub();
    System.out.println(me.numSub("0110111"));
  }

  private int numSub(String s) {

    char[] cs = s.toCharArray();
    int res = 0;
    int temp = 0;
    for (int i = 0; i < cs.length; i++) {
      if (cs[i] == '1') {
        temp++;
        res += temp;
        res %= 1000000007;
      } else {
        temp = 0;
      }
    }

    return res;
  }
}
