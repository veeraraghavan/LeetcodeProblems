package com.practice.india;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarityII {

  private int[] root;
  private int[] rank;

  public static void main(String[] args) {

    String[] words1 = new String[] {"great", "acting", "skills"};
    String[] words2 = new String[] {"fine", "drama", "talent"};
    String[][] wordList =
        new String[][] {
          {"great", "good"}, {"fine", "good"}, {"drama", "acting"}, {"skills", "talent"}
        };
    List<List<String>> words = new ArrayList<>();
    for (String[] wordgrp : wordList) {
      words.add(Arrays.asList(wordgrp));
    }
    SentenceSimilarityII me = new SentenceSimilarityII();
    System.out.println(me.areSentencesSimilarTwo(words1, words2, words));
  }

  private boolean areSentencesSimilarTwo(
      String[] words1, String[] words2, List<List<String>> pairs) {
    int capacity = pairs.size() * 2;
    root = new int[capacity];
    rank = new int[capacity];
    for (int i = 0; i < capacity; i++) {
      root[i] = i;
    }
    if (words1.length != words2.length) return false;
    Map<String, Integer> index = new HashMap<>();
    for (int i = 0; i < pairs.size(); i++) {
      List<String> pair = pairs.get(i);
      int a = index.getOrDefault(pair.get(0), -1);
      int b = index.getOrDefault(pair.get(1), -1);
      if (a == -1) index.put(pair.get(0), a = 2 * i);
      if (b == -1) index.put(pair.get(1), b = 2 * i + 1);
      union(a, b);
    }
    for (int i = 0; i < words1.length; i++) {
      if (!words1[i].equals(words2[i])) {
        int a = index.getOrDefault(words1[i], -1);
        int b = index.getOrDefault(words2[i], -1);
        if (a == -1 || b == -1 || find(a) != find(b)) {
          return false;
        }
      }
    }

    return true;
  }

  private void union(int ai, int bi) {
    int pa = find(ai);
    int pb = find(bi);
    if (pa == pb) {
      return;
    }
    //    if (rank[pa] == rank[pb]) {
    //      root[pb] = root[pa];
    //      rank[pb]++;
    //    } else if (rank[pa] > rank[pb]) {
    //      root[pb] = root[pa];
    //      rank[pb]++;
    //    } else {
    //      root[pa] = root[pb];
    //      rank[pb]++;
    //    }
    root[pb] = root[pa];
  }

  public int find(int wi) {
    int parent = root[wi];
    if (parent != wi) {
      root[wi] = find(root[wi]);
      parent = root[wi];
    }
    return parent;
  }
}
