/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/5/21, 3:19 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGame6 {
  public static void main(String[] args) {
    JumpGame6 me = new JumpGame6();
  }

  public int maxResult(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int[] score = new int[nums.length];
    deque.offer(0);
    score[0] = nums[0];
    for (int i = 1; i < nums.length - 1; i++) {
      while (deque.peekFirst() != null && deque.peekFirst() < (i - k)) {
        deque.pollFirst();
      }
      score[i] = nums[deque.peekFirst()] + nums[i];
      while (deque.peekLast() != null && score[deque.peekLast()] < score[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }
    return score[nums.length - 1];
  }
  // 1,-1,-2,4,-7,3
  /*10,-5,-2,4,0,3
  14



  */

}
