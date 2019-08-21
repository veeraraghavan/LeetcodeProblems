package com.practice.playground.graph;

public class Island {
    public static void main(String[] args) {
        Island me = new Island();
        char[][] input = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(me.numIslands(input));
    }

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        if (grid == null || grid.length == 0)
            return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1')
                    islandCount += dfs(grid, i, j);
            }
        return islandCount;

    }

    public int dfs(char[][] grid, int i, int j) {
        if((i<0 || i>=grid.length)||(j<0 || j>=grid[i].length )||grid[i][j]=='0')
            return 0;

        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        return 1;

    }
}
