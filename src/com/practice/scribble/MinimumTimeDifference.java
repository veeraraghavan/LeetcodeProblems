package com.practice.scribble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference {
    public static void main(String[] args) {
        MinimumTimeDifference me = new MinimumTimeDifference();
        System.out.println(me.findMinDifference(Arrays.asList(new String[]{"00:01", "01:01","02:00"})));
        System.out.println(me.findMinDifference(Arrays.asList(new String[]{"00:01", "23:59"})));

    }

    public int findMinDifference(List<String> timePoints) {
        int time = 1500;
        int[] tInMinutes = new int[timePoints.size()];
        for(int i=0;i<timePoints.size();i++){
            String[] temp = timePoints.get(i).split(";");
            tInMinutes[i] = Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
        }
        Arrays.sort(tInMinutes);
        for(int i=1;i<tInMinutes.length;i++){
            time = Math.min(tInMinutes[i]-tInMinutes[i-1],time);
        }

        time =  Math.min(time,1440-(tInMinutes[tInMinutes.length-1]-tInMinutes[0]));
        return time;


    }

}
