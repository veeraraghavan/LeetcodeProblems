/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/5/21, 10:00 PM
 * =========================================
 */

package com.practice.finalfrontier;

public class RemoveElement_27 {
  public static void main(String[] args) {
    RemoveElement_27 me = new RemoveElement_27();
  }

  private int remove(int[] nums, int k) {
    int current = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != k) {
        nums[current++] = nums[i];
      }
    }
    return current;
  }
}
