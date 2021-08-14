/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/14/21, 1:16 AM
 * =========================================
 */

package com.practice.serious;

public class judgeCircle {
  public static void main(String[] args) {
    judgeCircle me = new judgeCircle();
    System.out.println(me.judgeCircle("RRLL"));
  }

  private boolean judgeCircle(String moves) {
    int x = 0, y = 0;
    for (char next : moves.toCharArray()) {
      switch (next) {
        case 'L':
          x--;
        case 'R':
          x++;
        case 'U':
          y++;
        case 'D':
          y--;
      }
    }
    return x == 0 && y == 0;
  }

  public boolean judgeCircleSuperior(String moves) {
    int[] value = new int[128];
    value['U'] = 1;
    value['D'] = -1;
    value['L'] = 20;
    value['R'] = -20;
    int res = 0;
    for (char next : moves.toCharArray()) {
      res += value[next];
    }
    return res == 0;
  }
}
