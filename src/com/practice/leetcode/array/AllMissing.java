package com.practice.leetcode.array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-the-duplicate-number/
public class AllMissing {
    public static void main(String[] args) {
        AllMissing me = new AllMissing();
        int[] nums = {1,2,0};
        //System.out.println(me.firstMissingPositive(nums));
        System.out.println(me.MissingPositive(nums));
    }

    public int MissingPositive(int[] arr) {
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int x = Math.abs(arr[i]);
            if(x-1 < arr.length && arr[x-1]>0){
               arr[x-1] = -arr[x-1];
            }
        }
        int j=0;
        for(j=0;j<arr.length;j++){
            if(arr[j]>0)
                result.add(j+1);
        }
        return arr.length+1;

    }

    
}
