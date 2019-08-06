package com.practice.leetcode.string;

public class Decode2 {
    public static void main(String[] args) {
        Decode2 me = new Decode2();
        System.out.println(me.decodeAtIndex("leet2code3", 10));
        System.out.println(me.decodeAtIndex("ha22", 5));
        System.out.println(me.decodeAtIndex("a2345678999999999999999", 1));
    }

    public String decodeAtIndex(String S, int K) {
        if (S.length() == 0 || K == 0)
            return "";
        String result = "";
        int i = 0;
        while (i < S.length() && result.length() <= K) {
            if (Character.isDigit(S.charAt(i))) {
                String count = "";
                int counter = 0;
                while (i < S.length() && Character.isDigit(S.charAt(i))) {
                    counter++;
                    count += S.charAt(i++);

                }
                i += counter - 2;
                String temp = result;

                for (long j = 0; j < Long.parseLong(count) - 2 && result.length() < S.length(); j++) {
                    temp += result;

                }
                result = result + temp;
            } else {
                result += Character.toString(S.charAt(i));
            }
            i++;

        }
        return result.charAt(K - 1) + "";
    }
}
