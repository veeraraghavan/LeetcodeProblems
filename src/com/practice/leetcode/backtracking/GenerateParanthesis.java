package com.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        GenerateParanthesis me = new GenerateParanthesis();
        me.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurse(n,n,"",result);
        return result;

    }

    public void recurse(int leftCount,int rightCount,String currentString,List<String> result){
        if(leftCount==0 && rightCount==0){
            result.add(currentString);
            return;
        }
        if(leftCount>0){
            recurse(leftCount-1,rightCount,currentString+"(",result);
        }
        if(rightCount>leftCount){
            recurse(leftCount,rightCount-1,currentString+")",result);
        }

    }
}
