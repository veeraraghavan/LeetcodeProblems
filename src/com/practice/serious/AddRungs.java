/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/21/21, 5:35 PM
 * =========================================
 */

package com.practice.serious;

public class AddRungs {

  public static void main(String[] args) {
    AddRungs me = new AddRungs();
    System.out.println(me.addRungs(new int[] {1, 3, 5, 10}, 2));
  }

  private int addRungs(int[] rungs, int dist) {
    int[] distances = new int[rungs.length];
    for (int i = 0; i < rungs.length; i++) {
      if (i == 0) {
        distances[i] = rungs[i] - 0;
        continue;
      }
      distances[i] = rungs[i] - rungs[i - 1];
    }
    int add = 0;
    for (int i = 0; i < distances.length; i++) {

      if (distances[i] > dist) {
        int diff = distances[i];
        if (diff % dist == 0) {
          add += (diff / dist) - 1;
        } else {
          add += (diff / dist);
        }
      }
    }
    return add;
  }
}
