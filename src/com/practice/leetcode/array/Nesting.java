package com.practice.leetcode.array;

import java.util.HashMap;

public class Nesting {
    public static void main(String[] args) {
        Nesting me = new Nesting();
        int[] a = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(me.arrayNesting(a));
    }

    public int arrayNesting(int[] nums) {
//        HashMap<Integer,Integer> list; ;
        boolean[] visited = new boolean[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (!visited[i]) {

                int start = nums[i];
                do {
                    count++;
                    start = nums[start];
                    visited[start] = true;
                } while (start != nums[i]);
                result = Math.max(result, count);
            }

//          int count=0;
//          list = new HashMap<>();
//          int prev=nums[i];
//          list.put(nums[i],1);
//          count++;
//          int j=i;
//          while(true){
//             if(list.containsKey(nums[prev])){
//                 if(result < count)
//                     result=count;
//                     break;
//              }else{
//                 list.put(nums[prev],1);
//                 count++;
//                 prev = nums[prev];
//              }
//          }
        }
        return result;

    }
}
