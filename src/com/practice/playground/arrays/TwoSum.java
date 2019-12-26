package com.practice.playground.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum me = new TwoSum();
        int[] input = {3,3};
        me.twoSum(input,6);
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer> valMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            valMap.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            if(valMap.containsKey(target-nums[i]) && valMap.get(target-nums[i])!=i){
                result[0] = i;
                result[1] = valMap.get(target-nums[i]);
                return result;
            }
           // Arrays.asList()

        }
        return result;
    }
}
