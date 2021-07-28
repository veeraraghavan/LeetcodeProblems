/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/28/21, 12:53 AM
 * =========================================
 */

package com.practice.serious;
// https://leetcode.com/problems/palindrome-number
public class NumberPalindrome {
  public static void main(String[] args) {
    NumberPalindrome me = new NumberPalindrome();
    System.out.println(me.isPalindrome(121));
  }

  private boolean isPalindrome(int x) {
    int y = 0;
    if (x < 0) return false;
    int temp = x;
    while (x != 0) {
      y = (y * 10) + (x % 10);
      x /= 10;
    }
    return temp == y ? true : false;
  }
}
