package com.practice.leetcode.twodarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval me = new MergeInterval();
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        me.merge(input);

    }

    public int[][] merge(int[][] intervals) {
        if(!(intervals.length > 0)){
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<int[]>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if(newInterval[1]>=interval[0]){
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }else{
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);


    }
}
