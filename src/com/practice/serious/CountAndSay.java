/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/14/21, 12:18 AM
 * =========================================
 */

package com.practice.serious;

public class CountAndSay {
  public static void main(String[] args) {
    CountAndSay me = new CountAndSay();
    System.out.println(me.countAndSay(5));
  }

  private String countAndSay(int n) {
    if (n == 1) return "1";
    if (n == 2) return "11";
    String prev = countAndSay(n - 1);
    StringBuilder res = new StringBuilder();
    int index = 1;
    char start = prev.charAt(0);
    int count = 1;
    while (index < prev.length()) {
      if (prev.charAt(index) == start) {
        count++;
        index++;
        continue;
      }
      res.append(count).append(start);
      count = 1;
      start = prev.charAt(index++);
    }
    res.append(count).append(prev.charAt(index - 1));
    // res += count + "" + prev.charAt(index - 1);

    return res.toString();
  }
}
