/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/29/22, 12:32 AM
 * =========================================
 */

package com.practice.lastdance;

public class repeated {
  public static void main(String[] args) {
    repeated me = new repeated();
    System.out.println(me.repeatedString("gfcaaaecbg", 547602));
  }

  long repeatedString(String s, long n) {
    // Write your code here

    int length = s.length();
    int occurrences = 0;
    for (char c : s.toCharArray()) {
      if (c == 'a') occurrences++;
    }

    long result = 0;
    if (occurrences == 0) return result;
    double ratio = occurrences / (length * 1.0);
    result = (int) Math.round((ratio * n));
    return result;
  }
}
