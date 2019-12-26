package com.practice.microsoft;

import java.util.regex.Pattern;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome me = new ValidPalindrome();
        System.out.println(me.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        s = p.matcher(s).replaceAll("");
        if (s.length() == 0 || s.length() == 1)
            return true;
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)))
                return false;
            else {
                low++;
                high--;
            }
        }
        return true;
    }

    //using recursion
    // Use Regex to eliminate non Alpha Numeric characters
    // Fails with TLE
    // Time complexity n
    // Space complexity n
    public boolean isPalindrome1(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        if (s.length() == 1 || s.length() == 0)
            return true;
        if (Character.toLowerCase(s.charAt(0)) != Character.toLowerCase(s.charAt(s.length() - 1)))
            return false;
        else
            return isPalindrome(s.substring(1, s.length() - 1));
    }
}
