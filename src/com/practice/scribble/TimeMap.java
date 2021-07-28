package com.practice.scribble;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
    public static void main(String[] args) {
        TimeMap me = new TimeMap();

    }
    /**
     * Initialize your data structure here.
     */
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        this.map.putIfAbsent(key, new TreeMap());
        this.map.get(key).put(timestamp, value);

    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> tree = map.get(key);
            Integer t = tree.floorKey(timestamp);
            return t == null ? "" : tree.get(t);
        }
        return "";
    }
}

