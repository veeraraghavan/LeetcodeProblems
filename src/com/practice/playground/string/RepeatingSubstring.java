package com.practice.playground.string;

import java.util.HashMap;
import java.util.Map;

public class RepeatingSubstring {
    public static void main(String[] args) {
        RepeatingSubstring me = new RepeatingSubstring();
        System.out.println(me.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(me.lengthOfLongestSubstring("dddd"));
        System.out.println(me.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        if (s.length() == 0)
            return 0;
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if ((s.length() - i) > result) {
                Map<Character, Integer> characterMap = new HashMap<>();
                characterMap.put(s.charAt(i), 1);
                for (int j = i + 1; j < s.length(); j++) {
                    if (characterMap.containsKey(s.charAt(j))) {
                        break;
                    } else {
                        characterMap.put(s.charAt(j), 1);
                    }


                }
                if (characterMap.size() > result)
                    result = characterMap.size();

            }

        }
        return result;
    }
}
