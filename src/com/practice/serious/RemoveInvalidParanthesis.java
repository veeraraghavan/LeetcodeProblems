/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/16/21, 11:34 AM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParanthesis {
  public static void main(String[] args) {
    RemoveInvalidParanthesis me = new RemoveInvalidParanthesis();
  }

  int maxRemoved = Integer.MAX_VALUE;
  HashSet<String> result;

  public List<String> removeInvalidParentheses(String s) {
    result = new HashSet<>();
    recurse(new StringBuilder(), 0, 0, 0, 0, s);
    return new ArrayList<>(result);
  }

  public void recurse(
      StringBuilder exp, int left, int right, int removedCount, int index, String s) {
    if (index == s.length()) {
      if (left == right) {
        if (this.maxRemoved >= removedCount) {
          if (this.maxRemoved == removedCount) {
            this.result.add(exp.toString());
          } else {
            this.result.clear();
            this.result.add(exp.toString());
            this.maxRemoved = removedCount;
          }
        }
      }
      return;
    }
    if (s.charAt(index) != '(' && s.charAt(index) != ')') {
      exp.append(s.charAt(index));
      recurse(exp, left, right, removedCount, index + 1, s);
      exp.deleteCharAt(exp.length() - 1);
    } else {
      recurse(exp, left, right, removedCount + 1, index + 1, s);
      if (s.charAt(index) == '(') {
        exp.append(s.charAt(index));
        recurse(exp, left + 1, right, removedCount, index + 1, s);
        exp.deleteCharAt(exp.length() - 1);
      } else if (left > right) {
        exp.append(")");
        recurse(exp, left, right + 1, removedCount + 1, index + 1, s);
        exp.deleteCharAt(exp.length() - 1);
      }
    }
  }
}
