package com.practice.grokprog.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
  public static void main(String[] args) {
    ReorganizeString me = new ReorganizeString();
    me.reorganizeString("vvvlo");
  }

  private String reorganizeString(String S) {
    int N = S.length();
    String result = "";
    char[] ans = new char[N];
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (char c : S.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    char first = '0';
    char second = '0';
    PriorityQueue<Character> pq = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
    pq.addAll(map.keySet());
    if (map.get(pq.peek()) > (N + 1) / 2) return "";
    while (pq.size() > 2) {
      if (!pq.isEmpty()) {
        first = pq.poll();
        result += first;
      }
      if (!pq.isEmpty()) {
        second = pq.poll();
        result += second;
      }
      if (map.get(first) > 1) {
        map.put(first, map.get(first) - 1);
        pq.add(first);
      }
      if (map.get(second) > 1) {
        map.put(second, map.get(second) - 1);
        pq.add(second);
      }
    }
    return result;
  }
}
