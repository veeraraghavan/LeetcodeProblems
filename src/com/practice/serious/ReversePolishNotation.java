/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/23/21, 9:15 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReversePolishNotation {

  public static void main(String[] args) {
    ReversePolishNotation me = new ReversePolishNotation();
    System.out.println(me.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
  }

  private String plus = "+";
  private String minors = "-";
  private String multiple = "*";
  private String divide = "/";
  private Map<String, Integer> map = new HashMap<>();

  private int index = 0;

  private int evalRPN(String[] tokens) {
    map.put(plus, 0);
    map.put(minors, 1);
    map.put(multiple, 2);
    map.put(divide, 3);
    return dfs(tokens)[0];
  }

  private int[] dfs(String[] tokens) {
    int sum = Integer.valueOf(tokens[index]);
    index++;
    while (index < tokens.length && !isOperand(tokens[index])) {
      int[] result = dfs(tokens);
      if (result[1] == 0) {
        sum += result[0];
      } else if (result[1] == 1) {
        sum -= result[0];
      } else if (result[1] == 2) {
        sum *= result[0];
      } else {
        sum /= result[0];
      }
    }
    int[] result = {sum, index < tokens.length ? map.get(tokens[index]) : -1};
    index++;
    return result;
  }

  private boolean isOperand(String token) {
    return plus.equals(token)
        || minors.equals(token)
        || multiple.equals(token)
        || divide.equals(token);
  }

  public int evalRPNStack(String[] tokens) {
    Stack<Integer> expression = new Stack();
    for (String token : tokens) {
      if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
        int right = expression.pop();
        int left = expression.pop();
        int temp = 0;
        switch (token.charAt(0)) {
          case '+':
            temp = left + right;
            break;
          case '-':
            temp = left - right;
            break;
          case '*':
            temp = left * right;
            break;
          case '/':
            temp = left / right;
            break;
        }
        expression.push(temp);

      } else {
        expression.push(Integer.parseInt(token));
      }
    }
    return expression.pop();
  }
}
