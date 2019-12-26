package com.practice.microsoft;

public class ReverseWords2 {
    public static void main(String[] args) {
        ReverseWords2 me = new ReverseWords2();
        me.reverseWords(new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
        System.out.println();
    }
    public void reverseWords(char[] s) {
        reverseWords(s.toString());
        String result = reverseWords(new String(s));
        for(int i=0;i<s.length;i++){
            s[i]=result.charAt(i);
        }
    }
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
}
