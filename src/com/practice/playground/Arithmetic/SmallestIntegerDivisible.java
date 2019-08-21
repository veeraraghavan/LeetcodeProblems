package com.practice.playground.Arithmetic;

public class SmallestIntegerDivisible {
    public static void main(String[] args) {
        SmallestIntegerDivisible me = new SmallestIntegerDivisible();
        System.out.println(me.smallestRepunitDivByK(11));
    }

    public int smallestRepunitDivByK(int K) {
        int start = 1;
        int length = -1;
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        if (K == 1)
            return 1;
        while (start % K != 0) {
            start = (start % K) * 10 + 1;
            if (length == -1)
                length = 2;
            else
                length++;
        }
        return length;

    }
}
