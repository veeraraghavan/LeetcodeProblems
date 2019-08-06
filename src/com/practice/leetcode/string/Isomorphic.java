package com.practice.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static void main(String[] args) {
        Isomorphic me = new Isomorphic();
        System.out.println(me.isIsomorphic("add", "egg"));
        System.out.println(me.isIsomorphic("ab", "dd"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> resultMap = new HashMap<>();
        Map<Character, Character> lookupMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (resultMap.containsKey(s.charAt(i))) {
                if (resultMap.containsValue(t.charAt(i))) {
                    return false;
                }
            } else {
                resultMap.put(s.charAt(i), t.charAt(i));
            }
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += resultMap.get(s.charAt(i));
        }
        return (result.equals(t));
    }
}
