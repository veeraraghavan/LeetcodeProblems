package com.practice.ctci.string;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance me = new EditDistance();
        System.out.println(me.oneEditDistance("Hello","Helz"));
    }

    public boolean oneEditDistance(String s1, String s2) {
        int count = 0;
        int m = s1.length(), n = s2.length(), i = 0, j = 0;
        if (Math.abs(m - n) >= 2)
            return false;
        while (i < m && j < n) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1)
                    return false;// because there is already one difference immediately return
                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else {
                    i++;
                    j++;

                }
                count++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
