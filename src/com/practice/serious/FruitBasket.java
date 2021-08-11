/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/10/21, 9:38 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class FruitBasket {
  public static void main(String[] args) {
    FruitBasket me = new FruitBasket();
    System.out.println(me.totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
  }

  private int totalFruit(int[] fruits) {
    HashMap<Integer, Integer> fruitFrequency = new HashMap<>();
    int windowStart = 0;
    int max = 0;
    for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
      fruitFrequency.put(fruits[windowEnd], fruitFrequency.getOrDefault(fruits[windowEnd], 0) + 1);
      while (fruitFrequency.size() > 2) {
        fruitFrequency.put(fruits[windowStart], fruitFrequency.get(fruits[windowStart]) - 1);
        if (fruitFrequency.get(fruits[windowStart]) == 0)
          fruitFrequency.remove(fruits[windowStart]);
        windowStart++;
      }

      max = Math.max(max, windowEnd - windowStart + 1);
    }
    return max;
  }
}
