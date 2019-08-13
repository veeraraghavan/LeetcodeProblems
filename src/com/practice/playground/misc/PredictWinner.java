package com.practice.playground.misc;

public class PredictWinner {
    public static void main(String[] args) {
        PredictWinner me = new PredictWinner();
        int[] input = new int[]{1,5,2};
        System.out.println(me.PredictTheWinner(input));
    }

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 1)
            return true;
        return canWin(0, nums.length - 1, 0, 'A', nums);
    }

    public boolean canWin(int start, int end, int score, char player, int[] nums) {
        if (start > end) {
            if (score > 0)
                return false;
            return true;
        }
        return !canWin(start + 1, end, player == 'A' ? score + nums[start] : score - nums[start], player == 'A' ? 'B' : 'A', nums) || !canWin(start, end - 1, player == 'A' ? score + nums[end] : score - nums[end], player == 'A' ? 'B' : 'A', nums);
    }
}
