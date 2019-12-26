package com.practice.amzn;

import java.util.List;

public class AmazonTest {
    public static void main(String[] args) {
        AmazonTest me = new AmazonTest();
        System.out.println(me.dfs(5, 4, 0, 0, new int[][]{{1, 1, 1,1}, {0,1, 1, 1}, {0,1,0, 1},{1,1,9,1},{0,0,1,1}}));
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        int[][] arr = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                arr[i][j] = area.get(i).get(j);
            }
        } // WRITE YOUR CODE HERE
        return dfs(3, 3, 0, 0, new int[][]{{1, 0, 0}, {1, 0, 0}, {1, 9, 1}});
    }
    // METHOD SIGNATURE ENDS

    int dfs(int numRows, int numColumns, int i, int j, int[][] a) {
        int result = Integer.MAX_VALUE / 2;
        int minimum = Integer.MAX_VALUE;
        if (i < 0 || i >= numRows || j < 0 || j >= numColumns || a[i][j] == 0)
            return Integer.MAX_VALUE / 2;
        if (a[i][j] == 9)
            return 0;
        a[i][j] = 0;
        minimum = Math.min(minimum, dfs(numRows, numColumns, i + 1, j, a));
        minimum = Math.min(minimum, dfs(numRows, numColumns, i - 1, j, a));
        minimum = Math.min(minimum, dfs(numRows, numColumns, i, j + 1, a));
        minimum = Math.min(minimum, dfs(numRows, numColumns, i, j - 1, a));
        a[i][j] = 1;
        if (minimum != Integer.MAX_VALUE / 2)
            return 1 + minimum;
        else
            return Integer.MAX_VALUE;

    }
}
