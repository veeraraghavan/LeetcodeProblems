package com.practice.leetcode.arithmetic;

public class SuperPower {
    public static void main(String[] args) {
        SuperPower me = new SuperPower();
        int a = 2;
        int[] b = {1,0,1};
        System.out.println(me.superPower(a,
                b));
    }

    public int superPower(int a, int[] b) {
        int k = 1337;
        a %= k;
        int result = 1;
        for (int i = 0; i < b.length; i++) {
            result = powMod(result, 10, k) * powMod(a, b[i], k) % k;
        }
        return result;
    }

    private int powMod(int a, int b, int k) {
        int result = 1;
        while (b != 0) {
            if (b % 2 != 0) result = result * a % k;
            a = a * a % k;
            b /= 2;
        }
        return result;
    }


}
