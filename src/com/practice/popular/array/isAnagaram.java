package com.practice.popular.array;

import java.util.Arrays;

public class isAnagaram {
    public static void main(String[] args) {
        isAnagaram me = new isAnagaram();
        System.out.println(me.isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        // if(sChar.toString().equals(tChar.toString())==0){
        //     return true;
        // }

        return String.valueOf(sChar).equals(String.valueOf(tChar));

    }
}
