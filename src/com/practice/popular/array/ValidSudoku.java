package com.practice.popular.array;

import java.util.HashMap;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku me = new ValidSudoku();
        System.out.println(me.isValidSudoku(new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));

    }

    public boolean isValidSudoku(char[][] board) {
        boolean found = true;

        for (int i = 0; i < board.length; i++) {
            HashMap<Character, Boolean> map = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                if(Character.isDigit(board[i][j])){
                    if (map.containsKey(board[i][j])) {
                        return false;
                    } else {
                        map.put(board[i][j], true);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            HashMap<Character, Boolean> mapColumn = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                if(Character.isDigit(board[j][i])){
                    if (mapColumn.containsKey(board[j][i])) {
                        return false;
                    } else {
                        mapColumn.put(board[j][i], true);
                    }
                }
            }
        }

           for(int i=0;i<board.length;i+=3){
             for(int j=0;j<board[i].length;j+=3){
                HashMap<Character,Boolean> mapSmaller = new HashMap<>();
                int row=i,column=j;
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if(Character.isDigit(board[k][l])){
                            if(mapSmaller.containsKey(board[k][l])){
                                return false;
                            }else{
                                mapSmaller.put(board[k][l],true);
                            }
                        }
                    }
                }
             }
           }

        return true;

    }
}
