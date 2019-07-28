package com.practice.leetcode.twodarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insertintervak {
    public static void main(String[] args) {
        int[][] input = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] interval = {4, 8};
        insertintervak me = new insertintervak();
        me.insert(input, interval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        List<int[]> otherList = new ArrayList<>();
        for (int[] input : intervals) {
            if ((input[0] >= newInterval[0] && input[1]<= newInterval[1] )||(input[0]<=newInterval[0] && input[1]>=newInterval[0])||(input[0]<=newInterval[1] && input[1]>=newInterval[1])) {
                result.add(input);
            }else{
                otherList.add(input);
            }
        }
        result.add(newInterval);
        int[][] mergedList = merge(result.toArray(new int[result.size()][]));
        for(int[] mList:mergedList){
            otherList.add(mList);
        }
        otherList.sort((l1,l2)->Integer.compare(l1[0],l2[0]));
        return otherList.toArray(new int[otherList.size()][]);

    }

    public int[][] merge(int[][] intervals) {
        if (!(intervals.length > 0)) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<int[]>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (newInterval[1] >= interval[0]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
