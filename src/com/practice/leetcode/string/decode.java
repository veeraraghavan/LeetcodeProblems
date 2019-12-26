package com.practice.leetcode.string;

import java.util.Stack;

public class decode {
    public static void main(String[] args) {
        decode me = new decode();
        System.out.println(me.decodeString("30[a]2[bc]"));
        System.out.println(me.decodeString("3[a2[c]]"));
    }

    private String decodeString(String s) {
        Stack<String> contentString = new Stack<>();
        String top;
        String result = "";
        //Algorithm: Scan to the right until you find ].
        // Once found scan left until you find [
        // The text between this is the text 
        // Find its coefficient by traversing left 
        // Print the text coefficient number of times
        for (int i = 0; i < s.length(); i++) {
            String textToPrint = "";
            if (s.charAt(i) != ']') {
                contentString.push(s.charAt(i) + "");
            } else {
                while (!contentString.peek().equals("[")) {
                    top = contentString.pop();
                    textToPrint = top + textToPrint;
                }

                contentString.pop();
                StringBuilder coefficientText = new StringBuilder();
                while (!contentString.isEmpty() && Character.isDigit(contentString.peek().charAt(0)))
                    coefficientText.insert(0, contentString.pop());
                int coefficient = Integer.parseInt(coefficientText.toString());
                String interResult = "";
                for (int j = 0; j < coefficient; j++) {
                    interResult += textToPrint;
                }
                contentString.push(interResult);
            }
        }

        while (!contentString.isEmpty()) {
            String temp = "";
            temp = contentString.pop();
            result = temp + result;

        }
        //.bitCount()
        return result;

    }
}
