package com.practice.scribble;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloons {
    public static void main(String[] args) {
        BurstBalloons me = new BurstBalloons();
        System.out.println(me.maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        ArrayList<Integer> tmpList = new ArrayList<>();
        int res =  burst(memo, nums, 0, n - 1,tmpList);
        return res;
    }

    public int burst(int[][] memo, int[] nums, int left, int right,ArrayList<Integer> temp) {

        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i) {
            int tmp = nums[left] * nums[i] * nums[right];
            ans = Math.max(ans, tmp
                    + burst(memo, nums, left, i,temp) + burst(memo, nums, i, right,temp));
            temp.add(ans);

        }
        memo[left][right] = ans;
        return ans;
    }
}
