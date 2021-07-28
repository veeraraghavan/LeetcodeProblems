/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   5/15/21, 8:12 PM
 * =========================================
 */

package com.practice.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DNASequence {
  public static void main(String[] args) {
    DNASequence me = new DNASequence();
    // me.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    me.findRepeatedDnaSequences("AAAAAAAAAAA");
  }

  private List<String> findRepeatedDnaSequences(String s) {

    if (s.length() < 10) {
      return null;
    }

    // possible values of DNA sequence A,C,G,T => 4 and can be be encoded with 0,1,2,3
    HashMap<Character, Integer> map =
        new HashMap() {
          {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
          }
        };
    int uniqueElements = 4;
    int subSequenceLength = 10;
    int length = s.length();
    int maxValue = (int) Math.pow(uniqueElements, subSequenceLength);
    // placeholder for 10 letter sequences
    char[] letter = new char[length];
    for (int i = 0; i < length; i++) {
      letter[i] = s.charAt(i);
    }

    HashSet<Integer> seen = new HashSet();
    HashSet<String> result = new HashSet();
    int h = 0;
    for (int start = 0; start <= length - subSequenceLength; start++) {
      if (start != 0) {
        // substract the leftmost part
        h =
            (h - (int) Math.pow(4, subSequenceLength - 1) * map.get(letter[start - 1])) * 4
                + map.get(letter[subSequenceLength + start - 1]);

      } else {
        for (int i = 0; i < subSequenceLength; i++) {
          h = (int) Math.pow(4, i) * map.get(letter[subSequenceLength - i - 1]) + h;
        }
      }
      if (seen.contains(h)) {
        result.add(s.substring(start, start + subSequenceLength));
      } else {
        seen.add(h);
      }
    }
    return new ArrayList<String>(result);
  }
}
