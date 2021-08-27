/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/26/21, 11:10 PM
 * =========================================
 */

package com.practice.serious;

public class FreqAlphabets {

  public static void main(String[] args) {
    FreqAlphabets me = new FreqAlphabets();
  }

  public String freqAlphabets(String s) {

    StringBuilder result = new StringBuilder("");
    int length = s.length() - 1;
    while (length >= 0) {
      if (s.charAt(length) == '#') {
        result.insert(
            0,
            (char)
                ('a' + (((s.charAt(length - 2) - '0') * 10 + (s.charAt(length - 1) - '0'))) - 1));
        length = length - 3;

      } else {
        result.insert(0, (char) ('a' + (s.charAt(length) - '1')));
        length--;
      }
    }

    return result.toString();
  }
}
