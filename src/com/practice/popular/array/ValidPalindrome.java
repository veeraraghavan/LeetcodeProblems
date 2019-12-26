package com.practice.popular.array;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome me = new ValidPalindrome();
        System.out.println(me.isPalindrome("race a car"));
    }
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))){
                j--;
                continue;
            }
            if(String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;

    }
}
