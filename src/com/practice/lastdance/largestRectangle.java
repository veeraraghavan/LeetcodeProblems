/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/11/22, 9:25 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.Stack;

public class largestRectangle {
  public static void main(String[] args) {
    largestRectangle me = new largestRectangle();
  }

  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack();
    int n = heights.length;
    int max = 0;
    int v = 0;
    for (int i = 0; i <= n; i++) {
      v = i == n ? 0 : heights[i];
      while (!stack.isEmpty() && v < heights[stack.peek()]) {
        max = Math.max(max, heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1)));
      }
      stack.push(i);
    }
    return max;
  }
}
