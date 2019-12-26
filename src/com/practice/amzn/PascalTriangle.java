package com.practice.amzn;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle me = new PascalTriangle();
        me.generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        for(int i=0;i<numRows;i++){
            if(i==0){
                List<Integer> temp = new ArrayList();
                temp.add(1);
                result.add(temp);
            }else if(i==1){
                List<Integer> temp = new ArrayList();
                temp.add(1);
                temp.add(1);
                result.add(temp);

            }else{
                int record = 0;
                List<Integer> temp = new ArrayList<>();
                while(record<i+1){
                    if(record==0){
                        temp.add(result.get(i-1).get(0));
                    }else if(record==i){
                        temp.add(result.get(i-1).get(i-1));
                    }else{
                        temp.add(result.get(i-1).get(record)+result.get(i-1).get(record-1));
                    }
                    record++;
                }
                result.add(temp);
            }
        }
        return result;

    }
}
