package com.practice.leetcode.array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-the-duplicate-number/
public class AllDuplicates {
    public static void main(String[] args) {
        AllDuplicates me = new AllDuplicates();
        int[] nums = {1,2,2};
        //System.out.println(me.firstMissingPositive(nums));
        System.out.println(me.MissingPositive(nums));
    }

    public List<Integer> MissingPositive(int[] arr) {
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int x = Math.abs(arr[i]);
            if(arr[x-1]<0){
                result.add(x);
            }else{
                arr[x-1] = -arr[x-1];
            }
        }
        return result;

    }

    
}
