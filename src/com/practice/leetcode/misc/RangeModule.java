package com.practice.leetcode.misc;

import java.util.HashMap;
import java.util.Map;

public class RangeModule {
    public static void main(String[] args) {

//["RangeModule","addRange","removeRange","removeRange","addRange","removeRange","addRange","queryRange","queryRange","queryRange"]
//[[],[6,8],[7,8],[8,9],[8,9],[1,3],[1,8],[2,4],[2,9],[4,6]]
        RangeModule me = new RangeModule();
        me.addRange(6, 8);
        me.removeRange(7,8);
        me.removeRange(8,9);
        me.addRange(8,9);
        me.removeRange(1,3);
        me.addRange(1,8);
        me.queryRange(2,4);
        me.queryRange(2,9);
        me.queryRange(4,6);

    }

    ;
    Map<Integer, Boolean> map;

    public RangeModule() {
        map = new HashMap<>();

    }

    public void addRange(int left, int right) {
        for (int i = left; i < right; i++) {
            map.put(i,true);
        }

    }

    public boolean queryRange(int left, int right) {
        try {


            for (int i = left; i < right; i++) {
                if (!map.get(i)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void removeRange(int left, int right) {

        for (int i = left; i < right; i++) {
            if (map.containsKey(i)) {
                map.put(i, false);
            }
        }
    }
}
