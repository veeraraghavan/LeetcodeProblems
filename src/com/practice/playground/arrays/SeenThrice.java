package com.practice.playground.arrays;

public class SeenThrice {
    public static void main(String[] args) {
        SeenThrice me = new SeenThrice();
        System.out.println(me.singleNumber(new int[]{10,1,10,1,10,1,99}));
    }
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
          seenOnce = ~seenTwice & (seenOnce ^ num);
          seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }
}
