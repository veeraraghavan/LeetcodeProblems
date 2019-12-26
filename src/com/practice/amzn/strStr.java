package com.practice.amzn;

import java.util.Collections;
import java.util.PriorityQueue;

public class strStr {
    public static void main(String[] args) {
        strStr me = new strStr();
        System.out.println(me.strStr("mississippi","issip"));
    }
    public int strStr(String haystack, String needle) {

        if(needle.length()==0)
            return 0;
        if(haystack.length()==0)
            return -1;
        if(haystack.length()<needle.length())
            return -1;
        int i=0,j=0;
        while(i<haystack.length()){
            while(i<haystack.length() && haystack.charAt(i)!=needle.charAt(j))i++;
            if(i==haystack.length())break;
            while(i<haystack.length()&&j<needle.length() && haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            //Collections.reverseOrder()
            if(j==needle.length())
                return i-j;
            int temp = i-j+1;
            while(temp<j && haystack.charAt(temp)!=needle.charAt(0))temp++;
            i=temp;
            j=0;
        }
        return -1;

    }
}
