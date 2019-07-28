package com.practice.leetcode.string;

public class StringReversal {
    public static void main(String[] args) {


    }
    public void reverseString(char[] s) {
        char c = '1';
        for(int i=0;i<(s.length%2==0?s.length/2:(s.length-1)/2);i++){
            c = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-i-1] = c;
        }

    }

    public void reverseString2(char[] s) {
        char c = '1';
        for(int i=0;i<((s.length/2))-1;i++){
            c = s[s.length-1-i];
            s[s.length-1-i] = s[i];
            s[i] = c;
        }

    }



}
