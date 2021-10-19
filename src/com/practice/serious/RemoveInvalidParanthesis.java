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
    me.removeInvalidParentheses2("()())()");
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

  public List<String> removeInvalidParentheses2(String s) {
    List<String> res = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return res;
    }
    backtrack(s, res, 0, 0, '(', ')');
    return res;
  }

  public void backtrack(String s, List<String> res, int left, int right, char open, char close) {
    int count = 0;
    for (; right < s.length(); right++) {
      if (s.charAt(right) == open) {
        count++;
      } else if (s.charAt(right) == close) {
        count--;
      }
      if (count < 0) {
        break;
      }
    }
    if (count < 0) {
      for (; left <= right; left++) {
        char c = s.charAt(left);
        if (c != close || (left > 0 && s.charAt(left - 1) == c)) continue;
        backtrack(s.substring(0, left) + s.substring(left + 1), res, left, right, open, close);
      }
    } else if (count > 0) {
      if (open == '(') {
        backtrack(new StringBuilder(s).reverse().toString(), res, 0, 0, close, open);
      }
    } else {
      res.add(open == '(' ? s : new StringBuilder(s).reverse().toString());
    }
  }
}
