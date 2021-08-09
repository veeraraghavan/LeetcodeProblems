/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/8/21, 10:03 PM
 * =========================================
 */

package com.practice.serious;

import java.util.*;

public class AlienLanguage {
  public static void main(String[] args) {
    AlienLanguage me = new AlienLanguage();
    System.out.println(me.alienOrder(new String[] {"abc", "ab"}));
  }

  private String alienOrder(String[] words) {
    HashMap<Character, List<Character>> adjList = new HashMap<>();
    HashMap<Character, Integer> incomingEdge = new HashMap<>();
    String[] wordSet = words; // sanitizeWords(words);
    // initalize the adjList
    for (String word : wordSet) {
      for (char c : word.toCharArray()) {
        adjList.put(c, new ArrayList<>());
        incomingEdge.put(c, 0);
      }
    }
    // Fill the lists
    for (int i = 0; i < wordSet.length - 1; i++) {
      String w1 = wordSet[i];
      String w2 = wordSet[i + 1];
      if (w1.length() > w2.length() && w1.startsWith(w2)) {
        return "";
      }
      for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
        char parent = w1.charAt(j);
        char child = w2.charAt(j);
        if (parent != child) {
          adjList.get(parent).add(child);
          incomingEdge.put(child, incomingEdge.get(child) + 1);
          break;
        }
      }
    }

    // Now get the nodes without incoming edge
    Queue<Character> sourceNodes = new LinkedList<>();
    for (Map.Entry<Character, Integer> entry : incomingEdge.entrySet()) {
      if (entry.getValue() == 0) {
        sourceNodes.add(entry.getKey());
      }
    }

    String res = "";
    // Now traverse the nodes
    while (!sourceNodes.isEmpty()) {
      Character next = sourceNodes.poll();
      res = res + next;
      List<Character> children = adjList.get(next);
      for (Character child : children) {
        incomingEdge.put(child, incomingEdge.get(child) - 1);
        if (incomingEdge.get(child) == 0) {
          sourceNodes.add(child);
        }
      }
    }
    if (res.length() != adjList.size()) return "";
    return res;
  }

  private String[] sanitizeWords(String[] words) {
    String[] result = new String[words.length];
    int index = 0;
    for (String word : words) {
      char prev = word.charAt(0);
      String newWord = "" + prev;
      for (int i = 1; i < word.length(); i++) {
        if (prev != word.charAt(i)) {
          newWord += word.charAt(i);
          prev = word.charAt(i);
        }
      }
      result[index++] = newWord;
    }
    return result;
  }
}
