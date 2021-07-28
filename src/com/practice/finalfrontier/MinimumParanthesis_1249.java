/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   5/20/21, 8:13 PM
 * =========================================
 */

package com.practice.finalfrontier;

public class MinimumParanthesis_1249 {
  public static void main(String[] args) {
    MinimumParanthesis_1249 me = new MinimumParanthesis_1249();
    me.minRemoveToMakeValid("))((");
  }

  private String minRemoveToMakeValid(String s) {
    // Navigate from left to right the given string in first and keep adding characters into a
    // result string
    // As you find the first ')' without a corresponding '(' ignore the character.
    // Keep count of all the '(' seen so far in a counter variable.
    // Keep count of the unbalanced characters number in another counter ( list of all '(' with out
    // the closing ')'
    // After the first pass we are left with only unbalanced '(' if they exist. Remove the rightmost
    // ')' to balance the
    // string.

    StringBuilder result = new StringBuilder();
    int openParenthesis = 0;
    int balance = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        balance++;
        openParenthesis++;
      } else if (s.charAt(i) == ')') {
        if (balance == 0) continue;
        balance--;
      }
      result.append(s.charAt(i));
    }
    if (balance > 0) {
      int openParenToKeep = openParenthesis - balance;
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < result.length(); i++) {
        if (result.charAt(i) == '(') {
          openParenthesis--;
          if (openParenToKeep < 0) continue;
        }
        res.append(result.charAt(i));
      }
      return res.toString();

    } else {
      return result.toString();
    }
  }
}
