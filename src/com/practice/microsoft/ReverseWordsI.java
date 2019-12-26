package com.practice.microsoft;

public class ReverseWordsI {
    public static void main(String[] args) {
        ReverseWordsI me = new ReverseWordsI();
        System.out.println(me.reverseWords("the sky is blue"));
        System.out.println(me.reverseWords("  hello world!  "));
        System.out.println(me.reverseWords("a good   example"));
    }

    public String reverseWords1(String s1) {
        //Have two while loops
        // One to run till end of string
        // Two to run till end of word
        String s = s1.trim();
        int index = 0;
        String result = "";
        while (index < s.length()) {
            String temp = "";
            while (index < s.length() && s.charAt(index) != ' ') {
                temp = temp + s.charAt(index);
                index++;
            }
            result = temp + result;
            while (index < s.length() && s.charAt(index) == ' ') {
                index++;
            }
            if (index != s.length())
                result = " " + result;
        }
        return result;
    }

    public String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        boolean isSpace = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (isSpace) {
                    if (sb.length() > 0) {
                        res.insert(0, " " + sb.toString());
                    }
                    sb = new StringBuilder();
                    sb.append(c);
                    isSpace = false;
                } else {
                    sb.append(c);
                }
            } else {
                isSpace = true;
            }
        }
        res.insert(0, sb.toString());
        return res.toString();
    }

    //Always use string builder when dealing with Strings
    public String reverseWords(String s) {
        int end = s.length() - 1;
        StringBuilder result = new StringBuilder();
        while (end >= 0) {
            if (s.charAt(end) == ' ') {
                end--;
                continue;
            }
            int start = s.lastIndexOf(' ', end);
            result = result.append(s.substring(start + 1, end + 1)).append(" ");
            end = start - 1;
        }
        return result.length() == 0 ? result.toString() : result.substring(0, result.length() - 1);
    }

    public void reverseWords(char[] s) {
        s = reverseWords(s.toString()).toCharArray();


    }
}
