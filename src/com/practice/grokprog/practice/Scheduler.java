package com.practice.grokprog.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Scheduler {
  public static void main(String[] args) {
    Scheduler me = new Scheduler();
  }

  public int schedule(char[] tasks, int n) {
    int counter = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : tasks) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    queue.addAll(map.values());
    while (!queue.isEmpty()) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        if (!queue.isEmpty()) list.add(queue.remove());
      }
      for (int i : list) {
        if (--i > 0) queue.add(i);
      }
      counter += list.size() == n ? n : list.size();
    }
    return counter;
  }

  public int schedule2(char[] tasks, int n) {
    int counter = 0;
    int[] count = new int[26];
    for (char c : tasks) {
      count[c - 'a']++;
    }
    Arrays.sort(count);
    while (count[25] > 0) {
      int i = n;
      while (i >= 0) {
        if (count[25] == 0) break; // Break immediately and start processing the next highest first
        if (count[25 - i] > 0) {
          count[25 - i]--;
        }
        i--;
        counter++;
      }
      Arrays.sort(count);
    }

    return counter;
  }
}
