package com.practice.scribble;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParanthesis {
  private HashSet<String> expressions = new HashSet<>();
  private int removedThusFar = Integer.MAX_VALUE;

  public static void main(String[] args) {
    RemoveInvalidParanthesis me = new RemoveInvalidParanthesis();
    me.removeInvalidParentheses("(()"); //
  }

  private List<String> removeInvalidParentheses(String s) {
    recurse(s, 0, 0, 0, new StringBuilder(""), 0);
    return new ArrayList<>(this.expressions);
  }

  private void recurse(
          String s,
          int index,
          int leftCount,
          int rightCount,
          StringBuilder expSoFar,
          int removedCount) {

    // Recursion base condition to terminate the execution
    if (s.length() == index) {
      if (leftCount == rightCount) {
        if (this.removedThusFar >= removedCount) {
          String possibleAnswer = expSoFar.toString();
          if (this.removedThusFar > removedCount) {
            this.expressions.clear();
            this.removedThusFar = removedCount;
          }
          this.expressions.add(expSoFar.toString());
        }
      }
    } else {
      char current = s.charAt(index);
      int length = expSoFar.length();
      // handle the case of adding the characters as is and continuing the recursion
      if (current != '(' && current != ')') {
        expSoFar.append(current);
        recurse(s, index + 1, leftCount, rightCount, expSoFar, removedCount);
        expSoFar.deleteCharAt(length);
      } else {
        // In case of ( or ) run the first run by excluding the character
        recurse(s, index + 1, leftCount, rightCount, expSoFar, removedCount + 1);
        expSoFar.append(current);
        if (current == '(') {
          recurse(s, index + 1, leftCount + 1, rightCount, expSoFar, removedCount);
        } else if (leftCount > rightCount) {

          recurse(s, index + 1, leftCount, rightCount + 1, expSoFar, removedCount);
        }
        expSoFar.deleteCharAt(length);
      }
    }
  }
}
