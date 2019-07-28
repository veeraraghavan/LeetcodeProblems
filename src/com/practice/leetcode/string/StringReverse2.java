package com.practice.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class StringReverse2 {
    public static void main(String[] args) {
        StringReverse2 me = new StringReverse2();
        System.out.println(me.reverseStr("abcdefg",2));
    }

    public String reverseStr(String s, int k) {
        String result ="";
        //List<String> temp = new ArrayList<>();
        int j=0;
        StringBuilder sb;
        for (int i = 0; i < s.length(); i += k) {
            if (i + k < s.length())
                sb = new StringBuilder(s.substring(i, i + k));
            else
                sb = new StringBuilder(s.substring(i));
            if(j%2==0)
                result+=sb.reverse();
            else
                result+=sb;
            j++;
//            if (i + k < s.length())
//                temp.add(s.substring(i, i + k));
//            else
//                temp.add(s.substring(i));
        }


//        for(int i=0;i<temp.size();i++){
//            if(i%2==0){
//                StringBuilder sb = new StringBuilder(temp.get(i));
//                result+=sb.reverse();
//            }else{
//                result+=temp.get(i);
//            }
//
//        }
        return result;
    }
}
