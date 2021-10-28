/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/27/21, 4:54 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class WordDictionary {
  WordTrie trie;

  public WordDictionary() {
    trie = new WordTrie();
    trie.word = false;
    // trie.neighbors = new HashMap<>();
  }

  public static void main(String[] args) {
    WordDictionary me = new WordDictionary();
    me.addWord("a");
    me.search(".a");
  }

  public void addWord(String word) {
    WordTrie node = trie;
    for (char ch : word.toCharArray()) {
      if (!node.neighbors.containsKey(ch)) {
        node.neighbors.put(ch, new WordTrie());
      }
      node = node.neighbors.get(ch);
      // node.c = ch;
    }
    node.word = true;
  }

  public boolean search(String word) {
    return searchInNode(word, trie);
  }

  public boolean searchInNode(String word, WordTrie node) {
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.neighbors.containsKey(ch)) {
        if (ch == '.') {
          for (char key : node.neighbors.keySet()) {
            WordTrie child = node.neighbors.get(key);
            if (searchInNode(word.substring(i + 1), child)) {
              return true;
            }
          }
        }

        return false;

      } else {
        node = node.neighbors.get(ch);
      }
    }
    return node.word;
  }
}

class WordTrie {
  // public Character c;
  public boolean word;
  public HashMap<Character, WordTrie> neighbors;

  public WordTrie() {
    neighbors = new HashMap<>();
  }
  // public WordTrie()
}
