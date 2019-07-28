package com.practice.leetcode.string;

public class atoi {
    public static void main(String[] args) {
        atoi me = new atoi();
        System.out.println(me.myAtoi("words and 987"));
        System.out.println(me.myAtoi("4193 with words"));
        System.out.println(me.myAtoi("   -42"));
        System.out.println(me.myAtoi("42"));
        System.out.println(me.myAtoi("-91283472332"));
        System.out.println(me.myAtoi("3.14"));
        System.out.println(me.myAtoi("+-343"));
        System.out.println(me.myAtoi("   +0 123"));
    }

    public int myAtoi(String str) {
        Long result = 0L;
        int multiple = 1;
        boolean eval = false;
        Long intermeditate = 0L;
        for (int i = 0; i < str.length(); i++) {
            if (!eval&&Character.isSpaceChar(str.charAt(i))) {
                continue;
            } else if (str.charAt(i) == '+') {
                if (result == 0 && !eval) {
                    eval = true;
                    multiple = 1;
                } else {
                    return (int) (result * multiple);
                }

            } else if (str.charAt(i) == '-') {
                if (result == 0 && !eval) {
                    eval = true;
                    multiple = -1;
                } else {
                    return (int) (result * multiple);
                }
            } else if (Character.isDigit(str.charAt(i))) {
                eval=true;
                if (((multiple) * (result * 10 + Integer.parseInt(Character.toString(str.charAt(i))))) > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if ((multiple) * ((result * 10 + Integer.parseInt(Character.toString(str.charAt(i))))) < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else {
                    result = result * 10 + Integer.parseInt(Character.toString(str.charAt(i)));
                }


            } else {
                return (int) (result * multiple);

            }
        }

        return (int) (result * multiple);
    }
}
