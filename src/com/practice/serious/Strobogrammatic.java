/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/26/21, 11:05 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class Strobogrammatic {
  public static void main(String[] args) {
    Strobogrammatic me = new Strobogrammatic();
    me.findStrobogrammatic(2);
  }

  public List<String> findStrobogrammatic(int n) {
    List<String> result = new ArrayList<>();
    int start = n == 1 ? 0 : (int) Math.pow(10, n - 1);
    int end = (int) Math.pow(10, n);
    for (int i = start; i < end; i++) {
      String input = Integer.toString(i);
      if (inverted(input).equals(input)) result.add(input);
    }
    return result;
  }

  public String inverted(String text) {
    // String text = Integer.toString(num);
    StringBuilder invert = new StringBuilder();
    for (char c : text.toCharArray()) {
      int response = getInvertedCounterpart(c - '0');
      if (response == -1) return "";
      invert.append(response);
    }
    return invert.reverse().toString();
  }

  public int getInvertedCounterpart(int num) {
    switch (num) {
      case 1:
        return 1;
      case 8:
        return 8;
      case 0:
        return 0;
      case 6:
        return 9;
      case 9:
        return 6;
      default:
        return -1;
    }
  }
}
