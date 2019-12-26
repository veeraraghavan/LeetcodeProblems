package com.practice.amzn;

import java.util.HashMap;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
    }

    public int firstUniqChar(String s) {
        //HashMap<Character,Integer> charCount = new HashMap<>();
        int[] charCount = new int[26];
        for(char c:s.toCharArray()){

            charCount[c-'a']++;
        }
        int i=0;
        for(char c:s.toCharArray()){
            if(charCount[c-'a']==1)
                return i;
            i++;
        }
        return -1;
    }
}
