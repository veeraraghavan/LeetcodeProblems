/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/13/21, 8:31 PM
 * =========================================
 */

package com.practice.serious;

public class PredictWinner {
  public static void main(String[] args) {
    PredictWinner me = new PredictWinner();
    System.out.println(me.PredictTheWinner(new int[] {1, 5, 2}));
  }

  private boolean PredictTheWinner(int[] nums) {
    return predict(nums, 0, nums.length - 1, true, 0, 0);
  }

  private boolean predict(int[] nums, int start, int end, boolean playerA, int sumA, int sumB) {
    if (start > end) {
      if (sumA > sumB) return true;
      return false;
    }
    if (playerA) {
      return predict(nums, start + 1, end, false, sumA + nums[start], sumB)
          || predict(nums, start, end - 1, false, sumA + nums[end], sumB);
    }
    return predict(nums, start + 1, end, true, sumA, sumB + nums[start])
        && predict(nums, start, end - 1, true, sumA, sumB + nums[end]);

    //    return !(predict(
    //            nums,
    //            start + 1,
    //            end,
    //            !playerA,
    //            playerA == true ? sumA + nums[start] : sumA,
    //            playerA == true ? sumB : sumB + nums[start])
    //        && predict(
    //            nums,
    //            start,
    //            end - 1,
    //            !playerA,
    //            playerA == true ? sumA + nums[end] : sumA,
    //            playerA == true ? sumB : sumB + nums[end]));
  }
}
