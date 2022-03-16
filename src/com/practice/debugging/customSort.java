/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   2/4/22, 11:07 PM
 * =========================================
 */

package com.practice.debugging;

import java.util.Arrays;
import java.util.HashMap;

public class customSort {
  public static void main(String[] args) {
    customSort me = new customSort();
  }

  public String rankTeams(String[] votes) {

    HashMap<Character, Integer> charToIndex = new HashMap();
    int rows = votes[0].length();
    int[][] ranks = new int[rows][rows];
    char[] result = votes[0].toCharArray();
    Character[] temp = new Character[result.length];

    for (int i = 0; i < temp.length; i++) {
      temp[i] = result[i];
    }
    int index = 0;
    for (char c : result) {
      charToIndex.put(c, index++);
    }
    for (int i = 0; i < votes.length; i++) {
      for (int j = 0; j < rows; j++) {
        int rowNo = charToIndex.get(votes[i].charAt(j));
        ranks[rowNo][j]++;
      }
    }

    Arrays.sort(
        temp,
        (a, b) -> {
          int aRow = charToIndex.get(a);
          int bRow = charToIndex.get(b);
          int comparison = compare(ranks[aRow], ranks[bRow]);
          if (comparison != 0) {
            return comparison;
          }
          return a - b;
        });

    for (int i = 0; i < temp.length; i++) {
      result[i] = temp[i];
    }

    return String.valueOf(result);
  }

  public int compare(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] > b[i]) {
        return -1;
      } else if (a[i] < b[i]) {
        return 1;
      }
    }
    return 0;
  }
}
