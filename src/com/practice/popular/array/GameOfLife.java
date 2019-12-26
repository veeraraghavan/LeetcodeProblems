package com.practice.popular.array;

public class GameOfLife {
    public static void main(String[] args) {
        GameOfLife me = new GameOfLife();
        me.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int column = board[0].length;
        int state;
        int[][] result = new int[row][column] ;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                state = 0;
                //previous row
                if(i-1>=0){
                    if(j-1 >= 0){
                        state+=board[i-1][j-1];
                    }
                    if(j<column-1){
                        state+=board[i-1][j+1];
                    }
                    state+=board[i-1][j];
                }
                //next row
                if(i<row-1){
                    if(j-1 >= 0){
                        state+=board[i+1][j-1];
                    }
                    if(j<column-1){
                        state+=board[i+1][j+1];
                    }
                    state+=board[i+1][j];

                }
                //current row
                if(j-1 >= 0){
                    state+=board[i][j-1];

                }
                if(j<column-1){
                    state+=board[i][j+1];
                }
                if(board[i][j]==1){
                    if(state<2){
                        result[i][j]=0;
                    }else if(state > 3)
                        result[i][j]=0;
                    else
                        result[i][j]=board[i][j];

                }else{
                    if(state==3)
                        result[i][j]=1;
                }


            }
        }
        board=result;
    }
}
