package com.practice.amzn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String temp = String.valueOf(ch);
            if (!result.containsKey(temp))
                result.put(temp, new ArrayList<>());
            result.get(temp).add(str);
        }
        return new ArrayList(result.values());
    }
}
