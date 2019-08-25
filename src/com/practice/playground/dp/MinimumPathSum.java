package com.practice.playground.dp;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] input = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumPathSum me = new MinimumPathSum();
        System.out.println(me.minPathSum(input));
    }

    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    if (j != 0) {
                        grid[i][j] += grid[i][j - 1];
                    }
                } else {
                    if (j == 0) {
                        grid[i][j] += grid[i - 1][j];

                    } else {
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    }
                }

            }
        }
        return grid[grid.length-1][grid[0].length-1];

    }
}
