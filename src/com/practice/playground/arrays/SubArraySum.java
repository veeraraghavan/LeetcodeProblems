package com.practice.playground.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int[] input={1,1,1};
        SubArraySum me = new SubArraySum();
        System.out.println(me.subarraySum(input,2));
    }
    public int subarraySum(int[] nums, int k) {
        //Keep adding the sum cumulatively for each index.
        // Keep a hash map all the cumulative sums.
        // Eq 1,2,3,4,5 and check for Sum 3,
        // If CumSum equals k , increment the count by 1.
        // At i=1(starting from 0 index) , Sum = 3
        // After that we also check for Map[CumSum-k] .
        // If it exists increment the count by 1, This is required when 0 is present in Array
        // Else create a entry for Map[CumSum-k]
        //
        //Also check
        int count =0;
        int currSum=0;
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(currSum==k)
                count++;
            if(countMap.containsKey(currSum-k))
                count+=countMap.get(currSum-k);
            if(countMap.containsKey(currSum))
                countMap.put(currSum,countMap.get(currSum)+1);
            else
                countMap.put(currSum,1);

        }
        return count;

    }
}
