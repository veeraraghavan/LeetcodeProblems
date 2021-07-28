package com.practice.epi.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxConstructible {
  public static void main(String[] args) {
    MaxConstructible me = new MaxConstructible();
    System.out.println(me.MaxConstructable(Arrays.asList(new Integer[] {1, 2, 2, 2})));
  }

  private int MaxConstructable(List<Integer> numList) {
    int maxConstructable = 0;
    Collections.sort(numList);
    for (int num : numList) {
      if (num > maxConstructable + 1) {
        break;
      }
      maxConstructable += num;
    }
    return maxConstructable;
  }
}
