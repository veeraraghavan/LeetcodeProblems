/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/16/21, 11:26 PM
 * =========================================
 */

package com.practice.serious;

public class Ternary {
  public static void main(String[] args) {
    Ternary me = new Ternary();
  }

  int index = 0;

  public String parseTernary(String expression) {
    return Character.toString(helper(expression));
  }

  private char helper(String s) {
    char c = s.charAt(index);
    if (index + 1 == s.length() || s.charAt(index + 1) == ':') {
      index += 2;
      return c;
    }
    index += 2;
    char left = helper(s), right = helper(s);
    if (c == 'T') return left;
    else return right;
  }
}
