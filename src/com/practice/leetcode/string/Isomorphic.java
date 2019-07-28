package com.practice.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static void main(String[] args) {
        Isomorphic me = new Isomorphic();
        System.out.println(me.isIsomorphic("add", "egg"));
        System.out.println(me.isIsomorphic("ab", "aa"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> resultMap = new HashMap<>();
        Map<Character, Character> lookupMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //resultMap.get(s.charAt(i))
            if (lookupMap.containsKey(t.charAt(i))) {
                if (!(lookupMap.get(t.charAt(i)) == s.charAt(i))) {
                    return false;
                }
                //&& (lookupMap.get(t.charAt(i)) == s.charAt(i))
                // resultMap.put(s.charAt(i), t.charAt(i));
            } else {
                resultMap.put(s.charAt(i), t.charAt(i));
                lookupMap.put(t.charAt(i), s.charAt(i));
            }

        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += resultMap.get(s.charAt(i));
        }
        return (result.equals(t));
    }
}
