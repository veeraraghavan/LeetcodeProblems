package com.practice.epi.bitwise;

public class Bitwise {
  public static void main(String[] args) {
    Bitwise me = new Bitwise();
    System.out.println(me.countBits(7));
    System.out.println(me.parity(3));
  }

  private int countBits(int n) {
    // >>> shifts a 0 in most significant bit, >> retains the sign
    int numBits = 0;
    while (n != 0) {
      numBits += (n & 1);
      n >>>= 1;
    }
    return numBits;
  }

  private int parity(int x) {
    int result = 0;
    while (x != 0) {
      result ^= (x & 1);
      x = x >>> 1;
    }
    return result;
  }

  public int parityLarge(int x) {
    int result = 0;
    int[] lookup = new int[256];
    lookup[0] = 0;
    for (int i = 1; i < 256; i++) {
      lookup[i] = (i & 1) + lookup[i / 2];
    }
    result =
        lookup[x >>> 24 & 0xff]
            + lookup[x >>> 16 & 0xff]
            + lookup[x >>> 8 & 0xff]
            + lookup[x & 0xff];
    return result;
  }
}
