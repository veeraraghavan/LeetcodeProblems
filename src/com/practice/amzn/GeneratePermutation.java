package com.practice.amzn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GeneratePermutation {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        GeneratePermutation me = new GeneratePermutation();
        me.permute(new int[]{1,2,3},result,new ArrayList<>());
        System.out.println();
    }
    public void permute(int[] arr, List<List<Integer>> result,List<Integer> temp){
        if(temp.size()==arr.length){
            result.add(temp);
            return;
        }
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<temp.size();i++){
            map.put(temp.get(i),true);
        }
        for(int i=0;i<arr.length;i++){
            List tempList = new ArrayList(temp);
            if(!map.containsKey(arr[i])){
                tempList.add(arr[i]);
                permute(arr,result,tempList);
            }

        }

    }
}
