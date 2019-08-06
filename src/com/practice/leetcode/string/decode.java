package com.practice.leetcode.string;

import java.util.Stack;

public class decode {
    public static void main(String[] args) {
        decode me = new decode();
        System.out.println(me.decodeString("30[a]2[bc]"));
        System.out.println(me.decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        Stack<String> contentString = new Stack<>();
        String top = "";

        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            if (s.charAt(i) != ']') {
                contentString.push(s.charAt(i) + "");
            } else {
                while (!contentString.peek().equals("[")) {
                    top = contentString.pop();
                    temp = top + temp;
                }

                contentString.pop();
                int count2 = 0;
                String fact = "";
                while (!contentString.isEmpty() && Character.isDigit(contentString.peek().charAt(0))) {
                    fact = contentString.pop() + fact;
                }
                int count = Integer.parseInt(fact);
                String interResult = "";

                for (int j = 0; j < count; j++) {
                    interResult += temp;
                }
                contentString.push(interResult);
            }
        }
        String result = "";
        while (!contentString.isEmpty()) {
            String temp = "";
            temp = contentString.pop();
            result = temp + result;

        }
        return result;

    }
}
