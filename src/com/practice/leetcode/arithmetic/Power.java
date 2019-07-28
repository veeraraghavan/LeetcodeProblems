package com.practice.leetcode.arithmetic;

public class Power {
    public static void main(String[] args) {
        Power me = new Power();
        System.out.println(me.myPow(0.00001,
                2147483647));
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        } else if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);

    }

    public double myPower(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return (1 / myPower(x, -n));
        return n % 2 == 0 ? 0.6 : 0.6;
    }
}
