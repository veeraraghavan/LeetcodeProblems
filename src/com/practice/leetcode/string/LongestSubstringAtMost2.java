package com.practice.leetcode.string;

import java.util.HashMap;

public class LongestSubstringAtMost2 {
    public static void main(String[] args) {
        LongestSubstringAtMost2 me = new LongestSubstringAtMost2();
        System.out.println(me.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //Algorithm
        //Check if addition of
        //
        //
        int result = 0;
        int length = 0;
        HashMap<Character, Integer> map = new HashMap();
        int count = 0;
        //int[] visited = new int[256];

        // for(int i=0;i<visited.length;i++){
        //     visited[i]=-1;
        // }
        int left = 0, right = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right) )+ 1);
                right++;
                count = Math.max(right - left, count);
            } else {
                if (map.size() < 2) {
                    map.put(s.charAt(right), 1);
                    right++;
                } else {
                    if (map.get(s.charAt(left)) == 1) {
                        map.remove(s.charAt(left));
                    } else {
                        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    }
                    left++;
                }
            }

        }
        return count;

    }
}
