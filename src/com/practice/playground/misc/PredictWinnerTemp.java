package com.practice.playground.misc;

public class PredictWinnerTemp {
    public static void main(String[] args) {
        PredictWinnerTemp me = new PredictWinnerTemp();
        int[] input = new int[]{1,1};
        System.out.println(me.PredictTheWinner(input));
    }



    public boolean PredictTheWinner(int[] nums) {
        // Player A has 2 numbers to choose
        // Player A plays first and he can choose based on what's the best outcome would be
        // Simulate both ways and check if he can win
        // Records playerA ,Bs total
        if(nums.length==1)
            return true;
        return (Total(0, nums.length - 1, nums, 'A', 0, 0));
    }



    public boolean Total(int start, int end, int[] nums, char player, int A, int B) {
        if (start > end) {
            if (A >= B) return true;
            return false;
        }
        //choosing left
        return !(Total(start + 1, end, nums,
                player == 'A' ? 'B' : 'A',
                player == 'A' ? A + nums[start] : A,
                player == 'B' ? B + nums[start] : B)
                && Total(start, end - 1, nums,
                player == 'A' ? 'B' : 'A',
                player == 'A' ? A + nums[end] : A,
                player == 'B' ? B + nums[end] : B));



    }
}
