/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   5/15/21, 11:11 PM
 * =========================================
 */

package com.practice.leetcode.array;

// https://leetcode.com/problems/single-number-ii/
public class OneTwose_137 {
  public static void main(String[] args) {
    OneTwose_137 me = new OneTwose_137();
  }

  public int singleNumber(int[] nums) {
    // we need three number
    // Ones, twose, threes . Fill each one

    // first fill it in twose if already exists in one
    // XOR with ones again
    // Numbers not in ones and twose are filled into threes.
    // Remove from ones and twose which are in threes

    int ones = 0, twose = 0, threes = 0;
    for (int num : nums) {
      twose = twose | (ones & num);
      ones = ones ^ num;
      threes = ~(ones & twose);
      ones = ones & threes;
      twose = twose & threes;
    }
    return ones;
  }
}
