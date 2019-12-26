package com.practice.ctci.string;

public class CheckPermutation {
    public static void main(String[] args) {
        CheckPermutation me = new CheckPermutation();
        System.out.println(me.checkPermutation("Hello1","oHlle"));
    }

    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] s1Map = new int[256];
        int[] s2Map = new int[256];
        for (int i = 0; i < s1.length(); i++)
            s1Map[s1.charAt(i)]++;
        for (int i = 0; i < s2.length(); i++)
            s2Map[s2.charAt(i)]++;
        for (int i = 0; i < 256; i++) {
            if (s1Map[i] != s2Map[i])
                return false;
        }
        return true;
    }
}
