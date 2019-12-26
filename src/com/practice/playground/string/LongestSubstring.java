package com.practice.playground.string;

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring me = new LongestSubstring();
        System.out.println(me.longestPalindrome("ab"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        if (s=="")
            return "";
        int beginIndex = 0, endIndex = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--)
                if (j >= s.length()) {
                    if (isPalindrome(s.substring(i)))
                        if (length < (j - i)) {
                            length = j - i;
                            beginIndex = i;
                            endIndex = j;
                        }
                } else {
                    if (isPalindrome(s.substring(i, j + 1)))
                        if (length < (j - i)) {
                            length = j - i;
                            beginIndex = i;
                            endIndex = j;
                        }
                }


        }
        return endIndex-beginIndex==0?s.substring(0,1):s.substring(beginIndex, endIndex + 1);

    }

    public String longestPalindrome2(String s) {
        String result = "";

        for(int i=0;i<s.length();i++){
            boolean end =false;
            int length=0;
            int index=i;
            while(!end){
                if(index==0)
                    result=s.substring(index,1);
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        boolean result = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return result;
    }
}
