package com.practice.leetcode.string;

public class Monotone {
    public static void main(String[] args) {
        Monotone me = new Monotone();
        System.out.println(me.monotoneIncreasingDigits(332));
    }

    public int monotoneIncreasingDigits(int N) {
        int temp = N;
        while (temp >= 0) {
            if (isMonotone(temp)) {
                return temp;
            }
            temp -= 1;
        }
        return 0;
    }

    public boolean isMonotone(int n) {
        String s = Integer.toString(n);
        boolean isMonotone = true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return !isMonotone;
            }

        }
        return isMonotone;
    }
}
