package com.practice.playground.misc;

public class PredictWinner {
  public static void main(String[] args) {
    PredictWinner me = new PredictWinner();
    int[] input = new int[] {1, 5, 2};
    System.out.println(me.PredictTheWinner(input));
  }

  private boolean PredictTheWinner(int[] nums) {
    if (nums.length == 1) return true;
    return canWin(0, nums.length - 1, 0, 'A', nums);
  }

  private boolean canWin(int start, int end, int score, char player, int[] nums) {
    if (start > end) {
      if (score > 0) return false;
      return true;
    }
    return !canWin(
            start + 1,
            end,
            player == 'A' ? score + nums[start] : score - nums[start],
            player == 'A' ? 'B' : 'A',
            nums)
        || !canWin(
            start,
            end - 1,
            player == 'A' ? score + nums[end] : score - nums[end],
            player == 'A' ? 'B' : 'A',
            nums);
  }

  private int getScoreDiff(int[] nums, int leftIdx, int rightIdx, int player) {
    if (leftIdx == rightIdx) {
      return nums[leftIdx];
    } else {
      if (player == 1) {
        int left = nums[leftIdx] + getScoreDiff(nums, leftIdx + 1, rightIdx, 2);
        int right = nums[rightIdx] + getScoreDiff(nums, leftIdx, rightIdx - 1, 2);
        return Math.max(left, right);
      } else {
        int left = getScoreDiff(nums, leftIdx + 1, rightIdx, 1) - nums[leftIdx];
        int right = getScoreDiff(nums, leftIdx, rightIdx - 1, 1) - nums[rightIdx];
        return Math.min(left, right);
      }
    }
  }
}
