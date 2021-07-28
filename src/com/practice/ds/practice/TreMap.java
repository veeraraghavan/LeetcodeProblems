package com.practice.ds.practice;

import java.util.TreeMap;

public class TreMap {
    public static void main(String[] args) {
        TreMap me = new TreMap();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(1,2);
        map.put(1,3);
        map.put(2,2);
        map.put(2,3);
        map.put(3,5);
        map.put(5,5);
        int result = 0;

        System.out.println(me.Calculate(map));

    }
    private int result = 0;
    public int Calculate(TreeMap<Integer,Integer> map){
        map.tailMap(1,false).forEach((Key,Value)->{
            result +=Value;
        });
        return this.result;
    }
}
