package com.practice.leetcode.misc;

public class FirstBadVersion {
    public static void main(String[] args) {
        FirstBadVersion me = new FirstBadVersion();
        System.out.println(me.firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while(l < h) {
            int m = l + (h-l)/2;
            if(isBadVersion(m)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;

    }

    public boolean isBadVersion(int n) {
        if (n >= 4 && n < 6) {
            return true;
        }
        return false;
    }
}
