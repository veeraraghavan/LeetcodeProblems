package com.practice.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;

public class Scheduler {
    public static void main(String[] args) {
        Scheduler me = new Scheduler();
        Character[] input = {'A','A','A','B','B','B'};
        System.out.println(me.leastInterval(input,2));
    }
    public int leastInterval(Character[] tasks,int n){
        int[] queue = new int[26];
        for(Character c:tasks){
            if(queue[c-'A']>0)
                queue[c-'A']++;
            else
                queue[c-'A'] = 1;
        }
        Arrays.sort(queue);
        int time=0;
        int i=0;
        while(queue[25]>0){
            i=0;
            while(i<=n){
                if(queue[25]==0)
                    break;
                if(i<26 && queue[25-i]>0)
                    queue[25-i]--;
                time++;
                i++;
            }
            Arrays.sort(queue);
        }


        return time;
    }
}
