/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/18/21, 10:47 PM
 * =========================================
 */

package com.practice.serious;

public class Atoi {
  public static void main(String[] args) {
    Atoi me = new Atoi();
  }

  public int myAtoi(String s) {
    int index = 0;
    int length = s.length();
    boolean isNegative = false;
    while (index < length && s.charAt(index) == ' ') {
      index++;
    }

    if (index < length) {
      if (s.charAt(index) == '-') {
        isNegative = true;
        index++;
      } else if (s.charAt(index) == '+') {
        index++;
      }
    }
    int result = 0;
    while (index < length && Character.isDigit(s.charAt(index))) {
      int digit = s.charAt(index) - '0';
      if (result > (Integer.MAX_VALUE / 10) || result == (Integer.MAX_VALUE / 10) && digit > 7) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      result = (result * 10) + digit;
      ++index;
    }
    return isNegative ? -result : result;
  }
}
