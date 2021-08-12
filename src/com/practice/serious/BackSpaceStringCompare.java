/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 8:47 PM
 * =========================================
 */

package com.practice.serious;

public class BackSpaceStringCompare {
  public static void main(String[] args) {
    BackSpaceStringCompare me = new BackSpaceStringCompare();
    System.out.println(me.backspaceCompare("bbbextm", "bbb#extm"));
  }

  private boolean backspaceCompare(String S, String T) {
    int index1 = S.length() - 1;
    int index2 = T.length() - 1;
    while (index1 >= 0 || index2 >= 0) {
      int i1 = nextValidCharacter(S, index1);
      int i2 = nextValidCharacter(T, index2);
      if (i1 < 0 && i2 < 0) return true;
      else if (i1 < 0 || i2 < 0) return false;
      else if (S.charAt(i1) != T.charAt(i2)) return false;
      index1 = i1 - 1;
      index2 = i2 - 1;
    }
    return true;
  }

  private int nextValidCharacter(String s, int index) {
    int backSpace = 0;
    while (index >= 0) {
      if (s.charAt(index) == '#') backSpace++;
      else if (backSpace > 0) backSpace--;
      else break;
      index--;
    }
    return index;
  }
}
