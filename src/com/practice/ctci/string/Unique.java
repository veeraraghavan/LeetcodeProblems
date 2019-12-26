package com.practice.ctci.string;

public class Unique {
    public static void main(String[] args) {
        Unique me = new Unique();
        System.out.println(me.isUnique(""));
        System.out.println(me.isUnique("H"));
        System.out.println(me.isUnique("Helol"));
        System.out.println(me.isUnique("Hello"));
    }
    // Time complexity - O(n^2) Space Complexity - O(1)
    public boolean isUnique(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
