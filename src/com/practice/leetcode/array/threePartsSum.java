package com.practice.leetcode.array;

public class threePartsSum {
  public static void main(String[] args) {
    threePartsSum me = new threePartsSum();
    // int[] input = {10, -10, 10, 10, 10, 10, -10};
    int[] input = {1, 2, 3, 4, 5};
    System.out.println(me.canThreePartsEqualSum(input));
  }

  private boolean canThreePartsEqualSum(int[] A) {
    int sum = 0, part = 0, cnt = 0;
    for (int a : A) {
      sum += a;
    }
    int avg = 0;
    if (sum % 3 == 0) {
      avg = sum / 3;
    } else {
      return false;
    }
    for (int a : A) {
      part += a;
      if (part == avg) {
        if (++cnt == 2) return true;
      } else {
        continue;
      }
      part = 0;
    }
    return false;
  }
}
