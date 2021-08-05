/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/3/21, 11:08 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequent {
  public static void main(String[] args) {
    TopKFrequent me = new TopKFrequent();
    me.topKFrequentTrie(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2);
  }

  private List<String> topKFrequent(String[] words, int k) {
    List<String> result = new ArrayList<>();
    HashMap<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      int count = wordCount.getOrDefault(word, 0);
      wordCount.put(word, count + 1);
    }
    PriorityQueue<String> frequentList =
        new PriorityQueue<String>(
            (a, b) -> {
              int countA = wordCount.get(a);
              int countB = wordCount.get(b);
              if (countA == countB) {
                return a.compareTo(b);
              } else {
                return countB - countA;
              }
            });

    for (String word : wordCount.keySet()) {
      frequentList.add(word);
    }
    while (k > 0) {
      result.add(frequentList.poll());
      k--;
    }
    return result;
  }

  private class Trie {

    private int count;
    private int low;
    private int high;
    private String s;
    private Trie[] children;

    Trie() {}

    int insert(String s, int level) {
      if (s.length() == level) {
        if (count == 0) {
          this.s = s;
        }
        count++;
        return count;
      }

      int index = s.charAt(level) - 'a';

      if (children == null) {
        children = new Trie[26];
        low = high = index;
      }

      if (children[index] == null) {
        children[index] = new Trie();
        if (index < low) {
          low = index;
        } else if (index > high) {
          high = index;
        }
      }
      return children[index].insert(s, level + 1);
    }

    void traverse() {
      if (children != null) {
        for (int i = high; i >= low; i--) {
          if (children[i] != null) {
            children[i].traverse();
          }
        }
      }
      if (count > 0) {
        ListTrie listTrie = new ListTrie(this);
        listTrie.next = listTries[count];
        listTries[count] = listTrie;
      }
    }
  }

  private class ListTrie {

    private Trie trie;
    private ListTrie next;

    ListTrie(Trie trie) {
      this.trie = trie;
    }
  }

  private ListTrie[] listTries;

  private List<String> topKFrequentTrie(String[] words, int k) {
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0 || k <= 0) {
      return result;
    }

    int max = 0;
    Trie root = new Trie();

    for (String word : words) {
      int count = root.insert(word, 0);
      if (count > max) {
        max = count;
      }
    }

    listTries = new ListTrie[max + 1];
    root.traverse();

    for (int i = max; i >= 0 && k > 0; i--) {
      ListTrie listTrie = listTries[i];
      while (listTrie != null && k > 0) {
        result.add(listTrie.trie.s);
        listTrie = listTrie.next;
        k--;
      }
    }

    return result;
  }
}
