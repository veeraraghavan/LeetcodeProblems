/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/4/21, 10:44 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PowerfulIntegers {
  public static void main(String[] args) {
    PowerfulIntegers me = new PowerfulIntegers();
  }

  public List<Integer> powerfulIntegers(int x, int y, int bound) {
    // x^a=bound , a = log bound to base x
    int a = x == 1 ? bound : (int) Math.log(bound) / (int) Math.log(x);
    int b = y == 1 ? bound : (int) Math.log(bound) / (int) Math.log(y);
    HashSet<Integer> result = new HashSet<>();
    for (int i = 0; i <= x; i++) {
      for (int j = 0; j <= y; j++) {
        int value = (int) Math.pow(a, i) + (int) Math.pow(b, j);
        if (value <= bound) result.add(value);
        if (y == 1) break;
      }
      if (x == 1) break;
    }
    return new ArrayList<Integer>(result);
  }
}
