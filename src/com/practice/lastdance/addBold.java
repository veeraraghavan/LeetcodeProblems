/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   2/3/22, 8:35 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class addBold {
  public static void main(String[] args) {
    addBold me = new addBold();
    System.out.println(me.addBoldTag("abcxyz123", new String[] {"abc", "123"}));
  }

  public String addBoldTag(String s, String[] words) {
    List<Interval> intervals = new ArrayList<>();
    List<Interval> result = new ArrayList();
    for (String word : words) {
      int start = getIndexOf(s, word);
      if (start != -1) intervals.add(new Interval(start, start + word.length()));
    }
    Collections.sort(intervals, (a, b) -> a.start - b.start);
    result.add(intervals.get(0));
    for (Interval interval : intervals) {
      Interval prev = result.get(result.size() - 1);
      if (prev.end >= (interval.start + 1)) {
        prev.end = Math.max(prev.end, interval.end);
      } else {
        result.add(interval);
      }
    }
    StringBuilder res = new StringBuilder();
    int index = 0;
    Interval current = result.get(index);
    boolean indexRemain = true;
    for (int i = 0; i < s.length(); i++) {
      if (i == current.start && indexRemain) {
        res.append("<b>");
      }
      if (i == current.end && indexRemain) {
        res.append("</b>");
        if (index < result.size()) {
          current = result.get(++index);

        } else {
          indexRemain = false;
        }
      }
      res.append(s.charAt(i));
    }
    if (current.end == s.length()) res.append("</b>");
    return res.toString();
  }

  public int getIndexOf(String s, String word) {
    return s.indexOf(word);
  }
}

class Interval {
  int start;
  int end;

  public Interval(int s, int e) {
    this.start = s;
    this.end = e;
  }
}
