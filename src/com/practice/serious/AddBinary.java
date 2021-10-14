/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/12/21, 11:15 PM
 * =========================================
 */

package com.practice.serious;

public class AddBinary {
  public static void main(String[] args) {
    AddBinary me = new AddBinary();
    System.out.println(me.addBinary("11", "1"));
  }

  public String addBinary(String a, String b) {
    // always assume length of length a is lesser
    if (a.length() > b.length()) {
      return addBinary(b, a);
    }
    int sum = 0, carry = 0;
    StringBuilder result = new StringBuilder();
    int lengthA = a.length();
    int lengthB = b.length();
    StringBuilder as = new StringBuilder(a);
    as.reverse();
    StringBuilder bs = new StringBuilder(b);
    bs.reverse();
    int index = 0;
    while (index < lengthA) {
      sum = carry + (as.charAt(index) - '0') + (bs.charAt(index) - '0');
      carry = sum / 2;
      sum = sum % 2;
      result.append(sum);
      index++;
    }
    while (index < lengthB) {
      sum = carry + (bs.charAt(index) - '0');
      carry = sum / 2;
      sum = sum % 2;
      result.append(sum);
      index++;
    }
    if (carry == 1) result.append(carry);
    result.reverse();
    return result.toString();
  }
}
