/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/15/21, 9:55 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class partitionIntoNumber {

  public static void main(String[] args) {
    partitionIntoNumber me = new partitionIntoNumber();
    System.out.println(me.minPartitions("32"));
  }

  private int minPartitions(String n) {
    int length = n.length();
    int index = 0;
    List<String> result = new ArrayList<>();
    while (index < length) {
      int nextChar = n.charAt(length - index - 1) - '0';
      int subIndex = 0;
      while (subIndex < nextChar) {
        if (result.size() > subIndex) {
          subIndex++;
          continue;
        }
        result.add("");
        subIndex++;
      }
      index++;
    }

    return result.size();
  }
}
