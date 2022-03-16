/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/5/22, 6:44 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.Arrays;

public class largestnumber {
  public static void main(String[] args) {
    largestnumber me = new largestnumber();
    System.out.println(me.largestNumber(new int[] {111311, 1113}));
  }

  public String largestNumber(int[] nums) {

    String[] snums = new String[nums.length];
    int index = 0;
    for (int num : nums) {
      snums[index++] = String.valueOf(num);
    }
    Arrays.sort(
        snums,
        (a, b) -> {
          String first = a + b;
          String second = b + a;
          return second.compareTo(first);
        });

    StringBuilder result = new StringBuilder();
    for (String snum : snums) {
      result.append(snum);
    }
    if (result.charAt(0) == '0') return "0";
    return result.toString();
  }
}
