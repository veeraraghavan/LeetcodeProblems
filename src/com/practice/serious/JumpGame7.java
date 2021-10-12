/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/6/21, 11:46 PM
 * =========================================
 */

package com.practice.serious;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame7 {
  public static void main(String[] args) {
    JumpGame7 me = new JumpGame7();
  }

  public boolean canReach(String s, int minJump, int maxJump) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int maxReach = 0;
    char[] cs = s.toCharArray();
    while (!queue.isEmpty()) {
      int index = queue.poll();
      if (index == s.length() - 1) return true;
      for (int i = Math.max(index + minJump, maxReach);
          i <= Math.min(s.length() - 1, maxJump + index);
          i++) {
        if (cs[i] == '0') {
          queue.offer(i);
        }
        maxReach = Math.min(index + maxJump + 1, s.length() - 1);
      }
    }

    return false;
  }
}
