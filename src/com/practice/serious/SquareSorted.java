/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 4:33 PM
 * =========================================
 */

package com.practice.serious;

public class SquareSorted {
  public static void main(String[] args) {
    SquareSorted me = new SquareSorted();
  }

  public int[] sortedSquares(int[] nums) {
    int res[] = new int[nums.length];
    int left = 0, right = nums.length - 1;
    int highestSquareIndex = right;
    while (left <= right) {
      int leftSquare = nums[left] * nums[left];
      int rightSquare = nums[right] * nums[right];
      if (leftSquare > rightSquare) {
        res[highestSquareIndex--] = leftSquare;
        left++;
      } else {
        res[highestSquareIndex--] = rightSquare;
        right--;
      }
    }
    return res;
  }
}
