/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   12/31/21, 10:01 AM
 * =========================================
 */

package com.practice.lastdance;

public class wiggleSort2 {
  public static void main(String[] args) {
    wiggleSort2 me = new wiggleSort2();
  }

  public void wiggleSort(int[] nums) {
    int[] copy = nums.clone();
    int index = 1;
    for (int i = 1; i < nums.length; i += 2) {
      nums[i] = copy[copy.length - index];
      index++;
    }
    for (int i = 0; i < nums.length; i += 2) {
      nums[i] = copy[copy.length - index];
      index++;
    }
  }
}
