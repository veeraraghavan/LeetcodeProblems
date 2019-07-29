package com.practice.leetcode.misc;

public class WaterJug {
    public static void main(String[] args) {
        WaterJug me = new WaterJug();
        System.out.println(me.canMeasureWater(3, 5, 4));
        System.out.println(me.canMeasureWater(2, 6, 5));
    }

    public boolean canMeasureWater(int x, int y, int z) {

        return z == 0 || (z <= x + y && z % gcd(x, y) == 0);
    }

    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a > b) {
            return gcd(b, a % b);
        } else {
            return gcd(a, b % a);
        }

    }
}
