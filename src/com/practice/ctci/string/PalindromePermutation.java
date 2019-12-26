package com.practice.ctci.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutation me = new PalindromePermutation();
        System.out.println(me.canPermutePalindrome("malyaalam"));
    }

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        int odd = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() % 2 != 0)
                odd++;
        }
        if (odd > 1)
            return false;
        return true;
    }
}
