package com.practice.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2){
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<int[]>();
        int[] interval = intervals[0];
        for(int[] tempInterval:intervals){
            if (tempInterval[0]<interval[1]){
                interval[1] = Math.max(tempInterval[1],interval[1]);
            }else{
                result.add(interval);
                interval = tempInterval;
            }
        }
        return (int[][]) result.toArray();

    }
}
